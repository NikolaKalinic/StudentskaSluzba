package model;


import java.util.ArrayList;
import java.util.List;

public class SubjectDB {
	
	private static SubjectDB instance = null;
	
	public static SubjectDB getInstance() {
		if (instance == null) {
			instance = new SubjectDB();
		}
		return instance;
	}
	
	
	private List<Subject> subjects;
	private List<String> cols;
	
	private SubjectDB() {
		
		initSubjects();
		this.cols = new ArrayList<String>();
		this.cols.add("Sifra");
		this.cols.add("Naziv");
		this.cols.add("ESPB");
		this.cols.add("Godina");
		this.cols.add("Semestar");
	}
	
	private void initSubjects() {
		this.subjects = new ArrayList<Subject>();
		subjects.add(new Subject("ES231", "Matematicka analiza 1", 9, 1, Semestar.Winter));
		subjects.add(new Subject("ES232", "Algebra", 9, 1, Semestar.Winter));
		subjects.add(new Subject("ES233", "Baze podataka 1", 8, 3, Semestar.Winter));
		subjects.add(new Subject("ES234", "Fizika", 9, 1, Semestar.Summer));
		}
	
	/*getters/setter*/
	
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;	
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.cols.get(index);
	}
	
	public Subject getRow(int rowIndex) {
		return this.subjects.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Subject subject = this.subjects.get(row);
		switch (column) {
		case 0:
			return subject.getIdSubject();
		case 1:
			return subject.getName();
		case 2:
			return String.valueOf(subject.getEspb());
		case 3:
			return String.valueOf(subject.getYearOfStudySub());
		case 4:
			return subject.getSemestar().name();
		default:
			return null;	
		}
	}
	}