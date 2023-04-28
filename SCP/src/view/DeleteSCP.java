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

import clases.Overseer;
import clases.SCP;
import clases.Worker;

public class DeleteSCP extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	private JTable tablaSCP;
	private DefaultTableModel model;
	private JLabel lblSCP;
	private JTextField textSCP;
	private JButton btnShowInfo;
	private JButton btnDelete;
	private JLabel background;

	public DeleteSCP() {
		setBounds(0, 0, 1024, 768);
		setLayout(null);

		SCP scp = new SCP();
		ArrayList<SCP> arrayDeSCP = scp.showAllSCP();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 100, 800, 359);
		add(scrollPane);

		tablaSCP = new JTable();

		model = new DefaultTableModel();
		tablaSCP.setModel(model);
		tablaSCP.setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		tablaSCP.setShowGrid(false);

		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Level");

		scrollPane.setViewportView(tablaSCP);

		fillTable();

		lblSCP = new JLabel("Insert the ID of the SCP:");
		lblSCP.setForeground(new Color(255, 255, 255));
		lblSCP.setFont(new Font("OCR A Extended", Font.BOLD, 22));
		lblSCP.setBounds(80, 500, 1500, 80);
		add(lblSCP);

		textSCP = new JTextField();
		textSCP.setBounds(475, 527, 275, 25);
		textSCP.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		add(textSCP);
		textSCP.setColumns(10);

		btnShowInfo= new JButton("Show Info");
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

	public void fillTable() {
		SCP scp = new SCP();
		ArrayList<SCP> arrayDeSCP = scp.showAllSCP();

		for (SCP s : arrayDeSCP) {
			Object[] fila = new Object[3];
			fila[0] = s.getScp_id();
			fila[1] = s.getScp_name();
			fila[2] = s.getScp_level();

			model.addRow(fila);
		}

		tablaSCP.setDefaultEditor(Object.class, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnShowInfo)) {
			if (textSCP.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(tablaSCP, "Empty field. Please enter an ID");
			} else {
				String scpDeletion = textSCP.getText();
				SCP sc = new SCP();

				if (sc.checkSCP(scpDeletion)) {
					
				} else {
					JOptionPane.showMessageDialog(tablaSCP, "Please, insert an existing ID");
				}
			}
		}
		
		if (e.getSource().equals(btnDelete)) {
			if (textSCP.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(tablaSCP, "Empty field. Please enter an ID");
			} else {
				String SCPDeletion = textSCP.getText();
				SCP sc = new SCP();

				if (sc.checkSCP(SCPDeletion)) {
					Overseer ove = new Overseer();
					ove.deleteSCP(sc.getScp_id());
					JOptionPane.showMessageDialog(tablaSCP, "The SCP has been deleted");
				} else {
					JOptionPane.showMessageDialog(tablaSCP, "Please, insert an existing ID");
				}
			}
		}			
	}
}