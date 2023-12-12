package t05_state_control.stop;

class InterruptThread extends Thread{
	@Override
	public void run() {
		while(true) {
			System.out.println("실행 중 1");
			boolean isFlag = Thread.interrupted();
			System.out.println("interrupted : " + isFlag);
			if(isFlag) {
				break;
			}
		}
		System.out.println("자원 해제");
		System.out.println("실행 종료");
	}
	
}


public class InterruptExample {

	public static void main(String[] args) {
		Thread t = new InterruptThread();
		t.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		// interrupt(); t 스레드를 방해 플레이그 변경
		System.out.println("Interrupt 호출");
		t.interrupt();
	}

}










