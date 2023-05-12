package view;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import clases.RotatedLabel;
import clases.Worker;
import exceptions.LoginException;
import main.LoginableFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LoginWindow extends JFrame implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private Timer timer, timer2;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JPanel contentPane;
	private JLabel component;
	private int usery;
	private int logoy;
	private RotatedLabel scpLogo;
	private JLabel background;
	private ActionListener labelAnim, labelRotation;
	private JTextField userField;
	private JPasswordField passwordField;
	private JButton btnLogIn;
	private double[] size = new double[2];
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
		userField.setForeground(Color.WHITE);
		userField.setBackground(Color.BLACK);
		userField.setBounds(400, 1000, 300, 32);
		userField.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		contentPane.add(userField);
		userField.setColumns(10);
		userField.setFocusable(true);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.BLACK);
		passwordField.setBounds(400, 1200, 300, 33);
		passwordField.addKeyListener(this);
		contentPane.add(passwordField);

		scpLogo = new RotatedLabel("scp");
		scpLogo.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/MEDIUM_White.png")));
		scpLogo.setBounds(100, -550, 800, 800);
		scpLogo.setAngle(0);
		contentPane.add(scpLogo);

		background = new JLabel("bg");
		background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
		background.setBounds(0, 0, 1024, 768);
		contentPane.add(background);

		labelAnim = new LabelAnim();
		labelRotation = new LabelRotation();
		logoy = scpLogo.getY();
		usery = usernameLabel.getY();
		timer = new Timer(1, labelAnim);
		timer2 = new Timer(1, labelRotation);

		btnLogIn = new JButton("LOG IN");
		btnLogIn.setFont(new Font("OCR A EXTENDED", Font.BOLD, 16));
		btnLogIn.setBackground(new Color(0, 0, 0));
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setBounds(480, 600, 120, 45);
		contentPane.add(btnLogIn);
		btnLogIn.addActionListener(this);
		    
		timer.start();
		//timer2.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnLogIn)) {
			login();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_ENTER) {
			login();
		}
	}
	class LabelAnim implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("help1");
			moveLabel();
			moveLogo();
		}

		private void moveLogo() {
			logoy += 5;
			scpLogo.setLocation(scpLogo.getX(), logoy);
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
				timer2.start();
			}
		}
	}
	
	class LabelRotation implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			rotateLabel();
		}

		private void rotateLabel() {
			
			if(scpLogo.getAngle() >= 2*3.1416)
				scpLogo.setAngle(0);
			
			scpLogo.setLocation(scpLogo.getX()+1, scpLogo.getX()+1);
			scpLogo.setLocation(scpLogo.getX()-1, scpLogo.getX()-1);
			//scpLogo.setAngle(scpLogo.getAngle()+0.01);
			
			size[0]=size[0]+0.001;
			size[1]=size[1]+0.001;
			System.out.println(size[0]+" "+ size[1]);
			scpLogo.setSizeCustom(size);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	
	@Override
	public void keyReleased(KeyEvent e) {

	}
	public void login(){
		try {
			if (userField.getText().isEmpty() || passwordField.getText().isEmpty()) 
				throw new Exception("nombre y/o contraseña vacios");
				
			String usernameUsuario = userField.getText();
			String passwordUsuario = passwordField.getText();

			Worker worker = LoginableFactory.getLoginable().logIn(usernameUsuario, passwordUsuario);
			MainWindow vMain = new MainWindow(worker.getId());
			vMain.setVisible(true);
			
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(btnLogIn, e.getMessage());
		}
	}
}
