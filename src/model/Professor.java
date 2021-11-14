package model;

import java.time.LocalDate;
import java.util.Set;

public class Professor {
	
	private String surname;
	private String name;
	private String email;
	private LocalDate birthDate;
	private Adress homeAdress;
	private Adress workAdress;
	private String phoneNumber;
	private String id;
	private String title;
	private int experience;
	private Set<Subject> courseList; 

	public Professor(String surname, String name, String email, LocalDate birthDate, Adress homeAdress,
			Adress workAdress, String phoneNumber, String id, String title, int experience, Set<Subject> courseList) {
		super();
		this.surname = surname;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.homeAdress = homeAdress;
		this.workAdress = workAdress;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.title = title;
		this.experience = experience;
		this.courseList = courseList;
	}
	
	
	public Set<Subject> getCourseList() {
		return courseList;
	}



	public void setCourseList(Set<Subject> courseList) {
		this.courseList = courseList;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
		

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}


	public Adress getHomeAdress() {
		return homeAdress;
	}


	public void setHomeAdress(Adress homeAdress) {
		this.homeAdress = homeAdress;
	}


	public Adress getWorkAdress() {
		return workAdress;
	}


	public void setWorkAdress(Adress workAdress) {
		this.workAdress = workAdress;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


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
	

}
