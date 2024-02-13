package com.deervalley.poc.experiment;

import java.util.Arrays;

class MyQueueWithLinkedList {
	class Node {
		private Object value = null;
		private Node next = null;
		public Node(Object value) {
			this.value = value;
		}
	}
	
	private int size = 0;
	private Node first = null;
	private Node last = null;
	
	public MyQueueWithLinkedList() {
	}
	
	public Object peek() {
		if (first == null) {
			return null;
		} else {
			return first.value;
		}
	}
	
	//O(1) add after last
	public void enqueue(Object value) {
		Node newNode = new Node(value);

		if (last != null) {
			//for non empty queue
			last.next = newNode;
		} else {
			//for empty queue
			first = newNode;
		}
		
		last = newNode;
		
		size++;
	}

	//O(1) remove the first
	public Object dequeue() {
	
		if (first != null) {
			Node node = first;
			first = node.next;

			node.next = null;
			if (size == 1) {
				last = first;
			}
			
			size--;
			return node.value;
		} else {
			return null;
		}

	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		Object[] list = new Object[size];
		
		int pos = 0;
		Node node = first;
		while (node != null) {
			list[pos] = node.value;
			node = node.next;
			pos++;		
		}
		
		return Arrays.toString(list);
	}
	
	public int size() {
		return size;
	}
}
