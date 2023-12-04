package f02_output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class OutputStreamExample {

	public static void main(String[] args) {
		
		String path = "C:\\Temp\\file2.txt";
		
		try {
			// OutputStream os = new FileOutputStream(path);
			OutputStream os = new FileOutputStream(path,true);
			String s = "한글";
			byte[] strs = s.getBytes();
			System.out.println(Arrays.toString(strs));
			
			/*
			for(int i = 0; i < strs.length; i++) {
				// 1byte씩 출력
				os.write(strs[i]);
			}
			*/
			// 매개변수로 넘겨받은 모든 byte 배열을 출력
			// os.write(strs);
			os.write(strs, 3, 3);
			
			
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
