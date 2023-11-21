package a_object.finalize;

import java.util.Scanner;

public class FinalizeExample {
	
	public static void main(String[] args) {
		Counter counter = null;
		for(int i = 1; i <= 50; i++) {
			counter = new Counter(i);
			System.gc();
		}
		System.out.println("입력대기");
		Scanner sc = new Scanner(System.in);
		String result = sc.next();
		System.out.println(result);
		
		Object obj = new Object();
		
	}
}
	