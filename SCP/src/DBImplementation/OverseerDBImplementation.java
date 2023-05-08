package DBImplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import acs.Continent;
import clases.DBConnectionController;
import clases.Overseer;
import clases.Scientific;
import clases.Worker;
import controller.OverseerControllable;

public class OverseerDBImplementation implements OverseerControllable{

	protected Connection con;
	protected PreparedStatement stmt;
	protected DBConnectionController conController = new DBConnectionController();
	
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

	@Override
	public Worker showInfo(String id) {
		ResultSet rs = null;
		con = conController.openConnection();
		String OBTAINstudies = "select * from worker w, overseer o where w.ID_Worker = o.ID_Overseer and ID_Worker = ?";

		Overseer ove = new Overseer();
		try {
			stmt = con.prepareStatement(OBTAINstudies);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				ove.setId(rs.getString("ID_Worker"));
				ove.setName(rs.getString("Name_Worker"));
				ove.setDate_Entry(rs.getDate("Date_Entry"));
				ove.setActive(rs.getBoolean("Active_Worker"));
				ove.setLevel(rs.getInt("Level_Worker"));
				ove.setPassword(rs.getString("password_Worker"));
				ove.setBossID(rs.getString("ID_Boss"));
				ove.setContinent(Continent.valueOf(rs.getString("Continent")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		return ove;
	}

	@Override
	public void createWorker(Overseer ove) {
		ResultSet rs = null;
		con = conController.openConnection();

		try {
			CallableStatement cst = con.prepareCall("{CALL insertOverseer(?, ?, ?, ?, ?, ?, ? ,?)}");
			
			cst.setString(1,ove.getId());
			cst.setString(2,ove.getName());
			cst.setDate(3, ove.getDate_Entry());
			cst.setBoolean(4, ove.isActive());
			cst.setInt(5, ove.getLevel());
			cst.setString(6, ove.getPassword());
			cst.setString(7, ove.getBossID());
			cst.setString(8, ove.getContinent().toString());
			cst.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conController.closeConnection(stmt, con);
		
	}
	@Override
	public ArrayList<String> getOverseerIDs() {
		ResultSet rs = null;
		con = conController.openConnection();
		String OBTAINids = "SELECT ID_Overseer FROM Overseer";

		ArrayList<String> idList = new ArrayList();
		
		try {
			stmt = con.prepareStatement(OBTAINids);
			rs = stmt.executeQuery();

			while (rs.next()) {				
				idList.add(rs.getString("ID_Overseer"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		return idList;
		
	}

}
