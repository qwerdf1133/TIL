package interface_default;

public class HPPrinter implements Printable{
	
	@Override
	public void print() {
		System.out.println("HP 프린터기가 출력합니다.");
	}

}
