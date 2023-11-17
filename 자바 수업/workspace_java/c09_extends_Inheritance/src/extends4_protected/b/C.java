package extends4_protected.b;

import extends4_protected.a.*;
/*
import extends4_protected.a.A;
import extends4_protected.a.B;
*/
public class C // extends B
{
	B b = new B();
	A a = new A();
	
	public C() {
		a.a = 100;	// public
		/*
		a.b = 200; 	// protected
		a.c = 300;	// default
		a.methodA();// protected	
		*/
	}

}
