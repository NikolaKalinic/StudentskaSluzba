package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu.Separator;

public class About extends JDialog{
	public About() {
		super(MainFrame.getInstance(),MainFrame.getInstance().getResourceBundle().getString("miAbout"),true);
		setSize(300,200);
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		setLayout(new BorderLayout());
		JPanel north = new JPanel();
		JLabel lab1= new JLabel(MainFrame.getInstance().getResourceBundle().getString("biography"));
		north.setLayout(new BorderLayout());
		north.add(lab1,BorderLayout.WEST);
		north.setBackground(Color.LIGHT_GRAY);
		north.setPreferredSize(new Dimension(1,15));
		add(north,BorderLayout.NORTH);
		JPanel center = new JPanel();
		JLabel lab6 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("author")+" 1:   ");
		JLabel lab2 = new JLabel("Nikola Kalinić "+MainFrame.getInstance().getResourceBundle().getString("from") +" Inđije "+MainFrame.getInstance().getResourceBundle().getString("born") +" 07.12.2000.");
		JLabel lab3 = new JLabel("                "+MainFrame.getInstance().getResourceBundle().getString("contact")+" kalinic.ra71.2019@uns.ac.rs");
		JLabel lab7 = new JLabel(MainFrame.getInstance().getResourceBundle().getString("author")+" 2:");
		JLabel lab4 = new JLabel("Aleksa Ignjatović "+MainFrame.getInstance().getResourceBundle().getString("from") +" Loznice "+MainFrame.getInstance().getResourceBundle().getString("born") +" 18.10.2000.");
		JLabel lab5 = new JLabel("                "+MainFrame.getInstance().getResourceBundle().getString("contact")+" ignjatovic.ra85.2019@uns.ac.rs");
		center.setLayout(new FlowLayout(FlowLayout.LEFT));
		center.add(lab6);
		center.add(lab2);
		center.add(lab3);
		center.add(lab7);
		center.add(lab4);
		center.add(lab5);
		add(center,BorderLayout.CENTER);
		
		JPanel south= new JPanel();
		JLabel lab = new JLabel(MainFrame.getInstance().getResourceBundle().getString("version")+" v1.0   ");
		south.setLayout(new BorderLayout());
		south.add(lab,BorderLayout.EAST);
		south.setBackground(Color.LIGHT_GRAY);
		south.setPreferredSize(new Dimension(1,15));
		add(south,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
}
