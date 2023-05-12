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

import clases.Facility;
import clases.Overseer;
import clases.Scientific;
import clases.Agent;

public class AssignAgentToFacility extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblAgent;
	private JLabel lblFacility;
	private JLabel background;
	private JTextField txtAgent;
	private JTextField txtFacility;
	private JButton btnAssign;
	private JTable tableAgent;
	private JTable tableFacility;
	private DefaultTableModel modelAgent;
	private DefaultTableModel modelFacility;
	private JScrollPane scrollPaneAgent;
	private JScrollPane scrollPaneFacility;

	/**
	 * Create the panel.
	 */
	public AssignAgentToFacility() {

		setLayout(null);

		lblAgent = new JLabel("Agents");
		lblAgent.setForeground(new Color(255, 255, 255));
		lblAgent.setFont(new Font("OCR A Extended", Font.BOLD, 19));
		lblAgent.setBounds(223, 5, 91, 25);
		add(lblAgent);

		lblFacility = new JLabel("Facilities");
		lblFacility.setForeground(new Color(255, 255, 255));
		lblFacility.setFont(new Font("OCR A Extended", Font.BOLD, 19));
		lblFacility.setBounds(700, 5, 82, 25);
		add(lblFacility);

		tableAgent = new JTable();
		modelAgent = new DefaultTableModel();
		modelAgent.addColumn("ID_Agent");
		tableAgent.setBackground(new Color(0, 0, 0));
		tableAgent.setForeground(new Color(255, 255, 255));
		tableAgent.setOpaque(false);
		tableAgent.setShowGrid(false);
		tableAgent.setModel(modelAgent);
		tableAgent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 1) {
					final JTable jTable = (JTable) e.getSource();
					final int row = jTable.getSelectedRow();
					final String valueInCell = (String) jTable.getValueAt(row, 0);
					txtAgent.setText(valueInCell);
				}
			}
		});

		scrollPaneAgent = new JScrollPane();
		scrollPaneAgent.setBounds(50, 125, 400, 400);
		scrollPaneAgent.setBackground(new Color(0, 0, 0));
		scrollPaneAgent.setForeground(new Color(255, 255, 255));
		add(scrollPaneAgent);
		scrollPaneAgent.setOpaque(false);
		scrollPaneAgent.getViewport().setOpaque(false);
		scrollPaneAgent.setViewportView(tableAgent);

		fillTableAgent();

		tableFacility = new JTable();
		modelFacility = new DefaultTableModel();
		modelFacility.addColumn("ID_Facility");
		tableFacility.setBackground(new Color(0, 0, 0));
		tableFacility.setForeground(new Color(255, 255, 255));
		tableFacility.setOpaque(false);
		tableFacility.setShowGrid(false);
		tableFacility.setModel(modelFacility);
		tableFacility.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 1) {
					final JTable jTable = (JTable) e.getSource();
					final int row = jTable.getSelectedRow();
					final String valueInCell = (String) jTable.getValueAt(row, 0);
					txtFacility.setText(valueInCell);
				}
			}
		});

		scrollPaneFacility = new JScrollPane();
		scrollPaneFacility.setBounds(550, 125, 400, 400);
		add(scrollPaneFacility);
		scrollPaneFacility.setOpaque(false);
		scrollPaneFacility.getViewport().setOpaque(false);
		scrollPaneFacility.setViewportView(tableFacility);

		fillTableFacility();

		txtAgent = new JTextField();
		txtAgent.setBackground(new Color(0, 0, 0));
		txtAgent.setForeground(new Color(255, 255, 255));
		txtAgent.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		txtAgent.setBounds(200, 570, 100, 50);
		add(txtAgent);
		
		txtFacility = new JTextField();
	    txtFacility.setBackground(new Color(0,0,0));
	    txtFacility.setForeground(new Color(255, 255, 255));
        txtFacility.setFont(new Font("OCR A Extended", Font.BOLD, 14));
        txtFacility.setBounds(680, 570, 100, 50);
	    add(txtFacility);

		btnAssign = new JButton("Assign");
		btnAssign.setBounds(420, 620, 144, 23);
		btnAssign.setBackground(new Color(0, 0, 0));
		btnAssign.setForeground(new Color(255, 255, 255));
		btnAssign.setFont(new Font("OCR A Extended", Font.BOLD, 14));
		add(btnAssign);
		btnAssign.addActionListener(this);

		background = new JLabel("bg");
		background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
		background.setBounds(0, 0, 1024, 768);
		add(background);

	}

	public void fillTableAgent() {
		
		Agent agent = new Agent();
		ArrayList<Agent> arrayAgents = agent.showAllAgents();

		for (Agent age : arrayAgents) {
			Object[] fila = new Object[1];
			fila[0] = age.getId();

			modelAgent.addRow(fila);
		}

		tableAgent.setDefaultEditor(Object.class, null);

		
	}

	public void fillTableFacility() {
		Facility facility = new Facility();
		ArrayList<Facility> arrayFacilities = facility.showAllFacilities();

		for (Facility fac : arrayFacilities) {
			Object[] fila = new Object[1];
			fila[0] = fac.getFacility_id();

			modelFacility.addRow(fila);
		}

		tableFacility.setDefaultEditor(Object.class, null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAssign)) {
			Overseer overseer = new Overseer();
			overseer.asignAgentToFacility1(txtAgent.getText(), txtFacility.getText());;
			btnAssign.setEnabled(false);
			JOptionPane.showMessageDialog(btnAssign, txtFacility.getText() + " assigned to " + txtAgent.getText());
		}

	}

}
