package FacebookQuestions;
/**
 * 
 * @author ramasubramaniankrishnamurthy
 *
 * Given a number , print the english representation of the number in words
 * 
 */
public class DigitsToPhrase {
	String digs[]  = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
	String[] tens = {"Ten", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	String[] teens = {"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	String[] bigs = {"","Thousand","Million"};
	String str = "";
	int count = 0;
	
	
	public String digitsToPhrase(int n){
		//int count = 0;
		if (n == 0) return "Zero";
		if(n < 0) return "Negative"+digitsToPhrase((-1)*n);
		while(n > 0){
			if((n%1000) != 0){
				str = digitsToPhrase100(n%1000)+" "+bigs[count]+" "+ str;
			}
			n = n/1000;
			count ++;
		}
		return str;
	}
	
	public String digitsToPhrase100(int n){
		String str = "";
		if(n == 0) return "Zero";
		if(n >= 100){
			str += digs[(n/100)-1]+" Hundred ";
			n = n%100;
		}
		
		if(n >= 11 && n <= 19){
			str += teens[n-11]+ " ";
			return str;
		}
		else if(n == 10 || n >= 20){
			str += tens[(n/10)-1]+" ";
		    n = n%10;
		}
		if(n >= 1 && n <= 9)
		    str += digs[n-1]+ " ";
		return str;
	}
	
	public static void main(String[] args) throws Exception{
		DigitsToPhrase dtp = new DigitsToPhrase();
		System.out.println(dtp.digitsToPhrase(12341234));
	}
	
}
