package com.deervalley.poc.experiment;

class MyArray {
	private int length = 0;
	private Object[] items = null;
	
	public MyArray(int length) {
		if (length > 0) {
			this.length = 0;
			this.items = new Object[length];
		} else {
			throw new IllegalArgumentException("Array length has to be positive integer");
		}
	}
	
	public MyArray(Object[] items) {
		if (items != null && items.length > 0) {
			this.length = items.length;
			this.items = items;
		} else {
			throw new IllegalArgumentException("Array items has tp contain atleast one item");
		}
	}
	
	//O(1)
	public int length() {
		return length;
	}
	
	//O(1)
	public Object get(int index) {
		return items[index];
	}
	
	//O(n)
	public void add(int index, Object obj) {
		//in case the items array are full, redefine a bigger array
		if (length == this.items.length) {
			Object[] newItems = new Object[length + 1];
			for (int i = 0; i < index; i++) {
				newItems[i] = this.items[i];
				this.items[i] = null;
			}
			newItems[index] = obj;
			for (int i = index; i < length; i++) {
				newItems[i + 1] = this.items[i];
				this.items[i] = null;
			}
			
			this.length++;
			this.items = newItems;
		} else {
			for (int i = length - 1; i > index - 1; i--) {
				this.items[i+1] = this.items[i];
			}
			this.length++;
			this.items[index] = obj;
		}
	}
	
	//O(1)
	public void push(Object obj) {
		add(length, obj);
	}
	
	//O(1)
	public Object pop() {
		Object item = items[length -1];
		items[length -1] = null;
		length--;
		return item;
	}
	
	//O(n)
	public Object delete(int index) {
		Object item = items[index];
		for (int i = index; i < length - 1; i++) {
			this.items[i] = this.items[i+1];
		}
		this.items[length-1] = null;
		this.length--;
		return item;
	}
	
	//O(n)
	public void reverse() {
		for (int i = 0 ; i< length/2; i++) {
			Object item = items[i];
			items[i] = items[length -1 - i];
			items[length -1 - i] = item;
		}
	}
	
	//O(n)
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < length; i++) {
			sb.append(this.items[i]);
		}
		return sb.toString();
	}
	
	public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
		if (arr1.length == 0) {
			return arr2;
		}
		if (arr2.length == 0) {
			return arr1;
		}
		
		int[] merged = new int[arr1.length + arr2.length];
		int j1 = 0;
		int j2 = 0;
		for (int i = 0; i < arr1.length + arr2.length; i++) {
			if (j1 == arr1.length && j2 < arr2.length) {
				merged[i] = arr2[j2];
				j2++;
			} else if (j1 < arr1.length && j2 == arr2.length) {
				merged[i] = arr1[j1];
				j1++;
			} else {
				if (arr1[j1] <= arr2[j2]) {
					merged[i] = arr1[j1];
					j1++;
				} else {
					merged[i] = arr2[j2];
					j2++;
				}
			}
		}
		return merged;
	}
	

	 
}
