package FacebookQuestions;

import java.util.HashMap;

/*
 * You have a string of characters having numbers from 0 to 999.
Each number is represented by three chars, e.g. "000001002....999"

Find if all the numbers from 0 to 999 are present in the list.
Code it.
 */
public class Paritosh3_1 {
	
	static HashMap<Integer,Boolean> numbers;
	static String input;
	
	public static void createInput(){
		input = new String();
		for(int i = 0; i < 1000; i++){
			if(i < 10){
				input += "00"+i;
			}else if(i >=10 && i < 100){
				input +="0"+i;
			}else{
				if(i != 200)input += i+"";
			}
		}
		System.out.println("Input:"+input);
	}
	
	public static  void createNumbers(){
		numbers = new HashMap<Integer,Boolean>();
		for(int i = 0; i < 1000; i++){
			if(i < 10){
				numbers.put(Integer.parseInt("00"+i),false);
			}else if(i >=10 && i < 100){
				numbers.put(Integer.parseInt("0"+i),false);
			}else{
				numbers.put(Integer.parseInt(i+""),false);
			}
		}
		System.out.println(numbers.toString());
	}
	
	public static void main(String[] args)throws Exception{
		createInput();
		for(int i = 0; i <= input.length()-3; i += 3){
			String s1 = input.substring(i,i+3);
			String s2 = input.substring(i+3,i+6);
			Integer x = Integer.parseInt(s1);
			Integer y = Integer.parseInt(s2);
			if((y-x) != 1){
				System.out.println("Missing Number:"+(x+1));
			    break;
	    	}
	   }
	}
}


