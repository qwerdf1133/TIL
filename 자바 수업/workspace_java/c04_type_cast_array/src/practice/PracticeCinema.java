package practice;

import java.util.Scanner;

public class PracticeCinema {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char c1 = 'A';
		final int size = 10;
		int[] seatsw = new int[size];
		int[] seatsh = new int[size];
		
		//while(true) {
			System.out.println("              SCREEN");
			for(int i = 0; i < size; i++) {
				System.out.print("["+(i+1)+"]");
			}
			System.out.print(" [행]");
			System.out.println();
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					System.out.print("[□]");
					if(j > 8) {
						System.out.println(" ["+(char)(c1+i)+"열]");
					}
				}
			}
			
		//}
		
		
		
	}

}
