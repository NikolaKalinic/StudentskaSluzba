package gui;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.StudentController;
import model.StudentDB;

public class MyToolBar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		JButton create = new JButton();
		create.setToolTipText("Create entity");
		Image createImg = kit.getImage("images/create4.png");
		//Image resizedCreateImg = createImg.getScaledInstance(25, 24, java.awt.Image.SCALE_SMOOTH);
		create.setIcon(new ImageIcon(createImg));
		create.setBorderPainted(false);
		create.setFocusPainted(false);
		create.setBackground(Color.white);
		//create.getInputMap().put(KeyStroke.getKeyStroke("pressed");
        create.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(MyTabbedPane.getInstance().getSelectedIndex()==0) {
					MyAddingStudentDialog masd = new MyAddingStudentDialog();
				}
					
				
			}
		});
		
		add(create);
		
		addSeparator();
		
		JButton edit = new JButton();
		edit.setToolTipText("Edit entity");
		Image editImg = kit.getImage("images/edit4.png");
		//Image resizedEditImg = editImg.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
		edit.setIcon(new ImageIcon(editImg));
		edit.setBorderPainted(false);
		edit.setFocusPainted(false);
		edit.setBackground(Color.white);

		add(edit);
		
		addSeparator();
		
		JButton delete = new JButton();
		delete.setToolTipText("Delete entity");
		Image deleteImg = kit.getImage("images/delete4.png");
		//Image resizedDeleteImg = deleteImg.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
		delete.setIcon(new ImageIcon(deleteImg));
		delete.setBorderPainted(false);
		delete.setFocusPainted(false);
		delete.setBackground(Color.white);
		
		/*Listener for delete*/
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MyTabbedPane.getInstance().getSelectedIndex()==0)
					if(MyStudentTable.selectedRow < (StudentDB.getInstance().getStudents().size())) {
						StudentController.getInstance().deleteStudent(MyStudentTable.selectedRow);
						MyStudentTable.selectedRow=-1;
					}
				//else if(MyTabbedPane.getInstance().getSelectedIndex()==1)
					//TODO for profesor
				//else
					//TODO for subject
			}
		});
		
		add(delete);

		
		add(Box.createHorizontalGlue());
		
		
		addSeparator();
		
		JTextField searchField = new JTextField(10);
		searchField.setMaximumSize(searchField.getPreferredSize());
		searchField.setToolTipText("Type here");
		
		add(searchField);
	
		JButton loupe = new JButton();
		loupe.setToolTipText("Search");
		Image searchImg = kit.getImage("images/loupe.png");
		Image resizedSearchImg = searchImg.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);
		loupe.setIcon(new ImageIcon(resizedSearchImg));
		loupe.setBorderPainted(false);
		loupe.setFocusPainted(false);
		loupe.setBackground(Color.white);
		
		add(loupe);

		setFloatable(false);
		setBackground(new Color(255, 255, 255));
	}

}
