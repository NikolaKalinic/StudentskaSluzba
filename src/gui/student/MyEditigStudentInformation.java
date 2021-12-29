package gui.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import controller.StudentController;
import gui.MainFrame;
import model.Status;
import model.Student;

public class MyEditigStudentInformation extends JPanel {

	public int currYear=1;
	public Status stat=Status.B;
	public MyEditigStudentInformation() {
		Student s=StudentController.getInstance().getSelectedStudent(MyStudentPanel.getInstance().getStudentTable().getSelectedRow());
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		
		
		
		JPanel panCenter=new JPanel();
		JButton btnOk=new JButton("Potvrdi");
		panCenter.setPreferredSize(new Dimension(kit.getScreenSize().width/3,kit.getScreenSize().height/2-kit.getScreenSize().height/10));
		BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);		
		Dimension dim=new Dimension(kit.getScreenSize().width/14,kit.getScreenSize().height/50);
		int konst=kit.getScreenSize().width/15;
		FocusListenerForStudent focusListener = new FocusListenerForStudent(2);
		
		
		/*Panel for name*/
	
		
		JPanel pName=new JPanel(new FlowLayout(FlowLayout.LEFT));	
        JLabel lName=new JLabel("Ime*");
        lName.setPreferredSize(dim);
        JTextField fName=new JTextField();
        fName.setText(s.getName());
        focusListener.setName(s.getName());
        fName.setName("name");
        fName.setPreferredSize(dim);
        fName.addFocusListener(focusListener);
        pName.add(Box.createHorizontalStrut(konst));
        pName.add(lName);
        pName.add(Box.createHorizontalStrut(konst/2));
        pName.add(fName);
        focusListener.lostFocus(pName, btnOk);
        
        /*Panel for surname*/
        JPanel pSurname=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lSurname=new JLabel("Prezime*");
        lSurname.setPreferredSize(dim);
        JTextField fSurname=new JTextField();
        fSurname.setText(s.getSurname());
        focusListener.setSurname(s.getSurname());
        fSurname.setName("surname");
        fSurname.setPreferredSize(dim);
        fSurname.addFocusListener(focusListener);
        pSurname.add(Box.createHorizontalStrut(konst));
        pSurname.add(lSurname);
        pSurname.add(Box.createHorizontalStrut(konst/2));
        pSurname.add(fSurname);
        focusListener.lostFocus(pSurname, btnOk);
        
        /*Panel for birth date*/
        JPanel pBirthDate = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lBirthDate = new JLabel("Datum rodjenja*");
        lBirthDate.setPreferredSize(dim);
        JTextField fBirthDate = new JTextField();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        fBirthDate.setText(formatter.format(s.getDaateOfBirth()));
        focusListener.setDate(s.getDaateOfBirth());
        fBirthDate.setName("date");
        fBirthDate.addFocusListener(focusListener);
        fBirthDate.setPreferredSize(dim);
        pBirthDate.add(Box.createHorizontalStrut(konst));
        pBirthDate.add(lBirthDate);
        pBirthDate.add(Box.createHorizontalStrut(konst/2));
        pBirthDate.add(fBirthDate);
        focusListener.lostFocus(pBirthDate, btnOk);
        
        /*Panel for adress*/
        JPanel pAdress = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lAdress = new JLabel("Adresa stanovanja*");
        lAdress.setPreferredSize(dim);
        JTextField fAdress = new JTextField();
        fAdress.setText(s.getAdress().toString());
        focusListener.setAdress(s.getAdress());
        fAdress.setName("adress");
        fAdress.addFocusListener(focusListener);
        fAdress.setPreferredSize(dim);
        pAdress.add(Box.createHorizontalStrut(konst));
        pAdress.add(lAdress);
        pAdress.add(Box.createHorizontalStrut(konst/2));
        pAdress.add(fAdress);
        focusListener.lostFocus(pAdress, btnOk);
        
