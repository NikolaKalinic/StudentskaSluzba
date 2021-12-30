package gui.professor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.nio.ByteOrder;

import javax.swing.JButton;
import javax.swing.JPanel;



public class ProfessorSubjects extends JPanel {

private static ProfessorSubjects instance = null;
	
	public static ProfessorSubjects getInstance() {
		if (instance == null) {
			instance = new ProfessorSubjects();
		}
		return instance;
	}
	private ProfessorSubjects() {
		setLayout(new BorderLayout());
		JPanel panTop = new JPanel();
		panTop.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		panTop.setBackground(Color.white);
		JButton button1 = new JButton("Dodaj predmet");
		JButton button2 = new JButton("Ukloni predmet");
		button1.setBackground(new Color(14,98,190));
		button1.setForeground(Color.white);
		button2.setBackground(new Color(14,98,190));
		button2.setForeground(Color.white);
		panTop.add(button1);
		panTop.add(button2);
		
		add(panTop,BorderLayout.NORTH);
		
		JPanel cLeft = new JPanel();
		cLeft.setBackground(Color.white);
		cLeft.setPreferredSize(new Dimension(20,1));
		JPanel cRight = new JPanel();
		cRight.setBackground(Color.white);
		cRight.setPreferredSize(new Dimension(20,1));
		add(cLeft,BorderLayout.EAST);
		add(cRight,BorderLayout.WEST);
		
		
		JPanel panBottom = new JPanel();
		panBottom.setBackground(Color.white);
		panBottom.setPreferredSize(new Dimension(1,100));
		add(panBottom,BorderLayout.SOUTH);
	}
}
