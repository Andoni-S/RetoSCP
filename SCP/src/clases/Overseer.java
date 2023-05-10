package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public ArrayList<String> showAllFacility() {
		// TODO Auto-generated method stub

		ResultSet rs = null;
		con = conController.openConnection();
		ArrayList<String> facility_list = new ArrayList<String>();

		String OBTENER_SCP = "Select Name_Facility from facility";
		try {
			stmt = con.prepareStatement(OBTENER_SCP);
			rs = stmt.executeQuery();

			while (rs.next()) {
				//String facility;
				facility_list.add(rs.getString("Name_Facility"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);
		return facility_list;
	}
	// This method is used to level up the worker
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

	// And this is used to delete a worker from its ID
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

	public void addSCP(SCP scp) {

		con = conController.openConnection();

		String ADDscp = "INSERT INTO SCP (ID_SCP, ID_RelatedSCP, ID_Facility, Name_SCP, Procedures, Description_SCP, Level_SCP, Containment, Disruption, Risk, SecondaryC) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			stmt = con.prepareStatement(ADDscp);
			stmt.setString(1, scp.getScp_id());
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

		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

	}
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
}
