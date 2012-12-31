package FacebookQuestions;

import java.util.HashMap;

/*
 * Given a number N convert it into the excel column number. 1 will be A, 27 will be AA, 28 AB...
 * 
 */
public class ExcelReverse {
	
	static HashMap<Integer,String> dictMap;
		
	public static void createMap(){
		dictMap = new HashMap<Integer,String>();
		for(int i = 0; i < 26; i++){
			dictMap.put((i+1),(char)('A'+i)+"");
		}
		System.out.println(dictMap.entrySet());
	}
	
	public static String convert(int n){
		String str ="";
		while(n != 0){
			str =dictMap.get(((n-1)%26)+1)+str;
			n = (n-1)/26;
		}
		return str;
	}
	
	public static void main(String[] args) throws Exception{
		createMap();
		System.out.println(convert(18278));
	}
}
