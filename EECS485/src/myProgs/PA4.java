package myProgs;
import java.io.*;
import java.util.*;
public class PA4 {

	public static void main(String args[])throws IOException{
		InvertedIndex ii=new InvertedIndex();
		FileInputStream fis=new FileInputStream("Captions");
		InputStreamReader in=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(in);
		Document d[]=new Document[203];
		
		for(int i=0;i<203;i++){
			String term=br.readLine();
			d[i]=new Document(term);
			d[i].docID=(i+1);
			StringTokenizer st=new StringTokenizer(term);
			while(st.hasMoreElements()){
				String h=(String)st.nextElement();
				ii.add(h, d[i]);
			}
		}
		
		BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter query term");
		String query=br2.readLine();
		if(ii.h.containsKey(query)){
			LinkedList<myProgs.Document>f=new LinkedList<myProgs.Document>();
			f=ii.h.get(query);
			//Now rank the documents
			LinkedList<myProgs.Document>n=new LinkedList<Document>();
			for(int i=0;i<f.size();i++){
				int max=(Integer)f.get(i).hm.get(query);
				int pos=i;
				for(int j=i+1;j<f.size();j++){
					if((Integer)f.get(j).hm.get(query) > max){
						max=(Integer)f.get(j).hm.get(query);
						pos=j;
					}
				}
			
			//	n.add(f.get(pos));
				Document d1=f.get(i);
				f.set(i,f.get(pos));
				f.set(pos,d1);
				
			}
		     int k=0;
		    while(k< f.size()){
			System.out.println(f.get(k).docID);
			k++;
		   }
	}
}
}
