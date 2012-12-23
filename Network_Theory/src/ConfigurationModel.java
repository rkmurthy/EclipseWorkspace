//package Networks;

import java.io.*;
import java.util.*;

public class ConfigurationModel {

	HashMap<Integer,ArrayList<Integer>> adjList;
	int n; //Number of nodes in the network
	ArrayList<Integer> stubs;
	
	ConfigurationModel(int no_of_nodes){
		n=no_of_nodes;
		adjList=new HashMap<Integer,ArrayList<Integer>>();
	}
	
	public ArrayList<Integer> createStubs(double p1,double p3){
        
		stubs=new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			if(i<p1*n){
				stubs.add(i);
			}else if(i>=p1*n){
				stubs.add(i);
				stubs.add(i);
				stubs.add(i);
			}
		}
		//System.out.println(stubs.size());
		return stubs;
	}
	
	public ArrayList<Integer> randomShuffleStubs(){
		//Returns a completely random shuffled version of the stubs array
		Random rand=new Random();
		for(int i=0;i<stubs.size();i++){
			int x=rand.nextInt(stubs.size()-i);			
			int temp=stubs.get(i);
			stubs.set(i, stubs.get(x));
			stubs.set(x, temp);			
		}
		//System.out.println(stubs.size());
		return stubs;
	}
	
	public HashMap<Integer,ArrayList<Integer>> populateAdjList(){
		//boolean flag=false;
		//Random rand=new Random();
		for(int i=0;i<stubs.size()-1;i=i+2){
			int x=stubs.get(i);
			int y=stubs.get(i+1);
			//if(x==y)continue;//self-edges are allowed
			
			if(!adjList.containsKey(x)){
				ArrayList list=new ArrayList<Integer>();
				list.add(y);
				adjList.put(x, list);
				list=adjList.get(y);
				if(list!=null /*&& !list.contains(x)*/){
					list.add(x);
					adjList.put(y, list);
				}else if(list==null){
					list=new ArrayList<Integer>();
					list.add(x);
					adjList.put(y, list);
				}
			}
			
			else if(adjList.containsKey(x)){
				ArrayList list=(ArrayList<Integer>)adjList.get(x);
			   /* if(list.contains(y)){
			    	//continue;
			    }else  *///Multiedges are allowed
			    	list.add(y);
			    	adjList.put(x, list);
			    	ArrayList l1=adjList.get(y);
			    	if(l1!=null/* && !l1.contains(x)*/){
			    		l1.add(x);
			    		adjList.put(y, l1);
			    	}if(l1==null){
			    		l1=new ArrayList<Integer>();
			    		l1.add(x);
			    		adjList.put(y, l1);
			    	}			    
				}		 
			}
		return adjList;
	}

	
	
	public int findGiantComponentSize(){
		
		//returns the maximum size of component in the network		
		int max=0;
		int count=0;
		//Keeps track of which nodes have been visited already and which not
		HashSet<Integer> visited=new HashSet<Integer>();		
		for(int i=0;i<n;i++){
			visited.add(i);
		}		
		for(int k=0;k<n;k++){
			if(visited.contains(k)){
			count=0;
			Queue<Integer> q=new LinkedList<Integer>();
			if(adjList.containsKey(k)){
				for(int j:adjList.get(k)){
					q.add(j);
					if(visited.contains(j)){count++;
						visited.remove(j);
					}
					while(!q.isEmpty()){
						int t=q.remove();
						ArrayList<Integer> l=adjList.get(t);
						for(int h:l){
							if(visited.contains(h)){
								visited.remove(h);
								q.add(h);
								count++;
							}
						}
					}
				}			
			}
			if(max<count){
				max=count;
			}
	 
		 }
		}		
	return max;			
	}
	
	
	
	public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter number of nodes: ");
		int n=Integer.parseInt(br.readLine());
		//System.out.println(n);
		ConfigurationModel c=new ConfigurationModel(n);
		c.createStubs(0.6, 0.4);
		c.stubs=c.randomShuffleStubs();
		c.populateAdjList();
		System.out.println("Giant Component Size: "+c.findGiantComponentSize());
		
		//This is part 2
		
		System.out.println("p1"+"\t"+"S");
		for(double i=0;i<=100;i+=1){
			double j=i/100;
			c=new ConfigurationModel(n);
			c.createStubs(j, 1-j);
			c.stubs=c.randomShuffleStubs();
			c.populateAdjList();
			long s=c.findGiantComponentSize();		
			//i+=0.01;
			System.out.println(j+"\t"+(double)s/n);			
		}		
	}
	
}
