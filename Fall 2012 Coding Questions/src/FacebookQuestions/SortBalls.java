package FacebookQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
/*
 * There is a bin consisting of green, red, and blue balls. Sort them such in an order that is: green, red and blue.
    Code the solution.

 */
class Color{
	String name;
	
	Color(String name){
		this.name = name;
	}
}

public class SortBalls implements Comparator<Color>{
	static HashMap<String,Integer> ColorMap;
	
	public int compare(Color c1, Color c2){
		String s1= ColorMap.get(c1.name)+"";
		String s2 = ColorMap.get(c2.name)+"";
		return s1.compareTo(s2);
	
	}
	
	public static void createMap(){
		ColorMap = new HashMap<String,Integer>();
		ColorMap.put("green",1);
		ColorMap.put("red", 2);
		ColorMap.put("blue", 3);
	}
	
	public static void main(String[] args){
		createMap();
		SortBalls sb = new SortBalls();
	    Color[] input = {new Color("red"),new Color("blue"),new Color("green")};
	    Arrays.sort(input,sb);
	    for(Color c:input)
	    	System.out.println(c.name+"\t");
	}
	
}
