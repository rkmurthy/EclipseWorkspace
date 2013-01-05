package FacebookQuestions;

import java.io.*;
import java.util.*;

public class CountWays_New {
	
	public static String formNumber(int n){
		if (n < 0) return "(-1)*"+formNumber((-1)*n);
		String s = "";
		if( n >= 0 && n <= 9)
			return n+"";
		if(n %2 == 0){
			s = formNumber(n/2);
			return "(("+s+")+("+s+"))";
		}
	    else{
	    	s = formNumber((n-1)/2);
	    	return "1+"+ "(("+s+")+("+s+"))";
	    }
	}
	
	public static void main(String[] args)throws Exception{
		System.out.println(formNumber(128));
	}
}
