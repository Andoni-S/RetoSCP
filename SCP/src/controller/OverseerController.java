package controller;

import clases.Worker;

public interface OverseerController {
	
	//ADD
	void addSCP();
	void addWorker();
	//MODIFY
	void asignSCPtoScientific(String id_scientist, String id_scp);
	void asignAgentToFacility();
	void levelUpWorker(Worker worker);
	//DELETE
	void deleteSCP();
	void deleteWorker();
}
