package guide_answer.practice01;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample {

	/**
	 *  1. Scanner 클래스를 사용하여 6개 학점('A' 'B' 'C' 'D' 'F')을 
	 *  문자열로 입력받아 공백을 기준으로 알파벳을 분리 한 후 ArrayList에 저장하고, 
	 *  ArrayList를 검색하여 학점을 
	 *  점수(A=4.0, B=3.0, C=2.0, D=1.0, F=0)로 변환하여 
	 *  평균을 출력하는 프로그램을 작성하시오.
   		- 평균은 반올림하여 소수점 2번째 자리까지 표현
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("6개의 학점을 공백으로 분리 입력(A/B/C/D/F) >>");
		String value = sc.nextLine();
		// 합계
		double total = 0;
		double avg = 0.0;
		
		// 코드 작성 
		// 1. String.split("구분자")
		// 2. StringTokenizer("구분자")
		String[] numbers = value.split(" ");
		System.out.println(Arrays.toString(numbers));
		
		List<String> list = new ArrayList<>();
		for(String s : numbers) {
			list.add(s);
		}
		System.out.println(list);
		
		// 배열을 리스트로 변환
		list = Arrays.asList(numbers);
		
		for(int i = 0; i < list.size(); i++) {
			String score = list.get(i);
			switch(score) {
				case "A" :
					total = total + 4;
					break;
				case "B" :
					total = total + 3;
					break;
				case "C" :
					total = total + 2;
					break;
				case "D" :
					total += 1;
					break;
			}
		}
		
		// 평균
		avg = total / list.size();
		DecimalFormat df = new DecimalFormat("#.##");
		String result = df.format(avg);
		System.out.println("평균은 : " + result);
		System.out.printf("평균은 %.2f %n",avg);
		System.out.println("시스템 종료");
	}

}








