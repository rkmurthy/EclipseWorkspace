import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.text.Document;
//import SimpleStreamTokenizer;
public class InvertedIndex implements java.io.Serializable{
	
	private HashMap index;
	private ArrayList documentList;
	
	InvertedIndex(){
		index=new HashMap();
		documentList=new ArrayList();
	}
	
	public void add(Document d){
		String token;
		TermFrequency tf;
		Set termSet;
		LinkedList postingList;
		HashMap terms=new HashMap();
		Integer documentFrequency;
		int df;
		
		long docID=d.getDocumentID();
		//terms=d.getTerms();
		FileInputStream fis=new FileInputStream(inputFileName);
	    InputStreamReader in = new InputStreamReader(fis, "UTF-8");
	    BufferedReader br=new BufferedReader(in);
	    StringTokenizer i=new StringTokenizer(br.readLine());
		//termSet=terms.keySet();
		//Iterator i=termSet.iterator();
		
		while(i.hasMoreElements()){
			token=(String) i.nextToken();
			
			if(index.containsKey(token)){
				postingList=(LinkedList)index.get(token);
			}else{
				postingList=new LinkedList();
				index.put(token, postingList);
			}
			
			tf=(TermFrequency) terms.get(token);
			PostingListNode currentNode=new PostingListNode(docID,tf);
			postingList.add(currentNode);
		}
		
	}
	
	public LinkedList getPostingList(String token){
		LinkedList result=new LinkedList();
		
		if(index.containsKey(token)){
			result=(LinkedList) index.get(token);
		}else{
			result=null;
		}
	return result;
	}

	public void write(Properties configSettings){
		FileOutputStream ostream=null;
		ObjectOutputStream p=null;
		
		String outputFile=configSettings.getProperty("INDEX_FILE");
		try{
			ostream=new FileOutputStream(outputFile);
			p=new ObjectOutputStream(ostream);
		}
		
		catch(Exception e){
			System.out.println("Can't open output file");
			e.printStackTrace();
		}
		
		try{
			p.writeObject(this);
			p.flush();
			p.close();
			System.out.println("Inverted index written to file ==>"+ outputFile);
		}
		catch(Exception e){
			System.out.println("Can't write output file");
			e.printStackTrace();
		}
	}
}
