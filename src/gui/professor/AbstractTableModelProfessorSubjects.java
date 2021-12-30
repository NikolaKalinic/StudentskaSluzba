package gui.professor;

import javax.swing.table.AbstractTableModel;

import model.ProfessorDB;


public class AbstractTableModelProfessorSubjects extends AbstractTableModel {
	
	public AbstractTableModelProfessorSubjects() {}

	@Override
	public int getRowCount() {
		return ProfessorDB.getInstance().getRow(MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow()).getCourseList().size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int column) {
		return ProfessorDB.getInstance().getSubjectColumnName(column);
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ProfessorDB.getInstance().getSubjectValueAt(rowIndex, columnIndex);
	}
	
	
	
}
