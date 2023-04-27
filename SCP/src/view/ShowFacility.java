package view;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Agent;
import clases.Facility;
import java.awt.Color;
import java.awt.Dimension;

public class ShowFacility extends JPanel {

	private JLabel lblIdFacility, lblNameFacility, lblLevelFacility;
	private JLabel background;

	public ShowFacility(String userID) {

		Agent wAge = new Agent();
		Facility fac;
		fac = wAge.showAsignedFacility(userID);
		setLayout(null);
		

		lblIdFacility = new JLabel("ID Facility:           " + wAge.getId_facility());
		lblIdFacility.setForeground(new Color(255, 255, 255));
		lblIdFacility.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblIdFacility.setBounds(130, 110, 1500, 43);
		add(lblIdFacility);

		lblNameFacility = new JLabel("Name Facility:         " + fac.getFacility_name());
		lblNameFacility.setForeground(new Color(255, 255, 255));
		lblNameFacility.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblNameFacility.setBounds(130, 310, 796, 43);
		add(lblNameFacility);

		lblLevelFacility = new JLabel("Level Facility:        " + String.format("%d", fac.getFacility_level()));
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
