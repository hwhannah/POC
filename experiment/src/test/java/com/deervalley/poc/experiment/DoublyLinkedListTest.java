package com.deervalley.poc.experiment;

import java.util.Arrays;

import org.junit.Test;

import com.deervalley.poc.experiment.MyDoublyLinkedList;


public class DoublyLinkedListTest {
	@Test
    public void testDoublyLinkedList() {
		MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList();
		
		myDoublyLinkedList.append("orange");
		myDoublyLinkedList.preppend("grapes");
		myDoublyLinkedList.preppend("kiwi");
		myDoublyLinkedList.append("orange2");
		myDoublyLinkedList.insert(2, "orange1");

		System.out.println("list:" + myDoublyLinkedList);
		
		myDoublyLinkedList.insert(0, "kiwi1");
		System.out.println("add at begining, list:" + myDoublyLinkedList);
		
		myDoublyLinkedList.insert(myDoublyLinkedList.size(), "orange3");
		System.out.println("add at end, list:" + myDoublyLinkedList);
		
		myDoublyLinkedList.delete(0);
		System.out.println("delete head, list:" + myDoublyLinkedList);
		
		myDoublyLinkedList.delete(2);
		System.out.println("delete pos 2, list:" + myDoublyLinkedList);
		
		myDoublyLinkedList.delete(myDoublyLinkedList.size() - 1);
		System.out.println("delete tail, list:" + myDoublyLinkedList);

    }
	

}