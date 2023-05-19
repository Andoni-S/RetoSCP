package controller;

import java.util.ArrayList;
import clases.Agent;
import clases.Facility;
import clases.Worker;
import exceptions.ServerException;

/**
 * Interface that defines the operations controllable by an agent.
 */

public interface AgentControllable {

	/**
	 * Shows the facility assigned to a specific worker.
	 *
	 * @param idWorker the ID of the worker
	 * @return the facility assigned to the worker
	 * @throws ServerException if an error occurs on the server
	 */

	Facility showAsignedFacility(String idWorker) throws ServerException;

	/**
	 * Shows the information of a specific worker.
	 *
	 * @param id the ID of the worker
	 * @return the worker's information
	 * @throws ServerException if an error occurs on the server
	 */
	Worker showInfo(String id) throws ServerException;

	/**
	 * Creates a new worker using the data of an agent.
	 *
	 * @param age the agent from which to obtain the data to create the worker
	 * @throws ServerException if an error occurs on the server
	 */
	
	void createWorker(Agent age) throws ServerException;

	/**
	 * Shows all facilities.
	 *
	 * @return a list of all facilities
	 * @throws ServerException if an error occurs on the server
	 */
	
	ArrayList<Facility> showAllFacilities() throws ServerException;

	/**
	 * Shows all agents.
	 *
	 * @return a list of all agents
	 * @throws ServerException if an error occurs on the server
	 */
	
	ArrayList<Agent> showAllAgents() throws ServerException;

}
