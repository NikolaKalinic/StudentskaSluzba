package model;

import java.time.LocalDate;
import java.util.List;


public class Student {
	/*Fields*/
	private int key;
	private String surname;
	private String name;
	private LocalDate dateOfBirth;
	private Adress adress; 
	private String phoneNumber;
	private String email;
	private String index;
	private int yearOfEnrollment;
	private int currYearOfStudy;
	private Status status;
	private double avgMark;
	private List<Subject> passedExams;  		
	private List<Subject> failedExams;
	private List<Grades> grades;
	private int totalESPB;
	
	/*Constructor*/
	public Student(String surname, String name, LocalDate dateOfBirth, Adress adress, String phoneNumber, String email,
			String index, int yearOfEnrollment, int currYearOfStudy, Status status,List<Grades> grades) {
		super();
		this.surname = surname;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.index = index;
		this.yearOfEnrollment = yearOfEnrollment;
		this.currYearOfStudy = currYearOfStudy;
		this.status = status;
		this.grades=grades;
		this.avgMark = initAvg(grades);
		this.totalESPB=initEspb(grades);
	}
	
	public Student(String surname, String name, LocalDate dateOfBirth, Adress adress, String phoneNumber, String email,
			String index, int yearOfEnrollment, int currYearOfStudy, Status status,List<Grades> grades, List<Subject> failedExams) {
		super();
		this.surname = surname;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.index = index;
		this.yearOfEnrollment = yearOfEnrollment;
		this.currYearOfStudy = currYearOfStudy;
		this.status = status;
		this.grades=grades;
		this.avgMark = initAvg(grades);
		this.totalESPB=initEspb(grades);
		this.failedExams = failedExams;
	}
	
	public Student (String surname, String name, LocalDate dateOfBirth, Adress adress, String phoneNumber, String email,
			String index, int yearOfEnrollment, int currYearOfStudy, Status status) {
		super();
		this.surname = surname;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.index = index;
		this.yearOfEnrollment = yearOfEnrollment;
		this.currYearOfStudy = currYearOfStudy;
		this.status = status;
	}
	
	public Student (int key,String index,String name, String surname, int currYearOfStudy,LocalDate dateOfBirth, Adress adress, String phoneNumber, String email,
			 Status status,int yearOfEnrollment) {
		super();
		this.key=key;
		this.surname = surname;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.index = index;
		this.yearOfEnrollment = yearOfEnrollment;
		this.currYearOfStudy = currYearOfStudy;
		this.status = status;
	}
	
	public Student (int key,String index,String name, String surname, int currYearOfStudy,LocalDate dateOfBirth, Adress adress, String phoneNumber, String email,
			 Status status,int yearOfEnrollment,List<Grades> grades, List<Subject> failedExams) {
		super();
		this.key=key;
		this.surname = surname;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.index = index;
		this.yearOfEnrollment = yearOfEnrollment;
		this.currYearOfStudy = currYearOfStudy;
		this.status = status;
		this.grades=grades;
		this.avgMark = initAvg(grades);
		this.totalESPB=initEspb(grades);
		this.failedExams = failedExams;
	}
	/*Seters and geters*/
	
	private double initAvg(List<Grades> l) {
		if(l.isEmpty()) {
			return 0;
		}
		double sum=0;
		for(Grades g : l) {
			sum+=g.getGrades();
		}
		return sum/l.size();
	}
	private int initEspb(List<Grades> l) {
		int sum=0;
		for(Grades g:l) {
			sum+=g.getSubject().getEspb();
		}
		return sum;
	}
	
	public double getAverageMark(List<Grades> l) {
		if(l.isEmpty()){
			return 0;
		} 
		double sum = 0;
		for(Grades g : l) {
			sum += g.getGrades();
		}
		return sum/(l.size());
	}
	
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getTotalESPB(List<Grades> l) {
		int sum = 0;
		for(Grades g : l) {
			sum += g.getSubject().getEspb();
		}
		return sum;
	}
	
	public int getTotalESPB() {
		return totalESPB;
	}
	
	public void setTotalESPB(int totalESPB) {
		this.totalESPB = totalESPB;
	}
	public String getSurname() {
		return surname;
	}

	public List<Grades> getGrades() {
		return grades;
	}
	public void setGrades(List<Grades> grades) {
		this.grades = grades;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public LocalDate getDaateOfBirth() {
		return dateOfBirth;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public String getContactPhone() {
		return phoneNumber;
	}

	public void setContactPhone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public int getYearOfEnrollment() {
		return yearOfEnrollment;
	}

	public void setYearOfEnrollment(int yearOfEnrollment) {
		this.yearOfEnrollment = yearOfEnrollment;
	}

	public int getCurrYearOfStudy() {
		return currYearOfStudy;
	}

	public void setCurrYearOfStudy(int currYearOfStudy) {
		this.currYearOfStudy = currYearOfStudy;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getAvgMark() {
		return avgMark;
	}

	public void setAvgMark(double avgMark) {
		this.avgMark = avgMark;
	}

	public List<Subject> getPassedExams() {
		return passedExams;
	}

	public void setPassedExams(List<Subject> passedExams) {
		this.passedExams = passedExams;
	}

	public List<Subject> getFailedExams() {
		return failedExams;
	}

	public void setFailedExams(List<Subject> failedExams) {
		this.failedExams = failedExams;
	}
	@Override
	public String toString() {
		return "Student [surname=" + surname + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", adress=" + adress
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", index=" + index + ", yearOfEnrollment="
				+ yearOfEnrollment + ", currYearOfStudy=" + currYearOfStudy + ", status=" + status + ", avgMark="
				+ avgMark + ", passedExams=" + passedExams + ", failedExams=" + failedExams + "]";
	}
	
	
	
	
	
}
