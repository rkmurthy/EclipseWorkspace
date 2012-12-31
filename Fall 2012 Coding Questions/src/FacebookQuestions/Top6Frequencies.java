package FacebookQuestions;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 
 * @author ramasubramaniankrishnamurthy
 * Program that the top 6 values in a given array - using a min-heap 
 * Therefore the complexity of this solution is O(nlogn)
 */
public class Top6Frequencies {
	
	public static void BuildMinHeap(int[] heap){
		for(int i = heap.length/2;i >= 0; i--)
			MinHeapify(heap,i);
	}
	
	public static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void MinHeapify(int[] heap, int i){
		int l = 2*i+1;
		int r = 2*i+2;
		int smallest;
		if(l < heap.length && heap[l] < heap[i])
			smallest = l;
		else
			smallest = i;
		if(r < heap.length && heap[r] < heap[smallest])
			smallest = r;
		swap(heap,i,smallest);
		if(i != smallest)
			MinHeapify(heap,smallest);
	}

	public static void findTop6(ArrayList<Integer> a){
		int[] heap = new int[6];
		for(int i =0; i< 6; i++)
			heap[i] = a.get(i);
			BuildMinHeap(heap);
	  int index = 6;
	  while(index < a.size()){
		  if(a.get(index) < heap[0]) index++;
		  else{
			  heap[0] = a.get(index);
			  MinHeapify(heap,0);
			  index++;
		  }
	  }
	  System.out.println(Arrays.toString(heap));
	}
	
	public static void main(String[] args) throws Exception{
		ArrayList<Integer> a = new ArrayList<Integer>();
		int array[] = {12,23,34,45,56,67,78,89,90,100};
		for(int i = array.length-1; i >= 0; i--)
			 a.add(array[i]);
		findTop6(a);
	}
}
