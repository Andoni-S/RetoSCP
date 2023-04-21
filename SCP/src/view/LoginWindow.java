package view;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import clases.Worker;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LoginWindow extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JPanel contentPane;
    private JLabel component;
    private int usery;
    private int logoy;

    private JLabel SCPLogo;
    
    private ActionListener labelAnim;
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton btnLogIn;
    /**
     * Launch the application.
     */
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

    /**
     * Create the frame.
     */
    public LoginWindow() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(LoginWindow.class.getResource("/resources/icon.png")));
    	     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
		//adapta la ventana a la pantalla
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Monotxt_IV50", Font.PLAIN, 22));
        usernameLabel.setBounds(300, 1000, 133, 32);
        contentPane.add(usernameLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Monotxt_IV50", Font.PLAIN, 22));
        passwordLabel.setBounds(300, 1200, 133, 40);
        contentPane.add(passwordLabel);

        /*component = new JLabel("Click to Log In");
        component.setFont(new Font("Monotxt_IV50", Font.PLAIN, 50));
        component.setBackground(Color.BLACK);
        component.setBounds(800, 400, 1000, 114);
        component.addMouseListener(new MyMouseListener());
        contentPane.add(component);*/
        
        userField = new JTextField();
        userField.setBounds(450, 1000, 224, 32);
        contentPane.add(userField);
        userField.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(450, 1200, 224, 33);
        contentPane.add(passwordField);
        
        SCPLogo = new JLabel("scp");
        SCPLogo.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/SCP_Foundation_logoMEDIUM.png")));
        SCPLogo.setBounds(100, -550, 800, 800);
        contentPane.add(SCPLogo);
        
        background = new JLabel("scp");
        background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
        background.setBounds(100, -550, 800, 800);
        contentPane.add(background);
        
        labelAnim = new LabelAnim();
        logoy = SCPLogo.getY();
        usery = usernameLabel.getY();
        timer = new Timer(1, labelAnim);
        
        btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogIn.setBounds(480, 566, 120, 45);
		contentPane.add(btnLogIn);
		btnLogIn.addActionListener(this);
		
		timer.start();
    }

    class MyMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent evt) {
            if ((InputEvent.MOUSE_EVENT_MASK) != 0) {
                System.out.println("left" + (evt.getPoint()));            
                timer.start();
            }
            /*if ((evt.getModifiers() & InputEvent.BUTTON2_MASK) != 0) {
                System.out.println("middle" + (evt.getPoint()));
            }
            if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
                System.out.println("right" + (evt.getPoint()));
            }*/
        }
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
					//vMain.pack();
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
			// TODO Auto-generated method stub
        	logoy +=5;
        	SCPLogo.setLocation(SCPLogo.getX(), logoy);
        	/*if (logoy >= 50) {
                timer.stop();
            }*/
		}

		private void moveLabel() {
            usery-=7;
            //component.setVisible(false);
            usernameLabel.setLocation(usernameLabel.getX(), usery);
            passwordLabel.setLocation(passwordLabel.getX(), usery+50);
            userField.setLocation(userField.getX(), usery);
            passwordField.setLocation(passwordField.getX(), usery+50);
            
            if (usery <= 450) {
                timer.stop();
            }
        }
    }
}
