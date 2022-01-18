package gui;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import controller.ChairController;
import controller.ProfessorController;
import controller.StudentController;
import controller.SubjectController;
import gui.chair.MyChairPanel;
import gui.chair.SetChiefDialog;
import gui.professor.MyProfessorPanel;
import gui.professor.ProfessorDialog;
import gui.professor.ProfessorEditDialog;
import gui.student.MyAddingStudentDialog;
import gui.student.MyEditingStudentDialog;
import gui.student.MyStudentPanel;
import gui.subject.MyAddingSubjectDialog;
import gui.subject.MyEditingSubjectDialog;
import gui.subject.MySubjectPanel;
import model.ChairDB;
import model.ProfessorDB;
import model.StudentDB;
import model.SubjectDB;

public class MyMenuBar extends JMenuBar {
	private JMenu file;
	private JMenuItem fileNew;
	private JMenuItem fileSave;
	private JMenu fileOpen;
	private JMenuItem student;
	private JMenuItem subject;
	private JMenuItem professor;
	private JMenuItem chair;
	private JMenuItem fileClose;
	private JMenu edit;
	private JMenuItem editEdit;
	private JMenuItem editDelete;
	private JMenu help;
	private JMenuItem helpHelp;
	private JMenuItem helpAbout;
	private JMenu language;
	private JCheckBoxMenuItem lSrb;
	private JCheckBoxMenuItem lEng;
	
	public MyMenuBar() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		setBorder(border);
		
