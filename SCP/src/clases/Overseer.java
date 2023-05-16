package clases;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import acs.Continent;
import controller.OverseerController;

/**
 * Overseer class that inherits from Worker and implements the methods of the
 * interface named OverseerController
 * 
 * @author Alex
 */
public class Overseer extends Worker implements OverseerController {
	private Connection con;
	private PreparedStatement stmt;
	private DBConnectionController conController = new DBConnectionController();
	private Continent continent;

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	@Override
	public void addSCP() {

	}

	@Override
	public void addWorker() {

	}

	@Override
	public void asignSCPtoScientific() {

	}

	@Override
	public void asignAgentToFacility() {

	}

	/**
	 * The following method increments by 1 the Level_Worker attribute of a Worker
	 * that it finds using a user-entered ID
	 * 
	 * @param work - user-entered Worker object
	 */
	@Override
	public void levelUpWorker(Worker work) {
		con = conController.openConnection();
		String UPDATEworker = "UPDATE WORKER SET Level_Worker = Level_Worker + 1 WHERE ID_Worker=?";

		try {
			stmt = con.prepareStatement(UPDATEworker);
			stmt.setString(1, work.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		conController.closeConnection(stmt, con);

	}

	/**
	 * Method used to remove an SCP from the SCPs table in the database from the
	 * attribute ID_SCP
	 * 
	 * @param idScp - user-entered String variable
	 */
	@Override
	public void deleteSCP(String idScp) {
		con = conController.openConnection();

		String DELETEscp = "DELETE FROM scp WHERE ID_SCP = ?";

		try {
			stmt = con.prepareStatement(DELETEscp);

			stmt.setString(1, idScp);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);
	}

	/**
	 * This method deletes a Worker from its ID
	 * 
	 * @param idWorker - entered by the user
	 */
	@Override
	public void deleteWorker(String idWorker) {
		con = conController.openConnection();

		String BORRARwork = "DELETE FROM Worker WHERE ID_Worker = ?";

		try {
			stmt = con.prepareStatement(BORRARwork);

			stmt.setString(1, idWorker);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);
	}
}
