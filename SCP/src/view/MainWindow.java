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

	//private final JPanel contentPanel = new JPanel();
	private JTabbedPane tabbedPane;
	
	//buttons tab
	private JButton btnShowInfo,btnAddScp,btnAddWorker,btnAsignScientist,btnAsignAgent,btnLevelUpWorker,btnDeleteScp,btnDeleteWorker,btnAsigned;

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
	private String userID,userTypeID,userType;
	private Worker worker;
	
	public MainWindow(String usernameUsuario) {
					
		setBounds(100, 100, 1024, 768);
		//adapta la ventana a la pantalla
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		getContentPane().setLayout(new BorderLayout());
		
		tabbedPane = new JTabbedPane();

		userID = usernameUsuario;
		userTypeID = userID.substring(0, 3);
		userType = "undefined";
		
		JComponent panel = null;
		
		if(userTypeID.equalsIgnoreCase("SCI"))
		{
			userType = "SCIENTIFIC";
			panel = makePanelScientific("Panel Scientific");
			tabbedPane.addTab("Tab", null, panel, "Panel");			
		}        	
        else if(userTypeID.equalsIgnoreCase("AGE"))
        {
        	userType = "AGENT";
        	panel = makePanelAgent("Panel Agent");
			tabbedPane.addTab("Tab", null, panel, "Panel");       	
        }        	
        else if(userTypeID.equalsIgnoreCase("OVE"))
        {
        	userType = "OVERSEER";
        	panel = makePanelOverseer("Panel Overseer");
			tabbedPane.addTab("Tab", null, panel, "Panel");     	
        }	
		
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		/*tabbedPane.setUI(new BasicTabbedPaneUI() {  
		    @Override  
		    protected int calculateTabAreaHeight(int tab_placement, int run_count, int max_tab_height) {  
		        /*if (tabbedPane.getTabCount() > 1)
		            return super.calculateTabAreaHeight(tab_placement, run_count, max_tab_height);  
		        else  
		            return 0;  
		    }  
		});*/  		
		//desabilita el cambiar a una tab expecifica
		//tabbedPane.setEnabledAt(1, false);
		//hace invisible las tabs
		//tabbedPane.setVisible(false);
	}
	private JComponent makePanelScientific(String string) {
		JPanel panel = null;
		panel = createBasicPanel(panel);
		
		btnAsigned = new JButton("ASIGNED SCP");
		btnAsigned.setBounds(55, 169, 227, 54);
		btnAsigned.addActionListener(this);
        panel.add(btnAsigned);
	    
		return panel;
	}
	
	private JComponent makePanelAgent(String string) {
		JPanel panel = null;
		panel = createBasicPanel(panel);
		
		btnAsigned = new JButton("ASIGNED FACILITY");
		btnAsigned.setBounds(55, 169, 227, 54);
		btnAsigned.addActionListener(this);
        panel.add(btnAsigned);
	    
		return panel;
	}

	private JComponent makePanelOverseer(String text) {
		JPanel panel = null;
		panel = createBasicPanel(panel);

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

		return panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnShowInfo)){
			showInfoWindow();
		}
		if (e.getSource().equals(btnAddScp)){
			
		}
		if (e.getSource().equals(btnAddWorker)){
			addWorkerWindow();		
		}
		if (e.getSource().equals(btnAsignScientist)){
			
		}
		if (e.getSource().equals(btnAsignAgent)){
			
		}
		if (e.getSource().equals(btnLevelUpWorker)){
			Overseer over = new Overseer();
			over.showInfo("AGE-0003");
			over.levelUpWorker((Worker)over);
		}
		if (e.getSource().equals(btnDeleteScp)){
			
		}
		if (e.getSource().equals(btnDeleteWorker)){
			
		}		
		//Add Worker Buttons
		if (e.getSource().equals(btnAgent)){
			
		}
		if (e.getSource().equals(btnScientist)){
			
		}
		if (e.getSource().equals(btnOverseer)){
			
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
	    
	    background = new JLabel("bg");
        background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
        background.setBounds(0, 0, 1024, 768);
        panelAdd.add(background);
        
	    tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
	}
	private void showInfoWindow() {
		//id introducida previamente
		//Worker wObj = new Worker();
		if(userTypeID.equalsIgnoreCase("SCI"))
		{
			worker = new Scientific();
		}        	
        else if(userTypeID.equalsIgnoreCase("AGE"))
        {
        	worker = new Agent();
        }        	
        else if(userTypeID.equalsIgnoreCase("OVE"))
        {
        	worker = new Overseer();
        }	
		
		String idWorker = userID;		
		worker.showInfo(idWorker);
			
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
		lblId.setForeground(Color.WHITE);
		panel.add(lblId);
		
		lblName = new JLabel("NAME");
		lblName.setBounds(300, 112, 132, 40);
		lblName.setForeground(Color.WHITE);
		panel.add(lblName);
		
		lblDateEntry = new JLabel("DATE ENTRY");
		lblDateEntry.setBounds(300, 163, 132, 40);
		lblDateEntry.setForeground(Color.WHITE);
		panel.add(lblDateEntry);
		
		lblActive = new JLabel("ACTIVE");
		lblActive.setBounds(300, 214, 132, 40);
		lblActive.setForeground(Color.WHITE);
		panel.add(lblActive);
		
		lblLevel = new JLabel("LEVEL");
		lblLevel.setBounds(300, 265, 132, 40);
		lblLevel.setForeground(Color.WHITE);
		panel.add(lblLevel);
		
		lblBoss = new JLabel("BOSS ID");
		lblBoss.setBounds(300, 321, 132, 40);
		lblBoss.setForeground(Color.WHITE);
		panel.add(lblBoss);

		textFieldId = new JTextField(idWorker);
		textFieldId.setBounds(400, 61, 231, 30);
		panel.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldName = new JTextField(worker.getName());
		textFieldName.setColumns(10);
		textFieldName.setBounds(400, 117, 231, 30);
		panel.add(textFieldName);
		
		textFieldDate = new JTextField(worker.getDate_Entry().toString());
		textFieldDate.setColumns(10);
		textFieldDate.setBounds(400, 168, 231, 30);
		panel.add(textFieldDate);
		
		checkBoxActive = new JCheckBox();
		checkBoxActive.setSelected(worker.isActive());
		checkBoxActive.setBounds(400, 214, 231, 30);
		panel.add(checkBoxActive);
		
		lblLevelNumber = new JLabel(String.format("%d", worker.getLevel()));
		lblLevelNumber.setBounds(400, 265, 132, 40);
		lblLevelNumber.setForeground(Color.WHITE);
		panel.add(lblLevelNumber);
		
		textFieldBoss = new JTextField(worker.getBossID());
		textFieldBoss.setColumns(10);
		textFieldBoss.setBounds(400, 321, 231, 30);
		panel.add(textFieldBoss);
		 
		if(userTypeID.equalsIgnoreCase("SCI"))
		{
			lblStudies = new JLabel("Studies:    "+((Scientific)worker).getStudies());
			lblStudies.setBounds(300, 370, 500, 40);
			lblStudies.setForeground(Color.WHITE);
			panel.add(lblStudies);
		}        	
        else if(userTypeID.equalsIgnoreCase("AGE"))
        {
        	lblHistory = new JLabel("Record:    "+((Agent)worker).getHistory());
        	lblHistory.setBounds(300, 370, 500, 40);
        	lblHistory.setForeground(Color.WHITE);
			panel.add(lblHistory);
			
			lblHistory = new JLabel("Asigned Facility:    "+((Agent)worker).getId_facility());
        	lblHistory.setBounds(300, 460, 500, 40);
        	lblHistory.setForeground(Color.WHITE);
			panel.add(lblHistory);
        }        	
        else if(userTypeID.equalsIgnoreCase("OVE"))
        {
        	lblHistory = new JLabel("Continent:    "+((Overseer)worker).getContinent().name());
        	lblHistory.setBounds(300, 370, 500, 40);
        	lblHistory.setForeground(Color.WHITE);
			panel.add(lblHistory);
        }	
		
		// Instanciar Componente
		calendar = new JCalendar();	 
		// Ubicar y agregar al panel
		calendar.setBounds(700, 200, 300, 300);	 
		panel.add(calendar);	
		
		background = new JLabel("bg");
        background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
        background.setBounds(0, 0, 1024, 768);
        panel.add(background);
		
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
	}
	
	private JPanel createBasicPanel(JPanel panel) {	
		panel = new JPanel(false);
        panel.setLayout(null);
        JLabel filler = new JLabel("");
        filler.setBounds(0, 0, 1003, 701);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.add(filler);
        
		lblWelcome = new JLabel("WELCOME "+userID+": REGISTERED AS "+ userType);
	    lblWelcome.setFont(new Font("Monotxt_IV50", Font.BOLD, 20));
	    lblWelcome.setBounds(56, 15, 1000, 40);
	    lblWelcome.setForeground(Color.WHITE);
	    panel.add(lblWelcome);
	    
	    btnShowInfo = new JButton("Show Info");
        btnShowInfo.setBounds(55, 100, 227, 54);
        btnShowInfo.addActionListener(this);
        panel.add(btnShowInfo);
        
        lblLogo = new JLabel("logo");
        lblLogo.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/SCP_Foundation_logoSMALL.png")));
        lblLogo.setBounds(750, 0, 200, 200);
        panel.add(lblLogo);
        
        background = new JLabel("bg");
        background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
        background.setBounds(0, 0, 1024, 768);
        panel.add(background);
        
		return panel;
	}
}
