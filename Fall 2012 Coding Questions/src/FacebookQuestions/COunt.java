package FacebookQuestions;

public class COunt {
	static int count = 0;
	static int level = 0;

	static boolean create (int n){
	if (n == 0)
		return true;
	int dp[] = new int[n];
	 dp[0] = 1;
	for (int i=0; i<10; i++)
	{
	// For operator +
	// Reverse operator -
	if (create (n-i)){
		level ++;
		count ++;
		dp[n-i] = count;
	   return true;
	}
    level  = 0;
	// For operator -
	// Reverse operator +
	if (create (n+i)){
		level ++;
		count ++;
		return true;
	}
    level = 0;
	// For operator *
	// Reverse operator /
	if (i != 0 && n%i == 0 && create (n/i)){
		level ++;
		count ++;
		return true;
	}
     level = 0;
	// For operator /
	// Reverse operator *
	if (i != 0 && (i != 1) && create (n*i)){
		level ++;
		count ++;
		return true;
	}
	}
	return false;
 }
	
	public static void main(String[] args)throws Exception{
		create(1000);
		System.out.println(count);
	}
	
	}

