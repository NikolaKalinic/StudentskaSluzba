package gui.professor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ProfessorController;
import controller.StudentController;
import gui.MainFrame;
import gui.student.MyStudentPanel;
import model.StudentDB;




public class ProfessorSubjects extends JPanel {

private static ProfessorSubjects instance = null;
	
	public static ProfessorSubjects getInstance() {
		if (instance == null) {
			instance = new ProfessorSubjects();
		}
		return instance;
	}
	private JTable subjectsTable;
	private ProfessorSubjects() {
		setLayout(new BorderLayout());
		JPanel panTop = new JPanel();
		panTop.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		panTop.setBackground(Color.white);
		JButton button1 = new JButton(MainFrame.getInstance().getResourceBundle().getString("addSubjectToProf"));
		JButton button2 = new JButton(MainFrame.getInstance().getResourceBundle().getString("removeSubjectFromProf"));
		button1.setBackground(new Color(14,98,190));
		button1.setForeground(Color.white);
		button2.setBackground(new Color(14,98,190));
		button2.setForeground(Color.white);
		panTop.add(button1);
		panTop.add(button2);
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyAddSubjectDialog masd = new MyAddSubjectDialog();
				
			}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ProfessorSubjects.getInstance().getSubjectsTable().getSelectedRow() >= 0) {
					int answer=JOptionPane.showConfirmDialog(ProfessorSubjects.getInstance(), 
							MainFrame.getInstance().getResourceBundle().getString("deleteSubject"), MainFrame.getInstance().getResourceBundle().getString("deleteSubject1"), 
					        JOptionPane.YES_NO_OPTION);
					if(answer==JOptionPane.YES_OPTION) {
						ProfessorController.getInstance().removeSubject();
					}
				
				}
			}
		});
		
		add(panTop,BorderLayout.NORTH);
		
		JPanel cLeft = new JPanel();
		cLeft.setBackground(Color.white);
		cLeft.setPreferredSize(new Dimension(20,1));
		JPanel cRight = new JPanel();
		cRight.setBackground(Color.white);
		cRight.setPreferredSize(new Dimension(20,1));
		add(cLeft,BorderLayout.EAST);
		add(cRight,BorderLayout.WEST);
		
		
		JPanel panBottom = new JPanel();
		panBottom.setBackground(Color.white);
		panBottom.setPreferredSize(new Dimension(1,100));
		add(panBottom,BorderLayout.SOUTH);
		subjectsTableView();
	}
	public JTable getSubjectsTable() {
		return subjectsTable;
	}
	public void updateView() {
		AbstractTableModelProfessorSubjects model = (AbstractTableModelProfessorSubjects) subjectsTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
	private void subjectsTableView() {
		subjectsTable = MyProfessorSubjectsTabel.getInstance();
		JScrollPane scrollPane = new JScrollPane(subjectsTable);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	
}
