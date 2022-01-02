package gui.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.StudentDB;

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
		JButton button = new JButton("Poništi ocenu");
		button.setBackground(new Color(14,98,190));
		button.setForeground(Color.white);
		panTop.add(button,FlowLayout.LEFT);
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
		label1 = new JLabel("Prosečna ocena: "+StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())).getAvgMark());
		label2 = new JLabel("Ukupno ESPB: "+StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())).getTotalESPB());
		
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
	     label1.setText("Prosečna ocena: "+StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())).getAvgMark());
	     label2.setText("Ukupno ESPB: "+StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())).getTotalESPB());
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
