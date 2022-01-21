package gui.professor;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JPanel;

import gui.MainFrame;

public class ProfessorEditDialog extends JDialog {
	
	/*
	 * Nema vise MyProfessorTable.rowIndex, sada koristis MyProfessorPanel.getInstance().getProfessorTable().getSelectedRow(), staticke su postale fabrika gresaka
	 * Ne mogu da pozovem dispose() nad panel pa zato koristim ono brdo getParenta()
	 * Nema vise set-ova, sada se koriste liste
	 */
	public ProfessorEditDialog() {
		super(MainFrame.getInstance(),"Izmena profesora",true);
		setSize(600,700);
		setResizable(false);
		setLocationRelativeTo(MainFrame.getInstance());
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel paneltop = new JPanel();
		paneltop.setPreferredSize(new Dimension(1,30));	
		panel.add(paneltop,BorderLayout.NORTH);
		MyEditingProfessorTabbedPane myptp = new MyEditingProfessorTabbedPane();
		panel.add(myptp);
		
		add(panel);
		setVisible(true);
	}



}
