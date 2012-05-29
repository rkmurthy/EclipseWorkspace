package myJavaProgs;
import java.io.*;
import java.util.*;
/*
 * Given a string "abc"'produce all possible combinations of the string
 * Hint:Take a separately
 * Find all permutations of 'bc'
 * Add a to various locations in all the all the permutations of bc
 */
public class StringPermutations {

	public ArrayList<String> getPerms(String s){
	ArrayList<String> permutations=new ArrayList<String>();
	if(s==null)return null;
	if(s.length()==0){
		permutations.add("");
		return permutations;
	}
	char first=s.charAt(0);
    String remaining=s.substring(1);
    ArrayList<String>perms=getPerms(remaining);
	for(String w:perms)
		for(int i=0;i<=w.length();i++)
			permutations.add(combine(first,i,w));
	return permutations;
	}
	
		
	public String combine(char start,int j,String perm){
		String st=perm.substring(0, j);
		String rt=perm.substring(j);
		return st+start+rt;
	    }
		
	
	public static void main(String args[])throws IOException{
	StringPermutations sp=new StringPermutations();
	BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
	String input="";
	System.out.println("Enter String");
	input=b.readLine();
	ArrayList<String> result=new ArrayList<String>();
	result=sp.getPerms(input);
	System.out.println("Possible Permutations are");
	for(int i=0;i<result.size();i++)
		System.out.println(result.get(i));
	}
 }
