package FacebookQuestions;

import java.io.*;
import java.util.*;

public class nk {
	public static void NumbersPuzzle(String prefix, int last_num, int digits)
	   {
	       for(int j=1;j<=last_num;j++)
	       {
	           if( (prefix+j).length()<digits)
	               NumbersPuzzle((prefix+j),last_num,digits);
	           else
	               if(!prefix.equals(j+"") && Integer.parseInt(prefix)<j)
	            	   System.out.println(prefix+j);
	       }
	   }
	
	public static void main(String[] args) throws IOException{
		NumbersPuzzle("",4,2);
	}
}
