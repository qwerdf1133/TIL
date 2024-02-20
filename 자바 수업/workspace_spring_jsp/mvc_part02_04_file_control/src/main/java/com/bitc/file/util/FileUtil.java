package com.bitc.file.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
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
	public static String uploadFile(String realPath, MultipartFile file) throws Exception{
		String uploadedFileName = "";
		// 동일 디렉토리에 동일한 이름의 파일 중복 최소화
		UUID uuid = UUID.randomUUID();
		String savedName = uuid.toString().replace("-", "");
		String originalName = file.getOriginalFilename();
		savedName += "_"+(originalName.replace("_", " "));
		System.out.println(savedName);
		
		// url 요청으로 전달된 파일 이름은 공백이 자동으로 + 로 치환
		savedName = savedName.replace("+", " ");
		String datePath = calcPath(realPath);
		System.out.println(savedName);
		
		File f = new File(realPath+datePath, savedName);
		System.out.println(f.getAbsolutePath());
		file.transferTo(f);
		
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		if(MediaUtil.getMediaType(formatName) != null) {
			// 이미지 일 경우에는 썸네일 이미지 경로 반환
			uploadedFileName = makeThumbnail(realPath, datePath, savedName, formatName);
		}else {
			String fileName = datePath+File.separator+savedName;
			System.out.println(fileName);
			uploadedFileName = fileName.replace(File.separatorChar, '/');
		}
		
		return uploadedFileName;
	}
	
	// 이미지 일경우 썸네일 이미지 생성
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
		String thumbnailImage = realPath+datePath+File.separator+"s_"+savedName;
		// ImageIO.write(출력할 이미지 데이터, 파일 확장자, 출력 위치);
		ImageIO.write(sourceImage, ext, new File(thumbnailImage));
		name = thumbnailImage.substring(realPath.length()).replace(File.separatorChar, '/');
		return name;
	}
	
	
	// /yyyy/MM/dd 형식의 요청 날짜별 디렉토리 생성 
	public static String calcPath(String realPath) {
		String pattern =  File.separator+"yyyy"+File.separator+"MM"+File.separator+"dd";
		LocalDate date = LocalDate.now();
		String datePath = date.format(
			DateTimeFormatter.ofPattern(pattern)
		);
		File file = new File(realPath,datePath);
		if(!file.exists()) {
			file.mkdirs();
		}
		System.out.println(datePath);
		return datePath;
	}

}













