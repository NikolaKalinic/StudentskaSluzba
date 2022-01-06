package gui.student;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import gui.MainFrame;
import model.Student;

public class MyEditingStudentTabbedPane extends JTabbedPane {

	public MyEditingStudentTabbedPane() {
		addTab(MainFrame.getInstance().getResourceBundle().getString("studentInformation"),new MyEditigStudentInformation());
		addTab(MainFrame.getInstance().getResourceBundle().getString("studentPassed"),PassedExam.getInstance());
		addTab(MainFrame.getInstance().getResourceBundle().getString("studentFailed"),new JPanel());
	}
}
