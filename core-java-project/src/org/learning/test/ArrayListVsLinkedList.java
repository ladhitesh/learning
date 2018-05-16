package org.learning.test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListVsLinkedList {
	
	public static void main(String[] args) {
		System.out.println("Hi");
		
		ArrayList<Integer> arrayList = new ArrayList<>(100000);
		for(int i=0;i<=100000;i++){
			arrayList.add(i);
		}
		long start = System.nanoTime();
		System.out.println(start);
		//If new array is not getting created, then only the end part of array is copied into same array but shifted by one position.
		//then new element is added at correct location
		//if we insert element at start, there is lot of element to be shifted and hence lot of time needed
		arrayList.add(5, 9);
		System.out.println("ArrayList Done (ns): "+(System.nanoTime()-start));
		
		
		
		LinkedList<Integer> linkedList = new LinkedList();
		for(int i=0;i<=100000;i++){
			linkedList.add(i);
		}
		long start1 = System.nanoTime();
		System.out.println(start1);
		linkedList.add(5, 9);
		System.out.println("LinkedList Done (ns): "+(System.nanoTime()-start1));
	}

}
