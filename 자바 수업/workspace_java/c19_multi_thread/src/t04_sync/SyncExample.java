package t04_sync;

public class SyncExample {

	public static void main(String[] args) {
		Account account = new Account();
		Thread t1 = new Thread(new WithDrawTask(account));
		Thread t2 = new Thread(new WithDrawTask(account));
		t1.setName("task-1");
		t2.setName("task-2");
		t1.start();
		t2.start();
	}

}
