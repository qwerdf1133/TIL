package j_parctice;

import java.util.*;

public class Practice01ArraysRandomExample {
	
	public static void main(String[] args) {
		/*
		 1~100까지의 난수를 발생해 int형 배열에 10개의 값을 담고 아래와 같이 출력 후 
		 오름차순으로 정렬해서 출력 될 수 있도록 코드를 작성하시오.
		 (Random class 와 Arrays class 사용)
		 */
		
		int[] arrays = new int[10]; // 10개의 정수값을 저장할 배열
		
		Random random = new Random();	// 난수를 발생 시킬 class 생성
		for(int i = 0; i < arrays.length; i++) {
			arrays[i] = random.nextInt(100) + 1;
		}
		System.out.println("최초의 리스트 : " + Arrays.toString(arrays));
		Arrays.sort(arrays);
		System.out.println("정렬된 리스트 : " + Arrays.toString(arrays));
	}

}
