package myJavaProgs;
import java.io.*;
import java.util.*;
public class BinarySearch {
	
	public static int search(int a[],int min,int max,int element){
		if(max<min)return -1;
		int mid=(min+max)/2;
		if(element>a[mid])
			return search(a,mid+1,max,element);
		 if(element<a[mid])	
			return search(a,min,mid-1,element);
		 return mid;
			
		}
		//return mid;
	

	public static void main(String args[])throws IOException{
		//ArrayList<Integer> a=new ArrayList<Integer>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter array size");
		int size=Integer.parseInt(br.readLine());
		int a[]=new int[size];
		System.out.println("Enter array elements(in sorted order only");
		for(int i=0;i<size;i++)
		a[i]=(Integer.parseInt(br.readLine()));
		System.out.println("Enter element to search for");
		int element=Integer.parseInt(br.readLine());
		System.out.println("Element found at:"+(BinarySearch.search(a, 0, size-1, element)+1));
		
	}
}
