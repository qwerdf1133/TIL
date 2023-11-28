package generic.exam01;

public class Container<T>{
	
	private T t;
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}

}
