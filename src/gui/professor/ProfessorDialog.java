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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import controller.ProfessorController;
import gui.MainFrame;
import model.Adress;

public class ProfessorDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	private static JLabel idInfo;
	private static JButton ok;
	

	public ProfessorDialog() {
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("addingProfessor"), true);
		setSize(300, 650);
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		FocusListenerForProfessor focusListener = new FocusListenerForProfessor();
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		this.add(panel, BorderLayout.CENTER);
		
		JLabel name = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profName"));
		tfName = new JTextField();
		tfName.addFocusListener(focusListener);
		tfName.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfName"));
		GridBagConstraints cName =  new GridBagConstraints();
		cName.gridx = 0;
		cName.gridy = 0;
		cName.insets = new Insets(0, 0, 0, 0);
		cName.fill = GridBagConstraints.HORIZONTAL;
		panel.add(name, cName);
		GridBagConstraints cNameTf =  new GridBagConstraints();
		cNameTf.gridx = 1;
		cNameTf.gridy = 0;
		cNameTf.fill = GridBagConstraints.HORIZONTAL;
		cNameTf.insets = new Insets(5, 5, 0, 10);
		panel.add(tfName, cNameTf);
		
		
		
		JLabel Surname = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profSurname"));
		tfSurname = new JTextField();
		tfSurname.addFocusListener(focusListener);
		tfSurname.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfSurname"));
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
		
		JLabel email = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profEmail"));
		tfEmail = new JTextField();
		tfEmail.addFocusListener(focusListener);
		tfEmail.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfEmail"));
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
		
		JLabel birthDate = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profYearOfBirth"));
		tfBirthDate = new JTextField();
		tfBirthDate.addFocusListener(focusListener);
		tfBirthDate.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfYearOfBirth"));
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
		
		JLabel homeAdress = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profHomeAdressLabel"));
		JLabel homeStreet = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profStreet"));
		JLabel homeNumber = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profNumber"));
		JLabel homeCity = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profCity"));
		JLabel homeCountry = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profCountry"));
		tfStreet = new JTextField();
		tfStreet.addFocusListener(focusListener);
		tfNumber = new JTextField();
		tfNumber.addFocusListener(focusListener);
		tfCity = new JTextField();
		tfCity.addFocusListener(focusListener);
		tfCountry = new JTextField();
		tfCountry.addFocusListener(focusListener);
		
		tfStreet.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfStreet"));
		tfNumber.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfNumber"));
		tfCity.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfCity"));
		tfCountry.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfCountry"));
		
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
		
		JLabel workAdress = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profWorkAdressLabel"));
		JLabel workStreet = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profStreet"));
		JLabel workNumber = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profNumber"));
		JLabel workCity = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profCity"));
		JLabel workCountry = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profCountry"));
		tfStreetW = new JTextField();
		tfStreetW.addFocusListener(focusListener);
		tfNumberW = new JTextField();
		tfNumberW.addFocusListener(focusListener);
		tfCityW = new JTextField();
		tfCityW.addFocusListener(focusListener);
		tfCountryW = new JTextField();
		tfCountryW.addFocusListener(focusListener);
		
		tfStreetW.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfStreet"));
		tfNumberW.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfNumber"));
		tfCityW.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfCity"));
		tfCountryW.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfCountry"));
		
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
		
		
		JLabel phoneNumber = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profPhoneNumber"));
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfPhoneNumber"));
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
		
		JLabel id = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profId"));
		tfId = new JTextField();
		tfId.addFocusListener(focusListener);
		tfId.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfId"));
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
		
		idInfo = new JLabel("                                    ");
		GridBagConstraints cIdInfo = new GridBagConstraints();
		cIdInfo.gridwidth = 2;
		cIdInfo.gridx = 0;
		cIdInfo.gridy = 16;
		cIdInfo.insets = new Insets(10, 0, 0, 0);
		idInfo.setForeground(Color.black);
		panel.add(idInfo, cIdInfo);
		
		JLabel calling = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profCalling"));
		String[] callings = {"-", MainFrame.getInstance().getResourceBundle().getString("profCallingLecturer"), MainFrame.getInstance().getResourceBundle().getString("profCallingAssociateProfessor"), MainFrame.getInstance().getResourceBundle().getString("profCallingProfessor")};
		comboCalling = new JComboBox<String>(callings);
		GridBagConstraints cCalling =  new GridBagConstraints();
		cCalling.gridx = 0;
		cCalling.gridy = 18;
		cCalling.fill = GridBagConstraints.HORIZONTAL;
		cCalling.insets = new Insets(10, 0, 0, 0);
		panel.add(calling, cCalling);
		GridBagConstraints cComboCalling = new GridBagConstraints();
		cComboCalling.gridx = 1;
		cComboCalling.gridy = 18;
		cComboCalling.insets = new Insets(10, 5, 0, 10);
		panel.add(comboCalling, cComboCalling);
		
		
		JLabel exp = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profExperience"));
		tfExp = new JTextField();
		tfExp.setName("exp");
		tfExp.addFocusListener(focusListener);
		tfExp.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfExperience"));
		GridBagConstraints cExp =  new GridBagConstraints();
		cExp.gridx = 0;
		cExp.gridy = 17;
		cExp.fill = GridBagConstraints.HORIZONTAL;
		cExp.insets = new Insets(10, 0, 0, 30);
		panel.add(exp, cExp);
		GridBagConstraints cExpTf =  new GridBagConstraints();
		cExpTf.gridx = 1;
		cExpTf.gridy = 17;
		cExpTf.fill = GridBagConstraints.HORIZONTAL;
		cExpTf.insets = new Insets(10, 10, 0, 30);
		panel.add(tfExp, cExpTf);
		
		JPanel botPanel = new JPanel();
		botPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
		Dimension botDim = new Dimension();
		botDim.setSize(200, 50);
		botPanel.setPreferredSize(botDim);
		ok = new JButton(MainFrame.getInstance().getResourceBundle().getString("btnConfirm"));
		ok.setEnabled(true);
		ok.setFocusPainted(false);
		
		new Timer(100,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ProfessorDialog.checkValidity();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}).start();
	
		
		JButton cancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("btnCancel"));
		cancel.setFocusPainted(false);
		botPanel.add(ok);
		botPanel.add(cancel);
		this.add(botPanel, BorderLayout.SOUTH);
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				}	
		});
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(!(tfEmail.getText().contains("@"))) {
					JOptionPane.showMessageDialog(null, MainFrame.getInstance().getResourceBundle().getString("wrongFormatEmail"), MainFrame.getInstance().getResourceBundle().getString("completeFields"), JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				try {
					LocalDate.parse(tfBirthDate.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				} catch (Exception e1 ) {
					JOptionPane.showMessageDialog(null, MainFrame.getInstance().getResourceBundle().getString("wrongFormatBirthDate"), MainFrame.getInstance().getResourceBundle().getString("completeFields"), JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				
				
				if(comboCalling.getSelectedItem().toString().equals("-")) {
					JOptionPane.showMessageDialog(null, MainFrame.getInstance().getResourceBundle().getString("wrongCalling"), MainFrame.getInstance().getResourceBundle().getString("completeFields"), JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				
				try {
					 int a = Integer.parseInt(tfExp.getText());
					 if(a < 0 || a > 100) {
						 JOptionPane.showMessageDialog(null, MainFrame.getInstance().getResourceBundle().getString("wrongExperience"), MainFrame.getInstance().getResourceBundle().getString("completeFields"), JOptionPane.WARNING_MESSAGE);
							return;
					 }
				} catch(Exception e3) {
					JOptionPane.showMessageDialog(null, MainFrame.getInstance().getResourceBundle().getString("wrongExperience"), MainFrame.getInstance().getResourceBundle().getString("completeFields"), JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				
				
				
				Adress home = new Adress(tfStreet.getText(), tfNumber.getText(), tfCity.getText(), tfCountry.getText());
				Adress work = new Adress(tfStreetW.getText(), tfNumberW.getText(), tfCityW.getText(), tfCountryW.getText());
				ProfessorController.getInstance().addProfessor(tfSurname.getText(), tfName.getText(), tfEmail.getText(), tfBirthDate.getText(), home, work, tfPhoneNumber.getText(), tfId.getText(), comboCalling.getSelectedItem().toString(), Integer.parseInt(tfExp.getText()));
				
				
				
				
				dispose();
				
			}
		});
		
		
		
		
			
		
		setVisible(true);
			
		
	}
	
	public static void checkValidity() throws Exception {
		if(tfSurname.getText().isBlank() || tfName.getText().isBlank() || tfEmail.getText().isBlank() || tfBirthDate.getText().isBlank() || tfStreet.getText().isBlank() || tfNumber.getText().isBlank() || tfCity.getText().isBlank() || tfCountry.getText().isBlank() || tfStreetW.getText().isBlank() || tfNumberW.getText().isBlank() || tfCityW.getText().isBlank() || tfCountryW.getText().isBlank() || tfPhoneNumber.getText().isEmpty() || tfId.getText().isEmpty() ||  tfExp.getText().isBlank()){
			disableOk();
		} else if(ProfessorController.getInstance().alreadyExists(tfId.getText())) {
			disableOk();
			tfId.selectAll();
			idInfo.setForeground(Color.red);
			idInfo.setText(MainFrame.getInstance().getResourceBundle().getString("duplicateProfId1"));
			tfId.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("duplicateProfId1"));
		} else {
			tfId.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("insertProfId"));
			idInfo.setForeground(Color.black);
			idInfo.setText("                                   ");
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
