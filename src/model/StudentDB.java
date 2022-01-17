 package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import gui.student.MyStudentPanel;

public class StudentDB {
	/*Singltone*/
	private static StudentDB instance = null;
	public static StudentDB getInstance() {
		if(instance==null) {
			instance=new StudentDB();
		}
		return instance;	
	}
	
	
	
	/*Field*/
	private List<Student> students;
	private List<Subject> notPassedSubjects;
	private List<String> colums;
	private List<String> passedComumns;
	private List<String> notPassedColumns;
	
	
	/*Consturctor*/
	private StudentDB () {
		
		initStudent();
		this.colums = new ArrayList<String>();
		this.colums.add("Indeks");
		this.colums.add("Ime");
		this.colums.add("Prezime");
		this.colums.add("Godina studija");
		this.colums.add("Status");
		this.colums.add("Prosek");
		
		
		this.passedComumns = new ArrayList<String>();
		this.passedComumns.add("Šifra predmeta");
		this.passedComumns.add("Naziv predmeta");
		this.passedComumns.add("ESPB");
		this.passedComumns.add("Ocena");
		this.passedComumns.add("Datum");
		
		this.notPassedColumns = new ArrayList<String>();
		this.notPassedColumns.add("Šifra predmeta");
		this.notPassedColumns.add("Naziv predmeta");
		this.notPassedColumns.add("ESPB");
		this.notPassedColumns.add("Godina studija");
		this.notPassedColumns.add("Semestar");
	}
	
