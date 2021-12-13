package gui;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class MyMenuBar extends JMenuBar {
	
	public MyMenuBar() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		setBorder(border);
		
		JMenu file = new JMenu("File");
		file.setMnemonic('f');
		file.setCursor(new Cursor(12));
		JMenuItem fileNew = new JMenuItem("New");
		fileNew.setCursor(new Cursor(12));
		fileNew.setMnemonic('n');
		fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		Image img = kit.getImage("images/newplus.png");
		Image iconNew = img.getScaledInstance(20,20, 4);
		Icon fileIconNew = new ImageIcon(iconNew);
		fileNew.setIcon(fileIconNew);
		
		JMenuItem fileSave = new JMenuItem("Save");
		fileSave.setMnemonic('s');
		fileSave.setCursor(new Cursor(12));
		fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		Image img1 = kit.getImage("images/save.png");
		Image iconSave = img1.getScaledInstance(15, 15, 4);
		Icon fileIconSave = new ImageIcon(iconSave);
		fileSave.setIcon(fileIconSave);
		
		
		JMenu fileOpen = new JMenu("Open");
		fileOpen.setCursor(new Cursor(12));
		fileOpen.setMnemonic('o');
		Image img2 = kit.getImage("images/open.png");
		Image iconOpen = img2.getScaledInstance(15, 15, 4);
		Icon fileIconOpen = new ImageIcon(iconOpen);
		fileOpen.setIcon(fileIconOpen);
		JMenuItem student = new JMenuItem("Studenti");
		student.setCursor(new Cursor(12));
		student.setMnemonic('s');
		student.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));
		Image imgStud = kit.getImage("images/student.png");
		imgStud = imgStud.getScaledInstance(20, 20, 4);
		Icon iconStud = new ImageIcon(imgStud);
		student.setIcon(iconStud);
		
		JMenuItem subject = new JMenuItem("Predmeti");
		subject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
		subject.setMnemonic('p');
		Image imgSubj = kit.getImage("images/subject.png");
		imgSubj = imgSubj.getScaledInstance(20, 20, 4);
		Icon iconSubj = new ImageIcon(imgSubj);
		subject.setIcon(iconSubj);
		subject.setCursor(new Cursor(12));
		
		JMenuItem professor = new JMenuItem("Profesori");
		professor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.SHIFT_MASK));
		professor.setMnemonic('f');
		Image imgProf = kit.getImage("images/professor.png");
		imgProf = imgProf.getScaledInstance(20, 20, 4);
		Icon iconProf = new ImageIcon(imgProf);
		professor.setIcon(iconProf);
		professor.setCursor(new Cursor(12));
		
		JMenuItem chair = new JMenuItem("Katedre");
		chair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.SHIFT_MASK));
		chair.setMnemonic('k');
		Image imgChair = kit.getImage("images/department.png");
		imgChair = imgChair.getScaledInstance(20, 20, 4);
		Icon iconChair = new ImageIcon(imgChair);
		chair.setIcon(iconChair);
		subject.setCursor(new Cursor(12));
		chair.setCursor(new Cursor(12));
		
		fileOpen.add(student);
		fileOpen.add(subject);
		fileOpen.add(professor);
		fileOpen.add(chair);
		
		JMenuItem fileClose = new JMenuItem("Close");
		fileClose.setCursor(new Cursor(12));
		fileClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		fileClose.setMnemonic('c');
		Image img3 = kit.getImage("images/close.png");
		Image iconClose = img3.getScaledInstance(15, 15, 4);
		Icon fileIconClose = new ImageIcon(iconClose);
		fileClose.setIcon(fileIconClose);
		
		file.add(fileNew);
		file.addSeparator();
		file.add(fileSave);
		file.addSeparator();
		file.add(fileOpen);
		file.addSeparator();
		file.add(fileClose);
		
		
		JMenu edit = new JMenu("Edit");
		edit.setCursor(new Cursor(12));
		edit.setMnemonic('e');
		JMenuItem editEdit = new JMenuItem("Edit");
		editEdit.setCursor(new Cursor(12));
		editEdit.setMnemonic('e');
		editEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		Image img4 = kit.getImage("images/edit.png");
		Image iconEdit = img4.getScaledInstance(15, 15, 4);
		Icon editIconEdit = new ImageIcon(iconEdit);
		editEdit.setIcon(editIconEdit);
		
		JMenuItem editDelete = new JMenuItem("Delete");
		editDelete.setCursor(new Cursor(12));
		editDelete.setMnemonic('d');
		editDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		Image img5 = kit.getImage("images/delete.png");
		Image iconDelete = img5.getScaledInstance(15, 15, 4);
		Icon editIconDelete = new ImageIcon(iconDelete);
		
		editDelete.setIcon(editIconDelete);
		edit.add(editEdit);
		edit.addSeparator();
		edit.add(editDelete);
		
		JMenu help = new JMenu("Help");
		help.setCursor(new Cursor(12));
		help.setMnemonic('h');
		JMenuItem helpHelp = new JMenuItem("Help");
		helpHelp.setCursor(new Cursor(12));
		helpHelp.setMnemonic('h');
		helpHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		Image img6 = kit.getImage("Images/help.png");
		Image iconHelp = img6.getScaledInstance(15, 15, 4);
		Icon helpIconHelp = new ImageIcon(iconHelp);
		helpHelp.setIcon(helpIconHelp);
		
		JMenuItem helpAbout = new JMenuItem("About");
		helpAbout.setCursor(new Cursor(12));
		helpAbout.setMnemonic('a');
		helpAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		Image img7 = kit.getImage("images/about.png");
		Image iconAbout = img7.getScaledInstance(15, 15, 4);
		Icon helpIconAbout = new ImageIcon(iconAbout);
		helpAbout.setIcon(helpIconAbout);
		
		help.add(helpHelp);
		help.addSeparator();
		help.add(helpAbout);
		
		
		add(file);
		add(edit);
		add(help);
	}
	
}