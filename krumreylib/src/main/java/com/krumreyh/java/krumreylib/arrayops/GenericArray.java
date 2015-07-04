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
		this.last++;
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
