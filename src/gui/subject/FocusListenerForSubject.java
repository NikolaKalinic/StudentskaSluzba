package gui.subject;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

import controller.SubjectController;
import model.Professor;
import model.Semestar;

public class FocusListenerForSubject implements FocusListener{
	
	private  int key = 0b0000; 
	private String idSubject;
	private String idSubjectBackUp;
	private String name;
	private String nameBackUp;
	private Professor professor;
	private int espb;
	private String espbBackUp;
	private int i;
	public FocusListenerForSubject(int i) {
		this.i=i;
	}
	@Override
	public void focusGained(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.WHITE);
		if (txt.getName().equals("code")) {
			if((key | 0b1110) == 0b1110)
				txt.setText(idSubjectBackUp);
		}
		if (txt.getName().equals("name")) {
			if((key | 0b1101) == 0b1101)
				txt.setText(nameBackUp);
		}
		if (txt.getName().equals("espb")) {
			if((key | 0b1011) == 0b1011)
				txt.setText(espbBackUp);
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		Border defaultBorder = UIManager.getBorder("TextField.border");
		Border invalidBorder = BorderFactory.createLineBorder(Color.red);
		/*Vadilidation for code*/
		if (txt.getName().equals("code")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite šifru predmeta...")) {
				idSubjectBackUp=txt.getText();
				txt.setText("Unesite šifru predmeta...");
				idSubject="Unesite sifru...";
				key = key & 0b1110;
				txt.setForeground(Color.RED);
				txt.setBorder(invalidBorder);
			} else {
				String regex ="[A-Za-z0-9]+";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					idSubject=txt.getText().toUpperCase();
					idSubjectBackUp=idSubject;
					if(i==1) {
						if(!SubjectController.getInstance().existsSubject(idSubject)) {
							txt.setText("Šifra već postoji...");
							idSubject="Unesite sifru...";
							key = key & 0b1110;
							txt.setForeground(Color.RED);
							txt.setBorder(invalidBorder);
						}else {
							key = key | 0b0001;
							System.out.println(Integer. toBinaryString(key));
							txt.setForeground(Color.BLACK);
							txt.setBorder(defaultBorder);
						}
					}else {
						if(!SubjectController.getInstance().editExistsSubject(idSubject)) {
							txt.setText("Šifra već postoji...");
							idSubject="Unesite sifru...";
							key = key & 0b1110;
							txt.setForeground(Color.RED);
							txt.setBorder(invalidBorder);
						}else {
							key = key | 0b0001;
							System.out.println(Integer. toBinaryString(key));
							txt.setForeground(Color.BLACK);
							txt.setBorder(defaultBorder);
						}
					}
				} else {
					idSubjectBackUp=txt.getText();
					txt.setText("Unesite šifru predmeta...");
					idSubject="Unesite sifru...";
					key = key & 0b1110;
					txt.setForeground(Color.RED);
					txt.setBorder(invalidBorder);
				}
				
			}
		}
		
		/*Vadilidation for name*/
		if (txt.getName().equals("name")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite ime predmeta...")) {
				nameBackUp=txt.getText();
				txt.setText("Unesite Ime...");
				name="Unesite Ime...";
				key = key & 0b0001;
				txt.setForeground(Color.RED);
				txt.setBorder(invalidBorder);
			} else {
				String regex ="[A-Za-z]+( *[A-Za-z0-9])*";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					name=txt.getText().substring(0,1).toUpperCase()+txt.getText().substring(1);
					nameBackUp=name;
					key = key | 0b0010;
					System.out.println(Integer. toBinaryString(key));
					txt.setForeground(Color.BLACK);
					txt.setBorder(defaultBorder);
				} else {
					nameBackUp=txt.getText();
					txt.setText("Unesite ime predmeta...");
					name="Unesite Ime...";
					key = key & 0b0001;
					txt.setForeground(Color.RED);
					txt.setBorder(invalidBorder);
				}
			}
		}
		
		
		/*Vadilidation for espb*/
		if (txt.getName().equals("espb")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite espb...")) {
				espbBackUp=txt.getText();
				txt.setText("Unesite espb...");
				espb=-1;
				key = key & 0b0011;
				txt.setForeground(Color.RED);
				txt.setBorder(invalidBorder);
			} else {
				String regex ="[1-9][0-9]?";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					espb=Integer.parseInt(txt.getText());
					espbBackUp=Integer.toString(espb);
					key = key | 0b0100;
					System.out.println(Integer. toBinaryString(key));
					txt.setForeground(Color.BLACK);
					txt.setBorder(defaultBorder);
				} else {
					espbBackUp=txt.getText();
					txt.setText("Unesite espb...");
					espb=-1;
					key = key & 0b0011;
					txt.setForeground(Color.RED);
					txt.setBorder(invalidBorder);
				}
				
			}
		}
		
		/*Nije potrebna*/
//		/*Vadilidation for espb*/
//		if (txt.getName().equals("profesor")) {
//			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite espb...")) {
//				txt.setText("Unesite profesora...");
//				professor=new Professor("-1","-1");
//				key = key & 0b0111;
//				txt.setForeground(Color.RED);
//			} else {
//				String regex ="[A-Z][a-z]+ [A-Z][a-z]+";
//				Pattern pattern = Pattern.compile(regex);
//				Matcher matcher = pattern.matcher(txt.getText());
//				if(matcher.matches()) {
//					String [] splits =txt.getText().split(" ");
//					String _name =  splits[0];
//					String _surname =  splits[1];
//					professor=new Professor(_name, _surname);
//					key = key | 0b1000;
//					System.out.println(Integer. toBinaryString(key));
//					txt.setForeground(Color.BLACK);
//				} else {
//					txt.setText("Unesite profesora...");
//					professor=new Professor("-1","-1");
//					key = key & 0b0111;
//					txt.setForeground(Color.RED);
//				}
//				
//			}
//		}
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
