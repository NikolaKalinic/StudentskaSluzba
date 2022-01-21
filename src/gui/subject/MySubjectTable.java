package gui.subject;

import java.awt.Color;
import java.awt.Component;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import gui.MainFrame;
import gui.professor.AbstractTableModelProfessors;
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
	
	public static TableRowSorter myTableRowSorter;
	
	private MySubjectTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelSubject());
		myTableRowSorter = new TableRowSorter(new AbstractTableModelSubject());
		this.setRowSorter(myTableRowSorter);
		myTableRowSorter.setComparator(2, comparator2);
		myTableRowSorter.setComparator(0, comparator1);
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
	
	Comparator comparator1 = new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			String string1[] = o1.toString().split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)"); // splits letter from numbers
			String string2[] = o2.toString().split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
			int cmp = string1[0].compareTo(string2[0]);
			int cmp2 = Integer.valueOf(string1[1]).compareTo(Integer.valueOf(string2[1]));
			if (cmp == 0) {
				return cmp2;
			} else {
				return cmp;
			}
		}	
	};
	
	
	
	
	
	Comparator comparator2 = new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			Integer int1 = Integer.valueOf(o1.toString());
			Integer int2 = Integer.valueOf(o2.toString());
			return int1.compareTo(int2);
		}
		
		public boolean equals(Object o2) {
			return this.equals(o2);
		}
		
	};
	public void initComponents() {
		getColumnModel().getColumn(0).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("idSubject"));
		getColumnModel().getColumn(1).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("nameSubject"));
		getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("yearOfStudy"));
	}
}