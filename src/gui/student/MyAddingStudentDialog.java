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
	
	
	private JButton btnOk;
	private JLabel lName;
	private JTextField fName;
	private JLabel lSurname;
	private JTextField fSurname;
	private JLabel lBirthDate;
	private JTextField fBirthDate;
	private JLabel lAdress;
	private JTextField fAdress;
	private JLabel lNumber;
	private JTextField fNumber;
	private JLabel lEmail;
	private JTextField fEmail;
	private JLabel lId;
	private JTextField fId;
	private JLabel lYearOfEntrollment;
	private JTextField fYearOfEntrollment;
	private  JLabel lCurrYearOfStudy;
	private JLabel lStatus ;
	private JComboBox<String> combo1;
	private JComboBox<String> combo;
	private JButton btnCancel;
	
	
	public MyAddingStudentDialog() {
		super(MainFrame.getInstance(),MainFrame.getInstance().getResourceBundle().getString("addStudent"),true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setSize(new Dimension(kit.getScreenSize().width/4,kit.getScreenSize().height/2));
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		JPanel panCenter=new JPanel();
		 btnOk=new JButton(MainFrame.getInstance().getResourceBundle().getString("btnConfirm"));
		BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		Dimension dim=new Dimension(kit.getScreenSize().width/16,kit.getScreenSize().height/50);
		int konst=kit.getScreenSize().width/20;
		FocusListenerForStudent focusListener = new FocusListenerForStudent(1);
		
		/*Panel for name*/
		JPanel pName=new JPanel(new FlowLayout(FlowLayout.LEFT));
         lName=new JLabel(MainFrame.getInstance().getResourceBundle().getString("studentName"));
        lName.setPreferredSize(dim);
         fName=new JTextField();
        fName.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("studentNameTooltip"));
        fName.setName("name");
        fName.setPreferredSize(dim);
        fName.addFocusListener(focusListener);
        pName.add(Box.createHorizontalStrut(konst));
        pName.add(lName);
        pName.add(fName);
        focusListener.lostFocus(pName, btnOk);
        
        /*Panel for surname*/
        JPanel pSurname=new JPanel(new FlowLayout(FlowLayout.LEFT));
         lSurname=new JLabel(MainFrame.getInstance().getResourceBundle().getString("studentSurname"));
        lSurname.setPreferredSize(dim);
         fSurname=new JTextField();
        fSurname.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("studentSurnameTooltip"));
        fSurname.setName("surname");
        fSurname.setPreferredSize(dim);
        fSurname.addFocusListener(focusListener);
        pSurname.add(Box.createHorizontalStrut(konst));
        pSurname.add(lSurname);
        pSurname.add(fSurname);
        focusListener.lostFocus(pSurname, btnOk);
        
        /*Panel for birth date*/
        JPanel pBirthDate = new JPanel(new FlowLayout(FlowLayout.LEFT));
         lBirthDate = new JLabel(MainFrame.getInstance().getResourceBundle().getString("studentDate"));
        lBirthDate.setPreferredSize(dim);
         fBirthDate = new JTextField();
        fBirthDate.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("studentDateTooltip"));
        fBirthDate.setName("date");
        fBirthDate.addFocusListener(focusListener);
        fBirthDate.setPreferredSize(dim);
        pBirthDate.add(Box.createHorizontalStrut(konst));
        pBirthDate.add(lBirthDate);
        pBirthDate.add(fBirthDate);
        focusListener.lostFocus(pBirthDate, btnOk);
        
        /*Panel for adress*/
        JPanel pAdress = new JPanel(new FlowLayout(FlowLayout.LEFT));
         lAdress = new JLabel(MainFrame.getInstance().getResourceBundle().getString("studentAdress"));
        lAdress.setPreferredSize(dim);
         fAdress = new JTextField();
        fAdress.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("studentAdressTooltip"));
        fAdress.setName("adress");
        fAdress.addFocusListener(focusListener);
        fAdress.setPreferredSize(dim);
        pAdress.add(Box.createHorizontalStrut(konst));
        pAdress.add(lAdress);
        pAdress.add(fAdress);
        focusListener.lostFocus(pAdress, btnOk);
        
        /*Panel for phone number*/
        JPanel pNumber = new JPanel(new FlowLayout(FlowLayout.LEFT));
         lNumber = new JLabel(MainFrame.getInstance().getResourceBundle().getString("studentPhone"));
        lNumber.setPreferredSize(dim);
         fNumber = new JTextField();
        fNumber.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("studentPhoneTooltip"));
        fNumber.setName("number");
        fNumber.addFocusListener(focusListener);
        fNumber.setPreferredSize(dim);
        pNumber.add(Box.createHorizontalStrut(konst));
        pNumber.add(lNumber);
        pNumber.add(fNumber);
        focusListener.lostFocus(pNumber, btnOk);
        
        /*Panel for email*/
        JPanel pEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
         lEmail = new JLabel(MainFrame.getInstance().getResourceBundle().getString("studentEmail"));
        lEmail.setPreferredSize(dim);
         fEmail = new JTextField();
        fEmail.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("studentEmailTooltip"));
        fEmail.setName("email");
        fEmail.addFocusListener(focusListener);
        fEmail.setPreferredSize(dim);
        pEmail.add(Box.createHorizontalStrut(konst));
        pEmail.add(lEmail);
        pEmail.add(fEmail);
        focusListener.lostFocus(pEmail, btnOk);
        
        JPanel pId = new JPanel(new FlowLayout(FlowLayout.LEFT));
         lId = new JLabel(MainFrame.getInstance().getResourceBundle().getString("studentId"));
        lId.setPreferredSize(dim);
         fId = new JTextField();
        fId.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("studentIdTooltip"));
        fId.setName("index");
        fId.addFocusListener(focusListener);
        fId.setPreferredSize(dim);
        pId.add(Box.createHorizontalStrut(konst));
        pId.add(lId);
        pId.add(fId);
        focusListener.lostFocus(pId, btnOk);
        
        /*Panel for year of entrollment*/
        JPanel pYearOfEntrollment = new JPanel(new FlowLayout(FlowLayout.LEFT));
         lYearOfEntrollment = new JLabel(MainFrame.getInstance().getResourceBundle().getString("studentYearEn"));
        lYearOfEntrollment.setPreferredSize(dim);
         fYearOfEntrollment = new JTextField();
        fYearOfEntrollment.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("studentYearEnTooltip"));
        fYearOfEntrollment.setName("yearOfEntrollment");
        fYearOfEntrollment.addFocusListener(focusListener);
        fYearOfEntrollment.setPreferredSize(dim);
        pYearOfEntrollment.add(Box.createHorizontalStrut(konst));
        pYearOfEntrollment.add(lYearOfEntrollment);
        pYearOfEntrollment.add(fYearOfEntrollment);
        focusListener.lostFocus(pYearOfEntrollment, btnOk);
        
        
        /*Panel for current year of study*/
        JPanel pCurrYearOfStudy = new JPanel(new FlowLayout(FlowLayout.LEFT));
         lCurrYearOfStudy = new JLabel(MainFrame.getInstance().getResourceBundle().getString("studentYearCur"));
        lCurrYearOfStudy.setPreferredSize(dim);
        String[] CurrYear = { MainFrame.getInstance().getResourceBundle().getString("studentFirst"), MainFrame.getInstance().getResourceBundle().getString("studentSecond"), MainFrame.getInstance().getResourceBundle().getString("studentThird"), MainFrame.getInstance().getResourceBundle().getString("studentFourth"), MainFrame.getInstance().getResourceBundle().getString("studentMaster"), MainFrame.getInstance().getResourceBundle().getString("studentDoctor"),};
         combo = new JComboBox<String>(CurrYear);
        combo.setName("currYear");
        combo.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("studentYearCurTooltip"));
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
         lStatus = new JLabel(MainFrame.getInstance().getResourceBundle().getString("studentStatus"));
        lStatus.setPreferredSize(dim);
        String[] status = {MainFrame.getInstance().getResourceBundle().getString("studentBudget") , MainFrame.getInstance().getResourceBundle().getString("studentSelf")};
         combo1 = new JComboBox<String>(status);
        combo1.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("studentStatusTooltip"));
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
		
		new Timer(200,new ActionListener() {
			
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
		btnOk.setFocusPainted(false);
        btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(focusListener.getKey()==0b11111111) {
						StudentController.getInstance().addStudent(focusListener.getSurname(), focusListener.getName(), focusListener.getDate(), focusListener.getAdress(), focusListener.getNumber(), focusListener.getEmail(), focusListener.getIndex(), focusListener.getYearOfEntrollment(), currYear, stat);
						dispose();
				}
			}
		});
		
		
		 btnCancel=new JButton(MainFrame.getInstance().getResourceBundle().getString("btnCancel"));
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("studentExitDialog"), MainFrame.getInstance().getResourceBundle().getString("studentExitDialogTitle"), JOptionPane.YES_NO_OPTION);
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
