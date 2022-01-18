package gui.chair;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import gui.MainFrame;
import gui.subject.MySubjectTable;

public class MyChairTable extends JTable{
	
	private static MyChairTable instance = null;
	public static MyChairTable getInstance() {
		if(instance==null) {
			instance=new MyChairTable();
		}
		return instance;	
	}

	private MyChairTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelChair());
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(new Color(153, 204, 255));
		} else
			if (row % 2 == 0) {
				c.setBackground(Color.LIGHT_GRAY);
			} else {
				c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	public void initComponents() {
		getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("idChair"));
		getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("nameChair"));
		getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("chiefChair"));
	}
}
