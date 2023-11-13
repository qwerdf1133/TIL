package f_object_array;

import java.util.Scanner;

public class StudentManagement {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Student[] students = null;
		
		
		menu : while(true) {
			System.out.println("=====================================");
			System.out.println("1.학생수|2.정보입력|3.정보확인|4.분석|5.종료");
			System.out.println("=====================================");
			System.out.println("메뉴 번호를 입력해 주세요 > ");
			int selectNo = sc.nextInt();
			
			/*
			 1. 학생수를 입력받아 Student 객체가 저장될 students배열 생성 
			    - 입력 받은 학생 수 만큼 
			 2. 생성된 students 배열의 항목 수만큼 학생의 정보를 입력받아 저장
			    - 학번(int), 이름(String), 점수(int)
			 3. students 배열에 저장된 학생들의 정보(field data)를 출력
			 4. 1. students 배열에 저장된 학생들의 점수를 전체합계, 평균을 구해서 출력
			    2. students 배열에 저장된 학생들의 점수 중에서 
			       최고 득점자 이름, 최저 득점자 이름 출력
			 5. 종료      
			 */
			
			switch(selectNo) {
				case 1 :
					System.out.println("학생 수 입력 : ");
					
					int stuCount = sc.nextInt();
					
					students = new Student[stuCount];
					System.out.println("등록할 학생 수는 " +students.length);
					break;
				case 2 : 
					System.out.println("학생 정보 입력");
					// 배열에 저장될 Student 객체 마다, 학번, 이름, 점수를 입력받아 저장
					// [null] [null] [null] ...
					// [Student 객체] ... 
					for(int i = 0; i < students.length; i++) {
						
						// 학번은 1에서 부터 순차적으로 등록
						int num = i + 1;
						System.out.println(num+"번째 학생 정보 입력");
						System.out.println("학생의 이름을 입력해 주세요 > ");
						String name = sc.next();
						
						System.out.println("학생의 점수를 입력해 주세요 > ");
						int score = sc.nextInt();

						Student stu = new Student(num, name, score);
						/*
						Student stu = new Student();
						students[i].number = num;
						students[i].name = name;
						students[i].score = score;
						*/
						students[i] = stu;
					}
					break;
				case 3 : 
					System.out.println("학생 정보 확인");
					// 배열에 저장된 Student 학생정보 출력
					for(Student s : students) {
						System.out.println(s.getInfo());
					}
					break;
				case 4 : 
					System.out.println("학생 정보 분석");
					// 전체합계, 평균, 최고, 최저 득점자 이름
					int total = 0;
					double avg = 0;
					// 최고 최저 점수를 가진 학생 정보를 저장
					Student stuMax, stuMin;
					stuMax = stuMin = students[0];
					// 배열에 저장된 학생의 점수를 순회하며 확인
					for(int i = 0; i < students.length; i++) {
						int score = students[i].score;
						total += score;
						
						// stuMin에 저장된 학생의 점수보다 현재 학생의 점수가 크면
						// stuMin에 현재 학생의 정보를 저장
						if(stuMax.score < score) {
							stuMax = students[i];
						}
						// stuMin에 저장된 학생의 점수보다 현재 학생의 점수가 작으면
						// stuMin에 현재 학생의 정보를 저장
						if(stuMin.score > score) {
							stuMin = students[i];
						}
					} // end for
					
					System.out.println("전체합계 : " + total);
					avg = total / students.length;
					System.out.println("평균점수 : " + avg);
					System.out.println("최고득점자 : " + stuMax.name);
					System.out.println("최저득점자 : " + stuMin.name);
					
					break;
				case 5 : 
					System.out.println("프로그램 종료");
					break menu;
				default : 
					System.out.println("사용할 수 없는 번호입니다.");
			} // end switch
		} // end while
	} // end main
} // end class
