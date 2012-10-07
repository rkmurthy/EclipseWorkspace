import java.io.*;
import java.util.*;

public class BinarySearch {

	public static void main(String args[])throws IOException{
		ArrayList<Integer>input=new ArrayList<Integer>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter array size");
		int n=Integer.parseInt(br.readLine());
		System.out.println("Enter array elements");
		for(int i=0;i<n;i++){
			input.add(Integer.parseInt(br.readLine()));
		}
		System.out.println("Enter element to search for:");
		int element=Integer.parseInt(br.readLine());
		int position1=binary_search_recursive(input,element,0,n-1);
		//int position2=binary_search_iterative(input,element,0,input.size()-1);;
		System.out.println("Element found at position:"+(position1+1));
		}
	
	
	public static int binary_search_recursive(ArrayList<Integer> input, int element,int start,int end){
		if(start<=end){
			int mid=(start+end)/2;
			if(input.get(mid)==element)
				return mid;
			else if(element<input.get(mid)){
				return binary_search_recursive(input,element,start,mid-1);
			}
			else if(element>input.get(mid)){
				return binary_search_recursive(input,element,mid+1,end);	
			}
		}
		
			return -1;
			
		}
	
	public static int binary_search_iterative(ArrayList<Integer> input, int element,int start,int end){
		while(start<=end){
			int mid=(start+end)/2;
			if(input.get(mid)==element){
				return mid;
			}else if (element<input.get(mid)){
				end=mid-1;
			}else if (element>input.get(mid)){
				start=mid+1;
			}
		}
		return -1;
	}
		
	}
	

