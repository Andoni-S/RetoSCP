package clases;

import acs.Continent;

/**
 * Overseer class that inherits from the Worker interface. Represents an
 * overseer.
 * 
 * @author Andoni
 */
public class Overseer extends Worker {

	/**
	 * * This class extends the Worker class and adds the functionality of an
	 * overseer. Overseers have a continent associated with them.
	 */
	public Continent continent;

	/**
	 * Retrieves the continent associated with the overseer.
	 * 
	 * @return the continent associated with the overseer
	 */
	public Continent getContinent() {
		return continent;
	}

	/**
	 * Sets the continent associated with the overseer.
	 * 
	 * @param continent the continent associated with the overseer
	 */
	public void setContinent(Continent continent) {
		this.continent = continent;
	}
}
