package controller;

import clases.Worker;

public interface OverseerController {
	// ADD
	void addSCP();
	void addWorker();
	// MODIFY
	void asignSCPtoScientific();
	void asignAgentToFacility();
	void levelUpWorker(Worker worker);
	// DELETE
	void deleteWorker(String idWorker);
	void deleteSCP(String idScp);
}
