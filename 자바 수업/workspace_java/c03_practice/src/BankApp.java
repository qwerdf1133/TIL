import java.util.Scanner;

public class BankApp {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// while문 종료 flag true = 계속 실행, false 종료
		boolean isRun = true;
		// 사용자의 예금을 저장할 변수
		
		/*
	 	1. 예금 - 입금할 금액을 입력받아 money 변수에 누적 저장
	 	2. 출금 - 출금할 금액을 입력 받아 money 변수 값에서 출금
	 		   - 단 출금 금액은 예금 금액을 초과할 수 없음.
		    3. 잔액 - money 변수 (입금액)을 출력
		    4. while문 종료 - 프로그램 종
		*/
		
		int money = 0;
		
		
		while(isRun) {
			System.out.println("==========================");
			System.out.println("1.예금|2.출금|3.잔액확인|4.종료");
			System.out.println("==========================");
			System.out.println("번호를 입력해주세요 (1~4) > ");
			int selectNo = sc.nextInt();
			System.out.println("선택 하신 번호는 : " + selectNo + "번 입니다");
			
			
			if(selectNo == 1) {
				System.out.println("입금");
				System.out.println("입금하실 금액을 입력하세요.");
				money = money + sc.nextInt();
				System.out.println(money + "원 입금이 완료되었습니다.");
				
			}else if(selectNo == 2) {
				System.out.println("출금");
				System.out.println("출금하실 금액을 입력하세요.");
				int minus = sc.nextInt();
				if(minus > money) {
					System.out.println("출금 금액이 예금된 금액보다 클 수 없습니다.");
				}else if(minus < money) {
					money = money - minus;
					System.out.println(minus + "원 출금되었습니다.");
				}
				
			}else if(selectNo == 3) {
				System.out.println("잔액확인");
				System.out.println("잔액 : " + money + "원");
				
			}else if(selectNo == 4) {
				System.out.println("종료");
				isRun = false;
			}else {
				System.out.println("없는 번호 입니다.");
			}
			
			
			// switch문 풀이
			  
			/*
			  switch(selectNo) {
				case 1 :
					System.out.println("입금");
					System.out.println("입금하실 금액을 입력하세요.");
					int deposit = sc.nextInt();
					money = money + deposit;
					System.out.println(deposit+"원이 입금 되었습니다.");
					break;
				case 2 : 
					System.out.println("출금");
					System.out.println("출금하실 금액을 입력해주세요.");
					int minus = sc.nextInt();
					if(money < minus) {
						System.out.println("출금금액이 예금된 금액보다 클 수 없습니다.");
						continue;
					}
					money = money - minus;
					System.out.println(minus+"원이 출금되었습니다.");
					break;
				case 3 :
					System.out.println("잔액확인");
					System.out.println("잔액 : " + money +"원");
					break;
				case 4 :
					System.out.println("종료");
					isRun = false;
					break;
				default :
					System.out.println("선택 하신 메뉴 번호는 존재하지않습니다.");
			  }
			 */
			 
			
		} // while 종료
		System.out.println("프로그램 종료");
	}

}
