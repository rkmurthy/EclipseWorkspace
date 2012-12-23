import java.io.*;
public class UniqueStrings {

	public static boolean checkUnique(String s){
		
		int checker=0;
		for(int i=0;i<s.length();i++){
			int val=s.charAt(i)-'a';
			if((checker&(1<<val))>0)
				return false;
			checker|=1<<val;
		}
		return true;
	}
	
	public static String reverseString(String s){
		char[] copy=s.toCharArray();
		int i=0,j=s.length()-1;
		while(i<j){
			char temp = copy[i];
			copy[i] = copy[j];
			copy[j] = temp;
			i++;
			j--;
		}
		s=new String(copy);
		return s;
			
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string");
		String input=br.readLine();
		System.out.println("This string has all unique characters: "+checkUnique(input));
		System.out.println("Reversed String: "+reverseString(input));
	}
}
