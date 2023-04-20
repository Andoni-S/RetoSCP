package controller;

public interface OverseerController {
	
	//ADD
	void addSCP();
	void addWorker();
	//MODIFY
	void asignSCPtoScientific();
	void asignAgentToFacility();
	void levelUpWorker();
	//DELETE
	void deleteSCP();
	void deleteWorker();
}
