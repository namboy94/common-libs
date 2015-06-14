package com.krumreyh.java.krumreylib.arrayops;

public class ArrayHandler {

	public ArrayHandler() {
		
	}
	
	//TODO Implement a generic interface for extending arrays
	public static String[] extendStringArray(int extender, String[] array) {
		String[] extendedArray = new String[array.length + extender];
		for (int i = 0; i < array.length; i++) {
			extendedArray[i] = array[i];
		}
		return extendedArray;
	}
}