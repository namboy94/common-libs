package com.krumreyh.java.krumreylib.arrayops;

/**
 * 
 * @author hermann
 *
 * @param <T1>
 */
public class GenericArray<T1> {

	private T1[] array;
	
	/**
	 * 
	 * @param array
	 */
	public GenericArray(T1[] array) {
		this.array = array;
	}
	
	/**
	 * 
	 * @param extender
	 */
	public void extendArray(int extender) {
		T1[] extendedArray = (T1[]) new Object[this.array.length + extender];
		for (int i = 0; i < this.array.length; i++) {
			extendedArray[i] = this.array[i];
		}
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
}
