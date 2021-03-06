package controller;

import java.util.ArrayList;
import java.util.List;

import gui.professor.MyProfessorPanel;
import gui.professor.ProfessorSubjects;
import model.Adress;
import model.ChairDB;
import model.Professor;
import model.ProfessorDB;
import model.Subject;
import model.SubjectDB;

public class ProfessorController {
	
	private static ProfessorController instance = null;
	
	public static ProfessorController getInstance() {
		if (instance == null) {
			instance = new ProfessorController();
		}
		return instance;
	}
	
	private ProfessorController() {}
	
	public boolean alreadyExists(String id) {
		return ProfessorDB.getInstance().alreadyExists(id);
	}
	public void save() {
		ProfessorDB.getInstance().save();
	}
	public boolean alreadyExists(String id, int selectedRowIndex) {
		if(selectedRowIndex < 0) {
			return true;
		}
		Professor p = ProfessorDB.getInstance().getRow(selectedRowIndex);
		if(p.getId().equals(id)) {
			return false;
		}
		return ProfessorDB.getInstance().alreadyExists(id);
	}
	
	public void addProfessor(String surname, String name, String email, String birthDate, Adress homeAdress, Adress workAdress, String phoneNumber, String id, String calling, int experience) {
		ProfessorDB.getInstance().addProfessor(surname, name, email, birthDate, homeAdress, workAdress, phoneNumber, id, calling, experience);
		MyProfessorPanel.getInstance().updateView();
	}
	
	public void removeProfessor(int selectedRowIndex) {
		if (selectedRowIndex < 0) {
			return;
		}
		Professor professor = ProfessorDB.getInstance().getRow(selectedRowIndex);
		ProfessorDB.getInstance().deleteProfessor(professor.getId());
		MyProfessorPanel.getInstance().updateView();
		
		/*delete profesor from chair*/
		for(int i =0; i<ChairDB.getInstance().getChairs().size();i++) {
			for(int j = 0; j<ChairDB.getInstance().getChairs().get(i).getProfessors().size();j++) {
				if(ChairDB.getInstance().getChairs().get(i).getProfessors().get(j).getKey()==professor.getKey()) {
					ChairDB.getInstance().removeProfessorFromChair(i, professor.getKey());
				}
			}
		}
		for(int i =0;i<professor.getCourseList().size();i++) {
			for(int j=0;j<SubjectDB.getInstance().getSubjects().size();j++)
				if(professor.getCourseList().get(i).getKey()==SubjectDB.getInstance().getSubjects().get(j).getKey()) {
					SubjectDB.getInstance().getSubjects().get(j).removeProfessor();
			}
		}
	}
	
	public void editProfessor(int selectedRowIndex, String surname, String name, String email, String birthDate, Adress homeAdress, Adress workAdress, String phoneNumber, String id, String calling, int experience) {
		if(selectedRowIndex < 0) {
			return;
		}
		
		ProfessorDB.getInstance().editProfessor((MyProfessorPanel.getInstance().getProfessorTable().convertRowIndexToModel(MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow())), surname, name, email, birthDate, homeAdress, workAdress, phoneNumber, id, calling, experience);
		MyProfessorPanel.getInstance().updateView();
		
		Professor p = ProfessorDB.getInstance().getRow(selectedRowIndex);
		/*edit profesor from chair*/
		for(int i =0; i<ChairDB.getInstance().getChairs().size();i++) {
			for(int j = 0; j<ChairDB.getInstance().getChairs().get(i).getProfessors().size();j++) {
				if(ChairDB.getInstance().getChairs().get(i).getProfessors().get(j).getKey()==p.getKey()) {
					ChairDB.getInstance().editProfessorFromChair(i,p,p.getKey());
				}
			}
		}
	}

	public Professor getSelectedProfessor(int rowSelectedIndex) {
		Professor professor = ProfessorDB.getInstance().getRow(rowSelectedIndex);
		return professor;
	}
	
	
	
	/*method for remove and add subject*/
	public void removeSubject() {
		if(ProfessorSubjects.getInstance().getSubjectsTable().getSelectedRow()<0)
			return;
		Professor p = ProfessorDB.getInstance().getRow((MyProfessorPanel.getInstance().getProfessorTable().convertRowIndexToModel(MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow())));
		List<String> subs  = new ArrayList<String>();
		int[] index = ProfessorSubjects.getInstance().getSubjectsTable().getSelectedRows();
		for (int i = 0 ;i< index.length;i++) {
			p.getCourseList().get(index[i]).removeProfessor();
			subs.add(p.getCourseList().get(index[i]).getIdSubject());
		}
		ProfessorDB.getInstance().removeSubject(p,subs);
		ProfessorSubjects.getInstance().updateView();
	}
	public void addSubject(List<Subject> s) {
		Professor p = ProfessorDB.getInstance().getRow((MyProfessorPanel.getInstance().getProfessorTable().convertRowIndexToModel(MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow())));
		for(int i = 0 ; i<s.size();i++) {
			s.get(i).setProfesor(p);
		}
		ProfessorDB.getInstance().addSubject(p,s);
		ProfessorSubjects.getInstance().updateView();
	}
	
	public void removeSubjectFromProfessor(int subKey,int profKey) {
		for(int i =0; i<ProfessorDB.getInstance().getProfWithKey(profKey).getCourseList().size();i++) {
			if(ProfessorDB.getInstance().getProfWithKey(profKey).getCourseList().get(i).getKey()==subKey)
				ProfessorDB.getInstance().getProfWithKey(profKey).getCourseList().remove(i);
		}
	}
	public void addSubject(int subKey,int profKey) {
		ProfessorDB.getInstance().getProfWithKey(profKey).getCourseList().add(SubjectDB.getInstance().getSubjectWithKey(subKey));
	}
	/*----------------------------------------*/

}
