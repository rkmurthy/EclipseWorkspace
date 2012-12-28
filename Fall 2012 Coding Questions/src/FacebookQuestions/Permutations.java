package FacebookQuestions;

import java.util.ArrayList;


public class Permutations {
/*
 * Program that outputs all the permutations of a string
 * 
 */
	
	public static ArrayList<String> getPerms(String str)throws Exception{
		if(str == null)
			throw new Exception("Invalid String");
		ArrayList<String> permutations = new ArrayList<String>();
		if(str.length() == 0){
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String remainder = str.substring(1);
		
		ArrayList<String> words = getPerms(remainder);
		for(String word:words){
			for(int j = 0; j <= word.length(); j++){
				String s = insertCharAt(word,first,j);
				permutations.add(s);
			}
		}
		return permutations;
	}
	
	public static String insertCharAt(String word, char c, int i){
		String start = word.substring(0,i);
		String end = word.substring(i);
		return start+c+end;
	}
	
	public static void main(String args[]) throws Exception{
		ArrayList<String> result = new ArrayList<String>();
		result = getPerms("abcd");
		for(String r:result)
			System.out.println(r);
	}
}
