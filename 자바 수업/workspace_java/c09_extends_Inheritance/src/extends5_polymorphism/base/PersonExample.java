package extends5_polymorphism.base;

public class PersonExample {
	
	public static void main(String[] args) {
		// String name, int age, int weight, int height
		Person h = new Person("최기근",26 ,70 ,183);
		String str = h.toString();
		System.out.println(str);
		System.out.println(h);
		
		Student stu = new Student("김철수",17,50,160,"3반","45번","2학년");
		System.out.println(stu);
		
		Person stu1 = new Student("김영희",16,48,170,"2반","1번","1학년");
		System.out.println(stu1);
		
		// 자동 타입 변환
		Person teacher = (Person)new Teacher("제임스고슬링",65,80,193,"EAD-134","JAVA","4학년");
		System.out.println(teacher);
		
		// teacher.teach();
		Teacher t1 = (Teacher)teacher;
		t1.teach();

		
		// Person p = new String("aa");
		Object o = new String("test");
		Object o1 = new Person();
		
		Person p1 = stu1;
		if(p1 instanceof Teacher) {
			Teacher t2 = (Teacher)p1;
			System.out.println("teacehr 타입입니다");
			t2.teach();
		}else {
			System.out.println("teacher 타입이 아닙니다");
		}
	}

}
