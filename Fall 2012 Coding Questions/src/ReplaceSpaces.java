import java.io.*;
import java.util.*;

public class ReplaceSpaces {
	
	public static String repSpaces(String s){
		StringBuffer sb = new StringBuffer(s);
		for(int i=0;i<s.length();i++){
			if(sb.charAt(i)==' '){
				sb = new StringBuffer(sb.substring(0, i)+"%20"+sb.substring(i+1));
			}
		}
		return new String(sb);
	}
	
	public static void main(String[] args)throws IOException{
		System.out.println(repSpaces1("Hello how are you ?"));
	}
	
	public static String repSpaces1(String s){
		//Using read-write pointer
		char[] string = s.toCharArray();
		int count=0;//counts the number of spaces
		
		for(int i=0; i< string.length; i++){
			if(string[i] == ' ')
				count++;
		}
		
		char[] copy = new char[s.length()+count*2];
		int read=0;int write=0;
		while(read<string.length){
			if(string[read]!=' '){
				copy[write]=string[read];
				read++;
				write++;
			}else{
			    copy[write]='%';
			    copy[write+1]='2';
			    copy[write+2]='0';
			    write+=3;
			    read++;
			}
		}
		return new String(copy);
	}
	
	
}
