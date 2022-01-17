package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import gui.professor.MyProfessorPanel;

public class ProfessorDB {
	
	private static ProfessorDB instance = null;
	
	public static ProfessorDB getInstance() {
		if (instance == null) {
			instance = new ProfessorDB();
		}
		return instance;
	}
	
	
	private List<Professor> professors;
	private List<String> cols;
	private List<String> subjects;
	
	private ProfessorDB() {
		
		initProfessors();
		this.cols = new ArrayList<String>();
		this.cols.add("Ime");
		this.cols.add("Prezime");
		this.cols.add("Zvanje");
		this.cols.add("Email");
		
		
		this.subjects = new ArrayList<String>();
		this.subjects.add("Šifra predmeta");
		this.subjects.add("Naziv predmeta");
		this.subjects.add("Godina studija");
		this.subjects.add("Semestar");
	}
	
	private void initProfessors() {
		List<Subject> courseList = new ArrayList<Subject>();
		List<Subject> courseList1 = new ArrayList<Subject>();
		List<Subject> courseList2 = new ArrayList<Subject>();
		List<Subject> courseList3 = new ArrayList<Subject>();
		Subject s1=new Subject("ES231", "Matematicka analiza 1", 9, 1, Semestar.Winter);
		Subject s2=new Subject("ES232", "Algebra", 9, 1, Semestar.Winter);
		Subject s3=new Subject("ES233", "Baze podataka 1", 8, 3, Semestar.Winter);
		Subject s4=new Subject("ES234", "Fizika", 9, 1, Semestar.Summer);
		courseList.add(s1);
		courseList.add(s3);
		courseList1.add(s2);
		courseList1.add(s3);
		courseList2.add(s4);
		courseList3.add(s1);
		courseList3.add(s3);
		courseList3.add(s4);
		
		
		
		
		
		
		
		this.professors = new ArrayList<Professor>();
//		professors.add(new Professor("Milutinovic", "Milutin", "mmilutin@uns.ac.rs", LocalDate.parse("01-01-1960", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Lazina", "1", "Novi Sad", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "069123324", "20021", "Asistent", 1,courseList));
//		professors.add(new Professor("Manjevic", "Mila", "mmila@uns.ac.rs", LocalDate.parse("12-05-1962", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Minjina", "15", "Novi Sad", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "062222222", "24521", "Docent", 21,courseList1));
//		professors.add(new Professor("Strahinjic", "Vera", "svera@uns.ac.rs", LocalDate.parse("25-10-1949", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Filipova", "2", "Sremska Mitrovica", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "063234123", "22321", "Profesor", 15,courseList2));
//		professors.add(new Professor("Milenovic", "Dragutin", "mdragutin@uns.ac.rs", LocalDate.parse("02-03-1989", DateTimeFormatter.ofPattern("dd-MM-yyyy")), new Adress("Suzanina", "3", "Beograd", "Srbija"), new Adress("Mikina", "1", "Novi Sad", "Srbija"), "069452231", "25521", "Vanredni profesor", 22,courseList3));
		/*home adress*/
		Adress ak1 = new Adress("Šafarikova","2","Novi Sad","Srbija");
		Adress ak2 = new Adress("Nikole Tesle","56","Novi Sad","Srbija");
		Adress ak3 = new Adress("Bulevar Patrijaha Pavla","3","Beograd","Srbija");
		Adress ak4 = new Adress("Stražilovska","6a","Novi Sad","Srbija");
		Adress ak5 = new Adress("Nikole Pašića","2d","Kikinda","Srbija");
		Adress ak6 = new Adress("Bulevar Kralja Petra","22","Niš","Srbija");
		Adress ak7 = new Adress("Tolstojeva","31","Novi Sad","Srbija");
		Adress ak8 = new Adress("Marićeva","11","Kragujevac","Srbija");
		Adress ak9 = new Adress("Stražilovska","3","Beograd","Srbija");
		Adress ak10 = new Adress("Nikole Pašića","6a","Novi Sad","Srbija");
		Adress ak11 = new Adress("Bulevar Kralja Petra","2d","Niš","Srbija");
		Adress ak12 = new Adress("Knez Mihajlova","22","Beograd","Srbija");
		/*work adres*/

		Adress ap10 = new Adress("Nikole Pašića","6a","Novi Sad","Srbija");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		professors.add(new Professor(1	,   "123123123",	"Milos"	,"Nikolic",	LocalDate.parse("12.12.1965.",formatter)	,ak1,	"021/356-785",	"milos.nikolic@mailinator.com",	ap10,	30,	"REDOVNI_PROFESOR",new ArrayList<Subject>()));
		professors.add(new Professor(2	,   "321321321",	"Nikola"	,"Mirkovic",	LocalDate.parse("01.01.1978.",formatter)	,ak2,	"021/368-456",	"nikola.mirkovic@mailinator.com",	ap10,	22,	"REDOVNI_PROFESOR",new ArrayList<Subject>()));
		professors.add(new Professor(3	,   "456456456",	"Ilija"	,"Petkovic",	LocalDate.parse("03.09.1988.",formatter)	,ak3,	"021/215-314",	"ilija.petkovic@mailinator.com",	ap10,	22,	"VANREDNI_PROFESOR",new ArrayList<Subject>()));
		professors.add(new Professor(4	,   "789789789",	"Mitar"	,"Petrovic",	LocalDate.parse("25.07.1976.",formatter)	,ak4,	"021/884-640",	"mitar.petrovic@mailinator.com",	ap10,	27,	"VANREDNI_PROFESOR",new ArrayList<Subject>()));
		professors.add(new Professor(5	,   "100100144",	"Vasa"	,"Micic",	LocalDate.parse("14.02.1970.",formatter)	,ak5,	"021/212-114",	"vasa.micic@mailinator.com",	ap10,	24,	"DOCENT",new ArrayList<Subject>()));
		professors.add(new Professor(6	,   "200020244",	"Srdjan"	,"Miletic",	LocalDate.parse("20.04.1966.",formatter)	,ak6,	"021/978-225",	"srdjan.miletic@mailinator.com",	ap10,	31,	"DOCENT",new ArrayList<Subject>()));
		professors.add(new Professor(7	,   "559585632",	"Branislav"	,"Mihajlovic",	LocalDate.parse("28.06.1980.",formatter)	,ak7,	"021/778-323",	"branislav.mihajlovic@mailinator.com",	ap10,	13,	"REDOVNI_PROFESOR"	,new ArrayList<Subject>()));
		professors.add(new Professor(8	,   "334968855",	"Marko"	,"Marković",	LocalDate.parse("31.01.1985.",formatter)	,ak8,	"021/899-659",	"marko.markovic@mailinator.com",	ap10,	17,	"REDOVNI_PROFESOR"	,new ArrayList<Subject>()));
		professors.add(new Professor(9	,   "730703654",	"Miloš"	,"Milaković",	LocalDate.parse("21.09.1975.",formatter)	,ak9,	"021/122-326",	"milos.milakovic@mailinator.com",	ap10,	12,	"VANREDNI_PROFESOR"	,new ArrayList<Subject>()));
		professors.add(new Professor(10,	"600378644",	"Lazar"	,"Bratić",	LocalDate.parse("13.11.1973.",formatter)	,ak10,	"021/156-326",	"lazar.bratic@mailinator.com",	ap10,	3,	"VANREDNI_PROFESOR"	,new ArrayList<Subject>()));
		professors.add(new Professor(11,	"158496152",	"Ljeposava"	,"Dražić",	LocalDate.parse("11.08.1964.",formatter)	,ak11,	"021/888-156",	"ljeposava.drazic@mailinator.com",	ap10,	31,	"DOCENT"	,new ArrayList<Subject>()));
		professors.add(new Professor(12,	"777348595",	"Miroljub"	,"Dragić",	LocalDate.parse("02.03.1959.",formatter)	,ak12,	"021/456-125",	"miroljub.dragic@mailinator.com",	ap10,	42,	"DOCENT"	,new ArrayList<Subject>()));
		professors.add(new Professor(13,	"721254363",	"Bogdan"	,"Rekavić",	LocalDate.parse("23.06.1977.",formatter)	,ak6,	"021/886-455",	"bogdan.rekavic@mailinator.com",	ap10,	18,	"VANREDNI_PROFESOR"	,new ArrayList<Subject>()));
		professors.add(new Professor(14,	"225533448",	"Stanka"	,"Milić",	LocalDate.parse("03.03.1991.",formatter)	,ak3,	"021/945-155",	"stanka.milic@mailinator.com",	ap10,	7,	"DOCENT"	,new ArrayList<Subject>()));
		professors.add(new Professor(15,	"111555888",	"Milica"	,"Vuković",	LocalDate.parse("18.10.1967.",formatter)	,ak8,	"021/746-659",	"milica.vukovic@mailinator.com",	ap10,	14,	"VANREDNI_PROFESOR"	,new ArrayList<Subject>()));
		professors.add(new Professor(16,	"300300344",	"Miša"	,"Mišić",	LocalDate.parse("20.10.1969.",formatter)	,ak1,	"021/489-326",	"misa.misic@mailinator.com",	ap10,	19,	"DOCENT"	,new ArrayList<Subject>()));
		professors.add(new Professor(17,	"400400444",	"Branko"	,"Maricić",	LocalDate.parse("18.01.1973.",formatter)	,ak2,	"021/487-265",	"branko.maricic@mailinator.com",	ap10,	22,	"DOCENT"	,new ArrayList<Subject>()));
		professors.add(new Professor(18,	"500500544",	"Branislav"	,"Lukovic",	LocalDate.parse("08.04.1982.",formatter)	,ak3,	"021/159-478",	"branislav.lukovic@mailinator.com",	ap10,	9,	"REDOVNI_PROFESOR"	,new ArrayList<Subject>()));
		professors.add(new Professor(19,	"600600644",	"Branimir"	,"Obradović",	LocalDate.parse("07.01.1979.",formatter)	,ak1,	"021/922-333",	"branimir.obradovic@mailinator.com",	ap10,	17,	"DOCENT"	,new ArrayList<Subject>()));
		}
	
