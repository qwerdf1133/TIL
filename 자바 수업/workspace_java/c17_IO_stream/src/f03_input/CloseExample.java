package f03_input;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class CloseExample {

	public static void main(String[] args) {
		// 지정된 파일에 console 을 통해서 입력받은 문자열을 출력
		InputStream is = null;
		OutputStream os = null;
		String path = "C:\\Temp\\file23.txt";
		
		try {
			is = new FileInputStream(path);
			byte[] bytes = new byte[is.available()];
			System.out.println("bytes length : " + bytes.length);
			int readBytes = is.read(bytes);
			
			String result = new String(bytes, 0, readBytes);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("추가로 저장할 문자열을 입력해주세요 > ");
			String a = sc.next();
			System.out.println(result);
			System.out.println(a);
			a = (result + a);
			
			bytes = a.getBytes();
			os = new FileOutputStream(path);
			os.write(bytes);
			os.flush();
		}catch(IOException e) { 
			e.printStackTrace();
		}finally{
			try {
				if(is != null)is.close();
			} catch (IOException e) {}
			
			try {
				if(os != null)os.close();
			} catch (IOException e) {}
			
		}
		
	}

}












