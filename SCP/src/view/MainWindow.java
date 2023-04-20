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
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Worker;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class MainWindow extends JFrame implements ActionListener {

	//private final JPanel contentPanel = new JPanel();
	private JTabbedPane tabbedPane;
	private JButton btnShowInfo;
	private JButton btnAddScp;
	private JButton btnAddWorker;
	private JButton btnAsignScientist;
	private JButton btnAsignAgent;
	private JButton btnLevelUpWorker;
	private JButton btnDeleteScp;
	private JButton btnDeleteWorker;
	
	private Worker worker;
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblDateEntry;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextField textFieldDate;
	
	private String workerId;
	
	public MainWindow(String usernameUsuario) {
			
			
		setBounds(100, 100, 1024, 768);
		//adapta la ventana a la pantalla
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		getContentPane().setLayout(new BorderLayout());
		
		tabbedPane = new JTabbedPane();

		JComponent panel1 = makePanel1("Panel #1");
		tabbedPane.addTab("Tab 1", null, panel1, "First Panel");
		
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		
		workerId = usernameUsuario;
		//desabilita el cambiar a una tab expecifica
		//tabbedPane.setEnabledAt(1, false);
		//hace invisible las tabs
		//tabbedPane.setVisible(false);
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
	        
	        return panel;
	    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnShowInfo)){
			showInfoWindow(workerId);
		}
		if (e.getSource().equals(btnAddScp)){
			 JPanel newPanel = new JPanel();
		     tabbedPane.addTab("Add SCP", newPanel);
		}
		if (e.getSource().equals(btnAddWorker)){
			
		}
		if (e.getSource().equals(btnAsignScientist)){
			
		}
		if (e.getSource().equals(btnAsignAgent)){
			
		}
		if (e.getSource().equals(btnLevelUpWorker)){
			
		}
		if (e.getSource().equals(btnDeleteScp)){
			
		}
		if (e.getSource().equals(btnDeleteWorker)){
			
		}
		
	}
	private void showInfoWindow(String usernameUsuario) {

		//id introducida previamente
		String idWorker = usernameUsuario;
		Worker wObj = new Worker();
		wObj.showInfo(idWorker);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Info", null, panel, null);
		panel.setLayout(null);
		
		lblId = new JLabel("ID");
		lblId.setBounds(56, 56, 132, 40);
		panel.add(lblId);
		
		lblName = new JLabel("NAME");
		lblName.setBounds(56, 112, 132, 40);
		panel.add(lblName);
		
		lblDateEntry = new JLabel("DATE ENTRY");
		lblDateEntry.setBounds(56, 163, 132, 40);
		panel.add(lblDateEntry);
		
		textFieldId = new JTextField(idWorker);
		textFieldId.setBounds(198, 61, 231, 30);
		panel.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldName = new JTextField(wObj.getName());
		textFieldName.setColumns(10);
		textFieldName.setBounds(198, 117, 231, 30);
		panel.add(textFieldName);
		
		textFieldDate = new JTextField(wObj.getDate_Entry().toString());
		textFieldDate.setColumns(10);
		textFieldDate.setBounds(198, 168, 231, 30);
		panel.add(textFieldDate);
		
		tabbedPane.setSelectedIndex(1);
	}
}
