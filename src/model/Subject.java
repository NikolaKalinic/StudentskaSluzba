package model;

import java.io.Serializable;
import java.util.List;



public class Subject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7399269298579518184L;
	/*Fields*/
	private int key;
	private String idSubject;
	private String name;
	private Semestar semestar;
	private int yearOfStudySub;
	private Professor professor;  						
	private int espb;
	private List<Student> studentsPassed;
	private List<Student> studentsFailed;
	
	public Subject() {}
	
	/*Constructors*/	
	public Subject(int key,String idSubject, String name, Semestar semestar, int yearOfStudySub, Professor profesor, int espb) {
		super();
		this.key=key;
		this.idSubject = idSubject;
		this.name = name;
		this.semestar = semestar;
		this.yearOfStudySub = yearOfStudySub;
		this.professor = profesor;
		this.espb = espb;
	}
	public Subject(int key,String idSbuject,String name,int yearOfStudySub,int espb,Professor p,Semestar semestar) {
		this.key=key;
		this.idSubject = idSbuject;
		this.name = name;
		this.espb = espb;
		this.yearOfStudySub = yearOfStudySub;
		this.semestar = semestar;
		this.professor=p;
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
	
	public void removeProfessor() {
		this.professor = null;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int id) {
		this.key = id;
	}
	
	public List<Student> getStudentsPassed() {
		return studentsPassed;
	}

	public void setStudentsPassed(List<Student> studentsPassed) {
		this.studentsPassed = studentsPassed;
	}

	public List<Student> getStudentsFailed() {
		return studentsFailed;
	}

	public void setStudentsFailed(List<Student> studentsFailed) {
		this.studentsFailed = studentsFailed;
	}

	@Override
	public String toString() {
		return  idSubject + "  -  " + name;
	}
	
	
	
	
}
