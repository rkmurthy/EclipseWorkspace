package FacebookQuestions;
/*
 * This is similar to producing all the subsets of a given set
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Combinations {
    	@SuppressWarnings("unchecked")
		public static ArrayList<ArrayList<String>> getCombinations(String s)throws Exception{
    		if( s == null )
    			throw new Exception("Invalid String");
    		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    		result.add(new ArrayList<String>());
			
    		if(s.length()  == 0){
    			return result;
    		}
    		int index = 0;
    		while(index < s.length()){
    				ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
    				for(ArrayList<String> r: result){
    			        ArrayList<String> tempClone = (ArrayList<String>)r.clone();
    			        tempClone.add(s.charAt(index)+"");
    			        temp.add(tempClone);
    				}
    			result.addAll(temp);
    			index +=1;
    		}
    		
    		return result;	
    	}
    	
    	public static void main(String[] args) throws Exception{
    		ArrayList<ArrayList<String>> result = getCombinations("wxyz");
    		for(ArrayList<String> r: result)
    			if(r.size() != 0)
    				System.out.println(Arrays.toString(r.toArray()));
    		
    	}
}
