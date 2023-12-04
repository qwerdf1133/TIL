package f01_file;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class FileExample {

	public static void main(String[] args) {
		String dir = "C:/Temp/dir/aaa";
		dir = "C:\\Temp\\dir\\aaa";
		
		String separator = File.separator;
		System.out.println(separator);
		
		dir = "C:"+File.separator+"dir"+File.separator+"aaa";
		System.out.println(dir);
		
		char separatorChar = File.separatorChar;
		System.out.println(separatorChar);
		
		dir = "";
		
		System.out.println("dir : " +dir);
		
		File file = new File(dir);
		// 절대 경로
		System.out.println(file.getAbsolutePath());
		// 저장된 경로
		System.out.println(file.getPath());
		
		file = new File(dir,"Temp"); // C:\Temp
		// 절대 경로
		System.out.println(file.getAbsolutePath());
		// 저장된 경로
		System.out.println(file.getPath());	
		
		// file.exists()
		// 해당 위치에 폴더나 파일이 존재하면 true
		// 존재하지 않으면 false
		if(!file.exists()) {
			// 디렉토리 또는 파일이 존재하지 않음
			
			// 지정된 경로에 있는 디렉토리 중 마지막에 정의된 디렉토리 생성
			// 중간에 지정된 폴더가 없으면 생성 불가
			boolean isMake = file.mkdir();
			System.out.println("디렉토리 생성 여부 : " + isMake);
		}
		
		
		file = new File(file,"dir"+File.separator+"aaa");
		System.out.println("absolute : " + file.getAbsolutePath());
		
		if(!file.exists()) {
			System.out.println("디렉토리가 존재하지 않음");
			// mkdirs() : 경로상에 정의된 모든 디렉토리를 생성
			boolean isMake = file.mkdirs();
			System.out.println("디렉토리 생성 여부 : " + isMake);
		}
		
		String fileName = "test.txt";
		
		file = new File(file, fileName);
		System.out.println("absolute : " + file.getAbsolutePath());
		// C:\Temp\dir\aaa\test.txt
		if(file.exists() == false) {
			// file.mkdirs(); // 확장자명 상관없이 경로 상에 정의된 모든걸 directory로 생성
			System.out.println("파일이 존재하지 않음");
			
			try {
				file.createNewFile(); // 새 파일 생성
				System.out.println("새 파일 생성 완료");
			} catch (IOException e) {
				System.out.println("파일 생성 실패 : " + e.getMessage());
			}			
		}
		
		File file1 = new File("C:\\Temp\\file1.txt");
		if(!file1.exists()) {
			try {
				// try catch 블럭 지정 : alt + s + w
				boolean isMake = file1.createNewFile();
				System.out.println("파일 생성 여부 : " + isMake);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String path = file1.getAbsolutePath();
		System.out.println("absolute : "+path);
		
		File temp = new File("C:\\Temp");
		File[] temps = temp.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		
		for(File f : temps) {
			// 폴더나 파일의 마지막 수정 시간을 millis seconds로 반환
			long modified = f.lastModified();
			Date date = new Date(modified);
			String lastModified = sdf.format(date);
			System.out.println(lastModified);
			if(f.isDirectory()) { // 디레토리 인가
				System.out.println("\t<dir>\t\t\t"+f.getName());
			}else {
				System.out.println("\t<FILE>\t\t\t"+f.getName());
			}
		}
		
		// 삭제
		File file2 = new File("C:\\Temp\\dir\\aaa\\test.txt");
		boolean isDeleted = false;
		isDeleted = file2.delete();
		System.out.println("파일 삭제 여부 : " + isDeleted);
		
		file2 = new File("C:\\Temp\\dir\\aaa");
		isDeleted = file2.delete();
		System.out.println("디렉토리 삭제 여부 : " + isDeleted);
		
	}

}













