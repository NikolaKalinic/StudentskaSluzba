package gui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import model.Adress;

public class FocusListenerForStudent implements FocusListener {

	private  int key = 0b00000000;
	private   String name;
	private  String surname;
	private  LocalDate date;	
	private  Adress adress;
	private  String number;
	private  String email;
	private  String index;
	private  int yearOfEntrollment;
	@Override
	public void focusGained(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		
		/*Vadilidation for name*/
		if (txt.getName().equals("name")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite Ime...")) {
				txt.setText("Unesite Ime...");
				key = key & 0b00000000;
				txt.setForeground(Color.RED);
			} else {
				String regex ="[A-Za-z][a-z]+";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					name=txt.getText().substring(0,1).toUpperCase()+txt.getText().substring(1);
					key = key | 0b00000001;
					txt.setForeground(Color.BLACK);
				} else {
					txt.setText("Unesite Ime...");
					key = key & 0b00000000;
					txt.setForeground(Color.RED);
				}
				
			}
		}
		/*Vadilidation for surname*/
		if (txt.getName().equals("surname")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite Prezime...")) {
				txt.setText("Unesite Prezime...");
				key = key & 0b00000001;
				txt.setForeground(Color.RED);
			} else {
				String regex ="[A-Za-z][a-z]+";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					surname=txt.getText().substring(0,1).toUpperCase()+txt.getText().substring(1);
					key = key | 0b00000010;
					txt.setForeground(Color.BLACK);
				} else {
					txt.setText("Unesite Prezime...");
					key = key & 0b00000001;
					txt.setForeground(Color.RED);
				}
				
			}
		}
		/*Vadilidation for birth date*/
		if (txt.getName().equals("date")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite datum...")) {
				txt.setText("Unesite datum...");
				key = key & 0b00000011;
				txt.setForeground(Color.RED);
			} else {
				String regex ="[0-9]{1,2}-[0-9]{1,2}-[0-9]{4,4}";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					String [] splits =txt.getText().split("-");
					int year =  Integer.parseInt(splits[2]);
					int mounth =Integer.parseInt(splits[1]);
					int day = Integer.parseInt(splits[0]);
					if( mounth == 0 || mounth > 12 ) {
						txt.setText("Mesec nije validan..");
						key = key & 0b00000011;
						txt.setForeground(Color.RED);
					}
					if(mounth==2) {
						if ((((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) && day<=29) {
							txt.setForeground(Color.BLACK);
							key = key | 0b00000100;
						}
						else 
							txt.setText("Dan nije validan...");
							txt.setForeground(Color.RED);
					}
					if(mounth == 1 ||mounth == 3 || mounth == 5 || mounth == 7 ||mounth == 8 ||mounth == 10 ||mounth == 12 )
						if(day == 0 || day>31 ) {
							txt.setText("Dan nije validan..");
							txt.setForeground(Color.RED);
					}
					if(mounth == 4 ||mounth == 6 || mounth == 9 || mounth == 11 )
						 if(day==0 || day>30){
						txt.setText("Dan nije validan..");
						key = key & 0b0000000011;
						txt.setForeground(Color.RED);
					}
					date=LocalDate.of(year,mounth,day);
					key = key | 0b00000100;
					txt.setForeground(Color.BLACK);
				} else {
					txt.setText("Format:\"DD-MM-YYYY\"");
					key = key & 0b00000011;
					txt.setForeground(Color.RED);
				}
			}
		}
		
		
		/*Vadilidation for adress*/
		if (txt.getName().equals("adress")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite adresu...")) {
				txt.setText("Unesite adresu...");
				key = key & 0b00000111;
				txt.setForeground(Color.RED);
			} else {
				String regex ="[A-Za-z]+( *[A-Za-z])* ?, ?[A-Za-z0-9]+ ?, ?[A-Za-z]+( *[A-Za-z])* ?, ?[A-Za-z]+( *[A-Za-z])*";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					String [] splits =txt.getText().split(",");
					adress = new Adress(splits[0],splits[1],splits[2],splits[3]);
					key = key | 0b00001000;
					txt.setForeground(Color.BLACK);
				} else {
					txt.setText("\"ulica,broj,grad,drzava\"");
					key = key & 0b00000111;
					txt.setForeground(Color.RED);
				}
			}
		}
		
		/*Vadilidation for number*/
		if (txt.getName().equals("number")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite broj...")) {
				txt.setText("Unesite broj...");
				key = key & 0b00001111;
				txt.setForeground(Color.RED);
			} else {
				String regex ="\\+?[0-9]+";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					number=txt.getText();
					key = key | 0b00010000;
					txt.setForeground(Color.BLACK);
				} else {
					txt.setText("Unesite broj...");
					key = key & 0b00001111;
					txt.setForeground(Color.RED);
				}
			}
		}
		/*Vadilidation for email*/
		if (txt.getName().equals("email")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite email...")) {
				txt.setText("Unesite emal...");
				key = key & 0b00011111;
				txt.setForeground(Color.RED);
			} else {
				String regex ="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					email=txt.getText();
					key = key | 0b00100000;
					txt.setForeground(Color.BLACK);
				} else {
					txt.setText("Unesite email...");
					key = key & 0b00011111;
					txt.setForeground(Color.RED);
				}
			}
		}
		/*Vadilidation for index*/
		if (txt.getName().equals("index")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite index...")) {
				txt.setText("Unesite index...");
				key = key & 0b00111111;
				txt.setForeground(Color.RED);
			} else {
				String regex ="[A-Za-z]{1,3}-[0-9]{1,3}-[0-9]{1,4}";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					index=txt.getText();
					key = key | 0b001000000;
					txt.setForeground(Color.BLACK);
				} else {
					txt.setText("\"RA-1-2021\"");
					key = key & 0b00111111;
					txt.setForeground(Color.RED);
				}
			}
		}
		
		/*Vadilidation for year of enrtrollment*/
		if (txt.getName().equals("yearOfEntrollment")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite godinu upisa...")) {
				txt.setText("Unesite godinu upisa...");
				key = key & 0b01111111;
				txt.setForeground(Color.RED);
			} else {
				String regex ="[1-9][0-9]{3,3}";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					yearOfEntrollment=Integer.parseInt(txt.getText());
					key = key | 0b10000000;
					txt.setForeground(Color.BLACK);
				} else {
					txt.setText("Unesite godinu upisa...");
					key = key & 0b01111111;
					txt.setForeground(Color.RED);
				}
				
			}
		}
	}

	public int getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public LocalDate getDate() {
		return date;
	}

	public Adress getAdress() {
		return adress;
	}

	public String getNumber() {
		return number;
	}

	public String getEmail() {
		return email;
	}

	public String getIndex() {
		return index;
	}

	public int getYearOfEntrollment() {
		return yearOfEntrollment;
	}

	
}
