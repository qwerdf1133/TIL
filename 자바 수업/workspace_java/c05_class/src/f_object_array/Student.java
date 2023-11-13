package f_object_array;

public class Student {

	int number;		// 학번
	String name;	// 학생이름
	int score;		// 점수
	
	Student(){}
	
	Student(int number, String name, int score){
		this.number = number;
		this.name = name;
		this.score = score;
	}
	
	String getInfo() {
		return "number : " +number+", name : " +name+", score : "+score;
	}
	
}
