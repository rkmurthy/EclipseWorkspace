package myJavaProgs;
import java.io.*;
import java.util.*;
public class Anagrams {

	public static boolean checkAnagram(String s1,String s2){
		if(Sorting(s1).equals(Sorting(s2))) return true;
		return false;
		
	}
	
	public static String Sorting(String s){
		ArrayList<Character> a=new ArrayList<Character>();
		for(int i=0;i<s.length();i++){
			a.add(s.charAt(i));
	     }
		Collections.sort(a);
		String s12="";
		for(int index=0;index<a.size();index++)
		s12+=a.get(index);
		return s12;
	}
	public static void main(String[] args)throws IOException{
		System.out.println("Enter 2 strings");
		BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
		String s1,s2;
		s1=b.readLine();
		s2=b.readLine();
		System.out.println("Anagram?:"+Anagrams.checkAnagram(s1,s2));
		
	}
}
