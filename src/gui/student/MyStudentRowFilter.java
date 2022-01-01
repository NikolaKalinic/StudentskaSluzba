package gui.student;

import javax.swing.RowFilter;

public class MyStudentRowFilter extends RowFilter {
	private String searchText;
	
	public MyStudentRowFilter(String searchText) {
		this.searchText=searchText;
	}
	
	@Override
	public boolean include(Entry entry) {
		 String[] split = searchText.split(",");
		 for(int i =0 ;i<split.length;i++) {
			 if(split[i].trim().length()==0)
				 return true;
		 }
		 if(split.length==1) {
			 //return entry.getStringValue(2).indexOf(split[0].substring(0, 1).toUpperCase()+split[0].substring(1).toLowerCase()) >=0;
			 return entry.getStringValue(2).indexOf(split[0].trim().substring(1).toLowerCase()) >=0;
		 }else if(split.length==2) {
			 int first = entry.getStringValue(2).indexOf(split[0].trim().substring(1).toLowerCase());
			 int second = entry.getStringValue(1).indexOf(split[1].trim().substring(1).toLowerCase());
			 if(first >=0 && second >=0) {
				 return true;
			 }else {
				 return false;
			 }
		 }else if(split.length==3) {
			 int third = entry.getStringValue(2).indexOf(split[2].trim().substring(1).toLowerCase());
			 int second = entry.getStringValue(1).indexOf(split[1].trim().substring(1).toLowerCase());
			 int first = entry.getStringValue(0).indexOf(split[0].toUpperCase().trim());
			 if(first >=0 && second >=0 && third >=0) {
				 return true;
			 }else {
				 return false;
			 }
		 }
		 else
			 return false;
	}

}
