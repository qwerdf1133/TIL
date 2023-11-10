package c_method;

public class AccountManager {
	
	public static void main(String[] args) {
		Account choi = new Account();
		String result = choi.showInfo();
		System.out.println(result);
		choi.desposit(10000000);
		result = choi.showInfo();
		System.out.println(result);
		choi.withdraw(15000);
		result = choi.showInfo();
		System.out.println(result);
		
		Account um = new Account();
		um.desposit(1000);
		result = um.showInfo();
		System.out.println(result);
		um.withdraw(1000000000);
		um.desposit(2000);
		
		result = choi.showInfo();
		System.out.println("choi : " + result);
		result = um.showInfo();
		System.out.println("um : " + result);
	}

}
