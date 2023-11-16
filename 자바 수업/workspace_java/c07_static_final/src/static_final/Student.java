package static_final;

public class Student {
	
	static String school;
	
	String name;
	int age;
	String grade;
	
	static int sum(int x , int y) {
		// System.out.println("나이는 : " + this.age);
		return x + y;
	}
	
	void setAge(int age) {
		System.out.println(school);
		System.out.println(sum(30,20));
		if(age < 1) {
			System.out.println("등록할 수 없는 나이입니다");
		}else {
			this.age = age;
		}
	}
}
