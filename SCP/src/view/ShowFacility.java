package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import clases.Agent;
import clases.Facility;

public class ShowFacility extends JPanel {

	private JLabel lblIdFacility,lblNameFacility,lblLevelFacility;
	
	public ShowFacility(String userID) {
		
		Agent wAge = new Agent();
		Facility fac;
		fac = wAge.showAsignedFacility(userID);

		lblIdFacility = new JLabel("ID Facility:           " + wAge.getId_facility());
		lblIdFacility.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblIdFacility.setBounds(125, 155, 1500, 80);
		add(lblIdFacility);

		lblNameFacility = new JLabel("Name Facility:         " + fac.getFacility_name());
		lblNameFacility.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblNameFacility.setBounds(125, 310, 1500, 80);
		add(lblNameFacility);

		lblLevelFacility = new JLabel("Level Facility:        " + String.format("%d", fac.getFacility_level()));
		lblLevelFacility.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblLevelFacility.setBounds(125, 465, 1500, 80);
		add(lblLevelFacility);
		
	}

}
