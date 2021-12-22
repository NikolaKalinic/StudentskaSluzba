package gui.subject;

import javax.swing.table.AbstractTableModel;

import model.ProfessorDB;
import model.SubjectDB;

public class AbstractTableModelSubject extends AbstractTableModel {


	public AbstractTableModelSubject() {
	}

	// broj redova
	@Override
	public int getRowCount() {
		return SubjectDB.getInstance().getSubjects().size();
	}
	
	// broj kolona
	@Override
	public int getColumnCount() {
		return SubjectDB.getInstance().getColumnCount();
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return SubjectDB.getInstance().getColumnName(column);
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return SubjectDB.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
}

