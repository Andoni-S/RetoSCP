package clases;


import java.sql.Connection;
import java.sql.PreparedStatement;

import controller.AgentController;
import controller.Loginable;

public class Agent extends Worker implements AgentController{

	/*@Override
	public void logIn() {
		// TODO Auto-generated method stub
		
	}*/

	private String id_facility;
	private String history;
	
	private Connection con;
	private PreparedStatement stmt;
	private DBConnectionController conController = new DBConnectionController();
	
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
  
	@Override
	public void showAsignedFacility() {
		// TODO Auto-generated method stub
		
	}

	

}
