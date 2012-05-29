import java.io.*;
public class PostingListNode implements Serializable {

	long documentID;
	TermFrequency tf;
	
	
	public PostingListNode(long id,TermFrequency tf){
		documentID=id;
		this.tf=tf;
	}
	
	public long getDocumentID(){
		return documentID;
	}
	
	public short getTF(){
		return tf.getTF();
	}
}
