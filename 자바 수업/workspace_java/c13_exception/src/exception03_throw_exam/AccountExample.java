package exception03_throw_exam;

import java.util.Scanner;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. 입금|2.출금|3.확인|4.종료");
			System.out.println("메뉴 번호 입력 > ");
			int num = sc.nextInt();
			switch(num) {
			case 1 :
				System.out.println("입금할 금액을 입력해주세요 > ");
				int money = sc.nextInt();
				try {
					account.deposit(money);
				} catch (BalanceInsuffcientException e) {
					System.out.println(e.getMessage());
					continue;
				}
				System.out.println("입금이 완료되었습니다");
			case 2 : 
				System.out.println("출금할 금액을 입력해주세요 > ");
				money = sc.nextInt();
				
				try {
					account.withdraw(money);
				} catch (BalanceInsuffcientException e) {
					System.out.println(e.getMessage());
					continue;
				}
				
				System.out.println("출금이 완료되었습니다.");
			case 3 :
				System.out.println(account);
				break;
			default :
				System.out.println("프로그램 종료");
				return;
			} // end switch
			
		} // end while

	} // end main

}
