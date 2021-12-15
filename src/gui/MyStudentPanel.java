package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyStudentPanel extends JPanel {

	private static MyStudentPanel instance = null;
	
	public static MyStudentPanel getInstance() {
		if (instance == null) {
			instance = new MyStudentPanel();
		}
		return instance;
	}
	private JTable studentTable;
	private MyStudentPanel() {
		setLayout(new BorderLayout());
		JPanel panNorht = new JPanel();
		panNorht.setPreferredSize(new Dimension(100,30));
		add(panNorht,BorderLayout.NORTH);
		
		JPanel panWest= new JPanel();
		panWest.setPreferredSize(new Dimension(100,30));
		add(panWest,BorderLayout.WEST);
		
		JPanel panEast= new JPanel();
		panEast.setPreferredSize(new Dimension(100,30));
		add(panEast,BorderLayout.EAST);
		
		JPanel panSouth= new JPanel();
		panSouth.setPreferredSize(new Dimension(100,30));
		add(panSouth,BorderLayout.SOUTH);
		studentTableView();
	}
	private void studentTableView() {
		studentTable = new MyStudentTable();
		JScrollPane scrollPane = new JScrollPane(studentTable);
		add(scrollPane, BorderLayout.CENTER);
	}
	public void updateView() {
		AbstractTableModelStudent model = (AbstractTableModelStudent) studentTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
}