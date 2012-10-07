import java.io.*;
import java.util.*;

public class Sort {

	public static void insertionSort(int a[]){
		int x,j;
		
			for(int i=1;i<=a.length-1;i++){
				x=a[i];j=i;
				while(j>0 && a[j-1]>x){
					a[j]=a[j-1];
					j=j-1;
				}
				a[j]=x;
			}
	}
	
	public static void main(String args[])throws IOException{
		int a[]={45,12,23,78,90,10};
		insertionSort(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"\t");
	}
	
}
