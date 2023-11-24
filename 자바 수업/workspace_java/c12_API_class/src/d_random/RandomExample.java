package d_random;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		// Random Class
		// int, double boolean 의 무작위 값을 출력하는 class
		// 객체 생성 시 생성자의 매개변수로 seed값이 결정 되며
		// seed 값이 일치하면 동일한 패턴으로 난수가 발생된다.
		
		// 1 / 1000 초
		long millisTime = System.currentTimeMillis();
		System.out.println(millisTime);
		
		// 10억분의 1초 나노 second(1/1000000000);
		long startTime = System.nanoTime();
		
		// java.util.Random random = new Random();
		Random random = new Random(5);
		for(int i = 0; i < 6; i++) {
			// 0 ~ 45미만의 값을 난수로 발생
			// 0 <= random < n
			int result = random.nextInt(45) + 1;
			System.out.print(result+" ");
		}
		
		random = new Random(System.nanoTime());
		for(int i = 0; i < 10; i++) {
			System.out.println("=================================");
			// true or false
			System.out.println(random.nextBoolean());
			// +Integer.MAX_VALUE -Integer.MIN_VALUE 범위 랜덤한 값
			System.out.println(random.nextInt());
			// random.nextInt(n)
			// 0 <= ~ < n
			System.out.println(random.nextInt(45));
			// 0.0 <= ~ < 1.0
			System.out.println(random.nextDouble());
		}
		
		long endTime = System.nanoTime();
		double seconds = (endTime - startTime);
		System.out.println("seconds : " + (seconds / 1000000000.0));
		
		/*
		 	Math, Formatter(3개), Date, Calendar, 
		 	LocalDateTime(3개), Arrays, Objects
		 */
		Integer i = new Integer(10);
		
		Integer i1 = new Integer(10);
		System.out.println(i == i1);
		
		Integer i2 = Integer.valueOf(10);
		Integer i3 = Integer.valueOf(10);
		
		System.out.println(i2 == i3);
		
	}

}













