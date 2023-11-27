package j_parctice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Practice06LocalDateTimeExample {

	public static void main(String[] args) {
		LocalDateTime targetDateTime = LocalDateTime.of(2023, 12, 31, 23, 59, 59);
		System.out.println(targetDateTime);
		targetDateTime = LocalDateTime.parse("2023-12-31T23:59:59");
		System.out.println(targetDateTime);
		targetDateTime = targetDateTime.withYear(1999)
						 .withMonth(12);
		System.out.println(targetDateTime);
		
		DateTimeFormatter patter =
				DateTimeFormatter.ofPattern("yyyy년MM월dd일 E요일 a HH시mm분ss초");
		
		String time = targetDateTime.format(patter);
		System.out.println(time);
		System.out.printf("지정된 시간은 : %S 입니다. %n",time);
	}

}
