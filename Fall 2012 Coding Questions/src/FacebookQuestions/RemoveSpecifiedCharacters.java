package FacebookQuestions;

import java.io.*;
import java.util.*;

public class RemoveSpecifiedCharacters {
	
	HashSet<String> set = new HashSet<String>();
	public static String remove(String s, HashSet set){
		char[] copy=s.toCharArray();
		
		int read,write;
		read=write=0;
		
		while(read<copy.length){
			if(!set.contains(copy[read]+"")){
				copy[write++]=copy[read++];
			}else{
				read++;
			}
		}
		s = new String(copy).substring(0,write);
		return s;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter String");
		String input = br.readLine();
		HashSet<String> set = new HashSet<String>();
		set.add("a");
		set.add("e");
		set.add("i");
		set.add("o");
		set.add("u");
		System.out.println(remove(input,set));
	
	}
	
}
