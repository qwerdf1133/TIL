package array;

/*
 	자료구조 (Data Structure)란
 	데이터를 효율적으로 저장하고 조작하기 위한 방법을 정의한 것
 	즉, 데이터를 저장하는 방법과 이를 조작하는 방법을 제공
 	삽입, 삭제, 검색 등의 연산이 가능해야 함
 	효율적인 메모리 사용과 처리속도를 보상 해야 함
 	구현이 쉽고 이해하기 쉬운 인터페이스를 제공해야 함
 	
 	배열(Array)은 데이터를 저장하는 자료구조의 일종
 	돌일한 자로형의 데이터를 연속된 공간에 순차적으로 나열 한 것
 	배열은 메모리상에서 연속된 공간에 데이터를 저장하며 각 데이터는
 	인덱스(index)라는 숫자로 구분 된다
 	배열은 메모리에 저장될 때 크기가 결정되며 변경할 수 없다
 */

public class UseArrayExample {
	
	public static void main(String[] args) {
		/*
			배열 생성 방법
			1. 배열에 저장할 값이 있을 시
		*/
		// 나열되어 있는 값으로 크기가 결정 되므로 크기를 지정할 필요가 없음
		int[] array = new int[] {10, 20, 30, 40, 50};
		
		// 2. 선언과 동시에 값을 지정할때는 new 연산자를 생략 가능하다.
		int array2[] = {50, 60, 70, 80};
		// int array2[] = {50, 60, 70, true}; // 컴파일 에러
		
		// 선언 이후에 배열 항목을 초기화 할때는 new 연산자를 생략할 수 없다
		int[] array3;
		// array3 = {10, 20, 30};
		array3 = new int[] {10, 20, 30};
		
		// 3. 배열 생성 시에 값이 정해져 있지 않을 때는
		//	  저장할 공간만 생성 가능 하며
		// 	  생성된 각 항목의 공간에는 기본값으로 자동으로 초기화된다.
		//	  정수 - 실수 : 0 | boolean - false | 참조타입 - null
		int[] array4 = new int[5];
		// [0][0][0][0][0]
		//  0  1  2  3  4  ...
		System.out.println(array4);
		// 저장된 항목 위치에 값을 저장
		array4[4] = 10;
		
		int num = array4[4];
		System.out.println(num);
		
		// 아직 배열에 저장될 항목의 크기가 결졍되지 않았을 때는
		// null keyword로 초기화 가능
		int[] array5 = null;
		int[] array6;
		System.out.println(array5);
		// if(array6 == null) {} 
		if(array5 == null) {
			array5 = new int[3];
		}
		System.out.println(array5);
		
		array5[0] = 10;
		array5[1] = 20;
		array5[2] = 30;
		// 크기를 벗어난 인덱스 번호로 접근하면 오류 발생
		// array5[3] = 40;
		int length = array5.length;
		System.out.println("array4의 길이는 : " + length);
		
		// 배열의 길이는 불변 - 변경할 수 없다
		// array5.length = 10;
		System.out.println(array5[array5.length-1]);
		
		for(int i = 0; i < array5.length; i++) {
			System.out.println(array5[i]);
		}
		
		// final keyword가 붙은 변수는 값의 재할당이 불가능 하다.
		final int value = 10;
		// value = 100;
		
		
	}

}
