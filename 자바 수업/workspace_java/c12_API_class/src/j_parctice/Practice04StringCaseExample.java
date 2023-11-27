package j_parctice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Practice04StringCaseExample {

	public static void main(String[] args) {
		String chars = "abcedfghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		
		System.out.println("문자나 숫자를 입력해주세요 > ");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		String lower = str.toLowerCase(); // 알파벳을 소문자로 변경
		lower = lower.trim(); // 좌우 공백 제거
		
		System.out.println("입력받은 문자 : " + str);
		System.out.println("변경된 소문자 : " + lower);
		
		boolean isCheckEng = chars.contains(lower);
		System.out.println("영어문자 : " + isCheckEng);
		
		boolean isCheckDigit = numbers.indexOf(lower) != -1;
		System.out.println("숫자문자 : " + isCheckDigit);
		
		char[] strs = lower.toCharArray();
		char[] strs2 = chars.toCharArray();
		for(char c : strs) {
			if(Arrays.binarySearch(strs2, c) < 0) {
				isCheckEng = false;
				break;
			}
			isCheckEng = true;
		}
		System.out.println("===========================");
		System.out.println("영어문자: " + isCheckEng);
		
		for(char c : strs) {
			if(Arrays.binarySearch(numbers.toCharArray(), c) < 0) {
				isCheckDigit = false;
				break;
			}
			isCheckDigit = true;
		}
		System.out.println("숫자문자 : " + isCheckDigit);
		
		System.out.println("정규 표현식 ===================");
		String pattern = "^[ㄱ-ㅎ가-힣]*$";
		// 정규표현식으로 한글 페크
		boolean a = Pattern.matches(pattern, str);
		System.out.println("한글문자 : " + a);
		
		a = Pattern.matches("^[\\d]*$", str);
		System.out.println("숫자문자 : " + a);
		
		a = Pattern.matches("^(0|[-]?[0-9]\\d*)$", str);
		System.out.println("숫자문자(음수포함) " + a);
		
		a = Pattern.matches("^[a-zA-Z]*$", str);
		System.out.println("영어문자 : " + a);
	}

}
