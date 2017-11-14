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

package com.krumreyh.java.krumreylib.arrayops;

/**
 * 
 * @author hermann
 *
 * @param <T1>
 */
public class GenericArray<T1> {

	private T1[] array;
	private int last;
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public GenericArray() {
		this.array = (T1[])new Object[0];
		this.last = -1;
	}
	
	/**
	 * 
	 * @param array
	 */
	public GenericArray(T1[] array) {
		this.array = array;
		this.last = array.length - 1;
	}
	
	/**
	 * 
	 * @param extender
	 */
	public void extend(int extender) {
		@SuppressWarnings("unchecked")
		T1[] extendedArray = (T1[]) new Object[this.array.length + extender];
		for (int i = 0; i < this.array.length; i++) {
			extendedArray[i] = this.array[i];
		}
		this.last += extender;
		this.array = extendedArray;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public T1 getElement(int index) {
		return this.array[index];
	}
	
	public void setElement(int index, T1 newElement) {
		if (index > last) {
			this.extend(index - last);
		}
		this.array[index] = newElement;
	}
	
	/**
	 * 
	 * @param newElement
	 */
	public void pushBack(T1 newElement) {
		if (this.last == this.array.length - 1) {
			extend(1);
		}
		this.array[this.last] = newElement;
	}
	
	/**
	 * 
	 * @return
	 */
	public int length() {
		return this.last + 1;
	}
}
