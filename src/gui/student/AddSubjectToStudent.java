package gui.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;

import controller.StudentController;
import gui.MainFrame;
import model.Student;
import model.Subject;
import model.SubjectDB;

public class AddSubjectToStudent extends JDialog{
	
	public AddSubjectToStudent() {
		super(MainFrame.getInstance(),MainFrame.getInstance().getResourceBundle().getString("addSubject"),true);
		setResizable(false);
		setSize(new Dimension(500,400));
		setLocationRelativeTo(MainFrame.getInstance());
		
		
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.white);
		northPanel.setPreferredSize(new Dimension(1,50));
		add(northPanel,BorderLayout.NORTH);
		JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.white);
		westPanel.setPreferredSize(new Dimension(50,1));
		add(westPanel,BorderLayout.WEST);
		JPanel eastPanel = new JPanel();
		eastPanel.setBackground(Color.white);
		eastPanel.setPreferredSize(new Dimension(50,1));
		add(eastPanel,BorderLayout.EAST);
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		JButton btnOk = new JButton(MainFrame.getInstance().getResourceBundle().getString("btnConfirm"));
	
		JButton btnCancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("btnCancel"));
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		southPanel.add(btnOk);
		southPanel.add(Box.createHorizontalStrut(50));
		southPanel.add(btnCancel);
		southPanel.setBackground(Color.white);
		southPanel.setPreferredSize(new Dimension(1,100));
		add(southPanel,BorderLayout.SOUTH);
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		Vector<Subject> subjects = new Vector<Subject>();
		boolean tmp = true;
		Student s = StudentController.getInstance().getSelectedStudent(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow()));
		for (int i =0 ; i<SubjectDB.getInstance().getSubjects().size();i++) {
			tmp=true;
			/*Prvi uslov je da se ne nalaze ni u listi položenih, kao ni u listi nepoloženih predmeta označenog studenta. 
			 * 
			 * Drugi uslov je da je označeni student na odgovarajućoj godini studija (ista ili viša godina studija u odnosu na godinu na kojoj se predmet izvodi).
			 */
			for(int j = 0; j<s.getGrades().size();j++) {
				if(SubjectDB.getInstance().getSubjects().get(i).getIdSubject().equals(s.getGrades().get(j).getSubject().getIdSubject()))
					tmp=false;
			}
			for(int j = 0; j<s.getFailedExams().size();j++) {
				if(SubjectDB.getInstance().getSubjects().get(i).getIdSubject().equals(s.getFailedExams().get(j).getIdSubject()))
						tmp=false;
			}
			if(SubjectDB.getInstance().getSubjects().get(i).getYearOfStudySub()<s.getCurrYearOfStudy())
				tmp=false;
			if(tmp)
				subjects.add(SubjectDB.getInstance().getSubjects().get(i));
		}
		JList<Subject> listBox = new JList<Subject>(subjects);
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentController.getInstance().addSubjectToFailed(listBox.getSelectedValue());
				dispose();
				
			}
		});

		centerPanel.add(listBox);

		listBox.setSelectedIndex(0);
		
		add(centerPanel,BorderLayout.CENTER);
		setVisible(true);
	}
}
