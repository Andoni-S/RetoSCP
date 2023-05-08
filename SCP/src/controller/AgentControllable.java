package controller;

import clases.Agent;
import clases.Facility;
import clases.Worker;

public interface AgentControllable {
	
	Facility showAsignedFacility(String idWorker);
	public Worker showInfo(String id);
	public void createWorker(Agent age);
}
