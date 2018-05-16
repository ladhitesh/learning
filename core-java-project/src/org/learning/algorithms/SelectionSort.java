package org.learning.algorithms;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {

		int[] unsorted = { 2, 1, 4, 3 };
		// comparison sort algorithm
		// divide array into two parts - sorted and unsorted
		// find minimum from unsorted part and start moving it to sorted part by
		// swapping
		// iterate each element from left and compare with remaining elements to
		// find minimum
		// inplace, comparison sort
		int[] sorted = new SelectionSort().sort(unsorted);
		System.out.println(Arrays.toString(sorted));

	}

	private int[] sort(int[] unsorted) {

		//iterate each element to find minimum
		for (int i = 0; i < unsorted.length -1 ; i++) {
			int minimumIndex = i;
			
			//iterate from current position and compare it with other positions
			for (int j = i+1; j < unsorted.length ; j++) {
				//if new element is less than current minimum, then current minimum is the new element
				if (unsorted[j] < unsorted[minimumIndex]) {
					minimumIndex = j;
				}
			}
			swap(unsorted,i,minimumIndex);

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
