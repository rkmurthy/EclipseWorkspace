package FacebookQuestions;
/**
 * 
 * @author ramasubramaniankrishnamurthy
 *Input: an integer n > 1
 
Let A be an array of Boolean values, indexed by integers 2 to n,
initially all set to true.
 
for i = 2, 3, 4, ..., Ãn :
  if A[i] is true:
    for j = i2, i2+i, i2+2i, ..., n:
      A[j] := false
 
Now all i such that A[i] is true are prime.
 */
public class Primes {
	
	public static void generatePrimes(int n){
		//n is the upper limit
		
		boolean a[] = new boolean[n];
		for(int i = 0; i < n; i++)
			a[i] = true;
		for(int i = 2; i <= Math.sqrt(n); i++)
			for( int j = 2*i ; j < n; j += i)
				if(a[j]) a[j] = false;
		for(int i = 2; i < a.length; i++)
			if(a[i]) System.out.print(i+"\t");
	}

	public static void main(String[] args)throws Exception{
		generatePrimes(30);
	}
}
