package a5_field;

public class B {
	
	public B() {
		A a = new A();
		a.field1 = 100; // public
		a.field2 = 200; // default
//		a.field3 = 400; // private
		
		a.publicMethod();
		a.defaultMethod();
//		a.privateMethod();
	}

}
