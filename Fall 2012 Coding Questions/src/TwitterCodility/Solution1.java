package TwitterCodility;

import java.io.*;
import java.util.*;

public class Solution1 {
	public static void function(int[][] array){
		int m = array[0].length;
		int n = array.length;
		int count = 0;
		int sum1=0,sum2=0,sum3=0,sum4=0;
		for(int i=1; i < n-1; i++){
			//System.out.println(i);
			sum1 = sum2 =0;
			int k = 0;
			while(k < i){
				for(int j = 0; j < m; j++)
					sum1 += array[k][j];
				k++;
			}
			k = i+1;
			while(k < n){
				for(int j = 0; j < m; j++)
					sum2 += array[k][j];
				k++;
			}
			if(sum1 == sum2){
				System.out.println(i+" "+sum1+" "+sum2);
			 for(int j = 1; j < m-1; j++){
				 int l = 0;
				while(l < j){
					for(int i1 = 0; i1 < n; i1++)
						 sum3 += array[i1][l];
					 l++;
				 }
				 l = j+1;
				 while(l< m){
					for(int i2 = 0; i2 < n; i2++)
						 sum4 += array[i2][l];
					 l++;
				 }
				 if(sum3 ==  sum4){
					 System.out.println(i+"\t"+j);
					 count++;
				 }
			 }
			 continue;
		  }else continue;
		}
		System.out.println("Number of equilibrium points: "+count);
		}
		
	
	public static void main(String[] args)throws Exception{
		int[][] array = {{ 2,7,5},{3,1,1},{2,1,-7},{0,2,1},{1,6,8}};
		function(array);
	}
}
