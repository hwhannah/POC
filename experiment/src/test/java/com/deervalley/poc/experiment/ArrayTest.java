package com.deervalley.poc.experiment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

import com.deervalley.poc.experiment.MyArray;


public class ArrayTest {
	@Test
    public void testArray() {
        //define and init an static array
		char [] charArr1 = new char[]{'a', 'b', 'c', 'd'};
        
		//define an static array of size 20
		char [] charArr2 = new char[20];
		System.out.println("charArr2.length=" + charArr2.length);
		
		//dyanamic array - ArrayList
		ArrayList<Character> arrList = new ArrayList<>();
		
		arrList.add('a');
		arrList.add('b');
		
		int i = 0;
		for (Character ele : arrList) {
			ele = Character.toUpperCase(ele);
			arrList.set(i, ele);
			System.out.println(ele);
			i++;
		}	 
		
		System.out.println(arrList);
    }
	
	@Test
    public void testMyArray() {
		
        MyArray arrC = new MyArray(4);
        arrC.push("I ");
        arrC.push("am ");
        arrC.push("happy ");
        arrC.push("!");
		System.out.println(arrC);
		
		arrC.pop();
		System.out.println(arrC);
		
		arrC.push("@");
		System.out.println(arrC);
		arrC.push("#");
		System.out.println(arrC);

		arrC.delete(1);
		System.out.println(arrC);
		
		arrC.add(1, "am ");
		System.out.println(arrC);
		
		arrC.reverse();
		System.out.println(arrC);
		
		int[] merged = MyArray.mergeSortedArrays(new int[]{1,3,4,6,8}, new int[]{2,5,6});
		
		System.out.println(Arrays.toString(merged));

    }
	
	@Test
    public void testTwoSum() {
		/*
		 * int[] nums = new int[] {3,2,4}; int target = 6;
		 */
		int[] nums = new int[] {2,7,11,15};
		int target = 9;
        HashMap<Integer, Integer> candidateMap = new HashMap<Integer, Integer>();

        int[] indexes = null;
        for (int i = 0; i < nums.length; i++) {
            if (!candidateMap.containsKey(nums[i])) {
                candidateMap.put(target-nums[i], i);
            } else {
            	indexes = new int[]{candidateMap.get(nums[i]), i};
            }
        }

        System.out.println("Result " + Arrays.toString(indexes));
    }
	
	@Test 
	public void testMaxSubArraySum() {

        int [] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
		//int [] nums = {-2, -3, -1, -1, -2, -3};
    
        int max = Integer.MIN_VALUE;
        int addsup = 0;
        for (int i = 0; i < nums.length; i++) {
            addsup += nums[i];
            if (max < addsup) {
                max = addsup;
            }
            if (addsup < 0) {
                addsup = 0;
            }
        }

        System.out.println("Maximum contiguous sum is " +
        		max);
	}

	@Test
	public void testMoveZeros() {
		int [] nums = {0, 1, 0, 3, 12};
		//int [] nums = {0};
		//int [] nums = {1, 1, 0, 3, 12};
		
        int toBeMoved = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (toBeMoved == -1) toBeMoved = i;
            } else {
                if (toBeMoved >= 0) {
                    nums[toBeMoved] = nums[i];
                    nums[i] = 0;
                    toBeMoved++;
                }
            }
        }
	}
	
	@Test
	public void testContainsDuplicate() {
		boolean hasDuplicate = false;
		
		int [] nums = {0, 1, 3, 12};
		
        HashSet<Integer> existSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            
        	if (existSet.contains(nums[i])) {
        		hasDuplicate = true;
        		break;
            } else {
            	existSet.add(nums[i]);
            }
        }
        
        System.out.println("Has diplicate: " + hasDuplicate);
	}
}