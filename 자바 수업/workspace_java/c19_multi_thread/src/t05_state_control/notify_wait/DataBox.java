package t05_state_control.notify_wait;

public class DataBox {
	
	private String data;

	public synchronized String getData() {
		
		if(this.data == null) {
			// 아직 dataBox에 data가 저장되어 있지 않으면 일시 정지
			try {
				wait();	// getData()를 호출 한 thread를 일시 정지 상태로 지정
			} catch (InterruptedException e) {}
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		String value = this.data;
		this.data = null;
		System.out.println("읽은 데이터 : " + value);
		notify();
		return value;
	}

	public synchronized void setData(String data) {
		
		if(this.data != null) {
			// data가 소비 되지 않았을 때는 일시정지 상태
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		this.data = data;
		System.out.println("생성한 데이터 : " + data);
		notify();
		
	}
	
	
	

}








