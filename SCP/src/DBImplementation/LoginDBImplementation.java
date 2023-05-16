package DBImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Agent;
import clases.Overseer;
import clases.Scientific;
import clases.Worker;
import controller.Loginable;
import exceptions.LoginException;
import exceptions.ServerException;

public class LoginDBImplementation implements Loginable{

	protected Connection con;
	protected PreparedStatement stmt;
	protected DBConnectionController conController = new DBConnectionController();
	
	@Override
	public Worker logIn(String usernameUsuario, String passwordUsuario) throws LoginException, ServerException {
		ResultSet rs = null;
		con = conController.openConnection();
		Worker worker = null;
		
		String OBTENERprop1 = "SELECT * FROM Worker WHERE ID_Worker = ? and password_Worker = ?";

		try {
			stmt = con.prepareStatement(OBTENERprop1);

			stmt.setString(1, usernameUsuario);
			stmt.setString(2, passwordUsuario);
			rs = stmt.executeQuery();

			if (rs.next()) {
				worker = new Worker();
				worker.setId(rs.getString("ID_Worker"));
				worker.setPassword(rs.getString("password_Worker"));
				worker.setActive(rs.getBoolean("Active_Worker"));
				worker.setDate_Entry(rs.getDate("Date_Entry"));
				worker.setLevel(rs.getInt("Level_Worker"));
				worker.setPassword(rs.getString("password_Worker"));
				worker.setBossID(rs.getString("ID_Boss"));
			}
			else {
				throw new LoginException("Error in Login");
			}
		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

		return worker;
	}

	@Override
	public Worker showInfoDefault(String id) throws ServerException {
		ResultSet rs = null;
		con = conController.openConnection();

		Worker worker = new Worker();
		String OBTENERprop = "SELECT * FROM Worker WHERE ID_Worker = ?";
		try {
			stmt = con.prepareStatement(OBTENERprop);

			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				worker.setId(rs.getString("ID_Worker"));
				worker.setName(rs.getString("Name_Worker"));
				worker.setDate_Entry(rs.getDate("Date_Entry"));
				worker.setActive(rs.getBoolean("Active_Worker"));
				worker.setLevel(rs.getInt("Level_Worker"));
				worker.setPassword(rs.getString("password_Worker"));
				worker.setBossID(rs.getString("ID_Boss"));
			}
		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}
		conController.closeConnection(stmt, con);
		return worker;
	}

	@Override
	public ArrayList<Worker> showAllWorkers() throws ServerException {
		ResultSet rs = null;
		con = conController.openConnection();
		ArrayList<Worker> arrayDeWorkers = new ArrayList<Worker>();

		String OBTENERprop = "SELECT * FROM Worker";

		try {
			stmt = con.prepareStatement(OBTENERprop);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Worker workie = new Worker();
				workie.setId(rs.getString("ID_Worker"));
				workie.setName(rs.getString("Name_Worker"));
				workie.setDate_Entry(rs.getDate("Date_Entry"));

				arrayDeWorkers.add(workie);
			}

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

		conController.closeConnection(stmt, con);

		return arrayDeWorkers;
	}
	public boolean checkWorker(String id_worker) throws ServerException {
		ResultSet rs = null;
		con = conController.openConnection();

		String OBTENERprop1 = "SELECT ID_Worker FROM Worker WHERE ID_Worker = ?";
		Worker worker = new Worker();
		try {
			stmt = con.prepareStatement(OBTENERprop1);

			stmt.setString(1, id_worker);
			rs = stmt.executeQuery();

			if (rs.next()) {
				worker.setId(rs.getString("ID_Worker"));
			}

			if (worker.getId() != null || worker.getPassword() != null) {
				if (worker.getId().equals(id_worker)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}
	}
	@Override
	public String workerIDCreator(Worker w) throws ServerException {
		ResultSet rs = null;
		con = conController.openConnection();
		String id = "";
		String OBTAINcount="";
		
		if(w instanceof Agent) {
			id = "AGE-"; 
			OBTAINcount = "select count(ID_Agent) AS count FROM AGENT;";
		}
		else if(w instanceof Scientific) {
			id = "SCI-"; 
			OBTAINcount = "select count(ID_Scientist) AS count FROM Scientist;";
		}
		else if(w instanceof Overseer) {
			id = "OVE-"; 
			OBTAINcount = "select count(ID_Overseer) AS count FROM Overseer;";
		}
		
		try {
			stmt = con.prepareStatement(OBTAINcount);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = id+String.format("%04d", rs.getInt("count")+1);				
			}

		} catch (SQLException e) {
			throw new ServerException(e.getMessage());
		}

		conController.closeConnection(stmt, con);
		return id;
	}
}
