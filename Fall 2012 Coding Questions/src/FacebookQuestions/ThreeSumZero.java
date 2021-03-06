package FacebookQuestions;

import java.io.*;
import java.util.*;


public class ThreeSumZero {
	
	public static void check(int[] a){
		int i=0;
		int j=0;
		int sum=0;
		for(int k=0;k<a.length-1;k++){
			i=k+1;
			j=a.length-1;
			while(i!=j){
				sum=a[i]+a[j];
				if(sum+a[k]==0){
					System.out.println("Numbers that sum to zero: "+a[i]+" "+a[j]+" "+a[k]);
					break;
				}
				else if(sum+a[k]<0)
					i++;
				else
					j--;
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		int[] a={4,5,-9,6,3,-11};
		Arrays.sort(a);
		check(a);
	}

}
