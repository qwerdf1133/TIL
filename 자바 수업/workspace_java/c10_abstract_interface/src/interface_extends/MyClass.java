package interface_extends;

public class MyClass implements C {

	@Override
	public void methodA() {
		System.out.println("MyClass의  methodA");

	}

	@Override
	public void methodC() {
		System.out.println("MyClass의 methodC");
	}
	
	
	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		myClass.methodA();
		myClass.methodB();
		myClass.methodC();
		A.methodC();
		
	}
	

}











