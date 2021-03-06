package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MyTabPane extends JPanel{

	
	
	public MyTabPane() {
		setLayout(new BorderLayout());
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int sWidth = d.width;
		
		JPanel tabNorth = new JPanel();
		tabNorth.setPreferredSize(new Dimension(3*sWidth/4,20));
		add(tabNorth,BorderLayout.NORTH);
		
		JPanel tabWest = new JPanel();
		tabWest.setPreferredSize(new Dimension(30,50));
		add(tabWest,BorderLayout.WEST);
		
		JPanel tabEast = new JPanel();
		tabEast.setPreferredSize(new Dimension(30,50));
		add(tabEast,BorderLayout.EAST);
		
		JPanel tabSouth = new JPanel();
		tabSouth.setPreferredSize(new Dimension(3*sWidth/4,20));
		add(tabSouth,BorderLayout.SOUTH);
		
		MyTabbedPane tp = MyTabbedPane.getInstance();
		add(tp,BorderLayout.CENTER);
	}
	
	public void initComponents() {
		MyTabbedPane.getInstance().initComponents();
	}
}