        /*Panel for phone number*/
        JPanel pNumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lNumber = new JLabel("Broj telefona*");
        lNumber.setPreferredSize(dim);
        JTextField fNumber = new JTextField();
        fNumber.setText(s.getContactPhone());
        focusListener.setNumber(s.getContactPhone());
        fNumber.setName("number");
        fNumber.addFocusListener(focusListener);
        fNumber.setPreferredSize(dim);
        pNumber.add(Box.createHorizontalStrut(konst));
        pNumber.add(lNumber);
        pNumber.add(Box.createHorizontalStrut(konst/2));
        pNumber.add(fNumber);
        focusListener.lostFocus(pNumber, btnOk);
        
        /*Panel for email*/
        JPanel pEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lEmail = new JLabel("E-mail adresa*");
        lEmail.setPreferredSize(dim);
        JTextField fEmail = new JTextField();
        fEmail.setText(s.getEmail());
        focusListener.setEmail(s.getEmail());
        fEmail.setName("email");
        fEmail.addFocusListener(focusListener);
        fEmail.setPreferredSize(dim);
        pEmail.add(Box.createHorizontalStrut(konst));
        pEmail.add(lEmail);
        pEmail.add(Box.createHorizontalStrut(konst/2));
        pEmail.add(fEmail);
        focusListener.lostFocus(pEmail, btnOk);
        
        /*Panel for index*/
        JPanel pId = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lId = new JLabel("Broj indeksa*");
        lId.setPreferredSize(dim);
        JTextField fId = new JTextField();
        fId.setText(s.getIndex());
        focusListener.setIndex(s.getIndex());
        fId.setName("index");
        fId.addFocusListener(focusListener);
        fId.setPreferredSize(dim);
        pId.add(Box.createHorizontalStrut(konst));
        pId.add(lId);
        pId.add(Box.createHorizontalStrut(konst/2));
        pId.add(fId);
        focusListener.lostFocus(pId, btnOk);
        
        /*Panel for year of entrollment*/
        JPanel pYearOfEntrollment = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lYearOfEntrollment = new JLabel("Godina upisa*");
        lYearOfEntrollment.setPreferredSize(dim);
        JTextField fYearOfEntrollment = new JTextField();
        fYearOfEntrollment.setText(Integer.toString(s.getYearOfEnrollment()));
        focusListener.setYearOfEntrollment(s.getYearOfEnrollment());
        fYearOfEntrollment.setName("yearOfEntrollment");
        fYearOfEntrollment.addFocusListener(focusListener);
        fYearOfEntrollment.setPreferredSize(dim);
        pYearOfEntrollment.add(Box.createHorizontalStrut(konst));
        pYearOfEntrollment.add(lYearOfEntrollment);
        pYearOfEntrollment.add(Box.createHorizontalStrut(konst/2));
        pYearOfEntrollment.add(fYearOfEntrollment);
        focusListener.lostFocus(pYearOfEntrollment, btnOk);
        
