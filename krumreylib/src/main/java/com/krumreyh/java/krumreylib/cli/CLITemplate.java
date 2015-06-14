package com.krumreyh.java.krumreylib.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class that models a basic CLI
 * @author Hermann Krumrey
 * @version 1.0
 */
public class CLITemplate {
	
	Command[] commands;
	boolean running;
	
	/**
	 * Constructor for the class
	 */
	public CLITemplate() {
		commands = new Command[0];
	}
	
	/**
	 * Starts the CLI
	 * @throws IOException - In/Out Exception
	 */
	public void start() throws IOException {
		this.running = true;
		while (running) {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String userInput = in.readLine();
			for (int i = 0; i < commands.length; i++) {
				commands[i].run(userInput);
			}
		}
	}
	
	/**
	 * Adds a possible command to the CLI based on a regular expression
	 * @param regex - the regex or string that leads to this command
	 * @param command - the command to be executed
	 * @param commandType - STRING (full comparison) or REGEX (regular expression comparison)
	 */
	protected void addCommand(String regex, CLICommand command, CommandType commandType) {
		Command[] extendedArray = new Command[this.commands.length + 1];
		for (int i = 0; i < this.commands.length; i++) {
			extendedArray[i] = this.commands[i];
		}
		extendedArray[this.commands.length] = new Command(regex, command, commandType);
		this.commands = extendedArray;
	}
	
	/**
	 * Class that models a Command of the CLI
	 */
	protected class Command {
		
		private String regex;
		private CLICommand command;
		private CommandType commandType;
		
		/**
		 * Constructor
		 * @param regex - the regex or string to be used to compare with the user input
		 * @param command - the command to be used
		 * @param commandType - which type of string comparison to be used
		 */
		public Command(String regex, CLICommand command, CommandType commandType) {
			this.regex = regex;
			this.command = command;
			this.commandType = commandType;
		}
		
		/**
		 * parses a user's input and executes the command if a match is found
		 * @param userInput
		 */
		public void run(String userInput) {
			switch (this.commandType) {
			case STRING:	if (userInput.equals(this.regex)) { this.command.execute(); }
							break;
			case REGEX:		if (userInput.matches(this.regex)) { this.command.execute(); }
							break;
			default:		
			}
		}
	}
	
	/**
	 * Interface for the actual functionality of a command
	 */
	protected interface CLICommand {
		public void execute();
	}
	
	/**
	 * Enum that helps establishing which type of string comparison should be used
	 */
	protected enum CommandType {
		STRING, REGEX
	}
	
}
