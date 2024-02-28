package com.bitc.common.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

/**
 * 파일 관련 요청에 대한 처리를 도와줄 class
 * upload, download, delete
 */
public class FileUtil {
	
	/**
	 * 날짜 별 디렉토리에 파일을 업로드 한 후
	 * 업로드된 디렉토리와 파일 이름을 문자열로 반환
	 */
	public static String uploadFile(String realPath,    // upload 파일 저장 root 경로 
									MultipartFile file  // upload할 파일 정보
									) throws Exception{
		String uploadedFileName = "";
		// 동일 디렉토리에 동일한 이름의 파일 중복 최소화
		UUID uuid = UUID.randomUUID();
		String savedName = uuid.toString().replace("-", "");
		String originalName = file.getOriginalFilename();
		// 원본 파일 이름에 _가 있으면 파일이름과 uuid를 구분하기 위하여 공백으로 치환
		savedName += "_"+(originalName.replace("_", " "));
		System.out.println(savedName);
		
		// url 요청으로 전달된 파일 이름은 공백이 자동으로 + 로 치환
		savedName = savedName.replace("+", " ");
		// 날짜별 디렉토리 경로
		String datePath = calcPath(realPath);
		
		// 지정된 경로에 원본 파일 저장
		File f = new File(realPath+datePath, savedName);
		file.transferTo(f);
		
		// 업로드된 파일의 파일 확장자명 획득
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		// 파일 확장자 명을 가지고 이미지 파일인지 일반 파일인지 구분
		if(MediaUtil.getMediaType(formatName) != null) {
			// 이미지 일 경우에는 썸네일 이미지 생성 저장 및 경로 반환
			uploadedFileName = makeThumbnail(realPath, datePath, savedName, formatName);
		}else {
			// 일반 파일일 경우 저장된 디렉토리 구분자만 URL 계층 구분자로 변경하여 반환
			String fileName = datePath+File.separator+savedName;
			System.out.println(fileName);
			uploadedFileName = fileName.replace(File.separatorChar, '/');
		}
		
		return uploadedFileName;
	}
	
	/**
	 * 이미지 일경우 썸네일 이미지 생성 및 저장된 경로를 문자열로 반환
	 */
	public static String makeThumbnail(
			String realPath,  // upload folder root 경로
			String datePath,  // 년월일 경로
			String savedName, // upload된 원본 파일 이름
			String ext 		  // upload된 파일 확장자 명
			) throws Exception{
		String name = "";
		// 원본 이미지 정보
		File file = new File(realPath+datePath,savedName);
		// ImageScalr는 BufferedImage 타입으로 이미지를 제어
		// ImageIO class는 javax package에서 Image타입의 파일을 쉽게 메모리로 읽거나
		// 메모리의 파일 정보를 물리 파일로 write하는 method를 제공하는 class이다.
		BufferedImage originalImage = ImageIO.read(file); 
		
		// scalr 객체를 이용해서 원본이미지를 복제한 Thmbnail 이미지 생성
		BufferedImage sourceImage = Scalr.resize(
											originalImage, 				// 복제할 원본 이미지 
											Scalr.Method.AUTOMATIC, 	// 이미지 비율 지정
											Scalr.Mode.FIT_TO_HEIGHT,	// 고정 높이
											100							// FIT 크기
									);
		// 원본 파일과 thumbnail 이미지를 구분하기 위하여 
		// 파일 이름 앞에 s_ 추가
		String thumbnailImage = realPath+datePath+File.separator+"s_"+savedName;
		// ImageIO.write(출력할 이미지 데이터, 파일 확장자, 출력 위치);
		ImageIO.write(sourceImage, ext, new File(thumbnailImage));
		// 메모리에 생성된 thumbnail 이미지를 디스크에 생성
		
		// URL 계층 형식의 경로로 변경하여 섬네일 이미지 경로 문자열로 반환
		name = thumbnailImage.substring(realPath.length()).replace(File.separatorChar, '/');
		return name;
	}
	
	
	/**
	 * /yyyy/MM/dd 형식의 요청 날짜별 디렉토리 생성
	 */ 
	public static String calcPath(String realPath) {
		String pattern =  File.separator+"yyyy"+File.separator+"MM"+File.separator+"dd";
		LocalDate date = LocalDate.now();
		String datePath = date.format(
			DateTimeFormatter.ofPattern(pattern)
		);
		// upload 요청 시 지정한 날짜별 디렉토리가 존재하지 않으면 생성
		File file = new File(realPath,datePath);
		if(!file.exists()) {
			file.mkdirs();
		}
		return datePath;
	}
	
