package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.OverseerController;

public class Overseer extends Worker implements OverseerController{

	/*@Override
	public void logIn() {
		// TODO Auto-generated method stub
		
	}*/
	
	private Connection con;
	private PreparedStatement stmt;
	private DBConnectionController conController = new DBConnectionController();

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
	public void levelUpWorker() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSCP(String id) {
		
		con = conController.openConnection();
		
		String DELETEscp = "DELETE FROM scp WHERE ID_SCP = ?";
		
		try {
			
			stmt = con.prepareStatement(DELETEscp);
			
			stmt.setString(1, id);

			stmt.executeUpdate();
		
		} catch (SQLException excep) {
	          excep.printStackTrace();
		}
		
		conController.closeConnection(stmt, con);
		
	}

	@Override
	public void deleteWorker() {
		// TODO Auto-generated method stub
		
	}

}
