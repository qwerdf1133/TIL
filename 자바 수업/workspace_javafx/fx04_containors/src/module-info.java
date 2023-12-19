module fx04_containors {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens c1_anchor_pane to javafx.graphics, javafx.fxml;
	opens c2_hbox_vbox to javafx.graphics, javafx.fxml;
	opens c3_border_pane to javafx.graphics, javafx.fxml;
	
}
