package b_string.method;

public class String06ValueOfExample {
	
	public static void main(String[] args) {
		String str1 = String.valueOf(false);
		String str2 = String.valueOf(10);
		String str3 = String.valueOf(3.14);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str1.equals(str2));
		
		Object o = new Object();
		
		String str4 = String.valueOf(o);
		System.out.println(str4);
		
		String str5 = o+"";
		System.out.println(str5);
		
	}

}
