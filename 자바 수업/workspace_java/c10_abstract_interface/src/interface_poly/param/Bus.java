package interface_poly.param;

public class Bus implements Runnable{
	
	@Override
	public void run() {
		System.out.println("버스를 운전합니다.");
	}

}
