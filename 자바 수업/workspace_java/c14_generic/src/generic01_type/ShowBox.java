package generic01_type;

/*
 	E : 요소 (Element) - 항목 요소
 	K : Key - 키
 	V : value - 값
 	N : Number
 	T : Type - 타입
 	S,U,V : 두번째, 세번째, 네번째 선언된 타입
 */
public class ShowBox<T> {
	
	private T fruit;

	public T getFruit() {
		return fruit;
	}

	public void setFruit(T fruit) {
		this.fruit = fruit;
	}

}
