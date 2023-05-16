package main;

import DBImplementation.AgentDBImplementation;
import controller.AgentControllable;

public class AgentFactory {
	
private static AgentDBImplementation agentDB = new AgentDBImplementation();
	
	public static AgentControllable getAgentDB() {
		return agentDB;
	}
}
