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

import controller.ProfessorController;
import controller.StudentController;
import model.Professor;
import model.ProfessorDB;
import gui.student.MyAddingStudentDialog;
import gui.student.MyEditingStudentDialog;
import gui.student.MyStudentTable;
import model.Student;
import model.StudentDB;

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
				}
					
				
			}
		});
        
        create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(MyTabbedPane.getInstance().getSelectedIndex() == 1) {
					ProfessorDialog pd = new ProfessorDialog();
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
					if((MyStudentTable.selectedRow < (StudentDB.getInstance().getStudents().size()) && MyStudentTable.selectedRow >= 0)) {
						Student student = StudentController.getInstance().getSelectedStudent(MyStudentTable.selectedRow);
						//TODO POZVATI DIALOG STO CES SADA NAPRAVITI I PROSLEDITI MU STUDENTA
						MyEditingStudentDialog mesd = new MyEditingStudentDialog();
					}
				else {
					//TODO ZA PROFU I PREDMET
				}
			}
		});
		
		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(MyTabbedPane.getInstance().getSelectedIndex() == 1) {
					if((MyProfessorTable.rowIndex < (ProfessorDB.getInstance().getProfessors().size()) && MyProfessorTable.rowIndex >= 0)){
						Professor professor = ProfessorController.getInstance().getSelectedProfessor(MyProfessorTable.rowIndex);
						ProfessorEditDialog ped = new ProfessorEditDialog(professor);
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
				// TODO Auto-generated method stub
				 if(MyTabbedPane.getInstance().getSelectedIndex() == 1) {
					if(MyProfessorTable.rowIndex < (ProfessorDB.getInstance().getProfessors().size()) && MyProfessorTable.rowIndex > -1) {
						int a = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da zelite da obrisete profesora ?", "Brisanje profesora", JOptionPane.YES_NO_OPTION);
						if (a == JOptionPane.YES_OPTION) {
							ProfessorController.getInstance().removeProfessor(MyProfessorTable.rowIndex);
							MyProfessorTable.rowIndex = -1;
						}
					}
				 }	
			}
		});
		
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MyTabbedPane.getInstance().getSelectedIndex()==0)
					if((MyStudentTable.selectedRow < (StudentDB.getInstance().getStudents().size()) && MyStudentTable.selectedRow >= 0)) {
						int answer=JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
								"Da li ste sigurni da zelite da obrisete studenta", "Brisanje studenta", 
						        JOptionPane.YES_NO_OPTION);
						if(answer==JOptionPane.YES_OPTION) {
							StudentController.getInstance().deleteStudent(MyStudentTable.selectedRow);
							MyStudentTable.selectedRow=-1;
						}
					}
				//else if(MyTabbedPane.getInstance().getSelectedIndex() == 1) {
				//	if(MyProfessorTable.rowIndex < (ProfessorDB.getInstance().getProfessors().size()) && MyProfessorTable.rowIndex > -1) {
				//		int a = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da zelite da obrisete profesora ?", "Brisanje profesora", JOptionPane.YES_NO_OPTION);
				//		if (a == JOptionPane.YES_OPTION) {
				//			ProfessorController.getInstance().removeProfessor(MyProfessorTable.rowIndex);
				//			MyProfessorTable.rowIndex = -1;
				//		}
				//	}
					
					
				//}
					
				//else
					//TODO for subject
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
