package i_arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortExample {
	
	public static void main(String[] args) {
		
		int[] scores = {100,99,98,60,97};
		
		// sorting == 정렬, 분류
		// 오름 차순 정렬
		Arrays.sort(scores,2,4);
		// {100,99,98,60,97};
		System.out.println(Arrays.toString(scores));
		
		Arrays.sort(scores);
		System.out.println(Arrays.toString(scores));
		
		String[] names = {"홍길동","박종현","김규민","이준호"};
		System.out.println(Arrays.toString(names));
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		
		Arrays.sort(names,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
			
		});
		
		System.out.println(Arrays.toString(names));
		
		// fill - 1번쨰 인덱스 부터 3번째 인덱스 이전가지 
		// 배열의 값을 매개변수로 전달한 값으로 채운다.
		Arrays.fill(names, 1, 3, "최기근");
		System.out.println(Arrays.toString(names));
		
		// 모든 항목을 null로 채운다
		Arrays.fill(names, null);
		System.out.println(Arrays.toString(names));
		
	}

}
