package com.krumreyh.java.krumreylib.arrayops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * JUnit test class for the ArrayHandler Class
 * @author Hermann Krumrey
 *
 */
public class ArrayHandlerTest {

	private String[] stringArray;
	private int[] intArray;
	
	@Before
	public void setUp() {
		this.stringArray = new String[] {"1", "2", "3"};
		this.intArray = new int[] {1, 2, 3};
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void test() {
	}
	
}
