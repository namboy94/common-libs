package com.krumreyh.java.krumreylib.cli;

/**
 * Class that models a basic CLI
 * @author Hermann Krumrey
 * @version 1.0
 */
public class CLITemplate {
	
	/**
	 * Constructor for the class
	 */
	public CLITemplate() {
		
	}
	
	/**
	 * Adds a possible command to the CLI based on a regular expression
	 * @param regex - the regex that leads to this command
	 * @param command - the command to be executed
	 */
	protected void addCommand(String regex, CLICommand command) {
		
	}
	
	protected interface CLICommand {
		public void command();
	}
	
	protected class Command {
		
	}
	
	protected enum CommandType {
		STRING, REGEX
	}
	
}
