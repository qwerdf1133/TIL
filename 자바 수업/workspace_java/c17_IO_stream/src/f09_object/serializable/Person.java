package f09_object.serializable;

import java.io.Serializable;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 6328165541094285911L;

	public static String nation;
	
	private String name;
	private int age;
	private String id;
	
	transient private String pw;
	
	private int score;
	
	// alt + s + r
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "nation = "+Person.nation+", Person [name=" + name + ", age=" + age + ", id=" + id + ", pw=" + pw + "]";
	}

}




