package model;

import java.time.LocalDate;
import java.util.List;

public class Professor {
	private int key;
	private String surname;
	private String name;
	private String email;
	private LocalDate birthDate;
	private Adress homeAdress;
	private Adress workAdress;
	private String phoneNumber;
	private String id;
	private String calling;
	private int experience;
	private List<Subject> courseList; 

	public Professor(String surname, String name, String email, LocalDate birthDate, Adress homeAdress,
			Adress workAdress, String phoneNumber, String id, String calling, int experience, List<Subject> courseList) {
		super();
		this.surname = surname;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.homeAdress = homeAdress;
		this.workAdress = workAdress;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.calling = calling;
		this.experience = experience;
		this.courseList = courseList;
	}
	public Professor(String name,String surname) {
		this.name=name;
		this.surname=surname;
	}
	
	
	public Professor(String surname, String name, String email, LocalDate birthDate, Adress homeAdress,
			Adress workAdress, String phoneNumber, String id, String calling, int experience) {
		super();
		this.surname = surname;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.homeAdress = homeAdress;
		this.workAdress = workAdress;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.calling = calling;
		this.experience = experience;
	}

	

	public Professor(int key, String id, String name, String surname, LocalDate birthDate, Adress homeAdress, String phoneNumber, String email,
			Adress workAdress, int experience, String calling,List<Subject> courseList) {
		super();
		this.key = key;
		this.surname = surname;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.homeAdress = homeAdress;
		this.workAdress = workAdress;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.calling = calling;
		this.experience = experience;
		this.courseList = courseList;
	}
	public List<Subject> getCourseList() {
		return courseList;
	}

	

	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public void setCourseList(List<Subject> courseList) {
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


	public String getCalling() {
		return calling;
	}



	public void setCalling(String calling) {
		this.calling = calling;
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
	
	public int getCallingIndex() {
		switch(this.getCalling()) {
		  case "REDOVNI_PROFESOR":
		    return 3;
		  case "VANREDNI_PROFESOR":
		    return 2;
		  case "DOCENT":
			return 1;
		  default:
		    return 0;
		}
	
	}
	
	public String getProfNameAndSurname() {
		String ret = name + " " + surname;
		return ret;
	}
	@Override
	public String toString() {
		return  surname + " " + name + " -- " + calling + " -- "
				+ experience;
	}
	

}
