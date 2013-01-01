package FacebookQuestions;
/**
 * This is the algorithm to find the i th largest element using a variant of quick sort in O(n) time
 * 
 * @author ramasubramaniankrishnamurthy
 *
 */
public class SelectionRankAlgo {
	
	public static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static int partition(int[] a, int left, int right){
		int pivot = left + (int)Math.random()*(right-left+1);
		int i = left, j = right;
		while(i <= j){
		while(i <= right && a[i] <= a[pivot])
			i++;
		while(j >= 0 && a[j] > a[pivot])
			j--;
		if(i < j)
			swap(a,i,j);
		}
		if( i > j){
			swap(a,j,pivot);
		}
		return j;
	}
	
	static int selectionRank(int a[], int left, int right, int i){
		if(left == right) return a[left];//corner case - useful when finding the element at the last position in the array -meaning for an n size array finding the nth order statistic
		if(left < right){
			int p = partition(a,left,right);
			int rank = p-left+1;
			if(rank == i) return a[p];
			if(i < rank)
				return selectionRank(a,left,p-1,i);
			else
				return selectionRank(a,p+1,right,i-rank);
		}
		return -1;
	}
	
	public static void main(String[] args)throws Exception{
		int[] a = {100,30,20,40,10,80,60,70,50,90};
		
		for(int i = 1; i <= a.length; i++)
		System.out.println(selectionRank(a,0,a.length-1,i));
	}
	
}
