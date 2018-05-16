package org.learning.algorithms;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		int[] unsorted = {2,1,4,3};
		//comparison sort algorithm
		//n square time, in place, not stable
		int[] sorted = new BubbleSort().sort(unsorted);
		System.out.println(Arrays.toString(sorted));
	}

	private int[] sort(int[] unsorted) {
		
		//compare n-1 times each pair, starting from 1st element and collecting max element to last
		for (int i = 0; i < unsorted.length - 1; i++) {
			
			//keep comparing but each time less the number of time already compared
			for (int j = 0; j < unsorted.length - 1 - i; j++) {
				//comparison determines ascending/descending sort
				if(unsorted[j] > unsorted[j+1]){
					int temp = unsorted[j+1];
					unsorted[j+1] = unsorted[j];
					unsorted[j] = temp;
				}
			}
			
		}
		int[] sorted = unsorted;
		return sorted;
		
	}

}
