package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class TableRowDataModel {

	private StringProperty name;
	private IntegerProperty korean;
	private IntegerProperty math;
	private IntegerProperty english;
	
	public TableRowDataModel(StringProperty name,IntegerProperty korean,IntegerProperty math,IntegerProperty english) {
		this.name = name;
		this.korean = korean;
		this.math = math;
		this.english = english;
	}
	
	public StringProperty nameProperty() {
		return name;
	}
	
	public IntegerProperty koreanProperty() {
		return korean;
	}
	
	public IntegerProperty mathProperty() {
		return math;
	}
	
	public IntegerProperty englishProperty() {
		return english;
	}
}
