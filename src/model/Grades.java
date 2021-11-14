package model;

import java.sql.Date;

public class Grades {
	/*Fields*/
	private Student studentPassed;
	private Subject subject;
	private int grades;
	private Date dateExam;
	
	/*Constructors*/
	public Grades(Student studentPassed, Subject subject, int grades, Date dateExam) {
		super();
		this.studentPassed = studentPassed;
		this.subject = subject;
		if(grades>5 && grades<=10)			/*Potential error*/
			this.grades = grades;
		this.dateExam = dateExam;
	}
	
	/*Getters and setters*/
	public Student getStudentPassed() {
		return studentPassed;
	}

	public void setStudentPassed(Student studentPassed) {
		this.studentPassed = studentPassed;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getGrades() {
		return grades;
	}

	public void setGrades(int grades){
		if(grades>5 && grades<=10)
			this.grades = grades;
		
	}

	public Date getDateExam() {
		return dateExam;
	}

	public void setDateExam(Date dateExam) {
		this.dateExam = dateExam;
	}
	
	
	
	
}
