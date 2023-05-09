package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import acs.Containment;
import acs.Continent;
import controller.OverseerController;

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

	@Override
	public Worker showInfo(String id) {
		super.showInfo(id);

		ResultSet rs = null;
		con = conController.openConnection();
		String OBTAINcontinent = "SELECT Continent FROM Overseer WHERE ID_Overseer = ?";

		try {
			stmt = con.prepareStatement(OBTAINcontinent);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				setContinent(Continent.valueOf(rs.getString("Continent")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		return this;
	}

	// This method is used to level up the worker
	@Override
	public void levelUpWorker(Worker work) {
		ResultSet rs = null;
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

	@Override
	public void deleteWorker() {
		ResultSet rs = null;
		con = conController.openConnection();

		String BORRARwork = "DELETE FROM Worker WHERE ID_Worker = ?";

		try {
			stmt = con.prepareStatement(BORRARwork);

			stmt.setString(1, id);
			rs = stmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This method deletes an SCP from its ID
	@Override
	public void deleteSCP(String idScp) {
		ResultSet rs = null;
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

	// And this is used to delete a worker from its ID
	@Override
	public void deleteWorker(String idWorker) {
		ResultSet rs = null;
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
