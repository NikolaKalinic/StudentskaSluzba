package gui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentController;
import model.Status;

public class MyAddingStudentDialog extends JDialog{

	public int currYear=1;
	public Status stat=Status.B;
	public MyAddingStudentDialog() {
		super(MainFrame.getInstance(),"Dodavanje studenta",true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setSize(new Dimension(kit.getScreenSize().width/4,kit.getScreenSize().width/4));
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		
		JPanel panCenter=new JPanel();
		BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		Dimension dim=new Dimension(150,25);
		
		FocusListenerForStudent focusListener = new FocusListenerForStudent();
		
		/*Panel for name*/
		JPanel pName=new JPanel(new FlowLayout(FlowLayout.LEFT));	
        JLabel lName=new JLabel("Ime*");
        lName.setPreferredSize(dim);
        JTextField fName=new JTextField();
        
        fName.setName("name");
        fName.setPreferredSize(dim);
        fName.addFocusListener(focusListener);
        pName.add(Box.createHorizontalStrut(60));
        pName.add(lName);
        pName.add(fName);
        
        
        /*Panel for surname*/
        JPanel pSurname=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lSurname=new JLabel("Prezime*");
        lSurname.setPreferredSize(dim);
        JTextField fSurname=new JTextField();
      
        fSurname.setName("surname");
        fSurname.setPreferredSize(dim);
        fSurname.addFocusListener(focusListener);
        pSurname.add(Box.createHorizontalStrut(60));
        pSurname.add(lSurname);
        pSurname.add(fSurname);
        
        
        /*Panel for birth date*/
        JPanel pBirthDate = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lBirthDate = new JLabel("Datum rodjenja*");
        lBirthDate.setPreferredSize(dim);
        JTextField fBirthDate = new JTextField();
        fBirthDate.setName("date");
        fBirthDate.addFocusListener(focusListener);
        fBirthDate.setPreferredSize(dim);
        pBirthDate.add(Box.createHorizontalStrut(60));
        pBirthDate.add(lBirthDate);
        pBirthDate.add(fBirthDate);
        
        /*Panel for adress*/
        JPanel pAdress = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lAdress = new JLabel("Adresa stanovanja*");
        lAdress.setPreferredSize(dim);
        JTextField fAdress = new JTextField();
        fAdress.setName("adress");
        fAdress.addFocusListener(focusListener);
        fAdress.setPreferredSize(dim);
        pAdress.add(Box.createHorizontalStrut(60));
        pAdress.add(lAdress);
        pAdress.add(fAdress);
        
        /*Panel for phone number*/
        JPanel pNumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lNumber = new JLabel("Broj telefona*");
        lNumber.setPreferredSize(dim);
        JTextField fNumber = new JTextField();
        fNumber.setName("number");
        fNumber.addFocusListener(focusListener);
        fNumber.setPreferredSize(dim);
        pNumber.add(Box.createHorizontalStrut(60));
        pNumber.add(lNumber);
        pNumber.add(fNumber);
        
        /*Panel for email*/
        JPanel pEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lEmail = new JLabel("E-mail adresa*");
        lEmail.setPreferredSize(dim);
        JTextField fEmail = new JTextField();
        fEmail.setName("email");
        fEmail.addFocusListener(focusListener);
        fEmail.setPreferredSize(dim);
        pEmail.add(Box.createHorizontalStrut(60));
        pEmail.add(lEmail);
        pEmail.add(fEmail);
        
        JPanel pId = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lId = new JLabel("Broj indeksa*");
        lId.setPreferredSize(dim);
        JTextField fId = new JTextField();
        fId.setName("index");
        fId.addFocusListener(focusListener);
        fId.setPreferredSize(dim);
        pId.add(Box.createHorizontalStrut(60));
        pId.add(lId);
        pId.add(fId);
        
        /*Panel for year of entrollment*/
        JPanel pYearOfEntrollment = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lYearOfEntrollment = new JLabel("Godina upisa*");
        lYearOfEntrollment.setPreferredSize(dim);
        JTextField fYearOfEntrollment = new JTextField();
        fYearOfEntrollment.setName("yearOfEntrollment");
        fYearOfEntrollment.addFocusListener(focusListener);
        fYearOfEntrollment.setPreferredSize(dim);
        pYearOfEntrollment.add(Box.createHorizontalStrut(60));
        pYearOfEntrollment.add(lYearOfEntrollment);
        pYearOfEntrollment.add(fYearOfEntrollment);
        
        /*Panel for current year of study*/
        JPanel pCurrYearOfStudy = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lCurrYearOfStudy = new JLabel("Trenutna godina studija*");
        lCurrYearOfStudy.setPreferredSize(dim);
        String[] CurrYear = { "I (Prva)", "II (Druga)", "III (Treca)", "IV (Cetvrata)", "Master studije", "Doktorske studije",};
        JComboBox<String> combo = new JComboBox<String>(CurrYear);
        combo.setName("currYear");
        
        combo.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				currYear=combo.getSelectedIndex();		//KRECE OD NULE TRBEACE TI NEGDE
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		combo.setPreferredSize(dim);
        pCurrYearOfStudy.add(Box.createHorizontalStrut(60));
        pCurrYearOfStudy.add(lCurrYearOfStudy);
        pCurrYearOfStudy.add(combo);
        
        
        /*Panel for status student*/
        JPanel pStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lStatus = new JLabel("Nacin finansiranja*");
        lStatus.setPreferredSize(dim);
        String[] status = { "Budzet", "Samofinansiranje"};
        JComboBox<String> combo1 = new JComboBox<String>(status);
        combo1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(combo1.getSelectedIndex()==0)
					stat=Status.B;
				else
					stat=Status.S;
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        combo1.setPreferredSize(dim);
        pStatus.add(Box.createHorizontalStrut(60));
        pStatus.add(lStatus);
        pStatus.add(combo1);
        
        
        panCenter.add(Box.createVerticalStrut(25));
        panCenter.add(pName);
        panCenter.add(pSurname);
        panCenter.add(pBirthDate);
        panCenter.add(pAdress);
        panCenter.add(pNumber);
        panCenter.add(pEmail);
        panCenter.add(pId);
        panCenter.add(pYearOfEntrollment);
        panCenter.add(pCurrYearOfStudy);
        panCenter.add(pStatus);
        panCenter.add(Box.createVerticalStrut(25));  
        add(panCenter,BorderLayout.CENTER);
		
        JPanel panBottom=new JPanel();
		BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);
		
		JButton btnOk=new JButton("Potvrdi");
		btnOk.setPreferredSize(new Dimension(90,30));
        btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(focusListener.getKey()==0b11111111) {
					StudentController.getInstance().addStudent(focusListener.getSurname(), focusListener.getName(), focusListener.getDate(), focusListener.getAdress(), focusListener.getNumber(), focusListener.getEmail(), focusListener.getIndex(), focusListener.getYearOfEntrollment(), currYear, stat);
				}else
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke ! ");
				
			}
		});
		
		
		JButton btnCancel=new JButton("Odustani");
		btnCancel.setPreferredSize(new Dimension(90,30));
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panBottom.add(Box.createGlue());
		panBottom.add(btnOk);
		panBottom.add(Box.createGlue());
		panBottom.add(btnCancel);
		panBottom.add(Box.createGlue());
		add(panBottom,BorderLayout.SOUTH);
        
    	setVisible(true);
    	pack();
	}
}
