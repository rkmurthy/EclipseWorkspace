package FacebookQuestions;

import java.util.Arrays;

/*
 * Was last of interviews so the interviewer was in a hurry so he named a shorter problem. Given a 2D array of boxes of two dimensions that are not the same (Ex. 4 x 5 array), 
 * write an algorithm that traverses every box in a spiral direction until it reaches the center box.
 * (Eg: Starting at the top left, traverse every box from left to right, and once you reach the top right, traverse down 
 *  until you reach the bottom right corner, then traverse left, up, right, down, left, etc)
 */
public class MicrosoftPhone {
    
	
	public static void traverse(int [][] a){
		int i = 0; 
		int j =0;
		int layer = 0;
		
		while( i != a.length/2 && j != a[i].length/2 ){
			
			while(j <= a[i].length-layer-1){
				System.out.print(a[i][j]+"\t");
				j++;
			}
			i++;
			j--;
		    while(i <= a.length-1-layer){
		    	System.out.print(a[i][j]+"\t");
		    	i++;
		    }
		    j--;
		    i--;
		    while( j >= layer-0){
		    	System.out.print(a[i][j]+"\t");
		    	j--;
		   }
		    i--;
		    j++;
		    layer++;
		    while(i >= layer-0){
		    	System.out.print(a[i][j]+"\t");
		    	i--;
		    }
		    j--;
		    i++;
		    i = layer; j = layer;
	}
		
    
}
	
	public static void main(String args[]) throws Exception{
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		traverse(matrix);
		System.out.println();
		for(int i =0; i< matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}
	
}
