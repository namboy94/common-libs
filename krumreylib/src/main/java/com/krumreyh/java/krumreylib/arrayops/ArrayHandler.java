package com.krumreyh.java.krumreylib.arrayops;

/**
 * Class that handles Array operations
 * @author Hermann Krumrey
 * @version 1.0
 */
public class ArrayHandler {

	/**
	 * default Constructor
	 */
	public ArrayHandler() {
		
	}
	
	//TODO Implement a generic interface for extending arrays
	/**
	 * Extends a String array by a set amount of elements
	 * @param extender - the amount of elements to extend the array by
	 * @param array - the array to be extended
	 * @return the extended array
	 */
	public static String[] extendStringArray(int extender, String[] array) {
		String[] extendedArray = new String[array.length + extender];
		for (int i = 0; i < array.length; i++) {
			extendedArray[i] = array[i];
		}
		return extendedArray;
	}
	
	//TODO Read up on Generics
}