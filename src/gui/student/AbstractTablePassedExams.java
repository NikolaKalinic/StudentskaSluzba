package gui.student;

import javax.swing.table.AbstractTableModel;

import model.StudentDB;

public class AbstractTablePassedExams extends AbstractTableModel {

	public AbstractTablePassedExams() {}

	@Override
	public int getRowCount() {
		return StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().getSelectedRow()).getGrades().size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(int column) {
		return StudentDB.getInstance().getPassedExamsColumnName(column);
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StudentDB.getInstance().getPassedExamsValueAt(rowIndex, columnIndex);
	}
	
	
}
