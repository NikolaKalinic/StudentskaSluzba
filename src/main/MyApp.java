package main;

import java.time.LocalDate;
import java.util.Scanner;

import controller.StudentController;
import gui.MainFrame;
import model.Adress;
import model.Status;
import model.StudentDB;

public class MyApp {

	public static void main(String[] args) {
		StudentDB dbs= StudentDB.getInstance();
		StudentController sc= StudentController.getInstance();
		MainFrame mf = MainFrame.getInstance();
			
	}

}
