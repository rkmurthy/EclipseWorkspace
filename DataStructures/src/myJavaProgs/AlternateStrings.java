package myJavaProgs;
//Google Interview Question to Aditya
import java.io.*;
import java.util.*;
public class AlternateStrings {
	public static void printString(String s){
	      System.out.println(s);  
	    }
	    
	    public static void printAlternate(String s){
	        String temp="";
	        char ch[]=s.toCharArray();
	        for(int i=0;i<ch.length;i++){
	           if(ch[i]==' '){
	        	int j=i+1;
	        	 while(j<ch.length && ch[j]!=' ')
	                    j=j+1;
	        	 i=j;
	        	 System.out.print(' ');
	          }else{
	        	  System.out.print(ch[i]);
	          }
	        } 
	        System.out.println();
	    }
	    public static void main(String args[])throws IOException{
	        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
	        System.out.println("Enter number of strings");
	        int n=Integer.parseInt(b.readLine());
	        ArrayList<String> s=new ArrayList<String>();
	        for(int i=0;i<n;i++){
	            System.out.println("Enter string # "+(i+1));
	            s.add(b.readLine());
	         }
	        for(int i=0;i<n;i++){
	            if(i%2==0)
	                printString(s.get(i));
	            else
	                printAlternate(s.get(i));
	            
	        }
	        
	    }
	}

