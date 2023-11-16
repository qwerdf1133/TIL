package final_test;

public class Car {
	
	// KIA == KIN
	static String company;			// 제조사 이름
	final String model;				// 모델명
	final int maxSpeed;				// 최대속도
	
	int speed;						// 현재속도
	
	static final int MIN_SPEED = 0;		// 최저속도
	
	Car(){
		this.model = "K3";
		this.maxSpeed = 280;
	}
	
	Car(String model, int maxSpeed){
		this.model = model;
		this.maxSpeed = maxSpeed;
	}
	
	public static void main(String[] args) {
		
		int v = 100;
		v = 101;
		
		// read only
		final int c;
		c = 100;
		
		// 값을 변경할 수 없고 읽기만 가능
		// c = 1000;
		
		Car.company = "KIN";
		Car k3 = new Car();
		System.out.println(k3.model);
		System.out.println(k3.maxSpeed);
		// k3.model = "K5";
		Car k5 = new Car("k5",320);
		System.out.println(k5.company);
		System.out.println(k5.model);
		System.out.println(k5.maxSpeed);
		
		System.out.println(Car.MIN_SPEED);
		
		System.out.println(Math.random());
		// Math.PI = 3.141592;
		System.out.println(Math.PI);
	}

}
