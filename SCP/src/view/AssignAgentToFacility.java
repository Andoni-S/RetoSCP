package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.PreparedStatement;

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

import exceptions.ServerException;
import main.AgentFactory;
import main.OverseerFactory;

import clases.Agent;

/**
 * @author Iñi
 *
 */
public class AssignAgentToFacility extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * It is used for showing the description of the table below it
	 */
	private JLabel lblAgent;
	/**
	 * It is used for showing the description of the table below it.
	 */
	private JLabel lblFacility;
	/**
	 * It is used to show the background image.
	 */
	private JLabel background;
	/**
	 * It is used to retrieve the text on the agent's table and send it to the database.
	 */
	private JTextField txtAgent;
	
	/**
	 * It is used to retrieve the text on the facilities table and send it to the database.
	 */
	private JTextField txtFacility;
	
	/**
	 * It is used to trigger the assignment of the agent to the facility in the database.
	 */
	private JButton btnAssign;
	/**
	 * It is used to show the agent's data from the database.
	 */
	private JTable tableAgent;
	
	/**
	 * It is used to show the facilities data from the database.
	 */
	private JTable tableFacility;
	
	/**
	 * It is used to show the header columns of the agent's table.
	 */
	private DefaultTableModel modelAgent;
	
	/**
	 * It is used to show the header columns of the facilities table.
	 */
	private DefaultTableModel modelFacility;
	
	/**
	 * It is used to contain the whole agent's table.
	 */
	private JScrollPane scrollPaneAgent;
	
	/**
	 * It is used to contain the whole facilities table.
	 */
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
		tableAgent.setBackground(new Color(35,35,35,0));

		tableAgent.setForeground(new Color(255, 255, 255));
		tableAgent.setOpaque(false);
		tableAgent.setShowGrid(false);
		tableAgent.setModel(modelAgent);
		tableAgent.setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		tableAgent.getTableHeader().setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		tableAgent.setRowHeight(tableAgent.getRowHeight()+15);
		tableAgent.getColumnModel().getColumn(0).setPreferredWidth(0);

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
		tableFacility.setBackground(new Color(35,35,35,0));

		tableFacility.setForeground(new Color(255, 255, 255));
		tableFacility.setOpaque(false);
		tableFacility.setShowGrid(false);
		tableFacility.setModel(modelFacility);

		tableFacility.setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		tableFacility.getTableHeader().setFont(new Font("OCR A Extended", Font.PLAIN, 25));
		tableFacility.setRowHeight(tableFacility.getRowHeight()+15);
		tableFacility.getColumnModel().getColumn(0).setPreferredWidth(0);

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

	/**
	 * Gets the data from the database puts it on an arrayList and shows everything on a table.
	 */
	public void fillTableAgent() {
		
		Agent agent = new Agent();

		
		
		ArrayList<Agent> arrayAgents = null
				;
		try {
			arrayAgents = AgentFactory.getAgentDB().showAllAgents();
		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		for (Agent age : arrayAgents) {
			Object[] fila = new Object[1];
			fila[0] = age.getId();

			modelAgent.addRow(fila);
		}

		tableAgent.setDefaultEditor(Object.class, null);

		
	}

	/**
	 * Gets the data from the database puts it on an arrayList and shows everything on a table.
	 */
	public void fillTableFacility() {

		ArrayList<Facility> arrayFacilities = null;
		
		try {
			arrayFacilities = AgentFactory.getAgentDB().showAllFacilities();
		
			for (Facility fac : arrayFacilities) {
				Object[] fila = new Object[1];
				fila[0] = fac.getFacility_id();

				modelFacility.addRow(fila);
			}

		tableFacility.setDefaultEditor(Object.class, null);
		
		} catch (ServerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAssign)) {


			try {
				OverseerFactory.getOverseerDB().asignAgentToFacility(txtAgent.getText(), txtFacility.getText());
				JOptionPane.showMessageDialog(btnAssign, txtFacility.getText() + " assigned to " + txtAgent.getText());
			
			} catch (ServerException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}

	}

}
