package f05_reader_writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExample {

	public static void main(String[] args) {
		
		try {
			Writer writer = new FileWriter("C:\\Temp\\data.hwp",true);
			String strs = "최기근님";
			char[] chars = strs.toCharArray();
			/*
			// char 단위로 출력
			for(char c : chars) {
				writer.write(c);
			}
			*/
			// 매개변수로 전달 받은 배열의 문자들을 출력
			// writer.write(chars);
			// writer.write(chars,3,1);
			writer.write("박보영님");
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end main

}










