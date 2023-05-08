package clases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.mysql.cj.jdbc.CallableStatement;

import controller.Loginable;
import exceptions.LoginException;
import exceptions.ServerException;
import clases.DBConnectionController;

public class Worker implements Loginable {

	protected String id;
	protected String name;
	protected Date date_Entry;
	protected boolean active;
	protected int level;
	protected String password;
	protected String bossID;

	protected Connection con;
	protected PreparedStatement stmt;
	protected DBConnectionController conController = new DBConnectionController();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate_Entry() {
		return date_Entry;
	}

	public void setDate_Entry(Date date_Entry) {
		this.date_Entry = date_Entry;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBossID() {
		return bossID;
	}

	public void setBossID(String bossID) {
		this.bossID = bossID;
	}

	@Override
	public Worker logIn(String usernameUsuario, String passwordUsuario) throws LoginException, ServerException{
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
			e.printStackTrace();
			throw new ServerException(e.getMessage());
		}

		return worker;
	}
	public Worker showInfo(String id) {

		ResultSet rs = null;
		con = conController.openConnection();

		String OBTENERprop = "SELECT * FROM Worker WHERE ID_Worker = ?";
		try {
			stmt = con.prepareStatement(OBTENERprop);

			stmt.setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				setId(rs.getString("ID_Worker"));
				setName(rs.getString("Name_Worker"));
				setDate_Entry(rs.getDate("Date_Entry"));
				setActive(rs.getBoolean("Active_Worker"));
				setLevel(rs.getInt("Level_Worker"));
				setPassword(rs.getString("password_Worker"));
				setBossID(rs.getString("ID_Boss"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conController.closeConnection(stmt, con);

		return this;
	}

	public ArrayList<Worker> showAllWorkers() {
		ResultSet rs = null;
		con = conController.openConnection();
		ArrayList<Worker> arrayDeWorkers = new ArrayList<Worker>();

		String OBTENERprop = "SELECT * FROM Worker";

		try {
			stmt = con.prepareStatement(OBTENERprop);

			// .setString(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Worker workie = new Worker();
				workie.setId(rs.getString("ID_Worker"));
				workie.setName(rs.getString("Name_Worker"));
				workie.setDate_Entry(rs.getDate("Date_Entry"));

				arrayDeWorkers.add(workie);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		return arrayDeWorkers;
	}

	public boolean checkWorker(String id_worker) {
		ResultSet rs = null;
		con = conController.openConnection();

		String OBTENERprop1 = "SELECT ID_Worker FROM Worker WHERE ID_Worker = ?";

		try {
			stmt = con.prepareStatement(OBTENERprop1);

			stmt.setString(1, id_worker);
			rs = stmt.executeQuery();

			while (rs.next()) {
				setId(rs.getString("ID_Worker"));
			}

			if (id != null || password != null) {
				if (id.equals(id_worker)) {
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
	public void createWorker() {
		
	}
	public String workerIDCreator() {
		//default Worker, not used
		return "WOR-0000";
	}
}
