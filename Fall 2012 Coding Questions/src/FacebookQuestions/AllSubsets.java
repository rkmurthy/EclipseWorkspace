package FacebookQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class AllSubsets {

		@SuppressWarnings("unchecked")
		public static ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> set){
			int index = 0;
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			result.add(new ArrayList<Integer>());
			while(index < set.size()){
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
				for(ArrayList<Integer> temp : result){
					ArrayList<Integer> t = (ArrayList<Integer>)temp.clone();
					t.add(set.get(index));
					moreSubsets.add(t);
				}
			result.addAll(moreSubsets);
			index += 1;
			}
			
			return result;
		}
		
		public static void main(String args[]) throws Exception{
			ArrayList<Integer> set = new ArrayList<Integer>();
			int i = 1;
			while(i <= 10){
				set.add(i);
				i++;
			}
			ArrayList<ArrayList<Integer>> result = getSubSets(set);
			System.out.println("All the subsets of the given set: "+Arrays.toString(set.toArray())+" are as follows: ");
			for(ArrayList<Integer> r: result){
				System.out.print(Arrays.toString(r.toArray())+"\n");
			}
		}
}