		file = new JMenu(MainFrame.getInstance().getResourceBundle().getString("mFile"));
		char c  = MainFrame.getInstance().getResourceBundle().getString("mFile").charAt(0);
		file.setMnemonic((int)c);
		//file.setMnemonic('f');
		file.setCursor(new Cursor(12));
		fileNew = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("miNew"));
		c=MainFrame.getInstance().getResourceBundle().getString("miNew").charAt(0);
		fileNew.setMnemonic((int)c);
		fileNew.setCursor(new Cursor(12));
		fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		Image img = kit.getImage("images/newplus.png");
		Image iconNew = img.getScaledInstance(20,20, 4);
		Icon fileIconNew = new ImageIcon(iconNew);
		fileNew.setIcon(fileIconNew);
		fileNew.addActionListener(new ActionListener() {
			
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
		fileSave = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("miSave"));
		c=MainFrame.getInstance().getResourceBundle().getString("miSave").charAt(0);
		fileSave.setMnemonic((int)c);
		fileSave.setCursor(new Cursor(12));
		fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		Image img1 = kit.getImage("images/save.png");
		Image iconSave = img1.getScaledInstance(15, 15, 4);
		Icon fileIconSave = new ImageIcon(iconSave);
		fileSave.setIcon(fileIconSave);
		
		
		fileOpen = new JMenu(MainFrame.getInstance().getResourceBundle().getString("miOpen"));
		c=MainFrame.getInstance().getResourceBundle().getString("miOpen").charAt(0);
		fileOpen.setMnemonic((int)c);
		fileOpen.setCursor(new Cursor(12));
		Image img2 = kit.getImage("images/open.png");
		Image iconOpen = img2.getScaledInstance(15, 15, 4);
		Icon fileIconOpen = new ImageIcon(iconOpen);
		fileOpen.setIcon(fileIconOpen);
		
		student = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("miStudent"));
		c=MainFrame.getInstance().getResourceBundle().getString("miStudent").charAt(0);
		student.setMnemonic((int)c);
		student.setCursor(new Cursor(12));
		student.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK+ActionEvent.CTRL_MASK));
		Image imgStud = kit.getImage("images/student.png");
		imgStud = imgStud.getScaledInstance(20, 20, 4);
		Icon iconStud = new ImageIcon(imgStud);
		student.setIcon(iconStud);
		
		
		subject = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("miSubject"));
		c=MainFrame.getInstance().getResourceBundle().getString("miSubject").charAt(0);
		subject.setMnemonic((int)c);
		subject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK+ActionEvent.CTRL_MASK));
		Image imgSubj = kit.getImage("images/subject.png");
		imgSubj = imgSubj.getScaledInstance(20, 20, 4);
		Icon iconSubj = new ImageIcon(imgSubj);
		subject.setIcon(iconSubj);
		subject.setCursor(new Cursor(12));
		
		
		professor = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("miProfessor"));
		c=MainFrame.getInstance().getResourceBundle().getString("miProfessor").charAt(0);
		professor.setMnemonic((int)c);
		professor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.SHIFT_MASK+ActionEvent.CTRL_MASK));
		Image imgProf = kit.getImage("images/professor.png");
		imgProf = imgProf.getScaledInstance(20, 20, 4);
		Icon iconProf = new ImageIcon(imgProf);
		professor.setIcon(iconProf);
		professor.setCursor(new Cursor(12));
		
		chair = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("miChair"));
		c=MainFrame.getInstance().getResourceBundle().getString("miChair").charAt(0);
		chair.setMnemonic((int)c);
		chair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.SHIFT_MASK+ActionEvent.CTRL_MASK));
		Image imgChair = kit.getImage("images/department.png");
		imgChair = imgChair.getScaledInstance(20, 20, 4);
		Icon iconChair = new ImageIcon(imgChair);
		chair.setIcon(iconChair);
		subject.setCursor(new Cursor(12));
		chair.setCursor(new Cursor(12));
		
		
		/*Listener for swiching tab with mnemonik and accelerator*/
		student.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyTabbedPane.getInstance().setSelectedIndex(0);
				
			}
		});
		professor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyTabbedPane.getInstance().setSelectedIndex(1);
				
			}
		});
		subject.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyTabbedPane.getInstance().setSelectedIndex(2);
				
			}
		});
		chair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyTabbedPane.getInstance().setSelectedIndex(3);
				
			}
		});
		
		
		fileOpen.add(student);
		fileOpen.add(subject);
		fileOpen.add(professor);
		fileOpen.add(chair);
		
		 fileClose = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("miClose"));
		 c=MainFrame.getInstance().getResourceBundle().getString("miClose").charAt(0);
		 fileClose.setMnemonic((int)c);
		fileClose.setCursor(new Cursor(12));
		fileClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		Image img3 = kit.getImage("images/close.png");
		Image iconClose = img3.getScaledInstance(15, 15, 4);
		Icon fileIconClose = new ImageIcon(iconClose);
		fileClose.setIcon(fileIconClose);
		
		fileClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().dispose();
			}
		});
		
		
		file.add(fileNew);
		file.addSeparator();
		file.add(fileSave);
		file.addSeparator();
		file.add(fileOpen);
		file.addSeparator();
		file.add(fileClose);
		
		
		 edit = new JMenu(MainFrame.getInstance().getResourceBundle().getString("miEdit"));
		 c=MainFrame.getInstance().getResourceBundle().getString("miEdit").charAt(0);
		 edit.setMnemonic((int)c);
		edit.setCursor(new Cursor(12));
		 editEdit = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("miEdit"));
		 c=MainFrame.getInstance().getResourceBundle().getString("miEdit").charAt(0);
		 editEdit.setMnemonic((int)c);
		editEdit.setCursor(new Cursor(12));
		editEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		Image img4 = kit.getImage("images/edit.png");
		Image iconEdit = img4.getScaledInstance(15, 15, 4);
		Icon editIconEdit = new ImageIcon(iconEdit);
		editEdit.setIcon(editIconEdit);
		editEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MyTabbedPane.getInstance().getSelectedIndex()==0)
					if((MyStudentPanel.getInstance().getStudentTable().getSelectedRow() < (StudentDB.getInstance().getStudents().size()) && MyStudentPanel.getInstance().getStudentTable().getSelectedRow() >= 0)) {
						MyEditingStudentDialog mesd = new MyEditingStudentDialog();
					}
				if(MyTabbedPane.getInstance().getSelectedIndex()==2) {
					if(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow()< SubjectDB.getInstance().getSubjects().size() && MySubjectPanel.getInstance().getSubjectTable().getSelectedRow()>=0) {
						MyEditingSubjectDialog ms = new MyEditingSubjectDialog();
					}
				}
				if(MyTabbedPane.getInstance().getSelectedIndex() == 1)
					if((MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow() < (ProfessorDB.getInstance().getProfessors().size()) && MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow() >= 0)) {
						ProfessorEditDialog ped = new ProfessorEditDialog();
						}
				if(MyTabbedPane.getInstance().getSelectedIndex() == 3) {
					if((MyChairPanel.getInstance().getChairTable().getSelectedRow() < (ChairDB.getInstance().getChairs().size()) && MyChairPanel.getInstance().getChairTable().getSelectedRow()>= 0)){
						SetChiefDialog ped = new SetChiefDialog();
					}
				}
			}
		});
				
		 editDelete = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("miDelete"));
		 c=MainFrame.getInstance().getResourceBundle().getString("miDelete").charAt(0);
		 editDelete.setMnemonic((int)c);
		editDelete.setCursor(new Cursor(12));
		editDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		Image img5 = kit.getImage("images/delete.png");
		Image iconDelete = img5.getScaledInstance(15, 15, 4);
		Icon editIconDelete = new ImageIcon(iconDelete);
		
		/*Listener for delete*/
		editDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MyTabbedPane.getInstance().getSelectedIndex()==0)
					if((MyStudentPanel.getInstance().getStudentTable().getSelectedRow() < (StudentDB.getInstance().getStudents().size()) && MyStudentPanel.getInstance().getStudentTable().getSelectedRow() >= 0)) {
						int answer=JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
								MainFrame.getInstance().getResourceBundle().getString("deleteStudent"), MainFrame.getInstance().getResourceBundle().getString("deleteStudent1"), 
						        JOptionPane.YES_NO_OPTION);
						if(answer==JOptionPane.YES_OPTION) {
							StudentController.getInstance().deleteStudent((MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())));
						}
					}
				if(MyTabbedPane.getInstance().getSelectedIndex()==3)
					if((MyChairPanel.getInstance().getChairTable().getSelectedRow()< (ChairDB.getInstance().getChairs().size()) && MyChairPanel.getInstance().getChairTable().getSelectedRow() >= 0)) {
						int answer=JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
								MainFrame.getInstance().getResourceBundle().getString("deleteChair"), MainFrame.getInstance().getResourceBundle().getString("deleteChair1"), 
						        JOptionPane.YES_NO_OPTION);
						if(answer==JOptionPane.YES_OPTION) {
							ChairController.getInstance().deleteChair((MyChairPanel.getInstance().getChairTable().getSelectedRow()));
						}
					}
			}
		});
		
		editDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(MyTabbedPane.getInstance().getSelectedIndex() == 1)
					if((MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow() < (ProfessorDB.getInstance().getProfessors().size()) && MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow() >= 0)) {
						int answer = JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
								MainFrame.getInstance().getResourceBundle().getString("deleteProfessor"), MainFrame.getInstance().getResourceBundle().getString("deleteProfessor1"), 
						        JOptionPane.YES_NO_OPTION);
						if(answer == JOptionPane.YES_OPTION) {
							ProfessorController.getInstance().removeProfessor(MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow());
						}
					}
				if(MyTabbedPane.getInstance().getSelectedIndex()==2) {
						if((MySubjectPanel.getInstance().getSubjectTable().getSelectedRow()< (SubjectDB.getInstance().getSubjects().size()) && MySubjectPanel.getInstance().getSubjectTable().getSelectedRow() >= 0)) {
							int answer=JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
									MainFrame.getInstance().getResourceBundle().getString("deleteSubject"), MainFrame.getInstance().getResourceBundle().getString("deleteSubject1"), 
							        JOptionPane.YES_NO_OPTION);
							if(answer==JOptionPane.YES_OPTION) {
								SubjectController.getInstance().deleteSubject((MySubjectPanel.getInstance().getSubjectTable().convertRowIndexToModel(MySubjectPanel.getInstance().getSubjectTable().getSelectedRow())));
							}
						}
				 }
				
			}
			
		});
		
		
		
		editDelete.setIcon(editIconDelete);
		edit.add(editEdit);
		edit.addSeparator();
		edit.add(editDelete);
		
		 help = new JMenu(MainFrame.getInstance().getResourceBundle().getString("mHelp"));
		 
		 c=MainFrame.getInstance().getResourceBundle().getString("mHelp").charAt(0);
		 help.setMnemonic((int)c);
		help.setCursor(new Cursor(12));
		 helpHelp = new JMenuItem("Help");
		helpHelp.setCursor(new Cursor(12));
		helpHelp.setMnemonic('h');
		helpHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		Image img6 = kit.getImage("Images/help.png");
		Image iconHelp = img6.getScaledInstance(15, 15, 4);
		Icon helpIconHelp = new ImageIcon(iconHelp);
		helpHelp.setIcon(helpIconHelp);
		
		 helpAbout = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("miAbout"));
		 c=MainFrame.getInstance().getResourceBundle().getString("miAbout").charAt(0);
		 helpAbout.setMnemonic((int)c);
		helpAbout.setCursor(new Cursor(12));
		helpAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		Image img7 = kit.getImage("images/about.png");
		Image iconAbout = img7.getScaledInstance(15, 15, 4);
		Icon helpIconAbout = new ImageIcon(iconAbout);
		helpAbout.setIcon(helpIconAbout);
		
		help.add(helpHelp);
		help.addSeparator();
		help.add(helpAbout);
		
		
		 language = new JMenu(MainFrame.getInstance().getResourceBundle().getString("mLanguage"));
		 c=MainFrame.getInstance().getResourceBundle().getString("mLanguage").charAt(0);
		 language.setMnemonic((int)c);
		language.setCursor(new Cursor(12));
		 lSrb = new JCheckBoxMenuItem(MainFrame.getInstance().getResourceBundle().getString("Serbian"));
		 c=MainFrame.getInstance().getResourceBundle().getString("Serbian").charAt(0);
		 lSrb.setMnemonic((int)c);
		lSrb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("sr", "RS"));
				MainFrame.getInstance().changeLanguage();
				
			}
		});
		lSrb.setSelected(true);
		lSrb.setCursor(new Cursor(12));
		 lEng = new JCheckBoxMenuItem(MainFrame.getInstance().getResourceBundle().getString("English"));
		 c=MainFrame.getInstance().getResourceBundle().getString("English").charAt(0);
		 lEng.setMnemonic((int)c);
		lEng.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("en", "US"));
				MainFrame.getInstance().changeLanguage();
				
			}
		});
		lEng.setCursor(new Cursor(12));
		language.add(lSrb);
		language.addSeparator();
		language.add(lEng);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(lSrb);
		bg.add(lEng);
		
		add(file);
		add(edit);
		add(help);
		add(language);
	}
	
	
	public void initComponents() {
		lEng.setText(MainFrame.getInstance().getResourceBundle().getString("English"));
		lSrb.setText(MainFrame.getInstance().getResourceBundle().getString("Serbian"));
		file.setText(MainFrame.getInstance().getResourceBundle().getString("mFile"));
		fileNew.setText(MainFrame.getInstance().getResourceBundle().getString("miNew"));
		fileSave.setText(MainFrame.getInstance().getResourceBundle().getString("miSave"));
		fileOpen.setText(MainFrame.getInstance().getResourceBundle().getString("miOpen"));
		student.setText(MainFrame.getInstance().getResourceBundle().getString("miStudent"));
		subject.setText(MainFrame.getInstance().getResourceBundle().getString("miSubject"));
		professor.setText(MainFrame.getInstance().getResourceBundle().getString("miProfessor"));
		chair.setText(MainFrame.getInstance().getResourceBundle().getString("miChair"));
		fileClose.setText(MainFrame.getInstance().getResourceBundle().getString("miClose"));
		edit.setText(MainFrame.getInstance().getResourceBundle().getString("miEdit"));
		editEdit.setText(MainFrame.getInstance().getResourceBundle().getString("miEdit"));
		editDelete.setText(MainFrame.getInstance().getResourceBundle().getString("miDelete"));
		help.setText(MainFrame.getInstance().getResourceBundle().getString("mHelp"));
		helpHelp.setText(MainFrame.getInstance().getResourceBundle().getString("mHelp"));
		helpAbout.setText(MainFrame.getInstance().getResourceBundle().getString("miAbout"));
		language.setText(MainFrame.getInstance().getResourceBundle().getString("mLanguage"));
		
		
		char c  = MainFrame.getInstance().getResourceBundle().getString("mFile").charAt(0);
		file.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("miNew").charAt(0);
		fileNew.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("miSave").charAt(0);
		fileSave.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("miStudent").charAt(0);
		student.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("miStudent").charAt(0);
		subject.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("miProfessor").charAt(0);
		professor.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("miChair").charAt(0);
		chair.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("miClose").charAt(0);
		fileClose.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("miEdit").charAt(0);
		 editEdit.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("miEdit").charAt(0);
		 edit.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("miDelete").charAt(0);
		 editDelete.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("miOpen").charAt(0);
		fileOpen.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("mHelp").charAt(0);
		help.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("miAbout").charAt(0);
		 helpAbout.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("Serbian").charAt(0);
		lSrb.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("English").charAt(0);
		lEng.setMnemonic((int)c);
		c=MainFrame.getInstance().getResourceBundle().getString("mLanguage").charAt(0);
		language.setMnemonic((int)c);
	}
	
}
