package gui.chair;

import javax.swing.table.AbstractTableModel;

import model.ChairDB;

public class AbstractTableModelChair extends AbstractTableModel {

	
	public AbstractTableModelChair() {
	}

	@Override
	public int getRowCount() {
		return ChairDB.getInstance().getChairs().size();
	}
	
	@Override
	public int getColumnCount() {
		return ChairDB.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return ChairDB.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ChairDB.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
