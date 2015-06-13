package com.krumreyh.java.krumreylib.fileops;

import java.io.File;

/**
 * Class that handles file operations
 * @author Hermann Krumrey
 * @version 1.0
 */
public class FileHandler {
	
	/**
	 * Constructor
	 */
	public FileHandler() {
		
	}
	
	/**
	 * Checks if a file is a file in the filesystem
	 * @param fileName - the file to be checked as string
	 * @return true if the file is a file, false otherwise
	 */
	protected boolean checkIfFile(String fileName) {
		File file = new File(fileName);
		if (file.exists() && file.isFile()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the extension of a file as string
	 * @param file - the file as a string
	 * @return the file extension
	 */
	protected String getExtension(String file) {
		return file.substring(file.lastIndexOf(".") + 1);
	}
	
	/**
	 * Overloads getExtension(String), using a File instead of a String
	 * @param file - the file to be checked
	 * @return the file extension
	 */
	protected String getExtension(File file) {
		return getExtension(file.getName());
	}
	
}
