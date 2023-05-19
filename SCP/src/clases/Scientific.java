package clases;

/**
 * Scientific class that represents a worker with a scientific background. It
 * inherits from the Worker interface.
 * 
 * This class extends the properties and behavior of a Worker, adding the
 * additional attribute for studies.
 * 
 * Author: Meylin
 */
public class Scientific extends Worker {

	private String studies;

	/**
	 * Retrieves the studies of the scientific worker.
	 * 
	 * @return the studies of the scientific worker
	 */
	public String getStudies() {
		return studies;
	}

	/**
	 * Sets the studies of the scientific worker.
	 * 
	 * @param studies the studies of the scientific worker to set
	 */
	public void setStudies(String studies) {
		this.studies = studies;
	}
}
