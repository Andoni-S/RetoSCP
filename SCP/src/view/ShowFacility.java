package view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clases.Agent;
import clases.Facility;
import exceptions.ServerException;
import main.AgentFactory;

import java.awt.Color;

/**
 * The JPanel named ShowFacility will display the Facility assigned to an agent
 * 
 * @author Alex
 *
 */
public class ShowFacility extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblIdFacility, lblNameFacility, lblLevelFacility;
	private JLabel background;


	/**
	 * This is the constructor of this window
	 * 
	 * @param userID
	 */

	public ShowFacility(String userID) {

		Facility fac = null;
		
		try {
			fac = AgentFactory.getAgentDB().showAsignedFacility(userID);
		} catch (ServerException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}

		setLayout(null);

		lblIdFacility = new JLabel("ID Facility:  " + fac.getFacility_id());
		lblIdFacility.setForeground(new Color(255, 255, 255));
		lblIdFacility.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblIdFacility.setBounds(130, 110, 1500, 43);
		add(lblIdFacility);

		lblNameFacility = new JLabel("Name Facility:  " + fac.getFacility_name());
		lblNameFacility.setForeground(new Color(255, 255, 255));
		lblNameFacility.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblNameFacility.setBounds(130, 310, 1000, 43);
		add(lblNameFacility);

		lblLevelFacility = new JLabel("Level Facility:  " + String.format("%d", fac.getFacility_level()));
		lblLevelFacility.setForeground(new Color(255, 255, 255));
		lblLevelFacility.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblLevelFacility.setBounds(130, 510, 595, 43);
		add(lblLevelFacility);

		background = new JLabel("bg");
		background.setIcon(new ImageIcon(ShowFacility.class.getResource("/resources/background.png")));
		background.setBounds(0, 0, 1024, 768);
		add(background);
	}

}
