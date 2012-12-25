package FacebookQuestions;
/**
 * This is a very good solution from Career Cup - O(n)
 */
import java.io.*;
import java.util.*;

public class MaxSubArray {
	public static void maxArray(int[] array){
		int start,max_start = 0,max_end = 0,sum,max_sum;
		start = 0;
		sum = 0;
		max_sum = 0;
		for(int i=1;i<array.length;i++){
			sum += array[i];
			if(max_sum < sum){
				max_start = start;
				max_end = i;
				max_sum = sum;
			}else if (sum <= 0){
				start = i+1;
				sum = 0;
			}
		}
		System.out.println("Max start: "+max_start+"\t Max_End "+max_end+"\tMax_Sum "+max_sum);
	}
	
	public static void main(String[] args)throws Exception{
		int[] array = {1, 6, -5, 9, -10, 1, -4, 7, 5, -6 };
		maxArray(array);
	}
}
