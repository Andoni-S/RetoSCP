package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clases.SCP;
import clases.Scientific;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class PanelShowScp extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final Component PanelShowScp = null;
	/**
	 * Create the panel.
	 */
	private JTextArea level_scp;
	private JTextArea facility_scp;
	private JTextArea procedure_scp;
	private JTextArea description_scp;
	JLabel lbGuardar, lbMoveOn, lbGoBack, lbNoGuardar, lbModify;
	private SCP scp_1;
	private int index = 0;
	JTextArea name_scp;
	JTextArea id_scp;
	JLabel lbContainment;
	JLabel lbDisruption;
	JLabel lbSecondary;
	JLabel lbRisk;
	String containment;
	String disruption;
	JComboBox<String> cbRelatedSCP;
	String risk;
	String secondary;
	String path = "/resources/";
	String png = ".png";
	int lastIdx;
	int lastElement;
	ArrayList<SCP> scp_list;

	public PanelShowScp(ArrayList<SCP> scp_list_) {

		setBounds(0, 0, 1024, 768);
		setLayout(null);

		scp_list = scp_list_;
		scp_1 = scp_list.get(0);

		lbMoveOn = new JLabel("");
		lbMoveOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index++;
				Update();

			}
		});
		lbGoBack = new JLabel("");
		lbGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index--;
				Update();
			}
		});
		lbGoBack.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/ArroyGoBack64.png")));
		lbGoBack.setBounds(675, 596, 64, 64);
		add(lbGoBack);
		// if (scp_list.get(scp_1)!=0) {
		lbGoBack.setVisible(true);
		// } else {
		lbGoBack.setVisible(false);
		// Lugar donde va la informacion

		id_scp = new JTextArea(scp_1.getScp_id());
		id_scp.setEditable(false);
		id_scp.setEnabled(false);
		id_scp.setForeground(new Color(255, 255, 255));
		id_scp.setBackground(new Color(0, 0, 0, 80));
		id_scp.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		id_scp.setBounds(28, 50, 519, 35);
		id_scp.setOpaque(false);
		add(id_scp);

		JTextArea id_background = new JTextArea((String) null);
		id_background.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		id_background.setEnabled(false);
		id_background.setEditable(false);
		id_background.setBackground(new Color(0, 0, 0, 80));
		id_background.setBounds(28, 25, 519, 81);
		add(id_background);

		name_scp = new JTextArea(scp_1.getScp_name());
		name_scp.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		name_scp.setEditable(false);
		name_scp.setEnabled(false);
		name_scp.setBackground(new Color(0, 0, 0));
		name_scp.setForeground(new Color(255, 255, 255));
		name_scp.setBounds(697, 32, 270, 27);
		name_scp.setOpaque(false);
		add(name_scp);

		JTextArea name_background = new JTextArea((String) null);
		name_background.setEnabled(false);
		name_background.setEditable(false);
		name_background.setBackground(Color.BLACK);
		name_background.setBounds(697, 25, 270, 35);
		add(name_background);

		facility_scp = new JTextArea(scp_1.getFacility_id());
		facility_scp.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		facility_scp.setEditable(false);
		facility_scp.setEnabled(false);
		facility_scp.setBackground(new Color(0, 0, 0, 80));
		facility_scp.setForeground(new Color(255, 255, 255));
		facility_scp.setBounds(697, 123, 270, 27);
		facility_scp.setOpaque(false);
		add(facility_scp);

		JTextArea facility_background = new JTextArea((String) null);
		facility_background.setEnabled(false);
		facility_background.setEditable(false);
		facility_background.setBackground(new Color(0, 0, 0, 80));
		facility_background.setBounds(697, 115, 270, 35);
		add(facility_background);

		level_scp = new JTextArea(String.valueOf(scp_1.getScp_level()));
		level_scp.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		level_scp.setEditable(false);
		level_scp.setEnabled(false);
		level_scp.setBackground(new Color(0, 0, 0, 80));
		level_scp.setForeground(new Color(255, 255, 255));
		level_scp.setBounds(697, 79, 270, 22);
		level_scp.setOpaque(false);
		add(level_scp);

		JTextArea level_background = new JTextArea("");
		level_background.setEnabled(false);
		level_background.setEditable(false);
		level_background.setBackground(new Color(0, 0, 0, 80));
		level_background.setBounds(697, 71, 270, 33);
		add(level_background);

		procedure_scp = new JTextArea(scp_1.getScp_procedures());
		procedure_scp.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		procedure_scp.setWrapStyleWord(true);
		procedure_scp.setLineWrap(true);
		procedure_scp.setEditable(false);
		procedure_scp.setEnabled(false);
		procedure_scp.setForeground(new Color(255, 255, 255));
		procedure_scp.setBackground(new Color(0, 0, 0, 80));
		procedure_scp.setBounds(28, 150, 519, 153);
		procedure_scp.setOpaque(false);
		add(procedure_scp);

		JTextArea procedure_background = new JTextArea((String) null);
		procedure_background.setWrapStyleWord(true);
		procedure_background.setLineWrap(true);
		procedure_background.setForeground(new Color(0, 0, 0));
		procedure_background.setEnabled(false);
		procedure_background.setEditable(false);
		procedure_background.setBackground(new Color(0, 0, 0, 80));
		procedure_background.setBounds(28, 150, 519, 153);
		add(procedure_background);

		description_scp = new JTextArea(scp_1.getScp_description());
		description_scp.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		description_scp.setWrapStyleWord(true);
		description_scp.setLineWrap(true);
		description_scp.setEditable(false);
		description_scp.setEnabled(false);
		description_scp.setBackground(new Color(0, 0, 0));
		description_scp.setForeground(new Color(255, 255, 255));
		description_scp.setBounds(28, 347, 519, 322);
		description_scp.setOpaque(false);
		add(description_scp);

		cbRelatedSCP = new JComboBox<String>();
		cbRelatedSCP.setForeground(new Color(255, 255, 255));
		cbRelatedSCP.setBackground(new Color(0, 0, 0));
		for(SCP scp: scp_list) {
			cbRelatedSCP.addItem(scp.getScp_id());
		}
		cbRelatedSCP.setSelectedItem(scp_1.getRelated_scp_id());
		cbRelatedSCP.getEditor().getEditorComponent().setBackground(Color.BLACK);
		JTextField text = ((JTextField) cbRelatedSCP.getEditor().getEditorComponent());
        text.setBackground(Color.YELLOW);
		cbRelatedSCP.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		cbRelatedSCP.setBounds(697, 166, 270, 27);
		cbRelatedSCP.setEnabled(false);
		add(cbRelatedSCP);

		JTextArea description_background = new JTextArea((String) null);
		description_background.setEnabled(false);
		description_background.setEditable(false);
		description_background.setBackground(new Color(0, 0, 0, 80));
		description_background.setBounds(28, 347, 519, 322);
		add(description_background);
		// Nombre de cada text area

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

		JLabel lblRelatedScp = new JLabel("RELATED \r\nSCP");
		lblRelatedScp.setToolTipText("");
		lblRelatedScp.setForeground(Color.WHITE);
		lblRelatedScp.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		lblRelatedScp.setBounds(573, 171, 132, 22);
		add(lblRelatedScp);

		JLabel lbACS = new JLabel("A.C.S.");
		lbACS.setForeground(new Color(255, 255, 255));
		lbACS.setFont(new Font("OCR A Extended", Font.PLAIN, 34));
		lbACS.setBounds(735, 208, 127, 54);
		add(lbACS);

		JLabel lbACS_MEANING = new JLabel("Anomaly Containment System");
		lbACS_MEANING.setForeground(new Color(255, 255, 255));
		lbACS_MEANING.setFont(new Font("OCR A Extended", Font.PLAIN, 19));
		lbACS_MEANING.setBounds(663, 248, 292, 35);
		add(lbACS_MEANING);

		// ACS of the SCP

		containment = path + scp_1.getContainment() + png;

		disruption = path + scp_1.getDisruption() + png;

		risk = path + scp_1.getRisk() + png;

		secondary = path + scp_1.getSecondary() + png;

		lbContainment = new JLabel("");
		lbContainment.setHorizontalAlignment(SwingConstants.CENTER);
		lbContainment.setVerticalAlignment(SwingConstants.BOTTOM);
		lbContainment.setIcon(new ImageIcon(PanelShowScp.class.getResource(containment)));
		lbContainment.setBounds(752, 294, 103, 113);
		add(lbContainment);

		lbDisruption = new JLabel("");
		lbDisruption.setIcon(new ImageIcon(PanelShowScp.class.getResource(disruption)));
		lbDisruption.setVerticalAlignment(SwingConstants.BOTTOM);
		lbDisruption.setHorizontalAlignment(SwingConstants.CENTER);
		lbDisruption.setBounds(675, 371, 103, 113);
		add(lbDisruption);

		lbSecondary = new JLabel("");
		lbSecondary.setIcon(new ImageIcon(PanelShowScp.class.getResource(secondary)));
		lbSecondary.setVerticalAlignment(SwingConstants.BOTTOM);
		lbSecondary.setHorizontalAlignment(SwingConstants.CENTER);
		lbSecondary.setBounds(706, 380, 200, 177);
		add(lbSecondary);

		lbRisk = new JLabel("");
		lbRisk.setIcon(new ImageIcon(PanelShowScp.class.getResource(risk)));
		lbRisk.setVerticalAlignment(SwingConstants.BOTTOM);
		lbRisk.setHorizontalAlignment(SwingConstants.CENTER);
		lbRisk.setBounds(806, 329, 149, 153);
		add(lbRisk);

		lbMoveOn.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/ArroyMoveOn64.png")));
		lbMoveOn.setBounds(877, 596, 64, 64);
		add(lbMoveOn);

		lbGuardar = new JLabel("");
		lbGuardar.setBounds(675, 596, 64, 64);
		add(lbGuardar);
		lbGuardar.setVisible(false);

		lbGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean correcto = false;

				Scientific senor = new Scientific();
				updateSCP();
				correcto = senor.modifySCP(scp_1);

				if (correcto) {
					JOptionPane.showMessageDialog(null, "The SCP was successfully modified");
				}
				Update();
				// cambiar los botones
				CambiarBotones();
				// Llama al metodo de modificar
				NoEditable();

			}

		});
		lbGuardar.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/save.png")));

		lbNoGuardar = new JLabel("");
		lbNoGuardar.setBounds(877, 596, 64, 64);
		add(lbNoGuardar);
		lbNoGuardar.setVisible(false);

		lbNoGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CambiarBotones();
				// No realiza ningun cambio
				NoEditable();
			}
		});
		lbNoGuardar.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/dontsave.png")));

		lbModify = new JLabel("");
		lbModify.setBounds(777, 596, 64, 64);
		add(lbModify);
		lbModify.setVisible(true);
		lbModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Mostrar iconos de guardar y no guardar y ocultar el icono de modificar
				lbNoGuardar.setVisible(true);
				lbNoGuardar.setEnabled(true);
				lbGuardar.setVisible(true);
				lbGuardar.setEnabled(true);
				lbModify.setVisible(false);
				lbModify.setEnabled(false);
				lbMoveOn.setVisible(false);
				lbMoveOn.setEnabled(false);
				lbGoBack.setVisible(false);
				lbGoBack.setEnabled(false);
				
				// Hacer editables los cuadros de texto

				level_scp.setEditable(true);
				level_scp.setEnabled(true);
				facility_scp.setEditable(true);
				facility_scp.setEnabled(true);
				procedure_scp.setEditable(true);
				procedure_scp.setEnabled(true);
				description_scp.setEditable(true);
				description_scp.setEnabled(true);
				cbRelatedSCP.setEnabled(true);
				cbRelatedSCP.getEditor().getEditorComponent().setBackground(Color.BLACK);
			}
		});
		lbModify.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/icons8-pencil-64.png")));

		JLabel lbOctagono = new JLabel("");
		lbOctagono.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/Octagono_400.png")));
		lbOctagono.setBounds(605, 282, 347, 287);
		add(lbOctagono);

		JLabel lbBackGround = new JLabel("");
		lbBackGround.setIcon(new ImageIcon(PanelShowScp.class.getResource("/resources/background.png")));
		lbBackGround.setBounds(-26, 0, 1040, 712);
		add(lbBackGround);

	}

	public void updateSCP() {

		scp_1.setScp_level(Integer.valueOf(level_scp.getText()));
		scp_1.setFacility_id(facility_scp.getText());
		scp_1.setScp_procedures(procedure_scp.getText());
		scp_1.setScp_description(description_scp.getText());
		scp_1.setRelated_scp_id((String) cbRelatedSCP.getSelectedItem());

	}

	public void Update() {

		scp_1 = scp_list.get(index);

		id_scp.setText(scp_1.getScp_id());
		name_scp.setText(scp_1.getScp_name());
		level_scp.setText(String.valueOf(scp_1.getScp_level()));
		facility_scp.setText(scp_1.getFacility_id());
		procedure_scp.setText(scp_1.getScp_procedures());
		description_scp.setText(scp_1.getScp_description());
		cbRelatedSCP.setSelectedItem(scp_1.getRelated_scp_id());


		containment = path + scp_1.getContainment() + png;
		lbContainment.setIcon(new ImageIcon(PanelShowScp.class.getResource(containment)));
		disruption = path + scp_1.getDisruption() + png;
		lbDisruption.setIcon(new ImageIcon(PanelShowScp.class.getResource(disruption)));
		risk = path + scp_1.getRisk() + png;
		lbRisk.setIcon(new ImageIcon(PanelShowScp.class.getResource(risk)));
		secondary = path + scp_1.getSecondary() + png;
		lbSecondary.setIcon(new ImageIcon(PanelShowScp.class.getResource(secondary)));

		if (index >= scp_list.size() - 1) {
			lbMoveOn.setVisible(false);
		} else {
			lbMoveOn.setVisible(true);

		}
		if (index > 0) {
			lbGoBack.setVisible(true);
		} else {
			lbGoBack.setVisible(false);

		}
	}

	public void CambiarBotones() {

		// TODO Auto-generated method stub

		lbNoGuardar.setVisible(false);
		lbNoGuardar.setEnabled(false);
		lbGuardar.setVisible(false);
		lbGuardar.setEnabled(false);
		lbModify.setVisible(true);
		lbModify.setEnabled(true);
		
		if (index >= scp_list.size() - 1) {
			lbMoveOn.setVisible(false);
		} else {
			lbMoveOn.setVisible(true);

		}
		if (index > 0) {
			lbGoBack.setVisible(true);
		} else {
			lbGoBack.setVisible(false);

		}
	}

	public void NoEditable() {

		level_scp.setEditable(false);
		level_scp.setEnabled(false);
		facility_scp.setEditable(false);
		facility_scp.setEnabled(false);
		procedure_scp.setEditable(false);
		procedure_scp.setEnabled(false);
		description_scp.setEditable(false);
		description_scp.setEnabled(false);
		cbRelatedSCP.setEnabled(false);
	}

}
