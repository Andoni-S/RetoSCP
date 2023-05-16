package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import acs.Containment;
import acs.Disruption;
import acs.Risk;
import acs.SecondaryC;
import clases.SCP;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

/**
 * CreateSCP is a JPanel and implements the ActionListener to listen to buttons,
 * and is responsible for adding an SCP to the DB
 * 
 * @author Alex
 *
 */
public class CreateSCP extends JPanel implements ActionListener {
	// We declare the necessary labels, textArea, buttons, and comboBoxes
	private static final long serialVersionUID = 1L;
	private JButton btnReset, btnCreate;
	private JLabel lblId, lblIdRelated, lblIdFacility, lblName, lblProcedures, lblDescription, lblLevel, lblContainment,
			lblDisruption, lblRisk, lblSecondary, background;
	private JTextField fieldId, fieldRelated, fieldIdFacility, fieldName;
	private JTextArea textAreaProcedures, textAreaDescription;
	private JSpinner spinnerLevel;
	private JComboBox<Containment> comboBoxContainment;
	private JComboBox<Disruption> comboBoxDisruption;
	private JComboBox<Risk> comboBoxRisk;
	private JComboBox<SecondaryC> comboBoxSecondary;

	/**
	 * This is the constructor of the window, where all the labels, buttons, etc.
	 * are added
	 */
	public CreateSCP() {
		setBounds(0, 0, 1024, 768);
		setLayout(null);

		lblId = new JLabel("ID");
		lblId.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		lblId.setBounds(75, 46, 71, 49);
		lblId.setForeground(new Color(255, 255, 255));
		add(lblId);

		fieldId = new JTextField();
		fieldId.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		fieldId.setForeground(new Color(255, 255, 255));
		fieldId.setBackground(new Color(0, 0, 0));
		fieldId.setBounds(220, 55, 227, 33);
		add(fieldId);
		fieldId.setColumns(10);

		lblIdRelated = new JLabel("ID RELATED SCP");
		lblIdRelated.setForeground(Color.WHITE);
		lblIdRelated.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblIdRelated.setBounds(75, 86, 120, 90);
		add(lblIdRelated);

		fieldRelated = new JTextField();
		fieldRelated.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		fieldRelated.setForeground(new Color(255, 255, 255));
		fieldRelated.setBackground(new Color(0, 0, 0));
		fieldRelated.setColumns(10);
		fieldRelated.setBounds(220, 115, 227, 33);
		add(fieldRelated);

		lblIdFacility = new JLabel("ID FACILITY");
		lblIdFacility.setForeground(Color.WHITE);
		lblIdFacility.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblIdFacility.setBounds(75, 168, 91, 46);
		add(lblIdFacility);

		fieldIdFacility = new JTextField();
		fieldIdFacility.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		fieldIdFacility.setForeground(new Color(255, 255, 255));
		fieldIdFacility.setBackground(new Color(0, 0, 0));
		fieldIdFacility.setColumns(10);
		fieldIdFacility.setBounds(220, 175, 227, 33);
		add(fieldIdFacility);

		lblName = new JLabel("NAME");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		lblName.setBounds(75, 230, 71, 40);
		add(lblName);

		fieldName = new JTextField();
		fieldName.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		fieldName.setForeground(new Color(255, 255, 255));
		fieldName.setBackground(new Color(0, 0, 0));
		fieldName.setColumns(10);
		fieldName.setBounds(220, 235, 227, 33);
		add(fieldName);

		lblProcedures = new JLabel("PROCEDURES");
		lblProcedures.setBounds(75, 336, 130, 40);
		lblProcedures.setFont(new Font("OCR A EXTENDED", Font.BOLD, 12));
		lblProcedures.setForeground(Color.WHITE);
		add(lblProcedures);

		textAreaProcedures = new JTextArea();
		textAreaProcedures.setForeground(new Color(255, 255, 255));
		textAreaProcedures.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		textAreaProcedures.setBounds(220, 326, 227, 140);
		textAreaProcedures.setLineWrap(true);
		textAreaProcedures.setWrapStyleWord(true);
		textAreaProcedures.setOpaque(false);
		add(textAreaProcedures);

		JTextArea textAreaProceduresTransparente = new JTextArea();
		textAreaProceduresTransparente.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		textAreaProceduresTransparente.setBounds(220, 326, 227, 140);
		textAreaProceduresTransparente.setBackground(new Color(0, 0, 0, 80));
		textAreaProceduresTransparente.setEditable(false);
		textAreaProceduresTransparente.setWrapStyleWord(true);
		textAreaProceduresTransparente.setEnabled(false);
		add(textAreaProceduresTransparente);

		lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setBounds(75, 496, 130, 40);
		lblDescription.setFont(new Font("OCR A EXTENDED", Font.BOLD, 12));
		lblDescription.setForeground(Color.WHITE);
		add(lblDescription);

		textAreaDescription = new JTextArea();
		textAreaDescription.setForeground(new Color(255, 255, 255));
		textAreaDescription.setLineWrap(true);
		textAreaDescription.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		textAreaDescription.setBounds(220, 496, 227, 140);
		textAreaDescription.setWrapStyleWord(true);
		textAreaDescription.setOpaque(false);
		add(textAreaDescription);

		JTextArea textAreaDescriptionTransparente = new JTextArea();
		textAreaDescriptionTransparente.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		textAreaDescriptionTransparente.setBounds(220, 496, 227, 140);
		textAreaDescriptionTransparente.setBackground(new Color(0, 0, 0, 80));
		textAreaDescriptionTransparente.setEditable(false);
		textAreaDescriptionTransparente.setEnabled(false);
		textAreaDescriptionTransparente.setWrapStyleWord(true);
		add(textAreaDescriptionTransparente);

		lblLevel = new JLabel("LEVEL");
		lblLevel.setBounds(629, 61, 71, 20);
		lblLevel.setFont(new Font("OCR A EXTENDED", Font.BOLD, 12));
		lblLevel.setForeground(Color.WHITE);
		add(lblLevel);

		spinnerLevel = new JSpinner();
		spinnerLevel.setForeground(new Color(255, 255, 255));
		spinnerLevel.setBackground(new Color(0, 0, 0));
		spinnerLevel.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerLevel.setBounds(798, 61, 138, 20);
		spinnerLevel.setOpaque(false);
		add(spinnerLevel);

		lblContainment = new JLabel("CONTAINMENT");
		lblContainment.setBounds(629, 115, 101, 20);
		lblContainment.setFont(new Font("OCR A EXTENDED", Font.BOLD, 12));
		lblContainment.setForeground(Color.WHITE);
		add(lblContainment);

		comboBoxContainment = new JComboBox<>();
		comboBoxContainment.setForeground(new Color(255, 255, 255));
		comboBoxContainment.setBackground(new Color(0, 0, 0));
		for (Containment conta : Containment.values()) {
			comboBoxContainment.addItem(conta);
		}
		comboBoxContainment.setBounds(798, 115, 138, 20);
		comboBoxContainment.setSelectedIndex(-1);
		add(comboBoxContainment);

		lblDisruption = new JLabel("DISRUPTION");
		lblDisruption.setBounds(629, 168, 101, 20);
		lblDisruption.setFont(new Font("OCR A EXTENDED", Font.BOLD, 12));
		lblDisruption.setForeground(Color.WHITE);
		add(lblDisruption);

		comboBoxDisruption = new JComboBox<>();
		comboBoxDisruption.setBackground(new Color(0, 0, 0));
		comboBoxDisruption.setForeground(new Color(255, 255, 255));
		for (Disruption disr : Disruption.values()) {
			comboBoxDisruption.addItem(disr);
		}
		comboBoxDisruption.setBounds(798, 168, 138, 20);
		comboBoxDisruption.setSelectedIndex(-1);
		add(comboBoxDisruption);

		lblRisk = new JLabel("RISK");
		lblRisk.setBounds(629, 230, 71, 20);
		lblRisk.setFont(new Font("OCR A EXTENDED", Font.BOLD, 12));
		lblRisk.setForeground(Color.WHITE);
		add(lblRisk);

		comboBoxRisk = new JComboBox<>();
		comboBoxRisk.setForeground(new Color(255, 255, 255));
		comboBoxRisk.setBackground(new Color(0, 0, 0));
		for (Risk risk : Risk.values()) {
			comboBoxRisk.addItem(risk);
		}
		comboBoxRisk.setBounds(798, 230, 138, 20);
		comboBoxRisk.setSelectedIndex(-1);
		add(comboBoxRisk);

		lblSecondary = new JLabel("SECONDARY");
		lblSecondary.setBounds(629, 286, 71, 20);
		lblSecondary.setFont(new Font("OCR A EXTENDED", Font.BOLD, 12));
		lblSecondary.setForeground(Color.WHITE);
		add(lblSecondary);

		comboBoxSecondary = new JComboBox<>();
		comboBoxSecondary.setForeground(new Color(255, 255, 255));
		comboBoxSecondary.setBackground(new Color(0, 0, 0));
		for (SecondaryC secon : SecondaryC.values()) {
			comboBoxSecondary.addItem(secon);
		}
		comboBoxSecondary.setBounds(798, 286, 138, 20);
		comboBoxSecondary.setSelectedIndex(-1);
		add(comboBoxSecondary);

		btnReset = new JButton("RESET");
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("OCR A EXTENDED", Font.BOLD, 16));
		btnReset.setBackground(Color.BLACK);
		btnReset.setBounds(620, 581, 110, 54);
		btnReset.addActionListener(this);
		add(btnReset);

