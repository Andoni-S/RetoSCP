package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
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

	public void asignSCPtoScientific(String scientificID, String scpID) {
		
		PreparedStatement stmt = null;
		con = conController.openConnection();
		
		try{
			stmt = con.prepareStatement("INSERT IGNORE INTO RESEARCH(ID_SCP, ID_Scientist) VALUES(?, ?)");
			stmt.setString(1, scpID);
			stmt.setString(2, scientificID);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conController.closeConnection(stmt, con);
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
	public void createWorker() {
		
		ResultSet rs = null;
		con = conController.openConnection();

		try {
			CallableStatement cst = con.prepareCall("{CALL insertOverseer(?, ?, ?, ?, ?, ?, ? ,?)}");
			
			cst.setString(1,id);
			cst.setString(2,name);
			cst.setDate(3, date_Entry);
			cst.setBoolean(4, active);
			cst.setInt(5, level);
			cst.setString(6, password);
			cst.setString(7, bossID);
			cst.setString(8, continent.toString());
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
		String id = "OVE-";
		
		
		String OBTENERIDAgent = "select count(ID_Overseer) AS count FROM OVERSEER;";

		try {
			stmt = con.prepareStatement(OBTENERIDAgent);

			//.setString(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				id = id+String.format("%04d", rs.getInt("count")+1);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		System.out.println(id);
		return id;
	}

	@Override
	public void deleteSCP() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWorker() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void levelUpWorker1(Worker worker) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asignAgentToFacility1(String agentID, String facilityID) {
		PreparedStatement stmt = null;
		con = conController.openConnection();
		
		try{
			stmt = con.prepareStatement("INSERT IGNORE INTO Agent(ID_Agent, ID_Facility) VALUES(?, ?)");
			stmt.setString(1, agentID);
			stmt.setString(2, facilityID);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conController.closeConnection(stmt, con);
		
	}

	@Override
	public void asignSCPtoScientific() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asignAgentToFacility() {
		
		
	}

}
