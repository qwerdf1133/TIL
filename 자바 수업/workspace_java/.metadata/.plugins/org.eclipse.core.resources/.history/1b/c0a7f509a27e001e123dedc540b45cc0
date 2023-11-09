package practice;

import java.util.Scanner;

public class TheaterReserve {
	
	public static void main(String[] args) {
		
		final int size = 10;
		
		int[] seats = new int[size];
		
		Scanner sc = new Scanner(System.in);	
		
		while(true) {
			System.out.println("------------------------");
			for (int i = 0; i < size; i++) {
				System.out.print(i+1 +" ");
			}
			System.out.println("\n------------------------");
			for(int i : seats) {
				System.out.print(i+" ");
			}
			System.out.println("\n------------------------");
			System.out.print("원하시는 좌석번호를 입력하세요. (종료는 -1)");
			int seatNum = sc.nextInt();
			System.out.println("선택하신 번호는 " + seatNum);
			
			if(seatNum == -1) {
				System.out.println("프로그램 종료");
				break;
			}
			
			// 입력한 좌석 번호가 1보다 작거나 10보다 크면
			if(seatNum < 1 || seatNum > 10) {
				System.out.println("선택 할 수 없는 자리입니다.");
				continue;
			}
			
			// seatNum == 1 확인할 인덱스 번호는 0
			// seatNum == 10 확인할 인덱스 번호 9
			
			if(seats[seatNum-1] == 0) {
				seats[seatNum-1] = 1;
				System.out.println("예약이 완료 되었습니다");
			}else {
				System.out.println("이미 예약이 완료된 자리입니다");
			}
		}
	}

}
