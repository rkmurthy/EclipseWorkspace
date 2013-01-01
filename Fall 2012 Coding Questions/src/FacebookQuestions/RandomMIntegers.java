package FacebookQuestions;

import java.util.Random;

public class RandomMIntegers {

	
	public static void genMRandFromN(int a[], int m){
		/**
		 * This solution doesnt need extra space like in the solution
		 * int the Cracking the Coding Interview book
		 */
		int j = a.length-1;
		Random rand = new Random();
		for(int i = 0 ; i < m; i++){
			int index = rand.nextInt(j);
			swap(a,index,j);
			j--;
		}
	}
	
	public static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) throws Exception{
		int a[] = {10,20,30,40,50,60,70,80,90};
		int m = 4;
		genMRandFromN(a,4);
		for(int k = a.length-m; k < a.length; k++)
			System.out.print(a[k]+"\t");
	}
}
