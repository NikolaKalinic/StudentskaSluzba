package main;



import controller.StudentController;
import gui.MainFrame;
import gui.MyAddingStudentDialog;
import model.StudentDB;

public class MyApp {

	public static void main(String[] args) {
		StudentDB dbs= StudentDB.getInstance();
		StudentController sc= StudentController.getInstance();
		MainFrame mf = MainFrame.getInstance();
		
	}

}
