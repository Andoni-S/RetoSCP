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
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;

import clases.Overseer;
import clases.Worker;
import exceptions.ServerException;
import main.LoginableFactory;
import main.OverseerFactory;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The DeleteWorker class is of type JPanel and implements ActionListener. The
 * window is oriented to delete workers
 * 
 * @author Alex
 */
public class DeleteWorker extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	private JTable tablaWorkers;
	private DefaultTableModel model;
	private JLabel lblWorker;
	private JTextField textWorker;
	private JButton btnDelete;
	private JLabel background;

	/**
	 * This is the window constructor, where the table, JTextField and buttons are
	 * generated
	 */
	public DeleteWorker() {
		setBounds(0, 0, 1024, 768);
		setLayout(null);

		Worker work = new Worker();
		try {
			ArrayList<Worker> arrayDeWorkers = LoginableFactory.getLoginable().showAllWorkers();
		} catch (ServerException e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}

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
		scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		scrollPane.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		scrollPane.getViewport().setBackground(Color.BLACK);
		scrollPane.getViewport().setForeground(Color.BLACK);
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override 
            protected void configureScrollBarColors(){
                this.thumbColor = Color.BLACK;
            }
        });
		scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
            @Override 
            protected void configureScrollBarColors(){
                this.thumbColor = Color.BLACK;
            }
        });
		tablaWorkers.setBackground(new Color(35,35,35,0));
		tablaWorkers.setForeground(new Color(255,255,255));
		tablaWorkers.setShowGrid(false);
		tablaWorkers.setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		tablaWorkers.getTableHeader().setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		tablaWorkers.setRowHeight(tablaWorkers.getRowHeight()+15);
		//tablaWorkers.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tablaWorkers.addMouseListener(new MouseAdapter() {
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
		//model.setFont(new Font("OCR A Extended", Font.PLAIN, 20));

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

		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(0, 0, 0));
		btnDelete.setFont(new Font("OCR A Extended", Font.BOLD, 16));
		btnDelete.setBounds(771, 515, 120, 45);
		add(btnDelete);
		btnDelete.addActionListener(this);

		background = new JLabel("bg");
		background.setIcon(new ImageIcon(ShowFacility.class.getResource("/resources/background.png")));
		background.setBounds(0, 0, 1024, 768);
		add(background);
	}

	public void emptyTable() {
		DefaultTableModel model = (DefaultTableModel) tablaWorkers.getModel();
		model.setRowCount(0);
	}

	public void fillTable() {
		try {
			Worker work = new Worker();
			ArrayList<Worker> arrayDeWorkers;
		
			arrayDeWorkers = LoginableFactory.getLoginable().showAllWorkers();
		

			for (Worker worker : arrayDeWorkers) {
			Object[] fila = new Object[3];
			fila[0] = worker.getId();
			fila[1] = worker.getName();
			fila[2] = worker.getDate_Entry();

			model.addRow(fila);
			}

			tablaWorkers.setDefaultEditor(Object.class, null);
		
		} catch (ServerException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {

		if (e.getSource().equals(btnDelete)) {
			if (textWorker.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Empty field. Please enter an ID");
			} else {
				int n = JOptionPane.showConfirmDialog(null, "Do you want to delete this worker?", "Confirmation",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

				if (n == JOptionPane.YES_OPTION) {
					String workerDeletion = textWorker.getText();

					if (LoginableFactory.getLoginable().checkWorker(workerDeletion)) {
						
						OverseerFactory.getOverseerDB().deleteWorker(workerDeletion);
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
		}catch (ServerException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
		
	}
}
