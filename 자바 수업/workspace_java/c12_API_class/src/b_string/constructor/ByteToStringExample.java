package b_string.constructor;

import java.io.UnsupportedEncodingException;

public class ByteToStringExample {

	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes = new byte[] {
		//  H    e    l    l    o   공백  J   A   V    A
			72, 101, 108, 108, 111, 32, 74, 97, 118, 97
		};
		
		String str = new String(bytes);
		System.out.println(str);
		// 6번째 인덱스부터 4개만큼 UTF-8 인코딩 형식으로 문자열 생성
		String str2 = new String(bytes,6, 4, "UTF-8");
		System.out.println(str2);
		
		char[] strs = new char[] {'안','녕','하','세','요'};
		str = new String(strs);
		
		// 0번째 인덱스부터 2개만큼 문자열 조합
		// charset이 지정되어 있지 않으면 자바는 기본적으로 UTF-8을 사용
		str = new String(strs, 0, 2);
		char[] charArray = str.toCharArray();
		for(char c : charArray) {
			System.out.println(c);
		}
		
		str = "한글표현";
		System.out.println(str.length());
		
		byte[] bytes1 = str.getBytes();
		System.out.println(bytes1.length);
		
		byte[] bytes2 = str.getBytes("EUC-KR");
		System.out.println(bytes2.length);
		
		String result1 = new String(bytes2);
		System.out.println(result1);
		
		String result2 = new String(bytes1);
		System.out.println(result2);
		
		String result3 = new String(bytes2, "EUC-KR");
		System.out.println(result3);
	}

}
