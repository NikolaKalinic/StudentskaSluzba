package controller;

import java.time.LocalDate;

import gui.MyStudentPanel;
import gui.MyTabbedPane;
import model.Adress;
import model.Status;
import model.Student;
import model.StudentDB;

public class StudentController {

private static StudentController instance = null;
	/*singltone*/
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	/*constructors*/
	private StudentController() {}
	
	/*data manipulation methods*/
	public void addStudent(String surname, String name, LocalDate dateOfBirth, Adress adress, String phoneNumber, String email,
			String index, int yearOfEnrollment, int currYearOfStudy, Status status){
		StudentDB.getInstance().addStudent(surname,name,dateOfBirth,adress,phoneNumber,email,index,yearOfEnrollment,currYearOfStudy,status);
		MyStudentPanel.getInstance().updateView();
	}
	
	public void deleteStudent(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	Student student = StudentDB.getInstance().getRow(rowSelectedIndex);
		StudentDB.getInstance().deleteStudent(student.getIndex());
		MyStudentPanel.getInstance().updateView();
    }
	
	public void editStudent(int rowSelectedIndex,String surname, String name, Adress adress, String phoneNumber, String email,
			String index, int yearOfEnrollment, int currYearOfStudy, Status status) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Student student = StudentDB.getInstance().getRow(rowSelectedIndex);
		StudentDB.getInstance().editStudent(surname, name, adress, phoneNumber, email, student.getIndex(), yearOfEnrollment, currYearOfStudy, status);
		MyStudentPanel.getInstance().updateView();
	}
}
