package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.AgentController;
import controller.Loginable;

public class Agent extends Worker implements AgentController {
	private Connection con;
	private PreparedStatement stmt;
	private DBConnectionController conController = new DBConnectionController();

	private String ID_Facility;
	private String record;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public PreparedStatement getStmt() {
		return stmt;
	}

	public void setStmt(PreparedStatement stmt) {
		this.stmt = stmt;
	}

	public DBConnectionController getConController() {
		return conController;
	}

	public void setConController(DBConnectionController conController) {
		this.conController = conController;
	}

	public String getID_Facility() {
		return ID_Facility;
	}

	public void setID_Facility(String iD_Facility) {
		ID_Facility = iD_Facility;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
		}

	/*
	 * @Override public void logIn() { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	@Override
	public Facility showAsignedFacility(String ID_Worker) {
		Facility fac = null;
		ResultSet rs = null;
		con = conController.openConnection();

		String OBTENERfacility = "SELECT * FROM FACILITY WHERE ID_Facility = (SELECT ID_Facility FROM agent WHERE ID_Agent = ?)";

		try {
			stmt = con.prepareStatement(OBTENERfacility);

			stmt.setString(1, ID_Worker);
			rs = stmt.executeQuery();

			while (rs.next()) {
				fac = new Facility(); //???
				setID_Facility(rs.getString("ID_Facility"));
				fac.setFacility_name(rs.getString("Name_Facility"));
				fac.setFacility_level(rs.getInt("Level_Facility"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conController.closeConnection(stmt, con);
		
		return fac;
	}


}
