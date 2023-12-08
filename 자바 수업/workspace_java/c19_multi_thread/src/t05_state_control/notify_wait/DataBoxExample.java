package t05_state_control.notify_wait;

public class DataBoxExample {

	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		Thread pThread = new ProduceThread(dataBox);
		Thread cThread = new ConsumerThread(dataBox);
		pThread.start();
		cThread.start();
	}

}
