package myJavaProgs;
import java.io.*;
public class factorial {

	public static double fact(double n){
		if(n==0 ||n==1)return 1;
		return n*fact(n-1);
	}
	
	public static void main(String a[])throws IOException{
		
		System.out.println("Enter number");
		BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
		double n=Double.parseDouble(b.readLine());
		System.out.println("Factorial is "+fact(n));
	}
}
