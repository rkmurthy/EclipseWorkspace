package FacebookQuestions;

public class UnsortedSequence {
		
	public static int findM(int[] a){
		for(int i = 0; i < a.length; i++)
			if(a[i+1] < a[i]) return i+1;
		return a.length-1;
	}
	
	public static int findN(int[] a){
		for(int i = a.length-1; i > 0; i--)
			if(a[i-1] > a[i]) return i-1;
		return 0;
	}
	
	public static int findMin(int[] a, int min, int max){
		int temp_min_index = min;
		for(int i = min+1; i <= max; i++)
			if(a[i] < a[temp_min_index])
				temp_min_index = i;
		return temp_min_index;
	}
	
	public static int findMax(int[] a, int min, int max){
		int temp_max_index = max;
		for(int i = max-1 ; i >= 0; i--)
			if(a[i] > a[temp_max_index])
				temp_max_index = i;
		return temp_max_index;
	}
	
	public static int getLeftPoint(int[] a, int index, int start){
		for (int i = start; i >= 0; i--)
			if(a[i] <= a[index]) return i;
		return -1;
	}
	
	public static int getRightPoint(int[] a, int index, int start){
		for(int i = start; i < a.length; i++)
			if(a[i] >= a[index]) return i;
		return -1;
	}
	
	public static void findUnsortedSequence(int a[]){
		int left  = findM(a);
		int right = findN(a);
		int minIndex = findMin(a, left, right);
		int maxIndex = findMax(a, left, right);
		
		int i = getLeftPoint(a,minIndex,left-1);
		int j = getRightPoint(a,maxIndex,right+1);
		
		System.out.println("Array has to be sorted between indices: "+(i+1)+" and "+(j+1));
	}
	
	
	public static void main(String[] args) throws Exception{
		int a[] ={1,2,4,7,10,11,7,12,6,7,16,18,19};
		findUnsortedSequence(a);
	}
}
