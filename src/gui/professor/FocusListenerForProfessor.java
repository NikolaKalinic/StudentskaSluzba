package gui.professor;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class FocusListenerForProfessor implements FocusListener {

	
	public void focusGained(FocusEvent e) {
		JTextField tf = (JTextField) e.getComponent();
		tf.setBackground(Color.WHITE);
		try {
			ProfessorDialog.checkValidity();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		try {
			ProfessorDialog.checkValidity();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
