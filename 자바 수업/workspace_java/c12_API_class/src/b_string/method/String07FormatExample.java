package b_string.method;

import java.sql.Date;

public class String07FormatExample {

	public static void main(String[] args) {
		// 지정된 패턴에 따라 대입된 값으로 문자열을 완성하는 메소드
		String str = "freelife";
		boolean bool = true;
		int i = 127;
		/*
		 	%d (10진수 정수 형식)
		 	%s (문자열 형식)
		 	%f (실수형 형식)
		 	%t (날짜 형식)
		 	%c (유니코드 문자 형식)
		 	%o, %x (8진수, 16진수 형식)
		 */
		// String result1 = String.format("문자열 서식 : %S, %s", str, str);
		String result1 = String.format("문자열 서식 : %S, %<s", str);
		System.out.println(result1);
		String result2 = String.format("boolean 서식 문자열 %B, %b",  bool, bool);
		System.out.println(result2);
		String result3 = String.format("숫자 서식 : %d, %<o, %<x, %<05d", i);
		System.out.println(result3);
		
		java.util.Date date = new java.util.Date();
		System.out.println(date);
		Date date2 = new Date(0);
		System.out.println(date2);
		
		String result = String.format("날짜 시간 서식 : %tY년 %<tm월 %<td일 %<tH시 %<tM분 %<tS초", date);
		System.out.println(result);
	}

}
