package FacebookQuestions;

import java.util.Arrays;

public class NQueens {
	static int[] columnForRow;
	static int n;
	
	static boolean check(int row) {
	 for (int i = 0; i < row; i++) {
		int diff = Math.abs(columnForRow[i] - columnForRow[row]);
			if (diff == 0 || diff == row - i) return false;
	}
	return true;
	}
		
	static void PlaceQueen(int row){
		 if (row == n) {
			 System.out.println(Arrays.toString(columnForRow));
			 return;
		 }
		for (int i = 0; i < n; i++) {
		columnForRow[row]=i;
			if(check(row)){
				PlaceQueen(row+1);
			}
		}
	}
	
	public static void main(String[] args)throws Exception{
		n=4;
		columnForRow = new int[n];
		for(int k=0;k<n;k++){
			PlaceQueen(k);
		}
	}
}
