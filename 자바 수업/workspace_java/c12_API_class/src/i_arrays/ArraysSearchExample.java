package i_arrays;

import java.util.Arrays;

public class ArraysSearchExample {

	public static void main(String[] args) {

		// search - 지정된 값이 배열의 몇번째 index에 존재하는지 검색
		int[] scores = {1, 10, 5, 7, 9};
		//              0   1  2  3  4
		//              -1 -2 -3 -4 -5 -6 
		Arrays.sort(scores);
		// 이진 탐색 트리 - 비교할 대상을 양분하여 검색
		int index = Arrays.binarySearch(scores, 10);
		System.out.println("찾은 인덱스 : " + index);
		index = Arrays.binarySearch(scores, 8);
		System.out.println("찾은 인덱스 : " + index);
	}

}






