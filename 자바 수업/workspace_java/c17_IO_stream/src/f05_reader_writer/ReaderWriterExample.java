package f05_reader_writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class ReaderWriterExample {

	public static void main(String[] args) {
		String path = "C:\\Temp\\data.hwp";
		path = "\\\\10.100.205.231\\public\\강사 연락처 및 공유폴더.txt";
		Reader reader = null;
		Writer writer = null;
		
		try {
			reader = new FileReader(path);
			
			char[] chars = new char[100];
			
			int readChar;
			String result = "";
			
			while((readChar = reader.read(chars)) != -1) {
				result += new String(chars, 0 , readChar);
			}
			System.out.println(result);
			
			writer = new FileWriter(path);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("추가할 문자를 입력해 주세요.");
			String add = sc.nextLine();
			result += add;
			writer.write(result);
			writer.flush();
			sc.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("지정된 파일을 찾을 수 없음 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("파일 요청 처리를 할 수 없음 : " + e.getMessage());
		} finally {
			try {
				if(reader != null) reader.close();
			} catch (IOException e) {}
			
			try {
				if(writer != null) writer.close();
			} catch (IOException e) {}
		} 
	} 
	

}






