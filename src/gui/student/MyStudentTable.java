package gui.student;

import java.awt.Color;
import java.awt.Component;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class MyStudentTable extends JTable {
	public static TableRowSorter trs;
	public MyStudentTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudent());
		trs = new TableRowSorter(new AbstractTableModelStudent());
		this.setRowSorter(trs);
		trs.setComparator(0, c1);
	}
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(new Color(153,204,255));
		}else
			if (row%2==0) {
				c.setBackground(Color.LIGHT_GRAY);
			} else {
				c.setBackground(Color.WHITE);
			}
		return c;
	}
	
	Comparator c1 = new Comparator() {

		@Override
		public int compare(Object oo1, Object oo2) {
			String o1=oo1.toString();
			String o2=oo2.toString();
			
			
			int intCompare1 = o1.split(" ")[0].compareTo((o2.split(" ")[0]));
			if (intCompare1 == 0) {
				int intCompare2 = Integer.valueOf(o1.split("/")[1]).compareTo(Integer.valueOf(o2.split("/")[1]));
				if (intCompare2 == 0) {
					int intCompare3 = Integer.valueOf(o1.split(" ")[1].split("/")[0]).compareTo(Integer.valueOf(o2.split(" ")[1].split("/")[0]));
					if (intCompare3 == 0) {
						return o1.compareToIgnoreCase(o2);
					}else
						return intCompare3;
                }
                return intCompare2;
			}else
				return intCompare1;
		}
		
	};
}
