package gui;

import javax.swing.table.AbstractTableModel;

import model.ProfessorDB;

public class AbstractTableModelProfessors extends AbstractTableModel {


	public AbstractTableModelProfessors() {
	}

	// broj redova
	@Override
	public int getRowCount() {
		return ProfessorDB.getInstance().getProfessors().size();
	}
	
	// broj kolona
	@Override
	public int getColumnCount() {
		return ProfessorDB.getInstance().getColumnCount();
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return ProfessorDB.getInstance().getColumnName(column);
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ProfessorDB.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
}

