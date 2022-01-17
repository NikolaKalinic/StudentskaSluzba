package gui.chair;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import gui.MainFrame;
import model.Chair;
import model.Professor;

public class ChooseChiefDialog extends JDialog {

	private JButton btnOk;
	private JButton btnCancel;
	public ChooseChiefDialog(Chair c,JTextField f) {
		super(MainFrame.getInstance(),"Postavi šefa",true);
		getContentPane().setBackground(Color.white);
		setResizable(false);
		setSize(new Dimension(300,350));
		setLocationRelativeTo(MainFrame.getInstance());
		setLayout(new BorderLayout());
		
		JPanel top = new JPanel();
		top.setPreferredSize(new Dimension(1,25));
		top.setBackground(Color.white);
//		JLabel lab= new JLabel("Izaberite šefa:");
//		top.add(lab);
		add(top,BorderLayout.NORTH);
		JPanel bot = new JPanel();
		bot.setPreferredSize(new Dimension(1,50));
		bot.setBackground(Color.white);

		
		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		center.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		btnOk = new JButton("Postavi");
		Vector<Professor> p = new Vector<Professor>();
		boolean tmp ;
		for(int i =0 ; i<c.getProfessors().size();i++) {
			tmp=true;
			if(c.getProfessors().get(i).getExperience()<5)
				tmp=false;
			if(c.getProfessors().get(i).getCalling()!="REDOVNI_PROFESOR" && c.getProfessors().get(i).getCalling()!="VANREDNI_PROFESOR")
				tmp=false;
			if(tmp)
				p.add(c.getProfessors().get(i));
		}
		if(p.size()<=0) {
			JLabel lab= new JLabel("Ni jedan profesor ne ispunjava uslov da bude šef.");
			btnOk.setEnabled(false);
			top.add(lab);
		}else {
			JLabel lab= new JLabel("Izaberite šefa:");
			top.add(lab);
		}
		JList<Professor> listBox = new JList<Professor>(p);
		JScrollPane jsp = new JScrollPane(listBox);
		center.add(jsp,BorderLayout.CENTER);
		add(center,BorderLayout.CENTER);
		
		
		
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listBox.getSelectedIndex()!=-1) {
					c.setHeadOfChair(listBox.getSelectedValue());
					f.setText(listBox.getSelectedValue().getProfNameAndSurname());
					dispose();
				}
			}
		});
		btnCancel = new JButton("Odustani");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		bot.add(btnOk);
		bot.add(Box.createHorizontalStrut(30));
		bot.add(btnCancel);
		add(bot,BorderLayout.SOUTH);
		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(25,1));
		east.setBackground(Color.white);
		add(east,BorderLayout.EAST);
		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(25,1));
		west.setBackground(Color.white);
		add(west,BorderLayout.WEST);
		
		
		setVisible(true);
		
	}
}
