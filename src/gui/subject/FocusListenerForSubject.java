package gui.subject;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import model.Professor;
import model.Semestar;

public class FocusListenerForSubject implements FocusListener{
	
	private  int key = 0b0000; //Ima bit viska ako budes zeleo da validiras polje profesora na ovaj nacin
	private String idSubject;
	private String name;
	private Semestar semestar;
	private int yearOfStudySub;
	private Professor professor;
	private int espb;
	@Override
	public void focusGained(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.WHITE);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		
		/*Vadilidation for code*/
		if (txt.getName().equals("code")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite šifru predmeta...")) {
				txt.setText("Unesite šifru predmeta...");
				idSubject="Unesite sifru...";
				key = key & 0b0000;
				txt.setForeground(Color.RED);
			} else {
				String regex ="[A-Za-z0-9]+";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					idSubject=txt.getText().toUpperCase();
					key = key | 0b0001;
					System.out.println(Integer. toBinaryString(key));
					txt.setForeground(Color.BLACK);
				} else {
					txt.setText("Unesite šifru predmeta...");
					idSubject="Unesite sifru...";
					key = key & 0b0000;
					txt.setForeground(Color.RED);
				}
				
			}
		}
		
		/*Vadilidation for name*/
		if (txt.getName().equals("name")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite ime predmeta...")) {
				txt.setText("Unesite Ime...");
				name="Unesite Ime...";
				key = key & 0b0001;
				txt.setForeground(Color.RED);
			} else {
				String regex ="[A-Za-z]+( *[A-Za-z0-9])*";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					name=txt.getText().substring(0,1).toUpperCase()+txt.getText().substring(1);
					key = key | 0b0010;
					System.out.println(Integer. toBinaryString(key));
					txt.setForeground(Color.BLACK);
				} else {
					txt.setText("Unesite ime predmeta...");
					name="Unesite Ime...";
					key = key & 0b0001;
					txt.setForeground(Color.RED);
				}
			}
		}
		
		
		/*Vadilidation for espb*/
		if (txt.getName().equals("espb")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite espb...")) {
				txt.setText("Unesite espb...");
				espb=-1;
				key = key & 0b0011;
				txt.setForeground(Color.RED);
			} else {
				String regex ="[1-9][0-9]?";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					espb=Integer.parseInt(txt.getText());
					key = key | 0b0100;
					System.out.println(Integer. toBinaryString(key));
					txt.setForeground(Color.BLACK);
				} else {
					txt.setText("Unesite espb...");
					espb=-1;
					key = key & 0b0011;
					txt.setForeground(Color.RED);
				}
				
			}
		}
		
		/*Vadilidation for espb*/
		if (txt.getName().equals("profesor")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite espb...")) {
				txt.setText("Unesite profesora...");
				professor=new Professor("-1","-1");
				key = key & 0b0111;
				txt.setForeground(Color.RED);
			} else {
				String regex ="[A-Z][a-z]+ [A-Z][a-z]+";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					String [] splits =txt.getText().split(" ");
					String _name =  splits[0];
					String _surname =  splits[1];
					professor=new Professor(_name, _surname);
					key = key | 0b1000;
					System.out.println(Integer. toBinaryString(key));
					txt.setForeground(Color.BLACK);
				} else {
					txt.setText("Unesite profesora...");
					professor=new Professor("-1","-1");
					key = key & 0b0111;
					txt.setForeground(Color.RED);
				}
				
			}
		}
	}

	

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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
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

	public void setKey(int key) {
		this.key = key;
	}

	
	
}
