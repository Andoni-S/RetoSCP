package view;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Overseer;

import java.awt.Color;
import java.awt.Font;

public class AssignSCPtoScientist extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblIdSCP;
	private JLabel lblIdScientist;
	private JTextField fieldIDScientist;
	private JTextField fieldIDSCP;
	private JButton btnIDSCP;
	private JLabel background;
	/**
	 * Create the panel.
	 */
	public AssignSCPtoScientist() {
		
		
		btnIDSCP = new JButton("Assign");
	    btnIDSCP.setBounds(400, 500, 144, 23);
	    btnIDSCP.setBackground(new Color(0,0,0));
	    btnIDSCP.setForeground(new Color(255, 255, 255));
        btnIDSCP.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
	    setLayout(null);
	    add(btnIDSCP);
	    btnIDSCP.addActionListener(this);
	    
	    lblIdSCP = new JLabel("SCP:");
	    lblIdSCP.setForeground(new Color(255, 255, 255));
        lblIdSCP.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
	    lblIdSCP.setBounds(65, 86, 42, 14);
	    add(lblIdSCP);
	    
	    fieldIDSCP = new JTextField();
	    fieldIDSCP.setBounds(225, 86, 200, 25);
	    add(fieldIDSCP);

	    	    
	    lblIdScientist = new JLabel("Scientist:");
	    lblIdScientist.setForeground(new Color(255, 255, 255));
        lblIdScientist.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
	    lblIdScientist.setBounds(65, 186, 89, 14);
	    add(lblIdScientist);
	    
	    fieldIDScientist = new JTextField();
	    fieldIDScientist.setBounds(225, 186, 200, 25);
	    add(fieldIDScientist);

	    
	    background = new JLabel("bg");
        background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
        background.setBounds(0, 0, 1024, 768);
        add(background);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnIDSCP)) {
			Overseer overseer = new Overseer();
			overseer.asignSCPtoScientific(fieldIDScientist.getText(), fieldIDSCP.getText());
			btnIDSCP.setEnabled(false);
		}
		
	}

}
