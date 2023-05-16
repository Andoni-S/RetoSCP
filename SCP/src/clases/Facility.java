package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Facility {
	private String facility_id;
	private String facility_name;
	private int facility_level;
	
	private Connection con;
	private PreparedStatement stmt;
	private DBConnectionController conController = new DBConnectionController();

	public String getFacility_id() {
		return facility_id;
	}

	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}

	public String getFacility_name() {
		return facility_name;
	}

	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}

	public int getFacility_level() {
		return facility_level;
	}

	public void setFacility_level(int facility_level) {
		this.facility_level = facility_level;
	}
	
	public ArrayList<Facility> showAllFacilities() {
		ResultSet rs = null;
		con = conController.openConnection();
		ArrayList<Facility> arrayFacilities = new ArrayList<Facility>();

		String OBTENERSCPs = "SELECT * FROM facility";

		try {
			stmt = con.prepareStatement(OBTENERSCPs);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Facility facility = new Facility();
				facility.setFacility_id(rs.getString("ID_Facility"));
				facility.setFacility_name(rs.getString("Name_Facility"));
				facility.setFacility_level(rs.getInt("Level_Facility"));

				arrayFacilities.add(facility);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		return arrayFacilities;
	}
}
