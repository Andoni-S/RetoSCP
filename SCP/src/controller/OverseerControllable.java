package controller;

import java.util.ArrayList;
import clases.Overseer;
import clases.SCP;
import clases.Worker;
import exceptions.ServerException;

/**
 * Interface that defines the operations controllable by an overseer.
 */
public interface OverseerControllable {
	/**
	* Adds a new SCP.
	*/
    void addSCP();

    /**
     * Assigns an SCP to a scientist.
     */
    void asignSCPtoScientific();

    /**
     * Assigns an agent to a facility.
     */
    void asignAgentToFacility();

    /**
     * Increases the level of a worker.
     *
     * @param work the worker to increase the level of
     * @throws ServerException if an error occurs on the server
     */
    
    void levelUpWorker(Worker work) throws ServerException;

    /**
     * Deletes a worker.
     *
     * @param idWorker the ID of the worker to delete
     * @throws ServerException if an error occurs on the server
     */
    
    void deleteWorker(String idWorker) throws ServerException;

    /**
     * Deletes an SCP.
     *
     * @param idScp the ID of the SCP to delete
     * @throws ServerException if an error occurs on the server
     */
    
    void deleteSCP(String idScp) throws ServerException;

    /**
     * Gets the IDs of the overseers.
     *
     * @return a list of overseer IDs
     * @throws ServerException if an error occurs on the server
     */
    
    ArrayList<String> getOverseerIDs() throws ServerException;

    /**
     * Shows the information of a specific worker.
     *
     * @param id the ID of the worker
     * @return the worker's information
     * @throws ServerException if an error occurs on the server
     */ 
    
    Worker showInfo(String id) throws ServerException;

    /**
     * Creates a new worker using the data of an overseer.
     * @param ove the overseer from which to obtain the data to create the worker
     * @throws ServerException if an error occurs on the server
     */
    
    void createWorker(Overseer ove) throws ServerException;

    /**
     * Shows all SCPs.
     * @return a list of all SCPs
     * @throws ServerException if an error occurs on the server
     */
    
    ArrayList<SCP> showAllSCP() throws ServerException;

    /**
     * Checks if an SCP exists in the system.
     * @param id_scp the ID of the SCP to check
     * @return true if the SCP exists, false otherwise
     * @throws ServerException if an error occurs on the server
     */
    
    boolean checkSCP(String id_scp) throws ServerException;

    /**
     * Assigns an SCP to a specific scientist.
     * @param scientificID the ID of the scientist
     * @param scpID        the ID of the SCP
     * @throws ServerException if an error occurs on the server
     */
    
    void asignSCPtoScientific(String scientificID, String scpID) throws ServerException;

    /**
     * Assigns an agent to a specific facility.
     * @param agentID     the ID of the agent
     * @param facilityID  the ID of the facility
     * @throws ServerException if an error occurs on the server
     */
    
    void asignAgentToFacility(String agentID, String facilityID) throws ServerException;
    
    /**
     * Adds a new SCP to the system.
     * @param scp the SCP to add
     * @throws ServerException if an error occurs on the server
     */
    void addSCP(SCP scp) throws ServerException;
}
