import java.util.ArrayList;


public class Permutations {
		public static ArrayList<String> getPerms(String s)throws Exception{
			if(s == null)
				return null;
			ArrayList<String> result = new ArrayList<String>();
			if(s.length() == 0){
				result.add("");
			    return result;
			}
			char c = s.charAt(0);
			String sub = s.substring(1);
			ArrayList<String> perms = getPerms(sub);
			
			for(String p: perms){
				for(int i = 0; i <= p.length(); i++){
					String s1 = insertCharAt(p,c,i);
				    result.add(s1);
				}
			}
			return result;
		}
		
		public static String insertCharAt(String s, char c, int i){
			String first  = s.substring(0,i);
			String last = s.substring(i);
			return first+c+last;
		}
		
		public static void main(String[] args)throws Exception{
		  ArrayList<String> result = getPerms("abcd");
		  for(String r:result)
			  System.out.println(r.toCharArray());
		  
		}
}
