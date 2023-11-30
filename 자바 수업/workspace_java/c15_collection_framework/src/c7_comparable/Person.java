package c7_comparable;

public class Person implements Comparable<Person>{
	
	private String name;
	private int age;
	
	// 생성자 & toString
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		int result = this.age - o.age;
		System.out.println(this.age+"-"+o.age+"="+result);
		return result;
	}
	
	
}













