package FacebookQuestions;

//Divide two numbers without using the / or % operators

import java.io.*;
import java.util.*;

public class Divide {
	public static int divide(int x, int y){
		if(x<y)
			return 0;
	
		int i=1;
		while(true){
			if(x==y*i)
				return i;
			else if(x<y*i){
				i--;
				return i;
			}
			i++;
		}
	//return -1;	
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println(divide(160,50)+"");
	}
}
