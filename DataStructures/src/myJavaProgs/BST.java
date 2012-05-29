package myJavaProgs;
import java.io.*;
import java.util.*;
class Node{
    int data;
	Node left;
	Node right;
	public Node(int d){
	data=d;
	left=null;
	right=null;
   }
}
public class BST{
	Node root;
	Node x,y;
	public void insert(int d){
	if(root==null){
		root=new Node(d);
	}else{
		Node newnode=new Node(d);
		x=root;
		while(x!=null){
			 y=x;//y points to the parent of x
			if(d<x.data)
				x=x.left;
			else
				x=x.right;
		}
		if(d<y.data)
			y.left=new Node(d);
		else 
			y.right=new Node(d);
		
	 }
	}
	
	public  boolean checkBST(Node root,int min,int max){
	if(root==null)return true;
	Node n=root;
	if(n!=null){
		if(n.data<min||n.data>max){
			return false;
		}
		if(checkBST(n.left,min,n.data)&&checkBST(n.right,n.data,max)){
			return true;
		}
		
	}
	return false;
	}
	
	public void inorder(Node root){
		Node n=root;
		if(n!=null){
			inorder(n.left);
			System.out.print(n.data+" ");
			inorder(n.right);
		}
	}
	
 public  int maxDepth(Node root) {
 if (root == null) {
 return 0;
 }
 return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
 }

 public  int minDepth(Node root) {
 if (root == null) {
 return 0;
 }
 return 1 + Math.min(minDepth(root.left), minDepth(root.right));
 }

 public  boolean isBalanced(Node root){
 return (maxDepth(root) - minDepth(root) <= 1);
 }
	 
	public static void main(String args[])throws IOException{
		BST bst=new BST();
		int a[]={10,8,15,4,9,12,19};
		for(int i=0;i<a.length;i++){
			bst.insert(a[i]);
		}
		System.out.println("Binary Search Tree?"+bst.checkBST(bst.root,-1000,1000));
		System.out.println("Inorder Traversal of List:");
		bst.inorder(bst.root);
		System.out.println("\nTree Balanced?"+bst.isBalanced(bst.root));
	}
}