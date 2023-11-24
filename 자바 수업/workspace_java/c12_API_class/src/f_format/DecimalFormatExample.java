package f_format;

import java.text.DecimalFormat;

public class DecimalFormatExample {

	public static void main(String[] args) {
		
		double num = 1234567.849;
		// 0 or #
		DecimalFormat df = new DecimalFormat("0");
		String str = df.format(num);
		System.out.println("0 : "+str);
		
		df = new DecimalFormat("0.0");
		str = df.format(num);
		System.out.println("0.0 : " + str);
		df.applyPattern("0.00");
		str = df.format(num);
		System.out.println("0.00 : " + str);
		
		// 10진수의 남은 자리를 0으로 채움
		df.applyPattern("00000000000000.00");
		str = df.format(num);
		System.out.println("00000000000000.00 : " + str);
		
		// 10진수의 남은 자리를 0으로 채우지 않음
		df.applyPattern("##############.##");
		str = df.format(num);
		System.out.println("##############.## : " + str);
		
		df.applyPattern("#,###.#");
		str = df.format(num);
		System.out.println("#,###.# : " + str);
		
	}

}











