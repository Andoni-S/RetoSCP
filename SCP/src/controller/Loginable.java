package controller;

import java.util.ArrayList;

import clases.Worker;
import exceptions.LoginException;
import exceptions.ServerException;

public interface Loginable {

	public Worker logIn(String usernameUsuario, String passwordUsuario) throws LoginException, ServerException;
	public Worker showInfoDefault(String id);
	public ArrayList<Worker> showAllWorkers();
	public boolean checkWorker(String id_worker);
}
