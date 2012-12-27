package FacebookQuestions;

import java.io.*;
import java.util.*;

public class Substring {
	public static String removeSubstring(String s, String sub)throws Exception{
		if(s == null || s.length() == 0)
			throw new Exception("Invalid/Empty String");
		boolean flag = true;
		int i = 0;
		while(s.length() >= 0 && i < s.length()-sub.length()){
			int j =0;
			if(s.charAt(i) == sub.charAt(j)){
				j = 1;
				while( j < sub.length()){
					if(s.charAt(i+j) != sub.charAt(j)){
						flag = false;
						break;
					}else{
						flag = true;
						j++;
					}
				}
				if(flag == true)
					s = s.substring(0,i)+s.substring(i+j);
			}
			i += 1;
		}
		return s.toString();
	}
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string");
		String input = br.readLine();
		System.out.println("Enter sub string to be removed");
		String sub = br.readLine();
		System.out.println(removeSubstring(input,sub));
	}
}
