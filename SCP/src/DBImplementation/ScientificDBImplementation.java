package DBImplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import acs.Containment;
import acs.Disruption;
import acs.Risk;
import acs.SecondaryC;
import clases.SCP;
import clases.Scientific;
import clases.Worker;
import controller.ScientificControllable;
import exceptions.ServerException;

/**
 * This class provides an implementation of the ScientificControllable interface
 * for managing scientific workers in a database.
 */

public class ScientificDBImplementation implements ScientificControllable {

	protected Connection con;
	protected PreparedStatement stmt;
	protected DBConnectionController conController = new DBConnectionController();

	/**
     * Retrieves a list of SCPs assigned to a specific scientist.
     *
     * @param id the ID of the scientist
     * @return an ArrayList of SCP objects assigned to the scientist
     * @throws ServerException if an error occurs on the server
     */
	@Override
	public ArrayList<SCP> showAsignedSCP(String id) throws ServerException {
		try {
			ResultSet rs = null;
			con = conController.openConnection();
			ArrayList<SCP> scp_list = new ArrayList<SCP>();

			String OBTENER_SCP = "Select * from scp where ID_SCP in (Select ID_SCP from research where ID_Scientist LIKE ?)";

			stmt = con.prepareStatement(OBTENER_SCP);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				SCP scp = new SCP();
				scp.setScp_id(rs.getString("ID_SCP"));
				scp.setScp_name(rs.getString("Name_SCP"));
				scp.setRelated_scp_id(rs.getString("ID_RelatedSCP"));
				scp.setFacility_id(rs.getString("ID_Facility"));
				scp.setScp_description(rs.getString("Description_SCP"));
				scp.setScp_procedures(rs.getString("Procedures"));
				scp.setScp_level(rs.getInt("Level_SCP"));
				scp.setContainment(Containment.valueOf(rs.getString("Containment")));
				scp.setDisruption(Disruption.valueOf(rs.getString("Disruption")));
				scp.setRisk(Risk.valueOf(rs.getString("Risk")));
				scp.setSecondary(SecondaryC.valueOf(rs.getString("SecondaryC")));
				scp_list.add(scp);
			}

			conController.closeConnection(stmt, con);

			return scp_list;

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}
	}

	
	/**
     * Retrieves information about a scientific worker.
     *
     * @param id the ID of the scientific worker
     * @return a Worker object representing the scientific worker
     * @throws ServerException if an error occurs on the server
     */
	@Override
	public Worker showInfo(String id) throws ServerException {
		ResultSet rs = null;
		Scientific sci = null;
		try {

			con = conController.openConnection();
			String OBTAINstudies = "select * from worker w, scientist s where w.ID_Worker = s.ID_Scientist and ID_Worker = ?";

			sci = new Scientific();

			stmt = con.prepareStatement(OBTAINstudies);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				sci.setId(rs.getString("ID_Worker"));
				sci.setName(rs.getString("Name_Worker"));
				sci.setDate_Entry(rs.getDate("Date_Entry"));
				sci.setActive(rs.getBoolean("Active_Worker"));
				sci.setLevel(rs.getInt("Level_Worker"));
				sci.setPassword(rs.getString("password_Worker"));
				sci.setBossID(rs.getString("ID_Boss"));
				sci.setStudies(rs.getString("Studies"));
			}

			conController.closeConnection(stmt, con);

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

		return sci;
	}
	 /**
     * Creates a new scientific worker in the database.
     *
     * @param sci the Scientific object representing the new worker
     * @throws ServerException if an error occurs on the server
     */
	@Override
	public void createWorker(Scientific sci) throws ServerException {
		try {

			con = conController.openConnection();

			CallableStatement cst = con.prepareCall("{CALL insertScientist(?, ?, ?, ?, ?, ?, ? ,?)}");

			cst.setString(1, sci.getId());
			cst.setString(2, sci.getName());
			cst.setDate(3, sci.getDate_Entry());
			cst.setBoolean(4, sci.isActive());
			cst.setInt(5, sci.getLevel());
			cst.setString(6, sci.getPassword());
			cst.setString(7, sci.getBossID());
			cst.setString(8, sci.getStudies());
			cst.execute();

			conController.closeConnection(stmt, con);

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

	}

	/**
     * Modifies an SCP in the database.
     *
     * @param scp the modified SCP object
     * @return true if the modification is successful, false otherwise
     * @throws ServerException if an error occurs on the server
     */
	@Override
	public boolean modifySCP(SCP scp) throws ServerException {

		try {

			final String MODIFYSCP = "UPDATE SCP SET ID_RelatedSCP= ?,ID_Facility=?,Procedures=?,Description_SCP=?,Level_SCP=? WHERE ID_SCP=?";
			boolean correcto = false;
			con = conController.openConnection();

			stmt = con.prepareStatement(MODIFYSCP);
			stmt.setString(1, scp.getRelated_scp_id());
			stmt.setString(2, scp.getFacility_id());
			stmt.setString(3, scp.getScp_procedures());
			stmt.setString(4, scp.getScp_description());
			stmt.setInt(5, scp.getScp_level());
			stmt.setString(6, scp.getScp_id());

			int valor = stmt.executeUpdate();
			conController.closeConnection(stmt, con);
			if (valor == 1)
				correcto = true;

			return correcto;

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}
	}
	/**
     * Retrieves a list of all scientific workers.
     *
     * @return an ArrayList of Scientific objects representing the scientists
     * @throws ServerException if an error occurs on the server
     */
	@Override
	public ArrayList<Scientific> showAllScientists() throws ServerException {
		ResultSet rs = null;
		con = conController.openConnection();
		ArrayList<Scientific> arrayScientists = new ArrayList<Scientific>();

		String OBTENERScientists = "SELECT * FROM scientist";

		try {
			stmt = con.prepareStatement(OBTENERScientists);

			// .setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Scientific scientist = new Scientific();
				scientist.setId(rs.getString("ID_Scientist"));
				scientist.setStudies(rs.getString("Studies"));

				arrayScientists.add(scientist);

			}

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

		conController.closeConnection(stmt, con);

		return arrayScientists;
	}
}
