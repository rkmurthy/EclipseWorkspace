package SortingMethods;
import java.io.*;
import java.util.*;

public class QuickSort {
	public static int partition(int[] array, int start, int end){
		//Random rand = new Random();
		int n = start;
		int pivot = array[n];
		int i = 1, j = array.length-1;
		if(i <= j && i < array.length && j >= 0){
			while(array[i] < pivot)
					i++;
			while(array[j] > pivot)
				 	j--;
			if(i<j){
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			}
		}
		if(i>j){
			int temp = array[n];
			array[n] = array[j];
			array[j] = temp;
		}
		System.out.println(j+"\t"+array[j]);
		return j;
	}
	
	public static void Quick(int[] a, int start, int end){
	//	if(end < start) return;
		if(start <= end){
			//System.out.println("I am executed?");
		int pivot = partition(a,start,end);
		//System.out.println("I am executed?222");
		Quick(a, start, pivot-1);
		//System.out.println("I am executed? 123");
		Quick(a, pivot+1, end);
		//System.out.println("I am executed? 345");
		}
	}
	
	public static void main(String[] args) throws IOException{
		int array[] = {35,10,20,30,40,50,60};
		Quick(array, 0, array.length-1);
		for(Integer i: array)
			System.out.print(i+"\t");
	}
}
