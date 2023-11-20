package interface_default;

public class Windows {
	
	public void print(Printable printable) {
		printable.print();
	}

	public static void main(String[] args) {
		Windows windows = new Windows();
		LGPrinter lg = new LGPrinter();
		windows.print(lg);
		
		HPPrinter hp = new HPPrinter();
		windows.print(hp);
	}

}







