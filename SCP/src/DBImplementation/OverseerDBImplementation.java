package DBImplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import acs.Continent;
import clases.Overseer;
import clases.SCP;
import clases.Scientific;
import clases.Worker;
import controller.OverseerControllable;
import exceptions.ServerException;

public class OverseerDBImplementation implements OverseerControllable{

	protected Connection con;
	protected PreparedStatement stmt;
	protected DBConnectionController conController = new DBConnectionController();
	
	@Override
	public void addSCP() {
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
	public void levelUpWorker(Worker work) throws ServerException {
		ResultSet rs = null;
		try {		
			con = conController.openConnection();
			
			String UPDATEworker = "UPDATE WORKER SET Level_Worker = Level_Worker + 1 WHERE ID_Worker=?";	
			stmt = con.prepareStatement(UPDATEworker);
			stmt.setString(1, work.getId());
			stmt.executeUpdate();	
			
			conController.closeConnection(stmt, con);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteWorker(String idWorker) throws ServerException {
		ResultSet rs = null;
		con = conController.openConnection();

		try {
			
			String BORRARwork = "DELETE FROM Worker WHERE ID_Worker = ?";
			stmt = con.prepareStatement(BORRARwork);
			stmt.setString(1, idWorker);
			stmt.executeUpdate();
		

			conController.closeConnection(stmt, con);	
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteSCP(String idScp) throws ServerException {
		
		try {
			
			ResultSet rs = null;
			con = conController.openConnection();

			String DELETEscp = "DELETE FROM scp WHERE ID_SCP = ?";

		
			stmt = con.prepareStatement(DELETEscp);

			stmt.setString(1, idScp);
			stmt.executeUpdate();		

			conController.closeConnection(stmt, con);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Worker showInfo(String id) throws ServerException {
		ResultSet rs = null;
		Overseer ove = null;
		try {
			
			con = conController.openConnection();
			String OBTAINstudies = "select * from worker w, overseer o where w.ID_Worker = o.ID_Overseer and ID_Worker = ?";

			ove = new Overseer();
		
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

		conController.closeConnection(stmt, con);

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}
		
		return ove;
	}

	@Override
	public void createWorker(Overseer ove) throws ServerException {
		ResultSet rs = null;
		try {
		con = conController.openConnection();

		
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
				
		conController.closeConnection(stmt, con);
		
		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}
		
	}
	@Override
	public ArrayList<String> getOverseerIDs() throws ServerException {
		ResultSet rs = null;
		ArrayList<String> idList = null;
		try {
			
			con = conController.openConnection();
			String OBTAINids = "SELECT ID_Overseer FROM Overseer";

			idList = new ArrayList();
		
		
			stmt = con.prepareStatement(OBTAINids);
			rs = stmt.executeQuery();

			while (rs.next()) {				
				idList.add(rs.getString("ID_Overseer"));
			}		

			conController.closeConnection(stmt, con);

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}
		
		return idList;	
	}
	
	public ArrayList<SCP> showAllSCP() throws ServerException {
		try {
		
			ResultSet rs = null;
			con = conController.openConnection();
			ArrayList<SCP> arrayDeSCP = new ArrayList<SCP>();

			String OBTENERprop = "SELECT * FROM scp";	
			stmt = con.prepareStatement(OBTENERprop);
			rs = stmt.executeQuery();

			while (rs.next()) {
				SCP scp = new SCP();
				scp.setScp_id(rs.getString("ID_SCP"));
				scp.setScp_name(rs.getString("Name_SCP"));
				scp.setScp_level(rs.getInt("Level_SCP"));
				arrayDeSCP.add(scp);

			}
			conController.closeConnection(stmt, con);

			return arrayDeSCP;
		
		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}
	}

	public boolean checkSCP(String id_scp) throws ServerException {
		ResultSet rs = null;
		
		try {		
			con = conController.openConnection();

			String OBTENERprop1 = "SELECT ID_SCP FROM scp WHERE ID_SCP = ?";
			String id = null;
		
			stmt = con.prepareStatement(OBTENERprop1);

			stmt.setString(1, id_scp);
			rs = stmt.executeQuery();

			if (rs.next()) {
				id = rs.getString("ID_SCP");
			}

			conController.closeConnection(stmt, con);
			
			if (id.equals(id_scp) && id != null) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

		
	}

}
