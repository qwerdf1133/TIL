package t03_state;

// target thread의 상태를 출력할 스레드
public class StatePrintThread extends Thread{

	Thread targetThread;
	
	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}
	
	@Override
	public void run() {
		while(true) {
			Thread.State state = targetThread.getState();
			System.out.println("target state : " + state);
			if(state == State.NEW) {
				targetThread.start();
			}
			
			if(state == State.TERMINATED) {
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}
