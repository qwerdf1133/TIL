package generic.exam05;

public class RunClass {

	public static void main(String[] args) {
		ArrayTest<String> array = new ArrayTest<>(3);
		System.out.println(array);
		array.add("최기근");
		array.add("유관순");
		array.add("신사임당");
		array.add("최기근");
		
		System.out.println(array.size());
		System.out.println(array);
		
		array.remove("최기근");
		System.out.println(array.size());
		System.out.println(array);
		
		array.remove("최기근");
		System.out.println(array.size());
		System.out.println(array);
		
	}

}
