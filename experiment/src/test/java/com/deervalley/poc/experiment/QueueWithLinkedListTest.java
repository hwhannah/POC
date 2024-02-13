package com.deervalley.poc.experiment;

import org.junit.Test;

import com.deervalley.poc.experiment.MyQueueWithLinkedList;

import org.junit.Assert;


public class QueueWithLinkedListTest {
	@Test
    public void testQueueWithLinkedList() {
		MyQueueWithLinkedList myQueue = new MyQueueWithLinkedList();
		
		myQueue.enqueue("I");
		myQueue.enqueue("like");
		myQueue.enqueue("google");

		System.out.println("queue: " + myQueue);
		
		System.out.println("peek: " + myQueue.peek());
		Assert.assertEquals("I", (String)myQueue.peek());
		
		Object firstValue = myQueue.dequeue();
		System.out.println("dequeued: " + firstValue);
		
		myQueue.enqueue("I");
		System.out.println("queue: " + myQueue);
		
		System.out.println("queue is empty: " + myQueue.isEmpty());
		Assert.assertFalse(myQueue.isEmpty());
		
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();

		System.out.println("after 3 dequeue, queue is empty: " + myQueue.isEmpty());
		Assert.assertTrue(myQueue.isEmpty());
    }
	

}