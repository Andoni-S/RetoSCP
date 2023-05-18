package clases;

import acs.Containment;
import acs.Disruption;
import acs.Risk;
import acs.SecondaryC;

/**
 * SCP class that represents a Secure Containment Procedure. It contains the
 * necessary attributes, getters, setters, and methods.
 * 
 * This class defines the properties and behavior of an SCP, including its ID,
 * related SCP ID, facility ID, name, procedures, description, level,
 * containment, disruption, risk, and secondary classification.
 * 
 * SCPs are used for secure containment of anomalous entities or phenomena.
 * 
 * Author: Meylin
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

	/**
	 * Retrieves the SCP ID.
	 * 
	 * @return the SCP ID
	 */
	public String getScp_id() {
		return scp_id;
	}

	/**
	 * Sets the SCP ID.
	 * 
	 * @param scp_id the SCP ID to set
	 */
	public void setScp_id(String scp_id) {
		this.scp_id = scp_id;
	}

	/**
	 * Retrieves the related SCP ID.
	 * 
	 * @return the related SCP ID
	 */
	public String getRelated_scp_id() {
		return related_scp_id;
	}

	/**
	 * Sets the related SCP ID.
	 * 
	 * @param related_scp_id the related SCP ID to set
	 */
	public void setRelated_scp_id(String related_scp_id) {
		this.related_scp_id = related_scp_id;
	}

	/**
	 * Retrieves the facility ID associated with the SCP.
	 * 
	 * @return the facility ID
	 */
	public String getFacility_id() {
		return facility_id;
	}

	/**
	 * Sets the facility ID associated with the SCP.
	 * 
	 * @param facility_id the facility ID to set
	 */
	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}

	/**
	 * Retrieves the name of the SCP.
	 * 
	 * @return the name of the SCP
	 */
	public String getScp_name() {
		return scp_name;
	}

	/**
	 * Sets the name of the SCP.
	 * 
	 * @param scp_name the name of the SCP to set
	 */
	public void setScp_name(String scp_name) {
		this.scp_name = scp_name;
	}

	/**
	 * Retrieves the procedures of the SCP.
	 * 
	 * @return the procedures of the SCP
	 */
	public String getScp_procedures() {
		return scp_procedures;
	}

	/**
	 * Sets the procedures of the SCP.
	 * 
	 * @param scp_procedures the procedures of the SCP to set
	 */
	public void setScp_procedures(String scp_procedures) {
		this.scp_procedures = scp_procedures;
	}

	/**
	 * Retrieves the description of the SCP.
	 * 
	 * @return the description of the SCP
	 */
	public String getScp_description() {
		return scp_description;
	}

	/**
	 * Sets the description of the SCP.
	 * 
	 * @param scp_description the description of the SCP to set
	 */
	public void setScp_description(String scp_description) {
		this.scp_description = scp_description;
	}

	/**
	 * Retrieves the level of the SCP.
	 * 
	 * @return the level of the SCP
	 */
	public int getScp_level() {
		return scp_level;
	}

	/**
	 * Sets the level of the SCP.
	 * 
	 * @param scp_level the level of the SCP to set
	 */
	public void setScp_level(int scp_level) {
		this.scp_level = scp_level;
	}

	/**
	 * Retrieves the containment information of the SCP.
	 * 
	 * @return the containment information of the SCP
	 */
	public Containment getContainment() {
		return containment;
	}

	/**
	 * Sets the containment information of the SCP.
	 * 
	 * @param containment the containment information of the SCP to set
	 */
	public void setContainment(Containment containment) {
		this.containment = containment;
	}

	/**
	 * Retrieves the disruption information of the SCP.
	 * 
	 * @return the disruption information of the SCP
	 */
	public Disruption getDisruption() {
		return disruption;
	}

	/**
	 * Sets the disruption information of the SCP.
	 * 
	 * @param disruption the disruption information of the SCP to set
	 */
	public void setDisruption(Disruption disruption) {
		this.disruption = disruption;
	}

	/**
	 * Retrieves the risk information of the SCP.
	 * 
	 * @return the risk information of the SCP
	 */
	public Risk getRisk() {
		return risk;
	}

	/**
	 * Sets the risk information of the SCP.
	 * 
	 * @param risk the risk information of the SCP to set
	 */
	public void setRisk(Risk risk) {
		this.risk = risk;
	}

	/**
	 * Retrieves the secondary classification information of the SCP.
	 * 
	 * @return the secondary classification information of the SCP
	 */
	public SecondaryC getSecondary() {
		return secondary;
	}

	/**
	 * Sets the secondary classification information of the SCP.
	 * 
	 * @param secondary the secondary classification information of the SCP to set
	 */
	public void setSecondary(SecondaryC secondary) {
		this.secondary = secondary;
	}
}
