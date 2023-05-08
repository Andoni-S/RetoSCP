package main;

import DBImplementation.ScientificDBImplementation;
import controller.ScientificControllable;

public class ScientificFactory {

private static ScientificDBImplementation scientistDB = new ScientificDBImplementation();
	
	public static ScientificControllable getScientificDB() {
		return scientistDB;
	}
}
