package SortingMethods;

import java.io.*;
import java.util.*;

public class BinarySearch {
	
	public static int BinSearch(int a[], int start, int end, int x){
		Arrays.sort(a);
		if(start < end){
			int mid = (start+end)/2;
			if(a[mid] == x)
				return mid;
			else if(a[mid] < x)
				BinSearch(a,start, mid-1,x);
			else
				BinSearch(a, mid+1, end,x);
		}
		return -1;
	}
	
	public static void main(String[] args)throws IOException{
		int a[] = {10,20,30,40,50,60};
		System.out.println("Element found at position: "+(BinSearch(a,0,a.length-1,30)+1));
	}

}
