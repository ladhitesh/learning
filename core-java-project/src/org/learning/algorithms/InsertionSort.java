package org.learning.algorithms;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] unsorted = { 2, 1, 4, 3 };
		// comparison sort algorithm

		// inplace, comparison sort
		int[] sorted = new InsertionSort().sort(unsorted);
		System.out.println(Arrays.toString(sorted));
	}

	private int[] sort(int[] unsorted) {
		
		//iteration can be replaced by recursion
		//recursion slower than iteration
		//recursion code cleaner than iteration code
		//tree data structures are easier to eplore using recursion than iteration
		//tail call optimization is used for making recursion faster
		//A recursive function is tail recursive when recursive call is the last thing executed by the function. 
		//since the recursive call is the last statement, there is nothing left to do in the current function, 
		//so saving the current function’s stack frame is of no use 
		
		//iterate each element and insert into sorted array starting from left
		for (int i = 1; i < unsorted.length; i++) {
			for (int j = i; j > 0; j--) {
				//keep shifting with adjacent element until previous element is less 
				if(unsorted[j]<unsorted[j-1]){
					swap(unsorted,j,j-1);
				}
				else{
					//found correct position. no need to reverse iterate further into sorted array
					break;
				}
			}
		}
		
		
		int[] sorted = unsorted;
		return sorted;
	}
	
	public void swap(int[] input, int first, int second){
		int temp = input[second];
		input[second] = input[first];
		input[first] = temp;
	}
}
