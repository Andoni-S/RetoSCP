package clases;

/**
 * Facility class interface. Represents a facility.
 * 
 * This class defines the basic structure and behavior of a facility. Facilities
 * can have an ID, name, and level.
 * 
 * @author Alex
 */
public class Facility {

	private String facility_id;
	private String facility_name;
	private int facility_level;

	/**
	 * Retrieves the ID of the facility.
	 * 
	 * @return the ID of the facility
	 */
	public String getFacility_id() {
		return facility_id;
	}

	/**
	 * Sets the ID of the facility.
	 * 
	 * @param facility_id the ID of the facility
	 */
	public void setFacility_id(String facility_id) {
		this.facility_id = facility_id;
	}

	/**
	 * Retrieves the name of the facility.
	 * 
	 * @return the name of the facility
	 */
	public String getFacility_name() {
		return facility_name;
	}

	/**
	 * Sets the name of the facility.
	 * 
	 * @param facility_name the name of the facility
	 */
	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}

	/**
	 * Retrieves the level of the facility.
	 * 
	 * @return the level of the facility
	 */
	public int getFacility_level() {
		return facility_level;
	}

	/**
	 * Sets the level of the facility.
	 * 
	 * @param facility_level the level of the facility
	 */
	public void setFacility_level(int facility_level) {
		this.facility_level = facility_level;
	}
}
