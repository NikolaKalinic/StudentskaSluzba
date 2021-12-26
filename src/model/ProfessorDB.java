package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDB {
	
	private static ProfessorDB instance = null;
	
	public static ProfessorDB getInstance() {
		if (instance == null) {
			instance = new ProfessorDB();
		}
		return instance;
	}
	
	
	private List<Professor> professors;
	private List<String> cols;
	
	private ProfessorDB() {
		
		initProfessors();
		this.cols = new ArrayList<String>();
		this.cols.add("Ime");
		this.cols.add("Prezime");
		this.cols.add("Zvanje");
		this.cols.add("Titula");
	}
	
	private void initProfessors() {
		this.professors = new ArrayList<Professor>();
		professors.add(new Professor("Milutinovic", "Milutin", "mmilutin@uns.ac.rs", LocalDate.parse("01-01-1960", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Lazina", "1", "Novi Sad", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "069123324", "20021", "Asistent", "Doktor", 1));
		professors.add(new Professor("Manjevic", "Mila", "mmila@uns.ac.rs", LocalDate.parse("12-05-1962", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Minjina", "15", "Novi Sad", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "062222222", "24521", "Docent", "Master", 21));
		professors.add(new Professor("Strahinjic", "Vera", "svera@uns.ac.rs", LocalDate.parse("25-10-1949", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Filipova", "2", "Sremska Mitrovica", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "063234123", "22321", "Profesor", "Doktor", 15));
		professors.add(new Professor("Milenovic", "Dragutin", "mdragutin@uns.ac.rs", LocalDate.parse("02-03-1989", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Suzanina", "3", "Beograd", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "069452231", "25521", "Vanredni profesor", "Doktor", 22));
		}
	
	/*getters/setter*/
	
	public List<Professor> getProfessors() {
		return professors;
	}
	
	public void setProfessors(List<Professor> professors) {
		this.professors = professors;	
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int index) {
		return this.cols.get(index);
	}
	
	public Professor getRow(int rowIndex) {
		return this.professors.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Professor professor = this.professors.get(row);
		switch (column) {
		case 0:
			return professor.getName();
		case 1:
			return professor.getSurname();
		case 2:
			return professor.getCalling();
		case 3:
			return professor.getTitle();
		default:
			return null;	
		}
	}
	
	public void addProfessor(String surname, String name, String email, String birthDate, Adress homeAdress, Adress workAdress, String phoneNumber, String id, String calling, String title, int experience) {
		this.professors.add(new Professor(surname, name, email, LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")), homeAdress, workAdress, phoneNumber, id, calling, title, experience));
	}
	
	public void deleteProfessor(String id) {
		for (Professor p : professors) {
			if(p.getId().equals(id)) {
				professors.remove(p);
				break;
			}
		}
	}
	
	public void editProfessor(String surname, String name, String email, String birthDate, Adress homeAdress, Adress workAdress, String phoneNumber, String id, String calling, String title, int experience) {
		for(Professor p : professors) {
			if(p.getId().equals(id)) {
				p.setSurname(surname);
				p.setName(name);
				p.setEmail(email);
				p.setBirthDate(LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				p.setHomeAdress(homeAdress);
				p.setWorkAdress(workAdress);
				p.setPhoneNumber(phoneNumber);
				p.setId(id);
				p.setCalling(calling);
				p.setTitle(title);
				p.setExperience(experience);
			}
		}
	}
	
	
	

}
