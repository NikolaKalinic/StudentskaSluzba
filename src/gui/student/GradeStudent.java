package gui.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import controller.StudentController;
import controller.SubjectController;
import gui.MainFrame;
import model.Grades;
import model.Student;
import model.Subject;

public class GradeStudent extends JDialog{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7121399372857188521L;
	private static JButton btnOk;
	private static JTextField sDateTf;
	private static JLabel dateInfo;
	private static Subject sub;

	public GradeStudent() {
		super(MainFrame.getInstance(),MainFrame.getInstance().getResourceBundle().getString("addGrade"),true);
		setResizable(false);
		setSize(new Dimension(300,350));
		setLocationRelativeTo(MainFrame.getInstance());
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
		btnOk = new JButton(MainFrame.getInstance().getResourceBundle().getString("btnConfirm"));
	
		JButton btnCancel = new JButton(MainFrame.getInstance().getResourceBundle().getString("btnCancel"));
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		southPanel.add(btnOk);
		southPanel.add(btnCancel);
		southPanel.setBackground(Color.white);
		southPanel.setPreferredSize(new Dimension(300,50));
		add(southPanel,BorderLayout.SOUTH);
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.white);
		centerPanel.setLayout(new GridBagLayout());
		
		Student student = StudentController.getInstance().getSelectedStudent(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow()));
		if(NotPassedExam.getInstance().getNotPassedExamsTable().getSelectedRow() > -1 ){
			sub = student.getFailedExams().get((NotPassedExam.getInstance().getNotPassedExamsTable().getSelectedRow()));
		} else {
			return;
		}
		JLabel sId = new JLabel(MainFrame.getInstance().getResourceBundle().getString("subjectId"));
		GridBagConstraints cId = new GridBagConstraints();
		cId.gridx = 0;
		cId.gridy = 0;
		cId.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(sId, cId);
		JTextField sIdTf = new JTextField(sub.getIdSubject());
		sIdTf.setEditable(false);
		GridBagConstraints cIdTf = new GridBagConstraints();
		cIdTf.gridx = 1;
		cIdTf.gridy = 0;
		cIdTf.insets = new Insets(0, 10, 0, 0);
		cIdTf.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(sIdTf, cIdTf);
		
		JLabel sGlue = new JLabel("                                   ");
		GridBagConstraints cGlue = new GridBagConstraints();
		cGlue.gridx = 0;
		cGlue.gridy = 1;
		cGlue.gridwidth = 2;
		cGlue.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(sGlue, cGlue);
		
		JLabel sName = new JLabel(MainFrame.getInstance().getResourceBundle().getString("subjectName"));
		GridBagConstraints cName = new GridBagConstraints();
		cName.gridx = 0;
		cName.gridy = 2;
		cName.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(sName, cName);
		JTextField sNameTf = new JTextField(sub.getName());
		sNameTf.setEditable(false);
		GridBagConstraints cNameTf = new GridBagConstraints();
		cNameTf.gridx = 1;
		cNameTf.gridy = 2;
		cNameTf.insets = new Insets(0, 10, 0, 0);
		cNameTf.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(sNameTf, cNameTf);
		
		JLabel sGlue1 = new JLabel("                                   ");
		GridBagConstraints cGlue1 = new GridBagConstraints();
		cGlue1.gridx = 0;
		cGlue1.gridy = 3;
		cGlue1.gridwidth = 2;
		cGlue1.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(sGlue1, cGlue1);
		
		JLabel sGrade = new JLabel(MainFrame.getInstance().getResourceBundle().getString("subjectGrade"));
		String[] grades = {"6", "7", "8", "9", "10"};
		JComboBox<String> comboGrades = new JComboBox<String>(grades);
		comboGrades.setSelectedItem(0);
		GridBagConstraints cGrade =  new GridBagConstraints();
		cGrade.gridx = 0;
		cGrade.gridy = 4;
		cGrade.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(sGrade, cGrade);
		GridBagConstraints cComboGrades = new GridBagConstraints();
		cComboGrades.gridx = 1;
		cComboGrades.gridy = 4;
		cComboGrades.insets = new Insets(0, 10, 0, 0);
		centerPanel.add(comboGrades, cComboGrades);
		
		JLabel sGlue2 = new JLabel("                                   ");
		GridBagConstraints cGlue2 = new GridBagConstraints();
		cGlue2.gridx = 0;
		cGlue2.gridy = 5;
		cGlue2.gridwidth = 2;
		cGlue2.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(sGlue2, cGlue2);
		
		
		JLabel sDate = new JLabel(MainFrame.getInstance().getResourceBundle().getString("subjectDate"));
		GridBagConstraints cDate = new GridBagConstraints();
		cDate.gridx = 0;
		cDate.gridy = 6;
		cDate.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(sDate, cDate);
		sDateTf = new JTextField("");
		GridBagConstraints cDateTf = new GridBagConstraints();
		cDateTf.gridx = 1;
		cDateTf.gridy = 6;
		cDateTf.insets = new Insets(0, 10, 0, 0);
		cDateTf.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(sDateTf, cDateTf);
		
		dateInfo = new JLabel("                                   ");
		dateInfo.setText("								    ");
		GridBagConstraints cDateInfo = new GridBagConstraints();
		cDateInfo.gridx = 1;
		cDateInfo.gridy = 7;
		cDateInfo.gridwidth = 1;
		centerPanel.add(dateInfo, cDateInfo);
		
		
		new Timer(100,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					GradeStudent.checkValidity();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}).start();
		
		
		
		
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Grades grade = new Grades(student, sub, Integer.parseInt(comboGrades.getSelectedItem().toString()), LocalDate.parse(sDateTf.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				StudentController.getInstance().addGrade(grade);
				dispose();
				
			}
		});

		
		
		this.add(centerPanel,BorderLayout.CENTER);
		setVisible(true);
	}
	
	public static void checkValidity() throws Exception {
		if(sDateTf.getText().isBlank()) {
			disableOk();
		} else {
			try {
				LocalDate.parse(sDateTf.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			} catch (Exception e1 ) {
				disableOk();
				dateInfo.setForeground(Color.red);
				dateInfo.setText(MainFrame.getInstance().getResourceBundle().getString("dateFormatInfo"));
				return;
			}
			enableOk();
			dateInfo.setForeground(Color.black);
			dateInfo.setText("								    ");
		}
	}
	
	public static void enableOk() {
		btnOk.setEnabled(true);
	}
	
	public static void disableOk() {
		btnOk.setEnabled(false);
	}
}
