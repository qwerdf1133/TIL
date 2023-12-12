package t05_state_control.stop;

import java.util.Scanner;

class PrintThread extends Thread{
	
	private boolean isRun = true;
	
	public void setIsRun(boolean isRun) {
		this.isRun = isRun;
	}
	
	@Override
	public void run() {
		long sum = 0;
		int i = 0;
		while(isRun) {
			sum += i;
			i++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
		
		System.out.println("자원정리 : " + sum);
		System.out.println("스레드 종료");
	}
	
}


public class StopFlagExample {

	public static void main(String[] args) {
		PrintThread t = new PrintThread();
		t.start();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("출력할 문자열을 입력해 주세요 q는 종료");
			String answer = sc.next();
			System.out.println(answer);
			if(answer.equals("q")) {
				// t.stop();
				t.setIsRun(false);
				break;
			}
		} // end while
		System.out.println("메인 종료");
		sc.close();
	} // end main

}



















