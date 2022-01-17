package gui.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.StudentController;
import gui.MainFrame;
import model.Grades;
import model.Student;
import model.StudentDB;
import model.Subject;

public class PassedExam extends JPanel{
	
	private static PassedExam instance = null;
	
	public static PassedExam getInstance() {
		if (instance == null) {
			instance = new PassedExam();
		}
		return instance;
	}
	public JLabel label1;
	public JLabel label2;
	private JTable passedExamsTable;
	private JButton button;
	private PassedExam(){
		setLayout(new BorderLayout());
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		/*top panel for button*/
		JPanel panTop = new JPanel();
		int width=kit.getScreenSize().width/30;
		int height=kit.getScreenSize().width/60;
		panTop.setLayout(new FlowLayout(FlowLayout.LEFT,width,height));
		panTop.setBackground(Color.white);
		panTop.setPreferredSize(new Dimension(kit.getScreenSize().width/3,kit.getScreenSize().height/15));
		 button = new JButton(MainFrame.getInstance().getResourceBundle().getString("cancelGrade"));
		button.setFocusPainted(false);
		button.setBackground(new Color(14,98,190));
		button.setForeground(Color.white);
		panTop.add(button,FlowLayout.LEFT);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if((PassedExam.getInstance().getPassedExamsTable().getSelectedRow() < (StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())).getGrades().size()) && PassedExam.getInstance().getPassedExamsTable().getSelectedRow() >= 0)) {
					int answer=JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
							MainFrame.getInstance().getResourceBundle().getString("cancelGrade"), MainFrame.getInstance().getResourceBundle().getString("cancelGrade1"), 
					        JOptionPane.YES_NO_OPTION);
					if(answer==JOptionPane.YES_OPTION)
						StudentController.getInstance().cancelGrade();
				}
				
			}
		});
		add(panTop,BorderLayout.NORTH);
		
		
		/*center panel for table*/
		JPanel cLeft = new JPanel();
		cLeft.setBackground(Color.white);
		cLeft.setPreferredSize(new Dimension(width,1));
		JPanel cRight = new JPanel();
		cRight.setBackground(Color.white);
		cRight.setPreferredSize(new Dimension(width,1));
		add(cLeft,BorderLayout.EAST);
		add(cRight,BorderLayout.WEST);

		
		
		
		
		/*bot panel for label*/
		JPanel panBottom = new JPanel();
		panBottom.setLayout(new BorderLayout());
		panBottom.setBackground(Color.white);
		panBottom.setPreferredSize(new Dimension(kit.getScreenSize().width/3,kit.getScreenSize().height/10));
		label1 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("labelAvg")+StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())).getAvgMark());
		label2 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("labelTotalEspb")+StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())).getTotalESPB());
		
		JPanel panLabel = new JPanel();
		panLabel.setBackground(Color.white);
		panLabel.setPreferredSize(new Dimension(kit.getScreenSize().width/8,kit.getScreenSize().height/10));
		panLabel.setLayout(new BorderLayout());
		panLabel.add(label1,BorderLayout.NORTH);
		
		JPanel margin = new JPanel();
		margin.setBackground(Color.white);
		margin.setPreferredSize(new Dimension(kit.getScreenSize().width/8,kit.getScreenSize().height/10));
		margin.setLayout(new BorderLayout());
		panLabel.add(margin,BorderLayout.CENTER);
		margin.add(label2,BorderLayout.NORTH);
		panBottom.add(panLabel,BorderLayout.EAST);
		
		
		
		add(panBottom,BorderLayout.SOUTH);
		passedExamsTableView();
		updateLabel();
	}
	private void passedExamsTableView() {
		passedExamsTable = new MyPassedExamsTable();
		JScrollPane scrollPane = new JScrollPane(passedExamsTable);
		add(scrollPane, BorderLayout.CENTER);
	}
	public void updateLabel() {
		 Student student = StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow()));
	     label1.setText(MainFrame.getInstance().getResourceBundle().getString("labelAvg") + student.getAverageMark(student.getGrades()));
	     label2.setText(MainFrame.getInstance().getResourceBundle().getString("labelTotalEspb") + student.getTotalESPB(student.getGrades()));
	     button.setText(MainFrame.getInstance().getResourceBundle().getString("cancelGrade"));
	     validate();
	}
	public void updateView() {
		AbstractTablePassedExams model = (AbstractTablePassedExams) passedExamsTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
	public JTable getPassedExamsTable() {
		return passedExamsTable;
	}
	
}
