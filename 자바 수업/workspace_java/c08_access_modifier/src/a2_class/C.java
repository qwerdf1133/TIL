package a2_class;

import a1_class.A;
// default 접근 제한은
// 외부 패키지에서의 접근을 제한한다
// import a1_class.B;

public class C {

	a1_class.A a = new a1_class.A();
	A a1 = new A();
	
	// B b = new B();
}
