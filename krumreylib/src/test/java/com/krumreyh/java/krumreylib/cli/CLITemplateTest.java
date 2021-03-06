/*
Copyright 2015-2017 Hermann Krumrey <hermann@krumreyh.com>

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

package com.krumreyh.java.krumreylib.cli;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit class that tests the CLITemplate class
 * @author Hermann Krumrey
 * @version 1.0
 */
public class CLITemplateTest {

	private TestCLI tester;
	
	/**
	 * Sets up JUnit tests (Creates a new TestCLI object)
	 */
	@Before
	public void setUp() {
		this.tester = new TestCLI();
	}
	
	/**
	 * Cleans up JUnit tests
	 */
	@After
	public void tearDown() {
		
	}
	
	/**
	 * Tests a basic command
	 */
	@Test
	public void basicCommandTest() {
		this.tester.start("test");
	}
	
	/**
	 * Child Class to test the CLITemplate class
	 */
	private class TestCLI extends CLITemplate {
		
		/**
		 * Constructor that adds all commands to the CLI and starts it afterwards
		 */
		public TestCLI() {
			System.out.println("Please enter 'test'");
			this.addCommand("test", new TestCommand(), CommandType.STRING, "Test", "Test command for Junit");
		}
		
		/**
		 * Class that implements a command to test the CLI via JUnit test
		 * @author Hermann Krumrey
		 */
		private class TestCommand implements CLICommand {
			/**
			 * The command (Program terminates afterwards)
			 */
			public void execute() {
				TestCLI.this.running = false;
			}
		}
	}
}
