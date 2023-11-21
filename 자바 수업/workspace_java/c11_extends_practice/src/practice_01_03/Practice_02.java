package practice_01_03;


public class Practice_02 {

	public static void main(String[] args) {

		int[] lotto = new int[6];
		
		
		// 코드 수정 및 작성

		// 풀이
		/*
		int number = (int) (Math.random() * 45 + 1);
		lotto[0] = number;
		
		for(int i = 1; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);
			for(int j = 0; j < lotto.length; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
				
				if(lotto[i] < lotto[j]) {
					number = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = number;
				}
			}
		}
		*/
		
//		/* 직접 한거
		for(int i = 0; i < lotto.length; i++ ) {
			lotto[i] = (int)(Math.random() * 45) + 1;
			for(int j = 0; j < i; j++) {
				// 중복 제거
				if(lotto[i] == lotto[j]) {
					i--;
					break;
					
				}
			}
		}
		
		int temp = 0;
		for(int i = 0; i < lotto.length; i++) {
			for(int j = i + 1; j < lotto.length; j++) {
				// 앞에 있는 값이 더 클 경우
				
				// 큰수를 뒤로 배치한다.
				if(lotto[i] > lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		} //end sorting
 
//	 	*/
		
		// 결과 출력 코드 수정 x
		System.out.println("[ 결과 ]");
		for (int i : lotto) {
			System.out.print("[" +i+ "]");
		}
	}
}
