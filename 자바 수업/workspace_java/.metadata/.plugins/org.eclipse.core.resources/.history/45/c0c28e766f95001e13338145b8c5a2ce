package t04_sync;

public class WithDrawTask implements Runnable{

	Account account;
	
	public WithDrawTask(Account account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		
		while(account.getBalance() > 0) {
			// 1000 ~ 5000
			int money = (int)(Math.random() * 5 + 1) * 1000;
			boolean isDenied = false;
			synchronized (account) { // lock
				isDenied = account.withDraw(money);
			}
			
			if(isDenied) {
				System.out.printf(
					"%s 출금 :  %d원 남은 금액 : %d원 %n",
					Thread.currentThread().getName(),
					money,
					account.getBalance()
				);
			}else {
				System.out.println("출금 금액 부족 - 거부");
			}
		}// end  while
		
	} // end run
	
}















