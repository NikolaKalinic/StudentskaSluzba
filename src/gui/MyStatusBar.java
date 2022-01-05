package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class MyStatusBar {
	public MyStatusBar(MainFrame mf) {
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		mf.add(statusPanel,BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(mf.getWidth(), 20));
		BoxLayout box = new BoxLayout(statusPanel, BoxLayout.X_AXIS);
		statusPanel.setLayout(box);
		JLabel statusLabel = new JLabel("Studentska Slu�ba-Studenti");
		
		MyTabbedPane.getInstance().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if(MyTabbedPane.getInstance().getSelectedIndex()==0)
					statusLabel.setText("Studentska Služba-Studenti");
				else if(MyTabbedPane.getInstance().getSelectedIndex()==1)
					statusLabel.setText("Studentska Služba-Profesori");
				else if(MyTabbedPane.getInstance().getSelectedIndex()==2)
					statusLabel.setText("Studentska Služba-Predmeti");
				else 
					statusLabel.setText("Studentska Služba-Katedre");
			}
		});
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusPanel.add(statusLabel);
		statusPanel.add(Box.createGlue());

            
		 DateFormat dateFormat = new SimpleDateFormat("HH:mm dd.MM.yyyy.");
		 Calendar cal = Calendar.getInstance();
		 JLabel statusTime = new JLabel(dateFormat.format(cal.getTime()));
		
		 /*taken from stackoverflow*/
		new Timer(1000, new ActionListener() {						
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            Calendar cal = Calendar.getInstance();
	           statusTime.setText(dateFormat.format(cal.getTime()));
	        }
	    }).start();
		
	   	 statusPanel.add(statusTime);
	   	 statusPanel.add(Box.createHorizontalStrut(20));
	}
	
	
}