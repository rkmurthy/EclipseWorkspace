package SortingMethods;

import java.util.Arrays;

public class Merge {

	
	public static void mergesort(int[] a, int left, int right){
		int mid;
		if(left < right){
			mid = (left+right)/2;
			mergesort(a,left,mid);
			mergesort(a,mid+1,right);
			simpleMerge(a,left,mid+1,right);
		}
	}
	
	public static void simpleMerge(int a[], int f, int s, int t){
		int i,j,k,w;
		
		int temp[] = new int[a.length];
		i = f;
		j = s;
		k = -1;
		
		while(i <= s-1 && j <= t){
			if(a[i] < a[j])
				temp[++k] = a[i++];
			else
				temp[++k] = a[j++];
		}
		// Now we copy the remaining elements
		
		if(i > s-1){
			for(w = j; w <= t; w++)
				temp[++k] = a[w];
		}else{
			for(w = i; w <= s-1; w++)
				temp[++k] = a[w];
		}
	
	//Now copy temp array back in a
	
	for(w = 0; w <= k ; w++)
		a[f+w] = temp[w];
	
	}
	
	public static void main(String args[]) throws Exception{
		int a[] = {90,80,70,60,50,40,30,20,10};
		mergesort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
}