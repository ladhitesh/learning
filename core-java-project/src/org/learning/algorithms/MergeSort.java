package org.learning.algorithms;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		int[] unsorted = { 5, 2, 10, 4, 3, 0, 9};
		// merge two sorted arrays
		int[] sorted = new MergeSort().sort(unsorted);
		System.out.println(Arrays.toString(sorted));
	}

	private int[] sort(int[] unsorted ) {

		int start = 0;
		int end = unsorted.length - 1;
		mergesort(unsorted, start, end);
		
		int[] sorted = unsorted;
		return sorted;
	}
	
	private void mergesort(int[] input, int start, int end){
		System.out.println("mergesort:start:"+start+",end:"+end);
		if(start == end){
			return;
		}
		int mid = (start + end + 1)/2;
		mergesort(input ,start, mid - 1 );
		mergesort(input ,mid, end );
		merge(input, start, mid, end);
	}
	
	private void merge(int[] input, int start, int mid, int end){
		System.out.println("start:"+start+",mid:"+mid+",end:"+end);
		System.out.println("input:"+Arrays.toString(input));
		
		if(start == end)
			return;
		
		int[] left, right;
		
		left = Arrays.copyOfRange(input, start, (mid-1+1));
		right = Arrays.copyOfRange(input, mid, (end+1));
		
		
		System.out.println("left:"+Arrays.toString(left));
		System.out.println("right:"+Arrays.toString(right));
		
		int i = 0 ,j = 0;
		int k = start;
		while(k < end + 1){
			
			if (j > right.length-1){
				input[k]=left[i];
				i++;
				k++;
				continue;
			}
			if (i > left.length-1){
				input[k]=right[j];
				j++;
				k++;
				continue;
			}
			if(left[i]<=right[j]){
				input[k]=left[i];
				i++;
				k++;
				continue;
			}
			if(right[j]<left[i]){
				input[k]=right[j];
				j++;
				k++;
				continue;
			}
			
		}
	}
	
	
	
}
