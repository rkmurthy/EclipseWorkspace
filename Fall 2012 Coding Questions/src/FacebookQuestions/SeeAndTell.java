package FacebookQuestions;

import java.io.*;
import java.util.*;

public class SeeAndTell {
	
	HashMap<String,Integer> map;
	
	SeeAndTell(){
		map=new HashMap<String,Integer>();
	}
	
	public static ArrayList<String> seeAndTell(int seed, int iterations){
		ArrayList<String> result=new ArrayList<String>();
		String s=seed+"";
		result.add(s);
		for(int i=0;i<iterations;i++){
			String input=result.get(i);
			//System.out.println(input);
			String res="";
			int count=1;
			for(int j=0;j<input.length();j++){
				
				//int count=1;
				
				if(j<input.length()-1 && (input.charAt(j)==input.charAt(j+1))){
					count++;
					//continue;
				}
				else{
					
					//System.out.println(input.charAt(j));
					//System.out.println(count);
					res=res+count+input.charAt(j)+"";
					//System.out.println(res);
					//continue;
					count=1;
				}
			}
			//System.out.println("res:"+res);
			result.add(res);
		}
		
		return result;
	}

	public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int seed,iterations;
		
		System.out.println("Enter seed");
		seed=Integer.parseInt(br.readLine());
		System.out.println("Enter iterations");
		iterations=Integer.parseInt(br.readLine());
		ArrayList<String> result=seeAndTell(seed,iterations);
		for(String r:result)
			System.out.println(r);
		
	}
}
