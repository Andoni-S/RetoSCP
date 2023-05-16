package controller;

import java.util.ArrayList;

import clases.Worker;

public interface OverseerController {
	// ADD
	void addSCP();
	void addWorker();

	// MODIFY
	void asignSCPtoScientific();
	void asignAgentToFacility();
	void levelUpWorker(Worker work);
	// DELETE
	void deleteWorker(String idWorker);
	void deleteSCP(String idScp);
	
	//Additional
	ArrayList<String> getOverseerIDs();
}
