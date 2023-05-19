package controller;

import java.util.ArrayList;
import clases.SCP;
import clases.Scientific;
import clases.Worker;
import exceptions.ServerException;

/**
 * Interface that defines the operations controllable by a scientist.
 */
public interface ScientificControllable {
	/**
	 * Shows the SCPs assigned to a specific scientist.
	 * 
	 * @param id the ID of the scientist
	 * @return a list of SCPs assigned to the scientist
	 * @throws ServerException if an error occurs on the server
	 */
	ArrayList<SCP> showAsignedSCP(String id) throws ServerException;


	/**
	 * Shows the information of a specific worker.
	 *
	 * @param id the ID of the worker
	 * @return the worker's information
	 * @throws ServerException if an error occurs on the server
	 */
	Worker showInfo(String id) throws ServerException;

	/**
	 * Creates a new worker using the data of a scientist.
	 *
	 * @param sci the scientist from which to obtain the data to create the worker
	 * @throws ServerException if an error occurs on the server
	 */
	void createWorker(Scientific sci) throws ServerException;

	/**
	 * Modifies an SCP.
	 *
	 * @param scp the SCP to modify
	 * @return true if the modification was successful, false otherwise
	 * @throws ServerException if an error occurs on the server
	 */
	boolean modifySCP(SCP scp) throws ServerException;

	/**
	 * Shows all scientists.
	 *
	 * @return a list of all scientists
	 * @throws ServerException if an error occurs on the server
	 */
	ArrayList<Scientific> showAllScientists() throws ServerException;
}