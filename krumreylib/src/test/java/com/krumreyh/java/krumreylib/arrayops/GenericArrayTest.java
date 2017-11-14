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

package com.krumreyh.java.krumreylib.arrayops;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author hermann
 *
 */
public class GenericArrayTest {
	
	private class TestObject {
		private String identifier;
		public TestObject(String identifier) {
			this.identifier = identifier;
		}
		public String getIdentifier() {
			return this.identifier;
		}
	}
	
	private GenericArray<String> stringArray;
	private GenericArray<TestObject> objectArray;
	
	@Before
	public void setUp() {
		this.stringArray = new GenericArray<String>();
		this.objectArray = new GenericArray<TestObject>();
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void testStringArray() {
		try {
			this.stringArray.getElement(0);
			fail();
		} catch (ArrayIndexOutOfBoundsException e) {	
		}
		this.stringArray.extend(1);
		this.stringArray.setElement(0, "TestString");
		this.stringArray.setElement(9, "ExtenderTest");
		assertEquals(this.stringArray.getElement(0), "TestString");
		assertEquals(this.stringArray.getElement(1), null);
		assertEquals(this.stringArray.getElement(9), "ExtenderTest");
		if (!(this.stringArray.length() == 10)) {
			fail();
		}
	}
	
	@Test
	public void testObjectArray() {
		try {
			this.objectArray.getElement(0);
			fail();
		} catch (ArrayIndexOutOfBoundsException e) {	
		}
		this.objectArray.extend(1);
		this.objectArray.setElement(0, new TestObject("TestString"));
		this.objectArray.setElement(9, new TestObject("ExtenderTest"));
		assertEquals(this.objectArray.getElement(0).getIdentifier(), "TestString");
		assertEquals(this.objectArray.getElement(1), null);
		assertEquals(this.objectArray.getElement(9).getIdentifier(), "ExtenderTest");
		if (!(this.objectArray.length() == 10)) {
			fail();
		}
	}

}
