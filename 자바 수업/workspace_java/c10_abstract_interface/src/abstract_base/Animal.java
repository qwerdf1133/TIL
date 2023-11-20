package abstract_base;

public abstract class Animal {
	
	String kind;		// 분류
	
	public void breath() {
		System.out.println("숨을 쉰다.");
	}
	
	public abstract void sound();

}
