package com.deervalley.poc.experiment;

import java.util.Arrays;

class MyLinkedList {
	class Node {
		private Object value = null;
		private Node next = null;
		
		public Node(Object value) {
			this.value = value;
		}
	}
	
	private int size = 0;
	private Node head = null;
	private Node tail = null;
	
	public MyLinkedList() {
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	//O(1)
	public void append(Object value) {
		Node newNode = new Node(value);
		
		if (size == 0) {
			head = newNode;
			tail = head;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		//return newNode;
	}
	
	//O(1)
	public void preppend(Object value) {
		Node newNode = new Node(value);
		
		newNode.next = head;
		head = newNode;
		if (size == 0) {
			tail = head;
		}
		size++;
		//return newNode;
	}
	
	//O(n)
	public void insert(int position, Object value) {
		if (position <= 0) {
			preppend(value);
			return;
		} else if (position >= size) {
			append(value);
			return;
		} else {
			Node leaderNode = this.traverseTo(position - 1);
			Node newNode = new Node(value);
			newNode.next = leaderNode.next;
			leaderNode.next = newNode;
			size++;
		}
	}
	
	
	public Node traverseTo(int position) {	
		int pos = 0;
		Node node = head;
		while (pos < position) {
			node = node.next;
			pos++;
		}
		
		return node;
	}
	
	public void delete(int position) {
			
		if (size > 0) {
			if (size == 1) {
				//remove head & tail
				head = tail = null;
			} else {
				if (position <= 0 ) {
					//remove head
					Node nd = head.next;
					head.next = null;
					head = nd;
				} else {
					Node leaderNode = traverseTo(position-1);
					leaderNode.next = leaderNode.next.next;
					//reset tail node
					if (position == size -1) {
						tail = leaderNode;
					}
				}
			}
			size--;
		}
		
	}

	public void reverse() {
		if (size > 1 ) {
			Node first = head;
			tail = head;
			
			Node second = head.next;
			while (second != null) {
				Node temp = second.next;
				second.next = first;
				
				first = second;
				second = temp;	
			}
			head = first;
			tail.next = null;
		}
		
	}
	
	public String toString() {
		Object[] list = new Object[size];
		
		int pos = 0;
		Node node = head;
		while (node != null) {
			list[pos] = node.value;
			node = node.next;
			pos++;		
		}
		
		return "size: " + size + ", " + Arrays.toString(list);
	}
	
	public int size() {
		return size;
	}
}
