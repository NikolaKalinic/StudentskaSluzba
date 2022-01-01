package gui;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.TableRowSorter;

import controller.ProfessorController;
import controller.StudentController;
import model.Professor;
import model.ProfessorDB;
import gui.professor.MyProfessorPanel;
import gui.professor.MyProfessorTable;
import gui.professor.ProfessorDialog;
import gui.professor.ProfessorEditDialog;
import gui.student.AbstractTableModelStudent;
import gui.student.MyAddingStudentDialog;
import gui.student.MyEditingStudentDialog;
import gui.student.MyStudentPanel;
import gui.student.MyStudentRowFilter;
import gui.student.MyStudentTable;
import gui.subject.MyAddingSubjectDialog;
import gui.subject.MyEditingSubjectDialog;
import gui.subject.MySubjectPanel;
import gui.subject.MySubjectTable;
import model.Student;
import model.StudentDB;
import model.SubjectDB;

public class MyToolBar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		JButton create = new JButton();
		create.setToolTipText("Create entity");
		Image createImg = kit.getImage("images/create4.png");
		//Image resizedCreateImg = createImg.getScaledInstance(25, 24, java.awt.Image.SCALE_SMOOTH);
		create.setIcon(new ImageIcon(createImg));
		create.setBorderPainted(false);
		create.setFocusPainted(false);
		create.setBackground(Color.white);
		//create.getInputMap().put(KeyStroke.getKeyStroke("pressed");
        create.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(MyTabbedPane.getInstance().getSelectedIndex()==0) {
					MyAddingStudentDialog masd = new MyAddingStudentDialog();
				}else if(MyTabbedPane.getInstance().getSelectedIndex() == 1) {
					ProfessorDialog pd = new ProfessorDialog();
				}else if(MyTabbedPane.getInstance().getSelectedIndex() == 2) {
					MyAddingSubjectDialog pd = new MyAddingSubjectDialog();
				}
			}
			
		});
        
		
		add(create);
		
		addSeparator();
		
		JButton edit = new JButton();
		edit.setToolTipText("Edit entity");
		Image editImg = kit.getImage("images/edit4.png");
		//Image resizedEditImg = editImg.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
		edit.setIcon(new ImageIcon(editImg));
		edit.setBorderPainted(false);
		edit.setFocusPainted(false);
		edit.setBackground(Color.white);
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MyTabbedPane.getInstance().getSelectedIndex()==0)
					if((MyStudentPanel.getInstance().getStudentTable().getSelectedRow()< (StudentDB.getInstance().getStudents().size()) && MyStudentPanel.getInstance().getStudentTable().getSelectedRow() >= 0)) {
						MyEditingStudentDialog mesd = new MyEditingStudentDialog();
					}
				if(MyTabbedPane.getInstance().getSelectedIndex()==2) {
					if(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow()< SubjectDB.getInstance().getSubjects().size() && MySubjectPanel.getInstance().getSubjectTable().getSelectedRow()>=0) {
						MyEditingSubjectDialog ms = new MyEditingSubjectDialog();
					}
				}
				if(MyTabbedPane.getInstance().getSelectedIndex() == 1) {
					if((MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow() < (ProfessorDB.getInstance().getProfessors().size()) && MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow()>= 0)){
						ProfessorEditDialog ped = new ProfessorEditDialog();
					}
				}
			}
		});
		
		add(edit);
		
		addSeparator();
		
		JButton delete = new JButton();
		delete.setToolTipText("Delete entity");
		Image deleteImg = kit.getImage("images/delete4.png");
		//Image resizedDeleteImg = deleteImg.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
		delete.setIcon(new ImageIcon(deleteImg));
		delete.setBorderPainted(false);
		delete.setFocusPainted(false);
		delete.setBackground(Color.white);
		
		/*Listener for delete*/
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 if(MyTabbedPane.getInstance().getSelectedIndex() == 1) {
					if(MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow() < (ProfessorDB.getInstance().getProfessors().size()) && MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow() > -1) {
						int a = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da zelite da obrisete profesora ?", "Brisanje profesora", JOptionPane.YES_NO_OPTION);
						if (a == JOptionPane.YES_OPTION) {
							ProfessorController.getInstance().removeProfessor(MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow());
						}
					}
				 }
				 if(MyTabbedPane.getInstance().getSelectedIndex()==0)
						if((MyStudentPanel.getInstance().getStudentTable().getSelectedRow()< (StudentDB.getInstance().getStudents().size()) && MyStudentPanel.getInstance().getStudentTable().getSelectedRow() >= 0)) {
							int answer=JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
									"Da li ste sigurni da zelite da obrisete studenta", "Brisanje studenta", 
							        JOptionPane.YES_NO_OPTION);
							if(answer==JOptionPane.YES_OPTION) {
								StudentController.getInstance().deleteStudent((MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())));
							}
						}
			}
		});
			
		add(delete);

		add(Box.createHorizontalGlue());
		
		
		addSeparator();
		
		JTextField searchField = new JTextField(10);
		searchField.setMaximumSize(searchField.getPreferredSize());
		searchField.setToolTipText("Type here");
		
		add(searchField);
	
		JButton loupe = new JButton();
		loupe.setToolTipText("Search");
		loupe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MyTabbedPane.getInstance().getSelectedIndex()==0) {
//					TableRowSorter trs = new TableRowSorter(new AbstractTableModelStudent());
					MyStudentTable.trs.setRowFilter(new MyStudentRowFilter(searchField.getText()));
				}
				
//				 if(MyTabbedPane.getInstance().getSelectedIndex()==0) {
//					 String[] split = searchField.getText().split(",");
//					 if(split.length==1 && split[0].length()!=0)
//						 MyStudentPanel.getInstance().search(split[0].substring(0, 1).toUpperCase()+split[0].substring(1).toLowerCase());
//					 else {
//						 MyStudentPanel.getInstance().search("");
//					 }if(split.length==2) {
//						 
//					 }else {
//						 
//					 }if(split.length==3 && split[0].length()!=0) {
//						 MyStudentPanel.getInstance().search(split[0].toUpperCase());
//					 }else {
//						 MyStudentPanel.getInstance().search("");
//					 }
//				 }
				
			}
		});
		Image searchImg = kit.getImage("images/loupe.png");
		Image resizedSearchImg = searchImg.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
		loupe.setIcon(new ImageIcon(resizedSearchImg));
		loupe.setBorderPainted(false);
		loupe.setFocusPainted(false);
		loupe.setBackground(Color.white);
		
		add(loupe);

		setFloatable(false);
		setBackground(new Color(255, 255, 255));
	}

}
