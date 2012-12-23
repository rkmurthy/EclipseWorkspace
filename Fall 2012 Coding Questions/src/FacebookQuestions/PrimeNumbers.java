package FacebookQuestions;

import java.io.*;
import java.util.*;

public class PrimeNumbers {
	public static boolean isPrime(int n){
		//if(n==2) return true;
		if(n==1||n==0) return false;
		for(int i=2;i<=n-1;i++){
			if( (n%i==0)) return false;
		}
		return true;
	}
	
	public static void extractNumbers(String input){
		String res="";
		boolean flag=false;
		for(int i=0;i<input.length();i++){
			char c=input.charAt(i);
			int x=c-'0';
			if(x>=0 && x <=9){
				res=res+c;
				flag=true;
			}
			else{
				if(flag){
				res=res+"\t";
				flag=false;
				}
				
			}
		}
		String number[]=res.split("\t");
		
		for(int i=0;i<number.length;i++){
			for(int j=0;j<number[i].length();j++){
				for(int k=j;k<number[i].length();k++){
					String s=number[i].substring(j,k+1);
					int temp=Integer.parseInt(s);
					if(isPrime(temp))
						System.out.println(temp);
				}
			}
		}
	}
	
	public static void main(String args[]) throws IOException{
		extractNumbers("abc2134kd31ef297");
	}
}
