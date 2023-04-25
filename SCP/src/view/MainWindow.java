package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Agent;
import clases.Facility;
import clases.Worker;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class MainWindow extends JFrame implements ActionListener {

	// private final JPanel contentPanel = new JPanel();
	private JTabbedPane tabbedPane;
	private JButton btnShowInfo;
	private JButton btnAddScp;
	private JButton btnAddWorker;
	private JButton btnAssignScientist;
	private JButton btnAssignAgent;
	private JButton btnLevelUpWorker;
	private JButton btnDeleteScp;
	private JButton btnDeleteWorker;
	private JButton btnShowAssignedFacility;
	private JButton btnConfirmDeletion;
	private DefaultTableModel model;

	private JLabel lblIdFacility;
	private JLabel lblNameFacility;
	private JLabel lblLevelFacility;
	private JLabel lblWorker;
	private JLabel lblPrueba;
	private JTextField textWorker;
	private JPanel contentPane;
	private JTable tablaWorkers;

	private String workerId;

	public MainWindow(String usernameUsuario) {

		setBounds(100, 100, 1024, 768);
		// adapta la ventana a la pantalla
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().setLayout(new BorderLayout());

		tabbedPane = new JTabbedPane();

		JComponent panel1 = makePanel1("Panel #1");
		tabbedPane.addTab("Tab 1", null, panel1, "First Panel");

		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		workerId = usernameUsuario;
		// desabilita el cambiar a una tab expecifica
		// tabbedPane.setEnabledAt(1, false);
		// hace invisible las tabs
		// tabbedPane.setVisible(false);
	}

	protected JComponent makePanel1(String text) {
		JPanel panel = new JPanel(false);
		panel.setLayout(null);
		JLabel filler = new JLabel("");
		filler.setBounds(0, 0, 1003, 701);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.add(filler);

		btnShowInfo = new JButton("Show Info");
		btnShowInfo.setBounds(55, 48, 227, 54);
		btnShowInfo.addActionListener(this);
		panel.add(btnShowInfo);

		btnAddScp = new JButton("Add SCP");
		btnAddScp.setBounds(55, 169, 227, 54);
		btnAddScp.addActionListener(this);
		panel.add(btnAddScp);

		btnAddWorker = new JButton("Add Worker");
		btnAddWorker.setBounds(292, 169, 227, 54);
		btnAddWorker.addActionListener(this);
		panel.add(btnAddWorker);

		btnAssignScientist = new JButton("Assign Scientist");
		btnAssignScientist.setBounds(55, 234, 227, 54);
		btnAssignScientist.addActionListener(this);
		panel.add(btnAssignScientist);

		btnAssignAgent = new JButton("Assign Scientist");
		btnAssignAgent.setBounds(292, 234, 227, 54);
		btnAssignAgent.addActionListener(this);
		panel.add(btnAssignAgent);

		btnLevelUpWorker = new JButton("Level Up Worker");
		btnLevelUpWorker.setBounds(529, 234, 227, 54);
		btnLevelUpWorker.addActionListener(this);
		panel.add(btnLevelUpWorker);

		btnDeleteScp = new JButton("Delete SCP");
		btnDeleteScp.setBounds(55, 299, 227, 54);
		btnDeleteScp.addActionListener(this);
		panel.add(btnDeleteScp);

		btnDeleteWorker = new JButton("Delete Worker");
		btnDeleteWorker.setBounds(292, 299, 227, 54);
		btnDeleteWorker.addActionListener(this);
		panel.add(btnDeleteWorker);

		btnShowAssignedFacility = new JButton("Show Assigned Facility");
		btnShowAssignedFacility.setBounds(529, 169, 227, 54);
		btnShowAssignedFacility.addActionListener(this);
		panel.add(btnShowAssignedFacility);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(358, 599, 220, -146);
		panel.add(scrollPane);

		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnShowInfo)) {
			// showInfoWindow(workerId);
		}
		if (e.getSource().equals(btnAddScp)) {
			JPanel newPanel = new JPanel();
			tabbedPane.addTab("Add SCP", newPanel);
		}
		if (e.getSource().equals(btnAddWorker)) {

		}
		if (e.getSource().equals(btnAssignScientist)) {

		}
		if (e.getSource().equals(btnAssignAgent)) {

		}
		if (e.getSource().equals(btnLevelUpWorker)) {

		}
		if (e.getSource().equals(btnDeleteScp)) {

		}
		if (e.getSource().equals(btnDeleteWorker)) {
			deleteWork();
		}
		if (e.getSource().equals(btnShowAssignedFacility)) {
			showAssignedFacility(workerId);
		}
		if (e.getSource().equals(btnConfirmDeletion)) {
			if (textWorker.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(btnConfirmDeletion, "Empty field. Please enter an ID");
			} else {
				String workerDeletion = textWorker.getText();
				Worker work = new Worker();

				if (work.checkWorker(workerDeletion)) {

				} else {
					JOptionPane.showMessageDialog(btnConfirmDeletion, "Please insert an existing ID");
				}
			}
		}
	}

	/*
	 * private void showInfoWindow() {
	 * 
	 * 
	 * //id introducida previamente String idWorker = userID; Worker wObj = new
	 * Worker(); wObj.showInfo(idWorker);
	 * 
	 * JPanel panel = new JPanel(); tabbedPane.addTab("Info", null, panel, null);
	 * panel.setLayout(null);
	 * 
	 * lblLogo = new JLabel("logo"); lblLogo.setIcon(new
	 * ImageIcon(MainWindow.class.getResource(
	 * "/resources/SCP_Foundation_logoSMALL.png"))); lblLogo.setBounds(750, 0, 200,
	 * 200); panel.add(lblLogo);
	 * 
	 * lblProfileImg = new JLabel("profile"); lblProfileImg.setIcon(new
	 * ImageIcon(MainWindow.class.getResource("/resources/profileSMALL.png")));
	 * lblProfileImg.setBounds(50, 50, 200, 200); panel.add(lblProfileImg);
	 * 
	 * lblId = new JLabel("ID"); lblId.setBounds(300, 56, 132, 40);
	 * panel.add(lblId);
	 * 
	 * lblName = new JLabel("NAME"); lblName.setBounds(300, 112, 132, 40);
	 * panel.add(lblName);
	 * 
	 * lblDateEntry = new JLabel("DATE ENTRY"); lblDateEntry.setBounds(300, 163,
	 * 132, 40); panel.add(lblDateEntry);
	 * 
	 * lblActive = new JLabel("ACTIVE"); lblActive.setBounds(300, 214, 132, 40);
	 * panel.add(lblActive);
	 * 
	 * lblLevel = new JLabel("LEVEL"); lblLevel.setBounds(300, 265, 132, 40);
	 * panel.add(lblLevel);
	 * 
	 * lblBoss = new JLabel("BOSS ID"); lblBoss.setBounds(300, 321, 132, 40);
	 * panel.add(lblBoss);
	 * 
	 * textFieldId = new JTextField(idWorker); textFieldId.setBounds(400, 61, 231,
	 * 30); panel.add(textFieldId); textFieldId.setColumns(10);
	 * 
	 * textFieldName = new JTextField(wObj.getName()); textFieldName.setColumns(10);
	 * textFieldName.setBounds(400, 117, 231, 30); panel.add(textFieldName);
	 * 
	 * textFieldDate = new JTextField(wObj.getDate_Entry().toString());
	 * textFieldDate.setColumns(10); textFieldDate.setBounds(400, 168, 231, 30);
	 * panel.add(textFieldDate);
	 * 
	 * checkBoxActive = new JCheckBox();
	 * checkBoxActive.setSelected(wObj.isActive()); checkBoxActive.setBounds(400,
	 * 214, 231, 30); panel.add(checkBoxActive);
	 * 
	 * lblLevel = new JLabel(String.format("%d", wObj.getLevel()));
	 * lblLevel.setBounds(400, 265, 132, 40); panel.add(lblLevel);
	 * 
	 * textFieldBoss = new JTextField(wObj.getBossID());
	 * textFieldBoss.setColumns(10); textFieldBoss.setBounds(400, 321, 231, 30);
	 * panel.add(textFieldBoss);
	 * 
	 * // Instanciar Componente calendar = new JCalendar(); // Ubicar y agregar al
	 * panel calendar.setBounds(600, 400, 350, 350); panel.add(calendar);
	 * 
	 * tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1); }
	 */

	private void showAssignedFacility(String usernameUsuario) {
		String idWorker = usernameUsuario;
		Agent wAge = new Agent();
		Facility fac;
		fac = wAge.showAsignedFacility(idWorker);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Facility Info.", null, panel, null);
		panel.setLayout(null);

		lblIdFacility = new JLabel("ID Facility:           " + wAge.getID_Facility());
		lblIdFacility.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblIdFacility.setBounds(125, 155, 1500, 80);
		panel.add(lblIdFacility);

		lblNameFacility = new JLabel("Name Facility:         " + fac.getFacility_name());
		lblNameFacility.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblNameFacility.setBounds(125, 310, 1500, 80);
		panel.add(lblNameFacility);

		lblLevelFacility = new JLabel("Level Facility:        " + String.format("%d", fac.getFacility_level()));
		lblLevelFacility.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		lblLevelFacility.setBounds(125, 465, 1500, 80);
		panel.add(lblLevelFacility);

		tabbedPane.setSelectedIndex(1);
	}

	private void deleteWork() {
		Worker work = new Worker();
		ArrayList<Worker> arrayDeWorkers = work.showAllWorkers();

		JPanel panel = new JPanel();
		tabbedPane.addTab("Delete Worker", null, panel, null);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 100, 800, 359);
		panel.add(scrollPane);

		tablaWorkers = new JTable();
		
		model = new DefaultTableModel();
		tablaWorkers.setModel(model);
		
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Date Entry");
		
		scrollPane.setViewportView(tablaWorkers);

		lblWorker = new JLabel("Insert the ID of the worker:");
		lblWorker.setFont(new Font("OCR A Extended", Font.BOLD, 22));
		lblWorker.setBounds(80, 600, 1500, 80);
		panel.add(lblWorker);

		textWorker = new JTextField();
		textWorker.setBounds(475, 627, 275, 25);
		textWorker.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		panel.add(textWorker);
		textWorker.setColumns(10);

		btnConfirmDeletion = new JButton("Show Info");
		btnConfirmDeletion.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		btnConfirmDeletion.setBounds(775, 615, 120, 45);
		panel.add(btnConfirmDeletion);
		btnConfirmDeletion.addActionListener(this);

	}
	
	public void fillTable() {
		Worker work = new Worker();
		ArrayList<Worker> arrayDeWorkers = work.showAllWorkers();
		
		for (Worker worker : arrayDeWorkers) {
			
		}
	}
}
