package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import acs.Containment;
import acs.Continent;
import controller.OverseerController;

public class Overseer extends Worker implements OverseerController{

	private Connection con;
	private PreparedStatement stmt;
	private DBConnectionController conController = new DBConnectionController();
	private Continent continent;
	/*@Override
	public void logIn() {
		// TODO Auto-generated method stub
		
	}*/

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	@Override
	public void addSCP() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void addWorker() {
		
		
	}

	@Override
	public void asignSCPtoScientific() {
		
		
		
		
	}

	@Override
	public void asignAgentToFacility() {
		
		
		
		
	}
	@Override
	public Worker showInfo(String id) {
		
		super.showInfo(id);
		
		ResultSet rs = null;
		con = conController.openConnection();
				
		String OBTENERprop = "SELECT Continent FROM Overseer WHERE ID_Overseer = ?";
		try {
			stmt = con.prepareStatement(OBTENERprop);		
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			
			while (rs.next()) {			
				setContinent(Continent.valueOf(rs.getString("Continent")));
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conController.closeConnection(stmt, con);
		
		return this;
	}
	@Override
	public void levelUpWorker(Worker worker) {

		ResultSet rs = null;
		
		con = conController.openConnection();
		
		String UPDATEProps = "UPDATE WORKER SET Level_Worker = Level_Worker + 1 WHERE ID_Worker=?";
		
		try {
			stmt = con.prepareStatement(UPDATEProps);
			
			stmt.setString(1, worker.getId());
			
			//rs = stmt.executeQuery();
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conController.closeConnection(stmt, con);
		
	}

	@Override
	public void deleteSCP() {
		ResultSet rs = null;
		con = conController.openConnection();

		String BORRARscp = "DELETE FROM SCP WHERE ID_SCP = ?";

		try {
			stmt = con.prepareStatement(BORRARscp);

			stmt.setString(1, id);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);
		
	}

  @Override
	public void deleteWorker() {
		ResultSet rs = null;
		con = conController.openConnection();

		String BORRARwork = "DELETE FROM Worker WHERE ID_Worker = ?";

		try {
			stmt = con.prepareStatement(BORRARwork);

			stmt.setString(1, id);
			rs = stmt.executeQuery();
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
			CallableStatement cst = con.prepareCall("{CALL insertScientist(?, ?, ?, ?, ?, ?, ? ,?)}");
			
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
		
		
		String OBTENERprop = "select count(ID_Overseer) AS count FROM OVERSEER;";

		try {
			stmt = con.prepareStatement(OBTENERprop);

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
}
