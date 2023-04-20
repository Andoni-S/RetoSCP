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
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class LoginWindow extends JFrame {

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
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Monotxt_IV50", Font.PLAIN, 22));
        usernameLabel.setBounds(800, 1000, 133, 32);
        contentPane.add(usernameLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Monotxt_IV50", Font.PLAIN, 22));
        passwordLabel.setBounds(800, 1200, 133, 40);
        contentPane.add(passwordLabel);

        component = new JLabel("Click to Log In");
        component.setFont(new Font("Monotxt_IV50", Font.PLAIN, 50));
        component.setBackground(Color.BLACK);
        component.setBounds(800, 400, 1000, 114);
        component.addMouseListener(new MyMouseListener());
        contentPane.add(component);
        
        userField = new JTextField();
        userField.setBounds(1000, 1000, 224, 32);
        contentPane.add(userField);
        userField.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(1000, 1200, 224, 33);
        contentPane.add(passwordField);
        
        SCPLogo = new JLabel("scp");
        SCPLogo.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/SCP_Foundation_logoSMALL.png")));
        SCPLogo.setBounds(800, -250, 202, 114);
        contentPane.add(SCPLogo);
        
        labelAnim = new LabelAnim();
        logoy = SCPLogo.getY();
        usery = usernameLabel.getY();
        timer = new Timer(1, labelAnim);
        
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
            usery-=5;
            component.setVisible(false);
            usernameLabel.setLocation(usernameLabel.getX(), usery);
            passwordLabel.setLocation(passwordLabel.getX(), usery+50);
            userField.setLocation(userField.getX(), usery);
            passwordField.setLocation(passwordField.getX(), usery+50);
            
            if (usery <= 300) {
                timer.stop();
            }
        }
    }
}
