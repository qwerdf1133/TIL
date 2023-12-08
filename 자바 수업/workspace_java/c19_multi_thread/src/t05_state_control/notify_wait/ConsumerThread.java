package t05_state_control.notify_wait;

public class ConsumerThread extends Thread {

	private DataBox dataBox;

	public ConsumerThread(DataBox dataBox) {
		this.dataBox = dataBox;
	}
	
	@Override
	public void run() {
		for(int i = 0; i <= 3; i++) {
			String data = dataBox.getData();
			System.out.println("consumer thread data : " + data);
		}
	}
	
}











