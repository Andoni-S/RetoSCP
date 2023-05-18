package controller;

import java.util.ArrayList;

import clases.Worker;
import exceptions.LoginException;
import exceptions.ServerException;

/**
 * Interface that defines operations related to login functionality.
 */
public interface Loginable {

	/**
	 * Performs the login of a user.
	 *
	 * @param usernameUsuario the username of the user
	 * @param passwordUsuario the password of the user
	 * @return the corresponding Worker object for the user
	 * @throws LoginException  if an error occurs during login
	 * @throws ServerException if an error occurs on the server
	 */

	Worker logIn(String usernameUsuario, String passwordUsuario) throws LoginException, ServerException;

	/**
	 * Shows the default information of a worker.
	 *
	 * @param id the ID of the worker
	 * @return the worker's information
	 * @throws ServerException if an error occurs on the server
	 */
	Worker showInfoDefault(String id) throws ServerException;

	/**
	 * Shows all workers.
	 *
	 * @return a list of all workers
	 * @throws ServerException if an error occurs on the server
	 */
	ArrayList<Worker> showAllWorkers() throws ServerException;

	/**
	 * Verifies if a worker exists in the system.
	 *
	 * @param id_worker the ID of the worker to verify
	 * @return true if the worker exists, false otherwise
	 * @throws ServerException if an error occurs on the server
	 */
	boolean checkWorker(String id_worker) throws ServerException;

	/**
	 * Creates a new ID for a worker.
	 *
	 * @param w the Worker object for which to create the ID
	 * @return the new ID of the worker
	 * @throws ServerException if an error occurs on the server
	 */
	String workerIDCreator(Worker w) throws ServerException;

}