package FacebookQuestions;

import java.io.*;
import java.util.*;

public class NQueens {
	static int[] columnForRow;
	static int n;
	/*public static boolean canPlace(int row){
		for(int i=0;i<row;i++){
			if(colForRow[i] == colForRow[row] || Math.abs(colForRow[row]-colForRow[i]) == Math.abs(row-i))
				return false;
		}
			return true;
			
		}
	
	public static void placeQueen(int row){
	int i;
		if(row == n){
			for(int k=0;k<n;k++)
				System.out.println(k+"\t"+colForRow[k]);
			return;
		}
		for(i=0;i<n;i++){
			colForRow[row]=i;
			if(canPlace(row))
				placeQueen(row+1);
		}
		
	}
	*/
	
	static boolean check(int row) {
	 for (int i = 0; i < row; i++) {
		int diff = Math.abs(columnForRow[i] - columnForRow[row]);
		if (diff == 0 || diff == row - i) return false;
		}
	return true;
		}
		
		static void PlaceQueen(int row){
		 if (row == n) {
		// printBoard();
			 for(int k=0;k<n;k++)
					System.out.println(k+"\t"+columnForRow[k]);
				return;
		// return;
		 }
		for (int i = 0; i < n; i++) {
		columnForRow[row]=i;
		if(check(row)){
		PlaceQueen(row+1);
		}
		 }
	}
	public static void main(String[] args)throws IOException{
		n=4;
		columnForRow = new int[n];
		for(int k=0;k<n;k++){
			PlaceQueen(k);
		}
		
	}
}
