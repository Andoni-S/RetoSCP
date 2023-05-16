package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import clases.Worker;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LoginWindow extends JFrame implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JPanel contentPane;
	private JLabel component;
	private int usery;
	private int logoy;
	private JLabel scpLogo;
	private JLabel background;
	private ActionListener labelAnim;
	private JTextField userField;
	private JPasswordField passwordField;
	private JButton btnLogIn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginWindow.class.getResource("/resources/icon.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		// adapta la ventana a la pantalla
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		usernameLabel = new JLabel("Username");
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 28));
		usernameLabel.setBounds(250, 950, 500, 32);
		contentPane.add(usernameLabel);

		passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 28));
		passwordLabel.setBounds(250, 1200, 500, 40);
		contentPane.add(passwordLabel);

		userField = new JTextField();

	   userField.setForeground(new Color(255, 255, 255));
		userField.setBackground(new Color(0, 0, 0));

		userField.setBounds(400, 1000, 300, 32);
		userField.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		contentPane.add(userField);
		userField.setColumns(10);
		userField.setFocusable(true);

		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBackground(new Color(0, 0, 0));

		passwordField.setBounds(400, 1200, 300, 33);
		passwordField.addKeyListener(this);
		contentPane.add(passwordField);

		scpLogo = new JLabel("scp");
		scpLogo.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/MEDIUM_White.png")));
		scpLogo.setBounds(100, -550, 800, 800);
		contentPane.add(scpLogo);

		background = new JLabel("bg");
		background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
		background.setBounds(0, 0, 1024, 768);
		contentPane.add(background);

		labelAnim = new LabelAnim();
		logoy = scpLogo.getY();
		usery = usernameLabel.getY();
		timer = new Timer(1, labelAnim);

		btnLogIn = new JButton("LOG IN");
		btnLogIn.setFont(new Font("OCR A EXTENDED", Font.BOLD, 16));
		btnLogIn.setBackground(new Color(0, 0, 0));
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setBounds(480, 600, 120, 45);
		contentPane.add(btnLogIn);
		btnLogIn.addActionListener(this);

		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnLogIn)) {
			if (userField.getText().isEmpty() || passwordField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(btnLogIn, "Username/Password is Empty");
			} else {
				String usernameUsuario = userField.getText();
				String passwordUsuario = passwordField.getText();

				Worker work = new Worker();

				if (work.logIn(usernameUsuario, passwordUsuario)) {
					MainWindow vMain = new MainWindow(usernameUsuario);
					vMain.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(btnLogIn, "Username/Password Incorrect");
				}
			}
		}
	}
	class LabelAnim implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			moveLabel();
			moveLogo();
		}

		private void moveLogo() {
			logoy += 5;
			scpLogo.setLocation(scpLogo.getX(), logoy);

			/*
			 * if (logoy >= 50) { timer.stop(); }
			 */
		}

		private void moveLabel() {
			usery -= 7;
			// component.setVisible(false);
			usernameLabel.setLocation(usernameLabel.getX(), usery);
			passwordLabel.setLocation(passwordLabel.getX(), usery + 50);
			userField.setLocation(userField.getX(), usery);
			passwordField.setLocation(passwordField.getX(), usery + 50);

			if (usery <= 450) {
				timer.stop();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_ENTER) {
			if (userField.getText().isEmpty() || passwordField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(btnLogIn, "Username/Password is Empty");
			} else {
				String usernameUsuario = userField.getText();
				String passwordUsuario = passwordField.getText();

				Worker work = new Worker();

				if (work.logIn(usernameUsuario, passwordUsuario)) {
					MainWindow vMain = new MainWindow(usernameUsuario);
					vMain.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(btnLogIn, "Username/Password Incorrect");
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
