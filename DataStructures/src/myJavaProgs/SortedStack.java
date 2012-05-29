package myJavaProgs;
import java.io.*;
import java.util.Stack;
import java.util.*;
public class SortedStack {
	
	public Stack<Integer> sort(Stack<Integer>s1,Stack<Integer>s2){
	 while(!s1.empty()){
		int n=s1.pop();
		while(!s2.empty() && n>s2.peek())
			s1.push(s2.pop());
		s2.push(n);
	 }
	return s2;	
	}

	public static void main(String a[])throws IOException{
		SortedStack ss=new SortedStack();
		Stack<Integer> s1=new Stack<Integer>();
		Stack<Integer> s2=new Stack<Integer>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of elements");
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++)
			s1.push(Integer.parseInt(br.readLine()));
		System.out.println("Elements of Stack");
		 for(int i=s1.size()-1;i>=0;i--)
			 System.out.println(s1.get(i));
		s2=ss.sort(s1,s2);
		System.out.println("The sorted stack:");
		for(int i=s2.size()-1;i>=0;i--)
			 System.out.println(s2.get(i));
		
	}
}
