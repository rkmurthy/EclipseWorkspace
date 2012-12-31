package SortingMethods;
/**
 *  O(n^2) average and worst case solution
 */
import java.util.Arrays;

public class SelectionSort {

	
	public static void sort(int[] a){
		int min = 0;
		for(int i = 0; i <= a.length-1; i++){
			 min = i;
			 for(int j = i+1; j <= a.length-1; j++){
				 if(a[j] < a[min])
					 min = j;
			 }
			 swap(a,i,min);
		}
	}
	
	public static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	public static void main(String[] args)throws Exception{
		int a[] = {90,80,70,60,50,40,30,20,10};
		sort(a);
		System.out.println("Sorted Result: \n"+Arrays.toString(a));
	}
}
