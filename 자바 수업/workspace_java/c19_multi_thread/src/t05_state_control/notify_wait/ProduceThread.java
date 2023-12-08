package t05_state_control.notify_wait;

public class ProduceThread extends Thread {
	
	private DataBox dataBox;

	public ProduceThread(DataBox dataBox) {
		this.dataBox = dataBox;
	}

	@Override
	public void run() {
		for(int i = 0; i <=3; i++) {
			String data = "Data-"+i;
			dataBox.setData(data);
		}
	}

}










