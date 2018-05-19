package org.learning.algorithms;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] unsorted = {2,1,4,3,6,0,2};
		int[] sorted = new QuickSort().sort(unsorted);
		System.out.println(Arrays.toString(sorted));
	}

	private int[] sort(int[] unsorted) {
		quickSort(unsorted, 0, unsorted.length-1);
		int[] sorted = unsorted;
		return sorted;
	}
	
	private void quickSort(int[] input,int start, int end ){
		if(end <= start)
			return;
		int pivotIndex = partition(input, start, end);
		quickSort(input,start, pivotIndex -1 );
		quickSort(input, pivotIndex, end);
	}
	
	private int partition(int[] input,int start, int end){
		//System.out.println("start:"+start+",end:"+end +",input:"+Arrays.toString(input));
		int pivot = input[end]; //pivot value. taking last element as pivot
		int pivotIndex = start - 1; //pivot index
		
		//start comparison after pivot index, move smaller to left of pivot index
		for (int j = start ; j < end; j++) {
			if(input[j]<=pivot){ //hanle duplicates
				pivotIndex++;
				swap(input, pivotIndex, j);
			}
		}
		swap(input, end , pivotIndex+1);
		//System.out.println("pivotIndex:"+pivotIndex+",input:"+Arrays.toString(input));
		return pivotIndex+1;
	}
	
	public void swap(int[] input, int first, int second){
		int temp = input[second];
		input[second] = input[first];
		input[first] = temp;
	}
}
