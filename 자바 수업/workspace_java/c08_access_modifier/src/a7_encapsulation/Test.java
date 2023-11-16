package a7_encapsulation;

public class Test {
	
	public static void main(String[] args) {
		// Test.main(null);
		System.out.println(args);
		
		for(String s : args) {
			System.out.println(s);
		}
		
		Student choi = new Student();
		choi.name = "최기근";
		// choi.age = -20;
		choi.setAge(-20);
		// choi.grade = 16;
		choi.setGrade(20);
		
		System.out.println(choi.getAge());
		System.out.println(choi.getGrade());
	}

}
