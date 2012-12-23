import java.io.*;
import java.util.*;


class BFS {
	
	ArrayList<ArrayList<Integer>> adjList;
	ArrayList<Integer> degrees;
	ArrayList<Integer> distances;
	
	public void setInitialDistances(){
		distances=new ArrayList<Integer>();
		for(int i=0;i<22963;i++){
			distances.add(i,-1);
		}
	}

	public void readFile()throws IOException{
		FileInputStream fis=new FileInputStream("internet.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		adjList=new ArrayList<ArrayList<Integer>>();
		degrees=new ArrayList<Integer>();
		String s="";
		while((s=br.readLine())!=null){
			ArrayList<Integer> t=new ArrayList<Integer>();
			String temp[]=s.split("\\s+");
			degrees.add(Integer.parseInt(temp[1]));
			for(int k=2;k<temp.length;k++){
				t.add(Integer.parseInt(temp[k]));
			}
			adjList.add(Integer.parseInt(temp[0]),t);
		}
	}
	
	public void findCentrality(){
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(0);
		distances.set(0, 0);
		while(!q.isEmpty()){
			int k=q.remove();
			int level = distances.get(k);
			ArrayList<Integer> temp=adjList.get(k);
			for(int l=0;l<temp.size();l++){
				int i=temp.get(l);
				if(distances.get(i)==-1){
					q.add(i);
					distances.set(i, level+1);
				}else{
					//do nothing
				}
			}
		}
		//Find the degree centrality
		
		float degreeCent=0;
		float sum=0;
		for(int i=0;i<22963;i++){
			sum+=distances.get(i);
		}
		degreeCent=sum/22963;
		System.out.println("Closeness Centrality of vertex 0 is: "+degreeCent);		
	}
}

public class Cmplxsys{
	
	public static void main(String[] args)throws IOException{
		BFS b=new BFS();
		b.setInitialDistances();
		b.readFile();
		b.findCentrality();
	}
}

/*-----------------------------------------------------------
 * Output:
 * Closeness Centrality of vertex 0 is: 2.71036
 * 
 * 
 * 
-------------------------------------------------------------*/