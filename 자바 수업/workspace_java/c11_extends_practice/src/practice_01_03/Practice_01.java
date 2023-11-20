package practice_01_03;

import java.util.Scanner;

public class Practice_01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String myId = "id001";
		
		System.out.print("아이디 입력>");
		String id = sc.next();

		if(myId.equals(id)) {
			System.out.println("아이디가 일치합니다.");
		}else {
			System.out.println("아이디가 일치하지 않습니다.");
		}
		sc.close();
	}
}
