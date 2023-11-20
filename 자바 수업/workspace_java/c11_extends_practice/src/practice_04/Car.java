package practice_04;

public class Car {
	
	String color;
	int speed;
	int speedUp;
	int speedDown;
	private int changeGear;
	
	public Car() {}
	
	public Car(String color, int speed, int changeGear, int speedUp, int speedDown) {
		this.color = color;
		this.speed = speed;
		this.changeGear = changeGear;
		this.speedUp = speedUp;
		this.speedDown = speedDown;
	}
	
	
	public String toString() {
		return "Car [ color = "+this.color+", speed = "+this.speed+", gear = "+this.changeGear+"]";
	}

	public void speedUp() {
		// TODO Auto-generated method stub
		
	}

	public void changeGear(int i) {
		// TODO Auto-generated method stub
		
	}

	public void speedDown() {
		// TODO Auto-generated method stub
		
	}


	

	
}
