import java.io.*;
import java.util.*;

public class LongestCommonSubstring {
	int dp[][];
	
	public void findLongestSubstring(String s1, String s2)throws Exception{
		
		if(s1.length()==0 || s2.length()==0)
			throw new Exception("One of the strings are empty!!");
		
		dp=new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<s1.length()+1;i++){
			for(int j=1;j<s2.length()+1;j++){
				if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];
				else
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		//Now reconstruct the String
		String result="";
		int i=s1.length();
		int j=s2.length();
		while(i>0 && j>0){
			if(dp[i][j] > dp[i-1][j] && dp[i][j] > dp[i][j-1]){
				result+=(s1.charAt(i-1));
				i--;j--;
				continue;
			}
			if(dp[i][j-1] > dp[i-1][j]){
				j--;
				continue;
			}else{
				i--;
				continue;
			}
		}
		System.out.println(result);
		//return result;
	}
	 
	public static void main(String[] args)throws IOException{
		LongestCommonSubstring lcs=new LongestCommonSubstring();
		try{
		lcs.findLongestSubstring("bdcaba","abcbdab");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
