package gui;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import gui.chair.MyChairPanel;
import gui.professor.MyProfessorPanel;
import gui.student.MyStudentPanel;
import gui.subject.MySubjectPanel;


public class MyTabbedPane extends JTabbedPane{

	private static MyTabbedPane instance = null;
	public static MyTabbedPane getInstance() {
		if (instance == null) {
			instance = new MyTabbedPane();
		}
		return instance;
	}
	private MyTabbedPane() {
		addTab(MainFrame.getInstance().getResourceBundle().getString("miStudent"),MyStudentPanel.getInstance());
		addTab(MainFrame.getInstance().getResourceBundle().getString("miProfessor"),MyProfessorPanel.getInstance());
		addTab(MainFrame.getInstance().getResourceBundle().getString("miSubject"),MySubjectPanel.getInstance());
		addTab(MainFrame.getInstance().getResourceBundle().getString("miChair"),MyChairPanel.getInstance());
	}
	
	public void initComponents() {
			setTitleAt(0, MainFrame.getInstance().getResourceBundle().getString("miStudent"));
			setTitleAt(2,MainFrame.getInstance().getResourceBundle().getString("miSubject"));
			setTitleAt(1,MainFrame.getInstance().getResourceBundle().getString("miProfessor"));
			setTitleAt(3,MainFrame.getInstance().getResourceBundle().getString("miChair"));
	}

	
}
