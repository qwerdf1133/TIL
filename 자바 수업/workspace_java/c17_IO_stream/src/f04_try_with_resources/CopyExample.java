package f04_try_with_resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
	
	/*
	 * C:\Temp\cat1.jpg
	 * 이미지를
	 * c:\Temp\images\copy.jpg
	 * 파일로 복사 하여 새로운 파일로 생성
	 */

	public static void main(String[] args) {
		
		String original = "C:\\Temp\\cat1.jpg";
		String targetDir = "C:\\Temp\\images";
		String copyFile = "copy.jpg";
		
		File file = new File(targetDir);
		// file 객체에 지정된 위치에 파일 또는 디렉토리가 존재하지 않을 경우
		if(!file.exists()) {
			file.mkdir();
			System.out.println("디렉토리 생성 완료");
		}
		
		File target = new File(targetDir,copyFile);
		System.out.println(target.getAbsolutePath());
		
		try(InputStream is = new FileInputStream(original);
			OutputStream os = new FileOutputStream(target);){
			/*
			while(true) {
				int read = is.read();
				if(read == -1) break;
				os.write(read);
						
			}
			os.flush();
			*/
			is.transferTo(os);
		}catch(IOException e) {
			System.out.println("copy 실패 : " + e.getMessage());
		}
				
		
	}

}
