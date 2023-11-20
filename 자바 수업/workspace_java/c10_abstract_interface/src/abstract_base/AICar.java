package abstract_base;

public class AICar extends Car{

	@Override
	protected void drive() {
		System.out.println("자율 주행 합니다");
		System.out.println("지정된 경로로 방향을 바꿉니다");
		
	}

	@Override
	protected void stop() {
		System.out.println("목적지에 도착하여 주행을 멈춥니다");
	}

}
