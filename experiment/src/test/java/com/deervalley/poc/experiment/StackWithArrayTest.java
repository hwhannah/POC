package com.deervalley.poc.experiment;

import org.junit.Test;

import com.deervalley.poc.experiment.MyStackWithArray;

import org.junit.Assert;


public class StackWithArrayTest {
	@Test
    public void testStackWithArray() {
		MyStackWithArray myStack = new MyStackWithArray();
		
		myStack.push("I");
		myStack.push("like");
		myStack.push("google");

		System.out.println("stack: " + myStack);
		
		System.out.println("peek: " + myStack.peek());
		Assert.assertEquals("google", (String)myStack.peek());
		
		Object topValue = myStack.pop();
		System.out.println("popped: " + topValue);
		
		myStack.push("GOOGLE");
		System.out.println("stack: " + myStack);
		
		System.out.println("stack is empty: " + myStack.isEmpty());
		Assert.assertFalse(myStack.isEmpty());
		
		myStack.pop();
		myStack.pop();
		myStack.pop();

		System.out.println("after 3 pops, stack is empty: " + myStack.isEmpty());
		Assert.assertTrue(myStack.isEmpty());
    }
	

}