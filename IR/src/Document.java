import java.util.*;
import java.io.*;
public class Document{
	
	int docID;
	HashMap<String,Integer> h;
	//int termFrequency;
	
	Document(String t,InvIndex I){
		h=new HashMap<String,Integer>();
		//FileInputStream fis=new FileInputStream(t);
		//InputStreamReader in=new InputStreamReader(fis);
		//BufferedReader br=new BufferedReader(in);
		//String temp=br.readLine();
		StringTokenizer st=new StringTokenizer(t);
		while(st.hasMoreElements()){
			String g=st.nextToken();
			if(!h.containsKey(g)){
				h.put(g, 1);
			}
			else{
				int c=h.get(g);
				h.put(g, ++c);
			}
		
		I.add(g, this);
		}
	}
	
	public int getDocID(){
		return docID;
	}
	
	

}
