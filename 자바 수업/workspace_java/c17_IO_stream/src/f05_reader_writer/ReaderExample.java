package f05_reader_writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class ReaderExample {

	public static void main(String[] args) {
		
		try {
			Reader reader = new FileReader("C:\\Temp\\data.hwp");
			int readData;
			/*
			while(true) {
				// 2byte의 문자 기반으로 입력 받음
				readData = reader.read();
				// EOF == -1
				if(readData == -1) break;
				System.out.print((char)readData);
			}
			*/
			char[] cBuf = new char[100];
			while((readData = reader.read(cBuf)) != -1) {
				System.out.println(readData);
				System.out.println(Arrays.toString(cBuf));
				String result = new String(cBuf,0,readData);
				System.out.println(result);
			}
			
			// 자원 해제
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
