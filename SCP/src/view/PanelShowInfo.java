package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clases.Agent;
import clases.Facility;
import clases.Overseer;
import clases.SCP;
import clases.Scientific;
import clases.Worker;
import exceptions.ServerException;
import main.AgentFactory;
import main.LoginableFactory;
import main.OverseerFactory;
import main.ScientificFactory;

public class PanelShowInfo extends JPanel implements ActionListener {

	private JButton btnAddScp, btnAddWorker, btnAsignScientist, btnAsignAgent, btnLevelUpWorker, btnDeleteScp,
	btnDeleteWorker, btnAsigned, btnAsignedFacility;
	private JLabel lblId, lblName, lblDateEntry, lblActive, lblBoss, lblLevel, lblLevelNumber, lblHistory, lblContinent,
	background, lblProfileImg, lblRecord;
	private JTextArea txtAreaAge, textAreaId, textAreaName, textAreaDate, textAreaBoss, txtAreaHistory,
	txtAreaContinent;
	private String userTypeID, userType, userID;
	private JCheckBox checkBoxActive;
	private JTabbedPane tabbedPane;
	private Container container;

	public PanelShowInfo(Worker worker, String usernameUsuario, JTabbedPane tabbedPane_, Container pane) {
		// JPanel panel = null;
		tabbedPane = tabbedPane_;
		container = pane;

		
		setBounds(0, 0, 1024, 768);
		setLayout(null);

		userTypeID = usernameUsuario.substring(0, 3);
		userType = "undefined";

		try {			
			if (userTypeID.equalsIgnoreCase("SCI")) {
				worker = ScientificFactory.getScientificDB().showInfo(usernameUsuario);				
			} else if (userTypeID.equalsIgnoreCase("AGE")) {
				worker = AgentFactory.getAgentDB().showInfo(usernameUsuario);
			} else if (userTypeID.equalsIgnoreCase("OVE")) {
				worker = OverseerFactory.getOverseerDB().showInfo(usernameUsuario);
			}
		} catch (ServerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage());
		}	
		userID = usernameUsuario;

		lblProfileImg = new JLabel("profile");
		lblProfileImg.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/profileSMALL.png")));
		lblProfileImg.setBounds(50, 50, 200, 200);
		add(lblProfileImg);

		lblId = new JLabel("ID");
		lblId.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblId.setBounds(300, 50, 132, 40);
		lblId.setForeground(Color.WHITE);
		add(lblId);

		lblName = new JLabel("NAME");
		lblName.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblName.setBounds(300, 100, 132, 40);
		lblName.setForeground(Color.WHITE);
		add(lblName);

		lblDateEntry = new JLabel("DATE ENTRY");
		lblDateEntry.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblDateEntry.setBounds(300, 150, 132, 40);
		lblDateEntry.setForeground(Color.WHITE);
		add(lblDateEntry);

		lblActive = new JLabel("ACTIVE");
		lblActive.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblActive.setBounds(300, 214, 94, 40);
		lblActive.setForeground(Color.WHITE);
		add(lblActive);

		lblLevel = new JLabel("LEVEL");
		lblLevel.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblLevel.setBounds(300, 255, 132, 40);
		lblLevel.setForeground(Color.WHITE);
		add(lblLevel);

		lblBoss = new JLabel("BOSS ID");
		lblBoss.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblBoss.setBounds(300, 301, 132, 40);
		lblBoss.setForeground(Color.WHITE);
		add(lblBoss);

		textAreaId = new JTextArea(usernameUsuario);
		textAreaId.setOpaque(false);
		textAreaId.setForeground(SystemColor.inactiveCaption);
		textAreaId.setBackground(new Color(0, 0, 0));
		textAreaId.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		textAreaId.setEditable(false);
		textAreaId.setBounds(400, 61, 231, 18);
		add(textAreaId);
		textAreaId.setColumns(10);

		JTextArea textAreaIdTransparente = new JTextArea();
		textAreaIdTransparente.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		textAreaIdTransparente.setBounds(400, 61, 231, 18);
		textAreaIdTransparente.setBackground(new Color(0, 0, 0, 80));
		textAreaIdTransparente.setEditable(false);
		textAreaIdTransparente.setEnabled(false);
		add(textAreaIdTransparente);

		textAreaName = new JTextArea(worker.getName());
		textAreaName.setOpaque(false);
		textAreaName.setForeground(SystemColor.inactiveCaption);
		textAreaName.setBackground(new Color(0, 0, 0));
		textAreaName.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		textAreaName.setEditable(false);
		textAreaName.setColumns(10);
		textAreaName.setBounds(400, 111, 231, 18);
		add(textAreaName);

