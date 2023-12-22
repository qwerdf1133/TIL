open module fx08_controls {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.web;
	requires javafx.media;
	/*
	opens c1_button_base to javafx.graphics, javafx.fxml;
	opens c2_input to javafx.graphics, javafx.fxml;
	opens c3_view_controls to javafx.graphics, javafx.fxml;
	*/
	
	/*
	 	c3_view_controls package의 PhoneVO class의 필드 정보를
	 	javafx.base package의 Application과 TableView가 해석 해서
	 	읽어 들여야 하는데 module 시스템은 패키지 외부의 class를 숨기기 때문에
	 	명시적으로 모든 public class 멤버를 외부로 노출 시키도록 명시해 줘야함
	 */
	
	exports c3_view_controls;
}
