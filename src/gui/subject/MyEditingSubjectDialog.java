package gui.subject;

import java.awt.BorderLayout;
import java.awt.Color;
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

import controller.SubjectController;
import gui.MainFrame;
import gui.professor.MyAddSubjectDialog;
import model.Professor;
import model.Semestar;
import model.Subject;
import model.SubjectDB;

public class MyEditingSubjectDialog extends JDialog{

	
	public int year=1;
	public Semestar smestar=Semestar.Summer;
	private static JButton button1;
	private static JButton button2;
	private static JButton btnOk;
	private static JTextField fProfesor;
	private static Professor primaryProfessor;
	private static boolean okEnabled;
	
	public MyEditingSubjectDialog() {
		super(MainFrame.getInstance(),MainFrame.getInstance().getResourceBundle().getString("editSubject"),true);
		Subject s=SubjectController.getInstance().getSelectedSubject(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow());
		smestar=s.getSemestar();
		okEnabled = false;
		Toolkit kit = Toolkit.getDefaultToolkit();
		setSize(new Dimension(kit.getScreenSize().width/4,kit.getScreenSize().height/3+50));
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		JPanel panCenter=new JPanel();
		btnOk=new JButton(MainFrame.getInstance().getResourceBundle().getString("btnConfirm"));
		btnOk.setFocusable(false);
		BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		Dimension dim=new Dimension(kit.getScreenSize().width/16,kit.getScreenSize().height/50);
		Dimension fdim=new Dimension(kit.getScreenSize().width/9,kit.getScreenSize().height/50);
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
        String[] CurrYear = { MainFrame.getInstance().getResourceBundle().getString("studentFirst"), MainFrame.getInstance().getResourceBundle().getString("studentSecond"), MainFrame.getInstance().getResourceBundle().getString("studentThird"), MainFrame.getInstance().getResourceBundle().getString("studentFourth"), MainFrame.getInstance().getResourceBundle().getString("studentMaster"), MainFrame.getInstance().getResourceBundle().getString("studentDoctor"),};
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
        JLabel lProfesor = new JLabel("Professor*");
        lProfesor.setPreferredSize(dim);
        fProfesor = new JTextField();
        if(s.getProfesor() == null) {
        	fProfesor.setText("");
        	primaryProfessor = null;
        } else {
        	fProfesor.setText(s.getProfesor().getProfNameAndSurname());
        	primaryProfessor = s.getProfesor();
        }
        fProfesor.setFocusable(false);
        fProfesor.setName("profesor");
        fProfesor.addFocusListener(focusListener);
        //fProfesor.setText(s.getProfesor().getProfNameAndSurname());
        //focusListener.setProfessor(s.getProfesor());
        
        button1 = new JButton("+");
        button2 = new JButton("-");
        //change font size of JButton;
        button1.setFont(new Font("Arial", Font.BOLD, 8));
        button2.setFont(new Font("Arial", Font.BOLD, 8));
        button1.setFocusable(true);
        button2.setFocusable(true);
        button1.setFocusPainted(false);
        button2.setFocusPainted(false);
        button1.setBackground(Color.white);
        button2.setBackground(Color.white);
        
        button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddingProfessorToSubject apts = new AddingProfessorToSubject();
				
			}
		});
        
        button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SubjectController.getInstance().removeProfessor();
				fProfesor.setText("");
			}
        	
        });
        
        fProfesor.setPreferredSize(dim);
        pProfesor.add(Box.createHorizontalStrut(konst));
        pProfesor.add(lProfesor);
        pProfesor.add(fProfesor);
        pProfesor.add(Box.createHorizontalStrut(10));
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
		
		
		btnOk.setPreferredSize(new Dimension(90,30));
		
		if(s.getIdSubject()==focusListener.getIdSubject())
			focusListener.setKey(focusListener.getKey() | 0b0001);
		if(s.getName()==focusListener.getName()) {
			focusListener.setKey(focusListener.getKey() | 0b0010);
		}
		if(s.getEspb()==focusListener.getEspb()) {
			focusListener.setKey(focusListener.getKey() | 0b0100);
		}
		if(fProfesor.getText().equals(focusListener.getProfessor())) {
			focusListener.setKey(focusListener.getKey() | 0b1000);
		}
		
		
		new Timer(200,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				checkProfessor();
				if(focusListener.getKey()==0b0111 && okEnabled) {
					btnOk.setEnabled(true);
				}else { 
					btnOk.setEnabled(false);
				}
			}
			
		}).start();
        btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(focusListener.getKey()==0b0111) {
					SubjectController.getInstance().editStudent(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow(), focusListener.getIdSubject(), focusListener.getName(),smestar , combo.getSelectedIndex()+1, SubjectController.getInstance().getSelectedSubject(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow()).getProfesor(), focusListener.getEspb());
					dispose();
				}
				
			}
		});
		
		
		JButton btnCancel=new JButton(MainFrame.getInstance().getResourceBundle().getString("btnCancel"));
		btnCancel.setPreferredSize(new Dimension(90,30));
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("studentExitDialog"), MainFrame.getInstance().getResourceBundle().getString("studentExitDialogTitle"), JOptionPane.YES_NO_OPTION);
				if (a == JOptionPane.YES_OPTION) {
					Subject s=SubjectController.getInstance().getSelectedSubject(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow());
					s.setProfesor(primaryProfessor);
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
	
	public static void updateProfessor() {
		Subject s=SubjectController.getInstance().getSelectedSubject(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow());
		fProfesor.setText(s.getProfesor().getProfNameAndSurname());
	}
	
	public static void checkProfessor() {
		if(fProfesor.getText().isBlank()) {
			button1.setEnabled(true);
			button2.setEnabled(false);
			okEnabled = false;
		} else {
			if(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow() != -1 && SubjectController.getInstance().getSelectedSubject(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow()).getProfesor() != null ) {
				fProfesor.setText(SubjectController.getInstance().getSelectedSubject(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow()).getProfesor().getProfNameAndSurname());
			}
			okEnabled = true;
			button1.setEnabled(false);
			button2.setEnabled(true);
		}
	}
}