	/*getters/setter*/
	
	public List<Professor> getProfessors() {
		return professors;
	}
	public void setProfessors(List<Professor> professors) {
		this.professors = professors;	
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int index) {
		return this.cols.get(index);
	}
	
	public Professor getRow(int rowIndex) {
		return this.professors.get(rowIndex);
	}
	public Professor getProfWithKey(int _key) {
		for(int i = 0 ;i< professors.size();i++) {
			if(this.professors.get(i).getKey()==_key) {
				return this.professors.get(i);
			}
		}
		return this.professors.get(-1);
	}
	
	public String getValueAt(int row, int column) {
		Professor professor = this.professors.get(row);
		switch (column) {
		case 0:
			return professor.getName();
		case 1:
			return professor.getSurname();
		case 2:
			return professor.getCalling();
		case 3:
			return professor.getEmail();
		default:
			return null;	
		}
	}
	
	
	
	/*Methods for subjects */
	public String getSubjectColumnName(int index) {
		return this.subjects.get(index);
	}
	
	public String getSubjectValueAt(int row, int column) {
		Subject subject = ProfessorDB.getInstance().getRow(MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow()).getCourseList().get(row);
		switch(column) {
		case 0:
			return subject.getIdSubject();
		case 1:
			return subject.getName();
		case 2:
			return Integer.toString(subject.getYearOfStudySub());
		case 3:
			if(subject.getSemestar().equals(Semestar.Summer))
				return "Letnji";
			else
				return "Zimski";
		default:
			return null;
		}
	}
	
