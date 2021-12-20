package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfessorController;
import model.Adress;

public class ProfessorDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfessorDialog() {
		super(MainFrame.getInstance(), "Dodavanje profesora", true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int sHeight = d.height;
		int sWidth = d.width;
		setSize(sWidth/4, sHeight/2);
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		this.add(panel, BorderLayout.CENTER);
		
		JLabel ime = new JLabel("Ime*");
		JTextField tfIme = new JTextField();
		tfIme.setToolTipText("Unesite ime profesora");
		GridBagConstraints cIme =  new GridBagConstraints();
		cIme.gridx = 0;
		cIme.gridy = 0;
		cIme.insets = new Insets(10, 0, 0, 0);
		panel.add(ime, cIme);
		GridBagConstraints cImeTf =  new GridBagConstraints();
		cImeTf.gridx = 1;
		cImeTf.gridy = 0;
		cImeTf.fill = GridBagConstraints.HORIZONTAL;
		cImeTf.insets = new Insets(5, 5, 0, 10);
		panel.add(tfIme, cImeTf);
		
		
		
		JLabel prezime = new JLabel("Prezime*");
		JTextField tfPrezime = new JTextField();
		tfPrezime.setToolTipText("Unesite prezime profesora");
		GridBagConstraints cPrezime =  new GridBagConstraints();
		cPrezime.gridx = 0;
		cPrezime.gridy = 1;
		cPrezime.insets = new Insets(10, 0, 0, 0);
		panel.add(prezime, cPrezime);
		GridBagConstraints cPrezimeTf =  new GridBagConstraints();
		cPrezimeTf.gridx = 1;
		cPrezimeTf.gridy = 1;
		cPrezimeTf.fill = GridBagConstraints.HORIZONTAL;
		cPrezimeTf.insets = new Insets(5, 5, 0, 10);
		panel.add(tfPrezime, cPrezimeTf);
		
		JLabel email = new JLabel("E-mail*");
		JTextField tfEmail = new JTextField();
		tfEmail.setToolTipText("Unesite e-mail profesora");
		GridBagConstraints cEmail =  new GridBagConstraints();
		cEmail.gridx = 0;
		cEmail.gridy = 2;
		cEmail.insets = new Insets(10, 0, 0, 0);
		panel.add(email, cEmail);
		GridBagConstraints cEmailTf =  new GridBagConstraints();
		cEmailTf.gridx = 1;
		cEmailTf.gridy = 2;
		cEmailTf.fill = GridBagConstraints.HORIZONTAL;
		cEmailTf.insets = new Insets(5, 5, 0, 10);
		panel.add(tfEmail, cEmailTf);
		
		JLabel birthDate = new JLabel("Godina rodjenja*");
		JTextField tfBirthDate = new JTextField();
		tfBirthDate.setToolTipText("Unesite datum rodjenja [YYYY/MM/DD]");
		GridBagConstraints cBirthDate =  new GridBagConstraints();
		cBirthDate.gridx = 0;
		cBirthDate.gridy = 3;
		cBirthDate.insets = new Insets(10, 0, 0, 0);
		panel.add(birthDate, cBirthDate);
		GridBagConstraints cBirthDateTf =  new GridBagConstraints();
		cBirthDateTf.gridx = 1;
		cBirthDateTf.gridy = 3;
		cBirthDateTf.fill = GridBagConstraints.HORIZONTAL;
		cBirthDateTf.insets = new Insets(5, 5, 0, 10);
		panel.add(tfBirthDate, cBirthDateTf);
		
		JLabel homeAdress = new JLabel("Kucna adresa*");
		JTextField tfStreet = new JTextField();
		tfStreet.setToolTipText("Unesite kucnu adresu [Ulica/Broj/Grad/Drzava]");
		GridBagConstraints cHA =  new GridBagConstraints();
		cHA.gridx = 0;
		cHA.gridy = 4;
		cHA.insets = new Insets(10, 0, 0, 0);
		panel.add(homeAdress, cHA);
		GridBagConstraints cStreetTf =  new GridBagConstraints();
		cStreetTf.gridx = 1;
		cStreetTf.gridy = 4;
		cStreetTf.fill = GridBagConstraints.HORIZONTAL;
		cStreetTf.insets = new Insets(5, 5, 0, 10);
		panel.add(tfStreet, cStreetTf);
		
		JLabel workAdress = new JLabel("Radna adresa*");
		JTextField tfStreetW = new JTextField();
		tfStreetW.setToolTipText("Unesite poslovnu adresu [Ulica/Broj/Grad/Drzava]");
		GridBagConstraints cHAW =  new GridBagConstraints();
		cHAW.gridx = 0;
		cHAW.gridy = 5;
		cHAW.insets = new Insets(10, 0, 0, 0);
		panel.add(workAdress, cHAW);
		GridBagConstraints cStreetTfW =  new GridBagConstraints();
		cStreetTfW.gridx = 1;
		cStreetTfW.gridy = 5;
		cStreetTfW.fill = GridBagConstraints.HORIZONTAL;
		cStreetTfW.insets = new Insets(5, 5, 0, 10);
		panel.add(tfStreetW, cStreetTfW);
		
		
		JLabel phoneNumber = new JLabel("Broj telefona*");
		JTextField tfPhoneNumber = new JTextField();
		tfPhoneNumber.setToolTipText("Unesite broj telefona");
		GridBagConstraints cPhoneNumber =  new GridBagConstraints();
		cPhoneNumber.gridx = 0;
		cPhoneNumber.gridy = 6;
		cPhoneNumber.insets = new Insets(10, 0, 0, 0);
		panel.add(phoneNumber, cPhoneNumber);
		GridBagConstraints cPhoneNumberTf =  new GridBagConstraints();
		cPhoneNumberTf.gridx = 1;
		cPhoneNumberTf.gridy = 6;
		cPhoneNumberTf.fill = GridBagConstraints.HORIZONTAL;
		cPhoneNumberTf.insets = new Insets(5, 5, 0, 10);
		panel.add(tfPhoneNumber, cPhoneNumberTf);
		
		JLabel id = new JLabel("Broj licne karte*");
		JTextField tfId = new JTextField();
		tfId.setToolTipText("Unesite broj licne karte");
		GridBagConstraints cId =  new GridBagConstraints();
		cId.gridx = 0;
		cId.gridy = 7;
		cId.insets = new Insets(10, 0, 0, 0);
		panel.add(id, cId);
		GridBagConstraints cIdTf =  new GridBagConstraints();
		cIdTf.gridx = 1;
		cIdTf.gridy = 7;
		cIdTf.fill = GridBagConstraints.HORIZONTAL;
		cIdTf.insets = new Insets(5, 5, 0, 10);
		panel.add(tfId, cIdTf);
		
		JLabel calling = new JLabel("Zvanje");
		String[] callings = {"-", "Asistent", "Docent", "Vanredni profesor", "Profesor"};
		JComboBox<String> comboCalling = new JComboBox<String>(callings);
		GridBagConstraints cCalling =  new GridBagConstraints();
		cCalling.gridx = 0;
		cCalling.gridy = 8;
		cCalling.insets = new Insets(0, 0, 0, 0);
		panel.add(calling, cCalling);
		GridBagConstraints cComboCalling = new GridBagConstraints();
		cComboCalling.gridx = 1;
		cComboCalling.gridy = 8;
		cComboCalling.insets = new Insets(0, 0, 0, 0);
		panel.add(comboCalling, cComboCalling);
		
		
		JLabel title = new JLabel("Titula*");
		GridBagConstraints cTitle =  new GridBagConstraints();
		String [] titles = {"-", "Master", "Doktor"};
		JComboBox<String> comboTitle = new JComboBox<String>(titles);
		cTitle.gridx = 0;
		cTitle.gridy = 9;
		cTitle.insets = new Insets(0, 0, 0, 0);
		panel.add(title, cTitle);
		GridBagConstraints cComboTitle = new GridBagConstraints();
		cComboTitle.gridx = 1;
		cComboTitle.gridy = 9;
		cComboTitle.insets = new Insets(0, 0, 0, 0);
		panel.add(comboTitle, cComboTitle);
		
		JLabel exp = new JLabel("Godine iskustva*");
		JTextField tfExp = new JTextField();
		tfExp.setToolTipText("Unesite godine iskustva [int]");
		GridBagConstraints cExp =  new GridBagConstraints();
		cExp.gridx = 0;
		cExp.gridy = 10;
		cExp.insets = new Insets(10, 0, 0, 0);
		panel.add(exp, cExp);
		GridBagConstraints cExpTf =  new GridBagConstraints();
		cExpTf.gridx = 1;
		cExpTf.gridy = 10;
		cExpTf.fill = GridBagConstraints.HORIZONTAL;
		cExpTf.insets = new Insets(5, 5, 0, 10);
		panel.add(tfExp, cExpTf);
		
		JPanel botPanel = new JPanel();
		botPanel.setLayout(new FlowLayout());
		JButton ok = new JButton("OK");
		JButton cancel = new JButton("CANCEL");
		botPanel.add(ok);
		botPanel.add(cancel);
		this.add(botPanel, BorderLayout.SOUTH);
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int a = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da zelite da odustanete ?", "Potvrda odustajanja", JOptionPane.YES_NO_OPTION);
				if (a == JOptionPane.YES_OPTION) {
					dispose();
				}	
			}
		});
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tfIme.getText().isBlank()) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ne ostavljati polje ime praznim!", "Popuni polja!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				
				if(tfPrezime.getText().isBlank()) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ne ostavljati polje prezime praznim!", "Popuni polja!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(!(tfEmail.getText().contains("@"))) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Email adresa je u pogresnom formatu!", "Popuni polja!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					LocalDate.parse(tfBirthDate.getText());
				} catch (Exception e1 ) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Datum mora biti u formatu 'YYYY-MM-DD'", "Popuni polja!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					String split1[] = tfStreet.getText().split("/");
					Adress home = new Adress(split1[0], split1[1], split1[2], split1[3]);
				} catch(Exception e2) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Adresa mora biti formata 'STREET/NUMBER/CITY/COUNTRY'", "Popuni polja!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				try {
					String split2[] = tfStreetW.getText().split("/");
					Adress work = new Adress(split2[0], split2[1], split2[2], split2[3]);
				} catch(Exception e3) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Adresa mora biti formata 'STREET/NUMBER/CITY/COUNTRY'", "Popuni polja!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					Integer.parseInt(tfPhoneNumber.getText());
				} catch(Exception e3) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Broj telefona nije validan", "Popuni polja!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(tfId.getText().isBlank()) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ne ostavljati polje broja licne karte praznim!", "Popuni polja!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(comboCalling.getSelectedItem().toString().equals("-")) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izabrati zvanje!", "Popuni polja!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(comboTitle.getSelectedItem().toString().equals("-")) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Izabrati titulu!", "Popuni polja!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					 int a = Integer.parseInt(tfExp.getText());
					 if(a < 0 || a > 100) {
						 JOptionPane.showMessageDialog(MainFrame.getInstance(), "Radni staz nije validan", "Popuni polja!", JOptionPane.ERROR_MESSAGE);
							return;
					 }
				} catch(Exception e3) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Radni staz nije validan", "Popuni polja!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				
				
				
				String split1[] = tfStreet.getText().split("/");
				Adress home = new Adress(split1[0], split1[1], split1[2], split1[3]);
				String split2[] = tfStreetW.getText().split("/");
				Adress work = new Adress(split2[0], split2[1], split2[2], split2[3]);
				ProfessorController.getInstance().addProfessor(tfIme.getText(), tfPrezime.getText(), tfEmail.getText(), tfBirthDate.getText(), home, work, tfPhoneNumber.getText(), tfId.getText(), comboCalling.getSelectedItem().toString(), comboTitle.getSelectedItem().toString(), Integer.parseInt(tfExp.getText()));
				
				
				
				
				
				
			}
		});
		
		setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
