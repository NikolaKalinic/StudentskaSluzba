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
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.ChairController;
import controller.ProfessorController;
import controller.StudentController;
import gui.chair.MyChairPanel;
import gui.chair.SetChiefDialog;
import gui.professor.MyProfessorPanel;
import gui.professor.ProfessorDialog;
import gui.professor.ProfessorEditDialog;
import gui.student.MyAddingStudentDialog;
import gui.student.MyEditingStudentDialog;
import gui.student.MyStudentPanel;
import gui.student.MyStudentRowFilter;
import gui.student.MyStudentTable;
import gui.subject.MyAddingSubjectDialog;
import gui.subject.MyEditingSubjectDialog;
import gui.subject.MySubjectPanel;
import model.ChairDB;
import model.ProfessorDB;
import model.StudentDB;
import model.SubjectDB;

public class MyToolBar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton create;
	private JButton edit;
	private JButton delete;
	private JTextField searchField;
	private JButton loupe;
	public MyToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		 create = new JButton();
		create.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("tooltipNew"));
		Image createImg = kit.getImage("images/create4.png");
		//Image resizedCreateImg = createImg.getScaledInstance(25, 24, java.awt.Image.SCALE_SMOOTH);
		create.setIcon(new ImageIcon(createImg));
		create.setBorderPainted(false);
		create.setFocusPainted(false);
		create.setBackground(Color.white);
		//create.getInputMap().put(KeyStroke.getKeyStroke("pressed");
		
		
		MyTabbedPane.getInstance().addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(MyTabbedPane.getInstance().getSelectedIndex()==3)
					create.setEnabled(false);
				else
					create.setEnabled(true);
				
			}
		});
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
		
		 edit = new JButton();
		edit.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("tooltipEdit"));
		Image editImg = kit.getImage("images/edit4.png");
		//Image resizedEditImg = editImg.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
		edit.setIcon(new ImageIcon(editImg));
		edit.setBorderPainted(false);
		edit.setFocusPainted(false);
		edit.setBackground(Color.white);
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MyTabbedPane.getInstance().getSelectedIndex()==0) {
					if((MyStudentPanel.getInstance().getStudentTable().getSelectedRow()< (StudentDB.getInstance().getStudents().size()) && MyStudentPanel.getInstance().getStudentTable().getSelectedRow() >= 0)) {
						MyEditingStudentDialog mesd = new MyEditingStudentDialog();
					}
				}
				else if(MyTabbedPane.getInstance().getSelectedIndex()==2) {
					if(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow()< SubjectDB.getInstance().getSubjects().size() && MySubjectPanel.getInstance().getSubjectTable().getSelectedRow()>=0) {
						MyEditingSubjectDialog ms = new MyEditingSubjectDialog();
					}
				}
				else if(MyTabbedPane.getInstance().getSelectedIndex() == 1) {
					if((MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow() < (ProfessorDB.getInstance().getProfessors().size()) && MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow()>= 0)){
						ProfessorEditDialog ped = new ProfessorEditDialog();
					}
				}
				else if(MyTabbedPane.getInstance().getSelectedIndex() == 3) {
					if((MyChairPanel.getInstance().getChairTable().getSelectedRow() < (ChairDB.getInstance().getChairs().size()) && MyChairPanel.getInstance().getChairTable().getSelectedRow()>= 0)){
						SetChiefDialog ped = new SetChiefDialog();
					}
				}
			}
		});
		
		add(edit);
		
		addSeparator();
		
		 delete = new JButton();
		delete.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("tooltipDelete"));
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
				 else if(MyTabbedPane.getInstance().getSelectedIndex()==0) {
						if((MyStudentPanel.getInstance().getStudentTable().getSelectedRow()< (StudentDB.getInstance().getStudents().size()) && MyStudentPanel.getInstance().getStudentTable().getSelectedRow() >= 0)) {
							int answer=JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
									MainFrame.getInstance().getResourceBundle().getString("deleteStudent"), MainFrame.getInstance().getResourceBundle().getString("deleteStudent1"), 
							        JOptionPane.YES_NO_OPTION);
							if(answer==JOptionPane.YES_OPTION) {
								StudentController.getInstance().deleteStudent((MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())));
							}
						}
				 }
				 else if(MyTabbedPane.getInstance().getSelectedIndex()==3) {
						if((MyChairPanel.getInstance().getChairTable().getSelectedRow()< (ChairDB.getInstance().getChairs().size()) && MyChairPanel.getInstance().getChairTable().getSelectedRow() >= 0)) {
							int answer=JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
									"Da li ste sigurni da zelite da obrisete katedru?", "Brisanje katedre", 
							        JOptionPane.YES_NO_OPTION);
							if(answer==JOptionPane.YES_OPTION) {
								ChairController.getInstance().deleteChair((MyChairPanel.getInstance().getChairTable().getSelectedRow()));
							}
						}
				 }
			}
		});
			
		add(delete);

		add(Box.createHorizontalGlue());
		
		
		addSeparator();
		
		 searchField = new JTextField(10);
		searchField.setMaximumSize(searchField.getPreferredSize());
		searchField.setToolTipText("Type here");
		searchField.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("tooltipField"));
		
		add(searchField);
	
		 loupe = new JButton();
		loupe.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("tooltipSearch"));
		loupe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MyTabbedPane.getInstance().getSelectedIndex()==0) {
					MyStudentTable.trs.setRowFilter(new MyStudentRowFilter(searchField.getText()));
				}
				
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
	
	public void initComponents() {
		create.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("tooltipNew"));
		edit.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("tooltipEdit"));
		delete.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("tooltipDelete"));
		searchField.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("tooltipField"));
		loupe.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("tooltipSearch"));
	}

}
