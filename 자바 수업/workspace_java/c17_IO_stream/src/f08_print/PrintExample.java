package f08_print;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintExample {

	public static void main(String[] args) {
		File file = new File("data.txt");
		
		try {
			FileOutputStream fos = new FileOutputStream(file,true);
			PrintStream ps = new PrintStream(fos,true);	// auto flush
			ps.println(); // 줄바꿈
			ps.println("[프린트 보조 스트림]");
			ps.print(1);
			ps.print("마치 ");
			ps.print("콘솔에 출력하는 것 처럼 ~");
			ps.println("데이터를 출력합니다~!");
			ps.printf("A의 값은 %d입니다.",100);
			ps.println();
			ps.close();
			
			PrintWriter // pw = new PrintWriter(fos,true);
			pw = new PrintWriter(new FileWriter(file,true),true);
			pw.println("PrintWriter 사용방법은 동일");
			pw.print('A');
			pw.printf("%s 입니다. %n", "최기근");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}















