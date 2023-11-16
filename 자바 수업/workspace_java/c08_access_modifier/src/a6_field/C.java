package a6_field;

import a5_field.A;

public class C {
	
	public C() {
		A a =new A();
		a.field1 = 100;		// public
//		a.field2 = 200;		// default
//		a.field3 = 300;		// private
		
		a.publicMethod();
	}

}
