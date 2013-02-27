package FacebookQuestions;

import java.util.HashMap;

public class MakeChange {

	
	public static int makeChange(int num, int denom){
		int next_denom = 0;
		
		switch(denom){
		case 25: next_denom = 10;
		   				break;
		case 10: next_denom = 5;
						break;
		case 5: next_denom = 1;
		               break;
		case 1: return 1;
		}
		
		int ways = 0;
		for(int i = 0 ; i * denom <= num ; i++){
			System.out.println(i+"\t"+denom+"\t"+num);
			ways += makeChange(num-i*denom,next_denom);
		}
		return ways;
	}
	
	public static void main(String[] args) throws Exception{
		makeChange(100,25);
	}
}
