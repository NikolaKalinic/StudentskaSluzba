package gui.professor;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import gui.MainFrame;


public class MyEditingProfessorTabbedPane extends JTabbedPane {

	public MyEditingProfessorTabbedPane() {
		addTab(MainFrame.getInstance().getResourceBundle().getString("profTPInfo"),new MyEditingProfessorInformation());
		addTab(MainFrame.getInstance().getResourceBundle().getString("profTPSubjects"),ProfessorSubjects.getInstance());
	}
}
