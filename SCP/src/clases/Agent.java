package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import controller.AgentController;

/**
 * Agent class that inherits from Worker and implements the AgentController
 * interface
 * 
 * @author Alex
 */
public class Agent extends Worker implements AgentController {
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

	/**
	 * A method that finds a worker from its ID using an SQL statement and returns
	 * it
	 * 
	 * @param id - entered by the user
	 * @return returns the Agent object to display
	 */
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
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		return this;
	}

	/**
	 * This method returns an object of type Facility which will be assigned to a
	 * specific Agent
	 * 
	 * @param ID_Worker - entered by the user
	 * @return returns the Facility object, which is assigned to the Agent
	 */
	@Override
	public Facility showAsignedFacility(String ID_Worker) {
		Facility fac = null;

		ResultSet rs = null;
		con = conController.openConnection();
		String OBTAINfacility = "SELECT * FROM FACILITY WHERE ID_Facility = (SELECT ID_Facility FROM agent WHERE ID_Agent = ?)";

		try {
			stmt = con.prepareStatement(OBTAINfacility);

			stmt.setString(1, ID_Worker);
			rs = stmt.executeQuery();

			while (rs.next()) {
				fac = new Facility();
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
}
