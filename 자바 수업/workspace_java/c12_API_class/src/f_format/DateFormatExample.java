package f_format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatExample {

	public static void main(String[] args) {
		// @since 1.0
		Date date = new Date();
		System.out.println(date.toString());
		// @deprecated 1.1
		int year = date.getYear();
		int month = date.getMonth()+1;
		int day = date.getDate();
		System.out.println(year+"년"+month+"월"+day+"일");
		
		// @since 1.1		
		SimpleDateFormat sdf = new SimpleDateFormat();
		String now = sdf.format(date);
		System.out.println(now);
		
		sdf = new SimpleDateFormat("yyyy-MM-dd E요일 a KK:mm:ss.SSS D");
		now = sdf.format(date);
		System.out.println(now);
		
		
	}

}









