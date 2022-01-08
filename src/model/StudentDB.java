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
	private List<Subject> notPassedSubjects;
	private List<String> colums;
	private List<String> passedComumns;
	private List<String> notPassedColumns;
	
	
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
		
		this.notPassedColumns = new ArrayList<String>();
		this.notPassedColumns.add("Šifra predmeta");
		this.notPassedColumns.add("Naziv predmeta");
		this.notPassedColumns.add("ESPB");
		this.notPassedColumns.add("Godina studija");
		this.notPassedColumns.add("Semestar");
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
		
		this.notPassedSubjects = new ArrayList<Subject>();
		notPassedSubjects.add(new Subject("ES235", "Metode optimizacije", 8, 3, Semestar.Winter));
		notPassedSubjects.add(new Subject("ES236", "OISISI", 6, 3, Semestar.Winter));
		notPassedSubjects.add(new Subject("ES234", "Fizika", 9, 1, Semestar.Summer));
		
		
		
		
		
		
		students.add(new Student( "Perovic","Petar", LocalDate.of(2000,12,7),new Adress("Perina","1","Novi Sad","Srbija"), "06666666","petar@gmail.com","RA-1-2019",2019,3,Status.B,grades1, notPassedSubjects));
		students.add(new Student( "Ivanovic","Ivan", LocalDate.of(2002,11,8),new Adress("Ivanova","2","Novi Sad","Srbija"), "06636666","ivan@gmail.com","RA-2-2019",2019,3,Status.S,grades,new ArrayList<Subject>()));
		students.add(new Student( "Markovic","Marko", LocalDate.of(2001,2,1),new Adress("Markova","3","Novi Sad","Srbija"), "06666266","marko@gmail.com","RA-3-2019",2019,3,Status.B,grades2,new ArrayList<Subject>()));
		students.add(new Student( "Aleksic","Aleksa", LocalDate.of(2005,12,7),new Adress("Aleksina","4","Novi Sad","Srbija"), "062366666","Aleksa@gmail.com","SW-1-2019",2019,3,Status.B,new ArrayList<Grades>(),new ArrayList<Subject>()));
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
		Grades grades = StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())).getGrades().get(row);
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
	
	
	/*Methods for not passed exams*/
	
	public String getNotPassedExamsColumnName(int index) {
		return this.notPassedColumns.get(index);
	}
	
	public String getNotPassedExamsValueAt(int row, int column) {
		Subject subject = StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())).getFailedExams().get(row);
		switch (column) {
		case 0:
			return subject.getIdSubject();
		case 1:
			return subject.getName();
		case 2:
			return Integer.toString(subject.getEspb());
		case 3:
			return Integer.toString(subject.getYearOfStudySub());
		case 4:
			if(subject.getSemestar().equals(Semestar.Summer))
				return "Letnji";
			else
				return "Zimski";
		default:
			return null;
		}
	}
	public void deleteFailedExam(Student s,String id) {
		for(int i =0 ; i<s.getFailedExams().size();i++) {
			if(s.getFailedExams().get(i).getIdSubject().equals(id)){
				s.getFailedExams().remove(s.getFailedExams().get(i));
				break;
			}
		}
	}
	public void addSubjectToFailed(Student student,Subject s) {
		student.getFailedExams().add(s);
	}
	
	
	public void addGrade(Student student, Grades grade) {
		for(int i = 0 ; i<student.getFailedExams().size();i++) {
			if(student.getFailedExams().get(i).getIdSubject().equals(grade.getSubject().getIdSubject())){
				student.getFailedExams().remove(student.getFailedExams().get(i));
				break;
			}
		}
		student.getGrades().add(grade);
	}
	
	public void cancelGrade(Student student, Grades grade) {
		for(int i = 0 ; i < student.getGrades().size(); i++) {
			if(student.getGrades().get(i).getSubject().getIdSubject().equals(grade.getSubject().getIdSubject())){
				student.getGrades().remove(student.getGrades().get(i));
				break;
			}
		}
		student.getFailedExams().add(grade.getSubject());
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
			this.students.add(new Student(surname,name,dateOfBirth,adress,phoneNumber,email,index.toUpperCase(),yearOfEnrollment,currYearOfStudy,status,new ArrayList<Grades>(),new ArrayList<Subject>()));
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