        /*Panel for current year of study*/
        JPanel pCurrYearOfStudy = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lCurrYearOfStudy = new JLabel("Trenutna godina studija*");
        lCurrYearOfStudy.setPreferredSize(dim);
        String[] CurrYear = { "I (Prva)", "II (Druga)", "III (Treca)", "IV (Cetvrata)", "Master studije", "Doktorske studije",};
        JComboBox<String> combo = new JComboBox<String>(CurrYear);
        combo.setName("currYear");
        combo.setSelectedIndex(s.getCurrYearOfStudy()-1);
        combo.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				currYear=combo.getSelectedIndex()+1;		//KRECE OD NULE TRBEACE TI NEGDE
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		combo.setPreferredSize(dim);
        pCurrYearOfStudy.add(Box.createHorizontalStrut(konst));
        pCurrYearOfStudy.add(lCurrYearOfStudy);
        pCurrYearOfStudy.add(Box.createHorizontalStrut(konst/2));
        pCurrYearOfStudy.add(combo);
        
        
        /*Panel for status student*/
        JPanel pStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lStatus = new JLabel("Nacin finansiranja*");
        lStatus.setPreferredSize(dim);
        String[] status = { "Budzet", "Samofinansiranje"};
        JComboBox<String> combo1 = new JComboBox<String>(status);
        combo1.setSelectedIndex(s.getStatus()==Status.B?0:1);
        stat=s.getStatus();
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
        /*validation if the field does not get focus and focus lost*/		
        if(s.getName()==focusListener.getName()) {
			focusListener.setKey(focusListener.getKey() | 0b00000001);
		}
		if(s.getSurname()==focusListener.getSurname()) {
			focusListener.setKey(focusListener.getKey() | 0b00000010);
		}
		if(s.getDaateOfBirth()==focusListener.getDate()) {
			focusListener.setKey(focusListener.getKey() | 0b00000100);
		}
		if(s.getAdress()==focusListener.getAdress()) {
			focusListener.setKey(focusListener.getKey() | 0b00001000);
		}
		if(s.getContactPhone()==focusListener.getNumber()) {
			focusListener.setKey(focusListener.getKey() | 0b00010000);
		}
		if(s.getEmail()==focusListener.getEmail()) {
			focusListener.setKey(focusListener.getKey() | 0b00100000);
		}
		if(s.getIndex()==focusListener.getIndex()) {
			focusListener.setKey(focusListener.getKey() | 0b01000000);
		}
		if(s.getYearOfEnrollment()==focusListener.getYearOfEntrollment()) {
			focusListener.setKey(focusListener.getKey() | 0b10000000);
		}
        
        
        
        
        combo1.setPreferredSize(dim);
        pStatus.add(Box.createHorizontalStrut(konst));
        pStatus.add(lStatus);
        pStatus.add(Box.createHorizontalStrut(konst/2));
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
        

        panel.add(panCenter,BorderLayout.CENTER);
		
        JPanel panBottom=new JPanel();
		panBottom.setLayout(new BorderLayout());
		panBottom.setPreferredSize(new Dimension(1,30));
		btnOk.setEnabled(false);
		new Timer(100,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(focusListener.getKey()==0b11111111) {
					btnOk.setEnabled(true);
				}else { 
					btnOk.setEnabled(false);
				}
			}
			
		}).start();
		btnOk.setPreferredSize(new Dimension(90,30));
        btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(focusListener.getKey()==0b11111111) {
					StudentController.getInstance().editStudent(MyStudentPanel.getInstance().getStudentTable().getSelectedRow(),focusListener.getSurname(), focusListener.getName(), focusListener.getDate(), focusListener.getAdress(), focusListener.getNumber(), focusListener.getEmail(), focusListener.getIndex(), focusListener.getYearOfEntrollment(), combo.getSelectedIndex()+1, stat);
					btnOk.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().setVisible(false);
				}
				
			}
		});
		
		
		JButton btnCancel=new JButton("Odustani");
		btnCancel.setPreferredSize(new Dimension(90,30));
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da zelite da odustanete ?", "Potvrda odustajanja", JOptionPane.YES_NO_OPTION);
				if (a == JOptionPane.YES_OPTION) {
					btnCancel.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().setVisible(false);
				}
			}
		});
		JPanel botWest = new JPanel();
		botWest.setPreferredSize(new Dimension(kit.getScreenSize().width/10,1));
		panBottom.add(botWest,BorderLayout.WEST);
		JPanel botEast = new JPanel();
		botEast.setPreferredSize(new Dimension(kit.getScreenSize().width/15,1));
		panBottom.add(botEast,BorderLayout.EAST);
		JPanel centerButton = new JPanel();
		centerButton.setLayout(new BorderLayout());
		centerButton.add(btnOk,BorderLayout.WEST);
		centerButton.add(btnCancel,BorderLayout.EAST);
		panBottom.add(centerButton,BorderLayout.CENTER);
		panel.add(panBottom,BorderLayout.SOUTH);
		add(panel);
    	setVisible(true);
	}
}
