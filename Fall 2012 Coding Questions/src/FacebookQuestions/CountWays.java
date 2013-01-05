package FacebookQuestions;

public class CountWays {
	static int count = 0;
	public static boolean canForm(int n){
		if(n == 0 || n == 1 || n == 2 || n == 3 || n == 4 || n == 5 || n == 6)
			return true;
		for(int i = 0; i < 10; i++){
			   //if(count < 10){
		        if( i == 0 | i == 1) i = 2;
		        count++;
				if(canForm(1/i) && canForm(n*i)){
				System.out.println("Divide "+(n*i)+" by "+i);
				
				return true;
				}
			//   }
			    if(i == 0 || i == 1) i=2;
				if(count < 20 && canForm((-1)*i) && canForm(n+i)){
					count ++;
				System.out.println("Subtract "+i+" from "+(n+i));
				return true;
				}
			
			
			if (count < 30 && canForm(i) && canForm(n-i)) {
				count++;
				System.out.println("Add "+i+" with "+(n-i));
				return true;
			}
			
			if(n%i == 0){
				if( i == 0 || i ==1) i =2;
				if(count < 40 &&  i >= 2 && canForm(i) && canForm(n/i)) {
					count++;
					
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
