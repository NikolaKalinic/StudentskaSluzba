package gui.student;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import gui.MainFrame;
import model.StudentDB;


public class MyNotPassedExamsTable extends JTable{

	private static MyNotPassedExamsTable instance = null;
	public static MyNotPassedExamsTable getInstance() {
		if(instance==null) {
			instance=new MyNotPassedExamsTable();
		}
		return instance;	
	}
	private MyNotPassedExamsTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableNotPassedExams());
	}
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(new Color(153,204,255));
		}else
			if (row%2==0) {
				c.setBackground(new Color(208,208,208));
			} else {
				c.setBackground(Color.WHITE);
			}
		return c;
	}
	public void initComponents() {
		getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("idSubject"));
		getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("nameSubject"));
		getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("yearOfStudy"));
	}
}
