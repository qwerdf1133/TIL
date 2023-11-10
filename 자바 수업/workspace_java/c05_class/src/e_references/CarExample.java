package e_references;

// 실행 class
public class CarExample {

	public static void main(String[] args) {
		
		Car car = new Car();
		System.out.println(car.company);
		System.out.println(car.model);
		System.out.println(car.engine);
		
		car.company = "현대자동차";
		car.model = "싼타페";
		
		Engine engine = new Engine();
		car.engine = engine;
		
		car.engine.maxSpeed = 280;
		car.engine.rpm = 2000;
		
		System.out.println(engine == car.engine);
		
		Car car2 = new Car();
		car2.company = "KIN";
		car2.model = "모닝";
		car2.engine = new Engine();
		car2.engine.maxSpeed = 180;
		car2.engine.rpm = 1000;
		
		Engine engine2 = new Engine();
		car2.engine = engine2;
		
		System.out.println(car2.engine.maxSpeed);
		System.out.println(car2.engine.rpm);
				
	}
}
