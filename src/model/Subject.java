package model;

import java.util.Set;

enum Semestar {Summer,Winter};

public class Subject {
	/*Fields*/
	private String idSubject;
	private String name;
	private Semestar semestar;
	private int yearOfStudySub;
	private Professor professor;  						
	private int espb;
	private Set<Student> studentsPassed;
	private Set<Student> studentsFailed;
	
	public Subject() {}
	
	/*Constructors*/
	public Subject(String idSubject, String name, Semestar semestar, int yearOfStudySub, Professor profesor, int espb,
			Set<Student> studentsPassed, Set<Student> studentsFailed) {
		super();
		this.idSubject = idSubject;
		this.name = name;
		this.semestar = semestar;
		this.yearOfStudySub = yearOfStudySub;
		this.professor = profesor;
		this.espb = espb;
		this.studentsPassed = studentsPassed;
		this.studentsFailed = studentsFailed;
	}

	/* Seters and geters*/
	public String getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(String idSubject) {
		this.idSubject = idSubject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public int getYearOfStudySub() {
		return yearOfStudySub;
	}

	public void setYearOfStudySub(int yearOfStudySub) {
		this.yearOfStudySub = yearOfStudySub;
	}

	public Professor getProfesor() {
		return professor;
	}

	public void setProfesor(Professor profesor) {
		this.professor = profesor;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public Set<Student> getStudentsPassed() {
		return studentsPassed;
	}

	public void setStudentsPassed(Set<Student> studentsPassed) {
		this.studentsPassed = studentsPassed;
	}

	public Set<Student> getStudentsFailed() {
		return studentsFailed;
	}

	public void setStudentsFailed(Set<Student> studentsFailed) {
		this.studentsFailed = studentsFailed;
	}
	
	
	
	
}
