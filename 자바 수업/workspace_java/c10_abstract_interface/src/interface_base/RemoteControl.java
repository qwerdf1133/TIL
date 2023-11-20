package interface_base;

public interface RemoteControl {
	
	public static final int MAX_VALUE = 10;
	
	int MIN_VALUE = 0;
	
	public abstract void turnOff();
	
	void turnOn();
	
	void setValue(int value);
	
	/*
	void setValue(int value) {
	
	}
	*/
}