		JTextArea textAreaNameTransparente = new JTextArea();
		textAreaNameTransparente.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		textAreaNameTransparente.setBounds(400, 111, 231, 18);
		textAreaNameTransparente.setBackground(new Color(0, 0, 0, 80));
		textAreaNameTransparente.setEditable(false);
		textAreaNameTransparente.setEnabled(false);
		add(textAreaNameTransparente);

		textAreaDate = new JTextArea(worker.getDate_Entry().toString());
		textAreaDate.setOpaque(false);
		textAreaDate.setForeground(SystemColor.inactiveCaption);
		textAreaDate.setBackground(new Color(0, 0, 0));
		textAreaDate.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		textAreaDate.setEditable(false);
		textAreaDate.setColumns(10);
		textAreaDate.setBounds(400, 161, 231, 18);
		add(textAreaDate);

		JTextArea textAreaDateTransparente = new JTextArea();
		textAreaDateTransparente.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		textAreaDateTransparente.setBounds(400, 161, 231, 18);
		textAreaDateTransparente.setBackground(new Color(0, 0, 0, 80));
		textAreaDateTransparente.setEditable(false);
		textAreaDateTransparente.setEnabled(false);
		add(textAreaDateTransparente);

		checkBoxActive = new JCheckBox();
		checkBoxActive.setBackground(new Color(0, 0, 0, 0));
		checkBoxActive.setSelected(worker.isActive());
		checkBoxActive.setBounds(400, 220, 32, 30);
		checkBoxActive.setEnabled(false);
		add(checkBoxActive);

		lblLevelNumber = new JLabel(String.format("%d", worker.getLevel()));
		lblLevelNumber.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblLevelNumber.setBounds(400, 255, 132, 40);
		lblLevelNumber.setForeground(SystemColor.inactiveCaption);
		add(lblLevelNumber);

		textAreaBoss = new JTextArea(worker.getBossID());
		textAreaBoss.setOpaque(false);
		textAreaBoss.setForeground(SystemColor.inactiveCaption);
		textAreaBoss.setBackground(new Color(0, 0, 0));
		textAreaBoss.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		textAreaBoss.setEditable(false);
		textAreaBoss.setColumns(10);
		textAreaBoss.setBounds(400, 312, 231, 18);
		add(textAreaBoss);

		JTextArea textAreaBossTransparente = new JTextArea();
		textAreaBossTransparente.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		textAreaBossTransparente.setBounds(400, 312, 231, 18);
		textAreaBossTransparente.setBackground(new Color(0, 0, 0, 80));
		textAreaBossTransparente.setEditable(false);
		textAreaBossTransparente.setEnabled(false);
		add(textAreaBossTransparente);


