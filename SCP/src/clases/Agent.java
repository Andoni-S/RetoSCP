package clases;

/**
 * Agent class that inherits from the Worker interface.
 * Represents an agent.
 * 
 * @author Alex
 */

public class Agent extends Worker {

	private String id_facility;
	private String history;

	/**
	 * Retrieves the identifier of the facility associated with the agent.
	 * 
	 * @return the identifier of the facility
	 */
	public String getId_facility() {
		return id_facility;
	}

	/**
	 * Sets the identifier of the facility associated with the agent.
	 * 
	 * @param id_facility the identifier of the facility
	 */
	public void setId_facility(String id_facility) {
		this.id_facility = id_facility;
	}

	/**
	 * Retrieves the history of the agent.
	 * 
	 * @return the history of the agent
	 */
	public String getHistory() {
		return history;
	}

	/**
	 * Sets the history of the agent.
	 * 
	 * @param history the history of the agent
	 */
	public void setHistory(String history) {
		this.history = history;
	}
}
