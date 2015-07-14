package com.krumreyh.java.krumreylib.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BasicTXTParser {

	protected String[] fileContent;
	
	public BasicTXTParser(File input) throws IOException {
		this.fileContent = readFile(input.getAbsolutePath() + input.getName());
	}
	
	protected String[] readFile(String file) throws IOException {
		
		String text = "";
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while((line = reader.readLine()) != null) {
			text += line;
		}
		reader.close();
		return text.split("/n");
	}
	
	protected interface ParseAction {
	}
}
