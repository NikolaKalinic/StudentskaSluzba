package gui.professor;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import gui.MainFrame;
import gui.subject.MySubjectTable;


public class MyProfessorSubjectsTabel extends JTable {
	
	private static MyProfessorSubjectsTabel instance = null;
	public static MyProfessorSubjectsTabel getInstance() {
		if(instance==null) {
			instance=new MyProfessorSubjectsTabel();
		}
		return instance;	
	}
	
	
	private MyProfessorSubjectsTabel() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		this.setModel(new AbstractTableModelProfessorSubjects());
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
		getColumnModel().getColumn(2).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("yearOfStudy"));
		getColumnModel().getColumn(3).setHeaderValue(MainFrame.getInstance().getResourceBundle().getString("semesterSubject"));
		
	}

}
