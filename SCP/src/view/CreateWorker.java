package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.toedter.calendar.JCalendar;

import acs.Continent;
import clases.Agent;
import clases.Overseer;
import clases.Worker;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

public class CreateWorker extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnAgent_1,btnOverseer_1,btnScientist_1,btnReset,btnCreate;
	private JLabel lblId,background,lblName,lblActive,lblEntryDate,lblLevel,lblBossID,lblPassword,lblHistory;
	private JTextField fieldName,fieldEntryDate,fieldBoss,fieldPassword;
	private JCheckBox chckbxActive;
	private JSpinner spinnerLevel;
	private JCalendar calendar;
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	private JTextArea textAreaHistory;
	private JComboBox<Continent> comboBox;
	//private JXDatePicker datePicker;
	
	public CreateWorker() {
		
		setBounds(0, 0, 1024, 768);
		setLayout(null);
		
		lblId = new JLabel("WORKER TYPE");
		lblId.setBounds(54, 49, 200, 40);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setForeground(Color.WHITE);
		add(lblId);
		
		btnAgent_1 = new JButton("Agent");
		btnAgent_1.setBounds(20, 110, 150, 54);
		btnAgent_1.setBackground(Color.black);
		btnAgent_1.setForeground(Color.white);
		btnAgent_1.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		btnAgent_1.addActionListener(this);
	    add(btnAgent_1);
	    
	    btnScientist_1 = new JButton("Scientist");
	    btnScientist_1.setBounds(20, 175, 150, 54);
	    btnScientist_1.setBackground(Color.black);
	    btnScientist_1.setForeground(Color.white);
	    btnScientist_1.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
	    btnScientist_1.addActionListener(this);
	    add(btnScientist_1);
	    
	    btnOverseer_1 = new JButton("Overseer");
	    btnOverseer_1.setBounds(20, 240, 150, 54);
	    btnOverseer_1.setBackground(Color.black);
	    btnOverseer_1.setForeground(Color.white);
	    btnOverseer_1.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
	    btnOverseer_1.addActionListener(this);
	    add(btnOverseer_1);
	    
	    lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblName.setBounds(203, 116, 130, 40);
        lblName.setForeground(new Color(255, 255, 255));
        add(lblName);  
        
        lblActive = new JLabel("Active");
        lblActive.setForeground(Color.WHITE);
        lblActive.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblActive.setBounds(203, 167, 130, 40);
        add(lblActive);
        
        lblEntryDate = new JLabel("Entry Date");
        lblEntryDate.setForeground(Color.WHITE);
        lblEntryDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEntryDate.setBounds(600, 50, 130, 40);
        add(lblEntryDate);
        
        lblLevel = new JLabel("Level");
        lblLevel.setForeground(Color.WHITE);
        lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblLevel.setBounds(203, 218, 91, 40);
        add(lblLevel);
        
        lblBossID = new JLabel("Boss ID");
        lblBossID.setForeground(Color.WHITE);
        lblBossID.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBossID.setBounds(203, 269, 130, 40);
        add(lblBossID);
        
        fieldName = new JTextField();
        fieldName.setBounds(294, 123, 217, 33);
        add(fieldName);
        fieldName.setColumns(10);
        
        fieldEntryDate = new JTextField();
        fieldEntryDate.setColumns(10);
        fieldEntryDate.setBounds(600, 411, 159, 33);
        add(fieldEntryDate);
        
        fieldBoss = new JTextField();
        fieldBoss.setColumns(10);
        fieldBoss.setBounds(294, 276, 217, 33);
        add(fieldBoss);
        
        chckbxActive = new JCheckBox("");
        chckbxActive.setBackground(new Color(255,255,255,0));
        chckbxActive.setBounds(294, 179, 97, 23);
        add(chckbxActive);
        
        fieldPassword = new JTextField();
        fieldPassword.setColumns(10);
        fieldPassword.setBounds(294, 327, 217, 33);
        add(fieldPassword);
        
        lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPassword.setBounds(203, 320, 130, 40);
        add(lblPassword);
        
        spinnerLevel = new JSpinner();
        spinnerLevel.setModel(new SpinnerNumberModel(0, 0, 3, 1));
        spinnerLevel.setBounds(294, 231, 30, 20);
        add(spinnerLevel);
        
        //Instanciar Componente
     	calendar = new JCalendar();
     	calendar.setWeekdayForeground(Color.WHITE);
     	calendar.setWeekOfYearVisible(false);
     	calendar.setDecorationBackgroundColor(Color.BLACK);
     	// Ubicar y agregar al panel
     	calendar.setBounds(600, 100, 300, 300);   
     	calendar.getDayChooser().addPropertyChangeListener(new PropertyChangeListener() {
     	    @Override
     	    public void propertyChange(PropertyChangeEvent e) {
     	    	fieldEntryDate.setText(format.format(calendar.getDate()).toString());
     	    }
     	});
     	fieldEntryDate.setText(calendar.getDate().toString());
     	
     	add(calendar);	
     		
     	btnReset = new JButton("Reset");
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Dialog", Font.PLAIN, 15));
        btnReset.setBackground(Color.BLACK);
        btnReset.setBounds(600, 613, 100, 54);
        btnReset.addActionListener(this);
        add(btnReset);
        
        btnCreate = new JButton("Create");
        btnCreate.setForeground(Color.WHITE);
        btnCreate.setFont(new Font("Dialog", Font.PLAIN, 15));
        btnCreate.setBackground(Color.BLACK);
        btnCreate.setBounds(800, 613, 100, 54);
        btnCreate.addActionListener(this);
        add(btnCreate);
        
        lblHistory = new JLabel("");
        lblHistory.setBounds(54, 377, 130, 40);
        lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblHistory.setForeground(Color.WHITE);
        lblHistory.setVisible(false);
		add(lblHistory);
		
		textAreaHistory = new JTextArea();
        textAreaHistory.setBounds(159, 388, 352, 202);
        textAreaHistory.setVisible(false);
        add(textAreaHistory);
        
        comboBox = new JComboBox<>();
        for (Continent cont : Continent.values()) {
            comboBox.addItem(cont);
        }
        comboBox.setBounds(159, 388, 352, 20);
        comboBox.setVisible(false);
        comboBox.setSelectedIndex(-1);
        add(comboBox);
        
        background = new JLabel("bg");
	    background.setBounds(0, 0, 1040, 712);
	    background.setForeground(Color.WHITE);
        background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
        add(background);  
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Add Worker Buttons
		if (e.getSource().equals(btnCreate)){
			Worker worker = new Worker();
			
		}
		if (e.getSource().equals(btnReset)){
			fieldName.setText("");
			fieldBoss.setText("");
			chckbxActive.setSelected(false);
			spinnerLevel.setValue(0);
			fieldPassword.setText("");
			lblHistory.setVisible(false);
			textAreaHistory.setText("");
			textAreaHistory.setVisible(false);
			comboBox.setVisible(false);
			comboBox.setSelectedIndex(-1);
			btnOverseer_1.setEnabled(true);
			btnAgent_1.setEnabled(true);
			btnScientist_1.setEnabled(true);
		}
		if (e.getSource().equals(btnAgent_1)){
			
			lblHistory.setText("Record");
			lblHistory.setVisible(true);
			textAreaHistory.setVisible(true);
			btnScientist_1.setEnabled(false);
			btnOverseer_1.setEnabled(false);
		}
		if (e.getSource().equals(btnScientist_1)){
			
			lblHistory.setText("Studies");
			lblHistory.setVisible(true);
			textAreaHistory.setVisible(true);
			btnAgent_1.setEnabled(false);
			btnOverseer_1.setEnabled(false);
		}
		if (e.getSource().equals(btnOverseer_1)){
			
			lblHistory.setText("Continent");
			lblHistory.setVisible(true);
			comboBox.setVisible(true);
			btnAgent_1.setEnabled(false);
			btnScientist_1.setEnabled(false);
		}
		
	}
}
