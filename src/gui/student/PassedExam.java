package gui.student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PassedExam extends JPanel{

	PassedExam(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		/*top panel for button*/
		JPanel panTop = new JPanel();
		int width=kit.getScreenSize().width/30;
		int height=kit.getScreenSize().width/60;
		panTop.setLayout(new FlowLayout(FlowLayout.LEFT,width,height));
		panTop.setBackground(Color.magenta);
		panTop.setPreferredSize(new Dimension(kit.getScreenSize().width/3,kit.getScreenSize().height/15));
		JButton button = new JButton("Poništi ocenu");
		button.setBackground(new Color(14,98,190));
		button.setForeground(Color.white);
		panTop.add(button,FlowLayout.LEFT);
		panel.add(panTop,BorderLayout.NORTH);
		
		
		
		
		/*center panel for table*/
		JPanel panCenter = new JPanel();
		panCenter.setLayout(new BorderLayout());
		JPanel cLeft = new JPanel();
		cLeft.setPreferredSize(new Dimension(width,1));
		JPanel cRight = new JPanel();
		cRight.setPreferredSize(new Dimension(width,1));
		panCenter.setPreferredSize(new Dimension(kit.getScreenSize().width/3,kit.getScreenSize().height/2-kit.getScreenSize().height/6));
		panCenter.setBackground(Color.cyan);
		panCenter.add(cLeft,BorderLayout.EAST);
		panCenter.add(cRight,BorderLayout.WEST);
		panel.add(panCenter,BorderLayout.CENTER);
		
		
		
		
		/*bot panel for label*/
		JPanel panBottom = new JPanel();
		panBottom.setLayout(new BorderLayout());
		panBottom.setBackground(Color.green);
		panBottom.setPreferredSize(new Dimension(kit.getScreenSize().width/3,kit.getScreenSize().height/10));
		JLabel label1 = new JLabel("Prosečna ocena: ");
		JLabel label2 = new JLabel("Prosečna ESPB: ");
		
		JPanel panLabel = new JPanel();
		panLabel.setPreferredSize(new Dimension(kit.getScreenSize().width/8,kit.getScreenSize().height/10));
		panLabel.setLayout(new BorderLayout());
		panLabel.add(label1,BorderLayout.NORTH);
		
		JPanel margin = new JPanel();
		margin.setPreferredSize(new Dimension(kit.getScreenSize().width/8,kit.getScreenSize().height/10));
		margin.setLayout(new BorderLayout());
		panLabel.add(margin,BorderLayout.CENTER);
		margin.add(label2,BorderLayout.NORTH);
		
		
		
		
		
		
		panBottom.add(panLabel,BorderLayout.EAST);
		panel.add(panBottom,BorderLayout.SOUTH);
		add(panel);
		
	}
}
