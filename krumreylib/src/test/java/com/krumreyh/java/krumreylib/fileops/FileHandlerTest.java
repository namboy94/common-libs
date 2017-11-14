/*
Copyright 2015-2017 Hermann Krumrey

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

package com.krumreyh.java.krumreylib.fileops;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class that tests FileHandler.java
 * @author Hermann Krumrey
 * @version 1.0
 */
public class FileHandlerTest {

	private File testFile;
	
	/**
	 * Set-up method
	 * Saves a test file as local variable
	 * @throws Exception - General Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.testFile = new File("src/test/resources/testFile.txt");
	}
	
	/**
	 * Tear-Down Method
	 * @throws Exception - General Exception
	 */
	@After
	public void tearDown() throws Exception {
		
	}
	
	/**
	 * Tests the rename functionality of the FileHandler class
	 */
	@Test
	public void testRename() {
		FileHandler.renameFile(this.testFile, "testFileRenamed");
		File newFile = new File("src/test/resources/testFileRenamed.txt");
		if (!FileHandler.checkIfFile(newFile)) {
			fail();
		}
		FileHandler.renameFile(newFile, "testFile");
		assertEquals(this.testFile.getName(), "testFile.txt");
	}
	
}
