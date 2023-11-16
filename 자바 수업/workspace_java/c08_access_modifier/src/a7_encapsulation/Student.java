package a7_encapsulation;

// encapsulation - 캡슐화
public class Student {
	
	public String name;		// 이름
	private int age;		// 나이
	private int grade;		// grade
	
	public static final int MIN_GRADE = 1;
	public static final int MAX_GRADE = 4;
	
	public void setAge(int age) {
		if(age < 1) {
			return;
		}
		this.age = age;
	}
	
	public void setGrade(int grade) {
		if(grade < MIN_GRADE || grade > MAX_GRADE) {
			this.grade = MIN_GRADE;
			return;
		}
		this.grade = grade;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getGrade() {
		return this.grade;
	}
}
