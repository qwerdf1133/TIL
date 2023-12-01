package guide_answer.practice04;

import java.util.Scanner;
import java.util.TreeSet;

public class SetExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 코드 작성 - Byte, Short, Integer, Long
		TreeSet<Integer> set = new TreeSet<>();
		System.out.println("정수(-1이 될때 까지) 입력 ");
		
		while(true) {
			// set 저장할 정수값 입력
			int num = sc.nextInt();
			
			// 정수값 입력 중단
			if(num == -1) break;
			
			set.add(num); // set에 입력받은 정수값 추가
			
		} // end while
		
		// set에 항목이 존재하는지 체크
		// if(set.size() == 0) {
		if(set.isEmpty()) {
			System.out.println("수가 하나도 없음");
			System.out.println("시스템 종료");
			return;
		}
		
		// Integer는 treeset에 저장될 때 오름 차순으로 정렬되어 저장
		int min = set.first();		// 최소값
		int max = set.last();		// 최대값
		System.out.println("가장 큰 수는 : " + max);
		System.out.println("가장 작은 수는 : " + min);
		System.out.println(set);
		System.out.println("시스템 종료");
		
		sc.close();
	}

}











