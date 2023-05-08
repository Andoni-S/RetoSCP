package exceptions;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class EmptyFieldException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyFieldException(JButton btnLogIn, String msg) {
		JOptionPane.showMessageDialog(btnLogIn, msg);
	}
}
