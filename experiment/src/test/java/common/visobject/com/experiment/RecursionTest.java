package common.visobject.com.experiment;

import org.junit.Test;


public class RecursionTest {
	@Test
    public void testFibonacciSeriesFindIndex() {
        //0 1 1 2 3 5 8 13 ..
		int index = fibonacciSeriesFindIndex(13);	
		System.out.println("index=" + index);
		
		index = fibonacciSeriesLoopFindIndex(13);	
		System.out.println("index=" + index);
    }

	//find the index of the n in the fibonacci series
	private int fibonacciSeriesFindIndex(int n) {
		int index = 1;
		int prev = 0;
		int curr = 1;
		
		index = fibonacciRecursionFindIndex(prev, curr, index, n);
		
		return index;
	}
	
	private int fibonacciRecursionFindIndex(int prev, int curr, int index, int n) {
		if (curr >= n) {
			return index;
		}
		
		return fibonacciRecursionFindIndex(curr, prev+curr, ++index, n);
	}
	
	private int fibonacciSeriesLoopFindIndex(int n) {
		int index = 1;
		int prev = 0;
		int curr = 1;
		
		while (curr < n) {
			int tmp = prev;
			prev = curr;
			curr = tmp + curr;
			index++;
		}
		
		return index;
	}
	
	
	@Test
    public void testFibonacciSeriesFindValue() {
        //0 1 1 2 3 5 8 13 ..
		int value = fibonacciSeriesFindValue(7);	
		System.out.println("value=" + value);
		
		value = fibonacciSeriesFindValue2(7);	
		System.out.println("value2=" + value);
		
		value = fibonacciSeriesLoopFindValue(7);	
		System.out.println("value=" + value);
    }
	
	//O(2^n)
	private int fibonacciSeriesFindValue(int n) {
		if (n < 2) {
			return n;
		}
		return fibonacciSeriesFindValue(n - 1) + fibonacciSeriesFindValue(n - 2);
	}
	
	//O(n)
	private int fibonacciSeriesFindValue2(int n) {
		int i = 2;
		int prev = 1;
		int curr = 1;
		return fibonacciSeriesFindValueRecursion(prev, curr, i, n);
	}
	
	private int fibonacciSeriesFindValueRecursion(int prev, int curr, int i, int n) {
		if (i >= n) {
			return curr;
		}
		
		return fibonacciSeriesFindValueRecursion(curr, prev + curr, ++i, n);
	}
	
	//O(n)
	private int fibonacciSeriesLoopFindValue(int n) {
		int i = 2;
		int prev = 1;
		int curr = 1;
		for (i = 2; i < n; i++) {
			int tmp = curr;
			curr += prev;
			prev = tmp;
		}
		return curr;
	}
}