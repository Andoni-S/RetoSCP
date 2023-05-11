package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBImplementation.DBConnectionController;
import acs.Containment;
import acs.Disruption;
import acs.Risk;
import acs.SecondaryC;
import controller.ScientificControllable;

public class Scientific extends Worker{

	private String studies;
	
	private Connection con;
	private PreparedStatement stmt;
	private DBConnectionController conController = new DBConnectionController();

	public String getStudies() {
		return studies;
	}

	public void setStudies(String studies) {
		this.studies = studies;
	}
}

