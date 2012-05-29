package myJavaProgs;
import java.io.*;
import java.util.*;
public class QuickSort {

public static int partition(int a[],int p,int r){
	int i,j,pivot;
	i=p;j=r;
	pivot=a[p];
	while(i<=r && a[i]<=pivot)
		i++;
	while(j>=p && a[j]>pivot)
		j--;
	  if(i<j){
		  int temp=a[i];
		  a[i]=a[j];
		  a[j]=temp;
	    }
	  else{
		 a[p]=a[j];
		 a[j]=pivot;
	  }
		System.out.print("[");
		for(i=0;i<a.length-1;i++)
			System.out.print(a[i]+",");
		System.out.print(a[i]+"]"); 
		System.out.println("Pivot=>"+a[j]);
	  return j;
}

public static void Quick_sort(int a[],int p,int r){
	if(p<r){
	int q=partition(a,p,r);
	Quick_sort(a,p,q);
	Quick_sort(a,q+1,r);
   }
}

public static void main(String a[])throws IOException{
	int n,i;
	int array[];
	BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter size of array");
	n=Integer.parseInt(b.readLine());
	array=new int[n];
	System.out.println("Enter array elements");
	for(i=0;i<n;i++)
		array[i]=Integer.parseInt(b.readLine());
	System.out.println("The array elements you entered");
	System.out.print("[");
	for(i=0;i<n-1;i++)
		System.out.print(array[i]+",");
	System.out.print(array[i]+"]");
	System.out.println();
	Quick_sort(array,0,n-1);
	System.out.println("\nThe sorted array is:");
	System.out.print("[");
	for(i=0;i<n-1;i++)
		System.out.print(array[i]+",");
	System.out.print(array[i]+"]");
}

}