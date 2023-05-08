package main;

import DBImplementation.LoginDBImplementation;
import clases.Worker;
import controller.Loginable;

public class LoginableFactory {
	
	private static LoginDBImplementation loginDB = new LoginDBImplementation();
	
	public static Loginable getLoginable() {
		return loginDB;
	}
}
