package DBImplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import acs.Continent;
import clases.Agent;
import clases.DBConnectionController;
import clases.Facility;
import clases.Overseer;
import clases.Worker;
import controller.AgentControllable;

public class AgentDBImplementation implements AgentControllable{

	protected Connection con;
	protected PreparedStatement stmt;
	protected DBConnectionController conController = new DBConnectionController();
	
	@Override
	public Facility showAsignedFacility(String idWorker) {
		Facility fac = null;

		ResultSet rs = null;
		con = conController.openConnection();
		String OBTAINfacility = "SELECT * FROM FACILITY WHERE ID_Facility = (SELECT ID_Facility FROM agent WHERE ID_Agent = ?)";

		try {
			stmt = con.prepareStatement(OBTAINfacility);

			stmt.setString(1, idWorker);
			rs = stmt.executeQuery();

			while (rs.next()) {
				fac = new Facility();
				//setId_facility(rs.getString("ID_Facility"));
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
	public Worker showInfo(String id) {
		ResultSet rs = null;
		con = conController.openConnection();
		String OBTAINstudies = "select * from worker w, agent a where w.ID_Worker = a.ID_Agent and ID_Worker = ?";

		Agent age = new Agent();
		try {
			stmt = con.prepareStatement(OBTAINstudies);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				age.setId(rs.getString("ID_Worker"));
				age.setName(rs.getString("Name_Worker"));
				age.setDate_Entry(rs.getDate("Date_Entry"));
				age.setActive(rs.getBoolean("Active_Worker"));
				age.setLevel(rs.getInt("Level_Worker"));
				age.setPassword(rs.getString("password_Worker"));
				age.setBossID(rs.getString("ID_Boss"));
				age.setId_facility(rs.getString("ID_Facility"));
				age.setHistory(rs.getString("Record"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		return age;
	}

	@Override
	public void createWorker(Agent age) {
		ResultSet rs = null;
		con = conController.openConnection();

		try {
			CallableStatement cst = con.prepareCall("{CALL insertAgent(?, ?, ?, ?, ?, ?, ? ,?)}");
			
			cst.setString(1,age.getId());
			cst.setString(2,age.getName());
			cst.setDate(3, age.getDate_Entry());
			cst.setBoolean(4, age.isActive());
			cst.setInt(5, age.getLevel());
			cst.setString(6, age.getPassword());
			cst.setString(7, age.getBossID());
			cst.setString(8, age.getHistory());
			cst.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conController.closeConnection(stmt, con);
		
	}

}
