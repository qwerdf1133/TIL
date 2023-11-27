package generic04_extends;

public class Parent<T,M> {
	
	private T kind;
	private M model;
	public T getKind() {
		return kind;
	}
	public void setKind(T kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "Parent [kind=" + kind + ", model=" + model + "]";
	}

}
