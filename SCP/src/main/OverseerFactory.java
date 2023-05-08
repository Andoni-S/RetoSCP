package main;

import DBImplementation.OverseerDBImplementation;
import controller.OverseerControllable;

public class OverseerFactory {
private static OverseerDBImplementation overseerDB = new OverseerDBImplementation();
	
	public static OverseerControllable getOverseerDB() {
		return overseerDB;
	}
}
