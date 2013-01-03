package FacebookQuestions;

public class Coins {
	
	
	public static void main(String[] args){
		int[] n = new int[10];
		for(int i = 0; i< n.length; i++)
			n[i] = i;
		char c[] = {'+','-','*','/'};
			
	}

	public int makeN(int n, char c, int i){
		
		int next_denom = 0;
		switch(c){
		case '+': return n-i;
		case '-': return n+i;
		case '*':
			if(i>1 && (n%i)==0) return n/i;
			break;
		case '/':
			 if(i > 1) return n*i;
			 break;
		default: return -1;
	}
		
		return -1;
	}
}
