package MicrosoftQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class  FindCommonArrayElements {
	public static ArrayList<Integer> findCommon(ArrayList<Integer> x, ArrayList<Integer> y) throws Exception{
		if(x.size() == 0 || y.size() == 0) throw new Exception("Invalid Inputs!");
			ArrayList<Integer> result = new ArrayList<Integer>();
			Arrays.sort(x.toArray());
			Arrays.sort(y.toArray());
	
			int i = 0, j = 0;
			while(i < x.size() && j < y.size()){
				if(x.get(i) < y.get(j)){
					if(i < x.size()-1) i++;
					else return result;
			}
				else if(x.get(i) > y.get(j)) {
					if(j < y.size()-1)	j++;
					else return result;
				}
				else{
					result.add(x.get(i));	
					i++;
					j++;
				}
	}
	return result;
	/**
	 * This is an O(nlogn+mlogm) solution. Another solution could have been to sort the smaller array and then
	 * do a binary search on the longer array for each element. This gives us complexity of m(logm+logn)
	 */
}


public static void main(String[] args)throws Exception{
	ArrayList<Integer> x = new ArrayList<Integer>();
	for(int i = 0; i < 10; i++)
		x.add(i+1);
	ArrayList<Integer> y = new ArrayList<Integer>();
	for(int i = 1; i < 10; i++)
		y.add(2*i);
	ArrayList<Integer> res = findCommon(x,y);
	for(Integer x1:res)
		System.out.print(x1+"\t");
}
}
