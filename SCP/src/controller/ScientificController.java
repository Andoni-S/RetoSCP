package controller;

import java.util.ArrayList;
import clases.SCP;

public interface ScientificController {

	ArrayList<SCP> showAsignedSCP(String id);
	boolean modifySCP(SCP scp);
	
}
