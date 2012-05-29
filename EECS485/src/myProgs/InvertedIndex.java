package myProgs;
import java.io.*;
import java.util.*;
import myProgs.Document;
//import javax.swing.text.Document;
public class InvertedIndex {
	
	HashMap<String, LinkedList<Document>> h;
	
	InvertedIndex(){
		h=new HashMap<String,LinkedList<Document>>();
	}
	//add document to inverted index of specific term
	public void add(String object,myProgs.Document d){
		LinkedList<Document>temp;
		if(h.containsKey(object) && !h.get(object).contains(d)){
		 h.get(object).add(d);
		}else if(h.containsKey(object) && h.get(object).contains(d)){
			//do nothing
		}else{
			LinkedList<Document>l=new LinkedList<Document>();
			 l.add(d);
			 h.put(object,l);
		}
	}

	
}
