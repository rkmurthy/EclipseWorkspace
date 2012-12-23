package FacebookQuestions;
//Implemented as Java code- Non recursive-O(n) time complexity- No extra space used
//Source: http://nitishkr.wordpress.com/category/all/
import java.io.*;
import java.util.*;

public class RegexParser {
	
	public static int m_plus(String s, char c){
		if(s.charAt(0)!=c)
			return -1;
		int i=0;
		while(s.charAt(i++)==c);
		return i-1;
	}
	
	public static int m_star(String s, char c){
		if(s.charAt(0)!=c)
			return 0;
		int i=0;
		while(s.charAt(i++)==c);
		return i-1;
	}
	
	public static int m_dot(String s, char c){
		if(s.charAt(0)!=c)
			return -1;
		return 1;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s,reg;
		int i,j,p;
		System.out.println("Enter string");
		s=br.readLine();
		System.out.println("Enter regular expression");
		reg=br.readLine();
		while(!reg.equals("")){
			if(reg.length()>=2){
				if(reg.charAt(1)=='+')
					p=m_plus(s,reg.charAt(0));
				else if(reg.charAt(1)=='*')
					p=m_star(s,reg.charAt(0));
				else
					p=m_dot(s,reg.charAt(0));
				if(p==-1){
					throw new Exception("String does not match pattern");
				}
				s=s.substring(p,s.length());
				if(reg.charAt(1)=='+'||reg.charAt(1)=='*'||reg.charAt(1)=='.')
					reg=reg.substring(2,reg.length());
				else
					reg=reg.substring(1,reg.length());
			}else{
				p=m_dot(s,reg.charAt(0));
				if(p==-1)
					throw new Exception("String does not match pattern");
				s=s.substring(p,s.length());
				reg=reg.substring(1,reg.length());
			}
		}
		if(!s.equals("")){
			throw new Exception("String does not match given regular expression");
		}else{
			System.out.println("String matches pattern!");
		}
		
	}
	
	
}
