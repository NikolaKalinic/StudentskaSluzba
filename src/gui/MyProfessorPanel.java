package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyProfessorPanel extends JPanel {

	private static MyProfessorPanel instance = null;
	
	public static MyProfessorPanel getInstance() {
		if (instance == null) {
			instance = new MyProfessorPanel();
		}
		return instance;
	}
	private JTable professorTable;
	private MyProfessorPanel() {
		setLayout(new BorderLayout());
		JPanel panNorht = new JPanel();
		panNorht.setBackground(Color.white);
		panNorht.setPreferredSize(new Dimension(100,30));
		add(panNorht,BorderLayout.NORTH);
		
		JPanel panWest= new JPanel();
		panWest.setBackground(Color.white);
		panWest.setPreferredSize(new Dimension(30,30));
		add(panWest,BorderLayout.WEST);
		
		JPanel panEast= new JPanel();
		panEast.setBackground(Color.white);
		panEast.setPreferredSize(new Dimension(30,30));
		add(panEast,BorderLayout.EAST);
		
		JPanel panSouth= new JPanel();
		panSouth.setBackground(Color.white);
		panSouth.setPreferredSize(new Dimension(100,30));
		add(panSouth,BorderLayout.SOUTH);
		professorTableView();
	}
	private void professorTableView() {
		professorTable = new MyProfessorTable();
		JScrollPane scrollPane = new JScrollPane(professorTable);
		add(scrollPane, BorderLayout.CENTER);
	}
	public void updateView() {
		AbstractTableModelProfessors model = (AbstractTableModelProfessors) professorTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
}