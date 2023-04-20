package clases;

import java.util.Enumeration;

public class SCP {
	private String scp_id;
	private String related_scp_id;
	private String facility_id;
	private String scp_name;
	private String scp_procedures;
	private String scp_description;
	private int scp_level;
	private Enumeration scp_containment;
	private Enumeration scp_disruption;
	private Enumeration scp_risk;
	private Enumeration scp_secondaryC;
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
	public Enumeration getScp_containment() {
		return scp_containment;
	}
	public void setScp_containment(Enumeration scp_containment) {
		this.scp_containment = scp_containment;
	}
	public Enumeration getScp_disruption() {
		return scp_disruption;
	}
	public void setScp_disruption(Enumeration scp_disruption) {
		this.scp_disruption = scp_disruption;
	}
	public Enumeration getScp_risk() {
		return scp_risk;
	}
	public void setScp_risk(Enumeration scp_risk) {
		this.scp_risk = scp_risk;
	}
	public Enumeration getScp_secondaryC() {
		return scp_secondaryC;
	}
	public void setScp_secondaryC(Enumeration scp_secondaryC) {
		this.scp_secondaryC = scp_secondaryC;
	}
	
	
}
