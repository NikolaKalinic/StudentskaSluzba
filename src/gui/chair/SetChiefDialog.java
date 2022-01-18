package gui.chair;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ChairController;
import gui.MainFrame;
import model.Chair;

public class SetChiefDialog extends JDialog {
	
	public SetChiefDialog() {
		super(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("chairInfo"),true);
		Chair c = ChairController.getInstance().getSelectedChair(MyChairPanel.getInstance().getChairTable().getSelectedRow());
		Color color= getContentPane().getBackground();
		getContentPane().setBackground(Color.white);
		setResizable(false);
		setSize(new Dimension(400,450));
		setLocationRelativeTo(MainFrame.getInstance());
		setLayout(new BorderLayout());
		
		
		/*Top panel for information about chair*/
		JPanel panTop = new JPanel();
		panTop.setLayout(new FlowLayout(FlowLayout.CENTER,20,15));
		JLabel lCode = new JLabel(MainFrame.getInstance().getResourceBundle().getString("chairId") + " " + c.getIdChair());
		panTop.add(lCode);
		JLabel lName = new JLabel(MainFrame.getInstance().getResourceBundle().getString("chairName") + " " + c.getNameOfChair());
		panTop.add(lCode);
		panTop.add(lName);
		panTop.setPreferredSize(new Dimension(1,50));
		panTop.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		panTop.setBackground(Color.white);
		add(panTop,BorderLayout.NORTH);
		
		
		/*center panel*/
		JPanel panCen = new JPanel();
		panCen.setBackground(Color.white);
		panCen.setLayout(new BorderLayout());
		panCen.setBackground(Color.white);
		JPanel cenEast = new JPanel();
		cenEast.setPreferredSize(new Dimension(20,1));
		cenEast.setBackground(Color.white);
		panCen.add(cenEast,BorderLayout.EAST);
		JPanel cenWest = new JPanel();
		cenWest.setPreferredSize(new Dimension(20,1));
		cenWest.setBackground(Color.white);
		panCen.add(cenWest,BorderLayout.WEST);
		
		JButton button1 = new JButton(MainFrame.getInstance().getResourceBundle().getString("setChief"));
		JTextField f = new JTextField();
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(c.getProfessors().size()==0) {
					JOptionPane.showConfirmDialog(null, MainFrame.getInstance().getResourceBundle().getString("noProfessorInChair")," ",JOptionPane.DEFAULT_OPTION);
				}else {
					if(!f.getText().equals("")) {
						int a = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni da zelite da smenite trenutnog šefa ?", "Smena šefa", JOptionPane.YES_NO_OPTION);
						if (a == JOptionPane.YES_OPTION) {
							ChooseChiefDialog ccd = new ChooseChiefDialog(c,f);
							MyChairPanel.getInstance().updateView();
						}
					}else {
						ChooseChiefDialog ccd = new ChooseChiefDialog(c,f);
						MyChairPanel.getInstance().updateView();
					}
				}
			}
		});
		button1.setFocusPainted(false);
		JButton button2 = new JButton(MainFrame.getInstance().getResourceBundle().getString("chairRemove1"));
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c.setHeadOfChair(null);
				f.setText("");
				MyChairPanel.getInstance().updateView();
			}
		});
		button2.setFocusPainted(false);
		
		
		
		JPanel cenNorth = new JPanel();
		cenNorth.setLayout(new FlowLayout(FlowLayout.LEFT,20,25));
		cenNorth.setPreferredSize(new Dimension(1,50));
		cenNorth.setBackground(Color.white);
		cenNorth.add(Box.createHorizontalStrut(25));
		cenNorth.add(button1);
		cenNorth.add(button2);
		panCen.add(cenNorth,BorderLayout.NORTH);
		
		JPanel cenSouth = new JPanel();
		cenSouth.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		cenSouth.setPreferredSize(new Dimension(1,50));
		cenSouth.setBackground(Color.white);
		f.setFocusable(false);
		if(c.getHeadOfChair()!=null)
			f.setText(c.getHeadOfChair().getProfNameAndSurname());
		f.setPreferredSize(new Dimension(167,25));
		JLabel lChief = new JLabel(MainFrame.getInstance().getResourceBundle().getString("chairChief"));
		cenSouth.add(lChief);
		cenSouth.add(f);
		panCen.add(cenSouth,BorderLayout.SOUTH);
		add(panCen,BorderLayout.CENTER);
		
		/* bot panel with  professor list*/
		JPanel panBot = new JPanel();
		panBot.setPreferredSize(new Dimension(1,250));
		panBot.setBackground(Color.white);
		panBot.setLayout(new BorderLayout());
		JPanel botSouth = new JPanel();
		botSouth.setPreferredSize(new Dimension(1,20));
		botSouth.setBackground(Color.white);
		panBot.add(botSouth,BorderLayout.SOUTH);
		JPanel botEast = new JPanel();
		botEast.setPreferredSize(new Dimension(20,1));
		botEast.setBackground(Color.white);
		panBot.add(botEast,BorderLayout.EAST);
		JPanel botWest = new JPanel();
		botWest.setPreferredSize(new Dimension(20,1));
		botWest.setBackground(Color.white);
		panBot.add(botWest,BorderLayout.WEST);
		
		JPanel botCenter = new JPanel();
		botCenter.setLayout(new BorderLayout());
		botCenter.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		Vector<String> p = new Vector<String>();
		int j=1;
		for(int i =0 ; i<c.getProfessors().size();i++) {
			p.add(j+". "+c.getProfessors().get(i).getProfNameAndSurname());
			++j;
		}
		if(p.size()<=0) {
			JLabel lab = new JLabel("      " + MainFrame.getInstance().getResourceBundle().getString("chairPopUp1") + " ");
			panBot.add(lab,BorderLayout.NORTH);
		}else {
			JLabel lab = new JLabel("      " + MainFrame.getInstance().getResourceBundle().getString("chairPopUp2") + " ");
			panBot.add(lab,BorderLayout.NORTH);
		}
		JList<String> listBox = new JList<String>(p);
		listBox.setBackground(color);
		botCenter.add(listBox);
		panBot.add(botCenter,BorderLayout.CENTER);
		add(panBot,BorderLayout.SOUTH);
		
		
		setVisible(true);
	}

}
