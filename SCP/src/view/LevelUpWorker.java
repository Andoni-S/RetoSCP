package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import clases.Overseer;
import clases.Worker;
import exceptions.ServerException;
import main.LoginableFactory;
import main.OverseerFactory;

import javax.swing.JComboBox;

/**
 * LevelUpWorker is also JPanel and will level up workers
 * 
 * @author Alex
 */
public class LevelUpWorker extends JPanel implements ActionListener {

	// This class will display a window for upgrading a worker when logged in as an
	// overseer

	// First, we declare all the labels and buttons we want to display in our window

	private JLabel lblWorker;
	private JButton btnShowInfo;
	private JButton btnLevelUp;
	private JLabel background;
	private JLabel lblIdWorker;
	private JLabel lblNameWorker;
	private JLabel lblDateEntry;
	private JLabel lblActive;
	private JLabel lblLevel;
	private JLabel lblIdBoss;
	private JComboBox comboBox;

	private JLabel lblDato1;
	private JLabel lblDato2;
	private JLabel lblDato3;
	private JLabel lblDato4;
	private JLabel lblDato5;
	private JLabel lblDato6;

	/**
	 * This is the window constructor, where all the elements of the window are
	 * instantiated
	 */
	public LevelUpWorker() {
		setBounds(0, 0, 1024, 768);
		setLayout(null);

		lblWorker = new JLabel("Select the worker:");
		lblWorker.setBounds(65, 25, 318, 70);
		lblWorker.setForeground(new Color(255, 255, 255));
		lblWorker.setFont(new Font("OCR A Extended", Font.BOLD, 22));
		add(lblWorker);

		btnShowInfo = new JButton("Show Info");
		btnShowInfo.setBackground(new Color(0, 0, 0));
		btnShowInfo.setForeground(new Color(255, 255, 255));
		btnShowInfo.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		btnShowInfo.setBounds(320, 600, 120, 45);
		add(btnShowInfo);
		btnShowInfo.addActionListener(this);

		btnLevelUp = new JButton("Level Up");
		btnLevelUp.setBounds(560, 600, 120, 44);
		btnLevelUp.setForeground(new Color(255, 255, 255));
		btnLevelUp.setBackground(new Color(0, 0, 0));
		btnLevelUp.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		add(btnLevelUp);
		btnLevelUp.addActionListener(this);

		comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(0, 0, 0));
		comboBox.setBounds(393, 49, 500, 30);
		add(comboBox);

		lblIdWorker = new JLabel("- ID:");
		lblIdWorker.setForeground(new Color(255, 255, 255));
		lblIdWorker.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblIdWorker.setBounds(130, 120, 1500, 43);
		add(lblIdWorker);

		lblDato1 = new JLabel();
		lblDato1.setForeground(new Color(255, 255, 255));

		lblDato1.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblDato1.setBounds(500, 120, 1500, 43);
		lblDato1.setVisible(false);
		add(lblDato1);

		lblNameWorker = new JLabel("- Name:         ");
		lblNameWorker.setForeground(new Color(255, 255, 255));
		lblNameWorker.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblNameWorker.setBounds(130, 200, 796, 43);
		add(lblNameWorker);

		lblDato2 = new JLabel();
		lblDato2.setForeground(new Color(255, 255, 255));
		lblDato2.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblDato2.setBounds(500, 200, 796, 43);
		lblDato2.setVisible(false);
		add(lblDato2);

		lblDateEntry = new JLabel("- Date Entry:        ");
		lblDateEntry.setForeground(new Color(255, 255, 255));
		lblDateEntry.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblDateEntry.setBounds(130, 280, 595, 43);
		add(lblDateEntry);

		lblDato3 = new JLabel();
		lblDato3.setForeground(new Color(255, 255, 255));

		lblDato3.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblDato3.setBounds(500, 280, 595, 43);
		lblDato3.setVisible(false);
		add(lblDato3);

		lblActive = new JLabel("- Active:        ");
		lblActive.setForeground(new Color(255, 255, 255));
		lblActive.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblActive.setBounds(130, 360, 595, 43);
		add(lblActive);

		lblDato4 = new JLabel();
		lblDato4.setForeground(new Color(255, 255, 255));
		lblDato4.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblDato4.setBounds(500, 360, 595, 43);
		lblDato4.setVisible(false);
		add(lblDato4);

