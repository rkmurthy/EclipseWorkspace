package SortingMethods;

import java.io.*;
import java.util.*;

public class HeapSort {
	
	//static int[] heap;
	static int[] sorted;
	static int start = 1;
	static int end = 0;
	static int i = 0;
	
	public static void max_heapify(int[] heap,int end, int i){
		    int largest = 0;
			int left = heap[2*(i)];
			int right = heap[2*(i+1)];
		    if(left <= end && heap[left] > heap[i])
		    	largest = left;
		    else largest = i;
		    if(right <= end && heap[right] > heap[i])
		    	largest = right;
		    if(largest!= i)
		    	swap(heap, i, largest);
		    max_heapify(heap, end, largest);
	}
	
	public static void build_max_heap(int[] heap){
		for(int i=(heap.length-2)/2; i>=1; i--)
			max_heapify(heap,end,i);
	}
	
	public static void sort(int[] heap){
		build_max_heap(heap);
		end = heap.length-1;
		for(int j = heap.length; j>=2; j--){
			swap(heap,1,i);
			end--;
			max_heapify(heap,end,1);
		}
	}
	
	
	
	
	
	public static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	public static void main(String[] args) throws Exception{
		int heap[] = {0,60,50,40,30,45,55,67,89};
		//sorted = new int [heap.length+10];
		sort(heap);
		for(int i =0 ;i<heap.length-1; i++){
			System.out.print(heap[i]+"\t");
		}
		
	}
}
