package com.krumreyh.java.krumreylib.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Method collection that helps with parsing user input from a terminal
 * @author Hermann Krumrey
 * @version 1.0
 */
public class TerminalParser {
	
	/**
	 * Empty Constructor to avoid object creation
	 */
	public TerminalParser() {
		
	}
	
	/**
	 * Gets the user's input and returns it as String. I/O Exceptions are caught and ignored
	 * @return the user's input as string
	 */
	public static String getUserInput() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String output = "";
		try {
			output =  in.readLine();
		} catch (IOException e) {
		}
		System.out.println("");
		return output;
	}
	
	/**
	 * Starts a CLI Prompt and returns the user's response as String
	 * @param promptMessage - the message to be displayed by the prompt
	 * @return the user's input as String
	 */
	public static String prompt(String promptMessage) {
		System.out.println(promptMessage);
		return getUserInput();
	}
}
