package gui;

import javax.swing.table.AbstractTableModel;

import model.StudentDB;

public class AbstractTableModelStudent extends AbstractTableModel{
	
	public AbstractTableModelStudent() {}


	@Override
	public int getRowCount() {
		return StudentDB.getInstance().getStudents().size();
	}
	
	@Override
	public int getColumnCount() {
		return StudentDB.getInstance().getColumnCount();
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return StudentDB.getInstance().getColumnName(column);
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StudentDB.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
