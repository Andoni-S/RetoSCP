package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clases.Agent;
import clases.Facility;
import clases.Overseer;
import clases.Scientific;
import clases.Worker;

public class PanelShowInfo extends JPanel implements ActionListener{

	private JButton btnAddScp,btnAddWorker,btnAsignScientist,btnAsignAgent,btnLevelUpWorker,btnDeleteScp,btnDeleteWorker,btnAsigned,btnAsignedFacility;
	private JLabel lblId,lblName,lblDateEntry,lblActive,lblBoss,lblLevel,lblLevelNumber,lblStudies,lblFacility,lblHistory,lblContinent,lblLogo,lblWelcome,background,lblProfileImg;
	private JLabel lblRecord;
	private JTextField textFieldId,textFieldName,textFieldDate,textFieldBoss;
	private JTextArea txtFieldAge;;
	private String userTypeID,userType, userID;
	private JCheckBox checkBoxActive;
	private JTabbedPane tabbedPane;
	private Container container;
	
	public PanelShowInfo(Worker worker, String usernameUsuario, JTabbedPane tabbedPane_, Container pane) {
		//JPanel panel = null;
		tabbedPane = tabbedPane_;	
		container = pane;
		
		setBounds(0, 0, 1024, 768);
		setLayout(null);
	    
		userTypeID = usernameUsuario.substring(0, 3);
		userType = "undefined";
		
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
		
		worker.showInfo(usernameUsuario);
		
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

		textFieldId = new JTextField(usernameUsuario);
		textFieldId.setEditable(false);
		textFieldId.setBounds(400, 55, 231, 30);
		add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldName = new JTextField(worker.getName());
		textFieldName.setEditable(false);
		textFieldName.setColumns(10);
		textFieldName.setBounds(400, 105, 231, 30);
		add(textFieldName);
		
		textFieldDate = new JTextField(worker.getDate_Entry().toString());
		textFieldDate.setEditable(false);
		textFieldDate.setColumns(10);
		textFieldDate.setBounds(400, 155, 231, 30);
		add(textFieldDate);
		
		checkBoxActive = new JCheckBox();
		checkBoxActive.setBackground(new Color(0, 0, 0, 0));
		checkBoxActive.setSelected(worker.isActive());
		checkBoxActive.setBounds(400, 220, 32, 30);
		checkBoxActive.setEnabled(false);
		add(checkBoxActive);
		
		lblLevelNumber = new JLabel(String.format("%d", worker.getLevel()));
		lblLevelNumber.setBounds(400, 255, 132, 40);
		lblLevelNumber.setForeground(Color.WHITE);
		add(lblLevelNumber);
		
		textFieldBoss = new JTextField(worker.getBossID());
		textFieldBoss.setEditable(false);
		textFieldBoss.setColumns(10);
		textFieldBoss.setBounds(400, 306, 231, 30);
		add(textFieldBoss);
		 
		if(userTypeID.equalsIgnoreCase("SCI"))
		{
			/*lblStudies = new JLabel("Studies:                  "+((Scientific)worker).getStudies());
			lblStudies.setBounds(300, 370, 500, 40);
			lblStudies.setForeground(Color.WHITE);
			add(lblStudies);*/
			
			lblRecord = new JLabel("STUDIES");
			lblRecord.setFont(new Font("OCR A Extended", Font.BOLD, 12));
    		lblRecord.setBounds(300, 390, 132, 40);
    		lblRecord.setForeground(Color.WHITE);
    		add(lblRecord);
    		
        	txtFieldAge = new JTextArea(((Scientific)worker).getStudies());
        	txtFieldAge.setBounds(400, 390, 400, 160);
        	txtFieldAge.setForeground(Color.BLACK);
        	txtFieldAge.setEditable(false);
        	txtFieldAge.setLineWrap(true);
			add(txtFieldAge);
			
			btnAsigned = new JButton("ASSIGNED SCP");
			btnAsigned.setBounds(750, 52, 200, 40);
			btnAsigned.setBackground(Color.black);
			btnAsigned.setForeground(Color.white);
			btnAsigned.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnAsigned.addActionListener(this);
	        setLayout(null);
	        add(btnAsigned);
		}        	
        else if(userTypeID.equalsIgnoreCase("AGE"))
        {
        	
        	lblRecord = new JLabel("RECORD");
        	lblRecord.setFont(new Font("OCR A Extended", Font.BOLD, 12));
    		lblRecord.setBounds(300, 390, 132, 40);
    		lblRecord.setForeground(Color.WHITE);
    		add(lblRecord);
    		
        	txtFieldAge = new JTextArea(((Agent)worker).getHistory());
        	txtFieldAge.setBounds(400, 390, 400, 160);
        	txtFieldAge.setForeground(Color.BLACK);
        	txtFieldAge.setEditable(false);
        	txtFieldAge.setLineWrap(true);
			add(txtFieldAge);
			
			lblHistory = new JLabel("Facility:                    "+((Agent)worker).getId_facility());
			lblHistory.setFont(new Font("OCR A Extended", Font.BOLD, 12));
        	lblHistory.setBounds(300, 560, 500, 40);
        	lblHistory.setForeground(Color.WHITE);
			add(lblHistory);
			
			btnAsignedFacility = new JButton("ASSIGNED FACILITY");
			btnAsignedFacility.setBounds(750, 52, 200, 40);
			btnAsignedFacility.setBackground(Color.black);
			btnAsignedFacility.setForeground(Color.white);
			btnAsignedFacility.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnAsignedFacility.addActionListener(this);
	        add(btnAsignedFacility);
			
			
        }        	
        else if(userTypeID.equalsIgnoreCase("OVE"))
        {
        	lblHistory = new JLabel("CONTINENT:               "+((Overseer)worker).getContinent().name());
        	lblHistory.setFont(new Font("OCR A Extended", Font.BOLD, 12));
        	lblHistory.setBounds(300, 370, 500, 40);
        	lblHistory.setForeground(Color.WHITE);
			add(lblHistory);
			
			btnAddScp = new JButton("Add SCP");
			btnAddScp.setBounds(750, 30, 200, 40);
			btnAddScp.setBackground(Color.black);
			btnAddScp.setForeground(Color.white);
			btnAddScp.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnAddScp.addActionListener(this);
			add(btnAddScp);

			btnAddWorker = new JButton("Add Worker");
			btnAddWorker.setBounds(750, 130, 200, 40);
			btnAddWorker.setBackground(Color.black);
			btnAddWorker.setForeground(Color.white);
			btnAddWorker.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnAddWorker.addActionListener(this);
			add(btnAddWorker);

			btnAsignAgent = new JButton("Asign Scientist");
			btnAsignAgent.setBounds(750, 230, 200, 40);
			btnAsignAgent.setBackground(Color.black);
			btnAsignAgent.setForeground(Color.white);
			btnAsignAgent.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnAsignAgent.addActionListener(this);
			add(btnAsignAgent);

			btnLevelUpWorker = new JButton("Level Up Worker");
			btnLevelUpWorker.setBounds(750, 330, 200, 40);
			btnLevelUpWorker.setBackground(Color.black);
			btnLevelUpWorker.setForeground(Color.white);
			btnLevelUpWorker.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnLevelUpWorker.addActionListener(this);
			add(btnLevelUpWorker);

			btnDeleteScp = new JButton("Delete SCP");
			btnDeleteScp.setBounds(750, 430, 200, 40);
			btnDeleteScp.setBackground(Color.black);
			btnDeleteScp.setForeground(Color.white);
			btnDeleteScp.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnDeleteScp.addActionListener(this);
			add(btnDeleteScp);

			btnDeleteWorker = new JButton("Delete Worker");
			btnDeleteWorker.setBounds(750, 530, 200, 40);
			btnDeleteWorker.setBackground(Color.black);
			btnDeleteWorker.setForeground(Color.white);
			btnDeleteWorker.setFont(new Font("OCR A Extended", Font.BOLD, 15));
			btnDeleteWorker.addActionListener(this);
			add(btnDeleteWorker);
			
			btnAsignScientist = new JButton("Assign Scientist");
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
		if (e.getSource().equals(btnAsignedFacility)){
			JComponent panelShowFacility = null;
			panelShowFacility = new ShowFacility(userID);
			tabbedPane.addTab("Tab", null, panelShowFacility, "Panel");     
			container.add(tabbedPane, BorderLayout.CENTER);			
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);		
		}
		if (e.getSource().equals(btnAddScp)){
			
		}
		if (e.getSource().equals(btnAddWorker)){
			JComponent panelCreateWorker = null;
			panelCreateWorker = new CreateWorker();
			tabbedPane.addTab("Tab", null, panelCreateWorker, "Panel");     
			container.add(tabbedPane, BorderLayout.CENTER);			
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
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
			JComponent panelDeleteWorker = null;
			panelDeleteWorker = new DeleteWorker();
			tabbedPane.addTab("Tab", null, panelDeleteWorker, "Panel");     
			container.add(tabbedPane, BorderLayout.CENTER);			
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
		}		
		
		
	}
}
