package c1_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 연결 리스트
 불연속적인 메모리 공간에 데이터들이 연관되며 포인터(참조 주소값)을 통해 각 데이터들이 연결되는 구조
 */

class Board{
	
	String subject;
	String content;
	String writer;
	
	// alt + s + a
	public Board(String subject, String content, String writer) {
		super();
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
	
}

public class LinkedListExample {

	public static void main(String[] args) {
		List<Board> arrayList = new ArrayList<>();
		List<Board> linkedList = new LinkedList<>();
		
		long startTime = 0;
		long endTime = 0;
		
		int size = 1000000;
		
		System.out.println("[ 추가 작업 ] ");
		startTime = System.nanoTime();	// 10억분의 1초
		for(int i = 0; i < size; i++) {
			arrayList.add(0, new Board("제목","내용","작성자"));
		}
		endTime = System.nanoTime();
		System.out.println("array 추가 시간 : " + (endTime - startTime)+"ns");
		
		startTime = System.nanoTime();
		for(int i = 0; i < size; i++) {
			linkedList.add(0, new Board("제목","내용","작성자"));
		}
		endTime = System.nanoTime();
		System.out.println("linked 추가 시간 : " + (endTime - startTime)+"ns");
		
		System.out.println("[ 검색 작업 ]");
		startTime = System.nanoTime();
		for(int i = 0; i < size; i++) {
			arrayList.get(i);
		}
		endTime = System.nanoTime();
		System.out.println("array 검색 시간 : " + (endTime - startTime)+"ns");
		
		startTime = System.nanoTime();
		for(int i = 0; i < size; i++) {
			linkedList.get(i);
		}
		endTime = System.nanoTime();
		System.out.println("linked 검색 시간 : " + (endTime - startTime)+"ns");
		
		
		
		
	}

}










