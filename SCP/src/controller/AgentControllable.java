package controller;

import clases.Agent;
import clases.Facility;
import clases.Worker;
import exceptions.ServerException;

public interface AgentControllable {
	
	Facility showAsignedFacility(String idWorker) throws ServerException;
	public Worker showInfo(String id) throws ServerException;
	public void createWorker(Agent age) throws ServerException;
}
