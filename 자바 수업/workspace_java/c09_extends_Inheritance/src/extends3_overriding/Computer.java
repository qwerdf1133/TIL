package extends3_overriding;

public class Computer extends Calculator{

	// annotation 자바 소스코드에 추가하여 사용할 수 있는 meta data의 일종
	@Override 
	public double circleArea(double radius) {
		System.out.println("Computer에 존재하는 circleArea");
		return radius * radius * Math.PI;
	}

}
