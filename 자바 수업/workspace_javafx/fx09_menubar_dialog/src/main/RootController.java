package main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable{
	
	@FXML private ComboBox<String> comboBox;
	@FXML private TextArea textArea;
	
	// 현재 스테이지(Window)정보를 저장할 field
	private Stage primaryStage;
	
	public void setStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 콤보 박스 항목 선택 변경 감지 이벤트 리스터 추가
		comboBox.getSelectionModel().selectedIndexProperty()
		.addListener((target, o, n)->{
			// 새로 선택 된 항목의 인덱스 번호
			int index = n.intValue();
			System.out.println("select comboBox : " + index);
			switch(index) {
			case 0 : // Directory Chooser 
				// JavaFX에서 제공하는 폴더 선택 상자
				DirectoryChooser chooser = new DirectoryChooser();
				chooser.setTitle("디렉토리 선택 창 테스트");
				chooser.setInitialDirectory(new File("C:\\temp"));
				File chooseDir= chooser.showDialog(primaryStage);
				System.out.println(chooseDir);
				if(chooseDir != null) {
					System.out.println(chooseDir.isDirectory());
					File[] files = chooseDir.listFiles();
					for(File f : files) {
						textArea.appendText(f.getName()+"\n");
					}
				}else {
					System.out.println("선택된 디렉토리가 존재하지 않습니다.");
				}
				break;
				
			case 1 : // File Chooser
				// JavaFX에서 제공하는 File 선택 상자
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("읽을 파일을 선택하세요");
				fileChooser.setInitialDirectory(new File("C:\\Temp"));
				
				ObservableList<ExtensionFilter> filters = fileChooser.getExtensionFilters();
				filters.add(new ExtensionFilter("Text Files","*.txt","*.hwp","*.pdf"));
				filters.addAll(new ExtensionFilter("Image Files","*.png","*.jpg","*.jpeg","*.gif"),
								new ExtensionFilter("All Files","*.*")
				);
				
				
//				File selectedFile = fileChooser.showOpenDialog(primaryStage);
				File selectedFile = fileChooser.showSaveDialog(primaryStage);
				if(selectedFile != null) {
					System.out.println(selectedFile.isFile());
					System.out.println(selectedFile.getAbsolutePath());
				}
				
				// 여러 파일을 선택 할 수 있는 file chooser
				List<File> selectedFiles = fileChooser.showOpenMultipleDialog(primaryStage);
				System.out.println(selectedFiles);
				break;
			case 2 : // PopUp
				Popup popup = new Popup();
				Parent root = null;
				
				try {
					root = FXMLLoader.load(getClass().getResource("Popup.fxml"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// 자동 숨김 설정 - focus 이동 시 popup창 종료
				popup.setAutoHide(true);
				
				ImageView imageView = (ImageView)root.lookup("#imgMessage");
				imageView.setOnMouseClicked(e->{
					System.out.println("ImageView Mouse Clicked");
					popup.hide();
				});
				
				Label lblMessage = (Label)root.lookup(".lblMessage");
				lblMessage.setText("메세지 알림");
				
				popup.getContent().add(root);
				popup.show(primaryStage);
				
				
				break;
			case 3 : // Custom Window - Alert
				handleCustom();
				break;
			} 
		});
	}
	
	// 사용자 정의형 dialog 생성
	private void handleCustom() {
		Stage stage = new Stage();
		// DECORATED - 기본값
		stage = new Stage(StageStyle.DECORATED);
		// 흰색 배경 제목 줄 X
		// stage.initStyle(StageStyle.UNDECORATED);
		// 흰배경, 제목줄에 타이틀 종료 버튼만 존재
		// stage.initStyle(StageStyle.UTILITY);
		// 투명 배경, 제목줄 x
		// stage.initStyle(StageStyle.TRANSPARENT);
		
		stage.setTitle("Custom Dialog");
		Parent parent = null;
		
		try {
			parent = FXMLLoader.load(
				getClass().getResource("Custom.fxml")
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// primaryStage를 새로 생성한 소유자 창으로 지정
		// stage.initOwner(primaryStage);
		// Modality 지정 속성, null, WINDOW_MODAL, APPLICATION_MODAL
		// stage.initModality(Modality.WINDOW_MODAL);
		// WINDOW_MODAL 소유자 창이 지정되어 있을 경우 오류자 소유권을 이동하지 않음
		stage.initModality(Modality.APPLICATION_MODAL);
		// 전체 애플리케이션 창에서 소유권을 변경하지 않음
		
		Scene scene = new Scene(parent);
		// 장면 배경을 투명하게 바꿈
		scene.setFill(Color.TRANSPARENT);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public void handleNew() {
		System.out.println("New");
	}
	
	public void handleOpen() {
		System.out.println("Open");
	}
	
	public void handleSave() {
		System.out.println("Save");
	}
	
	public void handleClose() {
		System.out.println("Close");
	}

}



