package FacebookQuestions;

public class CountWays {
	
	public static boolean canForm(int n){
		if(n == -9 || n == -8 || n==-7 || n==-6|| n==-5||n==-4||n==-3||n==-2||n==-1|| n == 0 || n ==1 || n == 2 || n == 3 || n == 4 || n == 5 || n == 6|| n == 7 || n == 8 || n == 9)
			return true;
		for(int i = 2; i < 10; i++){
			
		        if( i == 0 | i == 1) i = 2;
				if(canForm(1/i) && canForm(n*i)){
				System.out.println("Divide "+(n*i)+" by "+i);
				return true;
				}
			
			
				if(canForm((-1)*i) && canForm(n+i)){
				System.out.println("Subtract "+i+" from "+(n+i));
				return true;
				}
			
			
			if (canForm(i) && canForm(n-i)) {
				System.out.println("Add "+i+" with "+(n-i));
				return true;
			}
			
			if(n%i == 0){
				if( i == 0 || i ==1) i =2;
				if( i >= 2 && canForm(i) && canForm(n/i)) {
					System.out.println("Multiply "+(n/i)+" with  "+i);
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args)throws Exception{
		System.out.println(canForm(10));
	}
}
