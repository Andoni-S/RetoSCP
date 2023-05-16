package controller;

import java.util.ArrayList;

import clases.Agent;
import clases.Facility;
import clases.Worker;
import exceptions.ServerException;

public interface AgentControllable {
	
	Facility showAsignedFacility(String idWorker) throws ServerException;
	public Worker showInfo(String id) throws ServerException;
	public void createWorker(Agent age) throws ServerException;
	//public ArrayList<String> showAllFacility() throws ServerException;
	public ArrayList<Facility> showAllFacilities() throws ServerException;
	public ArrayList<Agent> showAllAgents() throws ServerException;
}
