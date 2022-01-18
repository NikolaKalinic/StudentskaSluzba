package gui.professor;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import gui.MainFrame;
import gui.subject.MySubjectTable;

public class MyProfessorTable extends JTable {

	private static final long serialVersionUID = 8900651367165240112L;
	
	private static MyProfessorTable instance = null;
	public static MyProfessorTable getInstance() {
		if(instance==null) {
			instance=new MyProfessorTable();
		}
		return instance;	
	}
	
	
	private MyProfessorTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfessors());
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
		getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("professorName"));
		getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("professorSurname"));
		getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("professorCalling"));
		getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("professorEmail"));
		
	}

}