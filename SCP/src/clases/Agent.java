package clases;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.AgentController;
import controller.Loginable;

public class Agent extends Worker implements AgentController{

	/*@Override
	public void logIn() {
		// TODO Auto-generated method stub
		
	}*/

	private String id_facility;
	private String history;
	
	private Connection con;
	private PreparedStatement stmt;
	private DBConnectionController conController = new DBConnectionController();
	
	public String getId_facility() {
		return id_facility;
	}

	public void setId_facility(String id_facility) {
		this.id_facility = id_facility;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}
	
	@Override
	public Worker showInfo(String id) {
		
		super.showInfo(id);
		
		ResultSet rs = null;
		con = conController.openConnection();
				
		String SELECTagent = "SELECT * FROM Agent WHERE ID_Agent = ?";
		try {
			stmt = con.prepareStatement(SELECTagent);		
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			
			while (rs.next()) {			
				setId_facility(rs.getString("ID_Facility"));
				setHistory(rs.getString("Record"));
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conController.closeConnection(stmt, con);
		
		return this;
	}
	
	@Override
	public void showAsignedFacility() {
		// TODO Auto-generated method stub
		
	}

	

}
