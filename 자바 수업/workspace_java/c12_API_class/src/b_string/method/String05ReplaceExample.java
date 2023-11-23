package b_string.method;

public class String05ReplaceExample {
	
	public static void main(String[] args) {
		String oldStr = "자바는 어렵다 그래도 해야한다 자바";
		String newStr = oldStr.replace("자바", "JAVA");
		System.out.println("oldStr : " + oldStr);
		System.out.println("newStr : " + newStr);
		
	}

}
