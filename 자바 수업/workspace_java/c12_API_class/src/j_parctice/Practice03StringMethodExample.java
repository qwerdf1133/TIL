package j_parctice;

import java.util.Scanner;

public class Practice03StringMethodExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("문자열을 입력해주세요 > ");
			String s = sc.nextLine();
			// java라는 문자열이 입력받은 문자열에 존재하는지 확인
			// index번호는 0에서부터 양수로 표현, -1은 존재하지 않음을 의미
			// if(s.indexOf("java") != -1) {
			// contains("검색할 문자열") , true 0 포함, flase - 미포함
			if(s.contains("java")) {
				System.out.println("java가 존재합니다");
				break;
			}
			System.out.println("java가 존재하지 않습니다");
			
		} // end while
		System.err.println("시스템을 종료합니다");
		
	}

}
