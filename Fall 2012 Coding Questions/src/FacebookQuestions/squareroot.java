package FacebookQuestions;

import java.io.*;
import java.util.*;

public class squareroot {

	static int low;
	static int hi;
	static int tries=1000;
	static int prev;
	
	public static int findSquareRoot(int n){
		hi=n;
		while(tries-- >= 0){
			//--tries;
			int curr=hi-((hi-low)/2);
			int prd=curr*curr;
			if(prd==n || prev==n){
				return curr;
			}
			
			if(prd>n)
				hi=curr;
			else
				low=curr;
		   prev=curr;//What does this line do?
		}
		return -1;
	}
	
	public static void main(String args[])throws IOException{
		System.out.println(findSquareRoot(80));
	}
	
}
