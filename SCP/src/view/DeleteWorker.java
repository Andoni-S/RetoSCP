package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import clases.Overseer;
import clases.Worker;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DeleteWorker extends JPanel implements ActionListener {
	// We declare the required labels, buttons, and table
	private JTable tablaWorkers;
	private DefaultTableModel model;
	private JLabel lblWorker;
	private JTextField textWorker;
	private JButton btnShowInfo;
	private JButton btnDelete;
	private JLabel background;
	private JTabbedPane tabbedPane = null;
	private Container container = null;
	private Worker worker;
	private String user;
	
	public DeleteWorker(Worker worker_, String usernameUsuario, JTabbedPane tabbedPane_, Container pane) {
		setBounds(0, 0, 1024, 768);
		setLayout(null);

		worker = worker_;
		user = usernameUsuario;
		tabbedPane = tabbedPane_;
		container = pane;
		// We collect all the workers in an array in order to fill the table with the
		// data

		Worker work = new Worker();
		ArrayList<Worker> arrayDeWorkers = work.showAllWorkers();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		scrollPane.setBounds(90, 100, 800, 359);
		add(scrollPane);

		tablaWorkers = new JTable();

		model = new DefaultTableModel();
		tablaWorkers.setModel(model);
		tablaWorkers.setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		tablaWorkers.setShowGrid(false);
		tablaWorkers.addMouseListener(new MouseAdapter() {
			// The following method fills in the text field called "textWorker" with the ID
			// selected in the table with the mouse
			@Override
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 1) {
					final JTable jTable = (JTable) e.getSource();
					final int row = jTable.getSelectedRow();
					final String valueInCell = (String) jTable.getValueAt(row, 0);
					textWorker.setText(valueInCell);
				}
			}
		});

		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Date Entry");

		scrollPane.setViewportView(tablaWorkers);

		// We call the fillTable() method to fill in the table
		fillTable();

		lblWorker = new JLabel("Insert the ID of the worker:");
		lblWorker.setForeground(new Color(255, 255, 255));
		lblWorker.setFont(new Font("OCR A Extended", Font.BOLD, 22));
		lblWorker.setBounds(80, 500, 1500, 80);
		add(lblWorker);

		textWorker = new JTextField();
		textWorker.setForeground(new Color(255, 255, 255));
		textWorker.setBackground(new Color(0, 0, 0));
		textWorker.setBounds(475, 527, 275, 25);
		textWorker.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		add(textWorker);
		textWorker.setColumns(10);
		btnShowInfo = new JButton("Show Info");
		btnShowInfo.setBackground(new Color(0, 0, 0));
		btnShowInfo.setForeground(new Color(255, 255, 255));
		btnShowInfo.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		btnShowInfo.setBounds(771, 485, 120, 45);
		add(btnShowInfo);
		btnShowInfo.addActionListener(this);

		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(0, 0, 0));
		btnDelete.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		btnDelete.setBounds(771, 545, 120, 45);
		add(btnDelete);
		btnDelete.addActionListener(this);

		background = new JLabel("bg");
		background.setIcon(new ImageIcon(ShowFacility.class.getResource("/resources/background.png")));
		background.setBounds(0, 0, 1024, 768);
		add(background);
	}

	// Method for emptying the table after deletion
	public void emptyTable() {
		DefaultTableModel model = (DefaultTableModel) tablaWorkers.getModel();
		model.setRowCount(0);
	}

	// Method to fill in the table with the data of all workers
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

		tablaWorkers.setDefaultEditor(Object.class, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// If the "Show Info" button is pressed, it will display a ShowInfo2 type window
		// with the data of the selected worker
		if (e.getSource().equals(btnShowInfo)) {
			if (textWorker.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Empty field. Please enter an ID");

			} else {
				String workerDeletion = textWorker.getText();
				Worker work = new Worker();

				if (work.checkWorker(workerDeletion)) {
					JComponent show = null;				
					show = new PanelShowInfo(worker, workerDeletion, tabbedPane, container);
					tabbedPane.addTab("Tab", null, show, "Panel");     			
					container.add(tabbedPane, BorderLayout.CENTER);				
					tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
					tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
					
				} else {
					JOptionPane.showMessageDialog(null, "Please insert an existing ID");
				}
			}
		}

		// If the user clicks on "Delete", a confirmation message will be displayed and,
		// if confirmed, the worker will be deleted
		if (e.getSource().equals(btnDelete)) {
			if (textWorker.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Empty field. Please enter an ID");
			} else {
				int n = JOptionPane.showConfirmDialog(null, "Do you want to delete this worker?", "Confirmation",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

				if (n == JOptionPane.YES_OPTION) {
					String workerDeletion = textWorker.getText();
					Worker work = new Worker();

					if (work.checkWorker(workerDeletion)) {
						Overseer ove = new Overseer();
						ove.deleteWorker(work.getId());
						JOptionPane.showMessageDialog(null, "The worker has been deleted");
						emptyTable();
						fillTable();
						textWorker.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Please insert an existing ID");
					}
				}
			}
		}
	}
}
