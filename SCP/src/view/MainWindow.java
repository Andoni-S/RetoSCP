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
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import com.toedter.calendar.JCalendar;

import clases.Agent;
import clases.Overseer;
import clases.Scientific;
import clases.Worker;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class MainWindow extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private final JPanel contentPanel = new JPanel();
	public JTabbedPane tabbedPane;
	
	//buttons tab
	public JButton btnShowInfo,btnAddScp,btnAddWorker,btnAsignScientist,btnAsignAgent,btnLevelUpWorker,btnDeleteScp,btnDeleteWorker,btnAsigned;

	//button Add Worker Overseer
	private JButton btnAgent,btnScientist,btnOverseer;
		
	//Labels Info Worker
	private JLabel lblId,lblName,lblDateEntry,lblActive,lblBoss,lblLevel,lblLevelNumber,lblStudies,lblFacility,lblHistory,lblContinent;
	//Text Fields Info Worker
	private JTextField textFieldId,textFieldName,textFieldDate,textFieldBoss;
	private JCheckBox checkBoxActive;
	
	//Label Images
	private JLabel lblLogo,lblProfileImg,lblWelcome,background;
	//Calendar
	private JCalendar calendar;	 
	private String userTypeID,userType;
	private Worker worker;
	
	public MainWindow(String usernameUsuario) {
					
		setBounds(100, 100, 1024, 768);
		//adapta la ventana a la pantalla
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		getContentPane().setLayout(new BorderLayout());
		
		tabbedPane = new JTabbedPane();

		userTypeID = usernameUsuario.substring(0, 3);
		userType = "undefined";
		
		JComponent panelOverseer = null;
		//panelOverseer = makePanelOverseer("Panel Overseer");
		panelOverseer = new PanelShowInfo(worker, usernameUsuario, tabbedPane, getContentPane());
		tabbedPane.addTab("Tab", null, panelOverseer, "Panel");     
		
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		

		tabbedPane.setUI(new BasicTabbedPaneUI() {  
		    @Override  
		    protected int calculateTabAreaHeight(int tab_placement, int run_count, int max_tab_height) {  
		        /*if (tabbedPane.getTabCount() > 1)
		            return super.calculateTabAreaHeight(tab_placement, run_count, max_tab_height);  
		        else  */
		            return 0;  
		    }  
		});		
		//desabilita el cambiar a una tab expecifica
		//tabbedPane.setEnabledAt(1, false);
		//hace invisible las tabs
		//tabbedPane.setVisible(false);
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
	    
	    background = new JLabel("bg");
        background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
        background.setBounds(0, 0, 1024, 768);
        panelAdd.add(background);
        
	    tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(btnAddWorker)){
			
			//MainWindow mw;
			JComponent panelCreateWorker = null;
			panelCreateWorker = new CreateWorker();
			tabbedPane.addTab("Tab", null, panelCreateWorker, "Panel");     
			
			getContentPane().add(tabbedPane, BorderLayout.CENTER);
			
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);	
		}
		if (e.getSource().equals(btnShowInfo)) {
			// showInfoWindow(workerId);
		}
		if (e.getSource().equals(btnAddScp)) {
			JPanel newPanel = new JPanel();
			tabbedPane.addTab("Add SCP", newPanel);
		}
		if (e.getSource().equals(btnAddWorker)) {

		}
		/*if (e.getSource().equals(btnAssignScientist)) {

		}
		if (e.getSource().equals(btnAssignAgent)) {

		}*/
		if (e.getSource().equals(btnLevelUpWorker)) {

		}
		if (e.getSource().equals(btnDeleteScp)) {

		}
		if (e.getSource().equals(btnDeleteWorker)) {
			//deleteWork();
		}
		/*if (e.getSource().equals(btnShowAssignedFacility)) {
			showAssignedFacility(workerId);
		}
		if (e.getSource().equals(btnConfirmDeletion)) {
			if (textWorker.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(tablaWorkers, "Empty field. Please enter an ID");
			} else {
				String workerDeletion = textWorker.getText();
				Worker work = new Worker();

				if (work.checkWorker(workerDeletion)) {

				} else {
					JOptionPane.showMessageDialog(tablaWorkers, "Please insert an existing ID");
				}
			}
		}*/
	}

	/*private void showAssignedFacility(String usernameUsuario) {
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
	}*/

	/*private void deleteWork() {
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
		
		fillTable();

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
			Object[] fila = new Object[3];
			fila[0] = worker.getId();
			fila[1] = worker.getName();
			fila[2] = worker.getDate_Entry();

			model.addRow(fila);
		}
	}*/
}
