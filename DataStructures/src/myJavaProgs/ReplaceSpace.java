package myJavaProgs;
import java.io.*;
import java.util.*;
public class ReplaceSpace {
public static void main(String a[]) throws IOException{
	BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter strings");
	String s=b.readLine();
	ArrayList<Character> ch=new ArrayList<Character>();
	for(int i=0;i<s.length();i++){
		ch.add(s.charAt(i));
	}
	for(int i=0;i<ch.size();){
		if(ch.get(i)==' '){	
			ch.remove(i);
			ch.add(i,'%');
			ch.add(i+1,'2');
			ch.add(i+2,'0');
			i=i+4;
		}
		else
			i=i+1;
	}
	
	String s1="";
	for(int i=0;i<ch.size();i++)
		s1+=ch.get(i);
	System.out.println("Modified String:"+s1);
		
	
	
	
}
}
