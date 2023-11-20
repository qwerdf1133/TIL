package interface_poly.param;

public class DriverExample {
	
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Sedan sedan = new Sedan();
		
		driver.drive(sedan);
		
		Bus bus = new Bus();
		driver.drive(bus);
		
		MotorCycle motor = new MotorCycle();
		driver.drive(motor);
	}

}