		lblLevel = new JLabel("- Level:        ");
		lblLevel.setForeground(new Color(255, 255, 255));
		lblLevel.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblLevel.setBounds(130, 440, 595, 43);
		add(lblLevel);

		lblDato5 = new JLabel();
		lblDato5.setForeground(new Color(255, 255, 255));
		lblDato5.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblDato5.setBounds(500, 440, 595, 43);
		lblDato5.setVisible(false);
		add(lblDato5);

		lblIdBoss = new JLabel("- ID Boss:        ");
		lblIdBoss.setForeground(new Color(255, 255, 255));
		lblIdBoss.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblIdBoss.setBounds(130, 520, 595, 43);
		add(lblIdBoss);

		lblDato6 = new JLabel();
		lblDato6.setForeground(new Color(255, 255, 255));
		lblDato6.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		lblDato6.setBounds(500, 520, 595, 43);
		lblDato6.setVisible(false);
		add(lblDato6);

		cargarWorkers();

		background = new JLabel("bg");
		background.setIcon(new ImageIcon(ShowFacility.class.getResource("/resources/background.png")));
		background.setBounds(0, 0, 1024, 768);
		add(background);
	}
	/**
	 * The following method takes care of loading the comboBox with the IDs of all
	 * workers
	 */

	// This is the method to fill the combobox options with workers
	private void cargarWorkers() {
		ArrayList<Worker> arrayDeWorkers = null;
		try {
			arrayDeWorkers = LoginableFactory.getLoginable().showAllWorkers();
		} catch (ServerException e) {
			JOptionPane.showMessageDialog(null, "Error trying to load the workers");
		}

		for (Worker w : arrayDeWorkers) {
			comboBox.addItem(w.getId());
		}
	}

	/**
	 * actionPerformed method listening to btnShowInfo and btnLevelUp buttons
	 * 
	 * @param e - ActionEvent type variable
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// If the "show info" button is pressed, the labels with the data corresponding
		// to the worker selected from the combobox will become visible
		if (e.getSource().equals(btnShowInfo)) {
			String workerDeletion = (String) comboBox.getSelectedItem();
			Worker work = null;

			try {
				if (LoginableFactory.getLoginable().checkWorker(workerDeletion)) {
					
					work = LoginableFactory.getLoginable().showInfoDefault(workerDeletion);
					showInfoWorker(work);					
				} else {
					JOptionPane.showMessageDialog(comboBox, "Please insert an existing ID");
				}
			} catch (HeadlessException | ServerException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}

		// If the "level up" button is clicked, confirmation will be requested and the worker's level will be added by one, and will be displayed as updated
		if (e.getSource().equals(btnLevelUp)) {
			String workerDeletion = (String) comboBox.getSelectedItem();
			Worker work = null;
						
			try {
				
				if (LoginableFactory.getLoginable().checkWorker(workerDeletion)) {

					work = LoginableFactory.getLoginable().showInfoDefault(workerDeletion);
					showInfoWorker(work);
					if (work.getLevel() == 3) {
						JOptionPane.showMessageDialog(null, "The worker is already level 3");
					} else {
						
					
						int n = JOptionPane.showConfirmDialog(null, "Do you want to level up this worker?", "Confirmation",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

						if (n == JOptionPane.YES_OPTION) {
						
							OverseerFactory.getOverseerDB().levelUpWorker(work);	
							JOptionPane.showMessageDialog(null, "The worker has been leveled up");
							work = LoginableFactory.getLoginable().showInfoDefault(workerDeletion);
							showInfoWorker(work);

						}
					}
				}
			} catch (HeadlessException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			} catch (ServerException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}
	}

	private void showInfoWorker(Worker work) {		
		lblDato1.setText(work.getId());
		lblDato1.setVisible(true);
		lblDato2.setText(work.getName());
		lblDato2.setVisible(true);
		lblDato3.setText(work.getDate_Entry().toString());
		lblDato3.setVisible(true);
		if (work.isActive())
			lblDato4.setText("YES");
		else
			lblDato4.setText("NO");
		lblDato4.setVisible(true);
		if (work.getLevel() == 1)
			lblDato5.setText("1");
		else if (work.getLevel() == 2)
			lblDato5.setText("2");
		else if (work.getLevel() == 3)
			lblDato5.setText("3");
		lblDato5.setVisible(true);
		lblDato6.setText(work.getBossID());
		lblDato6.setVisible(true);
	}
}

