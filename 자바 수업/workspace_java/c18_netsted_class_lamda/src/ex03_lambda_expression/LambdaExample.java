package ex03_lambda_expression;

public class LambdaExample {
	
	public static void main(String[] args) {
		MyInterface myInterface = new MyInterface() {
			@Override
			public void method() {
				System.out.println("myInterface method");
			}
			
		};
		myInterface.method();
		
		// method에서 수행할 작업이 실행문 하나라면 {} 실행 블럭 생략 가능
		myInterface = ()-> System.out.println("rambda method 호출");
		
		myInterface.method();
		
		myInterface = () -> {
			String str = "method call";
			System.out.println(str + " 실행블럭");
		};
		
		myInterface.method();
	}

}
