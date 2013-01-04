package AmazonQ;

public class SentenceReverse {

	public static void swap(char[] c, int i, int j){
		char temp = c[i];
		c[i] = c[c.length-1-i];
		c[c.length-1-i] = temp;
	}
	
	public static String reverse(String s){
		// s is a sentence
		char c[] = s.toCharArray();
		for(int i = 0; i < s.length()/2; i++)
			swap(c,i,s.length()-1-i);
		
	   String str = new String(c);
	   int i = 0;
	   int j = 0;
	   c = str.toCharArray();
	   while(j < c.length){
		   while(j < c.length && c[j] != ' ') j++;
		   if( j< c.length && c[j] == ' '){
			   int x = j;
			   
			   while(i < x){
				   System.out.println(i+"\t"+x);
				   swap(c,i,x);
				   i++;
				   x--;
			   }
			   i = j+1;
			   j = j+1;
		   }
		   j++;
	   }
	   return new String(c);
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(reverse("Hello World!!!"));
	}
}
