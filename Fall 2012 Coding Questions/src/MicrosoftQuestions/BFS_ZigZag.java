package MicrosoftQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//import TreeQuestions.Node;

class NodeBT{
	int value;
	NodeBT left;
	NodeBT right;
	
	NodeBT(){
		value = -1;
		left = null;
		right = null;
	}
	
	NodeBT(int value){
		this.value = value;
		left = null;
		right = null;
	}
}

public class BFS_ZigZag {

	/**This was a Microsoft On-Site Interview Question which I screwed up badly */
	
	public static NodeBT createMinBST(int array[],int start, int end){
		if(end < start) return null;
		
		int mid = (start+end)/2;
		NodeBT root = new NodeBT(array[mid]);
		root.left = createMinBST(array,start,mid-1);
		root.right = createMinBST(array,mid+1,end);
		return root;
	}
	
	public static void LevelTraversal(NodeBT root){
		/*
		 * Prints a level by level representation of the tree
		 */
		System.out.println("Level By Level Traversal is as follows:");
		if(root != null){
			Queue<NodeBT> q = new LinkedList<NodeBT>();
			q.add(root);
			q.add(null);
			while(!q.isEmpty()){
				NodeBT x = q.remove();
				if(x != null){
					System.out.print(x.value+"\t");
					if(x.left != null) q.add(x.left);
					if(x.right != null) q.add(x.right);
				}else{
					/*This is a very important condition
					else you may keep on adding null values to an empty list 
					thus getting stuck in an infinite loop*/
					if(!q.isEmpty()) q.add(null);
					System.out.println();
				}
			}
		}
	}
	
	public static void zigzagTraversal(NodeBT root){
		if(root == null ) return;
		ArrayList<NodeBT> buf1 = new ArrayList<NodeBT>();
		buf1.add(root);
		ArrayList<NodeBT> buf2 = new ArrayList<NodeBT>();
		int  i = 0;
		do{
			for(NodeBT x:buf1){
			System.out.print(x.value+"\t");
			//buf1.remove(x);
			if(x.right != null)buf2.add(x.right);
			if(x.left != null)buf2.add(x.left);
		  }
			buf1 = new ArrayList<NodeBT>();
			System.out.println();
			
		    for(NodeBT y:buf2){
		    	System.out.print(y.value+"\t");
		    	//buf2.remove(y);
		    	if(y.right != null)buf1.add(y.right);
		    	if(y.left != null)buf1.add(y.left);
		    }
		    buf2 = new ArrayList<NodeBT>();
			System.out.println();
			
		   i++;
		}while(!buf1.isEmpty());
	}
	
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7,8,9};
		NodeBT root = createMinBST(a,0,a.length-1);
		LevelTraversal(root);
		
		zigzagTraversal(root);
	}
}
