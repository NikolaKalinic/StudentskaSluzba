package controller;


import gui.chair.MyChairPanel;
import gui.student.MyStudentPanel;
import model.Chair;
import model.ChairDB;
import model.Professor;
import model.Student;
import model.StudentDB;


public class ChairController {

	private static ChairController instance = null;
	/*singltone*/
	public static ChairController getInstance() {
		if (instance == null) {
			instance = new ChairController();
		}
		return instance;
	}
	/*constructors*/
	private ChairController() {}
	
	/*data manipulation methods*/
	public void addChair(String id, String name){
		ChairDB.getInstance().addChair(id, name);
		MyChairPanel.getInstance().updateView();
	}
	public void deleteChair(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	Chair chairs = ChairDB.getInstance().getRow(rowSelectedIndex);
    	ChairDB.getInstance().deleteChair(chairs.getIdChair());
    	MyChairPanel.getInstance().updateView();
    }
	public void editChair(int rowSelectedIndex,String id, String name,Professor p) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Chair chair = ChairDB.getInstance().getRow(rowSelectedIndex);
		ChairDB.getInstance().editChair(chair,id, name,p);
		MyChairPanel.getInstance().updateView();
	}
	public Chair getSelectedChair(int rowSelectedIndex) {
		Chair chair = ChairDB.getInstance().getRow(rowSelectedIndex);
		return chair;
	}
	
	public boolean existsChair(String id) {
		return ChairDB.getInstance().existsChair(id);
	}
	
	public boolean editExistsChair(String id) {
		 if(ChairDB.getInstance().existsChair(id)) {
			 return true;
		 }else {
			 if (getSelectedChair(MyChairPanel.getInstance().getChairTable().getSelectedRow()).getIdChair().equals(id.toUpperCase())) {
				 return true;
			 }else
				 return false;
		 }
	}
}
