package myJavaProgs;
import java.io.*;
import java.util.*;
public class subsets {

	 ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set,int index){
		ArrayList<ArrayList<Integer>> allsubsets;
		if(set.size()==index){
			allsubsets=new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}else{
			allsubsets=getSubsets(set,index+1);
			int item=set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets=new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset:allsubsets){
				ArrayList<Integer> newsubset=new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
	
	public static void main(String[] args)throws IOException{
		subsets s=new subsets();
		ArrayList<Integer> a =new ArrayList<Integer>();
		for(int i=10;i<=100;i=i+10)
			a.add(i);
		s.getSubsets(a,2);
	}
}
