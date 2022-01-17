package model;

import java.util.ArrayList;
import java.util.List;

public class ChairDB {
	/*Singltone*/
	private static ChairDB instance = null;
	public static ChairDB getInstance() {
		if(instance==null) {
			instance=new ChairDB();
		}
		return instance;	
	}
	/*Field*/
	private List<Chair> chairs;
	private List<String> columns;
	private ChairDB() {
		initChair();
		this.columns = new ArrayList<String>();
		this.columns.add("Šifra");
		this.columns.add("Naziv");
		this.columns.add("Šef");
	}
	private void initChair() {
		this.chairs=new ArrayList<Chair>();
		List<Professor> professorsOnChair1 = new ArrayList<Professor>();
		professorsOnChair1.add(ProfessorDB.getInstance().getProfWithKey(1));
		professorsOnChair1.add(ProfessorDB.getInstance().getProfWithKey(7));
		professorsOnChair1.add(ProfessorDB.getInstance().getProfWithKey(13));
		professorsOnChair1.add(ProfessorDB.getInstance().getProfWithKey(19));
		List<Professor> professorsOnChair2 = new ArrayList<Professor>();
		professorsOnChair2.add(ProfessorDB.getInstance().getProfWithKey(2));
		professorsOnChair2.add(ProfessorDB.getInstance().getProfWithKey(8));
		professorsOnChair2.add(ProfessorDB.getInstance().getProfWithKey(14));
		List<Professor> professorsOnChair3 = new ArrayList<Professor>();
		professorsOnChair3.add(ProfessorDB.getInstance().getProfWithKey(3));
		professorsOnChair3.add(ProfessorDB.getInstance().getProfWithKey(9));
		professorsOnChair3.add(ProfessorDB.getInstance().getProfWithKey(15));
		List<Professor> professorsOnChair4 = new ArrayList<Professor>();
		professorsOnChair4.add(ProfessorDB.getInstance().getProfWithKey(4));
		professorsOnChair4.add(ProfessorDB.getInstance().getProfWithKey(10));
		professorsOnChair4.add(ProfessorDB.getInstance().getProfWithKey(16));
		List<Professor> professorsOnChair5 = new ArrayList<Professor>();
		professorsOnChair5.add(ProfessorDB.getInstance().getProfWithKey(5));
		professorsOnChair5.add(ProfessorDB.getInstance().getProfWithKey(11));
		professorsOnChair5.add(ProfessorDB.getInstance().getProfWithKey(17));
		List<Professor> professorsOnChair6 = new ArrayList<Professor>();
		professorsOnChair6.add(ProfessorDB.getInstance().getProfWithKey(6));
		professorsOnChair6.add(ProfessorDB.getInstance().getProfWithKey(12));
		professorsOnChair6.add(ProfessorDB.getInstance().getProfWithKey(18));
		
		chairs.add(new Chair(1,	"e42",	"Katedra za matematiku",	ProfessorDB.getInstance().getProfWithKey(2),professorsOnChair1));                    
		chairs.add(new Chair(2,	"e43",	"Katedra za fiziku",	ProfessorDB.getInstance().getProfWithKey(3),professorsOnChair2));
		chairs.add(new Chair(3,	"e44",	"Katedra za elektrotehniku",	ProfessorDB.getInstance().getProfWithKey(4),professorsOnChair3));
		chairs.add(new Chair(4,	"e45",	"Katedra za primenjene računarske nauke",	ProfessorDB.getInstance().getProfWithKey(7),professorsOnChair4));
		chairs.add(new Chair(5,	"e46",	"Katedra za informatiku",	ProfessorDB.getInstance().getProfWithKey(13),professorsOnChair5));
		chairs.add(new Chair(6,	"e47",	"Katedra za automatiku",	ProfessorDB.getInstance().getProfWithKey(18),professorsOnChair6));
	}
	
	/*Methods for student views*/
	public List<Chair> getChairs(){
		return chairs;
	}
	public void setChairs(List<Chair> chairs) {
		this.chairs=chairs;
	}
	public int getColumnCount() {
		return 3;
	}
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	public Chair getRow(int rowIndex) {
		return this.chairs.get(rowIndex);
	}
	public String getValueAt(int row, int column) {
		Chair chair = this.chairs.get(row);
		switch (column) {
		case 0:
			return chair.getIdChair();
		case 1:
			return chair.getNameOfChair();
		case 2:
			if(chair.getHeadOfChair()==null)
				return "Nema šefa";
			else
				return chair.getHeadOfChair().getProfNameAndSurname();
		default:
			return null;
		}
	}
	
	/*Add,delte,edit student methods*/
	public boolean existsChair(String id) {
		for(Chair s : chairs ) {
			String s1 = s.getIdChair().toUpperCase();
			if(s1.equals(id.toUpperCase()))
				return false;		
		}
		return true;				
	}
	public void addChair(String id, String name){
		if(existsChair(id))
			this.chairs.add(new Chair(name,id));
	}
	
	public void deleteChair(String index) {
		for (Chair s : chairs) {
			if(s.getIdChair().equals(index)) {
				chairs.remove(s);
				break;
			}
		}
	}
	public void editChair(Chair s,String id, String name,Professor p) {
		if(existsChair(id)) {
			s.setIdChair(id);
			s.setNameOfChair(name);
			s.setHeadOfChair(p);
		}else if (s.getIdChair().equals(id.toUpperCase())){
			s.setIdChair(id.toUpperCase());
			s.setNameOfChair(name);
			s.setHeadOfChair(p);
		}
	}
}
