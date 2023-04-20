package clases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import controller.Loginable;
import clases.DBConnectionController;

public class Worker implements Loginable {

	private String id;
	private String name;
	private Date date_Entry;
	private boolean active;
	private int level;
	private String password;

	private Connection con;
	private PreparedStatement stmt;
	private DBConnectionController conController = new DBConnectionController();

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

	@Override
	public boolean logIn(String usernameUsuario, String passwordUsuario) {
		ResultSet rs = null;
		con = conController.openConnection();

		String OBTENERprop1 = "SELECT ID_Worker, password_Worker FROM Worker WHERE ID_Worker = ?";

		try {
			stmt = con.prepareStatement(OBTENERprop1);

			stmt.setString(1, usernameUsuario);
			rs = stmt.executeQuery();

			while (rs.next()) {
				setId(rs.getString("ID_Worker"));
				setPassword(rs.getString("Password_Worker"));
			}

			if (id != null || password != null) {
				if (id.equals(usernameUsuario) && password.equals(passwordUsuario)) {
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
				// worker.setTelephone(rs.getString("telefono"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conController.closeConnection(stmt, con);

		return this;

	}
}