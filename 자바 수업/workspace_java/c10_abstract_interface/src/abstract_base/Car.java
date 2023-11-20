package abstract_base;

public abstract class Car {
	
	protected abstract void drive();
	
	protected abstract void stop();
	
	public void startCar() {
		System.out.println("시동을 켭니다");
	}
	
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	public final void run() {
		startCar();
		drive();
		stop();
		turnOff();
	}

}
