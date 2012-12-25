package TwitterCodility;

import java.io.*;
import java.util.*;

public class Siblings implements Comparator<Integer>{
	
	
	public int compare(Integer n1, Integer n2){
		String s1 = n1.toString();
		String s2 = n2.toString();
		return s2.compareTo(s1);
	}

	
	public static void main(String[] args)throws Exception{
		Siblings s2 = new Siblings();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number");
		int n = Integer.parseInt(br.readLine());
		int temp = n;
		int count = 0;
		while(temp!=0){
			temp = temp/10;
			count++;//number of digits in the number n
		}
		
		Integer temp_array[] = new Integer[count];
		temp = n;
		int i = 0;
		while(temp != 0){
			temp_array[i++] = temp%10;
			temp = temp/10;
		}
		
		for(i = 0; i < temp_array.length/2; i++){
			int temp_a = temp_array[i];
			temp_array[i] = temp_array[temp_array.length-1-i];
			temp_array[temp_array.length-1-i] = temp_a;
		}
		//return temp_array;
		Arrays.sort(temp_array,s2);
		System.out.println(Arrays.toString(temp_array));
		
	}
}
