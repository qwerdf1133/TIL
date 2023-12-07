package t01_create_thread;

import java.awt.Toolkit;

// 방법 1. Thread를 상속 받아 수행할 작업 재정의
public class BeepThread extends Thread{

	@Override
	public void run() {
		Toolkit tool = Toolkit.getDefaultToolkit();
		for(int i = 0 ; i < 5; i++) {
			System.out.println("BeepThread");
			tool.beep();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		System.out.println("Beep Thread 종료");
	}

}