		if (userTypeID.equalsIgnoreCase("SCI")) {
			lblProfileImg.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/profileScientific.gif")));
			
			lblRecord = new JLabel("STUDIES");
			lblRecord.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			lblRecord.setBounds(300, 390, 132, 40);
			lblRecord.setForeground(Color.WHITE);
			add(lblRecord);

			txtAreaAge = new JTextArea(((Scientific) worker).getStudies());
			txtAreaAge.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			txtAreaAge.setBounds(400, 390, 400, 160);
			txtAreaAge.setForeground(SystemColor.inactiveCaption);
			txtAreaAge.setEditable(false);
			txtAreaAge.setWrapStyleWord(true);
			txtAreaAge.setLineWrap(true);
			txtAreaAge.setOpaque(false);
			add(txtAreaAge);

			JTextArea textAreaProceduresTransparente = new JTextArea();
			textAreaProceduresTransparente.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			textAreaProceduresTransparente.setBounds(400, 390, 350, 160);
			textAreaProceduresTransparente.setBackground(new Color(0, 0, 0, 80));
			textAreaProceduresTransparente.setEditable(false);
			textAreaProceduresTransparente.setEnabled(false);
			add(textAreaProceduresTransparente);

			btnAsigned = new JButton("ASSIGNED SCP");
			btnAsigned.setBounds(750, 52, 200, 40);
			btnAsigned.setBackground(Color.black);
			btnAsigned.setForeground(Color.white);
			btnAsigned.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnAsigned.addActionListener(this);
			setLayout(null);
			add(btnAsigned);
		} else if (userTypeID.equalsIgnoreCase("AGE")) {

			lblProfileImg.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/profileAgent.gif")));
			
			lblRecord = new JLabel("RECORD");
			lblRecord.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			lblRecord.setBounds(300, 390, 132, 40);
			lblRecord.setForeground(Color.WHITE);
			add(lblRecord);

			txtAreaAge = new JTextArea(((Agent) worker).getHistory());
			txtAreaAge.setForeground(SystemColor.inactiveCaption);
			txtAreaAge.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			txtAreaAge.setBounds(400, 390, 350, 160);
			txtAreaAge.setEditable(false);
			txtAreaAge.setWrapStyleWord(true);
			txtAreaAge.setLineWrap(true);
			txtAreaAge.setOpaque(false);
			add(txtAreaAge);

			JTextArea textAreaProceduresTransparente = new JTextArea();
			textAreaProceduresTransparente.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			textAreaProceduresTransparente.setBounds(400, 390, 350, 160);
			textAreaProceduresTransparente.setBackground(new Color(0, 0, 0, 80));
			textAreaProceduresTransparente.setEditable(false);
			textAreaProceduresTransparente.setEnabled(false);
			add(textAreaProceduresTransparente);

			lblHistory = new JLabel("FACILITY      ");
			lblHistory.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			lblHistory.setBounds(300, 560, 500, 40);
			lblHistory.setForeground(Color.WHITE);
			add(lblHistory);

			txtAreaHistory = new JTextArea(((Agent) worker).getId_facility());
			txtAreaHistory.setOpaque(false);
			txtAreaHistory.setForeground(SystemColor.inactiveCaption);
			txtAreaHistory.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			txtAreaHistory.setBounds(400, 572, 231, 18);
			txtAreaHistory.setEditable(false);
			txtAreaHistory.setWrapStyleWord(true);
			txtAreaHistory.setLineWrap(true);
			txtAreaHistory.setOpaque(false);
			add(txtAreaHistory);

			JTextArea textAreaHistoryTransparente = new JTextArea();
			textAreaHistoryTransparente.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			textAreaHistoryTransparente.setBounds(400, 572, 231, 18);
			;
			textAreaHistoryTransparente.setBackground(new Color(0, 0, 0, 80));
			textAreaHistoryTransparente.setEditable(false);
			textAreaHistoryTransparente.setEnabled(false);
			add(textAreaHistoryTransparente);

			btnAsignedFacility = new JButton("ASSIGNED FACILITY");
			btnAsignedFacility.setBounds(750, 52, 200, 40);
			btnAsignedFacility.setBackground(Color.black);
			btnAsignedFacility.setForeground(Color.white);
			btnAsignedFacility.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnAsignedFacility.addActionListener(this);
			add(btnAsignedFacility);

		} else if (userTypeID.equalsIgnoreCase("OVE")) {
			
			lblProfileImg.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/profileOverseer.gif")));
			
			lblContinent = new JLabel("CONTINENT     ");
			lblContinent.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
			lblContinent.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			lblContinent.setBounds(300, 370, 500, 40);
			lblContinent.setForeground(Color.WHITE);
			add(lblContinent);

			txtAreaContinent = new JTextArea(((Overseer) worker).getContinent().name());
			txtAreaContinent.setOpaque(false);
			txtAreaContinent.setForeground(SystemColor.inactiveCaption);
			txtAreaContinent.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			txtAreaContinent.setBounds(400, 381, 231, 18);
			txtAreaContinent.setEditable(false);
			txtAreaContinent.setWrapStyleWord(true);
			txtAreaContinent.setLineWrap(true);
			txtAreaContinent.setOpaque(false);
			add(txtAreaContinent);

			JTextArea textAreaContinentTransparente = new JTextArea();
			textAreaContinentTransparente.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			textAreaContinentTransparente.setBounds(400, 381, 231, 18);
			;
			textAreaContinentTransparente.setBackground(new Color(0, 0, 0, 80));
			textAreaContinentTransparente.setEditable(false);
			textAreaContinentTransparente.setEnabled(false);
			add(textAreaContinentTransparente);

			btnAddScp = new JButton("ADD SCP");
			btnAddScp.setBounds(750, 30, 200, 40);
			btnAddScp.setBackground(Color.black);
			btnAddScp.setForeground(Color.white);
			btnAddScp.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnAddScp.addActionListener(this);
			add(btnAddScp);

			btnAddWorker = new JButton("ADD WORKER");
			btnAddWorker.setBounds(750, 130, 200, 40);
			btnAddWorker.setBackground(Color.black);
			btnAddWorker.setForeground(Color.white);
			btnAddWorker.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnAddWorker.addActionListener(this);
			add(btnAddWorker);

			btnAsignAgent = new JButton("ASSIGN FACILITY");
			btnAsignAgent.setBounds(750, 230, 200, 40);
			btnAsignAgent.setBackground(Color.black);
			btnAsignAgent.setForeground(Color.white);
			btnAsignAgent.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnAsignAgent.addActionListener(this);
			add(btnAsignAgent);

			btnLevelUpWorker = new JButton("LEVEL UP WORKER");
			btnLevelUpWorker.setBounds(750, 330, 200, 40);
			btnLevelUpWorker.setBackground(Color.black);
			btnLevelUpWorker.setForeground(Color.white);
			btnLevelUpWorker.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnLevelUpWorker.addActionListener(this);
			add(btnLevelUpWorker);

			btnDeleteScp = new JButton("DELETE SCP");
			btnDeleteScp.setBounds(750, 430, 200, 40);
			btnDeleteScp.setBackground(Color.black);
			btnDeleteScp.setForeground(Color.white);
			btnDeleteScp.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnDeleteScp.addActionListener(this);
			add(btnDeleteScp);

			btnDeleteWorker = new JButton("DELETE WORKER");
			btnDeleteWorker.setBounds(750, 530, 200, 40);
			btnDeleteWorker.setBackground(Color.black);
			btnDeleteWorker.setForeground(Color.white);
			btnDeleteWorker.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnDeleteWorker.addActionListener(this);
			add(btnDeleteWorker);

			btnAsignScientist = new JButton("ASSIGN SCIENTIST");
			btnAsignScientist.setBounds(750, 630, 200, 40);
			btnAsignScientist.setBackground(Color.black);
			btnAsignScientist.setForeground(Color.white);
			btnAsignScientist.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnAsignScientist.addActionListener(this);
			add(btnAsignScientist);
		}

