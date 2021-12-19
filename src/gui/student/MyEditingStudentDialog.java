package gui.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

import gui.MainFrame;


public class MyEditingStudentDialog extends JDialog{

	
	public MyEditingStudentDialog(){
		super(MainFrame.getInstance(),"Izmena studenta",true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setSize(new Dimension(kit.getScreenSize().width/3,kit.getScreenSize().height/2+40));
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel paneltop = new JPanel();
		paneltop.setPreferredSize(new Dimension(1,30));	
		panel.add(paneltop,BorderLayout.NORTH);
		MyEditingStudentTabbedPane mestp = new MyEditingStudentTabbedPane();
		panel.add(mestp);
		
		
		JPanel panelBot = new JPanel();
		panelBot.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		panelBot.setPreferredSize(new Dimension(1,10));	
		panel.add(panelBot,BorderLayout.SOUTH);
		
		add(panel);
		setVisible(true);
    	pack();
	}
	
}
