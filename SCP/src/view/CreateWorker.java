package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.UIManager;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

import acs.Continent;

import clases.Agent;
import clases.Overseer;
import clases.Scientific;
import clases.Worker;
import exceptions.ServerException;
import main.AgentFactory;
import main.LoginableFactory;
import main.OverseerFactory;
import main.ScientificFactory;


import clases.Worker;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

/**
 * The JPanel CreateWorker also implements the ActionListener, and its role is
 * to make it possible to create new workers
 * 
 * @author Alex
 */
public class CreateWorker extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton btnAgent_1, btnOverseer_1, btnScientist_1, btnReset, btnCreate;
	private JLabel lblId, background, lblName, lblActive, lblEntryDate, lblLevel, lblBossID, lblPassword, lblHistory;
	private JTextField fieldName, fieldEntryDate, fieldPassword;
	private JCheckBox chckbxActive;
	private JSpinner spinnerLevel;
	private JCalendar calendar;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	private JTextArea textAreaHistory;
	private JScrollPane scroll;
	private JComboBox<Continent> comboBox;

	private JComboBox<String> comboBoxBoss;


	private boolean isScientist = false, isAgent = false, isOverseer = false;
	//private JXDatePicker datePicker;

	public CreateWorker() {
		setBounds(0, 0, 1024, 768);
		setLayout(null);

		lblId = new JLabel("WORKER TYPE");
		lblId.setBounds(27, 53, 159, 37);
		lblId.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lblId.setForeground(Color.WHITE);
		add(lblId);

		btnAgent_1 = new JButton("AGENT");
		btnAgent_1.setBounds(20, 111, 150, 54);
		btnAgent_1.setBackground(Color.black);
		btnAgent_1.setForeground(Color.white);
		btnAgent_1.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		btnAgent_1.addActionListener(this);
		add(btnAgent_1);

		btnScientist_1 = new JButton("SCIENTIST");
		btnScientist_1.setBounds(20, 210, 150, 54);
		btnScientist_1.setBackground(Color.black);
		btnScientist_1.setForeground(Color.white);
		btnScientist_1.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		btnScientist_1.addActionListener(this);
		add(btnScientist_1);

		btnOverseer_1 = new JButton("OVERSEER");
		btnOverseer_1.setBounds(20, 306, 150, 54);
		btnOverseer_1.setBackground(Color.black);
		btnOverseer_1.setForeground(Color.white);
		btnOverseer_1.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		btnOverseer_1.addActionListener(this);
		add(btnOverseer_1);

		lblName = new JLabel("NAME");
		lblName.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblName.setBounds(203, 116, 71, 49);
		lblName.setForeground(new Color(255, 255, 255));
		add(lblName);

		lblActive = new JLabel("ACTIVE");
		lblActive.setForeground(Color.WHITE);
		lblActive.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblActive.setBounds(203, 167, 77, 46);
		add(lblActive);

		lblEntryDate = new JLabel("Entry Date");
		lblEntryDate.setForeground(Color.WHITE);
		lblEntryDate.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblEntryDate.setBounds(692, 53, 130, 40);
		add(lblEntryDate);

		lblLevel = new JLabel("LEVEL");
		lblLevel.setForeground(Color.WHITE);
		lblLevel.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblLevel.setBounds(203, 218, 91, 46);
		add(lblLevel);

		lblBossID = new JLabel("BOSS ID");
		lblBossID.setForeground(Color.WHITE);
		lblBossID.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblBossID.setBounds(203, 269, 71, 40);
		add(lblBossID);

		fieldName = new JTextField();
		fieldName.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		fieldName.setForeground(new Color(255, 255, 255));
		fieldName.setBackground(new Color(0, 0, 0));

		fieldName.setBounds(284, 123, 227, 33);
		add(fieldName);
		fieldName.setColumns(10);

		fieldEntryDate = new JTextField();

		fieldEntryDate.setEditable(false);

		fieldEntryDate.setColumns(10);
		fieldEntryDate.setBounds(600, 430, 300, 33);
		add(fieldEntryDate);

		chckbxActive = new JCheckBox("");
		chckbxActive.setBackground(Color.BLACK);
		chckbxActive.setBounds(284, 181, 21, 20);
		add(chckbxActive);

		ArrayList<String> bossList = null;
		try {
			bossList = OverseerFactory.getOverseerDB().getOverseerIDs();
		} catch (ServerException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
		
		comboBoxBoss = new JComboBox<>();
		for (String id : bossList) {
			comboBoxBoss.addItem(id);
		}
		comboBoxBoss.setSelectedIndex(-1);
		comboBoxBoss.setBounds(284, 269, 227, 31);
		add(comboBoxBoss);
		
		
		
		fieldPassword = new JTextField();

		fieldPassword.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		fieldPassword.setForeground(new Color(255, 255, 255));
		fieldPassword.setBackground(new Color(0, 0, 0));
		fieldPassword.setColumns(10);
		fieldPassword.setBounds(284, 327, 227, 33);
		add(fieldPassword);

		lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblPassword.setBounds(203, 320, 130, 46);
		add(lblPassword);

		spinnerLevel = new JSpinner();

		spinnerLevel.setForeground(new Color(255, 255, 255));
		spinnerLevel.setBackground(new Color(0, 0, 0));

		spinnerLevel.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerLevel.setBounds(294, 231, 30, 20);
		add(spinnerLevel);

		calendar = new JCalendar();
		calendar.getDayChooser().setBackground(Color.WHITE);
		calendar.getDayChooser().setWeekdayForeground(Color.WHITE);
		calendar.setBackground(new Color(0,0,0,0));
		calendar.setWeekdayForeground(Color.WHITE);
		calendar.setWeekOfYearVisible(false);
		calendar.setDecorationBackgroundColor(new Color(0,0,0,0));
		calendar.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		// Ubicar y agregar al panel

		calendar.setBounds(600, 100, 300, 300);
		
		for (int i = 0; i < calendar.getComponentCount(); i++)  {
		    if (calendar.getComponent(i) instanceof JDayChooser) {
		        JDayChooser chooser = ((JDayChooser) calendar.getComponent( i ) );
		        JPanel panel = (JPanel) chooser.getComponent(0);
		        // the following line changes the color of the background behind the buttons
		        panel.setBackground(new Color(0,0,0,0));
		        // the for loop below changes the color of the buttons themselves
		        for (int y = 0; y < panel.getComponentCount(); y++) {
		            panel.getComponent(y).setBackground(Color.BLACK);
		            panel.getComponent(y).setForeground(Color.WHITE);
		        }
		        break; // leave the for loop, we're done
		    }
		}
		calendar.getDayChooser().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				fieldEntryDate.setText(format.format(calendar.getDate()).toString());
			}
		});
		fieldEntryDate.setText(calendar.getDate().toString());

		add(calendar);

		btnReset = new JButton("RESET");
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("OCR A EXTENDED", Font.BOLD, 15));
		btnReset.setBackground(Color.BLACK);
		btnReset.setBounds(600, 536, 110, 54);
		btnReset.addActionListener(this);
		add(btnReset);

		btnCreate = new JButton("CREATE");
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("OCR A EXTENDED", Font.BOLD, 15));
		btnCreate.setBackground(Color.BLACK);
		btnCreate.setBounds(790, 536, 110, 54);
		btnCreate.addActionListener(this);
		add(btnCreate);

		lblHistory = new JLabel("");
		lblHistory.setBounds(54, 377, 130, 40);
		lblHistory.setFont(new Font("OCR A EXTENDED", Font.BOLD, 18));
		lblHistory.setForeground(Color.WHITE);
		lblHistory.setVisible(false);
		add(lblHistory);

		textAreaHistory = new JTextArea();
		textAreaHistory.setRows(100);
		textAreaHistory.setLineWrap(true);

		textAreaHistory.setBounds(284, 388, 227, 202);
		textAreaHistory.setOpaque(false);
		textAreaHistory.setWrapStyleWord(true);
		textAreaHistory.setLineWrap(true);
		textAreaHistory.setVisible(false);
		/*scroll = new JScrollPane (textAreaHistory, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);*/
		add(textAreaHistory);
		//scroll.setVisible(true);
		//add(scroll);
		

		textAreaProceduresTransparente = new JTextArea();
		textAreaProceduresTransparente.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		textAreaProceduresTransparente.setBounds(284, 388, 227, 202);
		textAreaProceduresTransparente.setBackground(new Color(0, 0, 0, 80));
		textAreaProceduresTransparente.setEditable(false);
		textAreaProceduresTransparente.setWrapStyleWord(true);
		textAreaProceduresTransparente.setEnabled(false);
		textAreaProceduresTransparente.setLineWrap(true);
		textAreaProceduresTransparente.setVisible(false);
		add(textAreaProceduresTransparente);

		comboBox = new JComboBox<>();
		comboBox.setBackground(new Color(0, 0, 0));
		comboBox.setForeground(new Color(255, 255, 255));
		for (Continent cont : Continent.values()) {
			comboBox.addItem(cont);
		}
		
		comboBox.setBounds(284, 388, 227, 20);
		comboBox.setVisible(false);
		comboBox.setSelectedIndex(-1);
		add(comboBox);

		background = new JLabel("bg");
		background.setBounds(0, 0, 1040, 712);
		background.setForeground(Color.WHITE);
		background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
		add(background);
	}

	/**
	 * actionPerformed method listening to btnCreate, btnReset, btnAgent_1,
	 * btnScientist_1, btnOverseer_1 buttons
	 * 
	 * @param e - ActionEvent type variable
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			//Add Worker Buttons
			if (e.getSource().equals(btnCreate)){
				Worker worker = null;		
				if(isAgent)
				{
					worker = new Agent();
					((Agent)worker).setHistory(textAreaHistory.getText());
				}
				else if(isScientist)
				{
					worker = new Scientific();
					((Scientific)worker).setStudies(textAreaHistory.getText());
				}
				else if(isOverseer)
				{
					worker = new Overseer();
					((Overseer)worker).setContinent(Continent.valueOf(comboBox.getSelectedItem().toString()));
				}
			
				String id = LoginableFactory.getLoginable().workerIDCreator(worker);
				
				worker.setId(id);
				worker.setActive(chckbxActive.isSelected());
				worker.setName(fieldName.getText());
				worker.setPassword(fieldPassword.getText());
				worker.setLevel((int)spinnerLevel.getValue());
				
				java.sql.Date sqlDate = java.sql.Date.valueOf( fieldEntryDate.getText() );	
				
				worker.setDate_Entry(sqlDate);
				worker.setBossID((String)comboBoxBoss.getSelectedItem());
				
				if(isAgent)
					AgentFactory.getAgentDB().createWorker((Agent)worker);
				else if(isScientist)
					ScientificFactory.getScientificDB().createWorker((Scientific)worker);			
				else if(isOverseer) 
					OverseerFactory.getOverseerDB().createWorker((Overseer)worker);		
				
				JOptionPane.showMessageDialog(this, "Worker created succesfully, ID "+id+" assigned");
		}
		if (e.getSource().equals(btnReset)){
			isAgent = false;
			isAgent = false;
			isAgent = false;
			
			fieldName.setText("");
			comboBoxBoss.setSelectedIndex(-1);
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
			textAreaProceduresTransparente.setVisible(false);
		}


		if (e.getSource().equals(btnAgent_1)) {
			isAgent= true;

			lblHistory.setText("RECORD");
			lblHistory.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			lblHistory.setBounds(203, 385, 91, 46);
			lblHistory.setVisible(true);
			lblHistory.setVisible(true);
			btnScientist_1.setEnabled(false);
			btnOverseer_1.setEnabled(false);

			btnCreate.setEnabled(true);
		}

		if (e.getSource().equals(btnScientist_1)) {

			isScientist = true;

			lblHistory.setText("STUDIES");
			lblHistory.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			lblHistory.setBounds(203, 385, 91, 46);
			lblHistory.setVisible(true);
			textAreaHistory.setVisible(true);
			btnAgent_1.setEnabled(false);
			btnOverseer_1.setEnabled(false);

			btnCreate.setEnabled(true);
		}

		if (e.getSource().equals(btnOverseer_1)) {

			isOverseer = true;

			lblHistory.setText("CONTINENT");
			lblHistory.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			lblHistory.setBounds(203, 375, 91, 46);
			lblHistory.setVisible(true);
			comboBox.setVisible(true);
			btnAgent_1.setEnabled(false);
			btnScientist_1.setEnabled(false);
			btnCreate.setEnabled(true);
		}
		
		}catch (ServerException ex){
			JOptionPane.showMessageDialog(this, ex.getMessage());

		}
	}
}
