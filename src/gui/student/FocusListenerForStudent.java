package gui.student;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

import controller.StudentController;
import gui.MainFrame;
import model.Adress;

public class FocusListenerForStudent implements FocusListener {

	private  int key = 0b00000000;
	private   String name;
	private	 String nameBackUp;
	private  String surname;
	private	 String surnameBackUp;
	private  LocalDate date;
	private String dateBackUp;
	private  Adress adress;
	private String adressBackUp;
	private  String number;
	private String numberBackUp;
	private  String email;
	private String emailBackUp;
	private  String index;
	private String indexBackUp;
	private  int yearOfEntrollment;
	private String yearBackUp;
	private int i;
	public FocusListenerForStudent(int i) {
		this.i=i;
	}
	/*stackoverflow*/
	final static String DATE_FORMAT = "dd.MM.yyyy.";

	public static boolean isDateValid(String date) 
	{
	        try {
	            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	            df.setLenient(false);
	            df.parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	}
	@Override
	public void focusGained(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.WHITE);
		if (txt.getName().equals("name")) {
			if(((key<<7) & 0b11111111) == 0b00000000)
				txt.setText(nameBackUp);
		}
		if (txt.getName().equals("surname")) {
			if((key | 0b11111101) == 0b11111101)
				txt.setText(surnameBackUp);
		}
		if (txt.getName().equals("date")) {
			if((key | 0b11111011) == 0b11111011)
				txt.setText(dateBackUp);
		}
		if (txt.getName().equals("adress")) {
			if((key | 0b11110111) == 0b11110111)
				txt.setText(adressBackUp);
		}
		if (txt.getName().equals("number")) {
			if((key | 0b11101111) == 0b11101111) 
				txt.setText(numberBackUp);	
		}
		if (txt.getName().equals("email")) {
			if((key | 0b11011111) == 0b11011111) 
				txt.setText(emailBackUp);	
		}
		if (txt.getName().equals("index")) {
			if((key | 0b10111111) == 0b10111111) 
				txt.setText(indexBackUp);	
		}
		if (txt.getName().equals("yearOfEntrollment")) {
			if((key | 0b01111111) == 0b01111111) 
				txt.setText(yearBackUp);	
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		Border defaultBorder = UIManager.getBorder("TextField.border");
		Border invalidBorder = BorderFactory.createLineBorder(Color.red);
		
		/*Vadilidation for name*/
		if (txt.getName().equals("name")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals(MainFrame.getInstance().getResourceBundle().getString("studentNameTooltip"))) {
				nameBackUp=txt.getText();
				txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentNameTooltip"));
				name="Unesite Ime...";
				key = key & 0b11111110;
				txt.setForeground(Color.RED);
				txt.setBorder(invalidBorder);
			} else {
				String regex =" *[A-Ša-š][a-š]+ *";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					name=txt.getText().trim();
					name=name.substring(0,1).toUpperCase()+name.substring(1);
					nameBackUp=name;
					key = key | 0b00000001;
					System.out.println(Integer. toBinaryString(key));
					txt.setForeground(Color.BLACK);
					txt.setBorder(defaultBorder);
				} else {
					nameBackUp=txt.getText();
					txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentNameTooltip"));
					name="Unesite Ime...";
					key = key & 0b11111110;;
					txt.setForeground(Color.RED);
					txt.setBorder(invalidBorder);
				}
				
			}
		}
		/*Vadilidation for surname*/
		if (txt.getName().equals("surname")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals(MainFrame.getInstance().getResourceBundle().getString("studentSurnameTooltip"))) {
				surnameBackUp=txt.getText();
				txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentSurnameTooltip"));
				surname="Unesite Prezime...";
				key = key & 0b11111101;
				txt.setForeground(Color.RED);
				txt.setBorder(invalidBorder);
			} else {
				String regex =" *[A-Ša-š][a-š]+ *";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					surname=txt.getText().trim();
					surname=surname.substring(0,1).toUpperCase()+surname.substring(1);
					surnameBackUp=surname;
					key = key | 0b00000010;
					System.out.println(Integer. toBinaryString(key));
					txt.setForeground(Color.BLACK);
					txt.setBorder(defaultBorder);
				} else {
					surnameBackUp=txt.getText();
					txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentSurnameTooltip"));
					surname="Unesite Prezime...";
					key = key & 0b11111101;
					txt.setForeground(Color.RED);
					txt.setBorder(invalidBorder);
				}
				
			}
		}
		/*Vadilidation for birth date*/
		if (txt.getName().equals("date")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals(MainFrame.getInstance().getResourceBundle().getString("studentDateTooltip"))) {
				dateBackUp=txt.getText();
				txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentDateTooltip"));
				key = key & 0b11111011;
				date = LocalDate.of(1111,1, 1);
				txt.setForeground(Color.RED);
				txt.setBorder(invalidBorder);
			} else {
				String regex =" *[0-9]{1,2}\\.[0-9]{1,2}\\.[0-9]{4,4}\\. *";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					System.out.println("AAAAA");
					if(isDateValid(txt.getText())) {
					dateBackUp=txt.getText();
					String tmp = txt.getText().trim();
					String [] splits =tmp.split("\\.");
					int year =  Integer.parseInt(splits[2]);
					int mounth =Integer.parseInt(splits[1]);
					int day = Integer.parseInt(splits[0]);

					date=LocalDate.of(year,mounth,day);
					key = key | 0b00000100;
					System.out.println(Integer. toBinaryString(key));
					txt.setForeground(Color.BLACK);
					txt.setBorder(defaultBorder);
					}else {
						dateBackUp=txt.getText();
						txt.setText("Format:\"DD.MM.YYYY\"");
						key = key & 0b11111011;
						txt.setForeground(Color.RED);
						txt.setBorder(invalidBorder);
					}
					
				} else {
					dateBackUp=txt.getText();
					txt.setText("Format:\"DD.MM.YYYY\"");
					key = key & 0b11111011;
					txt.setForeground(Color.RED);
					txt.setBorder(invalidBorder);
				}
			}
		}
		
		
		/*Vadilidation for adress*/
		if (txt.getName().equals("adress")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals(MainFrame.getInstance().getResourceBundle().getString("studentAdressTooltip"))) {
				adressBackUp=txt.getText();
				txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentAdressTooltip"));
				adress = new Adress("Adresa","a1","Nije","Validna");
				key = key & 0b11110111;
				txt.setForeground(Color.RED);
				txt.setBorder(invalidBorder);
			} else {
				String regex =" *[A-Ša-š]+( *[A-Ša-š])* *, *[A-Ša-š0-9]+ *, *[A-Ša-š]+( *[A-Ša-š])* *, *[A-Ša-š]+( *[A-Ša-š])* *";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					String tmp = txt.getText().trim();
					String [] splits =tmp.split(",");
					adress = new Adress(splits[0].trim(),splits[1].trim(),splits[2].trim(),splits[3].trim());
					key = key | 0b00001000;
					System.out.println(Integer. toBinaryString(key));
					txt.setForeground(Color.BLACK);
					txt.setBorder(defaultBorder);
				} else {
					adressBackUp=txt.getText();
					txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentAdressErr"));
					adress = new Adress("Adresa","a1","Nije","Validna");
					key = key & 0b11110111;
					txt.setForeground(Color.RED);
					txt.setBorder(invalidBorder);
				}
			}
		}
		
		/*Vadilidation for number*/
		if (txt.getName().equals("number")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals(MainFrame.getInstance().getResourceBundle().getString("studentPhoneTooltip"))) {
				numberBackUp=txt.getText();
				txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentPhoneTooltip"));
				number = "Unesite broj...";
				key = key & 0b11101111;
				txt.setForeground(Color.RED);
				txt.setBorder(invalidBorder);
			} else {
				String regex =" * *[0-9]{3}/[0-9]{3,4}-[0-9]{3} *";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					number = txt.getText().trim();
					numberBackUp=number;
					key = key | 0b00010000;
					System.out.println(Integer. toBinaryString(key));
					txt.setForeground(Color.BLACK);
					txt.setBorder(defaultBorder);
				} else {
					numberBackUp=txt.getText();
					txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentPhoneTooltip"));
					number = "Unesite broj...";
					key = key & 0b11101111;
					txt.setForeground(Color.RED);
					txt.setBorder(invalidBorder);
				}
			}
		}
		/*Vadilidation for email*/
		if (txt.getName().equals("email")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals(MainFrame.getInstance().getResourceBundle().getString("studentEmailTooltip"))) {
				emailBackUp=txt.getText();
				txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentEmailTooltip"));
				email="Unesite emal...";
				key = key & 0b11011111;
				txt.setForeground(Color.RED);
				txt.setBorder(invalidBorder);
			} else {
				String regex ="^[ *\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4} *";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					email=txt.getText().trim();
					emailBackUp=txt.getText();
					key = key | 0b00100000;
					System.out.println(Integer. toBinaryString(key));
					txt.setForeground(Color.BLACK);
					txt.setBorder(defaultBorder);
				} else {
					emailBackUp=txt.getText();
					txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentEmailTooltip"));
					email="Unesite emal...";
					key = key & 0b11011111;
					txt.setForeground(Color.RED);
					txt.setBorder(invalidBorder);
				}
			}
		}
		/*Vadilidation for index*/
		if (txt.getName().equals("index")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals(MainFrame.getInstance().getResourceBundle().getString("studentIdTooltip"))) {
				indexBackUp=txt.getText();
				txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentIdTooltip"));
				index = "Unesite index...";
				key = key & 0b10111111;
				txt.setForeground(Color.RED);
				txt.setBorder(invalidBorder);
			} else {
				String regex =" *[A-Za-z]{1,3} [0-9]{1,3}/[0-9]{1,4} *";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					index=txt.getText().trim();
					indexBackUp=txt.getText();
					if(i==1) {				//1-POZIVAM IZ DODAVANJA 2-POZIVAM IZ IZMENE
						if(!StudentController.getInstance().existsStudent(index)) {
							//JOptionPane.showMessageDialog(null, "Student sa tim indexom vec postoji ! ");
							txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentIdErr"));
							index = "Unesite index...";
							key = key & 0b10111111;
							txt.setForeground(Color.RED);
							txt.setBorder(invalidBorder);
						}else {
							key = key | 0b001000000;
							System.out.println(Integer. toBinaryString(key));
							txt.setForeground(Color.BLACK);
							txt.setBorder(defaultBorder);
						}
					}else {
						if(!StudentController.getInstance().editExistsStudent(index)) {
							key = key & 0b10111111;
							//JOptionPane.showMessageDialog(null, "Student sa tim indexom vec postoji ! ");
							txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentIdErr"));
							index = "Unesite index...";
							System.out.println(Integer. toBinaryString(key));
							txt.setForeground(Color.RED);
							txt.setBorder(invalidBorder);
						}else {
							key = key | 0b001000000;
							System.out.println(Integer. toBinaryString(key));
							System.out.println(Integer. toBinaryString(key));
							txt.setForeground(Color.BLACK);
							txt.setBorder(defaultBorder);
						}
					}
					
				} else {
					indexBackUp=txt.getText();
					txt.setText("\"RA 1/2021\"");
					index = "Unesite index...";
					key = key & 0b10111111;
					txt.setForeground(Color.RED);
					txt.setBorder(invalidBorder);
				}
			}
		}
		
		/*Vadilidation for year of enrtrollment*/
		if (txt.getName().equals("yearOfEntrollment")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals(MainFrame.getInstance().getResourceBundle().getString("studentYearEnTooltip"))) {
				yearBackUp=txt.getText();
				txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentYearEnTooltip"));
				yearOfEntrollment=-1;
				key = key & 0b01111111;
				txt.setForeground(Color.RED);
				txt.setBorder(invalidBorder);
			} else {
				String regex =" *[1-9][0-9]{3,3} *";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(txt.getText());
				if(matcher.matches()) {
					yearOfEntrollment=Integer.parseInt(txt.getText().trim());
					yearBackUp=txt.getText().trim();
					key = key | 0b10000000;
					System.out.println(Integer. toBinaryString(key));
					txt.setForeground(Color.BLACK);
					txt.setBorder(defaultBorder);
				} else {
					yearBackUp=txt.getText();
					txt.setText(MainFrame.getInstance().getResourceBundle().getString("studentYearEnTooltip"));
					yearOfEntrollment=-1;
					key = key & 0b01111111;
					txt.setForeground(Color.RED);
					txt.setBorder(invalidBorder);
				}
				
			}
		}
	}
	public void lostFocus(JPanel panel,JButton btnOk) {
		panel.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {
				try{
					Thread.sleep(100);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				btnOk.requestFocus();}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
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

	public void setKey(int key) {
		this.key = key;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public void setYearOfEntrollment(int yearOfEntrollment) {
		this.yearOfEntrollment = yearOfEntrollment;
	}
	

	
}
