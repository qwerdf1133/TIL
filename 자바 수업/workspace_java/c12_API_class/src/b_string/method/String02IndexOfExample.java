package b_string.method;

public class String02IndexOfExample {
	
	public static void main(String[] args) {
		String str = "자바 프로그래밍을 자바?";
		// IndexOf(), lastIndexOf
		// 매개변수로 넘겨받은 문자열이 지정된 문자열에 존재하는지
		// 확인하고 문자열이 시작하는 시작인덱스 값을 반환
		// 해당하는 문자열이 존재하지 않으면 -1을 반환
		
		int location = str.indexOf("프로그래밍");
		System.out.println(location);
		
		if(str.indexOf("자바") != -1) {
			System.out.println("자바가 존재합니다");
		}else {
			System.out.println("자바가 존재하지 않습니다");
		}
		
		location = str.indexOf("자바", 3);
		System.out.println("indexOf : " + location);
		
		location = str.indexOf("자바", location);
		System.out.println("indexOf offset : " + location);
		
		location = str.lastIndexOf("자바");
		System.out.println("lastIndexOf : " + location);
	}

}
