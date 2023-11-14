package object_array_guide.account;

public class Account {

	String ano;			// 계좌번호
	String owner;		// 계좌주
	int balance;		// 잔고
	String password;	// 비밀번호
	
	// 기본생성자
	public Account() {}

	// 전체값을 넘겨받는 생성자
	public Account(String ano, String owner, int balance, String password) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
		this.password = password;
	}

	public String toString() {
		return "Account[ ano : "+this.ano+" owner : " + this.owner + " balance : " + this.balance +" ]";
	}	
}




