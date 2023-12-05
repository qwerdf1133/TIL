package f06_buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class StreamReaderExample {

	public static void main(String[] args) {
		
		InputStream is = System.in;
		
		try {
			Reader reader = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(reader);
			
			System.out.println("입력 대기중...");
			
			BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(
					new FileOutputStream("C:\\Temp\\fos.txt",true)
				)
			);
			String readData = "";
			while(true) {
				readData = br.readLine();
				// 입력한 문자열이 quit로 시작 하면 true
				if(readData.startsWith("quit")) break;
				writer.write(readData);
				// 줄바꿈
				writer.newLine();
			}
			writer.flush();
			writer.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
