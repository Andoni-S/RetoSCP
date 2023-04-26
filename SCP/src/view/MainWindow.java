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
		
	}
}
