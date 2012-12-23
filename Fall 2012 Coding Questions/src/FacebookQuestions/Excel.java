package FacebookQuestions;

import java.io.*;
import java.util.*;

public class Excel {

	public static HashMap<String, Integer> dict;
	
	public static void createMap(){
		dict = new HashMap<String,Integer>();
		for(int i=0;i<26;i++){
			dict.put((char)('A'+i)+"", i+1);
		}
		System.out.println(dict.entrySet());
	}
	
	public static void main(String[] args)throws IOException{
		createMap();
		System.out.println(convert("AA"));
	}
	
	public static int convert(String s){
		// s is a excel column sheet
		int value = 0;
		for(int i=s.length()-1;i>=0;i--){
			value = value * 10;
			value += 26*dict.get(s.charAt(i)+"");
		}
		
		return value;
	}
	
	
	
}
