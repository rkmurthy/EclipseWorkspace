package AmazonQ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is not really an Amazon Interview Question...Had to put it here because 
 * the same program also exists inside FacebookQuestions package
 * 
 * @author ramasubramaniankrishnamurthy
 *
 */

public class PasswordCombinations {
	
	static HashMap<String,ArrayList<String>> dictMap;
	static String str ="";
	public static void createMap(){
		dictMap = new HashMap<String,ArrayList<String>>();
		ArrayList<String> tempS = new ArrayList<String>();
		tempS.add("@");
		tempS.add("-");
		tempS.add("$");
		dictMap.put("a", tempS);
		tempS = new ArrayList<String>();
		tempS.add("*");
		tempS.add("&");
		dictMap.put("c", tempS);
	}
	
	public static void createPassCombinations(String s)throws Exception{
		if(s == null) throw new Exception("Invalid Input String");
		
		ArrayList<String> result = new ArrayList<String>();
		
		result = createCombinations(s,0,result);
		 for(String p:result)
		    	System.out.println(p);
		
		
	}
	
	public static ArrayList<String> createCombinations(String s, int index, ArrayList<String> result){
		
		if(index < s.length()){
			String key = s.charAt(index)+"";
			if(dictMap.containsKey(key)){
				for(int i = 0; i < dictMap.get(key).size();i++){
					s = s.substring(0,index)+dictMap.get(key).get(i)+s.substring(index+1);
					result.add(s);
				    createCombinations(s,index+1,result);
				}
			}else{
				return createCombinations(s,index+1,result);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args)throws Exception{
		createMap();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Enter Input String");
	    String input = br.readLine();
	    createPassCombinations(input);
	   
	}

}
