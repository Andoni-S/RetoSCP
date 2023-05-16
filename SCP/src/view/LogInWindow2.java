package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import clases.Worker;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LogInWindow2 extends JFrame implements ActionListener {
	private JButton btnLogIn;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField passwordFieldPasswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInWindow2 frame = new LogInWindow2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInWindow2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(80, 45, 120, 30);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(80, 100, 120, 30);
		contentPane.add(lblPassword);

		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(190, 52, 180, 20);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogIn.setBounds(150, 185, 120, 45);
		contentPane.add(btnLogIn);
		btnLogIn.addActionListener(this);

		passwordFieldPasswd = new JPasswordField();
		passwordFieldPasswd.setBounds(190, 107, 180, 20);
		contentPane.add(passwordFieldPasswd);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnLogIn)) {
			if (textFieldUsername.getText().trim().isEmpty() || passwordFieldPasswd.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(btnLogIn, "Username/Password is Empty");
			} else {
				String usernameUsuario = textFieldUsername.getText();
				String passwordUsuario = passwordFieldPasswd.getText();

				Worker work = new Worker();
				
				if (work.logIn(usernameUsuario, passwordUsuario)) {
					MainWindow vMain = new MainWindow(usernameUsuario);
					//vMain.pack();
					vMain.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(btnLogIn, "Username/Password Incorrect");
				}
			}
		}
	}
}