package extends4_protected.a.c;

import extends4_protected.a.A;

// class의 package명이 동일해야 같은 package로 인식
public class E {
	
	A a = new A();
	
	public E() {
		a.a = 100; 		// public
		// a.b = 200;		// protected
		
	}

}
