package extends4_protected.b;

import extends4_protected.a.A;

public class D extends A{
	
	A a1 = new A();
	
	public D() {
		super();
		a1.a = 100;		// public
		// a1.b = 300;		// protected
		super.b = 300;		// super protected
	}
	
	// alt + s + v
	@Override
	public void methodA() {
		System.out.println("D class의 methodA");
	}
	/*
	// final method는 재정의 불가
	protected final void methodB() {
		System.out.println("A class의 methodB");
	}
	*/
	
	public static void main(String[] args) {
		D d = new D();
		System.out.println(d.b);
		d.methodA();
		d.methodB();
		// d.c = 100;		// default
	}

	
	
}
