package interface_extends;

public interface A {
	
	void methodA();
	
	default void methodB() {
		System.out.println("A interface methodB");
	}
	
	static void methodC() {
		System.out.println("interface 이름으로 접근하는 정적 멤버");
	}
}

interface B{
	void methodB();
}

interface C extends A, B{
	void methodC();

	@Override
	default void methodB() {
		System.out.println("C interface methodB");
	}
	
}











