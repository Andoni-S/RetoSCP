package controller;

import clases.Worker;

public class LoginableFactory {
	
	private static Worker worker = new Worker();
	
	public static Loginable getLoginable() {
		return worker;
	}
}
