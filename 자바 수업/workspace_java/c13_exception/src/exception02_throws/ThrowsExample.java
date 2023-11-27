package exception02_throws;

public class ThrowsExample {

	public static void main(String[] args) { //throws ClassNotFoundException{
		System.out.println("Main 시작");
		
		try {
			findClass("java.lang.String");
			findClass("java.lang.String2");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main 종료");

	}
	
	public static void findClass(String path) throws ClassNotFoundException, NullPointerException{
		// Class.forName("class 경로")
		// 클래스 위치 경로를 문자열로 전달받아 클래스의 설계정보를 저장하는 Class 객체 반환
		Class clazz = Class.forName(path);
		System.out.println(clazz);
	}

}
