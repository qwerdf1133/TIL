package application;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RootController implements Initializable{
	
	@FXML private Label lblTime;
	@FXML private Button btnStart, btnStop;

	// timer 종료 flag
	private boolean isRun;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btnStart.setOnAction(e->{
			isRun = true;
			Stage stage = (Stage)lblTime.getScene().getWindow();
			stage.setTitle("Timer");
			System.out.println(Thread.currentThread());
			System.out.println(Thread.currentThread().isDaemon());
			
			Thread t = new Thread(()->{
				
				LocalTime time = LocalTime.of(0, 0, 0);
				
				System.out.println(Thread.currentThread());
				while(isRun) {
					// 10억분의 1초 1,000,000,000 / 1  nano times
					// 1,000,000	millis
					// 10,000,000	10 millis
					time = time.plusNanos(10000000);
					
					String data = time.format(
						DateTimeFormatter.ofPattern("mm:ss:SS")
					);
					Platform.runLater(()->{
						lblTime.setText(data);
					});
					/*
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							lblTime.setText(data);
						}
					});
					*/
					try {
						Thread.sleep(10);
					} catch (InterruptedException e1) {}
				}
			});
			t.setDaemon(true);
			t.start();
			
		});
		
		btnStop.setOnAction(e->{
			isRun = false;
		});
	}
	
}
