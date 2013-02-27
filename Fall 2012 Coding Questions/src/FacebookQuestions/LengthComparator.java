package FacebookQuestions;

import java.util.Arrays;
import java.util.Comparator;

public class LengthComparator implements Comparator<String> {

	public int compare(String s1, String s2){
		String l1 = s1.length()+"";
		String l2 = s2.length()+"";
		return  l2.compareTo(l1);
		
	}
	
	public static void main(String[] args) throws Exception{
		String[] a = {"Hi","Hello","HowAreYou","Today?"};
		Arrays.sort(a,new LengthComparator());
		System.out.println(Arrays.toString(a));
	}
}
