package controller;

import java.util.ArrayList;
import clases.SCP;
import clases.Scientific;
import clases.Worker;
import exceptions.ServerException;

public interface ScientificControllable {

	ArrayList<SCP> showAsignedSCP(String id) throws ServerException;
	void modifySCP();
	public Worker showInfo(String id) throws ServerException;
	public void createWorker(Scientific sci) throws ServerException;
	public boolean modifySCP(SCP scp)throws ServerException;
}
