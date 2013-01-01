package FacebookQuestions;

import java.util.Arrays;
import java.util.Random;

public class shuffleArray {

	
	public static void shuffle(int[] a){
		Random rand = new Random();
		for(int i = a.length-1; i >= 0; i--){
			int index = (rand.nextInt(i+1));
			swap(a,index,i);
		}
	}
	
	public static void shuffle1(int[] a){
		/**
		 * This is the function from the Cracking The Coding Interview Book
		 */
		Random rand = new Random();
		for(int i = 0; i < a.length; i++){
			int index = (int) (Math.random() * a.length - i)+i;
			swap(a,i,index);
		}
	}
	
	public static void swap(int a[], int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args)throws Exception{
		int a[] = {10,20,30,40,50,60,70,80,90};
		System.out.println(Arrays.toString(a));
		shuffle(a);
		System.out.println(Arrays.toString(a));
	}
}
