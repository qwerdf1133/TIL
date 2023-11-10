package c_method;
/**
 * method : 객체의 동작 - 기능들을 정의 
 */
public class Methods {

	// 반환형-return type 메소드이름_식별자(매개변수들...){실행블럭}  
	void methodA() {
		System.out.println("void 반환하는 값은 없고 매개변수 없이 기능만 수행");
	}
	
	int methodB() {
		System.out.println("int type의 결과를 반환");
		return 0;
	}
	//     methodC(10,20); 
	double methodC(int x, int y) {
		System.out.println("매개변수에 인자값 두개를 전달받아");
		System.out.println("블럭 실행 후 결과를 double type으로 반환");
		return x / y;
	}
	
	double avg(int i, int j, double d) {
		double total = i + j + d;
		return total / 3;
	}
	
	public static void main(String[] args) {
		Methods m = new Methods();
		// int result = m.methodA();
		m.methodA();
		
		int result = m.methodB();
		System.out.println(result);
		
		double r = m.methodC(20,10);
		System.out.println(r);
		
		double avg = m.avg(10,20,30.0);
		System.out.println(avg);
	}


}
