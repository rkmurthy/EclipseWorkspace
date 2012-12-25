package FacebookQuestions;
import java.io.*;
import java.util.*;


public class StringIntegerConversions {
	
	public static long atoi(String s) throws Exception{
		if(s.length()==0||s==null) throw new Exception("Invalid String");
		long value = 0;
		boolean neg = false;
		int i=0,x;
		if(s.charAt(i) == '-'){
			neg = true;
			i++;
		}
		for(;i<s.length();i++){
			value *= 10;
			x = s.charAt(i)-'0';
			if(x >=0 && x <= 9)
				value += x;
			else throw new Exception("Invalid character at position "+(i+1));
		}
		 return (neg == true)? (-1)*value:value;
	}
	
	public static String itoa(int n){
		String result = "";
		boolean neg = false;
		//if(n == 0) return 0+"";
		if(n < 0) {
			neg = true;
			n *= -1;
		}
		String temp = "";
		
		do{
			temp= n%10+"";
			result = temp + result;
			n = n/10;
		}while(n>0);
		return (neg == true)? "-"+result:result;
	}
	
	public static void main(String[] args)throws Exception{
		System.out.println(atoi("1234"));
		System.out.println(itoa(1234));
	}

}
