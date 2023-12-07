package ex02_nested_interface;

public class Button {
	
	@FunctionalInterface
	interface OnClickListener{
		void onClick();
		// void onDBClick();
	}
	
	private String title;
	
	public Button(String title) {
		this.title = title;
	}
	
	private OnClickListener listener;
	
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	// 버튼 이 클릭 되었을 때 수행 할 기능
	public void onTouch() {
		this.listener.onClick();
	}

	@Override
	public String toString() {
		return "Button [title=" + title + "]";
	}
	
}






