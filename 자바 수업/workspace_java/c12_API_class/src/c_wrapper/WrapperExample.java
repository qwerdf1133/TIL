package c_wrapper;
/*
 	기본타입을 객체로 사용할 수 있도록
 	연산에 필요한 상수와 기능을 추가하여 묶어놓은 class
 	포장객체 - Wrapper Class
 */

public class WrapperExample {

	public static void main(String[] args) {
		
		// Boxing
		// new keyword는 java 9 version 에서 deprecated
		Integer obj1 = null;
		obj1 = new Integer(100);
		obj1 = new Integer("100");
		obj1 = Integer.valueOf(100);
		obj1 = Integer.valueOf("100");
		
		// 자동 boxing
		obj1 = 100;
		
		// unBoxing
		int i = obj1.intValue();
		
		// 자동 unboxing
		int value = obj1;
		
		// valueOf 문자열 또는 기본타입의 데이터를
		// 해당 타입의 포장 객체로 반환
		Integer obj2 = Integer.valueOf("600");
		System.out.println(obj2.toString());
		
		byte b = 127;
		Byte b1 = Byte.valueOf(b);
		b1 = Byte.valueOf("100");
		b1 = Byte.valueOf((byte)100);
		
		char c = '가';
		Character c1 = Character.valueOf(c);
		byte b2 = 65;
		c1 = Character.valueOf((char)b2);
		// c1 = Character.valueOf("가");
		
		Long l = Long.valueOf("100000");
		
		Float f = Float.valueOf("3.14");
		
		Double d = Double.valueOf("3.141592");
		
		Boolean bool = Boolean.valueOf("0");
		bool = Boolean.valueOf("flase");
		System.out.println(bool);
		bool = Boolean.valueOf("true");
		System.out.println(bool);
		
		// Integer => int 자동 박싱이 연산에 추가
		int obj3 = Integer.valueOf("700");
		System.out.println("obj 3 : " + obj3);
		// parseDateType == 기본타입으로 값을 변환하여 반환
		int obj4 = Integer.parseInt("700");
		System.out.println("obj 4 : " + obj4);
		
		double doubleValue = Double.parseDouble("3.14");
		boolean boolValue = Boolean.parseBoolean("false");
		
		String resultStr = Integer.toBinaryString(10);
		System.out.println("resultStr : " + resultStr);
		int obj5 = Integer.parseInt(resultStr, 10);
		System.out.println("obj5 : " + obj5); // 1010
		int obj6 = Integer.parseInt(resultStr, 2);
		System.out.println("obj6 : " + obj6);
		
		String resultOct = Integer.toOctalString(10);
		System.out.println("resultOct : " + resultOct);
		int obj7 = Integer.parseInt(resultOct, 8);
		System.out.println("obj7 : " + obj7);
		
		String resultHex = Integer.toHexString(10);
		System.out.println("resultHex : " + resultHex);
		int obj8 = Integer.parseInt(resultHex, 16);
		System.out.println("obj8 : " + obj8);
		
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Character.MIN_VALUE);
		System.out.println(Character.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.MAX_VALUE);
		
		System.out.println(Integer.TYPE);
		
		// 각 타입에 맞는 값을 비교하는 method
		int a = Integer.compare(10, 20);
		// 첫번째 매개변수 값이 작으면 음수
		// 같으면 0
		// 두번째 매개변수 값이 작으면 양수
		System.out.println(a);
		
		// test(Character.valueOf('A'));
		// test(Boolean.valueOf("0"));
		// test(new Object());
		test(Integer.valueOf("100"));
		test(Float.valueOf(3.14f));
		test(3.141592); // 자동 boxing
		test(11111111111L);
		test(null);
		
	} // end main
	
	// Number - Byte, Short, Integer, long, Float, Double 부모
	static void test(Number o) {
		if(o != null) {
			System.out.println("test : " + o);
			System.out.println(o.intValue());
			System.out.println(o.longValue());
			System.out.println(o.doubleValue());
			if(o instanceof Integer) {
				System.out.println("int type");
				System.out.println(o.intValue());
			}
				
		}else {
			System.out.println("null은 사용할 수 없습니다");
		}
	}

}
