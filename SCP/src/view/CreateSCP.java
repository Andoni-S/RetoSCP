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
import acs.Disruption;
import acs.Risk;
import acs.SecondaryC;
import clases.Facility;
import clases.Overseer;
import clases.SCP;
import exceptions.ServerException;
import main.OverseerFactory;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;

public class CreateSCP extends JPanel implements ActionListener {
	// We declare the necessary labels, textArea, buttons, and comboBoxes
	private static final long serialVersionUID = 1L;
	private JButton btnReset, btnCreate;
	private JLabel lblID, lblIdFacility, lblName, lblProcedures, lblDescription, lblLevel, lblContainment,
			lblDisruption, lblRisk, lblSecondary, background;
	private JTextArea fieldId, fieldName;
	private JTextArea textAreaProcedures;
	private JSpinner spinnerLevel;
	private JComboBox<String> CBlIdRelated, CBIDFacility;
	private JComboBox<Containment> comboBoxContainment;
	private JComboBox<Disruption> comboBoxDisruption;
	private JComboBox<Risk> comboBoxRisk;
	private JComboBox<SecondaryC> comboBoxSecondary;
	private JTextArea textAreaDescription ;
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
	ArrayList<Facility> facility_list;
	private JScrollPane scrollProcedure,scrollDescription;
	private JTextArea textAreaProcedure;
	private JTextArea lbTitle;

