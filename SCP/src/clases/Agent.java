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
	public void showAsignedFacility() {
		ResultSet rs = null;
		con = conController.openConnection();

		String OBTENERfacility = "SELECT * FROM facility WHERE id_facility = (SELECT id_facility FROM Agent)";
		try {
			stmt = con.prepareStatement(OBTENERfacility);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Facility facility = new Facility();
				facility.setFacility_id(rs.getString("id_facility"));
				facility.setFacility_name(rs.getString("name_facility"));
				facility.setFacility_level(rs.getString("level_facility"));
				// worker.setTelephone(rs.getString("telefono"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);
		
	}

	

}
