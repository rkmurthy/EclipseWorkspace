package FacebookQuestions;

import java.io.*;
import java.util.*;

public class BinarySearch {

	
	public static int rotated_binSearch(int a[], int x){
		int low=0;
		int high=a.length-1;
		
		while(low<=high){
			int mid=(low+high)/2;
			if(a[mid]==x)
				return mid;
			else if(a[low]>a[mid]){
				//Rotated Case
				if(a[low]>x){
					low=mid+1;
				}else{
					high=mid-1;
				}
			}
			else{
				if(a[mid]<x){
					low=mid+1;
				}else{
					high=mid-1;
				}
			}
		}
		return -1;
	}
	
	
	public static void main(String args[])throws IOException{
		int a[]={60,70,80,10,20,30,40,50};
		
		for(int i=0;i<a.length;i++){
		System.out.println("Element "+a[i]+" found at index: "+(rotated_binSearch(a,a[i])+1));
		}
	}
}
