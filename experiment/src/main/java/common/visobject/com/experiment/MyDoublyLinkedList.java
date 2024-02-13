package common.visobject.com.experiment;

import java.util.Arrays;

class MyDoublyLinkedList {
	class Node {
		private Object value = null;
		private Node next = null;
		private Node prev = null;
		
		public Node(Object value) {
			this.value = value;
		}
	}
	
	private int size = 0;
	private Node head = null;
	private Node tail = null;
	
	public MyDoublyLinkedList() {
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
			Node leader = tail;
			leader.next = newNode;
			newNode.prev = leader;
			
			tail = newNode;
		}
		size++;
		//return newNode;
	}
	
	//O(1)
	public void preppend(Object value) {
		Node newNode = new Node(value);
		
		Node follower = head;
		newNode.next = follower;
		head = newNode;
		
		if (follower != null) {
			follower.prev = newNode;
		} else {
			//first node
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
			Node newNode = new Node(value);
			Node leaderNode = this.traverseTo(position - 1);
			Node follower = leaderNode.next;
			
			newNode.prev = leaderNode;
			newNode.next = follower;
			leaderNode.next = newNode;
			follower.prev = newNode;
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
					Node followerNode = head.next;
					followerNode.prev = null;
					head.next = null;
					head = followerNode;
				} else {
					Node leaderNode = traverseTo(position-1);
					Node follower = leaderNode.next.next;
					leaderNode.next = follower;
					if (follower != null) {
						follower.prev = leaderNode;
					} else {
						//reset tail node
						tail = leaderNode;
					}
				}
			}
			size--;
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
