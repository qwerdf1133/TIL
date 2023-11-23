package b_string.method;

import java.util.Scanner;

public class String04TrimExample {
	
	public static void main(String[] args) {
		// trim() - 문자열의 좌우에 생성된 공백 제거
		String tel1 = "			      02";
		String tel2 = "1234				";
		String tel3 = "		5678		";
		String tel4 = "	010 9486 7166	";
		System.out.println(tel1 + tel2 + tel3);;
		System.out.println(tel1.trim() + tel2.trim() + tel3.trim());
		String result = tel4.trim();
		System.out.println(tel4.length());
		System.out.println(result);
		System.out.println(result.length());
		
		// ctrl shift + o
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력해 주세요 > ");
		String id = sc.nextLine();
		String onwerId = "id001";
		
		if(id.trim().equals(onwerId)) {
			System.out.println("일치합니다");
		}else {
			System.out.println("일치하지 않습니다");
		}
	}

}
