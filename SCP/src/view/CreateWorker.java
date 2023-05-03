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

public class CreateWorker extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton btnAgent_1, btnOverseer_1, btnScientist_1, btnReset, btnCreate;
	private JLabel lblId, background, lblName, lblActive, lblEntryDate, lblLevel, lblBossID, lblPassword, lblHistory;
	private JTextField fieldName, fieldEntryDate, fieldBoss, fieldPassword;
	private JCheckBox chckbxActive;
	private JSpinner spinnerLevel;
	private JCalendar calendar;
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	private JTextArea textAreaHistory;
	private JComboBox<Continent> comboBox;

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
		fieldName.setBounds(284, 123, 227, 33);
		add(fieldName);
		fieldName.setColumns(10);

		fieldEntryDate = new JTextField();
		fieldEntryDate.setColumns(10);
		fieldEntryDate.setBounds(600, 430, 300, 33);
		add(fieldEntryDate);

		fieldBoss = new JTextField();
		fieldBoss.setColumns(10);
		fieldBoss.setBounds(284, 276, 227, 33);
		add(fieldBoss);

		chckbxActive = new JCheckBox("");
		chckbxActive.setBackground(new Color(255, 255, 255, 0));
		chckbxActive.setBounds(284, 178, 97, 23);
		add(chckbxActive);

		fieldPassword = new JTextField();
		fieldPassword.setColumns(10);
		fieldPassword.setBounds(284, 327, 227, 33);
		add(fieldPassword);

		lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("OCR A Extended", Font.BOLD, 12));
		lblPassword.setBounds(203, 320, 130, 46);
		add(lblPassword);

		spinnerLevel = new JSpinner();
		spinnerLevel.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		spinnerLevel.setBounds(294, 231, 30, 20);
		add(spinnerLevel);

		// Instanciar Componente
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
		textAreaHistory.setBounds(284, 388, 227, 202);
		textAreaHistory.setVisible(false);
		add(textAreaHistory);

		comboBox = new JComboBox<>();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// Add Worker Buttons
		if (e.getSource().equals(btnCreate)) {
			Worker worker = new Worker();
		}

		if (e.getSource().equals(btnReset)) {
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
		if (e.getSource().equals(btnAgent_1)) {

			lblHistory.setText("RECORD");
			lblHistory.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			lblHistory.setBounds(203, 385, 91, 46);
			lblHistory.setVisible(true);
			textAreaHistory.setVisible(true);
			btnScientist_1.setEnabled(false);
			btnOverseer_1.setEnabled(false);
		}

		if (e.getSource().equals(btnScientist_1)) {

			lblHistory.setText("STUDIES");
			lblHistory.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			lblHistory.setBounds(203, 385, 91, 46);
			lblHistory.setVisible(true);
			textAreaHistory.setVisible(true);
			btnAgent_1.setEnabled(false);
			btnOverseer_1.setEnabled(false);
		}

		if (e.getSource().equals(btnOverseer_1)) {

			lblHistory.setText("CONTINENT");
			lblHistory.setFont(new Font("OCR A Extended", Font.BOLD, 12));
			lblHistory.setBounds(203, 375, 91, 46);
			lblHistory.setVisible(true);
			comboBox.setVisible(true);
			btnAgent_1.setEnabled(false);
			btnScientist_1.setEnabled(false);
		}
	}
}
