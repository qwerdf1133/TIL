import java.util.Scanner;

public class Practice03ControlTest {
	
	public static void main(String[] args) {
		
		int odd = 0; // 홀수의 총합을 저장할 변수
		for(int i = 1; i <= 100; i+=2) {
			System.out.println(i+" ");
			odd = odd + i;
		}
		System.out.println();
		System.out.println("홀수의 총합은 : " + odd);
		
		//짝수의 총합
		int even = 0;
		for(int i = 100; i >= 1; i -= 2) {
			System.out.println(i+" ");
			even += i;
		}
		System.out.println("\n짝수의 총합은 : " + even);
		
		// 1 ~ 50 까지의 정수 중
		// 홀수, 짝수, 전체 총 합계를 구하시오.
		int sum; // 전체 합계를 저장할 변수
		sum = even = odd = 0;
		
		for(int i = 1; i <= 50; i++) {
			
			if(i % 2 == 0) {
				// 짝수일 경우 even 누적 합계 저장
				even += i;
			}else {
				// 홀수일 경우 odd 누적 합계 저장
				odd = odd + i;
			}
			// 전체 값을 누적 저장
			sum = sum + i;
		}
		// 결과 출력
		// ...
		
		/*
		 (사다리꼴의 넓이) = ((윗변+아랫변) * 높이 ) / 2
		 */
		int top = 5;
		int bottom = 10;
		int height = 7;
		double area = ((top + bottom) * height) / 2.0;
		System.out.println(area);
		
		
		/*
		 문자열 형태로 사원명을 입력받아 변수에 저장하고 , 시급 과 근무 시간을 정수로 입력받아 아래와 같이 
		 급여명세서가 출력 될 수 있도록 코드를 작성하시오. 
		 - 급여금액 : 시급 * 근무 시간
		 - 공제합계 : 급여금액의 3%
		 - 실지급액 : 급여금액 – 공제합계
		 - 정수로 계산 
		 
		 */
		
		// ctrl + shift + o - auto import
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사원명을 입력해 주세요 > ");
		String 사원명 = sc.next();
		
		System.out.println("시급을 입력해 주세요 > ");
		int 시급 = sc.nextInt();
		
		System.out.println("근무시간을 입력해 주세요 > ");
		int 근무시간 = sc.nextInt();
		
		int 급여금액 = 시급 * 근무시간;
		int 공제금액 = 급여금액 * 3 / 100; // 3%
		// 공제금액 = 급여금액 * 0.03;
		int 실지급액 = 급여금액 - 공제금액;
		System.out.println("== 급여명세서 ==");
		System.out.println("사원명 : " + 사원명);
		System.out.println("급여금역 : " + 급여금액);
		System.out.println("공제금액 : " + 공제금액);
		System.out.println("실지급액 : " + 실지급액);
	}

}
