package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Locale;

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

	JLabel statusLabel;
	private DateFormat format;
	private  DateTimeFormatter dateFormat;
	
	public MyStatusBar(MainFrame mf) {
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		mf.add(statusPanel,BorderLayout.SOUTH);
		statusPanel.setPreferredSize(new Dimension(mf.getWidth(), 20));
		BoxLayout box = new BoxLayout(statusPanel, BoxLayout.X_AXIS);
		statusPanel.setLayout(box);
		 statusLabel = new JLabel(MainFrame.getInstance().getResourceBundle().getString("statusStudent"));
		
		MyTabbedPane.getInstance().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if(MyTabbedPane.getInstance().getSelectedIndex()==0)
					statusLabel.setText(MainFrame.getInstance().getResourceBundle().getString("statusStudent"));
				else if(MyTabbedPane.getInstance().getSelectedIndex()==1)
					statusLabel.setText(MainFrame.getInstance().getResourceBundle().getString("statusProfessor"));
				else if(MyTabbedPane.getInstance().getSelectedIndex()==2)
					statusLabel.setText(MainFrame.getInstance().getResourceBundle().getString("statusSubject"));
				else 
					statusLabel.setText(MainFrame.getInstance().getResourceBundle().getString("statusChair"));
			}
		});
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusPanel.add(statusLabel);
		statusPanel.add(Box.createGlue());

     
		
		dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		format = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.getDefault());
		Calendar cal = Calendar.getInstance();
		 JLabel statusTime = new JLabel(format.format(cal.getTime())+ " "+LocalDate.now().format(dateFormat));
		
		 /*taken from stackoverflow*/
		new Timer(1000, new ActionListener() {						
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            Calendar cal = Calendar.getInstance();
	           statusTime.setText(format.format(cal.getTime()) + " "+LocalDate.now().format(dateFormat));
	        }
	    }).start();
		
	   	 statusPanel.add(statusTime);
	   	 statusPanel.add(Box.createHorizontalStrut(20));
	}
	public void initComponents() {
		{
			if(MyTabbedPane.getInstance().getSelectedIndex()==0)
				statusLabel.setText(MainFrame.getInstance().getResourceBundle().getString("statusStudent"));
			else if(MyTabbedPane.getInstance().getSelectedIndex()==1)
				statusLabel.setText(MainFrame.getInstance().getResourceBundle().getString("statusProfessor"));
			else if(MyTabbedPane.getInstance().getSelectedIndex()==2)
				statusLabel.setText(MainFrame.getInstance().getResourceBundle().getString("statusSubject"));
			else 
				statusLabel.setText(MainFrame.getInstance().getResourceBundle().getString("statusChair"));
			dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
			format = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.getDefault());
		}
	}
	
	
}