package gui.student;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Student;

public class MyEditingStudentTabbedPane extends JTabbedPane {

	public MyEditingStudentTabbedPane() {
		addTab("Informacije",new MyEditigStudentInformation());
		addTab("Položeni",PassedExam.getInstance());
		addTab("Nepoloženi",NotPassedExam.getInstance());
	}
}
