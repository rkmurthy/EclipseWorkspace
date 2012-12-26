package AmazonQ;

import java.io.*;
import java.util.*;

public class Q1 {
		static int sum = 0;
		public static int findSum(int i, int j){
			if(i == j) return i;
			return i + findSum(i+1,j);
		}
		
		public static void main(String[] args)throws Exception{
			System.out.println(findSum(0,8));
		}
}
