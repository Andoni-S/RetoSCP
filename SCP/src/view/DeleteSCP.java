package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import exceptions.EmptyFieldException;
import exceptions.ServerException;
import main.OverseerFactory;

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

		try {
			ArrayList<SCP> arrayDeSCP =  OverseerFactory.getOverseerDB().showAllSCP();
		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 100, 800, 359);
		add(scrollPane);

		tablaSCP = new JTable();

		model = new DefaultTableModel();
		tablaSCP.setModel(model);
		tablaSCP.setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		scrollPane.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		tablaSCP.setBackground(new Color(35,35,35,0));
		tablaSCP.setForeground(new Color(255,255,255));
		tablaSCP.setShowGrid(false);
		tablaSCP.setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		tablaSCP.getTableHeader().setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		tablaSCP.setRowHeight(tablaSCP.getRowHeight()+15);
		tablaSCP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 1) {
					final JTable jTable = (JTable) e.getSource();
					final int row = jTable.getSelectedRow();
					final String valueInCell = (String) jTable.getValueAt(row, 0);
					textSCP.setText(valueInCell);
				}
			}
		});

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
		textSCP.setBounds(450, 527, 275, 25);
		textSCP.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		add(textSCP);
		textSCP.setColumns(10);

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

	public void emptyTable() {
		DefaultTableModel model = (DefaultTableModel) tablaSCP.getModel();
		model.setRowCount(0);
	}

	public void fillTable() {
		try {

			ArrayList<SCP> arrayDeSCP;
		
			arrayDeSCP = OverseerFactory.getOverseerDB().showAllSCP();
		

			for (SCP s : arrayDeSCP) {
				Object[] fila = new Object[3];
				fila[0] = s.getScp_id();
				fila[1] = s.getScp_name();
				fila[2] = s.getScp_level();

				model.addRow(fila);
			}	

			tablaSCP.setDefaultEditor(Object.class, null);
		
		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
		if (e.getSource().equals(btnShowInfo)) {
			if (textSCP.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(tablaSCP, "Empty field. Please enter an ID");
			} else {
				String scpDeletion = textSCP.getText();
				SCP sc = new SCP();

				if (OverseerFactory.getOverseerDB().checkSCP(scpDeletion)) {

				} else {
					JOptionPane.showMessageDialog(tablaSCP, "Please, insert an existing ID");
				}
			}
		}

		if (e.getSource().equals(btnDelete)) {
						
			if (textSCP.getText().trim().isEmpty()) {
				throw new EmptyFieldException("Empty field. Please enter an ID");
			} else {
				int n = JOptionPane.showConfirmDialog(null, "Do you want to delete this worker?", "Confirmation",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

				if (n == JOptionPane.YES_OPTION) {
					String SCPDeletion = textSCP.getText();

					if (OverseerFactory.getOverseerDB().checkSCP(SCPDeletion)) {					
						OverseerFactory.getOverseerDB().deleteSCP(SCPDeletion);
						JOptionPane.showMessageDialog(tablaSCP, "The SCP has been deleted");
						emptyTable();
						fillTable();
						textSCP.setText("");
					} 
					else
						JOptionPane.showMessageDialog(tablaSCP, "Please, insert an existing ID", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);				
				} else {
					JOptionPane.showMessageDialog(tablaSCP, "Please, insert an existing ID");
				}
			}
			
		}
		
		}catch (ServerException e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage());
		} catch (EmptyFieldException e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}
	}
}