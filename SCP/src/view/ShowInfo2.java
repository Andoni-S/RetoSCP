package view;

import javax.swing.JPanel;
import javax.swing.JButton;

public class ShowInfo2 extends JPanel {
	// This window will be displayed when pressing the "show info" button from
	// delete worker or delete SCP
	public ShowInfo2() {
		setLayout(null);

		JButton btnNewButton = new JButton("BOTÓN");
		btnNewButton.setBounds(158, 115, 343, 200);
		add(btnNewButton);
	}
}
