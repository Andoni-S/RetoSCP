package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.Enumeration;

import DBImplementation.DBConnectionController;
import acs.Containment;
import acs.Disruption;

import acs.Risk;
import acs.SecondaryC;
import exceptions.ServerException;

/**
 * SCP class, which will contain the necessary attributes, Getters and Setters
 * and methods
 * 
 * @author Alex
 */
public class SCP {
	private String scp_id;
	private String related_scp_id;
	private String facility_id;
	private String scp_name;
	private String scp_procedures;
	private String scp_description;
	private int scp_level;
	private Containment containment;
	private Disruption disruption;
	private Risk risk;
	private SecondaryC secondary;


	public String getScp_id() {
		return scp_id;
	}

	public void setScp_id(String scp_id) {
		this.scp_id = scp_id;
	}

	public String getRelated_scp_id() {
		return related_scp_id;
	}

	public void setRelated_scp_id(String related_scp_id) {
		this.related_scp_id = related_scp_id;
	}

	public String getFacility_id() {
		return facility_id;
	}

	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}

	public String getScp_name() {
		return scp_name;
	}

	public void setScp_name(String scp_name) {
		this.scp_name = scp_name;
	}

	public String getScp_procedures() {
		return scp_procedures;
	}

	public void setScp_procedures(String scp_procedures) {
		this.scp_procedures = scp_procedures;
	}

	public String getScp_description() {
		return scp_description;
	}

	public void setScp_description(String scp_description) {
		this.scp_description = scp_description;
	}

	public int getScp_level() {
		return scp_level;
	}

	public void setScp_level(int scp_level) {
		this.scp_level = scp_level;
	}

	public Containment getContainment() {
		return containment;
	}

	public void setContainment(Containment containment) {
		this.containment = containment;
	}

	public Disruption getDisruption() {
		return disruption;
	}

	public void setDisruption(Disruption disruption) {
		this.disruption = disruption;
	}

	public Risk getRisk() {
		return risk;
	}

	public void setRisk(Risk risk) {
		this.risk = risk;
	}

	public SecondaryC getSecondary() {
		return secondary;
	}

	public void setSecondary(SecondaryC secondary) {
		this.secondary = secondary;
	}
}
	

