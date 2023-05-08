package controller;

import java.util.ArrayList;

import clases.Overseer;
import clases.Worker;

public interface OverseerControllable {
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
	public Worker showInfo(String id);
	public void createWorker(Overseer ove);
}
