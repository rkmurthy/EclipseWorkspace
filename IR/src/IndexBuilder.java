import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.swing.text.Document;
public class IndexBuilder implements java.io.Serializable{
	
	private Properties configSettings;
	private int numberOfDocuments;
	private String inputFileName;
	private ArrayList documentList=new ArrayList();
	
	IndexBuilder(Properties p){
		configSettings=p;
	}
	
	public InvertedIndex build() throws IOException{
		boolean endOfFile=false;
		int offset=0;
		Document d;
		
		InvertedIndex index=new InvertedIndex();
		//index.clear();
		
		inputFileName=configSettings.getProperty("TEXT_FILE");
		String stopWordFileName=configSettings.getProperty("STOPWORD_FILE");
		//TRECParser parser=new TRECParser(inputFileName,stopWordFileName);
		//documentList=parser.readDocuments();
		//index.setDocumentList(documentList);
	    FileInputStream fis=new FileInputStream(inputFileName);
	    InputStreamReader in = new InputStreamReader(fis, "UTF-8");
	    BufferedReader br=new BufferedReader(in);
	    StringTokenizer st=new StringTokenizer(br.readLine());
		Iterator i=documentList.iterator();
		System.out.println("Starting to build the index");
		while(i.hasNext()){
			d=(Document) i.next();
			index.add(d);
		}
		
		index.write(configSettings);
		return index;
		
	}
	public static void main(String args[])throws IOException{
		InvertedIndex II=new InvertedIndex();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter search query");
		String query=br.readLine();
		LinkedList r=II.getPostingList(query);
		System.out.println("Most relevant documents are:");
		for(int i=0;i<r.size();i++)
			System.out.println(r.get(i));
		
	}
	

}
