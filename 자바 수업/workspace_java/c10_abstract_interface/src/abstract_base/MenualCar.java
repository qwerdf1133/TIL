package abstract_base;

public class MenualCar extends Car{

	@Override
	protected void drive() {
		System.out.println("사람이 운전합니다");
		System.out.println("사람이 핸들을 조작합니다");
		
	}

	@Override
	protected void stop() {
		System.out.println("브레이크를 밟아서 정지합니다");
	}

}
