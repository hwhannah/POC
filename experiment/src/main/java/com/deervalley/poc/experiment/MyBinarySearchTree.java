package com.deervalley.poc.experiment;

import java.util.Arrays;

class MyBinarySearchTree {
	class Node {
		private Integer value = null;
		private Node left = null;
		private Node right = null;
		private int count = 1;
		
		public Node(Integer value) {
			this.value = value;
		}
	}
	
	private int size = 0;
	private Node root = null;
	
	public MyBinarySearchTree() {
	}
	
	public Node getRoot() {
		return root;
	}
	
	//O(logN)
	public void add(Integer value) {
		Node newNode = new Node(value);
		
		add(newNode);
		//return newNode;
	}
	
	//O(logN)
	public void add(Node newNode) {
		
		if (root == null) {
			root = newNode;
		} else {
			Node node = root;
			while(true) {
				if (node == null) {
					node = newNode;
				} else if(newNode.value < node.value) {
					if (node.left == null) {
						node.left = newNode;
						break;
					}
					node = node.left;
				} else if (newNode.value > node.value) {
					if (node.right == null) {
						node.right = newNode;
						break;
					}
					node = node.right;
				} else if (newNode.value == node.value) {
					node.count++;
					break;
				}
			}
		}
		size++;
		
	}
	
	//O(logN)
	public void remove(Integer value) {
		
		if (root == null) {
			return;
		} 
		
		if (value == root.value) {
			Node left = root.left;
			Node right = root.right;
			root.left = null;
			root.right = null;
			
			size--;
			root = right;
			
			add(left);
		} else {
			removeNode (root, value);
		}
	}
	
	private void removeNode(Node node, Integer value) {
		if (node == null) {
			return;
		}

		if (node.left != null && value == node.left.value) {
			//remove node.left
			deleteNode(node, node.left, "left");
			return;
		} else if (node.right != null && value == node.right.value) {
			//remove node.right
			deleteNode(node, node.right, "right");
			return;
		}
		
		if (value < node.value) {
			removeNode(node.left, value);
		} else if (value > node.value) {
			removeNode(node.right, value);
		}
	}
	
	private void deleteNode(Node parent, Node node, String side) {

		node.count--;
		if (node.count == 0) {
			//remove
			Node left = node.left;
			Node right = node.right;
			node.left = null;
			node.right = null; 					
			node = null;
			if (side.equals("left")) {
				if (right != null) {
					parent.left = right;
					if (left != null) {
						parent.left.left = left;
					}
				} else if (left != null) {
					parent.left = left;
				} else {
					parent.left = null;
				}

			} else {
				if (right != null) {
					parent.right = right;
					if (left != null) {
						parent.right.left = left;
					}
				} else if (left != null) {
					parent.right = left;
				} else {
					parent.right = null;
				}
			}

			size--;
		}
	}

	//find the node that has the value or should be parent of this value
	private Node traverse(Node node, Integer value) {

		if (value < node.value && node.left != null) {
			node = traverse(node.left, value);
		} else if (value > node.value && node.right != null) {
			node = traverse(node.right, value);
		}
		
		return node;
	}
	
	//O(logN)
	public boolean lookup(Integer value) {
		Node node = root;
		if(node == null) {
			return false;
		}
		
		while (node != null) {
			if (value < node.value) {
				node = node.left;
			} else if (value > node.value) {
				node = node.right;
			} else if (value == node.value ) {
				return true;
			}
		}

		return false;
	}
	
	//depth-first algorithms - preOrder
	private void printNLR(Node node) {
		if (node == null) {
			return;
		}
		for (int i = 0; i < node.count; i++) {
			System.out.println("" + node.value);
		}
		printNLR(node.left);
		printNLR(node.right);
	}
	
	//depth-first algorithms - inOrder
	private void printLNR(Node node) {
		if (node == null) {
			return;
		}
		printLNR(node.left);
		for (int i = 0; i < node.count; i++) {
			System.out.println("" + node.value);
		}
		printLNR(node.right);
	}
	
	//depth-first algorithms - postOrder
	private void printRNL(Node node) {
		if (node == null) {
			return;
		}
		printRNL(node.right);
		for (int i = 0; i < node.count; i++) {
			System.out.println("" + node.value);
		}
		printRNL(node.left);
	}
	
	//breadth-first algorithm - level order traversal
	public void printByLevel() {
		int height = getHeight();
		for (int i = 0; i < height; i++) {
			printLevel(root, i+1, i);
		}
	}
	private void printLevel(Node node, int level, int idx) {
		if (node == null) {
			return;
		} else {
			if (idx == 0) {
				System.out.println("level " + level + ":" + node.value);
			} else if (idx > 0) {
				printLevel(node.left, level, idx - 1 );
				printLevel(node.right, level, idx - 1 );
			}
		}
	}
	
	//tree height
	public int getHeight() {
		return height(root);
	}
	
	private int height(Node node) {
		if (node == null) {
			return 0;
		} else {
			int lHeight = height(node.left);
			int rHeight = height(node.right);
			if (lHeight > rHeight) {
				return lHeight + 1;
			} else {
				return rHeight + 1;
			}
		}
	}
	
		
	public void printPreOrder() {
		printNLR(root);
	}
	public void printInOrder() {
		printLNR(root);
	}
	public void printPostOrder() {
		printRNL(root);
	}
	
	public int size() {
		return size;
	}
}
