package com.deervalley.poc.experiment;

import java.util.Arrays;

import org.junit.Test;

import com.deervalley.poc.experiment.MyLinkedList;


public class LinkedListTest {
	@Test
    public void testLinkedList() {
		MyLinkedList myLinkedList = new MyLinkedList();
		
		myLinkedList.append("orange");
		myLinkedList.preppend("grapes");
		myLinkedList.preppend("kiwi");
		myLinkedList.append("orange2");
		myLinkedList.insert(2, "orange1");

		System.out.println("list:" + myLinkedList);
		
		myLinkedList.insert(0, "kiwi1");
		System.out.println("add at begining, list:" + myLinkedList);
		
		myLinkedList.insert(myLinkedList.size(), "orange3");
		System.out.println("add at end, list:" + myLinkedList);
		
		myLinkedList.delete(0);
		System.out.println("delete head, list:" + myLinkedList);
		
		myLinkedList.delete(2);
		System.out.println("delete pos 2, list:" + myLinkedList);
		
		myLinkedList.delete(myLinkedList.size() - 1);
		System.out.println("delete tail, list:" + myLinkedList);

		myLinkedList.reverse();
		System.out.println("reversed: " + myLinkedList);
    }
	

}