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
