package common.visobject.com.experiment;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


public class BinarySearchTreeTest {
	@Test
    public void testBinarySearchTree() {
		MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();
		
		//add
		myBinarySearchTree.add(9);
		myBinarySearchTree.add(4);
		myBinarySearchTree.add(6);
		myBinarySearchTree.add(6);
		myBinarySearchTree.add(20);
		myBinarySearchTree.add(170);
		myBinarySearchTree.add(15);
		myBinarySearchTree.add(1);

		System.out.println("PreOrder");
		myBinarySearchTree.printPreOrder();
		System.out.println("InOrder");
		myBinarySearchTree.printInOrder();
		System.out.println("PostOrder");
		myBinarySearchTree.printPostOrder();
		
		//lookup
		boolean exist = myBinarySearchTree.lookup(20);
		System.out.println("20 exist: " + exist);
		Assert.assertTrue(exist);
		
		exist = myBinarySearchTree.lookup(25);
		System.out.println("25 exist: " + exist);
		Assert.assertFalse(exist);
		
		//height
		int h = myBinarySearchTree.getHeight();
		System.out.println("height: " + h);
		
		myBinarySearchTree.printByLevel();
		
		//delete
		System.out.println("remove 20 ");
		myBinarySearchTree.remove(20);
		myBinarySearchTree.printByLevel();
		
		System.out.println("remove 6 ");
		myBinarySearchTree.remove(6);
		myBinarySearchTree.printByLevel();
		
		System.out.println("remove 6 ");
		myBinarySearchTree.remove(6);
		myBinarySearchTree.printByLevel();
		
		System.out.println("remove 9 ");
		myBinarySearchTree.remove(9);
		myBinarySearchTree.printByLevel();
    }
	

}