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

public class Worker implements Loginable{
	
	private String id;
	private String name;
	private Date date_Entry;
	private boolean active;
	private int level;
	private String password;
	private String bossID;

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

	public String getBossID() {
		return bossID;
	}


	public void setBossID(String bossID) {
		this.bossID = bossID;
	}

	@Override
	public void logIn() {
		// TODO Auto-generated method stub
		
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
}
