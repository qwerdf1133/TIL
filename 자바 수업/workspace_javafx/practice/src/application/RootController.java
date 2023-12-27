package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RootController implements Initializable {

	@FXML private TableView<TableRowDataModel> myTableView;
	@FXML private TableColumn<TableRowDataModel, String> nameColumn;
	@FXML private TableColumn<TableRowDataModel, Integer> koreanColumn;
	@FXML private TableColumn<TableRowDataModel, Integer> mathColumn;
	@FXML private TableColumn<TableRowDataModel, Integer> englishColumn;
	
	ObservableList<TableRowDataModel>myList=FXCollections.observableArrayList(
		new TableRowDataModel(new SimpleStringProperty("홍길동A"),new SimpleIntegerProperty(40),new SimpleIntegerProperty(60),new SimpleIntegerProperty(80))	
	);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
