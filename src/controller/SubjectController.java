package controller;

import java.util.List;

import gui.professor.MyEditingProfessorInformation;
import gui.professor.MyProfessorPanel;
import gui.professor.ProfessorSubjects;
import gui.student.MyStudentPanel;
import gui.student.MyStudentTable;
import gui.subject.MyEditingSubjectDialog;
import gui.subject.MySubjectPanel;
import model.Professor;
import model.ProfessorDB;
import model.Semestar;
import model.Student;
import model.StudentDB;
import model.Subject;
import model.SubjectDB;

public class SubjectController {
	private static SubjectController instance = null;
	/*singltone*/
	public static SubjectController getInstance() {
		if (instance == null) {
			instance = new SubjectController();
		}
		return instance;
	}
	/*constructors*/
	private SubjectController() {}
	
	
	/*data manipulation methods*/
	public void addSubject(String idSubject, String name, Semestar semestar, int yearOfStudySub, Professor profesor, int espb) {
		SubjectDB.getInstance().addSubject(idSubject, name, semestar, yearOfStudySub, profesor, espb);
		MySubjectPanel.getInstance().updateView();
	}
	
	public void deleteSubject(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	Subject subject = SubjectDB.getInstance().getRow(rowSelectedIndex);
		SubjectDB.getInstance().deleteSubject(subject.getIdSubject());
		MySubjectPanel.getInstance().updateView();
    }
	
	public void editStudent(int rowSelectedIndex,String idSubject, String name, Semestar semestar, int yearOfStudySub, Professor profesor, int espb) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Subject subject = SubjectDB.getInstance().getRow(rowSelectedIndex);
		SubjectDB.getInstance().editSubject(subject,idSubject, name, semestar, yearOfStudySub, profesor, espb);
		MySubjectPanel.getInstance().updateView();
	}
	public Subject getSelectedSubject(int rowSelectedIndex) {
		Subject subject = SubjectDB.getInstance().getRow(rowSelectedIndex);
		return subject;
	}
	
	public boolean existsSubject(String id) {
		return SubjectDB.getInstance().existsSubject(id);
	}
	
	public boolean editExistsSubject(String id) {
		 if(SubjectDB.getInstance().existsSubject(id)) {
			 return true;
		 }else {
			 if (getSelectedSubject(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow()).getIdSubject().equals(id)) {
				 return true;
			 }else
				 return false;
		 }
	}
	
	public void addProfessor(Professor professor) {
		Subject subject = SubjectDB.getInstance().getRow(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow());
		subject.setProfesor(professor);
	}
	
	public void removeProfessor() {
		Subject subject = SubjectDB.getInstance().getRow(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow());
		ProfessorController.getInstance().removeSubjectFromProfessor(subject.getKey(),subject.getProfesor().getKey());
		subject.removeProfessor();
	}

}
