package gui.professor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import controller.ProfessorController;
import model.Adress;
import model.Professor;

public class MyEditingProfessorInformation extends JPanel {
	
		
		private static JTextField tfName;
		private static JTextField tfSurname;
		private static JTextField tfEmail;
		private static JTextField tfBirthDate;
		private static JTextField tfStreet;
		private static JTextField tfNumber;
		private static JTextField tfCity;
		private static JTextField tfCountry;
		private static JTextField tfStreetW;
		private static JTextField tfNumberW;
		private static JTextField tfCityW;
		private static JTextField tfCountryW;
		private static JComboBox<String> comboCalling;
		private static JTextField tfPhoneNumber;
		private static JTextField tfId;
		private static JTextField tfExp;
		private static JButton ok;
		

		public MyEditingProfessorInformation() {
			setLayout(new BorderLayout());
			JPanel panLeft = new JPanel();
			JPanel panRight = new JPanel();
			panLeft.setPreferredSize(new Dimension(100,1));
			panRight.setPreferredSize(new Dimension(100,1));
			add(panLeft,BorderLayout.WEST);
			add(panRight,BorderLayout.EAST);
			
			
			
			Professor professor = ProfessorController.getInstance().getSelectedProfessor(MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow());
			setSize(300, 650);
			FocusListenerForEditProfessor focusListener = new FocusListenerForEditProfessor();
			
			JPanel panel = new JPanel();
			panel.setLayout(new GridBagLayout());
			this.add(panel, BorderLayout.CENTER);
			
			JLabel Name = new JLabel("Ime*");
			tfName = new JTextField(professor.getName());
			tfName.addFocusListener(focusListener);
			tfName.setToolTipText("Unesite ime profesora");
			GridBagConstraints cName =  new GridBagConstraints();
			cName.gridx = 0;
			cName.gridy = 0;
			cName.insets = new Insets(0, 0, 0, 0);
			cName.fill = GridBagConstraints.HORIZONTAL;
			panel.add(Name, cName);
			GridBagConstraints cNameTf =  new GridBagConstraints();
			cNameTf.gridx = 1;
			cNameTf.gridy = 0;
			cNameTf.fill = GridBagConstraints.HORIZONTAL;
			cNameTf.insets = new Insets(5, 5, 0, 10);
			panel.add(tfName, cNameTf);
			
			
			
			JLabel Surname = new JLabel("Prezime*");
			tfSurname = new JTextField(professor.getSurname());
			tfSurname.addFocusListener(focusListener);
			tfSurname.setToolTipText("Unesite prezime profesora");
			GridBagConstraints cSurname =  new GridBagConstraints();
			cSurname.gridx = 0;
			cSurname.gridy = 1;
			cSurname.fill = GridBagConstraints.HORIZONTAL;
			cSurname.insets = new Insets(10, 0, 0, 0);
			panel.add(Surname, cSurname);
			GridBagConstraints cSurnameTf =  new GridBagConstraints();
			cSurnameTf.gridx = 1;
			cSurnameTf.gridy = 1;
			cSurnameTf.fill = GridBagConstraints.HORIZONTAL;
			cSurnameTf.insets = new Insets(5, 5, 0, 10);
			panel.add(tfSurname, cSurnameTf);
			
			JLabel email = new JLabel("E-mail*");
			tfEmail = new JTextField(professor.getEmail());
			tfEmail.addFocusListener(focusListener);
			tfEmail.setToolTipText("Unesite e-mail profesora");
			GridBagConstraints cEmail =  new GridBagConstraints();
			cEmail.gridx = 0;
			cEmail.gridy = 2;
			cEmail.fill = GridBagConstraints.HORIZONTAL;
			cEmail.insets = new Insets(10, 0, 0, 0);
			panel.add(email, cEmail);
			GridBagConstraints cEmailTf =  new GridBagConstraints();
			cEmailTf.gridx = 1;
			cEmailTf.gridy = 2;
			cEmailTf.fill = GridBagConstraints.HORIZONTAL;
			cEmailTf.insets = new Insets(5, 5, 0, 10);
			panel.add(tfEmail, cEmailTf);
			
			JLabel birthDate = new JLabel("Godina rodjenja*");
			tfBirthDate = new JTextField(professor.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			tfBirthDate.addFocusListener(focusListener);
			tfBirthDate.setToolTipText("Unesite datum rodjenja [DAY-MONTH-YEAR]");
			GridBagConstraints cBirthDate =  new GridBagConstraints();
			cBirthDate.gridx = 0;
			cBirthDate.gridy = 3;
			cBirthDate.fill = GridBagConstraints.HORIZONTAL;
			cBirthDate.insets = new Insets(10, 0, 0, 0);
			panel.add(birthDate, cBirthDate);
			GridBagConstraints cBirthDateTf =  new GridBagConstraints();
			cBirthDateTf.gridx = 1;
			cBirthDateTf.gridy = 3;
			cBirthDateTf.fill = GridBagConstraints.HORIZONTAL;
			cBirthDateTf.insets = new Insets(5, 5, 0, 10);
			panel.add(tfBirthDate, cBirthDateTf);
			
			JLabel homeAdress = new JLabel("========= Kucna adresa =========");
			JLabel homeStreet = new JLabel("Ulica*");
			JLabel homeNumber = new JLabel("Broj*");
			JLabel homeCity = new JLabel("Grad*");
			JLabel homeCountry = new JLabel("Drzava*");
			tfStreet = new JTextField(professor.getHomeAdress().getStreet());
			tfStreet.addFocusListener(focusListener);
			tfNumber = new JTextField(professor.getHomeAdress().getNumber());
			tfNumber.addFocusListener(focusListener);
			tfCity = new JTextField(professor.getHomeAdress().getCity());
			tfCity.addFocusListener(focusListener);
			tfCountry = new JTextField(professor.getHomeAdress().getCountry());
			tfCountry.addFocusListener(focusListener);
			
			tfStreet.setToolTipText("Unesite ulicu");
			tfNumber.setToolTipText("Unesite broj");
			tfCity.setToolTipText("Unesite grad");
			tfCountry.setToolTipText("Unesite drzava");
			
			GridBagConstraints cHA =  new GridBagConstraints();
			cHA.gridwidth = 2;
			cHA.gridx = 0;
			cHA.gridy = 4;
			cHA.insets = new Insets(10, 0, 0, 0);
			panel.add(homeAdress, cHA);
			
			GridBagConstraints cHomeStreet =  new GridBagConstraints();
			cHomeStreet.gridx = 0;
			cHomeStreet.gridy = 5;
			cHomeStreet.fill = GridBagConstraints.HORIZONTAL;
			cHomeStreet.insets = new Insets(10, 0, 0, 0);
			panel.add(homeStreet, cHomeStreet);
			
			GridBagConstraints cStreetTf =  new GridBagConstraints();
			cStreetTf.gridx = 1;
			cStreetTf.gridy = 5;
			cStreetTf.fill = GridBagConstraints.HORIZONTAL;
			cStreetTf.insets = new Insets(10, 5, 0, 10);
			panel.add(tfStreet, cStreetTf);
			
			GridBagConstraints cHomeNumber =  new GridBagConstraints();
			cHomeNumber.gridx = 0;
			cHomeNumber.gridy = 6;
			cHomeNumber.fill = GridBagConstraints.HORIZONTAL;
			cHomeNumber.insets = new Insets(10, 0, 0, 0);
			panel.add(homeNumber, cHomeNumber);
			
			GridBagConstraints cNumberTf =  new GridBagConstraints();
			cNumberTf.gridx = 1;
			cNumberTf.gridy = 6;
			cNumberTf.fill = GridBagConstraints.HORIZONTAL;
			cNumberTf.insets = new Insets(10, 5, 0, 10);
			panel.add(tfNumber, cNumberTf);	
			
			GridBagConstraints cHomeCity =  new GridBagConstraints();
			cHomeCity.gridx = 0;
			cHomeCity.gridy = 7;
			cHomeCity.fill = GridBagConstraints.HORIZONTAL;
			cHomeCity.insets = new Insets(10, 0, 0, 0);
			panel.add(homeCity, cHomeCity);
			
			GridBagConstraints cCityTf =  new GridBagConstraints();
			cCityTf.gridx = 1;
			cCityTf.gridy = 7;
			cCityTf.fill = GridBagConstraints.HORIZONTAL;
			cCityTf.insets = new Insets(10, 5, 0, 10);
			panel.add(tfCity, cCityTf);
			
			GridBagConstraints cHomeCountry =  new GridBagConstraints();
			cHomeCountry.gridx = 0;
			cHomeCountry.gridy = 8;
			cHomeCountry.fill = GridBagConstraints.HORIZONTAL;
			cHomeCountry.insets = new Insets(10, 0, 0, 0);
			panel.add(homeCountry, cHomeCountry);
			
			GridBagConstraints cCountryTf =  new GridBagConstraints();
			cCountryTf.gridx = 1;
			cCountryTf.gridy = 8;
			cCountryTf.fill = GridBagConstraints.HORIZONTAL;
			cCountryTf.insets = new Insets(10, 5, 0, 10);
			panel.add(tfCountry, cCountryTf);
			
			JLabel workAdress = new JLabel("========= Radna adresa =========");
			JLabel workStreet = new JLabel("Ulica*");
			JLabel workNumber = new JLabel("Broj*");
			JLabel workCity = new JLabel("Grad*");
			JLabel workCountry = new JLabel("Drzava*");
			tfStreetW = new JTextField(professor.getWorkAdress().getStreet());
			tfStreetW.addFocusListener(focusListener);
			tfNumberW = new JTextField(professor.getWorkAdress().getNumber());
			tfNumberW.addFocusListener(focusListener);
			tfCityW = new JTextField(professor.getWorkAdress().getCity());
			tfCityW.addFocusListener(focusListener);
			tfCountryW = new JTextField(professor.getWorkAdress().getCountry());
			tfCountryW.addFocusListener(focusListener);
			
			tfStreetW.setToolTipText("Unesite ulicu");
			tfStreetW.setToolTipText("Unesite broj");
			tfStreetW.setToolTipText("Unesite grad");
			tfStreetW.setToolTipText("Unesite drzava");
			
			GridBagConstraints cHAW =  new GridBagConstraints();
			cHAW.gridwidth = 2;
			cHAW.gridx = 0;
			cHAW.gridy = 9;
			cHAW.insets = new Insets(10, 0, 0, 0);
			panel.add(workAdress, cHAW);
			
			GridBagConstraints cWorkStreet =  new GridBagConstraints();
			cWorkStreet.gridx = 0;
			cWorkStreet.gridy = 10;
			cWorkStreet.fill = GridBagConstraints.HORIZONTAL;
			cWorkStreet.insets = new Insets(10, 0, 0, 0);
			panel.add(workStreet, cWorkStreet);
			
			GridBagConstraints cStreetTfW =  new GridBagConstraints();
			cStreetTfW.gridx = 1;
			cStreetTfW.gridy = 10;
			cStreetTfW.fill = GridBagConstraints.HORIZONTAL;
			cStreetTfW.insets = new Insets(10, 5, 0, 10);
			panel.add(tfStreetW, cStreetTfW);
			
			GridBagConstraints cWorkNumber =  new GridBagConstraints();
			cWorkNumber.gridx = 0;
			cWorkNumber.gridy = 11;
			cWorkNumber.fill = GridBagConstraints.HORIZONTAL;
			cWorkNumber.insets = new Insets(10, 0, 0, 0);
			panel.add(workNumber, cWorkNumber);
			
			GridBagConstraints cNumberTfW =  new GridBagConstraints();
			cNumberTfW.gridx = 1;
			cNumberTfW.gridy = 11;
			cNumberTfW.fill = GridBagConstraints.HORIZONTAL;
			cNumberTfW.insets = new Insets(10, 5, 0, 10);
			panel.add(tfNumberW, cNumberTfW);	
			
			GridBagConstraints cWorkCity =  new GridBagConstraints();
			cWorkCity.gridx = 0;
			cWorkCity.gridy = 12;
			cWorkCity.fill = GridBagConstraints.HORIZONTAL;
			cWorkCity.insets = new Insets(10, 0, 0, 0);
			panel.add(workCity, cWorkCity);
			
			GridBagConstraints cCityTfW =  new GridBagConstraints();
			cCityTfW.gridx = 1;
			cCityTfW.gridy = 12;
			cCityTfW.fill = GridBagConstraints.HORIZONTAL;
			cCityTfW.insets = new Insets(10, 5, 0, 10);
			panel.add(tfCityW, cCityTfW);
			
			GridBagConstraints cWorkCountry =  new GridBagConstraints();
			cWorkCountry.gridx = 0;
			cWorkCountry.gridy = 13;
			cWorkCountry.fill = GridBagConstraints.HORIZONTAL;
			cWorkCountry.insets = new Insets(10, 0, 0, 0);
			panel.add(workCountry, cWorkCountry);
			
			GridBagConstraints cCountryTfW =  new GridBagConstraints();
			cCountryTfW.gridx = 1;
			cCountryTfW.gridy = 13;
			cCountryTfW.fill = GridBagConstraints.HORIZONTAL;
			cCountryTfW.insets = new Insets(10, 5, 0, 10);
			panel.add(tfCountryW, cCountryTfW);
			
			
			JLabel phoneNumber = new JLabel("Broj telefona*");
			tfPhoneNumber = new JTextField(professor.getPhoneNumber());
			tfPhoneNumber.setToolTipText("Unesite broj telefona");
			GridBagConstraints cPhoneNumber =  new GridBagConstraints();
			cPhoneNumber.gridx = 0;
			cPhoneNumber.gridy = 14;
			cPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
			cPhoneNumber.insets = new Insets(10, 0, 0, 0);
			panel.add(phoneNumber, cPhoneNumber);
			GridBagConstraints cPhoneNumberTf =  new GridBagConstraints();
			cPhoneNumberTf.gridx = 1;
			cPhoneNumberTf.gridy = 14;
			cPhoneNumberTf.fill = GridBagConstraints.HORIZONTAL;
			cPhoneNumberTf.insets = new Insets(10, 5, 0, 10);
			panel.add(tfPhoneNumber, cPhoneNumberTf);
			
			JLabel id = new JLabel("Broj licne karte*");
			tfId = new JTextField(professor.getId());
			tfId.addFocusListener(focusListener);
			tfId.setToolTipText("Unesite broj licne karte");
			GridBagConstraints cId =  new GridBagConstraints();
			cId.gridx = 0;
			cId.gridy = 15;
			cId.fill = GridBagConstraints.HORIZONTAL;
			cId.insets = new Insets(10, 0, 0, 0);
			panel.add(id, cId);
			GridBagConstraints cIdTf =  new GridBagConstraints();
			cIdTf.gridx = 1;
			cIdTf.gridy = 15;
			cIdTf.fill = GridBagConstraints.HORIZONTAL;
			cIdTf.insets = new Insets(10, 5, 0, 10);
			panel.add(tfId, cIdTf);
			
			JLabel calling = new JLabel("Zvanje");
			String[] callings = {"-", "Asistent", "Docent", "Vanredni profesor", "Profesor"};
			comboCalling = new JComboBox<String>(callings);
			comboCalling.setSelectedItem(professor.getCalling());
			GridBagConstraints cCalling =  new GridBagConstraints();
			cCalling.gridx = 0;
			cCalling.gridy = 17;
			cCalling.fill = GridBagConstraints.HORIZONTAL;
			cCalling.insets = new Insets(10, 0, 0, 0);
			panel.add(calling, cCalling);
			GridBagConstraints cComboCalling = new GridBagConstraints();
			cComboCalling.gridx = 1;
			cComboCalling.gridy = 17;
			cComboCalling.insets = new Insets(10, 5, 0, 10);
			panel.add(comboCalling, cComboCalling);
			
			JLabel exp = new JLabel("Godine iskustva*");
			tfExp = new JTextField(Integer.toString(professor.getExperience()));
			tfExp.setName("exp");
			tfExp.addFocusListener(focusListener);
			tfExp.setToolTipText("Unesite godine iskustva [int]");
			GridBagConstraints cExp =  new GridBagConstraints();
			cExp.gridx = 0;
			cExp.gridy = 16;
			cExp.fill = GridBagConstraints.HORIZONTAL;
			cExp.insets = new Insets(10, 0, 0, 30);
			panel.add(exp, cExp);
			GridBagConstraints cExpTf =  new GridBagConstraints();
			cExpTf.gridx = 1;
			cExpTf.gridy = 16;
			cExpTf.fill = GridBagConstraints.HORIZONTAL;
			cExpTf.insets = new Insets(10, 10, 0, 30);
			panel.add(tfExp, cExpTf);
			
			JPanel botPanel = new JPanel();
			botPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
			Dimension botDim = new Dimension();
			botDim.setSize(200, 50);
			botPanel.setPreferredSize(botDim);
			ok = new JButton("OK");
			ok.setEnabled(true);
			ok.setFocusPainted(false);
			
			new Timer(100,new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					checkValidity();
				}
				
			}).start();
			
		
			
