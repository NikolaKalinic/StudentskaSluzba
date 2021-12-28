package gui.subject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MySubjectPanel extends JPanel {

	private static MySubjectPanel instance = null;
	
	public static MySubjectPanel getInstance() {
		if (instance == null) {
			instance = new MySubjectPanel();
		}
		return instance;
	}
	private JTable subjectTable;
	private MySubjectPanel() {
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
		subjectTableView();
	}
	private void subjectTableView() {
		subjectTable = new MySubjectTable();
		JScrollPane scrollPane = new JScrollPane(subjectTable);
		add(scrollPane, BorderLayout.CENTER);
	}
	public void updateView() {
		AbstractTableModelSubject model = (AbstractTableModelSubject) subjectTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
	public JTable getSubjectTable() {
		return subjectTable;
	}

	
}