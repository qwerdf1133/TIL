package b_string.method;

public class String03SubstringExample {

	public static void main(String[] args) {
		String ssn = "880815-1234567";
		int index = ssn.indexOf("-");
		// 0번째 인덱스 부터 index 이전까지 잘라내어 새로운 문자열 반환
		String birthDay = ssn.substring(0, index);
		System.out.println("생년월일은 : " + birthDay);
		
		// 전달받은 인덱스부터 뒤에 있는 모든 문자열을 잘라내어 새로운 문자열 반환
		String last = ssn.substring(index + 1);
		System.out.println(last);
		
		String fileName = "cat.png";
		index = fileName.lastIndexOf(".");
		String ext = fileName.substring(index + 1);
		System.out.println(ext);
		
		ext = ext.toLowerCase(); 	// 알파벳을 소문자로 변경
		System.out.println(ext);
		if(ext.equals("png")) {
			System.out.println("png 이미지 파일입니다.");
		}
		
		ext = ext.toUpperCase();	// 알파벳을 대문자로 변경
		if(ext.equals("PNG")) {
			System.out.println("png 이미지 파일입니다");
		}
		
		// 대소문자 무시하고 알파벳이 같은지 비교
		if(ext.equalsIgnoreCase("png")) {
			System.out.println("png 이미지 파일입니다");
		}
		
		if(ext.equals("PNG") || ext.equals("png") || ext.equals("Png")) {
			System.out.println("png 이미지 파일입니다");
		}
		
	}

}
