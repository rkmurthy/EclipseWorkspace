package MicrosoftQuestions;

import java.util.ArrayList;
/**
 * This was again a Microsoft On-Site Interview question that I screwed up real bad!!!
 * Could write this code here in like 5 minutes!
 * @author ramasubramaniankrishnamurthy
 *
 */
public class StringSubsets {
	
	public static ArrayList<String> getSubsets(String s){
		if(s == null) return null;
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i < s.length(); i++){
			String str = s.charAt(i)+"";
			if(result.size() == 0)
				result.add(str);
			else{
				ArrayList<String> temp = new ArrayList<String>();
				for(String r:result){
					String x = r+str;
					temp.add(x);
				}
				temp.add(str);
				result.addAll(temp);
			}
		}
		return result;
	}
	
	public static void main(String[] args)throws Exception{
		ArrayList<String> res = getSubsets("ABC");
		for(String r: res)
			System.out.println(r);
	}
}