	private void initStudent() {
		Student s1 = new Student( "Perovic","Petar", LocalDate.of(2000,12,7),new Adress("Perina","1","Novi Sad","Srbija"), "06666666","petar@gmail.com","RA-1-2019",2019,3,Status.B);
		this.students=new ArrayList<Student>();
		List<Grades> grades = new ArrayList<Grades>();
		List<Grades> grades1 = new ArrayList<Grades>();
		List<Grades> grades2 = new ArrayList<Grades>();
		Grades g1 = new Grades(s1,new Subject("ES231", "Matematicka analiza 1", 9, 1, Semestar.Winter),7,LocalDate.of(2021, 6, 26));
		Grades g2 = new Grades(s1,new Subject("ES232", "Algebra", 9, 1, Semestar.Winter),8,LocalDate.of(2021, 1, 12));
		Grades g3 = new Grades(s1,new Subject("ES233", "Baze podataka 1", 8, 3, Semestar.Winter),10,LocalDate.of(2021, 6, 26));
		Grades g4 = new Grades(s1,new Subject("ES234", "Fizika", 9, 1, Semestar.Summer),9,LocalDate.of(2021, 6, 26));
		
		
		grades.add(g1);
		grades1.add(g2);
		grades1.add(g3);
		grades2.add(g4);
		grades2.add(g2);
		
		this.notPassedSubjects = new ArrayList<Subject>();
		notPassedSubjects.add(new Subject("ES235", "Metode optimizacije", 8, 3, Semestar.Winter));
		notPassedSubjects.add(new Subject("ES236", "OISISI", 6, 3, Semestar.Winter));
		notPassedSubjects.add(new Subject("ES234", "Fizika", 9, 1, Semestar.Summer));
		
		
		
		
		
		/* TESTIIIIIIIIIIIIIIIIIIIING */
		Adress l1 = new Adress("Šafarikova","2","Novi Sad","Srbija");
		Adress l2 = new Adress("Nikole Tesle","56","Novi Sad","Srbija");
		Adress l3 = new Adress("Bulevar Patrijaha Pavla","3","Beograd","Srbija");
		Adress l4 = new Adress("Stražilovska","6a","Novi Sad","Srbija");
		Adress l5 = new Adress("Nikole Pašića","2d","Kikinda","Srbija");
		Adress l6 = new Adress("Bulevar Kralja Petra","22","Niš","Srbija");
		Adress l7 = new Adress("Tolstojeva","31","Novi Sad","Srbija");
		Adress l8 = new Adress("Marićeva","11","Kragujevac","Srbija");
		Adress l9 = new Adress("Stražilovska","3","Beograd","Srbija");
		Adress l10 = new Adress("Nikole Pašića","6a","Novi Sad","Srbija");
		Adress l11 = new Adress("Bulevar Kralja Petra","2d","Niš","Srbija");
		Adress l12 = new Adress("Knez Mihajlova","22","Beograd","Srbija");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		
		List<Subject> student4 = new ArrayList<Subject>();
		student4.add(SubjectDB.getInstance().getSubjectWithKey(2));
		student4.add(SubjectDB.getInstance().getSubjectWithKey(4));
		List<Subject> student17 = new ArrayList<Subject>();
		student17.add(SubjectDB.getInstance().getSubjectWithKey(15));
		List<Subject> student18 = new ArrayList<Subject>();
		student18.add(SubjectDB.getInstance().getSubjectWithKey(15));
		List<Subject> student22 = new ArrayList<Subject>();
		student22.add(SubjectDB.getInstance().getSubjectWithKey(18));
		student22.add(SubjectDB.getInstance().getSubjectWithKey(19));
		List<Subject> student23 = new ArrayList<Subject>();
		student23.add(SubjectDB.getInstance().getSubjectWithKey(18));
		student23.add(SubjectDB.getInstance().getSubjectWithKey(19));
		List<Subject> student24 = new ArrayList<Subject>();
		student24.add(SubjectDB.getInstance().getSubjectWithKey(18));
		student24.add(SubjectDB.getInstance().getSubjectWithKey(19));
		List<Subject> student26 = new ArrayList<Subject>();
		student26.add(SubjectDB.getInstance().getSubjectWithKey(18));
		student26.add(SubjectDB.getInstance().getSubjectWithKey(19));
		
		
		students.add(new Student(1,"RA 2/2020",  "Marko","Milosevic",1,	LocalDate.parse("12.03.2001.",formatter),	l1	  , "021/333-555","marko.milosevic@mailinator.com",Status.B,	2020,new ArrayList<Grades>(),new ArrayList<Subject>()));
		students.add(new Student(2,"RA 3/2019",  "Marija","Milić",2,	LocalDate.parse("12.01.2000.",formatter),	l2	  , "021/555-2222","marija.milic@mailinator.com",Status.S,	2019,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(3,"RA 3/2017" , "Nikola","Nikolic",1,	LocalDate.parse("30.08.2001.",formatter),	l3	  , "021/135-463","nikola.nikolic@mailinator.com",Status.B,	2017,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(4,"RA 134/2015",	  "Pera","Peric",3,	LocalDate.parse("07.06.1995.",formatter),	l4	  , " 021/903-463","pera.peric@mailinator.com",Status.S,	2015,new ArrayList<Grades>(),student4));	
		students.add(new Student(5,"RA 5/2019",  "Sofija","Ilic",3,	LocalDate.parse("06.05.1999.",formatter),	l5	  , " 021/731-067","sofija.ilic@mailinator.com",Status.B,	2019,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(6,"RA 8/2018",	  "Martina","Lukic",3,	LocalDate.parse("16.05.1999.",formatter),	l6	  , "011/4333-800","martina.lukic@mailinator.com",Status.S,	2018,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(7,"RA 10/2017",	  "Stojan","Stojakovic",1,	LocalDate.parse("19.10.2001.",formatter),	l7	  , "011/3130-007","stojan.stojakovic@mailinator.com",Status.B,	2017,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(8,"RA 12/2017", 	  "Milan","Milanovic",2,	LocalDate.parse("02.11.2000.",formatter),	l8	  , "015/313-061","milan.milanovic@mailinator.com",Status.S,	2017,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(9,"RA 16/2019",	  "Miroslav","Milic",2,	LocalDate.parse("11.10.2000.",formatter),	l9	  , "021/351-091","miroslav.milic@mailinator.com",Status.B,	2019,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(10,"RA 21/2015",	  "Stefan","Gojic",3,	LocalDate.parse("01.05.1999.",formatter),	l10	 , "015/324-500","stefan.gojic@mailinator.com",Status.S,	2015,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(11,"RA 9/2020",  "Anastasija","Jokic",3,	LocalDate.parse("11.07.1999.",formatter),	l11	 , "011/2333-900","anastasija.jokic@mailinator.com",Status.B,	2020,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(12,"RA 4/2017" , "Bogdan","Bogdanovic",3,	LocalDate.parse("23.07.1999.",formatter),	l12	 , "021/231-231","bogdan.bogdanovic@mailinator.com",Status.S,	2017,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(13,"RA 30/2019",	  "Ana","Dabovic",1,	LocalDate.parse("12.12.2001.",formatter),	null,	"014/303-007","ana.dabovic@mailinator.com",Status.B,	2019,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(14,"RA 1/2020",  "Mika","Mikic",1,	LocalDate.parse("05.11.2001.",formatter),	l2	  , "015/101-909","mika.mikic@mailinator.com",Status.S,	2020,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(15,"RA 11/2018",	  "Jovan","Deretic",4,	LocalDate.parse("10.09.1998.",formatter),	l3	  , "002/200-300","jovan.deretic@mailinator.com",Status.B,	2018,new ArrayList<Grades>(), new ArrayList<Subject>()));	
		students.add(new Student(16,"RA 12/2018",	  "Nikola","Miskovic",4,	LocalDate.parse("03.08.1998.",formatter),	l4	  , "022/123-456","nikola.miskovic@mailinator.com",Status.S,	2018,new ArrayList<Grades>(), new ArrayList<Subject>()));	
		students.add(new Student(17,"RA 13/2018",	  "Martin","Stojanovic",4,	LocalDate.parse("01.05.1998.",formatter),	null,	"024/321-775","martin.stojanovic@mailinator.com",Status.S,	2018,new ArrayList<Grades>(),student17));	
		students.add(new Student(18,"RA 14/2018",    "Tomislav","Novakovic",4,	LocalDate.parse("25.02.1996.",formatter),	l6	  , "011/1188-379","tomislav.novakovic@mailinator.com",Status.B,	2018,new ArrayList<Grades>(),student18));	
		students.add(new Student(19,"RA 154/2016",	  "Lena","Ivic",4,	LocalDate.parse("11.05.1998.",formatter),	l7	  , "024/333-555","lena.ivic@mailinator.com",Status.B,	2016,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(20,"RA 23/2020"	, "Jovan","Lazic",1,	LocalDate.parse("22.01.2001.",formatter),	l8	  , "025/1189-479","jovan.lazic@mailinator.com",Status.B,	2020,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(21,"RA 1/2019" , "Isidora","Mikic",2,	LocalDate.parse("31.12.2000.",formatter),	l9	  , "011/1122-366","isidora.mikic@mailinator.com ",Status.B,	2019,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(22,"SW 4/2014" , "Vladimir","Ilic",4,	LocalDate.parse("31.08.1998.",formatter),	l10	 , "0211122-367","vladimir.ilic@mailinator.com",Status.B,	2014,new ArrayList<Grades>(),student22));	
		students.add(new Student(23,"SW 17/2015",	  "Mirko","Alicic",3,	LocalDate.parse("21.07.1999.",formatter),	l11	 , "012/1122-368","mirko.alicic@mailinator.com",Status.S,	2015,new ArrayList<Grades>(),student23));	
		students.add(new Student(24,"SW 17/2016",	  "Milisav","Perković",4,	LocalDate.parse("28.09.1998.",formatter),	l12	 , "012/1122-369","milisav.pejkovic@mailinator.com",Status.S,	2016,new ArrayList<Grades>(),student24));	
		students.add(new Student(25,"SW 27/2018",	  "Purisa","Djordjević",2,	LocalDate.parse("29.02.2000.",formatter),	l3	  , "011/1543-370","purisa.djordjevic@mailinator.com",Status.B,	2018,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		students.add(new Student(26,"RA 226/2017",	  "Mikica","Kovacević",3,	LocalDate.parse("23.03.1999.",formatter),	l5	  , "011/1992-371","mikica.kovacevic@mailinator.com",Status.S,	2017,new ArrayList<Grades>(),student26));	
		students.add(new Student(27,"SW 12/2021",	  "Miloš","Milić",1,	LocalDate.parse("21.10.2001.",formatter),	l2	  , "011/8172-372","milos.milic@mailinator.com",Status.S,	2021,new ArrayList<Grades>(),new ArrayList<Subject>()));	
		
		List<Grades> studGrades4 = new ArrayList<Grades>();
		studGrades4.add(new Grades(getStudWithKey(4),SubjectDB.getInstance().getSubjectWithKey(5),10,LocalDate.parse("12.12.2017.",formatter)));
		studGrades4.add(new Grades(getStudWithKey(4),SubjectDB.getInstance().getSubjectWithKey(3),9,LocalDate.parse("10.11.2019.",formatter)));
		studGrades4.add(new Grades(getStudWithKey(4),SubjectDB.getInstance().getSubjectWithKey(1),8,LocalDate.parse("11.11.2020.",formatter)));
		getStudWithKey(4).setGrades(studGrades4);
		List<Grades> studGrades2 = new ArrayList<Grades>();
		studGrades2.add(new Grades(getStudWithKey(2),SubjectDB.getInstance().getSubjectWithKey(1),10,LocalDate.parse("20.11.2020.",formatter)));
		studGrades2.add(new Grades(getStudWithKey(2),SubjectDB.getInstance().getSubjectWithKey(5),10,LocalDate.parse("30.10.2021.",formatter)));
		getStudWithKey(2).setGrades(studGrades2);
		List<Grades> studGrades15 = new ArrayList<Grades>();
		studGrades15.add(new Grades(getStudWithKey(15),SubjectDB.getInstance().getSubjectWithKey(15),7,LocalDate.parse("10.01.2021.",formatter)));
		studGrades15.add(new Grades(getStudWithKey(15),SubjectDB.getInstance().getSubjectWithKey(16),10,LocalDate.parse("01.01.2021.",formatter)));
		getStudWithKey(15).setGrades(studGrades15);
		List<Grades> studGrades16 = new ArrayList<Grades>();
		studGrades16.add(new Grades(getStudWithKey(16),SubjectDB.getInstance().getSubjectWithKey(15),10,LocalDate.parse("12.01.2018.",formatter)));
		studGrades16.add(new Grades(getStudWithKey(16),SubjectDB.getInstance().getSubjectWithKey(16),9,LocalDate.parse("04.02.2019.",formatter)));
		getStudWithKey(16).setGrades(studGrades16);
		/*---------------------------------------------------*/
//		students.add(new Student( "Perovic","Petar", LocalDate.of(2000,12,7),new Adress("Perina","1","Novi Sad","Srbija"), "06666666","petar@gmail.com","RA-1-2019",2019,3,Status.B,grades1, notPassedSubjects));
//		students.add(new Student( "Ivanovic","Ivan", LocalDate.of(2002,11,8),new Adress("Ivanova","2","Novi Sad","Srbija"), "06636666","ivan@gmail.com","RA-2-2019",2019,3,Status.S,grades,new ArrayList<Subject>()));
//		students.add(new Student( "Markovic","Marko", LocalDate.of(2001,2,1),new Adress("Markova","3","Novi Sad","Srbija"), "06666266","marko@gmail.com","RA-3-2019",2019,3,Status.B,grades2,new ArrayList<Subject>()));
//		students.add(new Student( "Aleksic","Aleksa", LocalDate.of(2005,12,7),new Adress("Aleksina","4","Novi Sad","Srbija"), "062366666","Aleksa@gmail.com","SW-1-2019",2019,3,Status.B,new ArrayList<Grades>(),new ArrayList<Subject>()));
	}
	
	
	/*Methods for student views*/
	public List<Student> getStudents(){
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students=students;
	}
	public int getColumnCount() {
		return 6;
	}
	public String getColumnName(int index) {
		return this.colums.get(index);
	}
	public Student getRow(int rowIndex) {
		return this.students.get(rowIndex);
	}
	public Student getStudWithKey(int _key) {
		for(int i = 0 ;i< students.size();i++) {
			if(this.students.get(i).getKey()==_key) {
				return this.students.get(i);
			}
		}
		return this.students.get(-1);
	}
	public String getValueAt(int row, int column) {
		Student student = this.students.get(row);
		switch (column) {
		case 0:
			return student.getIndex();
		case 1:
			return student.getName();
		case 2:
			return student.getSurname();
		case 3:
			return Integer.toString(student.getCurrYearOfStudy());
		case 4:
			if(student.getStatus().equals(Status.B))
				return "Budzet";
			else
				return "Samofinansiranje";
		case 5: 
			//return Double.toString(student.getAverageMark(student.getGrades()));
			return String.format("%.2f",student.getAverageMark(student.getGrades()));
			
		default:
			return null;
		}
	}
	
	
	
	
	
	/*Methods for passed exams*/
	
	public String getPassedExamsColumnName(int index) {
		return this.passedComumns.get(index);
	}
	
	public String getPassedExamsValueAt(int row, int column) {
		Grades grades = StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())).getGrades().get(row);
		switch (column) {
		case 0:
			return grades.getSubject().getIdSubject();
		case 1:
			return grades.getSubject().getName();
		case 2:
			return Integer.toString(grades.getSubject().getEspb());
		case 3:
			return Integer.toString(grades.getGrades());
		case 4:
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			return grades.getDateExam().format(formatter);	
		default:
			return null;
		}
	}
	
	
	/*Methods for not passed exams*/
	
	public String getNotPassedExamsColumnName(int index) {
		return this.notPassedColumns.get(index);
	}
	
	public String getNotPassedExamsValueAt(int row, int column) {
		Subject subject = StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())).getFailedExams().get(row);
		switch (column) {
		case 0:
			return subject.getIdSubject();
		case 1:
			return subject.getName();
		case 2:
			return Integer.toString(subject.getEspb());
		case 3:
			return Integer.toString(subject.getYearOfStudySub());
		case 4:
			if(subject.getSemestar().equals(Semestar.Summer))
				return "Letnji";
			else
				return "Zimski";
		default:
			return null;
		}
	}
	public void deleteFailedExam(Student s,String id) {
		for(int i =0 ; i<s.getFailedExams().size();i++) {
			if(s.getFailedExams().get(i).getIdSubject().equals(id)){
				s.getFailedExams().remove(s.getFailedExams().get(i));
				break;
			}
		}
	}
	public void addSubjectToFailed(Student student,Subject s) {
		student.getFailedExams().add(s);
	}
	
	
	public void addGrade(Student student, Grades grade) {
		for(int i = 0 ; i<student.getFailedExams().size();i++) {
			if(student.getFailedExams().get(i).getIdSubject().equals(grade.getSubject().getIdSubject())){
				student.getFailedExams().remove(student.getFailedExams().get(i));
				break;
			}
		}
		student.getGrades().add(grade);
	}
	
	public void cancelGrade(Student student, Grades grade) {
		for(int i = 0 ; i < student.getGrades().size(); i++) {
			if(student.getGrades().get(i).getSubject().getIdSubject().equals(grade.getSubject().getIdSubject())){
				student.getGrades().remove(student.getGrades().get(i));
				break;
			}
		}
		student.getFailedExams().add(grade.getSubject());
	}
	
	
	
	
	
	
	
	/*Add,delte,edit student methods*/
	public boolean existsStudent(String id) {
		for(Student s : students ) {
			String s1 = s.getIndex().toUpperCase();
			if(s1.equals(id.toUpperCase()))
				return false;		
		}
		return true;				
	}
	
	/*data manipulation methods*/
	public void addStudent(String surname, String name, LocalDate dateOfBirth, Adress adress, String phoneNumber, String email,
			String index, int yearOfEnrollment, int currYearOfStudy, Status status){
		if(existsStudent(index))
			this.students.add(new Student(surname,name,dateOfBirth,adress,phoneNumber,email,index.toUpperCase(),yearOfEnrollment,currYearOfStudy,status,new ArrayList<Grades>(),new ArrayList<Subject>()));
	}
	
	public void deleteStudent(String index) {
		for (Student s : students) {
			if(s.getIndex().equals(index)) {
				students.remove(s);
				break;
			}
		}
	}
	
	public void editStudent(Student s,String surname, String name,LocalDate date, Adress adress, String phoneNumber, String email,
			String index, int yearOfEnrollment, int currYearOfStudy, Status status) {
		if(existsStudent(index)) {
				s.setSurname(surname);
				s.setName(name);
				s.setDateOfBirth(date);
				s.setAdress(adress);
				s.setContactPhone(phoneNumber);
				s.setEmail(email);
				s.setIndex(index.toUpperCase());
				s.setYearOfEnrollment(yearOfEnrollment);
				s.setCurrYearOfStudy(currYearOfStudy);
				s.setStatus(status);
		}else if (s.getIndex().equals(index.toUpperCase())){
			s.setSurname(surname);
			s.setName(name);
			s.setDateOfBirth(date);
			s.setAdress(adress);
			s.setContactPhone(phoneNumber);
			s.setEmail(email);
			s.setIndex(index.toUpperCase());
			s.setYearOfEnrollment(yearOfEnrollment);
			s.setCurrYearOfStudy(currYearOfStudy);
			s.setStatus(status);
		}else {
			System.out.println("Student sa tim indexom vec postoji.");
		}
	}
}
