package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		List<Professor> professors = new ArrayList<Professor>();
		professors.add(new Professor("Milutinovic", "Milutin", "mmilutin@uns.ac.rs", LocalDate.parse("01-01-1960", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Lazina", "1", "Novi Sad", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "069123324", "20021", "Asistent",  1));
		professors.add(new Professor("Manjevic", "Mila", "mmila@uns.ac.rs", LocalDate.parse("12-05-1962", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Minjina", "15", "Novi Sad", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "062222222", "24521", "Profesor",  21));
		chairs.add(new Chair("EA14","Automatika"));
		chairs.add(new Chair("EI12","Informatika",professors));
		chairs.add(new Chair("EG14","Gradjevinja"));
		chairs.add(new Chair("ES21","Saobracaj"));
		chairs.add(new Chair("EM14","Mehanika"));
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
