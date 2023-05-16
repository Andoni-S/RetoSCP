package exceptions;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class EmptyFieldException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyFieldException() {
		super();
	}
	public EmptyFieldException(String msg) {
		super(msg);
	}
}
