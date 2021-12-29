 package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import gui.student.MyStudentPanel;

public class StudentDB {
	/*Singltone*/
	private static StudentDB instance = null;
	public static StudentDB getInstance() {
		if(instance==null) {
			instance=new StudentDB();
		}
		return instance;	
	}
	
	
	
	/*Field*/
	private List<Student> students;
	private List<String> colums;
	private List<String> passedComumns;
	
	
	/*Consturctor*/
	private StudentDB () {
		
		initStudent();
		this.colums = new ArrayList<String>();
		this.colums.add("Indeks");
		this.colums.add("Ime");
		this.colums.add("Prezime");
		this.colums.add("Godina studija");
		this.colums.add("Status");
		this.colums.add("Prosek");
		
		
		this.passedComumns = new ArrayList<String>();
		this.passedComumns.add("Šifra predmeta");
		this.passedComumns.add("Naziv predmeta");
		this.passedComumns.add("ESPB");
		this.passedComumns.add("Ocena");
		this.passedComumns.add("Datum");
	}
	
	private void initStudent() {
		Student s1 = new Student( "Perovic","Petar", LocalDate.of(2000,12,7),new Adress("Perina","1","Novi Sad","Srbija"), "06666666","petar@gmail.com","RA-1-2019",2019,3,Status.B);
		this.students=new ArrayList<Student>();
		List<Grades> grades = new ArrayList<Grades>();
		List<Grades> grades1 = new ArrayList<Grades>();
		List<Grades> grades2 = new ArrayList<Grades>();
		Grades g1 = new Grades(s1,new Subject("ES231", "Matematicka analiza 1", 9, 1, Semestar.Winter),7,LocalDate.of(2021, 6, 26));
		Grades g2 = new Grades(s1,new Subject("ES232", "Algebra", 9, 1, Semestar.Winter),8,LocalDate.of(2021, 1, 12));
		Grades g3 = new Grades(s1,new Subject("ES233", "Baze podataka 1", 8, 3, Semestar.Winter),10,LocalDate.of(2021, 6, 26));
		Grades g4 = new Grades(s1,new Subject("ES234", "Fizika", 9, 1, Semestar.Summer),9,LocalDate.of(2021, 6, 26));
		grades.add(g1);
		grades1.add(g2);
		grades1.add(g3);
		grades2.add(g4);
		grades2.add(g2);
		
		
		
		
		
		
		
		students.add(new Student( "Perovic","Petar", LocalDate.of(2000,12,7),new Adress("Perina","1","Novi Sad","Srbija"), "06666666","petar@gmail.com","RA-1-2019",2019,3,Status.B,grades1));
		students.add(new Student( "Ivanovic","Ivan", LocalDate.of(2002,11,8),new Adress("Ivanova","2","Novi Sad","Srbija"), "06636666","ivan@gmail.com","RA-2-2019",2019,3,Status.S,grades));
		students.add(new Student( "Markovic","Marko", LocalDate.of(2001,2,1),new Adress("Markova","3","Novi Sad","Srbija"), "06666266","marko@gmail.com","RA-3-2019",2019,3,Status.B,grades2));
		students.add(new Student( "Aleksic","Aleksa", LocalDate.of(2005,12,7),new Adress("Aleksina","4","Novi Sad","Srbija"), "062366666","Aleksa@gmail.com","SW-1-2019",2019,3,Status.B,grades));
	}
	
	
	/*Methods for student views*/
	public List<Student> getStudents(){
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students=students;
	}
	public int getColumnCount() {
		return 6;
	}
	public String getColumnName(int index) {
		return this.colums.get(index);
	}
	public Student getRow(int rowIndex) {
		return this.students.get(rowIndex);
	}
	public String getValueAt(int row, int column) {
		Student student = this.students.get(row);
		switch (column) {
		case 0:
			return student.getIndex();
		case 1:
			return student.getName();
		case 2:
			return student.getSurname();
		case 3:
			return Integer.toString(student.getCurrYearOfStudy());
		case 4:
			if(student.getStatus().equals(Status.B))
				return "Budzet";
			else
				return "Samofinansiranje";
		case 5: 
			return Double.toString(student.getAvgMark());
			
		default:
			return null;
		}
	}
	
	
	
	
	
	/*Methods for passed exams*/
	
	public String getPassedExamsColumnName(int index) {
		return this.passedComumns.get(index);
	}
	
	public String getPassedExamsValueAt(int row, int column) {
		Grades grades = StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().getSelectedRow()).getGrades().get(row);
		switch (column) {
		case 0:
			return grades.getSubject().getIdSubject();
		case 1:
			return grades.getSubject().getName();
		case 2:
			return Integer.toString(grades.getSubject().getEspb());
		case 3:
			return Integer.toString(grades.getGrades());
		case 4:
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			return grades.getDateExam().format(formatter);	
		default:
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*Add,delte,edit student methods*/
	public boolean existsStudent(String id) {
		for(Student s : students ) {
			String s1 = s.getIndex().toUpperCase();
			if(s1.equals(id.toUpperCase()))
				return false;		
		}
		return true;				
	}
	
	/*data manipulation methods*/
	public void addStudent(String surname, String name, LocalDate dateOfBirth, Adress adress, String phoneNumber, String email,
			String index, int yearOfEnrollment, int currYearOfStudy, Status status){
		if(existsStudent(index))
			this.students.add(new Student(surname,name,dateOfBirth,adress,phoneNumber,email,index.toUpperCase(),yearOfEnrollment,currYearOfStudy,status,new ArrayList<Grades>()));
	}
	
	public void deleteStudent(String index) {
		for (Student s : students) {
			if(s.getIndex().equals(index)) {
				students.remove(s);
				break;
			}
		}
	}
	
	public void editStudent(Student s,String surname, String name,LocalDate date, Adress adress, String phoneNumber, String email,
			String index, int yearOfEnrollment, int currYearOfStudy, Status status) {
		if(existsStudent(index)) {
				s.setSurname(surname);
				s.setName(name);
				s.setDateOfBirth(date);
				s.setAdress(adress);
				s.setContactPhone(phoneNumber);
				s.setEmail(email);
				s.setIndex(index.toUpperCase());
				s.setYearOfEnrollment(yearOfEnrollment);
				s.setCurrYearOfStudy(currYearOfStudy);
				s.setStatus(status);
		}else if (s.getIndex().equals(index.toUpperCase())){
			s.setSurname(surname);
			s.setName(name);
			s.setDateOfBirth(date);
			s.setAdress(adress);
			s.setContactPhone(phoneNumber);
			s.setEmail(email);
			s.setIndex(index.toUpperCase());
			s.setYearOfEnrollment(yearOfEnrollment);
			s.setCurrYearOfStudy(currYearOfStudy);
			s.setStatus(status);
		}else {
			System.out.println("Student sa tim indexom vec postoji.");
		}
	}
}
