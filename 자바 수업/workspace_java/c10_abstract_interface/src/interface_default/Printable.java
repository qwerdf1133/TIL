package interface_default;

public interface Printable {
	void print();
	default void colorPrint() {};
}
