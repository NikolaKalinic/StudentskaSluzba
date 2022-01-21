package model;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gui.MainFrame;

public class SubjectDB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8755389994193550307L;
	private static SubjectDB instance = null;
	
	public static SubjectDB getInstance() {
		if (instance == null) {
			instance = new SubjectDB();
		}
		return instance;
	}
	
	
	private List<Subject> subjects;
	private List<String> cols;
	
	private SubjectDB() {
		
		initSubjects();
		this.cols = new ArrayList<String>();
		this.cols.add("Sifra");
		this.cols.add("Naziv");
		this.cols.add("ESPB");
		this.cols.add("Godina");
		this.cols.add("Semestar");
	}
	
	private void initSubjects() {
//		this.subjects = new ArrayList<Subject>();
//
//		subjects.add(new Subject(1	,   "p1"    ,"osnove programiranja"	    	    ,1,	7	,ProfessorDB.getInstance().getProfWithKey(2),Semestar.Winter));
//		subjects.add(new Subject(2	,   "p2"    ,"statistika"		        	    ,3,	8	,ProfessorDB.getInstance().getProfWithKey(2)	    ,Semestar.Summer));
//		subjects.add(new Subject(3	,   "p3"    ,"algoritmi i strukture podataka"	,2,	9	,ProfessorDB.getInstance().getProfWithKey(2)	    ,Semestar.Summer));
//		subjects.add(new Subject(4	,   "p4"    ,"LPRS"				                ,3,	7	,ProfessorDB.getInstance().getProfWithKey(2)	    ,Semestar.Winter));
//		subjects.add(new Subject(5	,   "p5"    ,"matematika"			            ,1,	11	,null	,Semestar.Summer));
//		subjects.add(new Subject(6	,   "p6"    ,"xml i web servisi"	           	,4,	6	,null	,Semestar.Summer));
//		subjects.add(new Subject(7	,   "p7"    ,"Metode optimizacije"		        ,3,	6	,null	,Semestar.Winter));
//		subjects.add(new Subject(8	,   "p8"    ,"osnove elektortehnike"		    ,1,	11	,ProfessorDB.getInstance().getProfWithKey(5)	    ,Semestar.Summer));
//		subjects.add(new Subject(9	,   "p9"    ,"Sociologija"			            ,1,	10	,ProfessorDB.getInstance().getProfWithKey(5)	    ,Semestar.Winter));
//		subjects.add(new Subject(10,	"p10"	,"Filozofija"		            	,1,	4	,ProfessorDB.getInstance().getProfWithKey(5)	    ,Semestar.Winter));
//		subjects.add(new Subject(11,	"p11"	,"ORT"				                ,2,	7	,null	,Semestar.Summer));
//		subjects.add(new Subject(12,	"p12"	,"NANS"				                ,2,	5	,ProfessorDB.getInstance().getProfWithKey(6)	    ,Semestar.Summer));
//		subjects.add(new Subject(13,	"p13"	,"Organizacija podataka"		    ,2,	7	,ProfessorDB.getInstance().getProfWithKey(6)	    ,Semestar.Winter));
//		subjects.add(new Subject(14,	"p14"	,"Baze podataka"			        ,2,	6	,ProfessorDB.getInstance().getProfWithKey(6)	    ,Semestar.Winter));
//		subjects.add(new Subject(15,	"p15"	,"paralelno programiranje"		    ,2,	8	,ProfessorDB.getInstance().getProfWithKey(7)	    ,Semestar.Winter));
//		subjects.add(new Subject(16,	"p16"	,"konkurentno programiranje"	    ,2,	9	,ProfessorDB.getInstance().getProfWithKey(7)	    ,Semestar.Summer));
//		subjects.add(new Subject(17,	"p17"	,"Operativni sistemi"		        ,2,	8	,null	,Semestar.Summer));
//		subjects.add(new Subject(18,	"p18"	,"Algebra"				            ,1,	15	,null	,Semestar.Winter));
//		subjects.add(new Subject(19,	"p19"	,"Diskretna matematika"		        ,3,	14	,null	,Semestar.Summer));
//		subjects.add(new Subject(20,	"ps20"	,"Upravljacki sistemi"		        ,3,	8	,null	,Semestar.Summer));
//		subjects.add(new Subject(21,	"ps21"	,"Osnovi elektronike"		        ,2,	7	,null	,Semestar.Winter));
//		subjects.add(new Subject(22,	"ps22"	,"Slucajni procesi"		            ,4,	9	,null	,Semestar.Summer));
//		subjects.add(new Subject(23,	"ps23"	,"Racunarstvo visokih performansi"	,4,	10	,null	,Semestar.Summer));
//		subjects.add(new Subject(24,	"p24"	,"Analiza 1"			            ,1,	20	,null	,Semestar.Winter));
//		subjects.add(new Subject(25,	"it25"	,"Informaciona bezbednost"		    ,4,	9	,ProfessorDB.getInstance().getProfWithKey(17)  	,Semestar.Summer));
//		subjects.add(new Subject(26,	"it26"	,"Elektronsko placanje"		        ,3,	8	,ProfessorDB.getInstance().getProfWithKey(18)  	,Semestar.Winter));
//		subjects.add(new Subject(27,	"it27"	,"Distribuirani sistemi"		    ,4,	6	,ProfessorDB.getInstance().getProfWithKey(19)	    ,Semestar.Summer));
//		subjects.add(new Subject(28,	"p28"	,"Projektovanje softvera"		    ,3,	5	,ProfessorDB.getInstance().getProfWithKey(18)	    ,Semestar.Winter));
//		subjects.add(new Subject(29,	"p29"	,"Informacioni sistemi"		        ,4,	6	,ProfessorDB.getInstance().getProfWithKey(17)	    ,Semestar.Winter));
//		subjects.add(new Subject(30,	"p30"	,"Masinsko ucenje"			        ,4,	7	,null	,Semestar.Summer));
//		
//		ProfessorDB.getInstance().getProfessors().get(1).getCourseList().add(subjects.get(0));
//		ProfessorDB.getInstance().getProfessors().get(1).getCourseList().add(subjects.get(1));
//		ProfessorDB.getInstance().getProfessors().get(1).getCourseList().add(subjects.get(2));
//		ProfessorDB.getInstance().getProfessors().get(1).getCourseList().add(subjects.get(3));
//		ProfessorDB.getInstance().getProfessors().get(4).getCourseList().add(subjects.get(7));
//		ProfessorDB.getInstance().getProfessors().get(4).getCourseList().add(subjects.get(8));
//		ProfessorDB.getInstance().getProfessors().get(4).getCourseList().add(subjects.get(9));
//		ProfessorDB.getInstance().getProfessors().get(5).getCourseList().add(subjects.get(12));
//		ProfessorDB.getInstance().getProfessors().get(5).getCourseList().add(subjects.get(13));
//		ProfessorDB.getInstance().getProfessors().get(5).getCourseList().add(subjects.get(11));
//		ProfessorDB.getInstance().getProfessors().get(6).getCourseList().add(subjects.get(14));
//		ProfessorDB.getInstance().getProfessors().get(6).getCourseList().add(subjects.get(15));
//		ProfessorDB.getInstance().getProfessors().get(16).getCourseList().add(subjects.get(24));
//		ProfessorDB.getInstance().getProfessors().get(16).getCourseList().add(subjects.get(28));
//		ProfessorDB.getInstance().getProfessors().get(17).getCourseList().add(subjects.get(27));
//		ProfessorDB.getInstance().getProfessors().get(17).getCourseList().add(subjects.get(25));
//		ProfessorDB.getInstance().getProfessors().get(18).getCourseList().add(subjects.get(26));
//		
//		save();
		File f = new File("subjectDatebase.txt");
		try {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
			try {
				this.subjects = (ArrayList<Subject>)ois.readObject();
				
			} finally {
				ois.close();
			}
		}catch(Exception e) {
			System.out.println("Nisam ucitao");
		}

	}
	
	
	public void save() {
		File f = new File("subjectDatebase.txt");
		try {
			f.createNewFile();
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			try {
				oos.writeObject(subjects);
			} finally {
				oos.close(); //Zatvara i tok nizeg nivoa.
			}
		}catch(Exception e) {
		System.out.println("Nisam uspeo");
		}
	}
	/*getters/setter*/
	
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;	
	}
	public Subject getSubjectWithKey(int _key) {
		for(int i = 0 ;i< subjects.size();i++) {
			if(this.subjects.get(i).getKey()==_key) {
				return this.subjects.get(i);
			}
		}
		return this.subjects.get(-1);
	}
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.cols.get(index);
	}
	
	public Subject getRow(int rowIndex) {
		return this.subjects.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Subject subject = this.subjects.get(row);
		switch (column) {
		case 0:
			return subject.getIdSubject();
		case 1:
			return subject.getName();
		case 2:
			return String.valueOf(subject.getEspb());
		case 3:
			return String.valueOf(subject.getYearOfStudySub());
		case 4:
			if(subject.getSemestar().equals(Semestar.Summer))
				return MainFrame.getInstance().getResourceBundle().getString("summer");
			else
				return MainFrame.getInstance().getResourceBundle().getString("winter");
		default:
			return null;	
		}
	}
	public boolean existsSubject(String id) {
		for(Subject s : subjects ) {
			String s1 = s.getIdSubject().toUpperCase();
			if(s1.equals(id.toUpperCase()))
				return false;
		}
		return true;
	}
	
	public void addSubject(String idSubject, String name, Semestar semestar, int yearOfStudySub, Professor profesor, int espb) {
		if(existsSubject(idSubject))
			this.subjects.add(new Subject(subjects.get(subjects.size()-1).getKey()+1,idSubject,name, semestar, yearOfStudySub, profesor, espb));
	}
	public void editSubject(Subject s,String idSubject, String name, Semestar semestar, int yearOfStudySub, Professor profesor, int espb) {

				s.setIdSubject(idSubject);
				s.setName(name);
				s.setSemestar(semestar);
				s.setYearOfStudySub(yearOfStudySub);
				s.setProfesor(profesor);
				s.setEspb(espb);

	}
	
	public void deleteSubject(String id) {
		for (Subject s : subjects) {
			if(s.getIdSubject().equals(id)) {
				subjects.remove(s);
				break;
			}
		}
	}
	
	}