package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clases.SCP;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Panel;
import java.awt.FlowLayout;

public class PanelShowScp extends JPanel {

	protected static final Component PanelShowScp = null;
	/**
	 * Create the panel.
	 */
	private JTextArea level_scp;
	private JTextArea facility_scp;
	private JTextArea procedure_scp;
	private JTextArea description_scp;
	private boolean flag = false;
	JLabel lbNoGuardar;
	JLabel lbGuardar;
	JLabel lbModify;

	public PanelShowScp(ArrayList<SCP> scp_list) {

		setBounds(0, 0, 1024, 768);
		setLayout(null);

		SCP scp_1 = scp_list.get(0);

		JTextArea id_scp = new JTextArea(scp_1.getScp_id());
		id_scp.setEditable(false);
		id_scp.setEnabled(false);
		id_scp.setForeground(new Color(255, 255, 255));
		id_scp.setBackground(new Color(0, 0, 0, 80));
		id_scp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		id_scp.setBounds(28, 25, 519, 81);
		add(id_scp);

		JTextArea name_scp = new JTextArea(scp_1.getScp_name());
		name_scp.setEditable(false);
		name_scp.setEnabled(false);
		name_scp.setBackground(new Color(0, 0, 0, 80));
		name_scp.setForeground(new Color(255, 255, 255));
		name_scp.setBounds(675, 25, 292, 35);
		add(name_scp);

		facility_scp = new JTextArea(scp_1.getFacility_id());
		facility_scp.setEditable(false);
		facility_scp.setBackground(new Color(0, 0, 0, 80));
		facility_scp.setForeground(new Color(255, 255, 255));
		facility_scp.setBounds(675, 115, 292, 35);
		add(facility_scp);

		procedure_scp = new JTextArea(scp_1.getScp_procedures());
		procedure_scp.setEditable(false);
		procedure_scp.setForeground(new Color(255, 255, 255));
		procedure_scp.setBackground(new Color(0, 0, 0, 80));
		procedure_scp.setBounds(28, 150, 519, 153);
		add(procedure_scp);

		level_scp = new JTextArea(String.valueOf(scp_1.getScp_level()));
		level_scp.setEditable(false);
		level_scp.setBackground(new Color(0, 0, 0, 80));
		level_scp.setForeground(new Color(255, 255, 255));
		level_scp.setBounds(675, 71, 292, 33);
		add(level_scp);

		description_scp = new JTextArea(scp_1.getScp_description());
		description_scp.setEditable(false);
		description_scp.setBackground(new Color(0, 0, 0, 80));
		description_scp.setForeground(new Color(255, 255, 255));
		description_scp.setBounds(28, 355, 519, 322);
		add(description_scp);

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

		JLabel lbDescription = new JLabel("DESCRIPTION");
		lbDescription.setForeground(new Color(255, 255, 255));
		lbDescription.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		lbDescription.setBounds(28, 314, 196, 22);
		add(lbDescription);

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

		lbNoGuardar = new JLabel("");
		add(lbNoGuardar);
		lbNoGuardar.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/dontsave.png")));

		lbGuardar = new JLabel("");
		add(lbGuardar);
		lbGuardar.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/save.png")));
		
		lbModify = new JLabel("");
		lbModify.setBounds(777, 596, 64, 64);
		add(lbModify);
		lbModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!flag) {
					//Mostrar iconos de guardar y no guardar y ocultar el icono de modificar
					lbNoGuardar.setVisible(true);
					lbNoGuardar.setEnabled(true);
					lbGuardar.setVisible(true);
					lbGuardar.setEnabled(true);
					lbModify.setVisible(false);
					lbModify.setEnabled(false);
					//Hacer editables los cuadros de texto
					level_scp.setEditable(true);
					level_scp.setEnabled(true);
					facility_scp.setEditable(true);
					facility_scp.setEnabled(true);
					procedure_scp.setEditable(true);
					procedure_scp.setEnabled(true);
					description_scp.setEditable(true);
					description_scp.setEnabled(true);
					
					flag = true;
				}
			}
		});
		lbModify.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/icons8-pencil-64.png")));

		if (flag == true) {
			lbGuardar.setVisible(true);
			lbGuardar.setEnabled(true);
			lbNoGuardar.setVisible(true);
			lbNoGuardar.setEnabled(true);
			flag = false;
		}
		JLabel lbOctagono = new JLabel("");
		lbOctagono.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/Octagono_400.png")));
		lbOctagono.setBounds(605, 282, 347, 287);
		add(lbOctagono);

		JLabel lbBackGround = new JLabel("");
		lbBackGround.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/background.png")));
		lbBackGround.setBounds(-26, 0, 1040, 712);
		add(lbBackGround);
	}
}
