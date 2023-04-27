package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import clases.Worker;

public class DeleteWorker extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	private JTable tablaWorkers;
	private DefaultTableModel model;
	private JLabel lblWorker;
	private JTextField textWorker;
	private JButton btnConfirmDeletion;
	private JButton btnDelete;
	private JLabel background;
	
	public DeleteWorker() {
		setBounds(0, 0, 1024, 768);
		setLayout(null);

Worker work = new Worker();
		ArrayList<Worker> arrayDeWorkers = work.showAllWorkers();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 100, 800, 359);
		add(scrollPane);

		tablaWorkers = new JTable();

		model = new DefaultTableModel();
		tablaWorkers.setModel(model);
		tablaWorkers.setOpaque(false);
		scrollPane.setOpaque(false); 
		scrollPane.getViewport().setOpaque(false); 
		tablaWorkers.setShowGrid(false); 
		

		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Date Entry");

		scrollPane.setViewportView(tablaWorkers);
		
		fillTable();

		lblWorker = new JLabel("Insert the ID of the worker:");
		lblWorker.setForeground(new Color(255, 255, 255));
		lblWorker.setFont(new Font("OCR A Extended", Font.BOLD, 22));
		lblWorker.setBounds(80, 500, 1500, 80);
		add(lblWorker);

		textWorker = new JTextField();
		textWorker.setBounds(475, 527, 275, 25);
		textWorker.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		add(textWorker);
		textWorker.setColumns(10);

		btnConfirmDeletion = new JButton("Show Info");
		btnConfirmDeletion.setBackground(new Color(0, 0, 0));
		btnConfirmDeletion.setForeground(new Color(255, 255, 255));
		btnConfirmDeletion.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		btnConfirmDeletion.setBounds(775, 485, 120, 45);
		add(btnConfirmDeletion);
		btnConfirmDeletion.addActionListener(this);
		
		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(0, 0, 0));
		btnDelete.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		btnDelete.setBounds(775, 545, 120, 45);
		add(btnDelete);
		btnDelete.addActionListener(this);
		
		background = new JLabel("bg");
		background.setIcon(new ImageIcon(ShowFacility.class.getResource("/resources/background.png")));
		background.setBounds(0, 0, 1024, 768);
		add(background);
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
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
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
		}
		
	}}

