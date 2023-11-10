package c_method;

/**
 * 전산학에서의 overload 
 * 객체지향에서 하나의 함수 또는 연산자가 입력된 값에 따라
 * 여러가지 동작을 하도록 하는 것
 */
public class MethodOverloading {
	
	
	void methodA() {
		System.out.println("Method A 호출");
	}
	
	// int methodA() {}
	// 매개변수 개수 상이
	void methodA(int a) {}
	// 매개변수의 타입 상이
	void methodA(double d) {}
	// 매개변수의 개수 상이
	void methodA(double d, double a) {}
	//void methodA(double a, double b) {}
	// 매개변수의 순서 상이
	void methodA(int a, double b) {}
	void methodA(double b, int a) {};

	public static void main(String[] args) {
		MethodOverloading m = new MethodOverloading();
		m.methodA();
		m.methodA(10);
		m.methodA(10.0);
		m.methodA(10.0, 10.3);
		System.out.println();
		
		AreaCalculator ac = new AreaCalculator();
		
		int result = ac.areaRectangle(10);
		System.out.println(result);
		double result1 = ac.areaRectangle(10.0, 5.0);
		System.out.println(result1);
		
		ac.divide(10, 5);
		
		ac.divide(10,  0);
		
	}

}
