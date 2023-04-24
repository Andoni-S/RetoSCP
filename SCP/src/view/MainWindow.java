package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import clases.Overseer;
import clases.Worker;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class MainWindow extends JFrame implements ActionListener {

	// private final JPanel contentPanel = new JPanel();
	private JTabbedPane tabbedPane;
	private JButton btnShowInfo;
	private JButton btnAddScp;
	private JButton btnAddWorker;
	private JButton btnAsignScientist;
	private JButton btnAsignAgent;
	private JButton btnLevelUpWorker;
	private JButton btnDeleteScp;
	private JButton btnDeleteWorker;
	private JButton btnAgent;
	private JButton btnScientist;
	private JButton btnOverseer,btnShowSCP;
	private Worker worker;
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblDateEntry;
	private JLabel lblActive;
	private JLabel lblBoss;
	private JLabel lblLevel;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextField textFieldDate;
	private JCheckBox checkBoxActive;
	private JLabel lblLevelNumber;
	private JTextField textFieldBoss;
	private JLabel lblLogo;
	private JLabel lblProfileImg;
	private JCalendar calendar;

	private String userID;

	public MainWindow(String usernameUsuario) {

		setBounds(100, 100, 1024, 768);
		// adapta la ventana a la pantalla
		// setExtendedState(JFrame.MAXIMIZED_BOTH);

		getContentPane().setLayout(new BorderLayout());

		tabbedPane = new JTabbedPane();

		JComponent panel1 = makePanel1("Overseer");
		tabbedPane.addTab("Tab 1", null, panel1, "First Panel");

		JComponent scientificPanel = makePanelScientific("Scientific");
		tabbedPane.addTab("Tab 2", null, scientificPanel, "Second Panel");

		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		userID = usernameUsuario;

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

		btnAsignScientist = new JButton("Asign Scientist");
		btnAsignScientist.setBounds(55, 234, 227, 54);
		btnAsignScientist.addActionListener(this);
		panel.add(btnAsignScientist);

		btnAsignAgent = new JButton("Asign Scientist");
		btnAsignAgent.setBounds(292, 234, 227, 54);
		btnAsignAgent.addActionListener(this);
		panel.add(btnAsignAgent);

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

		lblLogo = new JLabel("logo");
		lblLogo.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/SCP_Foundation_logoSMALL.png")));
		lblLogo.setBounds(750, 0, 200, 200);
		panel.add(lblLogo);

		return panel;
	}

	private JComponent makePanelScientific(String string) {
		
		JPanel scientificPanel = new JPanel(false);
		scientificPanel.setLayout(null);
		JLabel filler = new JLabel("");
		filler.setBounds(0, 0, 1003, 701);
		filler.setHorizontalAlignment(JLabel.CENTER);
		scientificPanel.add(filler);

		btnShowInfo = new JButton("Show Info");
		btnShowInfo.setBounds(55, 48, 227, 54);
		btnShowInfo.addActionListener(this);
		scientificPanel.add(btnShowInfo);
		
		btnShowSCP = new JButton("SHOW SCP");
		btnShowSCP.setBounds(55, 169, 227, 54);
		btnShowSCP.addActionListener(this);
		scientificPanel.add(btnShowSCP);

		return scientificPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnShowInfo)) {
			showInfoWindow();
		}
		if (e.getSource().equals(btnAddScp)) {

		}
		if (e.getSource().equals(btnAddWorker)) {
			addWorkerWindow();

		}
		if (e.getSource().equals(btnAsignScientist)) {

		}
		if (e.getSource().equals(btnAsignAgent)) {

		}
		if (e.getSource().equals(btnLevelUpWorker)) {
			Overseer over = new Overseer();
			over.showInfo("AGE-0003");
			over.levelUpWorker((Worker) over);
		}
		if (e.getSource().equals(btnDeleteScp)) {

		}
		if (e.getSource().equals(btnDeleteWorker)) {

		}

		// Add Worker Buttons
		if (e.getSource().equals(btnAgent)) {

		}
		if (e.getSource().equals(btnScientist)) {

		}
		if (e.getSource().equals(btnOverseer)) {

		}

	}

	private void addWorkerWindow() {
		btnAgent = new JButton();
		btnScientist = new JButton();
		btnOverseer = new JButton();

		JPanel panelAdd = new JPanel();
		tabbedPane.addTab("Add Worker", null, panelAdd, null);
		panelAdd.setLayout(null);

		lblId = new JLabel("WORKER TYPE");
		lblId.setBounds(56, 56, 200, 40);
		panelAdd.add(lblId);

		btnAgent = new JButton("Agent");
		btnAgent.setBounds(55, 100, 100, 54);
		btnAgent.addActionListener(this);
		panelAdd.add(btnAgent);

		btnScientist = new JButton("Scientist");
		btnScientist.setBounds(255, 100, 100, 54);
		btnScientist.addActionListener(this);
		panelAdd.add(btnScientist);

		btnOverseer = new JButton("Overseer");
		btnOverseer.setBounds(455, 100, 100, 54);
		btnOverseer.addActionListener(this);
		panelAdd.add(btnOverseer);

		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
	}


	private void showInfoWindow() {

		// id introducida previamente
		String idWorker = userID;
		Worker wObj = new Worker();
		wObj.showInfo(idWorker);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Info", null, panel, null);
		panel.setLayout(null);

		lblLogo = new JLabel("logo");
		lblLogo.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/SCP_Foundation_logoSMALL.png")));
		lblLogo.setBounds(750, 0, 200, 200);
		panel.add(lblLogo);

		lblProfileImg = new JLabel("profile");
		lblProfileImg.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/profileSMALL.png")));
		lblProfileImg.setBounds(50, 50, 200, 200);
		panel.add(lblProfileImg);

		lblId = new JLabel("ID");
		lblId.setBounds(300, 56, 132, 40);
		panel.add(lblId);

		lblName = new JLabel("NAME");
		lblName.setBounds(300, 112, 132, 40);
		panel.add(lblName);

		lblDateEntry = new JLabel("DATE ENTRY");
		lblDateEntry.setBounds(300, 163, 132, 40);
		panel.add(lblDateEntry);

		lblActive = new JLabel("ACTIVE");
		lblActive.setBounds(300, 214, 132, 40);
		panel.add(lblActive);

		lblLevel = new JLabel("LEVEL");
		lblLevel.setBounds(300, 265, 132, 40);
		panel.add(lblLevel);

		lblBoss = new JLabel("BOSS ID");
		lblBoss.setBounds(300, 321, 132, 40);
		panel.add(lblBoss);

		textFieldId = new JTextField(idWorker);
		textFieldId.setBounds(400, 61, 231, 30);
		panel.add(textFieldId);
		textFieldId.setColumns(10);

		textFieldName = new JTextField(wObj.getName());
		textFieldName.setColumns(10);
		textFieldName.setBounds(400, 117, 231, 30);
		panel.add(textFieldName);

		textFieldDate = new JTextField(wObj.getDate_Entry().toString());
		textFieldDate.setColumns(10);
		textFieldDate.setBounds(400, 168, 231, 30);
		panel.add(textFieldDate);

		checkBoxActive = new JCheckBox();
		checkBoxActive.setSelected(wObj.isActive());
		checkBoxActive.setBounds(400, 214, 231, 30);
		panel.add(checkBoxActive);

		lblLevel = new JLabel(String.format("%d", wObj.getLevel()));
		lblLevel.setBounds(400, 265, 132, 40);
		panel.add(lblLevel);

		textFieldBoss = new JTextField(wObj.getBossID());
		textFieldBoss.setColumns(10);
		textFieldBoss.setBounds(400, 321, 231, 30);
		panel.add(textFieldBoss);

		// Instanciar Componente
		calendar = new JCalendar();
		// Ubicar y agregar al panel
		calendar.setBounds(600, 400, 350, 350);
		panel.add(calendar);

		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
	}
}
