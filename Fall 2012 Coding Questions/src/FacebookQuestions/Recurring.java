package FacebookQuestions;
/*
 * Write a function that when given a string will return the position of the starting point of the largest 
 * re-occurring character. (ie. given:"AAABBCCCCD" would return 5 (starting point of C))
 */

/**
 * 
 * @author ramasubramaniankrishnamurthy
 * 
 * Test Cases:
 * 1. Empty or null string
 * 2. String like AB - what to return? A or B?
 * 3. String which ends with repeated character - check to see that you don't cross the 
 *    bounds of the string
 *
 */
public class Recurring {
	
	public static void findLongestRecurring(String s)throws Exception{
		if(s == null || s.length() == 0) throw new Exception("Invalid String!");
		int max_count = 1;
		int max_pos = 0;
		int count = 1;
		int read = 1; int write = 0;
		while(read < s.length()){
			if(s.charAt(read) == s.charAt(write)){
				while(read < s.length() && s.charAt(read) == s.charAt(write)){
				count++;
				read++;
				}
				if(max_count < count){
					max_count = count;
				    max_pos = write;
				}
			}else{
				count = 1;
				write = read;
				read++;
			}
		}
		System.out.println("Max occurences of: "+s.charAt(max_pos)+"\nMax_Count: "+max_count);
	}
	
	public static void main(String[] args) throws Exception{
		findLongestRecurring("HA");
	}
	
	

}
