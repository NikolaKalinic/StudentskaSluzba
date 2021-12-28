package gui.student;

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
import javax.swing.JList;
import javax.swing.JPanel;

import gui.MainFrame;
import model.Subject;
import model.SubjectDB;

public class AddSubjectToStudent extends JDialog{
	
	public AddSubjectToStudent() {
		super(MainFrame.getInstance(),"Dodavanje predmeta",false);
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		setSize(new Dimension(500,400));
		
		
		setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.white);
		northPanel.setPreferredSize(new Dimension(1,50));
		add(northPanel,BorderLayout.NORTH);
		JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.white);
		westPanel.setPreferredSize(new Dimension(50,1));
		add(westPanel,BorderLayout.WEST);
		JPanel eastPanel = new JPanel();
		eastPanel.setBackground(Color.white);
		eastPanel.setPreferredSize(new Dimension(50,1));
		add(eastPanel,BorderLayout.EAST);
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		JButton btnOk = new JButton("Potvrdi");
		JButton btnCancel = new JButton("Odustani");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		southPanel.add(btnOk);
		southPanel.add(Box.createHorizontalStrut(50));
		southPanel.add(btnCancel);
		southPanel.setBackground(Color.white);
		southPanel.setPreferredSize(new Dimension(1,100));
		add(southPanel,BorderLayout.SOUTH);
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		Vector<Subject> subjects = new Vector<Subject>();
		
		for (int i =0 ; i<SubjectDB.getInstance().getSubjects().size();i++) {
			/*Prvi uslov je da se ne nalaze ni u listi položenih, kao ni u listi nepoloženih predmeta označenog studenta. 
			 * Drugi uslov je da je označeni student na odgovarajućoj godini studija (ista ili viša godina studija u odnosu na godinu na kojoj se predmet izvodi).
			 */
			subjects.add(SubjectDB.getInstance().getSubjects().get(i));
		}
		JList<Subject> listBox = new JList<Subject>(subjects);
		
		

		centerPanel.add(listBox);

		listBox.setSelectedIndex(0);
		
		add(centerPanel,BorderLayout.CENTER);
		setVisible(true);
	}
}
