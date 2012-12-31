package FacebookQuestions;
/**
 * All Pairs of numbers in an array that sum to a particular value
 */
import java.util.Arrays;

public class SumToN {

	public static void doesSum(int a[], int n){
		Arrays.sort(a);
		int beg = 0, end =a.length-1;
		while(beg < end){
			int s = a[beg]+a[end];
			if(s == n){
				System.out.println(a[beg]+"\t"+a[end]);
				beg ++;
				end -- ;
			}   
			else if(s < n)
				beg++;
			else 
				end--;
		}
	}
	
	public static void main(String args[])throws Exception{
		int a[] ={ 1,2,3,4,5,6};
		doesSum(a,12);
	}
}
