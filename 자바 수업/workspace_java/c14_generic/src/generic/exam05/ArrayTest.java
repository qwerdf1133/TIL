package generic.exam05;

import java.util.Arrays;

/**
 *  ArrayTest class를 완성하시오.
 */
public class ArrayTest<E>{
	
	private int capacity;		// 저장 가능한 배열의 크기
	private int length;			// 배열에 저장된 실제 항목의 크기
	private E[] array;			// generic Type 배열
	
	public ArrayTest() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayTest(int capacity) {
		this.capacity = capacity;
		array = (E[])new Object[capacity];
	}
	
	public void add(E e) {
		if(length < capacity) {
			// 저장공간이 있음
			for(int i = 0; i < capacity; i++) {
				if(array[i] == null) {
					array[i] = e;
					break;
				}
			}
		}else {
			// 저장공간이 없음
			this.array = Arrays.copyOf(this.array, ++capacity);
			this.array[capacity - 1] = e;
		}
		this.length++;
	}
	
	public void remove(E e) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null && array[i].equals(e)) {
				E[] newArray = Arrays.copyOf(this.array, array.length-1);
				// sysotem.arraycopy(원본배열,시작인덱스,복제할배열,시작인덱스,복제할길이);
				System.arraycopy(this.array,i+1,newArray,i, (array.length-1) -i);
				this.array = newArray;
				length--;
				capacity--;
				break;
			}
		}
	}
	
	/*
	// 배열에 항목 추가
	public void add(E e) {
		// 추가할 저장 공간이 있는가?
		if(this.length >= this.capacity) {
			// 저장할 공간이 없음. - 새로운 배열 생성
			@SuppressWarnings("unchecked")
			E[] newArray = (E[])new Object[capacity + 1];
			// capacity field의 값을 새로운 배열 크기로 지정
			this.capacity = newArray.length;
			// 기존 배열의 항목들을 새로운 배열에 복사
			for(int i = 0; i < this.array.length; i++) {
				newArray[i] = this.array[i];
			}
			// 새로운 배열 마지막 인덱스에 매개변수로 전달된 항목의 값을 추가
			newArray[capacity-1] = e;
			this.array = newArray;
		}else {
			// 저장 공간이 남아 있음. - 기존 배열에 값 추가
			for(int i = 0; i < capacity; i++) {
				if(this.array[i] == null) {
					this.array[i] = e;
					break;
				}
			}
		}
		
		// 배열에 저장된 항목 개수 1 증가
		this.length++; 
	}
	
	// 배열에서 매개변수로 넘겨받은 값과 일치하는 항목을 찾아서 삭제
	public void remove(E e) {
		for(int i = 0; i < capacity; i++) {
			// 원본 배열에서 동일한 값을 가지고 있는 항목을 검색
			if(array[i] != null && array[i].equals(e)) {
				// 동일한 항목을 가진 배열을 찾았으면 크기가 1 감소된 배열 생성
				@SuppressWarnings("unchecked")
				E[] newArray = (E[])new Object[--capacity];
				// [1][2][3][4][5];
				// [1][2][4][5];
				for(int j = 0; j < capacity; j++) {
					if(j < i) {
						newArray[j] = this.array[j];
					}else {
						newArray[j] = this.array[j+1];
					}
				}
				this.array = newArray;
				this.length--;
				break;
			}
		} // end for
	}
	*/
	// ArrayTest가 저장하고 있는 배열의 항목을 문자열로 반환
	public String toString() {
		return Arrays.toString(array);
	}
	
	// 실제 배열에 저장된 항목의 크기를 반환
	public int size() {
		return this.length;
	}
}







