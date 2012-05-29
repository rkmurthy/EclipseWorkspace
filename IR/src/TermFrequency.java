import java.io.*;
public class TermFrequency implements Serializable{

	private static final short MAX_VALUE=32767;
	
	short tf;
	
	public TermFrequency(){
		tf=1;
	}
	
	public void increment(){
		if(tf<=MAX_VALUE){
			tf=(short)(tf+1);
		}
	}
	
	public void Set(short value){
		tf=value;
	}
	
	public short getTF(){
		return tf;
	}
}
