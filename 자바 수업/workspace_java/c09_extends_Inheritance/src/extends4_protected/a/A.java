package extends4_protected.a;

public class A {
	
	public int a;
	protected int b;
	int c;
	private int d;
	
	public A() {
		this.d= 10;	
	}
	
	protected void methodA() {
		System.out.println("A class의 methodA");
	}
	
	protected final void methodB() {
		System.out.println("A class의 methodB");
	}
	
}
