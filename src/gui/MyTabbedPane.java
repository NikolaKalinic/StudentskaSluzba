package gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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
		addTab("Studenti",MyStudentPanel.getInstance());
		addTab("Profesori",MyProfessorPanel.getInstance());
		addTab("Predmeti",MySubjectPanel.getInstance());
	}
}
