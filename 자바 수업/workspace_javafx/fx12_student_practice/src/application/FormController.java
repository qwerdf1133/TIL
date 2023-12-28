package application;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.StudentVO;

public class FormController {

	@FXML private TextField txtName, txtKor, txtMath, txtEng;
	@FXML private Button btnSave, btnCancel;
	
	// tableView의 리스트 정보, 현재 control이 등록된 Form stage 정보 
	public void init(ObservableList<StudentVO> list, Stage formStage) {
		btnCancel.setOnAction(e->{
			formStage.close();
		});
		
		// 저장 버튼 event 
		btnSave.setOnAction(e->{
			// 저장 버튼 선택 시점에 TextField에 작성된 내용으로 
			// RootController의 tableView list 학생 정보에 추가
			
			String name = txtName.getText().trim();
			String strKor = txtKor.getText().trim();
			String strMath = txtMath.getText().trim();
			String strEng = txtEng.getText().trim();
			
			boolean isChecked = checkInteger(strKor, strMath, strEng);
			System.out.println(isChecked);
			if(isChecked) {
				int kor = Integer.parseInt(strKor);
				int math = Integer.parseInt(strMath);
				int eng = Integer.parseInt(strEng);
				StudentVO vo = new StudentVO(name,kor,math,eng);
				RootController.list.add(vo);	// talbeView list 항목에 학생정보 추가
			}
			
			txtName.clear();
			txtKor.clear();
			txtMath.clear();
			txtEng.clear();
			txtName.requestFocus();
			
		});
	}
	
	public boolean checkInteger(String...scores) {
		// input : 	100 == [1][0][0]
		// char[] chars = scores[0].toCharArray();
		for(String str : scores) {
			for(char c : str.toCharArray()) {
				if(c < 48 || c > 57) {
					// 숫자로 변화할 수 없는 문자가 포함
					return false;
				}
			}
		}
		
		return true;
	}
	
}













