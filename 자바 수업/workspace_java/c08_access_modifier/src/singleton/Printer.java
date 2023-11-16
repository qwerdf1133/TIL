package singleton;
/**
 * Singleton pattern
 * 객체 인스턴스가 여러개 일 필요가 없을때 
 * 하나의 인스턴스를 공유하기 위한 기법
 * 
 * 프린터기는 사무실에 사용자 별로 하나씩 있을 필요가 없고
 * 필요할 때 공유 할 수 있도록 하나만 존재하면 된다.
 */
public class Printer {

	private static Printer printer;
	
	// printer 기는 프린터 내부에서만 생성가능
	private Printer() {}
	
	public static Printer getInstance() {
		if(printer == null) {
			printer = new Printer();
		}
		return printer;
	}
	
	public void print(String document) {
		System.out.println(document);
		Printer printerA = Printer.getInstance();
		System.out.println(printerA);
		
		Printer printerB = Printer.getInstance();
		System.out.println(printerB);
	}
	
}