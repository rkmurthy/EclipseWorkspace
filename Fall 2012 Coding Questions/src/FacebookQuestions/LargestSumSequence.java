package FacebookQuestions;
/**
 * 
 * @author ramasubramaniankrishnamurthy
 * 
 * Given an array with both positive and negative integers find the subsequence with the
 * largest sum and return the sum
 *
 */
public class LargestSumSequence {
	
	public static int findMaxSum(int[] a){
		int maxsum = 0;
		int sum = 0;
		
		for(int i = 0; i < a.length; i++){
			sum += a[i];
			if(maxsum < sum)
				maxsum = sum;
			if(sum < 0) sum = 0;
		}
		return maxsum;
	}
	
	public static void main(String[] args)throws Exception{
		int[] a = {2,3,-8,8,9,-1,2,4,-2,3};
		System.out.println(findMaxSum(a));
	}

}
