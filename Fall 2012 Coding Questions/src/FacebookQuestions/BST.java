package FacebookQuestions;

import java.io.*;
import java.util.*;

class Node{
	
	int value;
	Node left;
	Node right;
	
	Node(){
		
	}
	
	Node(int value){
		this.value=value;
		left=null;
		right=null;
	}
}

class BST{
	
	Node root;
	
	BST(){
		root=null;
	}
	
	public void insert(int value){
		if(root==null){
			root=new Node(value);
		}else{
			Node x=root,y=root;
			
            Node newnode=new Node(value);
			
            while(x!=null){
            	y=x;
				if(x.value>value){
					x=x.left;
				
				}else{
					x=x.right;
				}
			}
            if(x==null){
            	if(y.value>value){
            		y.left=newnode;
            	}else{
            		y.right=newnode;
            	}
            }
		}
	}
	
	public void inorder(Node root)
	{
		if(root!=null){
			inorder(root.left);
			System.out.println(root.value);
			inorder(root.right);
		}
	}
	
	public int findkthlargest(Node root,ArrayList l,int k){
		
			if(root!=null){
				findkthlargest(root.left,l,k);
				System.out.println("root.value:"+root.value);
				l.add(root.value);
				System.out.println(l.size());
				findkthlargest(root.right,l,k);
			}
			if(l.size()>=k)
				return (Integer)l.get(k-1);
			return -1;
		
	}
	
	public void levelTraversal(Node root){
		
		//Level Order Traversal of a Binary Tree
		Queue<Node> q=new LinkedList<Node>();
			if(root!=null){
				q.add(root);
				q.add(null);
				while(!q.isEmpty()){
					Node x=q.remove();
					if(x!=null){
						System.out.print(x.value+"\t");
						if(x.left!=null) 
							q.add(x.left);
						if(x.right!=null)
							q.add(x.right);
					}else{
						if(!q.isEmpty()) q.add(null);
						System.out.println();
					}
				}
		}
	}
	
	//Following is the function that converts the given BST to a Doubly-Circular Linked List
	
	public static void inorder_dcll(Node parent, Node first, Node last){
		if(parent.left==null)
			first=parent;
		else{
			Node tmpLast=null;
			inorder_dcll(parent.left,first,tmpLast);
			parent.left=tmpLast;
			if(tmpLast!=null)tmpLast.right=parent;
		}
		if(parent.right==null)
			last=parent;
		else{
			Node tmpFirst=null;
			inorder_dcll(parent.right,tmpFirst,last);
			parent.right=tmpFirst;
			if(tmpFirst!=null)tmpFirst.left=parent;
		}
	}
	
	public static Node treeToList(Node root){
		if(root==null) return null;
		Node first=null;
		Node last=null;
		inorder_dcll(root,first,last);
		if(first!=null)first.left=last;
		if(last!=null)last.right=first;
		return first;
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BST bst=new BST();
		BST bst_dcll=new BST();//For the DCLL conversion
		int a[]={50,40,60,70,30,20,35,10,80,65,75};
		for(int i:a){
			bst.insert(i);
		}
		for(int i:a){
			bst_dcll.insert(i);
		}
		
		bst.inorder(bst.root);
		bst.levelTraversal(bst.root);
		ArrayList<Integer> l=new ArrayList<Integer>();
		System.out.println("Enter value for k");
		int k=Integer.parseInt(br.readLine());
		System.out.println("Kth largest:"+bst.findkthlargest(bst.root, l,k));
		
		System.out.println("Cnverting BST to DCLL");
		Node first=treeToList(bst_dcll.root);
		Node x=first;
		int i=0;
		while(i<a.length){
			if(x!=null){
			System.out.print(x.value+"\t");
			x=x.right;
			}
			i++;
		}
		//System.out.print(x.value);
		
		System.out.println("Printing clone of given BST");
		Node root_Copy=clone(bst.root);
		bst.inorder(root_Copy);
	}
	
	
	public static Node clone(Node root){
		//Return root of a clone of the given tree
		if(root==null) return null;
		HashMap<Node,Node> hmap=new HashMap<Node, Node>();
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		Node root_Copy=new Node(root.value);
		//ArrayList<Node> list=new ArrayList<Node>();
		//list.add(root_Copy);
		hmap.put(root,root_Copy);
		while(!q.isEmpty()){
			Node node=q.remove();
			if(hmap.containsKey(node)){
				//if node has been visted once before
				hmap.get(node).left=hmap.get(node.left);
				hmap.get(node).right=hmap.get(node.right);
			}else{
				Node copy=new Node(node.value);
				hmap.put(node, copy);
				copy.left=hmap.get(node.left);
				copy.right=hmap.get(node.right);
				q.add(copy);
			}
		}
		return root_Copy;
		
	}
}
	
	

