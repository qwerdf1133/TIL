package application;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.StudentVO;

public class RootController implements Initializable {

	@FXML
	private TableView<StudentVO> tableView;
	@FXML
	private Button btnAdd, btnBarChart;
	
	// 학생 정보를 control과 함께 사용할 수 있도록 저장하는 list
	static ObservableList<StudentVO> list;
	
	public static StudentVO student; 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list = FXCollections.observableArrayList(
			new StudentVO("홍길동A",40,60,80),
			new StudentVO("홍길동B",60,80,40),
			new StudentVO("홍길동C",80,40,70)
		);
		/*
		TableColumn<StudentVO,String> nameColumn = new TableColumn<>("이름");
		nameColumn.setText("이름");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		tableView.getColumns().add(nameColumn);
		*/
		
		Class<StudentVO> clazz = StudentVO.class;
		
		Field[] fields = clazz.getDeclaredFields();
		for(Field f : fields) {
			String name = f.getName();
			TableColumn<StudentVO,String> tc = new TableColumn<>(name);
			tc.setCellValueFactory(new PropertyValueFactory<>(name));
			tc.setPrefWidth(100);
			tc.setResizable(false);
			tc.setStyle("-fx-alignment:center;-fx-text-fill:red;");
			tableView.getColumns().add(tc);
		}
		tableView.setItems(list);
		
		// 테이블 뷰 항목 선택 감지 이벤트 처리
		tableView.getSelectionModel().selectedItemProperty()
		.addListener((target,o,n)->{
			// 선택된 항목의 아이팀 -> StudentVO
			System.out.println(n);
		});
		
		// tableView 항목 double click 시 prieChart Stage(창) 오픈
		tableView.setOnMouseClicked(e->{
			// 단시간 내에 click된 횟수
			int clickCount = e.getClickCount();
			System.out.println("click count : " + clickCount);
			
			// mouse click button 종류
			// 좌클릭 - PRIMARY,  우클릭 - SECONDARY, 휠마우스 - MIDDLE
			MouseButton btn = e.getButton();
			System.out.println(btn);		
			
			// 좌버튼 더블 클릭
			if(btn == MouseButton.PRIMARY && clickCount == 2) {
				// pieChart 창 
				// 이벤트 발생 시점에 tableView에 선택된 item-항목 정보
				// StudentVO value = tableView.getSelectionModel().getSelectedItem();
				student = tableView.getSelectionModel().getSelectedItem();
				
				System.out.println(student);
				
				if(student == null) return;
				
				Stage stage = new Stage(StageStyle.UTILITY);
				Parent root = null;
				FXMLLoader loader = null;
				try {
					loader = new FXMLLoader(getClass().getResource("PieChart.fxml"));
					root = loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
					return;
				}
				stage.setScene(new Scene(root));
				
				// PieChartController controller = loader.getController();
				// controller.setStudent(student);
				stage.setTitle("파이 그래프");
				stage.show();
				
				/*
				// FXML 파일을 이용한 스테이지 구성
				Parent root = null;
				try {
					root = FXMLLoader.load(
						getClass().getResource("PieChart.fxml")
					);
				} catch (IOException e1) {
					e1.printStackTrace();
					return;
				}
				
				PieChart pieChart = (PieChart)root.lookup("#pieChart");
				pieChart.setData(FXCollections.observableArrayList(
					new PieChart.Data("국어", value.getKor()),
					new PieChart.Data("수학", value.getMath()),
					new PieChart.Data("영어", value.getEng())
				));
				
				Button btnClose = (Button)root.lookup("#btnClose");
				btnClose.setOnAction(event->{
					stage.close();
				});
				stage.setScene(new Scene(root));
				stage.setTitle("파이 그래프");
				stage.show();
				*/
				
				/*
				// 자바 코드로 UI 생성 및 이벤트 처리
				BorderPane pane = new BorderPane();
				pane.setPrefSize(300, 300);
				
				PieChart chart = new PieChart();
				chart.setData(FXCollections.observableArrayList(
					new PieChart.Data("국어", value.getKor()),
					new PieChart.Data("수학", value.getMath()),
					new PieChart.Data("영어", value.getEng())
				));
				pane.setCenter(chart);
				
				HBox hBox = new HBox();
				hBox.setPrefHeight(50);
				hBox.setAlignment(Pos.CENTER);
				Button btnClose = new Button("닫기");
				btnClose.setOnAction(event->{
					stage.close();
				});
				hBox.getChildren().add(btnClose);
				
				pane.setBottom(hBox);
				
				Scene scene = new Scene(pane);
				stage.setScene(scene);
				stage.setTitle(value.getName()+" 파이 그래프");
				stage.show();
				*/
			}
		}); 

		// tableView 에 새로운 학생 정보 추가 창 open
		btnAdd.setOnAction(e->{
			Stage stage = new Stage(StageStyle.UTILITY);
			stage.setTitle("추가");
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Form.fxml"));
				Parent root = loader.load();
				stage.setScene(new Scene(root));
				// 새로운 Stage를 그려줄 X,Y 좌표값을 현재 무대를 기준으로 지정
				Stage primary = (Stage)btnAdd.getScene().getWindow();
				double x = stage.getX();
				stage.setX(x + stage.getWidth());
				stage.setY(primary.getY());
				stage.initModality(Modality.APPLICATION_MODAL);
				FormController controller = loader.getController();
				
				controller.init(list, stage);
				stage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}); 
		
		// 학생별 막대 그래프 버튼 이벤트
		btnBarChart.setOnAction(e->{
			try {
				Stage stage = new Stage(StageStyle.UTILITY);
				Parent root = FXMLLoader.load(getClass().getResource("BarChart.fxml"));
				stage.setScene(new Scene(root));
				stage.setTitle("막대 그래프");
				stage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
	} 

}












