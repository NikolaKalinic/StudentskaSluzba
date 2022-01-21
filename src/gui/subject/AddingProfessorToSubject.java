package gui.subject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controller.SubjectController;
import gui.MainFrame;
import model.Professor;
import model.ProfessorDB;
import model.Subject;
import model.SubjectDB;

public class AddingProfessorToSubject extends JDialog {
	
	public AddingProfessorToSubject() {
		super(MainFrame.getInstance(),"    " + MainFrame.getInstance().getResourceBundle().getString("addProfessorToSubject"),true);
		setResizable(false);
		setSize(300,400);
		setLocationRelativeTo(MainFrame.getInstance());
		setLayout(new BorderLayout());
		
		/*panels for sides*/
		JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.white);
		westPanel.setPreferredSize(new Dimension(20,1));
		add(westPanel,BorderLayout.WEST);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setBackground(Color.white);
		eastPanel.setPreferredSize(new Dimension(20,1));
		add(eastPanel,BorderLayout.EAST);
		
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
		
		
		Vector<Professor> professors = new Vector<Professor>();
		
		Subject subject = SubjectDB.getInstance().getRow(MySubjectPanel.getInstance().getSubjectTable().convertRowIndexToModel(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow()));
		
		for(Professor p : ProfessorDB.getInstance().getProfessors()) {
			professors.add(p);
		}
			
		
		Vector<String> professorsNames = new Vector<String>();
	
		for(Professor p : professors) {
			professorsNames.add(p.getProfNameAndSurname());
		}
		
		JList<String> listBox = new JList<String>(professorsNames);
		listBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(listBox);
		centerPanel.add(scrollPane,BorderLayout.CENTER);
		listBox.setSelectedIndex(0);
		add(centerPanel,BorderLayout.CENTER);
		
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listBox.getSelectedIndex() > -1) {
					Professor selectedProf = ProfessorDB.getInstance().getProfessors().get(listBox.getSelectedIndex());
					SubjectController.getInstance().addProfessor(selectedProf);
					dispose();
				}
				
			}
		});
		
		setVisible(true);
	}
}
