package gui.subject;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import gui.MainFrame;
import gui.student.MyStudentPanel;
import model.StudentDB;

public class MySubjectTable extends JTable {

	private static final long serialVersionUID = 8900651367165240112L;

	private static MySubjectTable instance = null;
	public static MySubjectTable getInstance() {
		if(instance==null) {
			instance=new MySubjectTable();
		}
		return instance;	
	}
	
	private MySubjectTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelSubject());
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
		getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("idSubject"));
		getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("nameSubject"));
		getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("yearOfStudy"));
	}
}