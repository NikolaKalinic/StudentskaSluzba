package controller;

import java.time.LocalDate;

import gui.student.MyStudentPanel;
import gui.student.NotPassedExam;
import gui.student.PassedExam;
import model.Adress;
import model.Grades;
import model.Status;
import model.Student;
import model.StudentDB;
import model.Subject;
import model.SubjectDB;

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
			 if (getSelectedStudent(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())).getIndex().equals(id.toUpperCase())) {
				 return true;
			 }else
				 return false;
		 }
	}
	
	public void deleteFailedExam() {
		if(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())<0) {
			return;
		}
		if(NotPassedExam.getInstance().getNotPassedExamsTable().getSelectedRow()<0) {
			return;
		}
		Student s = StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow()));
		Subject sub = s.getFailedExams().get((NotPassedExam.getInstance().getNotPassedExamsTable().getSelectedRow()));
		StudentDB.getInstance().deleteFailedExam(s, sub.getIdSubject());
		NotPassedExam.getInstance().updateView();	
	}
	
	public void addSubjectToFailed(Subject s) {
		Student student = StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow()));
		StudentDB.getInstance().addSubjectToFailed(student,s);
		NotPassedExam.getInstance().updateView();
	}
	
	public void addGrade(Grades grade) {
		if(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())<0) {
			return;
		}
		if(NotPassedExam.getInstance().getNotPassedExamsTable().getSelectedRow()<0) {
			return;
		}
		Student student = StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow()));
		Subject subject = student.getFailedExams().get((NotPassedExam.getInstance().getNotPassedExamsTable().getSelectedRow()));
		StudentDB.getInstance().deleteFailedExam(student, subject.getIdSubject());
		StudentDB.getInstance().addGrade(student, grade);
		
		NotPassedExam.getInstance().updateView();
		PassedExam.getInstance().updateView();
		PassedExam.getInstance().updateLabel();
	}
	
	public void cancelGrade() {
		if(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())<0) {
			return;
		}
		if(PassedExam.getInstance().getPassedExamsTable().getSelectedRow()<0) {
			return;
		}
		Student student = StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow()));
		Grades grade = student.getGrades().get((PassedExam.getInstance().getPassedExamsTable().getSelectedRow()));
		StudentDB.getInstance().cancelGrade(student, grade);
		
		PassedExam.getInstance().updateLabel();
		PassedExam.getInstance().updateView();
		NotPassedExam.getInstance().updateView();	
		
	}
}
