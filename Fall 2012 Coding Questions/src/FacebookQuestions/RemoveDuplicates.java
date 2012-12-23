package FacebookQuestions;
import java.io.*;
import java.util.*;

public class RemoveDuplicates {
	
	public static StringBuffer removeDuplicates(StringBuffer s){
		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<s.length();j++){
				if(s.charAt(i)==s.charAt(j)){
					s=new StringBuffer(s.substring(0,j)+(s.substring(j+1,s.length())));
					j--;
				}
			}
		}
		return s;
	}
	
	public static void main(String args[]) throws IOException{
		StringBuffer s=new StringBuffer("abbbaccdefegheij");
		removeDuplicates(s);
		System.out.println("String after removing all duplicates:");
		System.out.println(removeDuplicates(s));
	}
}
