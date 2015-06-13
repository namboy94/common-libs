package com.krumreyh.java.krumreylib.fileops;

import java.io.File;

/**
 * Class that handles directories in the filesystem
 * @author Hermann Krumrey
 * @version 1.0
 */
public class DirectoryHandler {

	/**
	 * Constructor
	 */
	public DirectoryHandler() {
		
	}
	
	/**
	 * Checks if a directory exists
	 * @param directory - the directory to be checked
	 * @return - true if the directory exists, false otherwise
	 */
	public static boolean checkIfDirectory(String directory) {
		File directoryFile = new File(directory);
		if (directoryFile.exists() && directoryFile.isDirectory()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Appends either a '/' (UNIX) or a '\' (Windows) to the directory path, if there is none yet.
	 * @param directory - the directory
	 * @return the directory including a seperator at the end
	 * @throws IllegalArgumentException if the given parameter is not a valid directory
	 */
	public static String addLastSeperator(String directory) throws IllegalArgumentException{
		if (!checkIfDirectory(directory)) { throw new IllegalArgumentException("Not a directory"); }
		if (directory.endsWith("/") || directory.endsWith("\\")) {
			return directory;
		} else if (directory.contains("/")) {
			return directory + "/";
		} else {
			return directory + "\\";
		}
	}
	
	/**
	 * Turns a string of a directory into a File object and returns it
	 * @param directory - the directory as String
	 * @return the directory as File
	 * @throws IllegalArgumentException - in case the string is not a directory
	 */
	public static File StringToDirectoryFile(String directory) throws IllegalArgumentException {
		directory = addLastSeperator(directory);
		return new File(directory);
	}
}