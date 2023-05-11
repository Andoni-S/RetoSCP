package view;


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
import clases.Scientific;
import exceptions.ServerException;
import main.LoginableFactory;
import main.OverseerFactory;
import main.ScientificFactory;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * This class is a JPanel which implements the ActionListener Interface to add functionality to buttons.
 * It is used in the MainWindow Class.
 * @author Iñi
 */
public class AsignSCPtoScientist extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This label shows the word SCPs at the upper section of the window.
	 */
	private JLabel lblIdSCP;
	/**
	 * This label shows the word Scientists at the upper section of the window.
	 */
	private JLabel lblIdScientist;
	/**
	 * This text field obtains the information of the scientist from the tables and passes it onto the database.
	 */
	private JTextField fieldIDScientist;
	/**
	 * This text field obtains the information of the SCP from the tables and passes it onto the database.
	 */
	private JTextField fieldIDSCP;
	/**
	 * This JButton confirms the assignment of an SCP and a Scientist.
	 */
	private JButton btnIDSCP;
	/**
	 * This JLabel is used to show the background image on the window screen.
	 */
	private JLabel background;
	/**
	 * This table shows all the scientists, ID and studies there are for each one.
	 */
	private JTable tableScientists;
	/**
	 * This model is used to show the header of the columns of the scientist's table.
	 */
	private DefaultTableModel modelScientists;
	/**
	 * This scrollPane is used as a container for the scientist's table.
	 */
	private JScrollPane scrollPaneScientists;
	/**
	 * This table shows all the SCPs, ID and description there are for each one.
	 */
	private JTable tableSCPs;
	/**
	 * This model is used to show the header of the columns of the SCP's table.
	 */
	private DefaultTableModel modelSCPs;
	
	/**
	 * This scrollPane is used as a container for the SCP's table.
	 */
	private JScrollPane scrollPaneSCPs;
	
	/**
	 * Create the panel.
	 */
	
	
	public AsignSCPtoScientist() {
		
		setBounds(0, 0, 1024, 768);
		setLayout(null);
		
		btnIDSCP = new JButton("Assign");
	    btnIDSCP.setBounds(400, 620, 144, 23);
	    btnIDSCP.setBackground(new Color(0,0,0));
	    btnIDSCP.setForeground(new Color(255, 255, 255));
        btnIDSCP.setFont(new Font("OCR A Extended", Font.BOLD, 14));
	    setLayout(null);
	    add(btnIDSCP);
	    btnIDSCP.addActionListener(this);
	    
	    lblIdSCP = new JLabel("SCPs");
	    lblIdSCP.setForeground(new Color(255, 255, 255));
        lblIdSCP.setFont(new Font("OCR A Extended", Font.BOLD, 19));
	    lblIdSCP.setBounds(725, 75, 68, 19);
	    add(lblIdSCP);

	    lblIdScientist = new JLabel("Scientists");
	    lblIdScientist.setForeground(new Color(255, 255, 255));
        lblIdScientist.setFont(new Font("OCR A Extended", Font.BOLD, 19));
	    lblIdScientist.setBounds(189, 75, 122, 19);
	    add(lblIdScientist);
	    
	    fieldIDScientist = new JTextField();
	    fieldIDScientist.setBackground(new Color(0,0,0));
	    fieldIDScientist.setForeground(new Color(255, 255, 255));
        fieldIDScientist.setFont(new Font("OCR A Extended", Font.BOLD, 14));
        fieldIDScientist.setBounds(200, 570, 100, 50);
	    add(fieldIDScientist);
	    
	    fieldIDSCP = new JTextField();
	    fieldIDSCP.setBackground(new Color(0,0,0));
	    fieldIDSCP.setForeground(new Color(255, 255, 255));
        fieldIDSCP.setFont(new Font("OCR A Extended", Font.BOLD, 14));
        fieldIDSCP.setBounds(718, 570, 100, 50);
	    add(fieldIDSCP);
        
	    tableScientists = new JTable();
	    modelScientists = new DefaultTableModel();
	    modelScientists.addColumn("ID_Scientist");
	    modelScientists.addColumn("Studies");
	    tableScientists.setBackground(new Color(0,0,0));
	    tableScientists.setForeground(new Color(255,255,255));
		tableScientists.setOpaque(false);
		tableScientists.setShowGrid(false);
		tableScientists.setModel(modelScientists);
	    tableScientists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 1) {
					final JTable jTable = (JTable) e.getSource();
					final int row = jTable.getSelectedRow();
					final String valueInCell = (String) jTable.getValueAt(row, 0);
					fieldIDScientist.setText(valueInCell);
				}
			}
		});
	    
	    scrollPaneScientists = new JScrollPane();
	    scrollPaneScientists.setBounds(50,125,400,400);
	    scrollPaneScientists.setBackground(new Color(0,0,0));
	    scrollPaneScientists.setForeground(new Color(255,255,255));
	    add(scrollPaneScientists);
		scrollPaneScientists.setOpaque(false);
		scrollPaneScientists.getViewport().setOpaque(false);
	    scrollPaneScientists.setViewportView(tableScientists);
	    
	    fillTableScientists();
	    
	    tableSCPs = new JTable();
	    modelSCPs = new DefaultTableModel();
	    modelSCPs.addColumn("ID_SCP");
	    modelSCPs.addColumn("Name_SCP");
	    tableSCPs.setBackground(new Color(0,0,0));
	    tableSCPs.setForeground(new Color(255,255,255));
		tableSCPs.setOpaque(false);
		tableSCPs.setShowGrid(false);
	    tableSCPs.setModel(modelSCPs);
	    tableSCPs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 1) {
					final JTable jTable = (JTable) e.getSource();
					final int row = jTable.getSelectedRow();
					final String valueInCell = (String) jTable.getValueAt(row, 0);
					fieldIDSCP.setText(valueInCell);
				}
			}
		});
	    
	    scrollPaneSCPs = new JScrollPane();
	    scrollPaneSCPs.setBounds(550,125,400,400);
	    add(scrollPaneSCPs);
	    scrollPaneSCPs.setOpaque(false);
		scrollPaneSCPs.getViewport().setOpaque(false);
	    scrollPaneSCPs.setViewportView(tableSCPs);
	    
	    fillTableSCPs();
	    
	    background = new JLabel("bg");
        background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
        background.setBounds(0, 0, 1024, 768);
        add(background);
	}
	/**
	 * Fills the table with the information from the database in form of an ArrayList
	 * and calls to the showAllScientists method to obtain it.
	 */
	public void fillTableScientists() {
		Scientific scientist = new Scientific();
		ArrayList<Scientific> arrayScientists = null;
		try {
			arrayScientists = ScientificFactory.getScientificDB().showAllScientists();
		

		for (Scientific sci : arrayScientists) {
			Object[] fila = new Object[2];
			fila[0] = sci.getId();
			fila[1] = sci.getStudies();

			modelScientists.addRow(fila);
		}

		tableScientists.setDefaultEditor(Object.class, null);
		} catch (ServerException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	/**
	 * Fills the table with the information from the database in form of an ArrayList
	 * and calls to the showAllSCP method to obtain it.
	 */
	public void fillTableSCPs() {
		SCP scp = new SCP();
		ArrayList<SCP> arraySCP = null;
		try {
			arraySCP = OverseerFactory.getOverseerDB().showAllSCP();
		

			for (SCP sc : arraySCP) {
				Object[] fila = new Object[2];
				fila[0] = sc.getScp_id();
				fila[1] = sc.getScp_name();
				modelSCPs.addRow(fila);
			}

		tableSCPs.setDefaultEditor(Object.class, null);
		
		} catch (ServerException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnIDSCP)) {
			try {
				OverseerFactory.getOverseerDB().asignSCPtoScientific(fieldIDScientist.getText(), fieldIDSCP.getText());
			
			JOptionPane.showMessageDialog(btnIDSCP, fieldIDScientist.getText() + " assigned to " + fieldIDSCP.getText());
			} catch (ServerException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}
		
	}

}
