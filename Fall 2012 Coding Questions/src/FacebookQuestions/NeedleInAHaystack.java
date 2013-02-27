package FacebookQuestions;

import java.io.*;
import java.util.*;

public class NeedleInAHaystack {

	public static boolean find(String s, String t){
		if(s == null || t == null) return false;
		boolean flag = false;
		int j = 0;
		for(int i = 0 ; i < s.length()-t.length()-1; i++){
			j = 0;
		     if(s.charAt(i) == t.charAt(j)){
		    	 while(j < t.length()){
		    		 if(s.charAt(i+j) != t.charAt(j)){
		    			 flag = false;
		    			 break;
		    		 }else{
		    			 flag = true;
		    		 }
		    		 j++;
		    	 }
		    	 if(flag = true){
		    		 return true;
		    	 }
		     }
	 }
		return false;
}
	
	
	public static void main(String args[])throws IOException{
		System.out.println(find("abate","bat"));
	}
	
}
