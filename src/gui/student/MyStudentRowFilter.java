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
			 boolean b2= entry.getStringValue(2).indexOf(split[0].substring(0, 1).toUpperCase()+split[0].substring(1).toLowerCase()) >=0;
			 boolean b1=entry.getStringValue(2).indexOf(split[0].trim().toLowerCase()) >=0;
			 return b1 | b2;
		 }else if(split.length==2) {
			 int first = entry.getStringValue(2).indexOf(split[0].trim().toLowerCase());
			 boolean b2= entry.getStringValue(2).indexOf(split[0].substring(0, 1).toUpperCase()+split[0].substring(1).toLowerCase()) >=0;
			 
			 int second = entry.getStringValue(1).indexOf(split[1].trim().toLowerCase());
			 boolean b3= entry.getStringValue(1).indexOf(split[1].substring(0, 1).toUpperCase()+split[1].substring(1).toLowerCase()) >=0;
			 
			 return ((first>=0)|b2) & ((second>=0)|b3);
		 }else if(split.length==3) {
			 int first = entry.getStringValue(0).indexOf(split[0].toUpperCase().trim());
			 
			 int second = entry.getStringValue(1).indexOf(split[1].trim().toLowerCase());
			 boolean b3= entry.getStringValue(1).indexOf(split[1].substring(0, 1).toUpperCase()+split[1].substring(1).toLowerCase()) >=0;
			 
			 int third = entry.getStringValue(2).indexOf(split[2].trim().substring(1).toLowerCase());
			 boolean b2= entry.getStringValue(2).indexOf(split[2].substring(0, 1).toUpperCase()+split[2].substring(1).toLowerCase()) >=0;
			return (first >=0 && ((second >=0)|(b3)) && ((third >=0)|(b2))); 
		 }
		 else
			 return false;
	}

}
