package a_object.hashcode;

public class Key {
	
	int number;

	//number를 넘겨받는 생성자
	public Key(int number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
			Key key = (Key)obj;
			if(this.number == key.number) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
