package FacebookQuestions;
import java.io.*;
import java.util.*;

public class PasswordCombinations {

	
	static HashMap<String, ArrayList<String>> hmap;
	
	public static void createMap(){
		hmap=new HashMap<String, ArrayList<String>>();
		ArrayList<String> aList=new ArrayList<String>();
		aList.add("@");
		aList.add("-");
		aList.add("$");
		
		hmap.put("a",aList);
		 
		aList=new ArrayList<String>();
		aList.add("*");
		aList.add("&");
		hmap.put("c", aList);
	}
	
	public static ArrayList<String> getResult(String s, int i){
		createMap();
		ArrayList<String> result=new ArrayList<String>();
		if(i<s.length()){
			String key=s.charAt(i)+"";
			System.out.println("key:"+key);
			if(hmap.containsKey(key)){
				for(int j=0;j<hmap.get(key).size();j++){
					s=s.substring(0,i)+hmap.get(key).get(j)+s.substring(i+1);
					System.out.println(s);
					result.add(s);
					getResult(s,i+1);
				}
			}else{
					getResult(s,i+1);
					
				}
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception{
		createMap();
		getResult("Face",0);
	}
}
