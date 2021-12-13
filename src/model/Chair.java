package model;

import java.util.Set;

public class Chair {
	/*Fields*/
	private String idChair;
	private String nameOfChair;
	private String headOfChair; 		
	private Set<Professor> professors;
	
	/*Construcor*/
	public Chair(String idChair, String nameOfChair, String headOfChair, Set<Professor> professors) {
		super();
		this.idChair = idChair;
		this.nameOfChair = nameOfChair;
		this.headOfChair = headOfChair;
		this.professors = professors;
	}

	/*Getter and setter*/
	public String getIdChair() {
		return idChair;
	}

	public void setIdChair(String idChair) {
		this.idChair = idChair;
	}

	public String getNameOfChair() {
		return nameOfChair;
	}

	public void setNameOfChair(String nameOfChair) {
		this.nameOfChair = nameOfChair;
	}

	public String getHeadOfChair() {
		return headOfChair;
	}

	public void setHeadOfChair(String headOfChair) {
		this.headOfChair = headOfChair;
	}

	public Set<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(Set<Professor> professors) {
		this.professors = professors;
	}
	
	
	
	
	
}
