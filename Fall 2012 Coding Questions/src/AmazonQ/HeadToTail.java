package AmazonQ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Amazon "Bar-Raiser" Interview
 * @author ramasubramaniankrishnamurthy
 * Given two words generate one from the other using a valid conversion of one character at each step
 * This code will run out of heap space when run for string of length more than 3
 * The main thing here is to understand that this can be done using a variant of Breadth First Search
 */
public class HeadToTail {
	
	static HashMap<String,String> backTrackMap;
	static ArrayList<String> Dict;
	
	public static void createDict()throws Exception{
		Dict = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("../Fall 2012 Coding Questions/src/AmazonQ/Dictionary");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String s = "";
		while((s = br.readLine())!= null){
			String str[] = s.split("\t");
			for(String st:str){
				//int l = st.length();
				Dict.add(st);
			}
		}
		System.out.println(Arrays.toString(Dict.toArray()));
	}
	
	public static ArrayList<String> getValidCombinations(String s){
		
		//System.out.println(Arrays.toString(Dict.toArray()));
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i < s.length(); i++){
			 char c = s.charAt(i);
			 for(char x = 'A'; x <= 'Z'; x++){
				 if(c != x){
					 String str = s.substring(0,i)+x+s.substring(i+1);
					 str = str.toUpperCase();
					 //System.out.println(str);
					//if(Dict.contains(str.toString())){ 
						//System.out.println(str);
					 backTrackMap.put(str,s);
					 result.add(str);
					//}
				 }
			 }
		}
		System.out.println(backTrackMap.entrySet());
		return result;
		
	}
	
	
	public static ArrayList<String> generateTail(String head,String tail)throws Exception{
		if(head == null || tail == null || head.length() == 0 || tail.length() == 0) throw new Exception("Invalid Inputs");
		head = head.toUpperCase();
		tail = tail.toUpperCase();
		//ArrayList<String> result = new ArrayList<String>();
		Queue<String> q = new LinkedList<String>();
		HashSet<String> visited = new HashSet<String>();	
		ArrayList<String> track = new ArrayList<String>();
		q.add(head);
		while(!q.isEmpty()){
			//System.out.println("Am I executed at all?");
			String u = q.remove();
			visited.add(u);
			ArrayList<String> r = getValidCombinations(u);
			for(String v: r){
				//System.out.println(v);
				if(v.equals(tail)){
					track = new ArrayList<String>();
					track.add(tail);
					String w = backTrackMap.get(tail);
					while(w != null){
						//System.out.println("w:"+w);
						track.add(w);
						w = backTrackMap.get(w);
					}
					return track;
				}else{
					if(!visited.contains(v))
						q.add(v);
				}
			 }
		}
		throw new Exception(tail+" cannot be formed from "+head);
	}
	
	public static void main(String[] args)throws Exception{
		createDict();
		backTrackMap= new HashMap<String,String>();
		ArrayList<String> result = generateTail("HAIL","TAIL");
	    for(String r:result)
	    	System.out.println(r);
	}

}
