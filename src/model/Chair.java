package model;


import java.util.ArrayList;
import java.util.List;

public class Chair {
	/*Fields*/
	private int key;
	private String idChair;
	private String nameOfChair;
	private Professor headOfChair; 		
	private List<Professor> professors;
	
	/*Construcor*/
	public Chair(String idChair, String nameOfChair, List<Professor> professors) {
		super();
		this.idChair = idChair;
		this.nameOfChair = nameOfChair;
//		this.headOfChair=new Professor("Strahinjic", "Vera", "svera@uns.ac.rs", LocalDate.parse("25-10-1949", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Filipova", "2", "Sremska Mitrovica", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "063234123", "22321", "Profesor", 15);
		this.professors = professors;
	}
	public Chair(String idChair, String nameOfChair) {
		super();
		this.idChair = idChair;
		this.nameOfChair = nameOfChair;
		this.professors= new ArrayList<Professor>();
	}
	

	public Chair(int key, String idChair, String nameOfChair, Professor headOfChair,List<Professor> professors) {
		super();
		this.key = key;
		this.idChair = idChair;
		this.nameOfChair = nameOfChair;
		this.headOfChair = headOfChair;
		this.professors = professors;
	}
	/*Getter and setter*/
	public String getIdChair() {
		return idChair;
	}
	
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
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

	public Professor getHeadOfChair() {
		return headOfChair;
	}

	public void setHeadOfChair(Professor headOfChair) {
		this.headOfChair = headOfChair;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}
	
	
	
	
	
}
