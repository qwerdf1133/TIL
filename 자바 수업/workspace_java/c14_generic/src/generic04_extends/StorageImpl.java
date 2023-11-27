package generic04_extends;
/*
 	Storage Interface 구현 객체
 */

public class StorageImpl<E> implements Storage<E>{
	
	private E[] array;
	
	@SuppressWarnings("unchecked")
	public StorageImpl(int capacity) {
		// array = new E[capacity];
		array = (E[]) new Object[capacity];
	}

	@Override
	public void add(E item, int index) {
		array[index] = item;
	}

	@Override
	public E get(int index) {
		return array[index];
	}

}
