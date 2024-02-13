package common.visobject.com.experiment;

import java.util.Arrays;

import org.junit.Test;


public class HashTableTest {
	@Test
    public void testHashTable() {
		MyHashTable myHashTable = new MyHashTable(10);
		
		myHashTable.set("orange", 100);
		myHashTable.set("grape", 200);
		myHashTable.set("kiwi", 300);
		myHashTable.set("kiwi", 400);
		
		System.out.println("orange:" + myHashTable.get("orange"));
		System.out.println("grape:" + myHashTable.get("grape"));
		System.out.println("kiwi:" + myHashTable.get("kiwi"));
		System.out.println("undefined:" + myHashTable.get("undefined"));
		
		System.out.println("size:" + myHashTable.size());
		System.out.println("keys:" + Arrays.toString(myHashTable.getKeys()));
		System.out.println("keys:" + Arrays.toString(myHashTable.getValues()));
    }
	

}