package practice_06;

/**
 * Bank Class 생성
 * Bank Class 를 상속 받는 BadBank, NormalBank, GoodBank class 작성 
 *
 */

abstract class Bank{
	abstract double getInterestRate();
}

class BadBank extends Bank{

	@Override
	double getInterestRate() {
		return 10;
	}
	
}

class NormalBank extends Bank{

	@Override
	double getInterestRate() {
		return 5;
	}
	
}

class GoodBank extends Bank{

	@Override
	double getInterestRate() {
		return 3;
	}
	
}

public class BankTest {

	public static void main(String[] args) {
		Bank b1 = new BadBank();
		Bank b2 = new NormalBank();
		Bank b3 = new GoodBank();
		
		System.out.println("BadBank의 이자율 : " + b1.getInterestRate());
		System.out.println("NormalBank의 이자율 : " + b2.getInterestRate());
		System.out.println("GoodBank의 이자율 : " + b3.getInterestRate());	
		
	}

}
