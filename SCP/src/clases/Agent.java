package clases;


import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Agent class that inherits from Worker
 * interface
 * 
 * @author Alex
 */
public class Agent extends Worker {

	private String id_facility;
	private String history;

	private Connection con;
	private PreparedStatement stmt;
	private DBConnectionController conController = new DBConnectionController();

	/**
	 * Getters and setters
	 */
	public String getId_facility() {
		return id_facility;
	}

	public void setId_facility(String id_facility) {
		this.id_facility = id_facility;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}
}

