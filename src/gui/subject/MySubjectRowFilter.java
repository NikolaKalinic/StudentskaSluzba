package gui.subject;

import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;

public class MySubjectRowFilter extends RowFilter {
	
	private String searchText;
	
	public MySubjectRowFilter(String searchText) {
		this.searchText = searchText;
	}
	
	public boolean include(Entry entry) {
		
		 String[] split = searchText.split(",");
		 for(int i =0;i < split.length ;i++) {
			 if(split[i].trim().length() == 0)
				 return true;
		 }
		 
		 if(split.length == 1) {
			 split[0] = split[0].trim();
			 boolean bool1 = entry.getStringValue(1).indexOf(split[0].substring(0, 1).toUpperCase() + split[0].substring(1).toLowerCase()) >= 0;
			 boolean bool2 = entry.getStringValue(1).indexOf(split[0].trim().toLowerCase()) >=0;
			 return bool1 | bool2;
		 }else if(split.length == 2) {
			 split[0]=split[0].trim();
			 split[1]=split[1].trim();
			 boolean bool1 = entry.getStringValue(1).indexOf(split[0].trim().toLowerCase()) >= 0;
			 boolean bool2= entry.getStringValue(1).indexOf(split[0].substring(0, 1).toUpperCase()+split[0].substring(1).toLowerCase()) >= 0;
			 
			 boolean bool3 = entry.getStringValue(0).indexOf(split[1].trim().toLowerCase()) >= 0;
			 
			 return (bool1 | bool2) & bool3;
		 }
		 else
			 return false;
	}
}
