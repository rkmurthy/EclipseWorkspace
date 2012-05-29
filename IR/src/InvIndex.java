import java.io.*;import java.util.*;
public class InvIndex {
	
	HashMap<String,LinkedList<Document>>h;
	
	InvIndex(){
		h=new HashMap<String,LinkedList<Document>>();
	}
	
	public void add(String term,Document d){
		if(!h.containsKey(term)){
			if(!h.get(term).contains(d))
				h.get(term).add(d);
		}
	}

}
