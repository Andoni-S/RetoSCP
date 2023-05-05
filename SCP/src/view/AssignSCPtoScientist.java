package view;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import clases.Overseer;
import clases.SCP;
import clases.Scientific;
import clases.Worker;

import java.awt.Color;
import java.awt.Font;

public class AssignSCPtoScientist extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblIdSCP;
	private JLabel lblIdScientist;
	private JTextField fieldIDScientist;
	private JTextField fieldIDSCP;
	private JButton btnIDSCP;
	private JLabel background;
	private JTable table1;
	private DefaultTableModel model1;
	private JScrollPane scrollPane1;
	private JTable table2;
	private DefaultTableModel model2;
	private JScrollPane scrollPane2;
	/**
	 * Create the panel.
	 */
	public AssignSCPtoScientist() {
		
		
		btnIDSCP = new JButton("Assign");
	    btnIDSCP.setBounds(400, 620, 144, 23);
	    btnIDSCP.setBackground(new Color(0,0,0));
	    btnIDSCP.setForeground(new Color(255, 255, 255));
        btnIDSCP.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
	    setLayout(null);
	    add(btnIDSCP);
	    btnIDSCP.addActionListener(this);
	    
	    lblIdSCP = new JLabel("SCPs");
	    lblIdSCP.setForeground(new Color(255, 255, 255));
        lblIdSCP.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
	    lblIdSCP.setBounds(750, 75, 42, 14);
	    add(lblIdSCP);

	    lblIdScientist = new JLabel("Scientists");
	    lblIdScientist.setForeground(new Color(255, 255, 255));
        lblIdScientist.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
	    lblIdScientist.setBounds(225, 75, 89, 14);
	    add(lblIdScientist);
	    
	    table1 = new JTable();
	    model1 = new DefaultTableModel();
	    model1.addColumn("ID_Scientist");
	    model1.addColumn("Studies");
	    table1.setModel(model1);
	    
	    scrollPane1 = new JScrollPane();
	    scrollPane1.setBounds(50,125,400,400);
	    add(scrollPane1);
	    scrollPane1.setViewportView(table1);
	    
	    fillTable1();
	    
	    table2 = new JTable();
	    model2 = new DefaultTableModel();
	    model2.addColumn("ID_SCP");
	    model2.addColumn("Name_SCP");
	    table2.setModel(model2);
	    
	    scrollPane2 = new JScrollPane();
	    scrollPane2.setBounds(550,125,400,400);
	    add(scrollPane2);
	    scrollPane2.setViewportView(table2);
	    
	    fillTable2();
	    
	    background = new JLabel("bg");
        background.setIcon(new ImageIcon(LoginWindow.class.getResource("/resources/background.png")));
        background.setBounds(0, 0, 1024, 768);
        add(background);
	}
	
	public void fillTable1() {
		Scientific scientist = new Scientific();
		ArrayList<Scientific> arrayScientists = scientist.showAllScientists();

		for (Scientific sci : arrayScientists) {
			Object[] fila = new Object[2];
			fila[0] = sci.getId();
			fila[1] = sci.getStudies();

			model1.addRow(fila);
		}

		table1.setDefaultEditor(Object.class, null);
	}
	
	public void fillTable2() {
		SCP scp = new SCP();
		ArrayList<SCP> arraySCP = scp.showAllSCP();

		for (SCP sc : arraySCP) {
			Object[] fila = new Object[2];
			fila[0] = sc.getScp_id();
			fila[1] = sc.getScp_name();

			model2.addRow(fila);
		}

		table2.setDefaultEditor(Object.class, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnIDSCP)) {
			Overseer overseer = new Overseer();
			overseer.asignSCPtoScientific(fieldIDScientist.getText(), fieldIDSCP.getText());
			btnIDSCP.setEnabled(false);
		}
		
	}

}
