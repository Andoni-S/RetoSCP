package clases;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.OverseerController;

public class Overseer extends Worker implements OverseerController {

	/*
	 * @Override public void logIn() { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	@Override
	public void addSCP() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addWorker() {
		// TODO Auto-generated method stub

	}

	@Override
	public void asignSCPtoScientific() {
		// TODO Auto-generated method stub

	}

	@Override
	public void asignAgentToFacility() {
		// TODO Auto-generated method stub

	}

	@Override
	public void levelUpWorker() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSCP() {
		// TODO Auto-generated method stub

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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);
	}

}
