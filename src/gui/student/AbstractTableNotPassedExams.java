package gui.student;

import javax.swing.table.AbstractTableModel;

import model.StudentDB;

public class AbstractTableNotPassedExams extends AbstractTableModel {

	public AbstractTableNotPassedExams() {}

	@Override
	public int getRowCount() {
		return StudentDB.getInstance().getRow(MyStudentPanel.getInstance().getStudentTable().convertRowIndexToModel(MyStudentPanel.getInstance().getStudentTable().getSelectedRow())).getFailedExams().size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(int column) {
		return StudentDB.getInstance().getNotPassedExamsColumnName(column);
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StudentDB.getInstance().getNotPassedExamsValueAt(rowIndex, columnIndex);
	}
	
	
}
