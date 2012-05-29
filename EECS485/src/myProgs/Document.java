package myProgs;
import java.util.HashMap;
import java.util.StringTokenizer;
public class Document {

	int docID;
	HashMap hm;
	
	Document(String t){
		//this.docID=++docID;
		hm=new HashMap<String,Integer>();
		StringTokenizer st=new StringTokenizer(t);
		while(st.hasMoreElements()){
			String g=st.nextToken();
			if(!hm.containsKey(g)){
				hm.put(g, 1);
			}else{
				int count=(Integer) hm.get(g);
				count=count+1;
				hm.put(g, count);
			}
		}
	}
}
