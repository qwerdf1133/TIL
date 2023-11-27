package exception01_try_catch;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchExample {

	public static void main(String[] args) {
		System.out.println("Main Start");
		String str = null;
		int[] scores = new int[4];
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("배열에 삽입하려는 인덱스 번호를 입력 > ");
				int index = sc.nextInt();
				System.out.println("입력하려는 값을 작성하시오 > ");
				scores[index] = sc.nextInt();
				System.out.println(str.equals("time"));
			} //catch(RuntimeException e) {}
			catch(InputMismatchException e) {
				System.out.println("정수가 입력되지 않음.");
				sc.next();
				continue;
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("message : " + e.getMessage());
				continue;
			}catch(Exception e) {
				e.printStackTrace();
				break;
			}finally {
				System.out.println(Arrays.toString(scores));
				System.out.println("항상 실행");
			}
			/*
			if(index < 0){
				break;
			}
			*/
		} // end while
		System.out.println("Main End");
	}

}









