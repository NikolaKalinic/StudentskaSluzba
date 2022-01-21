package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import gui.MainFrame;
import gui.professor.MyProfessorPanel;

public class ProfessorDB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2080163250672036919L;
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
		this.cols.add(MainFrame.getInstance().getResourceBundle().getString("professorName"));
		this.cols.add(MainFrame.getInstance().getResourceBundle().getString("professorSurname"));
		this.cols.add(MainFrame.getInstance().getResourceBundle().getString("professorCalling"));
		this.cols.add(MainFrame.getInstance().getResourceBundle().getString("professorEmail"));
		
		
		this.subjects = new ArrayList<String>();
		this.subjects.add(MainFrame.getInstance().getResourceBundle().getString("subjectColId"));
		this.subjects.add(MainFrame.getInstance().getResourceBundle().getString("subjectColName"));
		this.subjects.add(MainFrame.getInstance().getResourceBundle().getString("subjectColYearOfStudy"));
		this.subjects.add(MainFrame.getInstance().getResourceBundle().getString("subjectColSemester"));
	}
	
	private void initProfessors() {
//		this.professors = new ArrayList<Professor>();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
//		professors.add(new Professor(1	,   "123123123",	"Milos"	,"Nikolic",	LocalDate.parse("12.12.1965.",formatter)	,new Adress("Šafarikova","2","Novi Sad","Srbija"),	"021/356-785",	"milos.nikolic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	30,	"REDOVNI_PROFESOR",new ArrayList<Subject>()));
//		professors.add(new Professor(2	,   "321321321",	"Nikola"	,"Mirkovic",	LocalDate.parse("01.01.1978.",formatter)	,new Adress("Nikole Tesle","56","Novi Sad","Srbija"),	"021/368-456",	"nikola.mirkovic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	22,	"REDOVNI_PROFESOR",new ArrayList<Subject>()));
//		professors.add(new Professor(3	,   "456456456",	"Ilija"	,"Petkovic",	LocalDate.parse("03.09.1988.",formatter)	,new Adress("Bulevar Patrijaha Pavla","3","Beograd","Srbija"),	"021/215-314",	"ilija.petkovic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	22,	"VANREDNI_PROFESOR",new ArrayList<Subject>()));
//		professors.add(new Professor(4	,   "789789789",	"Mitar"	,"Petrovic",	LocalDate.parse("25.07.1976.",formatter)	,new Adress("Stražilovska","6a","Novi Sad","Srbija"),	"021/884-640",	"mitar.petrovic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	27,	"VANREDNI_PROFESOR",new ArrayList<Subject>()));
//		professors.add(new Professor(5	,   "100100144",	"Vasa"	,"Micic",	LocalDate.parse("14.02.1970.",formatter)	,new Adress("Nikole Pašića","2d","Kikinda","Srbija"),	"021/212-114",	"vasa.micic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	24,	"DOCENT",new ArrayList<Subject>()));
//		professors.add(new Professor(6	,   "200020244",	"Srdjan"	,"Miletic",	LocalDate.parse("20.04.1966.",formatter)	,new Adress("Bulevar Kralja Petra","22","Niš","Srbija"),	"021/978-225",	"srdjan.miletic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	31,	"DOCENT",new ArrayList<Subject>()));
//		professors.add(new Professor(7	,   "559585632",	"Branislav"	,"Mihajlovic",	LocalDate.parse("28.06.1980.",formatter)	,new Adress("Tolstojeva","31","Novi Sad","Srbija"),	"021/778-323",	"branislav.mihajlovic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	13,	"REDOVNI_PROFESOR"	,new ArrayList<Subject>()));
//		professors.add(new Professor(8	,   "334968855",	"Marko"	,"Marković",	LocalDate.parse("31.01.1985.",formatter)	,new Adress("Marićeva","11","Kragujevac","Srbija"),	"021/899-659",	"marko.markovic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	17,	"REDOVNI_PROFESOR"	,new ArrayList<Subject>()));
//		professors.add(new Professor(9	,   "730703654",	"Miloš"	,"Milaković",	LocalDate.parse("21.09.1975.",formatter)	,new Adress("Stražilovska","3","Beograd","Srbija"),	"021/122-326",	"milos.milakovic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	12,	"VANREDNI_PROFESOR"	,new ArrayList<Subject>()));
//		professors.add(new Professor(10,	"600378644",	"Lazar"	,"Bratić",	LocalDate.parse("13.11.1973.",formatter)	,new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	"021/156-326",	"lazar.bratic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	3,	"VANREDNI_PROFESOR"	,new ArrayList<Subject>()));
//		professors.add(new Professor(11,	"158496152",	"Ljeposava"	,"Dražić",	LocalDate.parse("11.08.1964.",formatter)	,new Adress("Bulevar Kralja Petra","2d","Niš","Srbija"),	"021/888-156",	"ljeposava.drazic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	31,	"DOCENT"	,new ArrayList<Subject>()));
//		professors.add(new Professor(12,	"777348595",	"Miroljub"	,"Dragić",	LocalDate.parse("02.03.1959.",formatter)	,new Adress("Knez Mihajlova","22","Beograd","Srbija"),	"021/456-125",	"miroljub.dragic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	42,	"DOCENT"	,new ArrayList<Subject>()));
//		professors.add(new Professor(13,	"721254363",	"Bogdan"	,"Rekavić",	LocalDate.parse("23.06.1977.",formatter)	,new Adress("Bulevar Kralja Petra","22","Niš","Srbija"),	"021/886-455",	"bogdan.rekavic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	18,	"VANREDNI_PROFESOR"	,new ArrayList<Subject>()));
//		professors.add(new Professor(14,	"225533448",	"Stanka"	,"Milić",	LocalDate.parse("03.03.1991.",formatter)	,new Adress("Bulevar Patrijaha Pavla","3","Beograd","Srbija"),	"021/945-155",	"stanka.milic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	7,	"DOCENT"	,new ArrayList<Subject>()));
//		professors.add(new Professor(15,	"111555888",	"Milica"	,"Vuković",	LocalDate.parse("18.10.1967.",formatter)	,new Adress("Marićeva","11","Kragujevac","Srbija"),	"021/746-659",	"milica.vukovic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	14,	"VANREDNI_PROFESOR"	,new ArrayList<Subject>()));
//		professors.add(new Professor(16,	"300300344",	"Miša"	,"Mišić",	LocalDate.parse("20.10.1969.",formatter)	,new Adress("Šafarikova","2","Novi Sad","Srbija"),	"021/489-326",	"misa.misic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	19,	"DOCENT"	,new ArrayList<Subject>()));
//		professors.add(new Professor(17,	"400400444",	"Branko"	,"Maricić",	LocalDate.parse("18.01.1973.",formatter)	,new Adress("Nikole Tesle","56","Novi Sad","Srbija"),	"021/487-265",	"branko.maricic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	22,	"DOCENT"	,new ArrayList<Subject>()));
//		professors.add(new Professor(18,	"500500544",	"Branislav"	,"Lukovic",	LocalDate.parse("08.04.1982.",formatter)	,new Adress("Bulevar Patrijaha Pavla","3","Beograd","Srbija"),	"021/159-478",	"branislav.lukovic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	9,	"REDOVNI_PROFESOR"	,new ArrayList<Subject>()));
//		professors.add(new Professor(19,	"600600644",	"Branimir"	,"Obradović",	LocalDate.parse("07.01.1979.",formatter)	,new Adress("Šafarikova","2","Novi Sad","Srbija"),	"021/922-333",	"branimir.obradovic@mailinator.com",	new Adress("Nikole Pašića","6a","Novi Sad","Srbija"),	17,	"DOCENT"	,new ArrayList<Subject>()));
//		
//		save();
		File f = new File("professorDatebase.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			try {
				this.professors = (ArrayList<Professor>)ois.readObject();
				
			} finally {
				ois.close();
			}
		}catch(Exception e) {
			System.out.println("Nisam ucitao");
		}
	}
	
	public void save() {
		File f = new File("professorDatebase.txt");
		try {
			f.createNewFile();
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			try {
				oos.writeObject(professors);
			} finally {
				oos.close(); //Zatvara i tok nizeg nivoa.
			}
		}catch(Exception e) {
			System.out.println("Nisam uspeo");
		}
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
	
	public void editSubject(Subject s) {
		for(int i =0; i<professors.size();i++) {
			for(int j =0 ;j<professors.get(i).getCourseList().size();j++) {
				if(professors.get(i).getCourseList().get(j).getKey()==s.getKey()) {
					professors.get(i).getCourseList().get(j).setEspb(s.getEspb());
					professors.get(i).getCourseList().get(j).setIdSubject(s.getIdSubject());
					professors.get(i).getCourseList().get(j).setName(s.getName());
					professors.get(i).getCourseList().get(j).setSemestar(s.getSemestar());;
					professors.get(i).getCourseList().get(j).setYearOfStudySub(s.getYearOfStudySub());
					professors.get(i).getCourseList().get(j).setProfesor(s.getProfesor());
				}
			}
		}
	}
	public String getSubjectValueAt(int row, int column) {
		Subject subject = ProfessorDB.getInstance().getRow((MyProfessorPanel.getInstance().getProfessorTable().convertRowIndexToModel(MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow()))).getCourseList().get(row);
		switch(column) {
		case 0:
			return subject.getIdSubject();
		case 1:
			return subject.getName();
		case 2:
			return Integer.toString(subject.getYearOfStudySub());
		case 3:
			if(subject.getSemestar().equals(Semestar.Summer))
				return MainFrame.getInstance().getResourceBundle().getString("summer");
			else
				return MainFrame.getInstance().getResourceBundle().getString("winter");
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
		this.professors.add(new Professor(professors.get(professors.size()-1).getKey()+1,surname, name, email, LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")), homeAdress, workAdress, phoneNumber, id, calling, experience,new ArrayList<Subject>()));
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
