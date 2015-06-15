package com.krumreyh.java.krumreylib.fileops;

import java.io.File;
import java.util.Arrays;

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
	 * @param fileName - the file to be checked
	 * @return true if the file is a file, false otherwise
	 */
	public static boolean checkIfFile(File file) {
		if (file.exists() && file.isFile()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Overloads the checkIfFile method to check a string instead of a File object
	 * @param file - the file as string
	 * @return true, if the file exists an is a file, false otherwise
	 */
	public static boolean checkIfFile(String file) {
		return checkIfFile(new File(file));
	}
	
	/**
	 * Checks if a file is a directory
	 * @param directory - the directory to be checked
	 * @return true if the directory exists and is a directory, false otherwise
	 */
	public static boolean checkIfDirectory(File directory) {
		if (directory.exists() && directory.isDirectory()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Overloads checkIfDirectory to check a directory given as a String
	 * @param directory - the directory to be checked
	 * @return true if the directory exists and is a directory, false otherwise
	 */
	public static boolean checkIfDirectory(String directory) {
		return checkIfDirectory(new File(directory));
	}
	
	/**
	 * Returns the extension of a file as string
	 * @param file - the file as a string
	 * @return the file extension
	 */
	public static String getExtension(String file) {
		return file.substring(file.lastIndexOf(".") + 1);
	}
	
	/**
	 * Overloads getExtension(String), using a File instead of a String
	 * @param file - the file to be checked
	 * @return the file extension
	 */
	public static String getExtension(File file) {
		return getExtension(file.getName());
	}
	
	/**
	 * Checks a String for illegal (at least under Windows) characters, removes them, and returns
	 * the result. The original file name is not modified.
	 * @param fileName - the file to be checked for illegal characters
	 * @return the sanitized file name
	 */
	public static String sanitizeFileName(String fileName) {
		String newFileName = fileName;
		char[] illegalCharacters =  {'<', '>', ':', '\"', '/', '\\', '|', '?', '*'};
		for (int i = 0; i < illegalCharacters.length; i++) {
			if (fileName.indexOf(illegalCharacters[i]) != -1) {
				 newFileName = newFileName.replace("" + illegalCharacters[i], "");
			}
		}
		return newFileName;
	}
	
	/**
	 * Establishes if either a Windows-like filesystem is used (with \ as seperator)
	 * or a UNIX-based filesystem (with / as seperator) and returns a seperator as string.
	 * @param fileName - the filename to be checked
	 * @return the seperator used on this system
	 */
	public static String getDivider(String fileName) {
		if (fileName.contains("/")) {
			return "/";
		} else {
			return "\\";
		}
	}
	
	/**
	 * Method that renames a file.
	 * @param file - the file to be renamed
	 * @param newName - the new file name, without an extension
	 */
	public static void renameFile(File file, String newName) {
		String sanitizedNewName = sanitizeFileName(newName);
		String extension = getExtension(file.getName());
		String path = file.getParentFile().getAbsolutePath();
		path += getDivider(path);
		file.renameTo(new File(path + sanitizedNewName + "." + extension));
	}

	/**
	 * Returns an alphabetically sorted Array of Files that are contained in the
	 * given directory 
	 * @param directory - the directory which's content should be turned into a File array
	 * @return the sorted array of Files
	 */
	public static File[] getDirectoryContent(File directory) {
		File[] listOfFiles = directory.listFiles();
		Arrays.sort(listOfFiles);
		return listOfFiles;
	}
	
	/**
	 * Overloads getDirectoryContent(File) to be useable with a String as well.
	 * @param directory - the directory which's content should be turned into a File array
	 * @return the directory's content as File array
	 */
	public static File[] getDirectoryContent(String directory) {
		return getDirectoryContent(new File(directory));
	}
	
	/**
	 * Retrieves the pure file name of a file without its extension
	 * @param file - the file to be used
	 * @return the pure file name as string
	 */
	public static String getPureFileName(File file) {
		String fileName = file.getName();
		String fileExtension = getExtension(file);
		String[] extensionSplit = fileName.split("." + fileExtension);
		String pureName = "";
		
		if (extensionSplit.length == 1) {
			pureName = extensionSplit[0];
		} else {
			for (int i = 0; i < extensionSplit.length - 1; i++) {
				pureName += extensionSplit[i];
			}
		}
		return pureName;
	}
	
	/**
	 * Overloads getPureFileName(File) to be compatible with strings
	 * @param file - the file to be checked as string
	 * @return the pure file name without extension or file path
	 */
	public static String getPureFileName(String file) {
		return getPureFileName(new File(file));
	}
}
