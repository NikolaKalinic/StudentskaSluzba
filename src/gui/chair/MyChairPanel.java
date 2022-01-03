package gui.chair;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class MyChairPanel extends JPanel {

private static MyChairPanel instance = null;
	
	public static MyChairPanel getInstance() {
		if (instance == null) {
			instance = new MyChairPanel();
		}
		return instance;
	}
	
	private JTable chairTable;
	private MyChairPanel() {
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
		chairTableView();
	}
	
	private void chairTableView() {
		chairTable = new MyChairTable();
		JScrollPane scrollPane = new JScrollPane(chairTable);
		add(scrollPane, BorderLayout.CENTER);
	}
	public void updateView() {
		AbstractTableModelChair model = (AbstractTableModelChair) chairTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
	public JTable getChairTable() {
		return chairTable;
	}
}
