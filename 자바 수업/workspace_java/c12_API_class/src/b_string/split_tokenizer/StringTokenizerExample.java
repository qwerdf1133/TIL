package b_string.split_tokenizer;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		
		String text = "이나영/김희선/박보영/원빈/장동건/최기근";
		StringTokenizer st = new StringTokenizer(text,"/");
		int countTokens = st.countTokens();
		System.out.println(countTokens);
		
		for(int i = 0; i < countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		System.out.println("======================");
		text = "홍길동|페이커,최기근,이순신&김유신";
		st = new StringTokenizer(text,"|,&");
		// 꺼내올 token이 존재하면 true
		// 꺼내올 token이 없으면 false
		while(st.hasMoreTokens()) {
			// String token = st.nextToken();
			String token = st.nextToken("|,&");
			System.out.println(token);
		}

	}

}
