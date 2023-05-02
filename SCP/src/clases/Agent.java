package clases;

import java.sql.CallableStatement;
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
				setId_facility(rs.getString("ID_Facility"));
				fac.setFacility_name(rs.getString("Name_Facility"));
				fac.setFacility_level(rs.getInt("Level_Facility"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conController.closeConnection(stmt, con);
		
		return fac;
	}
	@Override
	public void createWorker() {
		
		ResultSet rs = null;
		con = conController.openConnection();

		try {
			CallableStatement cst = con.prepareCall("{CALL insertScientist(?, ?, ?, ?, ?, ?, ? ,?)}");
			
			cst.setString(1,id);
			cst.setString(2,name);
			cst.setDate(3, date_Entry);
			cst.setBoolean(4, active);
			cst.setInt(5, level);
			cst.setString(6, password);
			cst.setString(7, bossID);
			cst.setString(8, history);
			cst.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conController.closeConnection(stmt, con);
	}
	@Override
	public String workerIDCreator() {
		ResultSet rs = null;
		con = conController.openConnection();
		String id = "AGE-";
		
		
		String OBTENERprop = "select count(ID_Agent) AS count FROM AGENT;";

		try {
			stmt = con.prepareStatement(OBTENERprop);

			//.setString(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				id = id+String.format("%04d", rs.getInt("count")+1);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		System.out.println(id);
		return id;
	}
}
