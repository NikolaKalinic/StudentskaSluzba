package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import controller.ChairController;
import controller.ProfessorController;
import controller.StudentController;
import gui.MainFrame;
import model.ProfessorDB;
import model.SubjectDB;

public class MyApp {

	public static void main(String[] args) {
		MainFrame mf = MainFrame.getInstance();
		mf.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}			
			@Override
			public void windowClosing(WindowEvent e) {
				StudentController.getInstance().save();
				ProfessorController.getInstance().save();
				SubjectDB.getInstance().save();
				ChairController.getInstance().save();
			}
			@Override
			public void windowClosed(WindowEvent e) {}
			@Override
			public void windowActivated(WindowEvent e) {}
		});
		
	}

}
