package myJavaProgs;
import java.io.*;
public class Duplicates {
	
	public  char[] removeDuplicates(String s){
		char[] ch=s.toCharArray();
		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<s.length();j++){
				if(ch[j]==ch[i])
					ch[j]='\f';
			}
				
			}
	
		return ch;
	}
	
	

	public static void main(String a[])throws IOException{
		Duplicates d=new Duplicates();
		BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string");
		String s=new String();
		s=b.readLine();
		char c[]=d.removeDuplicates(s);
		System.out.println("After removing duplicates:");
		s=c.toString();
		System.out.println("String:");
		for(int i=0;i<c.length;i++)
			System.out.print(c[i]);
	}
}
