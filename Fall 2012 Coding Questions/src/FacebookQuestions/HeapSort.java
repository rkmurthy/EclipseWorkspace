package FacebookQuestions;

import java.util.ArrayList;
import java.util.Arrays;


public class HeapSort {
	
	public static void BuildMaxHeap(ArrayList<Integer> array){
		for( int i = array.size()/2; i >= 0; i--)
			Max_Heapify(array,i);
			
	}
	
	public static void Max_Heapify(ArrayList<Integer> array, int i){
		int l = 2*i+1;
		int r = 2*i+2;
		int largest;
		if(l <= array.size()-1 && array.get(l) > array.get(i))
			largest = l;
		else largest = i;
		if( r <= array.size()-1 && array.get(r) > array.get(largest))
			largest = r;
		if(largest != i){
			swap(array,i,largest);
			Max_Heapify(array,largest);
		}
	}
	
	public static void swap(ArrayList<Integer> v, int i, int j){
		int temp = v.get(i);
		v.set(i, v.get(j));
		v.set(j,temp);
	}
	
	public static ArrayList<Integer> heapSort(ArrayList<Integer> array){
		ArrayList<Integer> result = new ArrayList<Integer>();
		BuildMaxHeap(array);
		while(!array.isEmpty()){
		result.add(array.remove(0));
		Max_Heapify(array,0);
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception{
		int a[] = {90,80,50,12,35,54};
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i:a) array.add(i);
		System.out.println("Input Array: "+Arrays.toString(array.toArray()));
		ArrayList<Integer> result = heapSort(array);
		System.out.println("Sorted result (in Descending order):\n "+Arrays.toString(result.toArray()));
     
     
	}
}
