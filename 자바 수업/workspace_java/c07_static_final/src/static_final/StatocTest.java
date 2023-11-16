package static_final;

public class StatocTest {
	
	static String test;
	
	public static void main(String[] args) {
		
		System.out.println(test);
		
		Student.school = "부산IT아카데미";
		System.out.println(Student.school);
		// Student.name = "최기근";
		Student choi = new Student();
		choi.name = "최기근";
		choi.age = 18;
		choi.grade = "4";
		choi.school = "부산직업전문학교";
		
		Student lee = new Student();
		System.out.println(lee.school);
		
		Student song = new Student();
		song.school = "부산교도소";
		
		System.out.println(Student.school);
		
		int result = Student.sum(1, 2);
		System.out.println(result);
		
		// Student.setAge(20);
		song.setAge(30);	
	}

}
