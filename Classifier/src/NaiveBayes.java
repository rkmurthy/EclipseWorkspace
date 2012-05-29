import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NaiveBayes {

	public static void main(String args[])throws Exception{
		File f1=new File("training.txt");
		File f2=new File("testdata.txt");
		File f3=new File("stopwords.txt");
		File f4=new File("Output.txt");
		
		ArrayList<String> stopwords = new ArrayList<String>();
		ArrayList<String> uniqueWords=new ArrayList<String>();
		
		HashMap<String,Integer> h1=new HashMap<String,Integer>();//positive
		HashMap<String,Integer> h2=new HashMap<String,Integer>();//negative
		
		FileInputStream fis1=new FileInputStream(f1);
		FileInputStream fis2=new FileInputStream(f3);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(fis1));
		BufferedReader br1=new BufferedReader(new InputStreamReader(fis1));
	    BufferedReader br2=new BufferedReader(new InputStreamReader(fis2));
	    
	    FileOutputStream fos=new FileOutputStream(f4);
	    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos));
	    
	    int totalcount1=0;
		int totalcount2=0;
		
	    String g=br2.readLine();
		while(g!=null){
			
			stopwords.add(g);
			g=br2.readLine();
			
		}
		//stopwords.add(g);
		fis2.close();
		
		String u=br.readLine();
		while(u!=null){
			StringTokenizer st1=new StringTokenizer(u," , ");
			while(st1.hasMoreTokens()){
				String r=st1.nextToken();
				if(!uniqueWords.contains(r) && !stopwords.contains(r))
					uniqueWords.add(r);
			}
			u=br.readLine();
		}
		fis1.close();
	/*	for(String s: stopwords){
			System.out.println(s);
		}
		for(String h:uniqueWords){
			System.out.println(h);
		}*/
		fis1=new FileInputStream(f1);
		br1=new BufferedReader(new InputStreamReader(fis1));
		String j=br1.readLine();
		int category=2;
		int count1=0,count2=0;
		while(j!=null){
			
			StringTokenizer st=new StringTokenizer(j);
			String f=st.nextToken();
			
			if(f.equals("1")||f.equals("0")) category=Integer.parseInt(f);
			if(category==1||category==0)
			{
				if(category==1)count1++;
				else if(category==0)count2++;
			System.out.print("category:"+category);
			while(st.hasMoreTokens()){
				String temp=st.nextToken();
				if(category==1){
				if(h1.containsKey(temp)){
					int count=h1.get(temp);
					h1.put(temp, count+1);
					totalcount1+=1;
				//	count1=count1+1;
				}else{
					h1.put(temp, 1);
					totalcount1+=1;
					
				 }
				
				}else if(category==0){
				if(h2.containsKey(temp)){
					int count=h2.get(temp);
					h2.put(temp, count+1);
					totalcount2+=1;
				}else{
					h2.put(temp, 1);
					totalcount2+=1;
				}
				}
				//temp=st.nextToken();
			}
			j=br1.readLine();
		  }
		}
		
		System.out.println(h1.entrySet());
		System.out.println();
		System.out.println(h2.entrySet());
		System.out.print("Total count for 1:" + totalcount1);
		System.out.println("Total count for 2:"+ totalcount2);
		
		//int termcount1[]=new int[uniqueWords.size()];
		//int termcount2[]=new int[uniqueWords.size()];
		HashMap<String,Float>probin1=new HashMap<String,Float>();
		HashMap<String,Float>probin2=new HashMap<String,Float>();
		
		int y=0;
		while(y<uniqueWords.size()){
			if(h1.containsKey(uniqueWords.get(y))){
				float t=(float)(h1.get(uniqueWords.get(y))+1)/(totalcount1+uniqueWords.size());
				probin1.put(uniqueWords.get(y),t);
			}
			if(h2.containsKey(uniqueWords.get(y))){
				float t=(float)(h2.get(uniqueWords.get(y))+1)/(totalcount2+uniqueWords.size());
				probin2.put(uniqueWords.get(y),t);
			}
			y++;
		}
	
		
	/*	float prob1[]=new float[uniqueWords.size()];
		float prob2[]=new float[uniqueWords.size()];
		
		for(int i=0;i<uniqueWords.size();i++){
			String q=uniqueWords.get(i);
			if(h1.containsKey(q)){
				prob1[i]=(float)(h1.get(uniqueWords.get(i))+1)/(totalcount1+uniqueWords.size());
			}
			if(h2.containsKey(q)){
				prob2[i]=(float)(h2.get(uniqueWords.get(i))+1)/(totalcount2+uniqueWords.size());
			}
			
		}*/
		/*
		 
		  
		  
		 * 
		 */
		//System.out.println(probin1.entrySet());
	//	System.out.println(probin2.entrySet());
		double e=0,f=0;
		/*for(int i=0;i<uniqueWords.size();i++){
			if(probin1.get!=0){
				e+=Math.log(prob1[i]);
			}
		}
		
		for(int i=0;i<uniqueWords.size();i++){
			if(prob2[i]!=0){
				f+=Math.log(prob2[i]);
			}
		}*/
		
	/*	for(String s: uniqueWords){
			if(h1.containsKey(s)){
				
			}
		}
		
		System.out.println("e:"+Math.exp(e));
		System.out.println("f:"+Math.exp(f));*/
		
		
		
		//Now the testing part
		
		fis1=new FileInputStream(f2);
		br1=new BufferedReader(new InputStreamReader(fis1));
		double score1=Math.log(count1/(count1+count2)),score2=Math.log(count2/(count1+count2));
		String line=br1.readLine();
		
		while(line!=null){
			StringTokenizer st3=new StringTokenizer(line);
			while(st3.hasMoreTokens()){
				String h=st3.nextToken();
				if(uniqueWords.contains(h)){
				if(h1.containsKey(h)) score1+=Math.log(h1.get(h));
				if(h2.containsKey(h)) score2+=Math.log(h2.get(h));
				}
			}
			if(score1>score2) bw.write(1);
			else bw.write(0);
			
		}
		
		
		
		bw.close();
		fis1.close();
		fis2.close();
		
		
	}
	
}
