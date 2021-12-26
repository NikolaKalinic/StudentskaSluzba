package controller;

import gui.subject.MySubjectPanel;
import model.Professor;
import model.Semestar;
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
	

}
