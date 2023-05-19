
package DBImplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import clases.Agent;
import clases.Facility;
import clases.Worker;
import controller.AgentControllable;
import exceptions.ServerException;

/**
 * 
 * This class provides implementation for the AgentControllable interface and
 * handles database operations related to agents.
 */
public class AgentDBImplementation implements AgentControllable {

	protected Connection con;
	protected PreparedStatement stmt;
	protected DBConnectionController conController = new DBConnectionController();

	/**
	 * Retrieves the facility assigned to a specific worker.
	 *
	 * @param idWorker the ID of the worker
	 * @return the facility assigned to the worker
	 * @throws ServerException if an error occurs on the server
	 */
	@Override
	public Facility showAsignedFacility(String idWorker) throws ServerException {
		Facility fac = null;

		ResultSet rs = null;
		try {

			con = conController.openConnection();
			String OBTAINfacility = "SELECT * FROM FACILITY WHERE ID_Facility = (SELECT ID_Facility FROM agent WHERE ID_Agent = ?)";

			stmt = con.prepareStatement(OBTAINfacility);

			stmt.setString(1, idWorker);
			rs = stmt.executeQuery();

			while (rs.next()) {
				fac = new Facility();
				fac.setFacility_id(rs.getString("ID_Facility"));
				fac.setFacility_name(rs.getString("Name_Facility"));
				fac.setFacility_level(rs.getInt("Level_Facility"));
			}
		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

		conController.closeConnection(stmt, con);

		return fac;
	}

	/**
	 * Retrieves the information of a specific worker.
	 *
	 * @param id the ID of the worker
	 * @return the worker's information
	 * @throws ServerException if an error occurs on the server
	 */
	@Override
	public Worker showInfo(String id) throws ServerException {
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
			throw new ServerException(e.getMessage());
		}

		conController.closeConnection(stmt, con);

		return age;
	}

	/**
	 * Creates a new worker using the data of an agent.
	 *
	 * @param age the agent from which to obtain the data to create the worker
	 * @throws ServerException if an error occurs on the server
	 */
	@Override
	public void createWorker(Agent age) throws ServerException {

		try {
			con = conController.openConnection();

			CallableStatement cst = con.prepareCall("{CALL insertAgent(?, ?, ?, ?, ?, ?, ? ,?)}");

			cst.setString(1, age.getId());
			cst.setString(2, age.getName());
			cst.setDate(3, age.getDate_Entry());
			cst.setBoolean(4, age.isActive());
			cst.setInt(5, age.getLevel());
			cst.setString(6, age.getPassword());
			cst.setString(7, age.getBossID());
			cst.setString(8, age.getHistory());
			cst.execute();

			conController.closeConnection(stmt, con);
		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}
	}

	/**
	 * Retrieves a list of all facilities.
	 *
	 * @return a list of all facilities
	 * @throws ServerException if an error occurs on the server
	 */
	public ArrayList<Facility> showAllFacilities() throws ServerException {
		ResultSet rs = null;
		ArrayList<Facility> arrayFacilities = null;
		try {
			con = conController.openConnection();
			arrayFacilities = new ArrayList<Facility>();

			String OBTENERSCPs = "SELECT * FROM facility";

			stmt = con.prepareStatement(OBTENERSCPs);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Facility facility = new Facility();
				facility.setFacility_id(rs.getString("ID_Facility"));
				facility.setFacility_name(rs.getString("Name_Facility"));
				facility.setFacility_level(rs.getInt("Level_Facility"));

				arrayFacilities.add(facility);

			}

			conController.closeConnection(stmt, con);

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

		return arrayFacilities;
	}

	/**
	 * Retrieves a list of all agents.
	 *
	 * @return a list of all agents
	 * @throws ServerException if an error occurs on the server
	 */
	public ArrayList<Agent> showAllAgents() throws ServerException {
		ResultSet rs = null;
		ArrayList<Agent> arrayAgents = null;
		try {

			con = conController.openConnection();
			arrayAgents = new ArrayList<Agent>();

			String OBTENERSCPs = "SELECT * FROM agent";

			stmt = con.prepareStatement(OBTENERSCPs);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Agent agent = new Agent();
				agent.setId(rs.getString("ID_Agent"));
				agent.setId_facility(rs.getString("ID_Facility"));
				agent.setHistory(rs.getString("Record"));

				arrayAgents.add(agent);

			}

			conController.closeConnection(stmt, con);

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

		return arrayAgents;

	}
}
