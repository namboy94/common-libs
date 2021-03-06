/*
Copyright 2015-2017 Hermann Krumrey <hermann@krumreyh.com>

This file is part of krumreylib.

krumreylib is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

krumreylib is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with krumreylib.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.krumreyh.java.krumreylib.cli;

/**
 * Class that models a basic CLI
 * @author Hermann Krumrey
 * @version 1.0
 */
public class CLITemplate {
	
	protected Command[] commands = new Command[0];
	protected boolean running;
	protected boolean hasRun;
	
	/**
	 * Constructor for the class
	 */
	public CLITemplate() {
	}
	
	/**
	 * Starts the CLI
	 * @param firstCommand - overrides the first command run. Enter null if this should not be the case
	 * @throws IOException - In/Out Exception
	 */
	public void start(String firstCommand) {
		boolean overRide = false;
		if (firstCommand != null) {
			overRide = true;
		}
		this.running = true;
		while (running) {
			String userInput = "";
			this.hasRun = false;
			if (overRide) {
				userInput = firstCommand; overRide = false;
			} else {
				userInput = TerminalParser.getUserInput();
			}
			for (int i = 0; i < commands.length; i++) {
				commands[i].run(userInput);
			}
			if (!this.hasRun) {
				System.out.println("\nError, command not understood\n");
			}
		}
	}
	
	/**
	 * Adds a possible command to the CLI based on a regular expression
	 * @param regex - the regex or string that leads to this command
	 * @param command - the command to be executed
	 * @param commandType - STRING (full comparison) or REGEX (regular expression comparison)
	 * @param name - the name to be displayed by the "help"-command
	 * @param description - the description to be displayed by the "help"-command
	 */
	protected void addCommand(String regex, CLICommand command, CommandType commandType,
														String name, String description) {
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
		public void run(String userInput) {
			switch (this.commandType) {
			case STRING:	if (userInput.equals(this.regex)) {
							this.command.execute();
							CLITemplate.this.hasRun = true;
							}
							break;
			case REGEX:		if (userInput.matches(this.regex)) {
							this.command.execute();
							CLITemplate.this.hasRun = true;
							}
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
		 * public constructor
		 */
		public HelpCommand() {
		}
		
		/**
		 * The command
		 */
		public void execute() {
			Command[] commands = CLITemplate.this.commands;
			for (int i = 0; i < commands.length; i++) {
				System.out.println("\n" + commands[i].getName() + "\n" + commands[i].getDescription());
			}
		}
	}
	
	/**
	 * Class that implements a command which terminates the program
	 * @author Hermann Krumrey
	 */
	protected class QuitCommand implements CLICommand {
		
		/**
		 * public constructor
		 */
		public QuitCommand() {
		}

		/**
		 * The command
		 */
		public void execute() {
			CLITemplate.this.running = false;
		}
	}
	
	/**
	 * Enum that helps establishing which type of string comparison should be used
	 */
	protected enum CommandType {
		STRING, REGEX
	}
}