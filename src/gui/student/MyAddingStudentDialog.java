package gui.student;


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
import javax.swing.Timer;
import controller.StudentController;
import gui.MainFrame;
import model.Status;

public class MyAddingStudentDialog extends JDialog{

	public int currYear=1;
	public Status stat=Status.B;
	public MyAddingStudentDialog() {
		super(MainFrame.getInstance(),"Dodavanje studenta",true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setSize(new Dimension(kit.getScreenSize().width/4,kit.getScreenSize().height/2));
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		JPanel panCenter=new JPanel();
		JButton btnOk=new JButton("Potvrdi");
		BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		Dimension dim=new Dimension(kit.getScreenSize().width/16,kit.getScreenSize().height/50);
		int konst=kit.getScreenSize().width/20;
		FocusListenerForStudent focusListener = new FocusListenerForStudent(1);
		
		/*Panel for name*/
		JPanel pName=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lName=new JLabel("Ime*");
        lName.setPreferredSize(dim);
        JTextField fName=new JTextField();
        fName.setToolTipText("Unesite ime studenta.");
        fName.setName("name");
        fName.setPreferredSize(dim);
        fName.addFocusListener(focusListener);
        pName.add(Box.createHorizontalStrut(konst));
        pName.add(lName);
        pName.add(fName);
        focusListener.lostFocus(pName, btnOk);
        
        /*Panel for surname*/
        JPanel pSurname=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lSurname=new JLabel("Prezime*");
        lSurname.setPreferredSize(dim);
        JTextField fSurname=new JTextField();
        fSurname.setToolTipText("Unesite prezime studenta.");
        fSurname.setName("surname");
        fSurname.setPreferredSize(dim);
        fSurname.addFocusListener(focusListener);
        pSurname.add(Box.createHorizontalStrut(konst));
        pSurname.add(lSurname);
        pSurname.add(fSurname);
        focusListener.lostFocus(pSurname, btnOk);
        
        /*Panel for birth date*/
        JPanel pBirthDate = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lBirthDate = new JLabel("Datum rodjenja*");
        lBirthDate.setPreferredSize(dim);
        JTextField fBirthDate = new JTextField();
        fBirthDate.setToolTipText("Unesite datum rođenja studenta.");
        fBirthDate.setName("date");
        fBirthDate.addFocusListener(focusListener);
        fBirthDate.setPreferredSize(dim);
        pBirthDate.add(Box.createHorizontalStrut(konst));
        pBirthDate.add(lBirthDate);
        pBirthDate.add(fBirthDate);
        focusListener.lostFocus(pBirthDate, btnOk);
        
        /*Panel for adress*/
        JPanel pAdress = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lAdress = new JLabel("Adresa stanovanja*");
        lAdress.setPreferredSize(dim);
        JTextField fAdress = new JTextField();
        fAdress.setToolTipText("Unesite adresu stanovanja studenta.");
        fAdress.setName("adress");
        fAdress.addFocusListener(focusListener);
        fAdress.setPreferredSize(dim);
        pAdress.add(Box.createHorizontalStrut(konst));
        pAdress.add(lAdress);
        pAdress.add(fAdress);
        focusListener.lostFocus(pAdress, btnOk);
        
        /*Panel for phone number*/
        JPanel pNumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lNumber = new JLabel("Broj telefona*");
        lNumber.setPreferredSize(dim);
        JTextField fNumber = new JTextField();
        fNumber.setToolTipText("Unesite broj telefona studenta.");
        fNumber.setName("number");
        fNumber.addFocusListener(focusListener);
        fNumber.setPreferredSize(dim);
        pNumber.add(Box.createHorizontalStrut(konst));
        pNumber.add(lNumber);
        pNumber.add(fNumber);
        focusListener.lostFocus(pNumber, btnOk);
        
        /*Panel for email*/
        JPanel pEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lEmail = new JLabel("E-mail adresa*");
        lEmail.setPreferredSize(dim);
        JTextField fEmail = new JTextField();
        fEmail.setToolTipText("Unesite e-mail studenta.");
        fEmail.setName("email");
        fEmail.addFocusListener(focusListener);
        fEmail.setPreferredSize(dim);
        pEmail.add(Box.createHorizontalStrut(konst));
        pEmail.add(lEmail);
        pEmail.add(fEmail);
        focusListener.lostFocus(pEmail, btnOk);
        
        JPanel pId = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lId = new JLabel("Broj indeksa*");
        lId.setPreferredSize(dim);
        JTextField fId = new JTextField();
        fId.setToolTipText("Unesite index studenta.");
        fId.setName("index");
        fId.addFocusListener(focusListener);
        fId.setPreferredSize(dim);
        pId.add(Box.createHorizontalStrut(konst));
        pId.add(lId);
        pId.add(fId);
        focusListener.lostFocus(pId, btnOk);
        
        /*Panel for year of entrollment*/
        JPanel pYearOfEntrollment = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lYearOfEntrollment = new JLabel("Godina upisa*");
        lYearOfEntrollment.setPreferredSize(dim);
        JTextField fYearOfEntrollment = new JTextField();
        fYearOfEntrollment.setToolTipText("Unesite godinu upisa studenta.");
        fYearOfEntrollment.setName("yearOfEntrollment");
        fYearOfEntrollment.addFocusListener(focusListener);
        fYearOfEntrollment.setPreferredSize(dim);
        pYearOfEntrollment.add(Box.createHorizontalStrut(konst));
        pYearOfEntrollment.add(lYearOfEntrollment);
        pYearOfEntrollment.add(fYearOfEntrollment);
        focusListener.lostFocus(pYearOfEntrollment, btnOk);
        
        
        /*Panel for current year of study*/
        JPanel pCurrYearOfStudy = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lCurrYearOfStudy = new JLabel("Trenutna godina studija*");
        lCurrYearOfStudy.setPreferredSize(dim);
        String[] CurrYear = { "I (Prva)", "II (Druga)", "III (Treca)", "IV (Cetvrata)", "Master studije", "Doktorske studije",};
        JComboBox<String> combo = new JComboBox<String>(CurrYear);
        combo.setName("currYear");
        combo.setToolTipText("Izaberite godinu studija studenta.");
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
        pCurrYearOfStudy.add(combo);
        
        
        /*Panel for status student*/
        JPanel pStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lStatus = new JLabel("Nacin finansiranja*");
        lStatus.setPreferredSize(dim);
        String[] status = { "Budzet", "Samofinansiranje"};
        JComboBox<String> combo1 = new JComboBox<String>(status);
        combo1.setToolTipText("Izaberite način finansiranja studenta.");
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
        pStatus.add(Box.createHorizontalStrut(konst));
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
						StudentController.getInstance().addStudent(focusListener.getSurname(), focusListener.getName(), focusListener.getDate(), focusListener.getAdress(), focusListener.getNumber(), focusListener.getEmail(), focusListener.getIndex(), focusListener.getYearOfEntrollment(), currYear, stat);
						dispose();
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
					dispose();
				}	
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
