package e02_bundle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class BundleController implements Initializable {
	
	@FXML private Button btnAccept, btnReload, btnCancel;

	@Override
	public void initialize(URL location, ResourceBundle bundle) {
		System.out.println(location);
		System.out.println(bundle);
		
		btnAccept.setOnAction(e->{
			handleEvent(e);
		});
	} 
	
	public void handleEvent(ActionEvent e) {
		Button btn = (Button)e.getTarget();
		System.out.println(btn);
		System.out.println(btn.getText());
		System.out.println(e.getEventType());
	}

}
















