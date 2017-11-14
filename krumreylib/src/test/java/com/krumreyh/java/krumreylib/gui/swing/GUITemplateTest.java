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

package com.krumreyh.java.krumreylib.gui.swing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit Class that test GUITemplate.java
 * @author Hermann Krumrey
 * @version 0.1
 */
public class GUITemplateTest {

	/**
	 * Simple child class of GUITemplate to test the class
	 */
	private class TestGUI extends GUITemplate {
		
		/**
		 * Constructor
		 */
		public TestGUI() {
			setGUISettings("TestGui", 0, 0, 300, 300, null, EXIT_ON_CLOSE, false);
			addLabel("testlabel", 5, 5, 50, 50);
			addTextField("testField", 5, 60, 50, 50);
			this.setVisible(true);
		}
	}
	
	/**
	 * Set-up method that currently does nothing
	 * @throws Exception - general Exception
	 */
	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * Tear-Down method that currently does nothing
	 * @throws Exception - general Exception
	 */
	@After
	public void tearDown() throws Exception {
		
	}
	
	/**
	 * Starts a new testGUI
	 */
	@Test
	public void basicGUITest() {
		new TestGUI();
	}
}
