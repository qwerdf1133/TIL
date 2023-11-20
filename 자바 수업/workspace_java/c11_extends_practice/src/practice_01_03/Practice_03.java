package practice_01_03;


public class Practice_03 {

	public static void main(String[] args) {
		// code 작성
		
		int[] number = new int [10];
		
		for(int i = 0; i < number.length; i++ ) {
			number[i] = (int)(Math.random() * 45) + 1;
			for(int j = 0; j < i; j++) {
				// 중복 제거
				if(number[i] == number[j]) {
					i--;
					break;
				}
			}
		}
		
		System.out.print("최초의 리스트 : ");
		for (int i : number) {
			System.out.printf("[" +i+ "]");
		}
		
		int temp = 0;
		for(int i = 0; i < number.length; i++) {
			for(int j = i + 1; j < number.length; j++) {
				// 앞에 있는 값이 더 클 경우
				
				// 큰수를 뒤로 배치한다.
				if(number[i] > number[j]) {
					temp = number[i];
					number[i] = number[j];
					number[j] = temp;
				}
			}
		} //end sorting
		System.out.println();
		System.out.print("정렬된 리스트 : ");
		for (int i : number) {
			System.out.print("[" +i+ "]");
		}
	}
}
