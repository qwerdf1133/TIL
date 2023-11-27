package generic03_method;

public class MethodExample {
	
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<>();
		box.setType(t);
		return box;
	}

	public static void main(String[] args) {
		Box<String> box1 = MethodExample.<String>boxing("사과");
		
		Box<String> box2 = boxing("오렌지");
		
		// Box<Integer> box = boxing(100);
		Box<Integer> box = MethodExample.<Integer>boxing(100);
		int result = box.getType();
		System.out.println(result);
	}

}
