package FacebookQuestions;

import java.util.Arrays;

public class SentenceReverse {

	public static void swap(char[] a, int i, int j){
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static String sentReverse(String s){
		char[] copy = s.toCharArray();
		for(int i = 0; i < copy.length/2;i++){
			swap(copy,i,copy.length-1-i);
		}	
		System.out.println(Arrays.toString(copy));
		int i = 0, j = 0;
		
		while( i < copy.length ){
			if(copy[i] == ' ' ){
				i --;
				int l = i;
				for(int k = j; k < j+(i-j+1)/2; k++){
					swap(copy,k,l);
				    l --;
				}
				j =(i+2); 
				i+=2;
			}else if(i == copy.length-1){
				int l = i;
				for(int k = j; k < j+(i-j+1)/2; k++){
					swap(copy,k,l--);
				}
				i++;
			}else{
				i ++;
			}
		}
		System.out.println(j);
		System.out.println(Arrays.toString(copy));
		return new String(copy);
	}
	
	public static void main(String[] args)throws Exception{
		System.out.println(sentReverse("Hello World I am here"));
		
	}
}
