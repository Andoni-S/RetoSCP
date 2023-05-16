package clases;

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
import controller.ScientificController;

public class Scientific extends Worker implements ScientificController {

	private String studies;

	private Connection con;
	private PreparedStatement stmt;
	private DBConnectionController conController = new DBConnectionController();

	public String getStudies() {
		return studies;
	}

	public void setStudies(String studies) {
		this.studies = studies;
	}

	@Override
	public Worker showInfo(String id) {

		super.showInfo(id);

		ResultSet rs = null;
		con = conController.openConnection();

		String OBTAINstudies = "SELECT Studies FROM Scientist WHERE ID_Scientist = ?";

		try {
			stmt = con.prepareStatement(OBTAINstudies);

			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				setStudies(rs.getString("Studies"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		return this;
	}


	/**
	 * Meter en un array de SCP todos los scp que han sido asignados a el científico
	 */
	@Override
	public ArrayList<SCP> showAsignedSCP(String id) {
		ArrayList<SCP> scp_list = new ArrayList<SCP>();

		ResultSet rs = null;
		con = conController.openConnection();

		SCP scp = new SCP();
		String OBTAINscp = "Select * from scp where ID_SCP in (Select ID_SCP from research where ID_Scientist LIKE ?";

		try {
			stmt = con.prepareStatement(OBTAINscp);

			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
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

		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);
		return scp_list;

	}

	@Override
	public void modifySCP() {

	}

	@Override
	public void createWorker() {

		con = conController.openConnection();

		try {
			CallableStatement cst = con.prepareCall("{CALL insertScientist(?, ?, ?, ?, ?, ?, ? ,?)}");

			cst.setString(1, id);
			cst.setString(2, name);
			cst.setDate(3, date_Entry);
			cst.setBoolean(4, active);
			cst.setInt(5, level);
			cst.setString(6, password);
			cst.setString(7, bossID);
			cst.setString(8, studies);
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
		String id = "SCI-";

		String OBTENERIDSCientist = "select count(ID_Scientist) AS count FROM SCIENTIST";

		try {
			stmt = con.prepareStatement(OBTENERIDSCientist);

			// .setString(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				id = id + String.format("%04d", rs.getInt("count") + 1);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		System.out.println(id);
		return id;
	}

	public ArrayList<Scientific> showAllScientists() {
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
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		return arrayScientists;
	}
}
