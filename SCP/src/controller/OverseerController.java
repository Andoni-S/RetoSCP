package controller;

import clases.SCP;
import clases.Scientific;
import clases.Worker;

public interface OverseerController {
	
	//ADD
	void addSCP();
	void addWorker();
	//MODIFY
	void asignSCPtoScientific(String scientificID, String scpID);
	void asignAgentToFacility();
	void levelUpWorker(Worker worker);
	//DELETE
	void deleteSCP();
	void deleteWorker();
	
}
