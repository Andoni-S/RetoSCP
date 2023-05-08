package controller;

import java.util.ArrayList;
import clases.SCP;
import clases.Scientific;
import clases.Worker;

public interface ScientificControllable {

	ArrayList<SCP> showAsignedSCP(String id);
	void modifySCP();
	public Worker showInfo(String id);
	public void createWorker(Scientific sci);
}
