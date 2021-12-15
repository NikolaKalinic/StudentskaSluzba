package controller;

import gui.MyProfessorPanel;
import model.Adress;
import model.Professor;
import model.ProfessorDB;

public class ProfessorController {
	
	private static ProfessorController instance = null;
	
	public static ProfessorController getInstance() {
		if (instance == null) {
			instance = new ProfessorController();
		}
		return instance;
	}
	
	private ProfessorController() {}
	
	public void addProfessor(String surname, String name, String email, String birthDate, Adress homeAdress, Adress workAdress, String phoneNumber, String id, String calling, String title, int experience) {
		ProfessorDB.getInstance().addProfessor(surname, name, email, birthDate, homeAdress, workAdress, phoneNumber, id, calling, title, experience);
		MyProfessorPanel.getInstance().updateView();
	}
	
	public void removeProfessor(int selectedRowIndex) {
		if (selectedRowIndex < 0) {
			return;
		}
		Professor professor = ProfessorDB.getInstance().getRow(selectedRowIndex);
		ProfessorDB.getInstance().deleteProfessor(professor.getId());
		MyProfessorPanel.getInstance().updateView();
	}
	
	public void editProfessor(int selectedRowIndex, String surname, String name, String email, String birthDate, Adress homeAdress, Adress workAdress, String phoneNumber, String id, String calling, String title, int experience) {
		if(selectedRowIndex < 0) {
			return;
		}
		
		ProfessorDB.getInstance().editProfessor(surname, name, email, birthDate, homeAdress, workAdress, phoneNumber, id, calling, title, experience);
		MyProfessorPanel.getInstance().updateView();
	}


}