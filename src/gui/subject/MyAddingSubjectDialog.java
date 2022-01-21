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
import javax.swing.Timer;


import controller.SubjectController;
import gui.MainFrame;
import model.Semestar;

public class MyAddingSubjectDialog extends JDialog{

	public int year;
	public Semestar smestar=Semestar.Summer;
	public MyAddingSubjectDialog() {
		super(MainFrame.getInstance(),MainFrame.getInstance().getResourceBundle().getString("addSubject"),true);
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
		FocusListenerForSubject focusListener = new FocusListenerForSubject(1);
		
		/*Panel for code subject*/
		JPanel pCode=new JPanel(new FlowLayout(FlowLayout.LEFT));	
        JLabel lCode=new JLabel(MainFrame.getInstance().getResourceBundle().getString("subjectId"));
        lCode.setPreferredSize(dim);
        JTextField fCode=new JTextField();
        fCode.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("subjectIdTooltip"));
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
        fName.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("studentNameTooltip"));
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
        String[] CurrYear = {MainFrame.getInstance().getResourceBundle().getString("studentFirst"), MainFrame.getInstance().getResourceBundle().getString("studentSecond"), MainFrame.getInstance().getResourceBundle().getString("studentThird"), MainFrame.getInstance().getResourceBundle().getString("studentFourth"), MainFrame.getInstance().getResourceBundle().getString("studentMaster"), MainFrame.getInstance().getResourceBundle().getString("studentDoctor"),};
        JComboBox<String> combo = new JComboBox<String>(CurrYear);
        combo.setName("currYear");
        combo.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("subjectYearTooltip"));
        combo.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				year=combo.getSelectedIndex();		
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
        combo1.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("subjectSemestarTooltip"));
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
        fESPB.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("subjectEspbTooltip"));
        fESPB.setName("espb");
        fESPB.setPreferredSize(fdim);
        fESPB.addFocusListener(focusListener);
        pESPB.add(Box.createHorizontalStrut(konst));
        pESPB.add(lESPB);
        pESPB.add(fESPB);
        focusListener.lostFocus(pESPB, btnOk);
        
        
        panCenter.add(Box.createVerticalStrut(25));
        panCenter.add(pYear);
        panCenter.add(pCode);
        panCenter.add(pName);
        panCenter.add(pSemestar);

        panCenter.add(pESPB);
        panCenter.add(Box.createVerticalStrut(25));  
        add(panCenter,BorderLayout.CENTER);
		
        
        
        JPanel panBottom=new JPanel();
		BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);
		
		
		btnOk.setEnabled(false);
		
		new Timer(200,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(focusListener.getKey()==0b0111) {
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
					SubjectController.getInstance().addSubject(focusListener.getIdSubject(), focusListener.getName(), smestar, combo.getSelectedIndex()+1, focusListener.getProfessor(), focusListener.getEspb());
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
