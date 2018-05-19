package org.learning.algorithms;

import java.util.Arrays;

public class HeapSort {
	//heapsort visualization - https://www.cs.usfca.edu/~galles/visualization/HeapSort.html
	
	public static void main(String[] args) {
		int[] unsorted = { 6, 11, 11, 2, 2, 1, 4, 3, 9 };
		
		int[] sorted = new HeapSort().sort(unsorted);
		//System.out.println(Arrays.toString(sorted));
		
		int[] unsorted1 = { 6, 11, 15, 2, 2, 1, 4, 20, 9 };
		new HeapSort().extractMax(unsorted1, 4);
	}

	private int[] sort(int[] unsorted) {
		
		//binary heap is complete binary tree. all levels are full except last level
		//all leaves are from left side of tree
		//heap is stored in array at level order.
		//starting from root at index 0, then 1st level nodes, 2nd level nodes
		//all leaves towards end of array after all nodes
		
		//heapify initial array
		//start from botom level to top level
		int n = unsorted.length; //no. of elements
		for (int i = n/2 -1 ; i >= 0; i--) {
			//for each node level, heapify
			heapify(unsorted, n, i);
		}
		
		//remove max from root and reheapify
		for (int i = n - 1 ; i >=0; i --) {
			swap(unsorted,0,i);
			heapify(unsorted,i,0);
		}
		
		int[] sorted = unsorted;
		return sorted;
	}
	
	public void extractMax(int[] unsorted,int noOfElementsToExtract){
		
		int n = unsorted.length; //no. of elements
		for (int i = n/2 -1 ; i >= 0; i--) {
			//for each node level, heapify
			heapify(unsorted, n, i);
		}
		
		//remove max from root and reheapify
		for (int i = n-1,j = 0 ; i >=0 && j < noOfElementsToExtract; i--,j++) {
			swap(unsorted,0,i);
			heapify(unsorted,i,0);
		}
		System.out.println(Arrays.toString(unsorted));
		for (int i = unsorted.length-1,j=0; i > 0 && j < noOfElementsToExtract; i--,j++) {
			System.out.print(unsorted[i] + " ");
		}
	}
	
	private void heapify(int[] unsorted, int maxElementsInHeap, int i) {
		
		int subtreeRoot = i;
		int left = (i*2)+1;
		int right = (i*2)+2;
		
		if(left < maxElementsInHeap && unsorted[left]>unsorted[subtreeRoot]){
			subtreeRoot = left;
		}
		
		if(right < maxElementsInHeap && unsorted[right]>unsorted[subtreeRoot]){
			subtreeRoot = right;
		}
		
		//swap if there is change in index holding max value
		if(subtreeRoot != i){
			swap(unsorted,subtreeRoot,i);
			heapify(unsorted,maxElementsInHeap,subtreeRoot);
		}
	}
	
	private void swap(int[] input, int first, int second){
		int temp = input[second];
		input[second] = input[first];
		input[first] = temp;
	}
	
	

}
