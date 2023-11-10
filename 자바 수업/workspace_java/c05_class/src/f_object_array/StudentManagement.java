package f_object_array;

import java.util.Scanner;

public class StudentManagement {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Student[] students = null;
		
		while(true) {
			System.out.println("====================================");
			System.out.println("1.학생수|2.정보입력|3.정보확인|4.분석|5.종료");
			System.out.println("====================================");
			System.out.println("메뉴 번호를 입력해 주세요 > ");
			int selectNo = sc.nextInt();
			
			/*
			 1. 학생수를 입력받아 Student 객체가 저장될 students 배열 생성
			 	- 입력 받은 학생 수 만큼 
	 		 2. 생성된 students 배열의 항목 수만큼 학생의 정보를 입력받아 저장
	 		 	- 학번(int), 이름(String), 점수(int)
	 		 3. students 배열에 저장된 학생들의 정보(field data)를 출력
	 		 4. students 배열에 저장된 학생들의 점수를 전체합계, 평균을 구해서 출력
	 		 	students 배열에 저장된 학생들의 점수 중에서 최고 득점자 이름, 최저 득점자 이름 출력
 		 	 5. 종료
			*/
			
			if(selectNo == 1) {
//				1. 학생수를 입력받아 Student 객체가 저장될 students 배열 생성
//			 	- 입력 받은 학생 수 만큼 
				System.out.println("학생 수를 입력해주세요.");
				int stu = sc.nextInt();
				System.out.println("입력하신 학생 수는 "+stu+" 명 입니다.");
				Student[] studnets = new Student[stu]; 
			}else if(selectNo == 2) {
//				2. 생성된 students 배열의 항목 수만큼 학생의 정보를 입력받아 저장
//	 		 	- 학번(int), 이름(String), 점수(int)
				for(int i = 0; i < students.length; i++) {
					System.out.println("학번을 입력해주세요.");
					System.out.println("이름을 입력해주세요.");
					System.out.println("점수를 입력해주세요.");
				}
				
			}else if(selectNo == 3) {
//				3. students 배열에 저장된 학생들의 정보(field data)를 출력
				
			}else if(selectNo == 4) {
//				4. students 배열에 저장된 학생들의 점수를 전체합계, 평균을 구해서 출력
//	 		 	students 배열에 저장된 학생들의 점수 중에서 최고 득점자 이름, 최저 득점자 이름 출력
				
			}else if(selectNo == 5) {
//				 5. 종료
				System.out.println("종료");
				break;
				
			}else {
				
			}
			
			
		}
		
	}

}