		btnCreate = new JButton("CREATE");
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("OCR A EXTENDED", Font.BOLD, 16));
		btnCreate.setBackground(Color.BLACK);
		btnCreate.setBounds(826, 581, 110, 54);
		btnCreate.addActionListener(this);
		add(btnCreate);

		background = new JLabel("bg");
		background.setBounds(0, 0, 1040, 712);
		background.setForeground(Color.WHITE);
		background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
		add(background);

	}

	/**
	 * actionPerformed method listening to btnCreate and btnReset buttons
	 * 
	 * @param e - ActionEvent type variable
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnCreate)) {
			if (fieldId.getText().equals("") || fieldRelated.getText().equals("")
					|| fieldIdFacility.getText().equals("") || fieldName.getText().equals("")
					|| textAreaProcedures.getText().equals("") || textAreaDescription.getText().equals("")
					|| comboBoxContainment.getSelectedIndex() == -1 || comboBoxDisruption.getSelectedIndex() == -1
					|| comboBoxRisk.getSelectedIndex() == -1 || comboBoxSecondary.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "There is an empty field");
			} else {
				SCP scp = new SCP();

				scp.setScp_id(fieldId.getText());
				scp.setRelated_scp_id(fieldRelated.getText());
				scp.setFacility_id(fieldIdFacility.getText());
				scp.setScp_name(fieldName.getText());
				scp.setScp_procedures(textAreaProcedures.getText());
				scp.setScp_description(textAreaDescription.getText());
				scp.setContainment((Containment) comboBoxContainment.getSelectedItem());
				scp.setDisruption((Disruption) comboBoxDisruption.getSelectedItem());
				scp.setRisk((Risk) comboBoxRisk.getSelectedItem());
				scp.setSecondary((SecondaryC) comboBoxSecondary.getSelectedItem());

			}
		}

		if (e.getSource().equals(btnReset)) {
			fieldId.setText("");
			fieldRelated.setText("");
			fieldIdFacility.setText("");
			fieldName.setText("");
			textAreaProcedures.setText("");
			textAreaDescription.setText("");
			spinnerLevel.setValue(0);
			comboBoxContainment.setSelectedIndex(-1);
			comboBoxDisruption.setSelectedIndex(-1);
			comboBoxRisk.setSelectedIndex(-1);
			comboBoxSecondary.setSelectedIndex(-1);
		}
	}
}
