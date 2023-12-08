package t03_state;

public class StateExample {

	public static void main(String[] args) {
		System.out.println("메인 시작");
		TargetThread targetThread = new TargetThread();
		
		Thread print = new StatePrintThread(targetThread);
		print.start();
		
		System.out.println("메인 종료");

	}

}
