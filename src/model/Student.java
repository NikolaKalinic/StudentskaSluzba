package model;

import java.time.LocalDate;
import java.util.Set;

enum Status{B,S};

public class Student {
	/*Fields*/
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
	private Set<Subject> passedExams;  		
	private Set<Subject> failedExams;
	
	/*Constructor*/
	public Student(String surname, String name, LocalDate daateOfBirth, String adress, String phoneNumber, String email,
			String index, int yearOfEnrollment, int currYearOfStudy, Status status, double avgMark, Adress adress1,
			Set<Subject> passedExams, Set<Subject> failedExams) {
		super();
		this.surname = surname;
		this.name = name;
		this.dateOfBirth = daateOfBirth;
		this.adress = adress1;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.index = index;
		this.yearOfEnrollment = yearOfEnrollment;
		this.currYearOfStudy = currYearOfStudy;
		this.status = status;
		this.avgMark = avgMark;
		this.passedExams = passedExams;
		this.failedExams = failedExams;
	}

	/*Seters and geters*/
	public String getSurname() {
		return surname;
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

	public Set<Subject> getPassedExams() {
		return passedExams;
	}

	public void setPassedExams(Set<Subject> passedExams) {
		this.passedExams = passedExams;
	}

	public Set<Subject> getFailedExams() {
		return failedExams;
	}

	public void setFailedExams(Set<Subject> failedExams) {
		this.failedExams = failedExams;
	}
	
	
	
	
	
}
