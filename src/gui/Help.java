package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class Help extends JDialog{
	public Help() {
		super(MainFrame.getInstance(),MainFrame.getInstance().getResourceBundle().getString("mHelp"),true);
		setSize(750, 800);
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		JLabel lab1= new JLabel(MainFrame.getInstance().getResourceBundle().getString("help"));
		north.setLayout(new BorderLayout());
		north.add(lab1, BorderLayout.WEST);
		north.setBackground(Color.LIGHT_GRAY);
		north.setPreferredSize(new Dimension(1,15));
	
		add(north,BorderLayout.NORTH);
		
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(0, 1, 0, 0));
		this.add(center, BorderLayout.CENTER);
		
		JSeparator s = new JSeparator();
		Font f = new Font(Font.SANS_SERIF,  Font.BOLD, 15);
		JLabel newEntityText = new JLabel(MainFrame.getInstance().getResourceBundle().getString("newEntityText"));
		JLabel editEntityText = new JLabel(MainFrame.getInstance().getResourceBundle().getString("editEntityText"));
		JLabel deleteEntityText = new JLabel(MainFrame.getInstance().getResourceBundle().getString("deleteEntityText"));
		JLabel addSubjectToStudent = new JLabel(MainFrame.getInstance().getResourceBundle().getString("addSubjectToStudentText"));
		JLabel addGradeToSubject = new JLabel(MainFrame.getInstance().getResourceBundle().getString("addGradeToSubjectText"));
		JLabel deleteSubjectFromStudent = new JLabel(MainFrame.getInstance().getResourceBundle().getString("removeSubjectFromStudentText"));
		JLabel cancelGradeOnSubject = new JLabel(MainFrame.getInstance().getResourceBundle().getString("cancelGradeText"));
		JLabel addSubjectToProfessor = new JLabel(MainFrame.getInstance().getResourceBundle().getString("addSubjectToProfessorText"));
		JLabel removeSubjectFromProfessor = new JLabel(MainFrame.getInstance().getResourceBundle().getString("removeSubjectFromProfessorText"));
		JLabel addAndRemoveProfessorFromSubject = new JLabel(MainFrame.getInstance().getResourceBundle().getString("addAndRemoveProfessorFromSubjectText"));
	
		
		center.add(newEntityText);
		center.add(editEntityText);
		center.add(deleteEntityText);
		center.add(addSubjectToStudent);
		center.add(addGradeToSubject);
		center.add(deleteSubjectFromStudent);
		center.add(cancelGradeOnSubject);
		center.add(addSubjectToProfessor);
		center.add(removeSubjectFromProfessor);
		center.add(addAndRemoveProfessorFromSubject);
		JScrollPane jsp = new JScrollPane(center);
		add(jsp, BorderLayout.CENTER);
		
		JPanel south= new JPanel();
		south.setLayout(new BorderLayout());
		south.setBackground(Color.LIGHT_GRAY);
		south.setPreferredSize(new Dimension(1,15));
		add(south,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
}
