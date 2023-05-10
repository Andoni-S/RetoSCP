package controller;

import clases.Worker;

public interface OverseerController {
	// ADD
	void addSCP();
	void addWorker();

	//MODIFY
	void asignSCPtoScientific(String scientificID, String scpID);
	void asignAgentToFacility1();
	void levelUpWorker1(Worker worker);
	//DELETE
	void deleteSCP();
	void deleteWorker();
	

	// MODIFY
	void asignSCPtoScientific();
	void asignAgentToFacility();
	void levelUpWorker(Worker work);
	// DELETE
	void deleteWorker(String idWorker);
	void deleteSCP(String idScp);
}
