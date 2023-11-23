package b_string.split_tokenizer;

public class StringSplitExample {

	public static void main(String[] args) {
		// 회원 목록을 출력한다
		// 최기근, 김유시느 이순신 ...
		String text = "최기근&박주신,이주명\\페이커-빛강선";
		// 구분자를 표현하는 패턴 - 정규표현식
		String[] names = text.split("&|,|\\\\|-");
		for(String s : names) {
			System.out.println(s);
		}
	}

}
