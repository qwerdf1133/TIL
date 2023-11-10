package c_method;

// Account 계좌 or 회계 장부
public class Account {

	// 최소 입금액
	int minDeposit;
	// 최대 출금액 오늘만 
	int maxWithDraw = 1000000;
	// 잔고
	int balance;
	
	// 입금
	void desposit(int amount) {
		if(amount < minDeposit) {
			System.out.println("입금할 수 있는 금액이 아닙니다");
			return;
		}
		balance = balance + amount;
	}
	
	// 출금
	void withdraw(int amount) {
		int result = balance - amount;
		if(result < 0 || maxWithDraw < amount) {
			System.out.println("출금 할 수 없는 금액입니다");
		}else {
			balance = result;
		}
	}
	
	// 이용자의 잔고 정보를 문자열로 전달
	String showInfo() {
		return "잔고는 : "+ balance + "원 입니다";
	}
}
