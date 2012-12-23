import java.io.*;
import java.util.*;

public class RotatedArray {

	public static int findRotPoint(int[] a, int start, int end){
		if(start<=end){
			int mid=(start+end)/2;
			
			if(a[mid]>=a[start]){
				if(a[mid]>a[end]){
					return findRotPoint(a,mid+1,end);
				}else{
					return start;
				}
			}else{
				if(a[mid]<a[end]) return findRotPoint(a,start,mid-1);
				return findRotPoint(a,mid+1,end);
			}
		}
		return -1;
		
	}
	
	
	public static void main(String[] args)throws IOException{
		int a[]={108,12,24,36,48,60,72,84,96};
		System.out.println("Rotation Index: "+findRotPoint(a,0,a.length-1));
	}
	
}
