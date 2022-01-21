package gui.subject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

import controller.ProfessorController;
import controller.SubjectController;
import gui.MainFrame;
import model.Semestar;
import model.Subject;

public class MyEditingSubjectDialog extends JDialog{

	
	public int year=1;
	public Semestar smestar=Semestar.Summer;
	public MyEditingSubjectDialog() {
		super(MainFrame.getInstance(),MainFrame.getInstance().getResourceBundle().getString("editSubject"),true);
		Subject s=SubjectController.getInstance().getSelectedSubject(MySubjectPanel.getInstance().getSubjectTable().convertRowIndexToModel(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow()));
		smestar=s.getSemestar();
		Toolkit kit = Toolkit.getDefaultToolkit();
		setSize(new Dimension(kit.getScreenSize().width/4,kit.getScreenSize().height/3+50));
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		JPanel panCenter=new JPanel();
		JButton btnOk=new JButton(MainFrame.getInstance().getResourceBundle().getString("btnConfirm"));
		BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		Dimension dim=new Dimension(kit.getScreenSize().width/16,kit.getScreenSize().height/45);
		Dimension fdim=new Dimension(kit.getScreenSize().width/9,kit.getScreenSize().height/45);
		int konst=kit.getScreenSize().width/30;
		FocusListenerForSubject focusListener = new FocusListenerForSubject(2);
		
		/*Panel for code subject*/
		JPanel pCode=new JPanel(new FlowLayout(FlowLayout.LEFT));	
        JLabel lCode=new JLabel(MainFrame.getInstance().getResourceBundle().getString("subjectId"));
        lCode.setPreferredSize(dim);
        JTextField fCode=new JTextField();
        fCode.setText(s.getIdSubject());
        focusListener.setIdSubject(s.getIdSubject());
        
        fCode.setName("code");
        fCode.setPreferredSize(fdim);
        fCode.addFocusListener(focusListener);
        pCode.add(Box.createHorizontalStrut(konst));
        pCode.add(lCode);
        pCode.add(fCode);
        focusListener.lostFocus(pCode, btnOk);
        
        /*Panel for name subject*/
        JPanel pName=new JPanel(new FlowLayout(FlowLayout.LEFT));	
        JLabel lName=new JLabel(MainFrame.getInstance().getResourceBundle().getString("studentName"));
        lName.setPreferredSize(dim);
        JTextField fName=new JTextField();
        fName.setText(s.getName());
        focusListener.setName(s.getName());
        fName.setName("name");
        fName.setPreferredSize(fdim);
        fName.addFocusListener(focusListener);
        pName.add(Box.createHorizontalStrut(konst));
        pName.add(lName);
        pName.add(fName);
        focusListener.lostFocus(pName, btnOk);
        
        /*Panel for  year*/
        JPanel pYear = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lYear = new JLabel(MainFrame.getInstance().getResourceBundle().getString("subjectYear"));
        lYear.setPreferredSize(dim);
        String[] CurrYear = { MainFrame.getInstance().getResourceBundle().getString("studentFirst"), MainFrame.getInstance().getResourceBundle().getString("studentSecond"), MainFrame.getInstance().getResourceBundle().getString("studentThird"), MainFrame.getInstance().getResourceBundle().getString("studentFourth"), MainFrame.getInstance().getResourceBundle().getString("studentMaster"), MainFrame.getInstance().getResourceBundle().getString("studentDoctor")};
        JComboBox<String> combo = new JComboBox<String>(CurrYear);
        combo.setName("currYear");
        combo.setSelectedIndex(s.getYearOfStudySub()-1);
        combo.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				year=combo.getSelectedIndex();		//KRECE OD NULE TRBEACE TI NEGDE
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		combo.setPreferredSize(fdim);
		pYear.add(Box.createHorizontalStrut(konst));
		pYear.add(lYear);
		pYear.add(combo);
		
		
		 /*Panel for status student*/
        JPanel pSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lSemestar = new JLabel("Semestar*");
        lSemestar.setPreferredSize(dim);
        String[] status = { MainFrame.getInstance().getResourceBundle().getString("summer"), MainFrame.getInstance().getResourceBundle().getString("winter")};
        JComboBox<String> combo1 = new JComboBox<String>(status);
        combo1.setSelectedIndex(s.getSemestar()==Semestar.Summer?0:1);
        combo1.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(combo1.getSelectedIndex()==0)
					smestar=Semestar.Summer;
				else
					smestar=Semestar.Winter;
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        combo1.setPreferredSize(fdim);
        pSemestar.add(Box.createHorizontalStrut(konst));
        pSemestar.add(lSemestar);
        pSemestar.add(combo1);
		
        
        /*Panel for ESPB*/
        JPanel pESPB = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lESPB = new JLabel("ESPB*");
        lESPB.setPreferredSize(dim);
        JTextField fESPB = new JTextField();
        fESPB.setText(Integer.toString(s.getEspb()));
        focusListener.setEspb(s.getEspb());
        fESPB.setName("espb");
        fESPB.setPreferredSize(fdim);
        fESPB.addFocusListener(focusListener);
        pESPB.add(Box.createHorizontalStrut(konst));
        pESPB.add(lESPB);
        pESPB.add(fESPB);
        focusListener.lostFocus(pESPB, btnOk);
        
        
        /*Panel for profesor*/
        JPanel pProfesor = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lProfesor = new JLabel(MainFrame.getInstance().getResourceBundle().getString("professor"));
        lProfesor.setPreferredSize(dim);
        JTextField fProfesor = new JTextField();
        fProfesor.setFocusable(false);
        fProfesor.setName("profesor");
    	if(s.getIdSubject()==focusListener.getIdSubject())
			focusListener.setKey(focusListener.getKey() | 0b0001);
		if(s.getName()==focusListener.getName()) {
			focusListener.setKey(focusListener.getKey() | 0b0010);
		}
		if(s.getEspb()==focusListener.getEspb()) {
			focusListener.setKey(focusListener.getKey() | 0b0100);
		}
        
        JButton button1 = new JButton("+");
        JButton button2 = new JButton("-");
        try {
			fProfesor.setText(s.getProfesor().getProfNameAndSurname());
			button1.setEnabled(false);
			button2.setEnabled(true);
			focusListener.setKey(focusListener.getKey() | 0b1000);
			System.out.println(Integer. toBinaryString(focusListener.getKey()));
		}catch(Exception e1) {
			button1.setEnabled(true);
			button2.setEnabled(false);
			focusListener.setKey(focusListener.getKey() & 0b0111);
			System.out.println(Integer. toBinaryString(focusListener.getKey()));
		}
        //change font size of JButton;
        button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddingProfessorToSubject asf= new AddingProfessorToSubject();
				try {
					fProfesor.setText(s.getProfesor().getProfNameAndSurname());
					button1.setEnabled(false);
					button2.setEnabled(true);
					ProfessorController.getInstance().addSubject(s.getKey(), s.getProfesor().getKey());
					focusListener.setKey(focusListener.getKey() | 0b1000);
				}catch(Exception e2) {
					button2.setEnabled(false);
					button1.setEnabled(true);
					fProfesor.setText("");
					focusListener.setKey(focusListener.getKey() & 0b0111);
				}
			}
		});
        button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SubjectController.getInstance().removeProfessor();
				button2.setEnabled(false);
				button1.setEnabled(true);
				fProfesor.setText("");
				focusListener.setKey(focusListener.getKey() & 0b0111);
				
			}
		});
        button1.setFont(new Font("Arial", Font.BOLD, 8));
        button2.setFont(new Font("Arial", Font.BOLD, 8));
        button1.setFocusPainted(false);
        button2.setFocusPainted(false);
        
        fProfesor.setPreferredSize(dim);
        pProfesor.add(Box.createHorizontalStrut(konst));
        pProfesor.add(lProfesor);
        pProfesor.add(fProfesor);
        pProfesor.add(button1);
        pProfesor.add(button2);
        focusListener.lostFocus(pProfesor, btnOk);
        
        
        
        panCenter.add(Box.createVerticalStrut(25));
        panCenter.add(pYear);
        panCenter.add(pCode);
        panCenter.add(pName);
        panCenter.add(pSemestar);
        panCenter.add(pESPB);
        panCenter.add(pProfesor);
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
				if(focusListener.getKey()==0b1111) {
					btnOk.setEnabled(true);
				}else { 
					btnOk.setEnabled(false);
				}
			}
			
		}).start();
        btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(focusListener.getKey()==0b1111) {
					SubjectController.getInstance().editSubject(MySubjectPanel.getInstance().getSubjectTable().convertRowIndexToModel(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow()), focusListener.getIdSubject(), focusListener.getName(),smestar , combo.getSelectedIndex()+1, s.getProfesor(), focusListener.getEspb());
					dispose();
				}
			}
		});
		
		
		JButton btnCancel=new JButton(MainFrame.getInstance().getResourceBundle().getString("btnCancel"));
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