	public void removeSubject(Professor p,List<String> id) {
		for(int j = 0; j<id.size();j++) {
			for(int i =0; i<p.getCourseList().size();i++) {
				if(p.getCourseList().get(i).getIdSubject().equals(id.get(j))) {
					p.getCourseList().remove(i);
					break;
				}
			}
		}
	}
	
	public void addSubject(Professor p ,List<Subject> s) {
		for(int i =0 ;i<s.size();i++) {
			p.getCourseList().add(s.get(i));
		}
	}
	/*----------------------------------------------*/
	
	
	
	public boolean alreadyExists(String id) {
		for (Professor p : professors) {
			if(p.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	
	public void addProfessor(String surname, String name, String email, String birthDate, Adress homeAdress, Adress workAdress, String phoneNumber, String id, String calling, int experience) {
		this.professors.add(new Professor(surname, name, email, LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")), homeAdress, workAdress, phoneNumber, id, calling, experience,new ArrayList<Subject>()));
	}
	
	public void deleteProfessor(String id) {
		for (Professor p : professors) {
			if(p.getId().equals(id)) {
				professors.remove(p);
				break;
			}
		}
	}
	
	public void editProfessor(int selectedRowIndex, String surname, String name, String email, String birthDate, Adress homeAdress, Adress workAdress, String phoneNumber, String id, String calling, int experience) {
		Professor p = ProfessorDB.getInstance().getRow(selectedRowIndex);
		p.setSurname(surname);
		p.setName(name);
		p.setEmail(email);
		p.setBirthDate(LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		p.setHomeAdress(homeAdress);
		p.setWorkAdress(workAdress);
		p.setPhoneNumber(phoneNumber);
		p.setId(id);
		p.setCalling(calling);
		p.setExperience(experience);
	}
	
	
	

}
