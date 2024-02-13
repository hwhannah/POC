package common.visobject.com.experiment;

import java.util.Arrays;

class MyStackWithLinkedList {
	class Node {
		private Object value = null;
		private Node next = null;
		
		public Node(Object value) {
			this.value = value;
		}
	}
	
	private int size = 0;
	private Node top = null;
	
	public MyStackWithLinkedList() {
	}
	
	public Object peek() {
		if (top == null) {
			return null;
		} else {
			return top.value;
		}
	}
	
	//O(1)
	public void push(Object value) {
		Node newNode = new Node(value);
		newNode.next = top;
		top = newNode;

		size++;
	}

	//O(1)
	public Object pop() {
	
		if (top != null) {
			Node popped = top;
			top = top.next;
			popped.next = null;
			size--;
			return popped.value;
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
		Node node = top;
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
