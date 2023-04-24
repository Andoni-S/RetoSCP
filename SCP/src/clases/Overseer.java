package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.mysql.cj.jdbc.CallableStatement;

import controller.OverseerController;

public class Overseer extends Worker implements OverseerController{

	private Connection con;
	private PreparedStatement stmt;
	private DBConnectionController conController = new DBConnectionController();
	
	/*@Override
	public void logIn() {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public void addSCP() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void addWorker() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asignSCPtoScientific(String id_scientist, String id_scp) {
		
		con = conController.openConnection();
		
		try {
			CallableStatement cst = (CallableStatement) con.prepareCall("{CALL asignSCPtoScientific(?, ?)}");
			cst.setString(1, id_scientist);
			cst.setString(2, id_scp);
			cst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		conController.closeConnection(stmt, con);
		
	}

	@Override
	public void asignAgentToFacility() {
		
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWorker() {
		// TODO Auto-generated method stub
		
	}

}
