package generic05_wildcard;

// 교육 과정
public class Course<S> {

	private String name;	// 수강 과정 이름
	private S[] students;	// 수강생 정보를 저장할 배열
	
	@SuppressWarnings("unchecked")
	public Course(String name, int capacity) {
		this.name = name;
		this.students = (S[])new Object[capacity];
	}
	
	public void add(S s) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = s;
				break;
			}
		}
	}

	public String getName() {
		return name;
	}

	public S[] getStudents() {
		return students;
	}
	
}
