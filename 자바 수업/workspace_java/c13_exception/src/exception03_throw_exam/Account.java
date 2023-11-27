package exception03_throw_exam;

public class Account {
	
	// 잔고
	private long balance;
	
	// 입금
	public void deposit(int money) throws BalanceInsuffcientException {
		if(money <= 0) {
			String message = "입금할 금액이 없거나 음수 일 수 없습니다.";
			throw new BalanceInsuffcientException(message);
		}
		balance += money;
	}
	
	// 출금
	public void withdraw(int money) throws BalanceInsuffcientException {
		if(balance < money) {
			String message = "잔고 부족 오류 : "+(money - balance)+"원 모자람";
			// return;
			throw new BalanceInsuffcientException(message);
			
		}
		balance -= money;
	}

	@Override
	public String toString() {
		return "Account [잔고는 " + balance + "원]";
	}

}
