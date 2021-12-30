package gui.professor;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class MyEditingProfessorTabbedPane extends JTabbedPane {

	public MyEditingProfessorTabbedPane() {
		addTab("Informacije",new MyEditingProfessorInformation());
		addTab("Predmeti",ProfessorSubjects.getInstance());
	}
}
