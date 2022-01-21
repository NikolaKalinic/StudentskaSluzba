package gui.professor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controller.ProfessorController;
import gui.MainFrame;
import model.Professor;
import model.ProfessorDB;
import model.Subject;
import model.SubjectDB;

public class MyAddSubjectDialog extends JDialog {
	
	public MyAddSubjectDialog() {
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("addSubjectToProf1"),true);
		setResizable(false);
		setSize(500,400);
		setLocationRelativeTo(ProfessorSubjects.getInstance());
		setLayout(new BorderLayout());
		/*panel for top*/
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.white);
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		northPanel.add(new JLabel(MainFrame.getInstance().getResourceBundle().getString("profSubjectss")));
		northPanel.setPreferredSize(new Dimension(1,50));
		add(northPanel,BorderLayout.NORTH);
		
		/*panels for sides*/
		JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.white);
		westPanel.setPreferredSize(new Dimension(20,1));
		add(westPanel,BorderLayout.WEST);
		JPanel eastPanel = new JPanel();
		eastPanel.setBackground(Color.white);
		eastPanel.setPreferredSize(new Dimension(20,1));
		add(eastPanel,BorderLayout.EAST);
		
		
		/*panel for bot*/
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		JButton btnOk = new JButton(MainFrame.getInstance().getResourceBundle().getString("btnConfirm"));
		btnOk.setFocusPainted(false);
		
		JButton btnCancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("btnCancel"));
		btnCancel.setFocusPainted(false);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		southPanel.add(btnOk);
		southPanel.add(Box.createHorizontalStrut(50));
		southPanel.add(btnCancel);
		southPanel.setBackground(Color.white);
		southPanel.setPreferredSize(new Dimension(1,50));
		add(southPanel,BorderLayout.SOUTH);
		
		
		/*panel for center*/
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		Vector<Subject> subjects = new Vector<Subject>();
		Professor p=ProfessorDB.getInstance().getRow(MyProfessorPanel.getInstance().getProfessorTable().convertRowIndexToModel(MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow()));
		boolean flag;
		for (int i =0 ; i<SubjectDB.getInstance().getSubjects().size();i++) {
			flag=false;
			for(int j =0; j <p.getCourseList().size();j++) {
				if(SubjectDB.getInstance().getSubjects().get(i).getIdSubject().equals(p.getCourseList().get(j).getIdSubject()))
					flag=true;
			}
			/*only one profesor on subject*/
			if(SubjectDB.getInstance().getSubjects().get(i).getProfesor()!=null)
				flag=true;
			if(flag==false)
				subjects.add(SubjectDB.getInstance().getSubjects().get(i));
		}
		
		
		JList<Subject> listBox = new JList<Subject>(subjects);
		listBox.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(listBox);
		centerPanel.add(scrollPane,BorderLayout.CENTER);
		listBox.setSelectedIndex(0);
		add(centerPanel,BorderLayout.CENTER);
		
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listBox.getSelectedIndex()>-1) {
					List<Subject> selectedSubjects = listBox.getSelectedValuesList();
					//Subject s = listBox.getSelectedValue();
					ProfessorController.getInstance().addSubject(selectedSubjects);
					dispose();
				}
				
			}
		});
		
		setVisible(true);
	}
}