		background = new JLabel("bg");
		background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
		background.setBounds(0, 0, 1024, 768);
		add(background);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAsignedFacility)) {
			JComponent panelShowFacility = null;
			panelShowFacility = new ShowFacility(userID);
			tabbedPane.addTab("Asigned Facility", null, panelShowFacility, "Panel");
			container.add(tabbedPane, BorderLayout.CENTER);
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		}
		if (e.getSource().equals(btnAsigned)){
			Scientific sci = new Scientific();
			ArrayList<SCP> scp_list = null;
			try {
				scp_list = ScientificFactory.getScientificDB().showAsignedSCP(userID);
			} catch (ServerException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}

			JComponent panelShowSCP = null;
			panelShowSCP = new PanelShowScp(scp_list);
			tabbedPane.addTab("Show SCP", null, panelShowSCP, "Panel");
			container.add(tabbedPane, BorderLayout.CENTER);
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		}
		if (e.getSource().equals(btnAddScp)){
			JComponent panelCreateWorker = null;
			ArrayList<Facility> facility_list = null;
			ArrayList<SCP> scp_list = null;
			try {
				scp_list = OverseerFactory.getOverseerDB().showAllSCP();		
				facility_list = AgentFactory.getAgentDB().showAllFacilities();
			} catch (ServerException e1) {
				
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			panelCreateWorker = new CreateSCP(scp_list, facility_list);
			tabbedPane.addTab("Add SCP", null, panelCreateWorker, "Panel");
			container.add(tabbedPane, BorderLayout.CENTER);
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		}

		if (e.getSource().equals(btnAddWorker)) {
			JComponent panelCreateWorker = null;
			panelCreateWorker = new CreateWorker();
			tabbedPane.addTab("Add Worker", null, panelCreateWorker, "Panel");
			container.add(tabbedPane, BorderLayout.CENTER);
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		}

		if (e.getSource().equals(btnAsignScientist)) {
			JComponent panelAsignScientist = null;
			panelAsignScientist = new AsignSCPtoScientist();
			tabbedPane.addTab("Asign SCP", null, panelAsignScientist, "Panel");
			container.add(tabbedPane, BorderLayout.CENTER);
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		}

		if (e.getSource().equals(btnAsignAgent)) {
			JComponent panelAssignAgentToFacility = null;
			panelAssignAgentToFacility = new AssignAgentToFacility();
			tabbedPane.addTab("Asign Agent", null, panelAssignAgentToFacility, "Panel");
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);		}

		if (e.getSource().equals(btnLevelUpWorker)) {
			JComponent panelLevelUp = null;
			panelLevelUp = new LevelUpWorker();
			tabbedPane.addTab("Level UP", null, panelLevelUp, "Panel");
			container.add(tabbedPane, BorderLayout.CENTER);
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		}

		if (e.getSource().equals(btnDeleteScp)) {
			JComponent panelDeleteSCP = null;
			panelDeleteSCP = new DeleteSCP();
			tabbedPane.addTab("Delete SCP", null, panelDeleteSCP, "Panel");
			container.add(tabbedPane, BorderLayout.CENTER);
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		}

		if (e.getSource().equals(btnDeleteWorker)) {
			JComponent panelDeleteWorker = null;
			panelDeleteWorker = new DeleteWorker();
			tabbedPane.addTab("Delete Worker", null, panelDeleteWorker, "Panel");
			container.add(tabbedPane, BorderLayout.CENTER);
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		}
	}
}
