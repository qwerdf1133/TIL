package practice_04;

public class Car {

	public String color;
	public int speed;
	int gear;
	
	public void changeGear(int i) {
		this.gear = i;
	}
	public void speedUp() {
		this.speed += 10;
	}
	public void speedDown() {
		this.speed -= 10;
	}
	
	@Override
	public String toString() {
		return "Car [color=" + color + ", speed=" + speed + ", gear=" + gear + "]";
	}
	
}
