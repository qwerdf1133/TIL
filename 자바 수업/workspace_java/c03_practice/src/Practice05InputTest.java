import java.util.Scanner;

public class Practice05InputTest {
	
	public static void main(String[] args) {
		/*
		 사용자에게 5개의 정수를 입력받아 sum 변수에 저장하고 
		 그 값을 통해 평균을 정수로 출력하는 소스코드를 작성하시오. (sum / 5)
		 */
		
		Scanner sc = new Scanner(System.in);
		// 평균 = 총 합계 / 항목개수
		// 총 합계
		int sum = 0;
		/*
		int score1 = 0, score2 = 0, score3 = 0, score4 = 0, score5 = 0;
		System.out.println("성적을 입력해 주세요");
		score1 = sc.nextInt();
		
		System.out.println("성적을 입력해주세요");
		score2 = sc.nextInt();
		*/
		for(int i = 0; i < 5; i++) {
			System.out.println("성적을 입력해주세요 : ");
			sum = sum + sc.nextInt();
		}
		
		int avg = sum / 5;
		System.out.println("평균 성적은 : " + avg + "입니다.");
		
		
		/*
		 다음은 사용자에게 정수 값을 입력 받아 학점을 확인 하는 애플리케이션의 실행 결과물이다. 
		 아래와 같이 실행 될 수 있도록 소스코드를 작성하세요.(단, while문과 조건문을 이용할 것.)
		 60점 미만 또는 사용할 수 없는 점수면 반복문 탈출
		 */
		boolean isRun = true;
		
		while(isRun) {
			System.out.println("점수를 입력해주세요");
			int score = sc.nextInt();
			char grade = 'F';
			if(score <= 100 && score >= 90) {
				grade = 'A';
			}else if(score <= 89 && score >= 80) {
				grade = 'B';
			}else if(score <= 79 && score >= 70) {
				grade = 'C';
			}else if(score <= 69 && score >= 60) {
				grade = 'D';
			}else {
				grade = 'F';
				isRun = false;
			}
			System.out.printf("%c학점입니다. \n",grade);
			
			
			
			
			
			
		} // end while
		
	} // end main

}