	/**
	 * download 받기 위한 파일 데이터를 byte[]로 반환
	 */
	public static byte[] getBytes(String realPath, String fileName) throws Exception{
		File file = new File(realPath,fileName.replace('/', File.separatorChar));
		InputStream is = new FileInputStream(file);
		// since java 9
		byte[] bytes = is.readAllBytes();
		is.close();
		return bytes;
		/*
		long length = file.length();
		length = is.available();
		
		byte[] bytes = new byte[(int)length];
		for(int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte)is.read();
		}
		is.close();
		return bytes;
		*/
	}

	/**
	 * 요청한 첨부 파일 정보에 따라
	 * content-type이 추가된 Headers 정보 반환
	 */
	public static HttpHeaders getHeaders(String fileName) throws Exception{
		HttpHeaders headers = new HttpHeaders();
		// 파일 이름에서 확장자 명 추출
		String ext = fileName.substring(fileName.lastIndexOf(".")+1);
		MediaType m = MediaUtil.getMediaType(ext);
		if(m != null) {
			headers.setContentType(m);
		}else {
			headers = getOctetHeaders(fileName);
		}
		return headers;
	}
	
	/**
	 * 이미지 파일이 아닐 경우는 브라우저를 통해
	 * 사용자 PC에 저장할 수 있도록 
	 * 해석할수 없는 바이너리 데이터라고 인식 할 수 있도록 headers 정보 추가
	 */
	public static HttpHeaders getOctetHeaders(String fileName) throws Exception{
		HttpHeaders headers = new HttpHeaders();
		// application/octet-stream
		// octet 8비트 / 1byte 단위의 이진 데이터가 전송 됨을 의미함.
		// headers.add("Content-Type","application/octet-stream");
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		fileName = fileName.substring(fileName.lastIndexOf("_") + 1);
		
		// Content-Disposition(배치 조치)
		// 응답헤더에를 통해서 컨텐츠가 브라우저에 인라인으로 표시되어야 하는지
		// 웹페이지의 일부인지 또는 첨부파일인 배치 조치 여부를 나타내는 헤더
		// attachment;fileName="파일이름.jpg" 
		/*
		fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		headers.add("Content-Disposition", "attachment;fileName=\""+fileName+"\"");
		*/
		ContentDisposition cd = ContentDisposition
								.attachment()
								.filename(fileName,Charset.forName("UTF-8"))
								.build();
		headers.setContentDisposition(cd);
		return headers;
	}
	
	/**
	 * 요청이 들어온 파일 삭제
	 *  /2024/02/21/s_a78fb89848374956ae0abb35fb25e739_cat1.jpg
		/2024/02/21/a68b7e6a06f54792bb19e677926181cb_data.hwp
		/2024/02/21/bec635e9d9254ffba862283cf46ce241_file1.txt
	 */
	public static boolean deleteFile(String realPath, String fileName) throws Exception{
		boolean isDeleted = false;
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		fileName = fileName.replace('/', File.separatorChar);
		File file = new File(realPath, fileName);
		isDeleted = file.delete();
		
		// 이미지 일 경우 원본 파일도 삭제
		if(isDeleted && MediaUtil.getMediaType(ext) != null) {
			fileName = fileName.replace("s_", "");
			isDeleted = new File(realPath,fileName).delete();
		}
		return isDeleted;
	}
	
}













