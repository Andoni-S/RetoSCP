package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import acs.Containment;
import acs.Discruption;
import acs.Risk;
import acs.SecondaryC;
import clases.Overseer;
import clases.SCP;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class CreateSCP extends JPanel implements ActionListener {
	// We declare the necessary labels, textArea, buttons, and comboBoxes
	private static final long serialVersionUID = 1L;
	private JButton btnReset, btnCreate;
	private JLabel lblId, lblIdFacility, lblName, lblProcedures, lblDescription, lblLevel, lblContainment,
			lblDisruption, lblRisk, lblSecondary, background;
	private JTextArea fieldId, fieldRelated, fieldIdFacility, fieldName;
	private JTextArea textAreaProcedures, textAreaDescription;
	private JSpinner spinnerLevel;
	private JComboBox<String> CBlIdRelated, CBIDFacility;
	private JComboBox<Containment> comboBoxContainment;
	private JComboBox<Discruption> comboBoxDisruption;
	private JComboBox<Risk> comboBoxRisk;
	private JComboBox<SecondaryC> comboBoxSecondary;
	private JTextArea textNameBackGround;
	private JTextArea textAreaProceduresBackGround;
	private JTextArea textidackGround;
	private JLabel lbContainment;
	private JLabel lbDisruption;
	private JLabel lbSecondary;
	private JLabel lbRisk;
	String path = "/resources/";
	String png = ".png";
	String containment;
	String disruption;
	String risk;
	String secondary;
	SCP scp_1;
	String facility_1;
	ArrayList<SCP> scp_list;
	ArrayList<String> facility_list;
	
	public CreateSCP(ArrayList<SCP> scp_list_,ArrayList<String> facility_list2) {

		setBounds(0, 0, 1024, 768);
		setLayout(null);

		scp_list = scp_list_;
		scp_1 = scp_list.get(0);
		facility_list = facility_list2;
		facility_1 = facility_list.get(0);

		lblId = new JLabel("ID");
		lblId.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblId.setBounds(25, 55, 71, 33);
		lblId.setForeground(new Color(255, 255, 255));
		add(lblId);

		fieldId = new JTextArea();
		fieldId.setWrapStyleWord(true);
		fieldId.setLineWrap(true);
		fieldId.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		fieldId.setForeground(new Color(255, 255, 255));
		fieldId.setBounds(220, 55, 279, 33);
		fieldId.setOpaque(false);
		add(fieldId);
		fieldId.setColumns(10);

		textidackGround = new JTextArea();
		textidackGround.setBackground(new Color(0, 0, 0, 60));
		textidackGround.setBounds(220, 55, 279, 33);
		textidackGround.setEnabled(false);
		textidackGround.setEditable(false);
		add(textidackGround);

		JLabel lblIdRelated = new JLabel("ID RELATED SCP");
		lblIdRelated.setForeground(Color.WHITE);
		lblIdRelated.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblIdRelated.setBounds(25, 115, 170, 40);
		add(lblIdRelated);

		CBlIdRelated = new JComboBox<String>();
		CBlIdRelated.setBackground(new Color(0, 0, 0));
		CBlIdRelated.setForeground(new Color(255, 255, 255));
		for (SCP scp : scp_list) {
			CBlIdRelated.addItem(scp.getScp_id());
		}
		CBlIdRelated.setBounds(220, 115, 279, 33);
		CBlIdRelated.addItem("NONE");
		CBlIdRelated.setSelectedItem(scp_1.getRelated_scp_id());
		CBlIdRelated.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		add(CBlIdRelated);

		lblIdFacility = new JLabel("FACILITY");
		lblIdFacility.setForeground(Color.WHITE);
		lblIdFacility.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblIdFacility.setBounds(25, 175, 170, 33);
		add(lblIdFacility);
		
		CBIDFacility = new JComboBox<String>();
		CBIDFacility.setBackground(new Color(0, 0, 0));
		CBIDFacility.setForeground(new Color(255, 255, 255));
		for (String fac : facility_list) {
			CBIDFacility.addItem(fac);
		}
		CBIDFacility.setBounds(220, 175, 279, 33);
		CBIDFacility.setSelectedItem(scp_1.getRelated_scp_id());
		CBIDFacility.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		add(CBIDFacility);

		lblName = new JLabel("NAME");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblName.setBounds(25, 235, 71, 33);
		add(lblName);

		fieldName = new JTextArea();
		fieldName.setWrapStyleWord(true);
		fieldName.setLineWrap(true);
		fieldName.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		fieldName.setForeground(new Color(255, 255, 255));
		fieldName.setBounds(220, 235, 279, 33);
		fieldName.setOpaque(false);
		add(fieldName);

		textNameBackGround = new JTextArea();
		textNameBackGround.setBackground(new Color(0, 0, 0, 60));
		textNameBackGround.setBounds(220, 235, 279, 33);
		textNameBackGround.setEnabled(false);
		textNameBackGround.setEditable(false);
		add(textNameBackGround);

		lblProcedures = new JLabel("PROCEDURES");
		lblProcedures.setBounds(25, 326, 130, 40);
		lblProcedures.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblProcedures.setForeground(Color.WHITE);
		add(lblProcedures);

		textAreaProcedures = new JTextArea();
		textAreaProcedures.setWrapStyleWord(true);
		textAreaProcedures.setLineWrap(true);
		textAreaProcedures.setForeground(new Color(255, 255, 255));
		textAreaProcedures.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		textAreaProcedures.setBounds(220, 326, 279, 162);
		textAreaProcedures.setOpaque(false);
		add(textAreaProcedures);

		textAreaProceduresBackGround = new JTextArea();
		textAreaProceduresBackGround.setBounds(220, 326, 279, 162);
		textAreaProceduresBackGround.setBackground(new Color(0, 0, 0, 60));
		textAreaProceduresBackGround.setEditable(false);
		textAreaProceduresBackGround.setEnabled(false);
		add(textAreaProceduresBackGround);

		lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setBounds(25, 496, 130, 40);
		lblDescription.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblDescription.setForeground(Color.WHITE);
		add(lblDescription);

		textAreaDescription = new JTextArea();
		textAreaDescription.setWrapStyleWord(true);
		textAreaDescription.setLineWrap(true);
		textAreaDescription.setForeground(new Color(255, 255, 255));
		textAreaDescription.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		textAreaDescription.setBounds(220, 496, 279, 179);
		textAreaDescription.setOpaque(false);
		add(textAreaDescription);

		JTextArea textAreaDescriptionBackGround = new JTextArea();
		textAreaDescriptionBackGround.setBounds(220, 496, 279, 179);
		textAreaDescriptionBackGround.setBackground(new Color(0, 0, 0, 60));
		textAreaDescriptionBackGround.setEditable(false);
		textAreaDescriptionBackGround.setEnabled(false);
		add(textAreaDescriptionBackGround);

		lblLevel = new JLabel("LEVEL");
		lblLevel.setBounds(629, 61, 71, 20);
		lblLevel.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblLevel.setForeground(Color.WHITE);
		add(lblLevel);

		spinnerLevel = new JSpinner();
		spinnerLevel.setForeground(new Color(255, 255, 255));
		spinnerLevel.setBackground(new Color(0, 0, 0));
		spinnerLevel.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerLevel.setBounds(826, 55, 130, 26);
		spinnerLevel.setOpaque(false);
		add(spinnerLevel);

		lblContainment = new JLabel("CONTAINMENT");
		lblContainment.setBounds(629, 115, 130, 20);
		lblContainment.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblContainment.setForeground(Color.WHITE);
		add(lblContainment);

		comboBoxContainment = new JComboBox<>();
		comboBoxContainment.setForeground(new Color(255, 255, 255));
		comboBoxContainment.setBackground(new Color(0, 0, 0));
		for (Containment conta : Containment.values()) {
			comboBoxContainment.addItem(conta);
		}
		comboBoxContainment.setBounds(826, 109, 130, 26);
		comboBoxContainment.setSelectedIndex(-1);
		comboBoxContainment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCombo();
			}
		});
		add(comboBoxContainment);

		lblDisruption = new JLabel("DISRUPTION");
		lblDisruption.setBounds(629, 168, 130, 20);
		lblDisruption.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblDisruption.setForeground(Color.WHITE);
		add(lblDisruption);

		comboBoxDisruption = new JComboBox<>();
		comboBoxDisruption.setBackground(new Color(0, 0, 0));
		comboBoxDisruption.setForeground(new Color(255, 255, 255));
		for (Discruption disr : Discruption.values()) {
			comboBoxDisruption.addItem(disr);
		}
		comboBoxDisruption.setBounds(826, 162, 130, 26);
		comboBoxDisruption.setSelectedIndex(-1);
		comboBoxDisruption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCombo();
			}
		});
		add(comboBoxDisruption);

		lblRisk = new JLabel("RISK");
		lblRisk.setBounds(629, 230, 71, 20);
		lblRisk.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblRisk.setForeground(Color.WHITE);

		add(lblRisk);

		comboBoxRisk = new JComboBox<>();
		comboBoxRisk.setForeground(new Color(255, 255, 255));
		comboBoxRisk.setBackground(new Color(0, 0, 0));
		for (Risk risk : Risk.values()) {
			comboBoxRisk.addItem(risk);
		}
		comboBoxRisk.setBounds(826, 224, 130, 26);
		comboBoxRisk.setSelectedIndex(-1);
		comboBoxRisk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCombo();
			}
		});
		add(comboBoxRisk);

		lblSecondary = new JLabel("SECONDARY");
		lblSecondary.setBounds(629, 286, 130, 20);
		lblSecondary.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblSecondary.setForeground(Color.WHITE);
		add(lblSecondary);

		comboBoxSecondary = new JComboBox<>();
		comboBoxSecondary.setForeground(new Color(255, 255, 255));
		comboBoxSecondary.setBackground(new Color(0, 0, 0));
		for (SecondaryC secon : SecondaryC.values()) {
			comboBoxSecondary.addItem(secon);
		}
		comboBoxSecondary.setBounds(826, 280, 130, 26);
		comboBoxSecondary.setSelectedIndex(-1);
		comboBoxSecondary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCombo();
			}
		});
		add(comboBoxSecondary);

		btnReset = new JButton("RESET");
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("OCR A EXTENDED", Font.BOLD, 16));
		btnReset.setBackground(Color.BLACK);
		btnReset.setBounds(629, 635, 130, 40);
		btnReset.addActionListener(this);
		add(btnReset);

		btnCreate = new JButton("CREATE");
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("OCR A EXTENDED", Font.BOLD, 16));
		btnCreate.setBackground(Color.BLACK);
		btnCreate.setBounds(826, 635, 130, 40);
		btnCreate.addActionListener(this);
		add(btnCreate);

		containment = path + comboBoxContainment.getSelectedItem() + png;

		disruption = path + comboBoxDisruption.getSelectedItem() + png;

		risk = path + comboBoxRisk.getSelectedItem() + png;

		secondary = path + comboBoxSecondary.getSelectedItem() + png;

		lbContainment = new JLabel("");
		lbContainment.setIcon(new ImageIcon(CreateSCP.class.getResource("/resources/NULL.png")));
		lbContainment.setVerticalAlignment(SwingConstants.BOTTOM);
		lbContainment.setHorizontalAlignment(SwingConstants.CENTER);
		lbContainment.setBounds(732, 348, 120, 113);
		add(lbContainment);

		lbDisruption = new JLabel("");
		lbDisruption.setIcon(new ImageIcon(CreateSCP.class.getResource("/resources/NULL.png")));
		lbDisruption.setVerticalAlignment(SwingConstants.BOTTOM);
		lbDisruption.setHorizontalAlignment(SwingConstants.CENTER);
		lbDisruption.setBounds(666, 423, 103, 113);
		add(lbDisruption);

		lbSecondary = new JLabel("");
		lbSecondary.setIcon(new ImageIcon(CreateSCP.class.getResource("/resources/NULL.png")));
		lbSecondary.setVerticalAlignment(SwingConstants.BOTTOM);
		lbSecondary.setHorizontalAlignment(SwingConstants.CENTER);
		lbSecondary.setBounds(732, 436, 120, 179);
		add(lbSecondary);

		lbRisk = new JLabel("");
		lbRisk.setIcon(new ImageIcon(CreateSCP.class.getResource("/resources/NULL.png")));
		lbRisk.setVerticalAlignment(SwingConstants.BOTTOM);
		lbRisk.setHorizontalAlignment(SwingConstants.CENTER);
		lbRisk.setBounds(810, 402, 120, 134);
		add(lbRisk);

		JLabel lbOctagono = new JLabel("");
		lbOctagono.setIcon(new ImageIcon(CreateSCP.class.getResource("/resources/Octagono_400.png")));
		lbOctagono.setBounds(594, 336, 342, 287);
		add(lbOctagono);

		background = new JLabel("bg");
		background.setBounds(0, 0, 1040, 712);
		background.setForeground(Color.WHITE);
		background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
		add(background);

	}

	protected void UpdateCombo() {
		containment = path + comboBoxContainment.getSelectedItem() + png;

		disruption = path + comboBoxDisruption.getSelectedItem() + png;

		risk = path + comboBoxRisk.getSelectedItem() + png;

		secondary = path + comboBoxSecondary.getSelectedItem() + png;

		lbContainment.setIcon(new ImageIcon(CreateSCP.class.getResource(containment)));
		lbDisruption.setIcon(new ImageIcon(CreateSCP.class.getResource(disruption)));
		lbRisk.setIcon(new ImageIcon(CreateSCP.class.getResource(risk)));
		lbSecondary.setIcon(new ImageIcon(CreateSCP.class.getResource(secondary)));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// If you click on "Create", a new SCP is created
		if (e.getSource().equals(btnCreate)) {
			Overseer Ove_scp = new Overseer();
			Ove_scp.addSCP();
			JOptionPane.showMessageDialog(null, "The SCP has been create");

		}

		// If you click on "Reset", all data entered so far will be deleted
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
