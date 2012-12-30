package FacebookQuestions;
import java.io.*;
import java.util.*;

public class RemoveDuplicates {
	
	public static StringBuffer removeDuplicates1(StringBuffer s){
		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<s.length();j++){
				if(s.charAt(i) == s.charAt(j)){
					s=new StringBuffer(s.substring(0,j)+(s.substring(j+1,s.length())));
					j--;
				}
			}
		}
		return s;
	}
	
	public static String removeDuplicates2(String s){
		
		char c[] = s.toCharArray();
		Arrays.sort(c);
		System.out.println(Arrays.toString(c));
	    int write = 0, read = 1;
	    while(read <= c.length-1){
	       if(c[read] == c[read-1]){
	    	   while(c[read] == c[read-1]) ++read;
	       //write++;
	       c[++write] = c[read++];
	       }else{
	    	   c[++write] = c[read++];
	       }
	    }
	    return new String(c).substring(0,write+1);
	}
	
	public static void main(String args[]) throws IOException{
		StringBuffer s=new StringBuffer("abbbaccdefegheij");
		System.out.println("String after removing all duplicates:");
		System.out.println(removeDuplicates1(s));
		System.out.println(Arrays.toString(removeDuplicates2(s.toString()).toCharArray()));
	}
	
}
