package j_parctice;

import java.util.Arrays;

public class Practice02CopyOfRangeExample {

	public static void main(String[] args) {
		int[] array1 = {10,20,30,40,50};
		
		// 1번째 인덱스부터 3번째 인덱스 이전까지 복제한 새로운 배열 생성
		int[] array2 = Arrays.copyOfRange(array1, 1, 3);
		System.out.println(Arrays.toString(array2));
		
		
	}

}
