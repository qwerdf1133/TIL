package interface_poly.array;

public class Car {
	
	String model;
	String color;
	
	int speed;
	
	Tire[] tires;
	
	public Car() {
		tires = new Tire[] {
			new NormalTire(),
			new NormalTire(),
			new NormalTire(),
			new NormalTire(),
		};
	}
	
	public void run() {
		for(Tire tire : tires) {
			tire.roll();
		}
	}
	
	public static void main(String[] args) {
		Car car = new Car();
		car.run();
		System.out.println("=================");
		
		Tire[] tires = new WetTire[4];
		for(int i = 0; i < tires.length; i++) {
			tires[i] = new WetTire();
		}
		car.tires = tires;
		car.run();
		
		System.out.println("=================");
		tires = new SnowTire[4];
		for(int i = 0; i < tires.length; i++) {
			tires[i] = new SnowTire();
		}
		car.tires = tires;
		car.run();
		
	}

}
