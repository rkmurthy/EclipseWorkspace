package FacebookQuestions;

import java.io.*;
import java.util.*;

public class SubArrayWithLargestSum {
	
	public static void findLargestSumSubArray(int a[])throws IOException{
		Arrays.sort(a);
		int max_sum=0;
		int sum=0;
		int max_i=0;
		for(int i=a.length-1;i>=0;i--){
			if(sum+a[i]<sum)
				break;
			else{
			sum+=a[i];
				if(sum>max_sum){
					max_sum=sum;
					max_i=i;
				}  
			}
		}
		System.out.println("Max sub-array from: "+max_i+" to "+(a.length-1));
	}
	
	public static void main(String args[]) throws IOException{
		int a[]={-1,-10,45,56,32,100,78};
		findLargestSumSubArray(a);
	}
}
