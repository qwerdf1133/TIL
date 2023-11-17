package extends3_overriding;

public class CalculatorExample {
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		int sum = calc.sum(20, 10);
		System.out.println("SUM : " + sum);
		System.out.println(calc.circleArea(5));
		
		Computer com = new Computer();
		int plus = com.sum(30,  40);
		System.out.println("com sum : " + plus);
		double area = com.circleArea(7.5);
		System.out.println("area : " + area);
	}

}
