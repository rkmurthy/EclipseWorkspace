package FacebookQuestions;

import java.io.*;
import java.util.*;

public class LongestStringsInFile {

	static String[] heap;
	
	static void swap(String[] a, int i, int j){
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void BuildMinHeap(){
		for(int i = heap.length/2; i >= 0 ; i--){
			MinHeapify(i);
		}
	}
	
	static void MinHeapify(int i){
		int l = 2*i+1;
		int r = 2*i+2;
		int smallest;
		if(l <= heap.length && (heap[l].length() <= heap[i].length()))
			smallest = l;
		else smallest = i;
		if(r <= heap.length && (heap[r].length() <= heap[smallest].length()))
			smallest = r;
		if( i != smallest){
			swap(heap,i,smallest);
		    MinHeapify(smallest);
		}
	}
	
	public static void find(String filename)throws Exception{
		FileInputStream fis = new FileInputStream(filename);
	    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	    String s="";
	    String str[];
	    int index = 0;
	    int ind = 0;
	    s = br.readLine();
	    int val = s.charAt(0);
	    
	    //---------------------------------
	    char c = 'A';
	    int a[] = new int[256];
	    System.out.println(a[c]);
	    //---------------------------------
	    int v = 200;
	    System.out.println((char)v);
	    //----------------------------------
	    boolean flag[] = new boolean[val+1];
	    boolean test = false;
	    if(test)
	    if(flag[val])
	   //-----------------------------------
	    System.out.println(val+s);
	    while(index < 20){
	    	str = s.split("\t");
	    	if(str.length > 0){
	    	heap[index] = str[ind];
	    	index ++;
	    	ind ++;
	    }
	    BuildMinHeap();
	    if(ind != 0){
	    	while(ind < s.split("\t").length){
	    		if(s.split("\t")[ind].length() < heap[0].length())
	    			ind ++;
	    		else{
	    			heap[0] = s.split("\t")[ind];
	    			MinHeapify(0);
	    		}
	    	}
	    }else{
	    	while( (s=br.readLine()) != null){
	    		String split[] = s.split("\t");
	    		for(int i =0; i< split.length; i++){
	    			if(heap[0].length() < split[i].length()){
	    				heap[0] = split[i];
	    				MinHeapify(0);
	    		}
	    		}}}}
	  
	}
	
	public static void main(String[] args)throws Exception{
		heap = new String[20];//min-heap that stores the 20 largest strings
		find("../Fall 2012 Coding Questions/src/FacebookQuestions/FindLongestStrings");
		System.out.println(Arrays.toString(heap));
		
	}
}
