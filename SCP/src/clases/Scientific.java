package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import acs.Containment;
import acs.Discruption;
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
	public ArrayList<SCP> showAsignedSCP(String id) {
		// TODO Auto-generated method stub

		ResultSet rs = null;
		con = conController.openConnection();
		ArrayList<SCP> scp_list = new ArrayList();
		SCP scp = new SCP();
		String OBTENER_SCP = "Select * from scp where ID_SCP in (Select ID_SCP from research where ID_Scientist LIKE ?";
		try {
			stmt = con.prepareStatement(OBTENER_SCP);

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
				scp.setDisruption(Discruption.valueOf(rs.getString("Disruption")));
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

	@Override
	public void modifySCP() {
		// TODO Auto-generated method stub

	}

}
