package FacebookQuestions;

import java.io.*;
import java.util.*;

public class PhoneNumber {

static HashMap<Integer,ArrayList<String>> charKey;

public static void setCharKey(){
	charKey=new HashMap<Integer,ArrayList<String>>();
	ArrayList<String> a=new ArrayList<String>();
	a.add("A");
	a.add("B");
	a.add("C");
	charKey.put(2, a);
	a=new ArrayList<String>();
	a.add("D");
	a.add("E");
	a.add("F");
	charKey.put(3,a);
	a=new ArrayList<String>();
	a.add("G");
	a.add("H");
	a.add("I");
	charKey.put(4,a);
	a=new ArrayList<String>();
	a.add("J");
	a.add("K");
	a.add("L");
	charKey.put(5,a);
	a=new ArrayList<String>();
	a.add("M");
	a.add("N");
	a.add("O");
	charKey.put(6,a);
	a=new ArrayList<String>();
	a.add("P");
	a.add("Q");
	a.add("R");
	a.add("S");
	charKey.put(7,a);
	a=new ArrayList<String>();
	a.add("T");
	a.add("U");
	a.add("V");
	charKey.put(8,a);
	a=new ArrayList<String>();
	a.add("W");
	a.add("X");
	a.add("Y");
	a.add("Z");
	charKey.put(9,a);	
}

public static String getCharKey(int i, int offset){
	return charKey.get(i).get(offset);
}
	
public static ArrayList<String> printTelephoneWords(int phoneNumber[]){
	//734-730-7190
	ArrayList<String> result=new ArrayList<String>();
	
	
	
	
	return result;
	
	
}

public static void main(String args[])throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	System.out.println("Enter digits in telephone number");
	int n=Integer.parseInt(br.readLine());
	int[] phonenumber=new int[n];
	System.out.println("Enter telephone number");
	
	for(int i=0;i<n;i++){
		phonenumber[i]=Integer.parseInt(br.readLine());
	}
	
	printTelephoneWords(phonenumber);
	
	
}

}
