package com.deervalley.poc.experiment;

import java.util.Arrays;

class MyStackWithArray {
	
	private int size = 0;
	private Object[] items = null;
	
	public MyStackWithArray() {
		items = new Object[10];
	}
	
	public Object peek() {
		if (size == 0) {
			return null;
		} else {
			return items[size-1];
		}
	}
	
	//O(1) can be O(n)
	public void push(Object value) {
		if (size == items.length) {
			//double array size
			Object[] temp = items;
			items = new Object[temp.length * 2];
			for (int i = 0; i<temp.length; i++) {
				items[i] = temp[i];
			}
		}	
		//add new item
		items[size] = value;
		size++;
		
	}

	//O(1)
	public Object pop() {
		if (size == 0) {
			return null;
		} else {
			Object popped = items[size-1];
			items[size-1] = null;
			size--;
			return popped;
		}

	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		Object[] stackValues = new Object[size];
		
		for (int i = 0; i < size; i++) {
			stackValues[i] = items[i];
		}
		
		return Arrays.toString(stackValues);
	}
	
	public int size() {
		return size;
	}
}
