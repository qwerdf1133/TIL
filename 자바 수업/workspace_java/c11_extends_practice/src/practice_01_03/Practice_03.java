package practice_01_03;


public class Practice_03 {

	public static void main(String[] args) {
		// code 작성
		
		// 풀이
		
		int[] numbers = new int[10];
		
		System.out.print("최초의 리스트 : ");
		for(int i = 0; i < numbers.length; i++) {
			// 난수 삽입 및 출력
			numbers[i] = (int) (Math.random() * 100) + 1;
			System.out.print(numbers[i]+" ");
			
			for(int j = 0; j < i; j++) {
				if(numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			} // 정렬
		} // end for
		
		// 정렬된 리스트 출력
		System.out.println();
		System.out.print("정렬된 리스트 : ");
		for(int i : numbers) {
			System.out.print(i+" ");
		} // end 출력
		
		
		
		
		
		
		
//		직접
		/*
		int[] number = new int [10];
		
		for(int i = 0; i < number.length; i++ ) {
			number[i] = (int)(Math.random() * 100) + 1;
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
		for (int i : numbers) {
			System.out.print("[" +i+ "]");
		}
		*/
	}
}
