package gui.subject;

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
import javax.swing.JToggleButton;

import controller.ProfessorController;
import controller.StudentController;
import controller.SubjectController;
import gui.MainFrame;
import model.Semestar;
import model.Status;

public class MyAddingSubjectDialog extends JDialog{

	public int year;
	public Semestar smestar;
	public MyAddingSubjectDialog() {
		super(MainFrame.getInstance(),"Dodavanje predmeta",true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setSize(new Dimension(kit.getScreenSize().width/4,kit.getScreenSize().height/3+50));
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		JPanel panCenter=new JPanel();
		BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		Dimension dim=new Dimension(kit.getScreenSize().width/16,kit.getScreenSize().height/50);
		Dimension fdim=new Dimension(kit.getScreenSize().width/9,kit.getScreenSize().height/50);
		int konst=kit.getScreenSize().width/30;
		FocusListenerForSubject focusListener = new FocusListenerForSubject();
		
		/*Panel for code subject*/
		JPanel pCode=new JPanel(new FlowLayout(FlowLayout.LEFT));	
        JLabel lCode=new JLabel("Šifra*");
        lCode.setPreferredSize(dim);
        JTextField fCode=new JTextField();
        fCode.setToolTipText("Unesite šifru predmeta.");
        fCode.setName("code");
        fCode.setPreferredSize(fdim);
        fCode.addFocusListener(focusListener);
        pCode.add(Box.createHorizontalStrut(konst));
        pCode.add(lCode);
        pCode.add(fCode);
        
        
        /*Panel for name subject*/
        JPanel pName=new JPanel(new FlowLayout(FlowLayout.LEFT));	
        JLabel lName=new JLabel("Naziv*");
        lName.setPreferredSize(dim);
        JTextField fName=new JTextField();
        fName.setToolTipText("Unesite naziv predmeta.");
        fName.setName("name");
        fName.setPreferredSize(fdim);
        fName.addFocusListener(focusListener);
        pName.add(Box.createHorizontalStrut(konst));
        pName.add(lName);
        pName.add(fName);
        
        
        /*Panel for  year*/
        JPanel pYear = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lYear = new JLabel("Godina*");
        lYear.setPreferredSize(dim);
        String[] CurrYear = { "I (Prva)", "II (Druga)", "III (Treca)", "IV (Cetvrata)", "Master studije", "Doktorske studije",};
        JComboBox<String> combo = new JComboBox<String>(CurrYear);
        combo.setName("currYear");
        combo.setToolTipText("Izaberite godinu studija na kojoj se predmet izvodi.");
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
        String[] status = { "Letnji", "Zimski"};
        JComboBox<String> combo1 = new JComboBox<String>(status);
        combo1.setToolTipText("Izaberite semestar u kom se predmet izvodi.");
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
        fESPB.setToolTipText("Unesite broj espb bodova.");
        fESPB.setName("espb");
        fESPB.setPreferredSize(fdim);
        fESPB.addFocusListener(focusListener);
        pESPB.add(Box.createHorizontalStrut(konst));
        pESPB.add(lESPB);
        pESPB.add(fESPB);
        
        
        
        /*Panel for profesor*/
        JPanel pProfesor = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lProfesor = new JLabel("Profesor*");
        lProfesor.setPreferredSize(dim);
        JTextField fProfesor = new JTextField();
        fProfesor.setToolTipText("Unesite predmetnog profesora.");
        fProfesor.setName("profesor");
        //fProfesor.addFocusListener(focusListener);
        JToggleButton button1 = new JToggleButton("+");
        JToggleButton button2 = new JToggleButton("-");
        button1.setPreferredSize(new Dimension(kit.getScreenSize().width/45,kit.getScreenSize().height/50));
        button2.setPreferredSize(new Dimension(kit.getScreenSize().width/45,kit.getScreenSize().height/50));
        
        fProfesor.setPreferredSize(dim);
        pProfesor.add(Box.createHorizontalStrut(konst));
        pProfesor.add(lProfesor);
        pProfesor.add(fProfesor);
        pProfesor.add(button1);
        pProfesor.add(button2);
        
        
        
        
        panCenter.add(Box.createVerticalStrut(25));
        panCenter.add(pCode);
        panCenter.add(pName);
        panCenter.add(pYear);
        panCenter.add(pSemestar);
        panCenter.add(pESPB);
        panCenter.add(pProfesor);
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
				if(focusListener.getKey()==0b0111) {
					SubjectController.getInstance().addSubject(focusListener.getIdSubject(), focusListener.getName(), smestar, year, focusListener.getProfessor(), focusListener.getEspb());
					dispose();
				}else
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke ! ");
				
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