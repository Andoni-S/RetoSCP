package controller;

import clases.Worker;
import exceptions.LoginException;
import exceptions.ServerException;

public interface Loginable {

	public Worker logIn(String usernameUsuario, String passwordUsuario) throws LoginException, ServerException;
}
