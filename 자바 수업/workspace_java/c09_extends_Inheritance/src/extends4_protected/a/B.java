package extends4_protected.a;

// final class는 설계가 변경될 수 없는 class
// 상속으로 확장이 불가능한 클래스
// 부모가 될 수 없는 class
public final class B {
	A a = new A();
	
	public B() {
		a.a = 100; 		// public
		a.b = 2000;		// protected
		a.c = -100; 	// default
		// a.d = 40;		// private
		a.methodA();	// protected
		a.methodB();	// protected
	}
	

}
