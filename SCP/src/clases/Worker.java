package clases;

import java.sql.Date;

/**
 * Worker class used for different users. Represents a worker.
 * 
 * This class serves as a base class for specific worker types.
 * 
 * @author Andoni
 */
public class Worker {

	protected String id;
	protected String name;
	protected Date date_Entry;
	protected boolean active;
	protected int level;
	protected String password;
	protected String bossID;

	/**
	 * Retrieves the ID of the worker.
	 * 
	 * @return the ID of the worker
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the ID of the worker.
	 * 
	 * @param id the ID of the worker
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Retrieves the name of the worker.
	 * 
	 * @return the name of the worker
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the worker.
	 * 
	 * @param name the name of the worker
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the date of entry for the worker.
	 * 
	 * @return the date of entry for the worker
	 */
	public Date getDate_Entry() {
		return date_Entry;
	}

	/**
	 * Sets the date of entry for the worker.
	 * 
	 * @param date_Entry the date of entry for the worker
	 */
	public void setDate_Entry(Date date_Entry) {
		this.date_Entry = date_Entry;
	}

	/**
	 * Retrieves the activity status of the worker.
	 * 
	 * @return true if the worker is active, false otherwise
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the activity status of the worker.
	 * 
	 * @param active the activity status of the worker
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Retrieves the level of the worker.
	 * 
	 * @return the level of the worker
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets the level of the worker.
	 * 
	 * @param level the level of the worker
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Retrieves the password of the worker.
	 * 
	 * @return the password of the worker
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the worker.
	 * 
	 * @param password the password of the worker
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Retrieves the boss ID associated with the worker.
	 * 
	 * @return the boss ID associated with the worker
	 */
	public String getBossID() {
		return bossID;
	}

	/**
	 * Sets the boss ID associated with the worker.
	 * 
	 * @param bossID the boss ID associated with the worker
	 */
	public void setBossID(String bossID) {
		this.bossID = bossID;
	}

}
