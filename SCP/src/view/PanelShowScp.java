package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelShowScp extends JPanel {

	protected static final Component PanelShowScp = null;
	/**
	 * Create the panel.
	 */
	private JTextArea level_scp;
	private JTextArea facility_scp;
	private JTextArea procedure_scp;
	private JTextArea description_scp;

	public PanelShowScp() {
		setLayout(null);

		JTextArea id_scp = new JTextArea();
		id_scp.setEditable(false);
		id_scp.setEnabled(false);
		id_scp.setForeground(new Color(255, 255, 255));
		id_scp.setBackground(new Color(0, 0, 0, 80));
		id_scp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		id_scp.setBounds(28, 25, 519, 81);
		add(id_scp);

		JTextArea name_scp = new JTextArea();
		name_scp.setEditable(false);
		name_scp.setEnabled(false);
		name_scp.setBackground(new Color(0, 0, 0, 80));
		name_scp.setForeground(new Color(255, 255, 255));
		name_scp.setBounds(675, 25, 292, 35);
		add(name_scp);

		facility_scp = new JTextArea();
		facility_scp.setEditable(false);
		facility_scp.setEnabled(false);
		facility_scp.setBackground(new Color(0, 0, 0, 80));
		facility_scp.setForeground(new Color(255, 255, 255));
		facility_scp.setBounds(675, 71, 292, 35);
		add(facility_scp);

		procedure_scp = new JTextArea();
		procedure_scp.setEditable(false);
		procedure_scp.setEnabled(false);
		procedure_scp.setForeground(new Color(255, 255, 255));
		procedure_scp.setBackground(new Color(0, 0, 0, 80));
		procedure_scp.setBounds(28, 150, 519, 153);
		add(procedure_scp);

		level_scp = new JTextArea();
		level_scp.setEditable(false);
		level_scp.setEnabled(false);
		level_scp.setBackground(new Color(0, 0, 0, 80));
		level_scp.setForeground(new Color(255, 255, 255));
		level_scp.setBounds(675, 117, 292, 33);
		add(level_scp);

		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		lblName.setBounds(579, 24, 52, 36);
		add(lblName);

		JLabel lblLevel = new JLabel("LEVEL");
		lblLevel.setForeground(new Color(255, 255, 255));
		lblLevel.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		lblLevel.setBounds(579, 73, 60, 33);
		add(lblLevel);

		JLabel lblFacility = new JLabel("FACILITY");
		lblFacility.setForeground(new Color(255, 255, 255));
		lblFacility.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		lblFacility.setBounds(579, 117, 103, 33);
		add(lblFacility);

		JLabel lbProcedure = new JLabel("PROCEDURES");
		lbProcedure.setForeground(new Color(255, 255, 255));
		lbProcedure.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		lbProcedure.setBounds(28, 117, 196, 22);
		add(lbProcedure);

		description_scp = new JTextArea();
		description_scp.setEditable(false);
		description_scp.setEnabled(false);
		description_scp.setBackground(new Color(0, 0, 0, 80));
		description_scp.setForeground(new Color(255, 255, 255));
		description_scp.setBounds(28, 355, 519, 322);
		add(description_scp);

		JLabel lbDescription = new JLabel("DESCRIPTION");
		lbDescription.setForeground(new Color(255, 255, 255));
		lbDescription.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		lbDescription.setBounds(28, 314, 196, 22);
		add(lbDescription);

		JLabel lbOctagono = new JLabel("");
		lbOctagono.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/Octagono_400.png")));
		lbOctagono.setBounds(605, 282, 347, 287);
		add(lbOctagono);

		JLabel lbModify = new JLabel("");
		lbModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				level_scp.setEditable(true);
				level_scp.setEnabled(true);
				facility_scp.setEditable(true);
				facility_scp.setEnabled(true);
				procedure_scp.setEditable(true);
				procedure_scp.setEnabled(true);
				description_scp.setEditable(true);
				description_scp.setEnabled(true);
				
			}
		});
		lbModify.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/icons8-pencil-64.png")));
		lbModify.setBounds(772, 598, 78, 79);
		add(lbModify);

		JLabel lbACS = new JLabel("A.C.S.");
		lbACS.setForeground(new Color(255, 255, 255));
		lbACS.setFont(new Font("OCR A Extended", Font.PLAIN, 34));
		lbACS.setBounds(738, 161, 127, 85);
		add(lbACS);

		JLabel lbACS_MEANING = new JLabel("Anomaly Containment System");
		lbACS_MEANING.setForeground(new Color(255, 255, 255));
		lbACS_MEANING.setFont(new Font("OCR A Extended", Font.PLAIN, 19));
		lbACS_MEANING.setBounds(660, 234, 292, 35);
		add(lbACS_MEANING);
		
		JLabel lbGuardarCambios = new JLabel("");
		lbGuardarCambios.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/save.png")));
		lbGuardarCambios.setBounds(661, 596, 74, 81);
		add(lbGuardarCambios);
		
		JLabel lbNoGuardar = new JLabel("");
		lbNoGuardar.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/dontsave.png")));
		lbNoGuardar.setBounds(878, 596, 74, 81);
		add(lbNoGuardar);
		
		JLabel lbBackGround = new JLabel("");
		lbBackGround.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/background.png")));
		lbBackGround.setBounds(-26, 0, 1040, 712);
		add(lbBackGround);
		
	
		
		
		
		

	}
}
