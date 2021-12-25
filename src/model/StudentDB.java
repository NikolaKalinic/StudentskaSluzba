 package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	}
	
	private void initStudent() {
		this.students=new ArrayList<Student>();
		students.add(new Student( "Perovic","Petar", LocalDate.of(2000,12,7),new Adress("Perina","1","Novi Sad","Srbija"), "06666666","petar@gmail.com","RA-1-2019",2019,3,Status.B));
		students.add(new Student( "Ivanovic","Ivan", LocalDate.of(2002,11,8),new Adress("Ivanova","2","Novi Sad","Srbija"), "06636666","ivan@gmail.com","RA-2-2019",2019,3,Status.S));
		students.add(new Student( "Markovic","Marko", LocalDate.of(2001,2,1),new Adress("Markova","3","Novi Sad","Srbija"), "06666266","marko@gmail.com","RA-3-2019",2019,3,Status.B));
		students.add(new Student( "Aleksic","Aleksa", LocalDate.of(2005,12,7),new Adress("Aleksina","4","Novi Sad","Srbija"), "062366666","Aleksa@gmail.com","SW-1-2019",2019,3,Status.B));
	}
	
	
	/*Getters and setters*/ 
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
	
	private boolean existsStudent(String id) {
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
			this.students.add(new Student(surname,name,dateOfBirth,adress,phoneNumber,email,index.toUpperCase(),yearOfEnrollment,currYearOfStudy,status));
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
				s.setIndex(index);
				s.setYearOfEnrollment(yearOfEnrollment);
				s.setCurrYearOfStudy(currYearOfStudy);
				s.setStatus(status);
		}else if (s.getIndex().equals(index)){
			s.setSurname(surname);
			s.setName(name);
			s.setDateOfBirth(date);
			s.setAdress(adress);
			s.setContactPhone(phoneNumber);
			s.setEmail(email);
			s.setIndex(index);
			s.setYearOfEnrollment(yearOfEnrollment);
			s.setCurrYearOfStudy(currYearOfStudy);
			s.setStatus(status);
		}else {
			System.out.println("Student sa tim indexom vec postoji.");
		}
	}
}
