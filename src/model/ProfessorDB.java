package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import gui.professor.MyProfessorPanel;

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
	private List<String> subjects;
	
	private ProfessorDB() {
		
		initProfessors();
		this.cols = new ArrayList<String>();
		this.cols.add("Ime");
		this.cols.add("Prezime");
		this.cols.add("Zvanje");
		this.cols.add("Email");
		
		
		this.subjects = new ArrayList<String>();
		this.subjects.add("Šifra predmeta");
		this.subjects.add("Naziv predmeta");
		this.subjects.add("Godina studija");
		this.subjects.add("Semestar");
	}
	
	private void initProfessors() {
		List<Subject> courseList = new ArrayList<Subject>();
		List<Subject> courseList1 = new ArrayList<Subject>();
		List<Subject> courseList2 = new ArrayList<Subject>();
		List<Subject> courseList3 = new ArrayList<Subject>();
		Subject s1=new Subject("ES231", "Matematicka analiza 1", 9, 1, Semestar.Winter);
		Subject s2=new Subject("ES232", "Algebra", 9, 1, Semestar.Winter);
		Subject s3=new Subject("ES233", "Baze podataka 1", 8, 3, Semestar.Winter);
		Subject s4=new Subject("ES234", "Fizika", 9, 1, Semestar.Summer);
		courseList.add(s1);
		courseList.add(s3);
		courseList1.add(s2);
		courseList1.add(s3);
		courseList2.add(s4);
		courseList3.add(s1);
		courseList3.add(s3);
		courseList3.add(s4);
		
		
		
		
		
		
		
		this.professors = new ArrayList<Professor>();
		professors.add(new Professor("Milutinovic", "Milutin", "mmilutin@uns.ac.rs", LocalDate.parse("01-01-1960", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Lazina", "1", "Novi Sad", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "069123324", "20021", "Asistent", 1,courseList));
		professors.add(new Professor("Manjevic", "Mila", "mmila@uns.ac.rs", LocalDate.parse("12-05-1962", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Minjina", "15", "Novi Sad", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "062222222", "24521", "Docent", 21,courseList1));
		professors.add(new Professor("Strahinjic", "Vera", "svera@uns.ac.rs", LocalDate.parse("25-10-1949", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Filipova", "2", "Sremska Mitrovica", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "063234123", "22321", "Profesor", 15,courseList2));
		professors.add(new Professor("Milenovic", "Dragutin", "mdragutin@uns.ac.rs", LocalDate.parse("02-03-1989", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Suzanina", "3", "Beograd", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "069452231", "25521", "Vanredni profesor", 22,courseList3));
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
			return professor.getEmail();
		default:
			return null;	
		}
	}
	
	
	
	/*Methods for subjects */
	public String getSubjectColumnName(int index) {
		return this.subjects.get(index);
	}
	
	public String getSubjectValueAt(int row, int column) {
		Subject subject = ProfessorDB.getInstance().getRow(MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow()).getCourseList().get(row);
		switch(column) {
		case 0:
			return subject.getIdSubject();
		case 1:
			return subject.getName();
		case 2:
			return Integer.toString(subject.getYearOfStudySub());
		case 3:
			if(subject.getSemestar().equals(Semestar.Summer))
				return "Letnji";
			else
				return "Zimski";
		default:
			return null;
		}
	}
	
	public void removeSubject(Professor p,List<String> id) {
		for(int j = 0; j<id.size();j++) {
			for(int i =0; i<p.getCourseList().size();i++) {
				if(p.getCourseList().get(i).getIdSubject().equals(id.get(j))) {
					p.getCourseList().remove(i);
					break;
				}
			}
		}
	}
	
	public void addSubject(Professor p ,List<Subject> s) {
		for(int i =0 ;i<s.size();i++) {
			p.getCourseList().add(s.get(i));
		}
	}
	/*----------------------------------------------*/
	
	
	
	public boolean alreadyExists(String id) {
		for (Professor p : professors) {
			if(p.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	
	public void addProfessor(String surname, String name, String email, String birthDate, Adress homeAdress, Adress workAdress, String phoneNumber, String id, String calling, int experience) {
		this.professors.add(new Professor(surname, name, email, LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")), homeAdress, workAdress, phoneNumber, id, calling, experience,new ArrayList<Subject>()));
	}
	
	public void deleteProfessor(String id) {
		for (Professor p : professors) {
			if(p.getId().equals(id)) {
				professors.remove(p);
				break;
			}
		}
	}
	
	public void editProfessor(int selectedRowIndex, String surname, String name, String email, String birthDate, Adress homeAdress, Adress workAdress, String phoneNumber, String id, String calling, int experience) {
		Professor p = ProfessorDB.getInstance().getRow(selectedRowIndex);
		p.setSurname(surname);
		p.setName(name);
		p.setEmail(email);
		p.setBirthDate(LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		p.setHomeAdress(homeAdress);
		p.setWorkAdress(workAdress);
		p.setPhoneNumber(phoneNumber);
		p.setId(id);
		p.setCalling(calling);
		p.setExperience(experience);
	}
	
	
	

}