			JButton cancel = new JButton("CANCEL");
			cancel.setFocusPainted(false);
			botPanel.add(ok);
			botPanel.add(cancel);
			
			add(botPanel, BorderLayout.SOUTH);
			add(panel,BorderLayout.CENTER);
			cancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//dispose();
					cancel.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().setVisible(false);
					}	
			});
			
			ok.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(!(tfEmail.getText().contains("@"))) {
						JOptionPane.showMessageDialog(null, "Email adresa je u pogresnom formatu!", "Popuni polja!", JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					try {
						LocalDate.parse(tfBirthDate.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					} catch (Exception e1 ) {
						JOptionPane.showMessageDialog(null, "Datum mora biti u formatu 'DAY-MONTH-YEAR'", "Popuni polja!", JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					try {
						Integer.parseInt(tfPhoneNumber.getText());
					} catch(Exception e3) {
						JOptionPane.showMessageDialog(null, "Broj telefona nije validan", "Popuni polja!", JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					
					
					if(comboCalling.getSelectedItem().toString().equals("-")) {
						JOptionPane.showMessageDialog(null, "Izabrati zvanje!", "Popuni polja!", JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					
					try {
						 int a = Integer.parseInt(tfExp.getText());
						 if(a < 0 || a > 100) {
							 JOptionPane.showMessageDialog(null, "Radni staz nije validan", "Popuni polja!", JOptionPane.WARNING_MESSAGE);
								return;
						 }
					} catch(Exception e3) {
						JOptionPane.showMessageDialog(null, "Radni staz nije validan", "Popuni polja!", JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					
					
					
					Adress home = new Adress(tfStreet.getText(), tfNumber.getText(), tfCity.getText(), tfCountry.getText());
					Adress work = new Adress(tfStreetW.getText(), tfNumberW.getText(), tfCityW.getText(), tfCountryW.getText());
					ProfessorController.getInstance().editProfessor(MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow(),tfSurname.getText(), tfName.getText(), tfEmail.getText(), tfBirthDate.getText(), home, work, tfPhoneNumber.getText(), tfId.getText(), comboCalling.getSelectedItem().toString(), Integer.parseInt(tfExp.getText()));
					
					
					
					
					//dispose();
					ok.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().setVisible(false);
				}
			});
			
			
			
			
				
			
			setVisible(true);
				
			
		}
		
		public static void checkValidity() {
			int temp = MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow();
			if (temp == -1) {
				return;
			}
			if(tfSurname.getText().isBlank() || tfName.getText().isBlank() || tfEmail.getText().isBlank() || tfBirthDate.getText().isBlank() || tfStreet.getText().isBlank() || tfNumber.getText().isBlank() || tfCity.getText().isBlank() || tfCountry.getText().isBlank() || tfStreetW.getText().isBlank() || tfNumberW.getText().isBlank() || tfCityW.getText().isBlank() || tfCountryW.getText().isBlank() || tfPhoneNumber.getText().isEmpty() || tfId.getText().isEmpty() ||  tfExp.getText().isBlank()){
				disableOk();
			} else if(ProfessorController.getInstance().alreadyExists(tfId.getText(), temp)) {
				disableOk();
				tfId.selectAll();
				tfId.setSelectedTextColor(Color.red);
				tfId.setToolTipText("Profesor sa ovim brojem licne karte vec postoji");
			} else {
				tfId.setToolTipText("Unesite broj licne karte");
				enableOk();
			}	
		}
		
		public static void enableOk() {
			ok.setEnabled(true);
		}
		
		public static void disableOk() {
			ok.setEnabled(false);
		}

	


}
