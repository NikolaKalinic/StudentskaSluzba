package controller;

import java.time.LocalDate;

import gui.MyTabbedPane;
import gui.student.MyStudentPanel;
import gui.student.MyStudentTable;
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
	
	public void editStudent(int rowSelectedIndex,String surname, String name,LocalDate date, Adress adress, String phoneNumber, String email,
			String index, int yearOfEnrollment, int currYearOfStudy, Status status) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Student student = StudentDB.getInstance().getRow(rowSelectedIndex);
		StudentDB.getInstance().editStudent(student,surname, name,date, adress, phoneNumber, email, index, yearOfEnrollment, currYearOfStudy, status);
		MyStudentPanel.getInstance().updateView();
	}
	
	public Student getSelectedStudent(int rowSelectedIndex) {
		Student student = StudentDB.getInstance().getRow(rowSelectedIndex);
		return student;
	}
	
	public boolean existsStudent(String id) {
		return StudentDB.getInstance().existsStudent(id);
	}
	
	public boolean editExistsStudent(String id) {
		 if(StudentDB.getInstance().existsStudent(id)) {
			 return true;
		 }else {
			 if (getSelectedStudent(MyStudentTable.selectedRow).getIndex().equals(id)) {
				 return true;
			 }else
				 return false;
		 }
	}
	
}
