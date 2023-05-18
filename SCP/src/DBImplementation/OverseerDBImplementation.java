package DBImplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import acs.Continent;
import clases.Overseer;
import clases.SCP;
import clases.Worker;
import controller.OverseerControllable;
import exceptions.ServerException;

/**
 * Implements the functionality for managing Overseer objects in the database.
 */

public class OverseerDBImplementation implements OverseerControllable {

	protected Connection con;
	protected PreparedStatement stmt;
	protected DBConnectionController conController = new DBConnectionController();

	/**
	 * Adds a new SCP to the database.
	 */
	@Override
	public void addSCP() {
		// TODO Auto-generated method stub

	}

	/**
	 * Assigns an SCP to a Scientific worker.
	 */
	@Override
	public void asignSCPtoScientific() {
		// TODO Auto-generated method stub

	}

	/**
	 * Assigns an Agent to a Facility.
	 */
	@Override
	public void asignAgentToFacility() {
		// TODO Auto-generated method stub

	}

	/**
	 * Increases the level of a Worker.
	 *
	 * @param work the Worker object
	 * @throws ServerException if an error occurs on the server
	 */
	@Override
	public void levelUpWorker(Worker work) throws ServerException {
		try {
			con = conController.openConnection();

			String UPDATEworker = "UPDATE WORKER SET Level_Worker = Level_Worker + 1 WHERE ID_Worker=?";
			stmt = con.prepareStatement(UPDATEworker);
			stmt.setString(1, work.getId());
			stmt.executeUpdate();

			conController.closeConnection(stmt, con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes a Worker from the database.
	 *
	 * @param idWorker the ID of the Worker to delete
	 * @throws ServerException if an error occurs on the server
	 */
	@Override
	public void deleteWorker(String idWorker) throws ServerException {
		con = conController.openConnection();

		try {

			String BORRARwork = "DELETE FROM Worker WHERE ID_Worker = ?";
			stmt = con.prepareStatement(BORRARwork);
			stmt.setString(1, idWorker);
			stmt.executeUpdate();

			conController.closeConnection(stmt, con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes an SCP from the database.
	 *
	 * @param idScp the ID of the SCP to delete
	 * @throws ServerException if an error occurs on the server
	 */
	@Override
	public void deleteSCP(String idScp) throws ServerException {

		try {

			con = conController.openConnection();

			String DELETEscp = "DELETE FROM scp WHERE ID_SCP = ?";

			stmt = con.prepareStatement(DELETEscp);

			stmt.setString(1, idScp);
			stmt.executeUpdate();

			conController.closeConnection(stmt, con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves information about a Worker from the database.
	 *
	 * @param id the ID of the Worker
	 * @return the Overseer object with the retrieved information
	 * @throws ServerException if an error occurs on the server
	 */
	@Override
	public Worker showInfo(String id) throws ServerException {
		ResultSet rs = null;
		Overseer ove = null;
		try {

			con = conController.openConnection();
			String OBTAINstudies = "select * from worker w, overseer o where w.ID_Worker = o.ID_Overseer and ID_Worker = ?";

			ove = new Overseer();

			stmt = con.prepareStatement(OBTAINstudies);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				ove.setId(rs.getString("ID_Worker"));
				ove.setName(rs.getString("Name_Worker"));
				ove.setDate_Entry(rs.getDate("Date_Entry"));
				ove.setActive(rs.getBoolean("Active_Worker"));
				ove.setLevel(rs.getInt("Level_Worker"));
				ove.setPassword(rs.getString("password_Worker"));
				ove.setBossID(rs.getString("ID_Boss"));
				ove.setContinent(Continent.valueOf(rs.getString("Continent")));
			}

			conController.closeConnection(stmt, con);

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

		return ove;
	}

	/**
	 * Creates a new Worker in the database.
	 *
	 * @param ove the Overseer object to create
	 * @throws ServerException if an error occurs on the server
	 */
	@Override
	public void createWorker(Overseer ove) throws ServerException {
		try {
			con = conController.openConnection();

			CallableStatement cst = con.prepareCall("{CALL insertOverseer(?, ?, ?, ?, ?, ?, ? ,?)}");

			cst.setString(1, ove.getId());
			cst.setString(2, ove.getName());
			cst.setDate(3, ove.getDate_Entry());
			cst.setBoolean(4, ove.isActive());
			cst.setInt(5, ove.getLevel());
			cst.setString(6, ove.getPassword());
			cst.setString(7, ove.getBossID());
			cst.setString(8, ove.getContinent().toString());
			cst.execute();

			conController.closeConnection(stmt, con);

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

	}

	/**
	 * Retrieves a list of Overseer IDs from the database.
	 *
	 * @return an ArrayList of Overseer IDs
	 * @throws ServerException if an error occurs on the server
	 */
	@Override
	public ArrayList<String> getOverseerIDs() throws ServerException {
		ResultSet rs = null;
		ArrayList<String> idList = null;
		try {

			con = conController.openConnection();
			String OBTAINids = "SELECT ID_Overseer FROM Overseer";

			idList = new ArrayList<String>();

			stmt = con.prepareStatement(OBTAINids);
			rs = stmt.executeQuery();

			while (rs.next()) {
				idList.add(rs.getString("ID_Overseer"));
			}

			conController.closeConnection(stmt, con);

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

		return idList;
	}

	/**
	 * Retrieves information about all SCPs from the database.
	 *
	 * @return an ArrayList of SCP objects
	 * @throws ServerException if an error occurs on the server
	 */
	public ArrayList<SCP> showAllSCP() throws ServerException {
		try {

			ResultSet rs = null;
			con = conController.openConnection();
			ArrayList<SCP> arrayDeSCP = new ArrayList<SCP>();

			String OBTENERprop = "SELECT * FROM scp";
			stmt = con.prepareStatement(OBTENERprop);
			rs = stmt.executeQuery();

			while (rs.next()) {
				SCP scp = new SCP();
				scp.setScp_id(rs.getString("ID_SCP"));
				scp.setScp_name(rs.getString("Name_SCP"));
				scp.setScp_level(rs.getInt("Level_SCP"));
				arrayDeSCP.add(scp);

			}
			conController.closeConnection(stmt, con);

			return arrayDeSCP;

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}
	}

	/**
	 * Checks if an SCP with the given ID exists in the database.
	 *
	 * @param id_scp the ID of the SCP to check
	 * @return true if the SCP exists, false otherwise
	 * @throws ServerException if an error occurs on the server
	 */
	public boolean checkSCP(String id_scp) throws ServerException {
		ResultSet rs = null;

		try {
			con = conController.openConnection();

			String OBTENERprop1 = "SELECT ID_SCP FROM scp WHERE ID_SCP = ?";
			String id = null;

			stmt = con.prepareStatement(OBTENERprop1);

			stmt.setString(1, id_scp);
			rs = stmt.executeQuery();

			if (rs.next()) {
				id = rs.getString("ID_SCP");
			}

			conController.closeConnection(stmt, con);

			if (id.equals(id_scp) && id != null) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

	}

	/**
	 * Assigns an SCP to a scientist in the database.
	 *
	 * @param scientificID the ID of the scientist
	 * @param scpID        the ID of the SCP
	 * @throws ServerException if an error occurs on the server
	 */
	@Override
	public void asignSCPtoScientific(String scientificID, String scpID) throws ServerException {

		try {

			PreparedStatement stmt = null;
			con = conController.openConnection();
			stmt = con.prepareStatement("INSERT IGNORE INTO RESEARCH(ID_SCP, ID_Scientist) VALUES(?, ?)");
			stmt.setString(1, scpID);
			stmt.setString(2, scientificID);
			stmt.executeUpdate();

			conController.closeConnection(stmt, con);

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}
	}

	/**
	 * Assigns an agent to a facility in the database.
	 *
	 * @param agentID    the ID of the agent
	 * @param facilityID the ID of the facility
	 * @throws ServerException if an error occurs on the server
	 */
	@Override
	public void asignAgentToFacility(String agentID, String facilityID) throws ServerException {
		PreparedStatement stmt = null;
		try {

			con = conController.openConnection();

			stmt = con.prepareStatement("UPDATE AGENT SET ID_Facility = ? WHERE ID_Agent = ?");
			stmt.setString(1, facilityID);
			stmt.setString(2, agentID);
			stmt.executeUpdate();

			conController.closeConnection(stmt, con);
		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

	}

	/**
	 * Adds an SCP to the database.
	 *
	 * @param scp the SCP object to add
	 * @throws ServerException if an error occurs on the server
	 */
	@Override
	public void addSCP(SCP scp) throws ServerException {

		try {

			con = conController.openConnection();

			String ADDscp = "INSERT INTO SCP (ID_SCP, ID_RelatedSCP, ID_Facility, Name_SCP, Procedures, Description_SCP, Level_SCP, Containment, Disruption, Risk, SecondaryC) VALUES (?,?,(SELECT ID_Facility FROM FACILITY WHERE Name_Facility=?),?,?,?,?,?,?,?,?)";

			stmt = con.prepareStatement(ADDscp);
			stmt.setString(1, scp.getScp_id());
			if (scp.getRelated_scp_id().equals("NONE"))
				stmt.setNull(2, Types.VARCHAR);
			else
				stmt.setString(2, scp.getRelated_scp_id());
			stmt.setString(3, scp.getFacility_id());
			stmt.setString(4, scp.getScp_name());
			stmt.setString(5, scp.getScp_procedures());
			stmt.setString(6, scp.getScp_description());
			stmt.setInt(7, scp.getScp_level());
			stmt.setString(8, scp.getContainment().toString());
			stmt.setString(9, scp.getDisruption().toString());
			stmt.setString(10, scp.getRisk().toString());
			stmt.setString(11, scp.getSecondary().toString());
			stmt.executeUpdate();

			conController.closeConnection(stmt, con);

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

	}
}
