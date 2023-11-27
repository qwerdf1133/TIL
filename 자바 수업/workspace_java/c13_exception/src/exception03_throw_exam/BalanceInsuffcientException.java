package exception03_throw_exam;

// 잔고 부족 예외
public class BalanceInsuffcientException extends Exception{
	
	public BalanceInsuffcientException(String message) {
		super(message);
	}

}