	public CreateSCP(ArrayList<SCP> scp_list_, ArrayList<Facility> facility_list2) {

		setBounds(0, 0, 1024, 768);
		setLayout(null);

		scp_list = scp_list_;
		scp_1 = scp_list.get(0);
		facility_list = facility_list2;
		facility_1 = facility_list.get(0).getFacility_id();
		
		lbTitle = new JTextArea ("CREATE NEW SCP");
		lbTitle.setFont(new Font("Chiller", Font.BOLD, 80));
		lbTitle.setForeground(new Color(255, 255, 255,90));
		lbTitle.setBounds(10, 10, 544, 81);
		lbTitle.setOpaque(false);
		add(lbTitle);
		
		lblID = new JLabel("ID");
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblID.setBounds(25, 99, 170, 40);
		add(lblID);
		
		
		fieldId = new JTextArea();
		fieldId.setWrapStyleWord(true);
		fieldId.setLineWrap(true);
		fieldId.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		fieldId.setBounds(220, 102, 295, 33);
		fieldId.setBackground(new Color(255, 255, 255));
		fieldId.setForeground(new Color(0, 0, 0));
		fieldId.setColumns(10);
		add(fieldId);
		
		JLabel lblIdRelated = new JLabel("ID RELATED SCP");
		lblIdRelated.setForeground(Color.WHITE);
		lblIdRelated.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblIdRelated.setBounds(25, 150, 170, 40);
		add(lblIdRelated);

		CBlIdRelated = new JComboBox<String>();
		CBlIdRelated.setBackground(new Color(255, 255, 255));
		CBlIdRelated.setForeground(new Color(0, 0, 0));
		for (SCP scp : scp_list) {
			CBlIdRelated.addItem(scp.getScp_id());
		}
		CBlIdRelated.setBounds(220, 155, 295, 33);
		CBlIdRelated.addItem("NONE");
		CBlIdRelated.setSelectedItem(scp_1.getRelated_scp_id());
		CBlIdRelated.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		add(CBlIdRelated);

		lblIdFacility = new JLabel("FACILITY");
		lblIdFacility.setForeground(Color.WHITE);
		lblIdFacility.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblIdFacility.setBounds(25, 216, 170, 33);
		add(lblIdFacility);

		CBIDFacility = new JComboBox<String>();
		CBIDFacility.setBackground(new Color(255, 255, 255));
		CBIDFacility.setForeground(new Color(0, 0, 0));
		for (Facility fac : facility_list) {
			CBIDFacility.addItem(fac.getFacility_id());
		}
		CBIDFacility.setBounds(220, 217, 295, 33);
		CBIDFacility.setSelectedItem(scp_1.getRelated_scp_id());
		CBIDFacility.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		add(CBIDFacility);

		lblName = new JLabel("NAME");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblName.setBounds(25, 267, 71, 33);
		add(lblName);

		fieldName = new JTextArea();
		fieldName.setWrapStyleWord(true);
		fieldName.setLineWrap(true);
		fieldName.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		fieldName.setBackground(new Color(255, 255, 255));
		fieldName.setForeground(new Color(0, 0, 0));
		fieldName.setBounds(220, 273, 295, 33);
		add(fieldName);

		lblProcedures = new JLabel("PROCEDURES");
		lblProcedures.setBounds(25, 326, 130, 40);
		lblProcedures.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblProcedures.setForeground(Color.WHITE);
		add(lblProcedures);
		
		scrollProcedure = new JScrollPane();
		scrollProcedure.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollProcedure.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollProcedure.setBounds(220, 326, 295, 157);
		scrollProcedure.getViewport().setBackground(new Color (255,255,255));
		add(scrollProcedure);
		
		textAreaProcedure = new JTextArea();
		scrollProcedure.setViewportView(textAreaProcedure);
		textAreaProcedure.setWrapStyleWord(true);
		textAreaProcedure.setOpaque(false);
		textAreaProcedure.setLineWrap(true);
		textAreaProcedure.setForeground(Color.BLACK);
		textAreaProcedure.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		textAreaProcedure.setEnabled(true);
		textAreaProcedure.setEditable(true);

		lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setBounds(25, 496, 130, 40);
		lblDescription.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblDescription.setForeground(Color.WHITE);
		add(lblDescription);

		scrollDescription = new JScrollPane();
		scrollDescription.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollDescription.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollDescription.setBounds(220, 499, 295, 179);
		scrollDescription.getViewport().setBackground(new Color (255,255,255));
		add(scrollDescription);
		
		textAreaDescription = new JTextArea();
		scrollDescription.setViewportView(textAreaDescription);
		textAreaDescription.setWrapStyleWord(true);
		textAreaDescription.setOpaque(false);
		textAreaDescription.setLineWrap(true);
		textAreaDescription.setForeground(Color.BLACK);
		textAreaDescription.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		textAreaDescription.setEnabled(true);
		textAreaDescription.setEditable(true);

		lblLevel = new JLabel("LEVEL");
		lblLevel.setBounds(629, 61, 71, 20);
		lblLevel.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblLevel.setForeground(Color.WHITE);
		add(lblLevel);

		spinnerLevel = new JSpinner();
		spinnerLevel.setForeground(new Color(0, 0, 0));
		spinnerLevel.setBackground(new Color(255, 255, 255));
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
		comboBoxContainment.setBackground(new Color(255, 255, 255));
		comboBoxContainment.setForeground(new Color(0, 0, 0));
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
		comboBoxDisruption.setBackground(new Color(255, 255, 255));
		comboBoxDisruption.setForeground(new Color(0, 0, 0));
		for (Disruption disr : Disruption.values()) {
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
		comboBoxRisk.setBackground(new Color(255, 255, 255));
		comboBoxRisk.setForeground(new Color(0, 0, 0));
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
		comboBoxSecondary.setForeground(new Color(0, 0, 0));
		comboBoxSecondary.setBackground(new Color(255, 255, 255));
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
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("OCR A EXTENDED", Font.BOLD, 16));
		btnReset.setBackground(Color.WHITE);
		btnReset.setBounds(629, 635, 130, 40);
		btnReset.addActionListener(this);
		add(btnReset);

		btnCreate = new JButton("CREATE");
		btnCreate.setForeground(Color.BLACK);
		btnCreate.setFont(new Font("OCR A EXTENDED", Font.BOLD, 16));
		btnCreate.setBackground(Color.WHITE);
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
		background.setIcon(new ImageIcon(CreateSCP.class.getResource("/resources/background2.1.png")));
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
			if (fieldId.getText().equals("") || CBlIdRelated.getSelectedItem().equals(" ")
					|| CBIDFacility.getSelectedItem().equals(" ") || fieldName.getText().equals("")
					|| textAreaProcedures.getText().equals("") || textAreaDescription.getText().equals("")
					|| comboBoxContainment.getSelectedIndex() == -1 || comboBoxDisruption.getSelectedIndex() == -1
					|| comboBoxRisk.getSelectedIndex() == -1 || comboBoxSecondary.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "There is an empty field");
			} else {
				SCP scpC = new SCP();
				scpC.setScp_id(fieldId.getText());			
				if(CBlIdRelated.getSelectedItem().toString().equals("NONE")) {
					scpC.setRelated_scp_id("NONE");
				}else {
					scpC.setRelated_scp_id((String) CBlIdRelated.getSelectedItem());
				}
				scpC.setFacility_id((String) CBIDFacility.getSelectedItem());
				scpC.setScp_name(fieldName.getText());
				scpC.setScp_procedures(textAreaProcedures.getText());
				scpC.setScp_description(textAreaDescription.getText());
				scpC.setScp_level((int) spinnerLevel.getValue());
				scpC.setContainment((Containment) comboBoxContainment.getSelectedItem());
				scpC.setDisruption((Disruption) comboBoxDisruption.getSelectedItem());
				scpC.setRisk((Risk) comboBoxRisk.getSelectedItem());
				scpC.setSecondary((SecondaryC) comboBoxSecondary.getSelectedItem());

				try {
					OverseerFactory.getOverseerDB().addSCP(scpC);
				} catch (ServerException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				JOptionPane.showMessageDialog(null, "The SCP has been created");

			}
		}

		// If you click on "Reset", all data entered so far will be deleted
		if (e.getSource().equals(btnReset)) {
			fieldId.setText("");
			CBlIdRelated.setSelectedItem(" ");
			CBIDFacility.setSelectedItem(" ");
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
