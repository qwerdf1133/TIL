package draw_line;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class DrawController implements Initializable {
	
	@FXML private Canvas canvas;
	@FXML private TextArea txtArea;
	@FXML private ColorPicker pick;
	@FXML private Slider slider;
	@FXML private Button btnClear, btnSave;

	// 그리기 도구
	private GraphicsContext gc;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gc = canvas.getGraphicsContext2D();
		// colorPick의 기본 색상은 흰색 -> 검은색으로 변경
		pick.setValue(Color.BLACK); 
		gc.setStroke(Color.BLACK);		// 선색 지정
		gc.setLineWidth(1);				// 선 굵기 지정
		slider.setMin(1);
		slider.setMax(100);
		txtArea.setEditable(false);		// textArea 작성 불가
		
		// canvas 위에서 마우스가 움직일때 
		canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				double x = event.getScreenX();
				double y = event.getScreenY();
				txtArea.appendText("screen x : " + x + ", y : " + y+"\n");
				x = event.getX();
				y = event.getY();
				txtArea.appendText("canvas x : " + x + ", y : " + y+"\n");
			}
		}); // end mouse moved
		
		// 마우스가 눌러졌을 때
		canvas.setOnMousePressed(e -> {
			gc.beginPath();
			gc.lineTo(e.getX(), e.getY());
		});
		
		// 마우스가 드래그 되는 동안
		canvas.setOnMouseDragged(e->{
			gc.lineTo(e.getX(), e.getY());
			gc.stroke();
		});
		
		// Clear button event
		btnClear.setOnAction(e->{
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		});
		
		// 선색 변경 - 색상 변경 감지
		pick.valueProperty().addListener((target,o,n)->{
			System.out.println("old color : " + o);
			System.out.println("new color : " + n);
			gc.setStroke(n);
		});
		
		slider.valueProperty().addListener((target,o,n)->{
			double value = n.doubleValue() / 10;
			gc.setLineWidth(value);
		});
		
		// 저장 버튼 click 시
		btnSave.setOnAction((e)->{
			FileChooser chooser = new FileChooser();
			chooser.getExtensionFilters().add(
				new ExtensionFilter("IMAGE FILE", "*.png")
			);
			File file = chooser.showSaveDialog(slider.getScene().getWindow());
			if(file != null) {
				try {
					// 지정된 요소의 스크린샷을 제공하기 위한 부가 정보를 저장하는 class
					SnapshotParameters param = new SnapshotParameters();
					param.setDepthBuffer(true);
					param.setFill(Color.TRANSPARENT);
					
					// Node Canvas 화면 의 스크린샷 정보
					WritableImage writeImg = canvas.snapshot(param, null);
					
					// 매개변수로 전달된 스크린샷 정보로 이미지 소스 생성
					RenderedImage renderImage = SwingFXUtils.fromFXImage(writeImg, null);
					OutputStream os = new FileOutputStream(file);
					
					// ImageIO.write(출력할 이미지, 파일확장자명, 출력스트림);
					ImageIO.write(renderImage, "png", os);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			} // end if
			
		}); // end btnSave
		
		
	}// end initialize

}











