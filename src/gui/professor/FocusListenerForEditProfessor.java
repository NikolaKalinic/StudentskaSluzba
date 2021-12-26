package gui.professor;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class FocusListenerForEditProfessor implements FocusListener {

	
	public void focusGained(FocusEvent e) {
		JTextField tf = (JTextField) e.getComponent();
		tf.setBackground(Color.WHITE);
		ProfessorEditDialog.checkValidity();
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		ProfessorEditDialog.checkValidity();
	}
	
}
