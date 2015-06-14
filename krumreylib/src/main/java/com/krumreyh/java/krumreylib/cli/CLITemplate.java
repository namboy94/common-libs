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
	
	protected Command[] commands;
	protected boolean running;
	
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
	public void start(){
		this.running = true;
		while (running) {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String userInput = "";
			boolean hasRun = false;
			try {
				userInput = in.readLine();
			} catch (IOException e) {
				System.out.println("Error parsing user input from CLI");
			}
			for (int i = 0; i < commands.length; i++) {
				commands[i].run(userInput, hasRun);
			}
			if (!hasRun) { System.out.println("\nError, command not understood\n"); }
		}
	}
	
	/**
	 * Adds a possible command to the CLI based on a regular expression
	 * @param regex - the regex or string that leads to this command
	 * @param command - the command to be executed
	 * @param commandType - STRING (full comparison) or REGEX (regular expression comparison)
	 */
	protected void addCommand(String regex, CLICommand command, CommandType commandType, String name, String description) {
		Command[] extendedArray = new Command[this.commands.length + 1];
		for (int i = 0; i < this.commands.length; i++) {
			extendedArray[i] = this.commands[i];
		}
		extendedArray[this.commands.length] = new Command(regex, command, commandType, name, description);
		this.commands = extendedArray;
	}
	
	/**
	 * Class that models a Command of the CLI
	 */
	protected class Command {
		
		private String regex;
		private CLICommand command;
		private CommandType commandType;
		private String name;
		private String description;
		
		/**
		 * Constructor
		 * @param regex - the regex or string to be used to compare with the user input
		 * @param command - the command to be used
		 * @param commandType - which type of string comparison to be used
		 * @param name - the name of the command
		 * @param description - a discription of the command's function
		 */
		public Command(String regex, CLICommand command, CommandType commandType, String name, String description) {
			this.regex = regex;
			this.command = command;
			this.commandType = commandType;
			this.name = name;
			this.description = description;
		}
		
		/**
		 * parses a user's input and executes the command if a match is found
		 * @param userInput
		 */
		public void run(String userInput, boolean hasRun) {
			switch (this.commandType) {
			case STRING:	if (userInput.equals(this.regex)) { this.command.execute(); }
							hasRun = true;
							break;
			case REGEX:		if (userInput.matches(this.regex)) { this.command.execute(); }
							hasRun = true;
							break;
			default:		
			}
		}
		
		/**
		 * Getter-Method that delivers the name of the command
		 * @return the name of the command
		 */
		public String getName() {
			return this.name;
		}
		
		/**
		 * Getter-Method that delivers a description of the command
		 * @return a description of the command
		 */
		public String getDescription() {
			return this.description;
		}
	}
	
	/**
	 * Interface for the actual functionality of a command
	 */
	protected interface CLICommand {
		public void execute();
	}
	
	/**
	 * Class that implements a help command that prints all commands with a short description
	 * of its function to the console.
	 * @author Hermann Krumrey
	 */
	protected class HelpCommand implements CLICommand {
		/**
		 * The command
		 */
		public void execute() {
			Command[] commands = CLITemplate.this.commands;
			for (int i = 0; i < commands.length; i++) {
				System.out.println("\n" + commands[i].getName() + "\n" + commands[i].getDescription() + "\n");
			}
		}
	}
	
	/**
	 * Enum that helps establishing which type of string comparison should be used
	 */
	protected enum CommandType {
		STRING, REGEX
	}
}