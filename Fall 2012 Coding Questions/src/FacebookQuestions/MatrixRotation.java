package FacebookQuestions;
import java.io.*;
import java.util.*;

public class MatrixRotation {
	static int[][] a;
	
	public static void rotate(int[][] a, int n){
		for(int layer = 0; layer < (n/2); layer++){
			int first = layer;
			int last = n-1-layer;
			for(int i = first; i < last; i++){
				int offset = i-first;
				int top = a[first][i];
				a[first][i] = a[last-offset][first];
				a[last-offset][first] = a[last][last-offset];
				a[last][last-offset] = a[i][last];
				a[i][last] = top;
				System.out.println("---------------------------------------");
				print(a,n);
			}
		}
	}
	
	public static void print(int[][] a, int n){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(a[i][j]+"\t");
			}
		System.out.println();
		}
	}
	
	public static void main(String[] args)throws Exception{
		int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int n = a.length;
		print(a,n);
		rotate(a,n);
	}
}
