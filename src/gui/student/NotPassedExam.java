package gui.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.StudentController;
import gui.MainFrame;
import gui.MyTabbedPane;
import gui.professor.ProfessorDialog;
import gui.subject.MyAddingSubjectDialog;
import model.StudentDB;

public class NotPassedExam extends JPanel{
	
	private static NotPassedExam instance = null;
	
	public static NotPassedExam getInstance() {
		if (instance == null) {
			instance = new NotPassedExam();
		}
		return instance;
	}
	private JTable NotPassedExamsTable;
	private JButton button;
	private JButton button1;
	private JButton button2;
	private NotPassedExam(){
		setLayout(new BorderLayout());
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		/*top panel for button*/
		JPanel panTop = new JPanel();
		int width=kit.getScreenSize().width/30;
		int height=kit.getScreenSize().width/60;
		panTop.setLayout(new FlowLayout(FlowLayout.LEFT, 10, height));
		panTop.setBackground(Color.white);
		panTop.setPreferredSize(new Dimension(kit.getScreenSize().width/3,kit.getScreenSize().height/15));
		
		JLabel label = new JLabel();
		label.setPreferredSize(new Dimension(width - 20, height));
		 button = new JButton(MainFrame.getInstance().getResourceBundle().getString("add"));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddSubjectToStudent asts = new AddSubjectToStudent();
			}
			
		});
		 button1 = new JButton(MainFrame.getInstance().getResourceBundle().getString("delete"));
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if((NotPassedExam.getInstance().getNotPassedExamsTable().getSelectedRow()< (StudentDB.getInstance().getFailedExams().size()) && NotPassedExam.getInstance().getNotPassedExamsTable().getSelectedRow() >= 0)) {
					int answer=JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
							MainFrame.getInstance().getResourceBundle().getString("deleteSubject"), MainFrame.getInstance().getResourceBundle().getString("deleteSubject1"), 
					        JOptionPane.YES_NO_OPTION);
					if(answer==JOptionPane.YES_OPTION)
						StudentController.getInstance().deleteFailedExam();
				}
				
			}
		});
		 button2= new JButton(MainFrame.getInstance().getResourceBundle().getString("take"));
		
		button.setBackground(new Color(14,98,190));
		button.setForeground(Color.white);
		button1.setBackground(new Color(14,98,190));
		button1.setForeground(Color.white);
		button2.setBackground(new Color(14,98,190));
		button2.setForeground(Color.white);
		
		panTop.add(label);
		panTop.add(button);
		panTop.add(button1);
		panTop.add(button2);
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

		JPanel panBottom = new JPanel();
		panBottom.setLayout(new BorderLayout());
		panBottom.setBackground(Color.white);
		panBottom.setPreferredSize(new Dimension(kit.getScreenSize().width/3,kit.getScreenSize().height/10));
		
		JPanel panLabel = new JPanel();
		panLabel.setBackground(Color.white);
		panLabel.setPreferredSize(new Dimension(kit.getScreenSize().width/8,kit.getScreenSize().height/10));
		panLabel.setLayout(new BorderLayout());
		
		JPanel margin = new JPanel();
		margin.setBackground(Color.white);
		margin.setPreferredSize(new Dimension(kit.getScreenSize().width/8,kit.getScreenSize().height/10));
		margin.setLayout(new BorderLayout());
		panLabel.add(margin,BorderLayout.CENTER);
		panBottom.add(panLabel,BorderLayout.EAST);
		
		add(panBottom,BorderLayout.SOUTH);
		NotPassedExamsTableView();
	}
	private void NotPassedExamsTableView() {
		NotPassedExamsTable = new MyNotPassedExamsTable();
		JScrollPane scrollPane = new JScrollPane(NotPassedExamsTable);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void updateView() {
		AbstractTableNotPassedExams model = (AbstractTableNotPassedExams) NotPassedExamsTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
	public JTable getNotPassedExamsTable() {
		return NotPassedExamsTable;
	}
	public void initComponents() {
		button.setText(MainFrame.getInstance().getResourceBundle().getString("add"));
		button1.setText(MainFrame.getInstance().getResourceBundle().getString("delete"));
		button2.setText(MainFrame.getInstance().getResourceBundle().getString("take"));
	}
	
}
