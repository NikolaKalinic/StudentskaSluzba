package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
	
	private static MainFrame instance = null;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	private MainFrame(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int sHeight = d.height;
		int sWidth = d.width;
		setSize(3*sWidth/4,3*sHeight/4);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Studenska služba");
		
		MyMenuBar mb = new MyMenuBar();
		MyToolBar tb = new MyToolBar();
		this.setJMenuBar(mb);
		
		add(tb, BorderLayout.NORTH);
		////////////////
		
	
		MyTabPane tp = new MyTabPane();
		add(tp,BorderLayout.CENTER);
		
		
		
		
		
		/////////
		MyStatusBar sb = new MyStatusBar(this);
		
		setVisible(true);
		
		
	}

}
