package FacebookQuestions;
import java.io.*;
import java.util.*;

public class ReverseWords{
	public static String reverse(String s){
		//This is an inplace reversal without using extra space
		char[] copy=s.toCharArray();
		
		for(int i=0;i<copy.length/2;i++){
			char temp = copy[i];
			copy[i]=copy[copy.length-1-i];
			copy[copy.length-1-i]=temp;
		}
		s=new String(copy);
		System.out.println(s);
		int i,j;
		i=j=0;
		while(i<copy.length){
			if(copy[i]!=' ') {
				j = i;
				//i++;
				while(i < copy.length && copy[i]!=' ')
					i++;
				i--;
				int start=j;int end=i;
				while(end>start){
					char temp = copy[start];
					copy[start] = copy[end];
					copy[end] = temp;
					end--;
					start++;
				}
			}
			i+=1;
		}
		s=new String(copy);
		return s;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string");
		String input=br.readLine();
		System.out.println(reverse(input));
	}
}
