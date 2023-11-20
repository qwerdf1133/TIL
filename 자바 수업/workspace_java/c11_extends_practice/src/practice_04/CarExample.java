package practice_04;

public class CarExample {
	/**
	 * Car class 작성
	 */
	public static void main(String[] args) {
		Car car = new Car();
		car.color = "red";
		car.speed = 0;
		car.changeGear(1);
		car.speedUp();
		System.out.println(car.toString());
		car.speedDown();
		System.out.println(car.toString());
	}
	
}



