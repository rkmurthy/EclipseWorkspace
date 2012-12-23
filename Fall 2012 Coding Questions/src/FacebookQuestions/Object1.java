package FacebookQuestions;

import java.io.*;

class Object{
	int start;
	int end;
	
	Object(){
		start=0;
		end=0;
	}
	
	Object(int s, int e){
		start=s;
		end=e;
	}
}

public class Object1{
	public static void main(String[] args)throws IOException{
		Object o1=new Object(2,4);
		System.out.println("Hello! Object class can be created!");
		System.out.println(o1.start+"\t"+o1.end);
	}
}
