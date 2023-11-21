package a_object.toString;

class Person{
	
	String name;
	int height;
	double weight;
	
	// alt + s + a
	public Person(String name, int height, double weight) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	// alt + s + s + s
	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + ", weight=" + weight + "]";
	}

	// alt + s + v
	/*
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	*/
	
}


public class ToStringExample {

	public static void main(String[] args) {
		Object obj = new Object();
		String result = obj.toString();
		System.out.println(result);
		System.out.println(obj);
		
		Person p = new Person("최기근", 193, 80.1);
		System.out.println(p);
		
	}

}















