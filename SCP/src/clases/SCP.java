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

public class SCP {
	private String scp_id;
	private String related_scp_id;
	private String facility_id;
	private String scp_name;
	private String scp_procedures;
	private String scp_description;
	private int scp_level;
	private Containment containment;
	private Discruption disruption;
	private Risk risk;
	private SecondaryC secondary;

	private Connection con;
	private PreparedStatement stmt;
	private DBConnectionController conController = new DBConnectionController();

	public String getScp_id() {
		return scp_id;
	}

	public void setScp_id(String scp_id) {
		this.scp_id = scp_id;
	}

	public String getRelated_scp_id() {
		return related_scp_id;
	}

	public void setRelated_scp_id(String related_scp_id) {
		this.related_scp_id = related_scp_id;
	}

	public String getFacility_id() {
		return facility_id;
	}

	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}

	public String getScp_name() {
		return scp_name;
	}

	public void setScp_name(String scp_name) {
		this.scp_name = scp_name;
	}

	public String getScp_procedures() {
		return scp_procedures;
	}

	public void setScp_procedures(String scp_procedures) {
		this.scp_procedures = scp_procedures;
	}

	public String getScp_description() {
		return scp_description;
	}

	public void setScp_description(String scp_description) {
		this.scp_description = scp_description;
	}

	public int getScp_level() {
		return scp_level;
	}

	public void setScp_level(int scp_level) {
		this.scp_level = scp_level;
	}

	public Containment getContainment() {
		return containment;
	}

	public void setContainment(Containment containment) {
		this.containment = containment;
	}

	public Discruption getDisruption() {
		return disruption;
	}

	public void setDisruption(Discruption disruption) {
		this.disruption = disruption;
	}

	public Risk getRisk() {
		return risk;
	}

	public void setRisk(Risk risk) {
		this.risk = risk;
	}

	public SecondaryC getSecondary() {
		return secondary;
	}

	public void setSecondary(SecondaryC secondary) {
		this.secondary = secondary;
	}

	public ArrayList<SCP> showAllSCP() {
		ResultSet rs = null;
		con = conController.openConnection();
		ArrayList<SCP> arrayDeSCP = new ArrayList<SCP>();

		String OBTENERprop = "SELECT * FROM scp";

		try {
			stmt = con.prepareStatement(OBTENERprop);
			rs = stmt.executeQuery();

			while (rs.next()) {
				SCP scp = new SCP();
				scp.setScp_id(rs.getString("ID_SCP"));
				scp.setScp_name(rs.getString("Name_SCP"));
				scp.setScp_level(rs.getInt("Level_SCP"));

				arrayDeSCP.add(scp);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		return arrayDeSCP;
	}

	public boolean checkSCP(String id_scp) {
		ResultSet rs = null;
		con = conController.openConnection();

		String OBTENERprop1 = "SELECT ID_SCP FROM scp WHERE ID_SCP = ?";

		try {
			stmt = con.prepareStatement(OBTENERprop1);

			stmt.setString(1, id_scp);
			rs = stmt.executeQuery();

			while (rs.next()) {
				setScp_id(rs.getString("ID_SCP"));
			}

			if (scp_id != null) {
				if (scp_id.equals(id_scp)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
