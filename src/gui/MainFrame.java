package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
	
	public MainFrame(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int sHeight = d.height;
		int sWidth = d.width;
		setSize(3*sWidth/4,3*sHeight/4);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Studenska služba");
		
		MyMenuBar mb = new MyMenuBar();
		this.setJMenuBar(mb);
		setVisible(true);
		
		
	}

}
