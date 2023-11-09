package practice;

import java.util.Scanner;

public class ArrayPractice {
	
	public static void main(String[] args) {
		// 배열의 선언과 동시에 초기화
		// new 연산자 생략가능
		int[] arr = new int[]{10, 20, 30, 50, 3, 60, -3};
		
		// arr 배열 중에서 값이 60인 곳의 인덱스 번호를 출력하시오
		for(int i = 0; i < arr.length; i++) {
			// System.out.print(arr[i]+" ");
			if(arr[i] == 60) {
				System.out.println("60은 "+i+" 인덱스에 위치하고 있습니다");
			}
		}
		
		// arr 배열의 인덱스 번호가 3인 곳은 출력하지 말고, 나머지만 출력해보자.
		for(int i = 0; i < arr.length; i++) {
			if(i != 3) {
				System.out.println(arr[i]);
			}
		}
		
		System.out.println("=====================================");
		
		/*
		 	arr 배열 안의 변경하고 싶은 값의 인덱스 번호를 입력받아, 그 값을 1000으로 변경해보자.
			예) 입력받은 인덱스 번호 : 3
	        {10, 20, 30, 1000, 3, 60, -3}
		*/
		Scanner sc = new Scanner(System.in);
		System.out.println("변경할 인덱스 번호를 입력하세요 > ");
		int index = sc.nextInt();
		System.out.println("입력한 인덱스 번호는 : "+ index);
		// 해당되는 인덱스 번호를 가진 항목의 값을 1000으로 변경하고
		// 변경 된 배열의 각 항목의 값을 출력
		arr[index] = 1000;
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		/*
			인덱스 번호 2개를 입력받아, 그 값을 서로 바꿔보자.
	    	예) 인덱스: 1    인덱스: 2
	        {10, 30, 20, 50, 3, 60, -3}
		*/
		
		System.out.println("변경할 첫번째 인덱스 번호를 입력하세요");
		int index1 = sc.nextInt();
		
		System.out.println("변경할 두번째 인덱스 번호를 입력하세요");
		int index2 = sc.nextInt();
		
		/*
		arr[1] = arr[2];
		arr[2] = arr[1];
		*/
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
		
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
