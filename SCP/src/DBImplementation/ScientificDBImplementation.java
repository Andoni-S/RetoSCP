package DBImplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import acs.Containment;
import acs.Discruption;
import acs.Risk;
import acs.SecondaryC;
import clases.DBConnectionController;
import clases.SCP;
import clases.Scientific;
import clases.Worker;
import controller.ScientificControllable;

public class ScientificDBImplementation implements ScientificControllable{

	protected Connection con;
	protected PreparedStatement stmt;
	protected DBConnectionController conController = new DBConnectionController();
	
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
				scp.setDisruption(Discruption.valueOf(rs.getString("Disruption")));
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Worker showInfo(String id) {
		ResultSet rs = null;
		con = conController.openConnection();
		String OBTAINstudies = "select * from worker w, scientist s where w.ID_Worker = s.ID_Scientist and ID_Worker = ?";

		Scientific sci= new Scientific();
		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		return sci;
	}

	@Override
	public void createWorker(Scientific sci) {
		ResultSet rs = null;
		con = conController.openConnection();

		try {
			CallableStatement cst = con.prepareCall("{CALL insertScientist(?, ?, ?, ?, ?, ?, ? ,?)}");
			
			cst.setString(1,sci.getId());
			cst.setString(2,sci.getName());
			cst.setDate(3, sci.getDate_Entry());
			cst.setBoolean(4, sci.isActive());
			cst.setInt(5, sci.getLevel());
			cst.setString(6, sci.getPassword());
			cst.setString(7, sci.getBossID());
			cst.setString(8, sci.getStudies());
			cst.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conController.closeConnection(stmt, con);
		
	}

}
