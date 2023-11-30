package c9_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= 45; i++) {
			list.add(i);
		}
		System.out.println(list);
		// 섞는다.
		Collections.shuffle(list);
		System.out.println(list);
		
		// 해당 리스트에서 필요한 부분만 짤라서 새로운 list 생성
		// (시작인덱스번호, 개수)
		List<Integer> lotto = list.subList(0, 6);
		System.out.println("=======================");
		System.out.println("lotto : " + lotto);
		
		// 역순 정렬 - 기존에 나열된 순서에서 방향만 바꿈 - 오름차순 내림차순 X
		Collections.reverse(lotto);
		System.out.println("reverse : " + lotto);
		
		// 오름차순 정렬
		Collections.sort(lotto);
		System.out.println(lotto);
		
		System.out.println(Collections.max(lotto));
		System.out.println(Collections.min(lotto));
		
	}

}










