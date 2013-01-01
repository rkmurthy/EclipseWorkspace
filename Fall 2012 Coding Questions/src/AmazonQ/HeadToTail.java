package AmazonQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Amazon "Bar-Raiser" Interview
 * @author ramasubramaniankrishnamurthy
 * Given two words generate one from the other using a valid conversion of one character at each step
 */
public class HeadToTail {
	
	static HashMap<String,String> backTrackMap;
	
	
	public static ArrayList<String> getValidCombinations(String s){
		
		
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i < s.length(); i++){
			 char c = s.charAt(i);
			 for(char x = 'a'; x < 'z'; x++){
				 if(c != x){
					 String str = s.substring(0,i)+x+s.substring(i+1);
					 backTrackMap.put(str,s);
					 result.add(str);
				 }
			 }
		}
		return result;
	}
	
	
	public static ArrayList<String> generateTail(String head,String tail)throws Exception{
		if(head == null || tail == null || head.length() == 0 || tail.length() == 0) throw new Exception("Invalid Inputs");
		head = head.toLowerCase();
		tail = tail.toLowerCase();
		ArrayList<String> result = new ArrayList<String>();
		Queue<String> q = new LinkedList<String>();
		HashSet<String> visited = new HashSet<String>();	
		ArrayList<String> track = new ArrayList<String>();
		q.add(head);
		while(! q.isEmpty()){
			String u = q.remove();
			visited.add(u);
			for(String v: getValidCombinations(u)){
				if(v.equals(tail)){
					track.add(tail);
					String w = backTrackMap.get(tail);
					while(w != null){
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
		backTrackMap= new HashMap<String,String>();
		ArrayList<String> result = generateTail("ad","cd");
	    for(String r:result)
	    	System.out.println(r);
	}

}
