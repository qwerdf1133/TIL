package abstract_base;

public class CarExample {
	
	public static void main(String[] args) {
		
		// Car car = new Car();
		Car aiCar = new AICar();
		aiCar.run();
		System.out.println("=============");
		Car menualCar = new MenualCar();
		menualCar.run();
		
	}

}
