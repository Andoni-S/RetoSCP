package controller;

import java.util.ArrayList;

import clases.Overseer;
import clases.SCP;
import clases.Worker;
import exceptions.ServerException;

public interface OverseerControllable {
	// ADD
	void addSCP();
	// MODIFY
	void asignSCPtoScientific();
	void asignAgentToFacility();
	void levelUpWorker(Worker work) throws ServerException;
	// DELETE
	void deleteWorker(String idWorker) throws ServerException;
	void deleteSCP(String idScp) throws ServerException;
	
	//Additional
	ArrayList<String> getOverseerIDs() throws ServerException;
	public Worker showInfo(String id) throws ServerException;
	public void createWorker(Overseer ove) throws ServerException;
	public ArrayList<SCP> showAllSCP() throws ServerException;
	public boolean checkSCP(String id_scp) throws ServerException;
}