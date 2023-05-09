package clases;

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

		String OBTENERprop = "SELECT Studies FROM Scientist WHERE ID_Scientist = ?";
		try {
			stmt = con.prepareStatement(OBTENERprop);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				setStudies(rs.getString("Studies"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub

		ResultSet rs = null;
		con = conController.openConnection();
		ArrayList<SCP> scp_list = new ArrayList<SCP>();

		String OBTENER_SCP = "Select * from scp where ID_SCP in (Select ID_SCP from research where ID_Scientist LIKE ?)";
		try {
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

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		return scp_list;

	}

	/** Modificar un SCP */
	@Override
	public boolean modifySCP(SCP scp) {
		// TODO Auto-generated method stub
		final String MODIFYSCP = "UPDATE SCP SET ID_RelatedSCP= ?,ID_Facility=?,Procedures=?,Description_SCP=?,Level_SCP=? WHERE ID_SCP=?";
		boolean correcto = false;
		con = conController.openConnection();
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correcto;
	}

}
