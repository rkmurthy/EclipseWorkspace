package myJavaProgs;
import java.io.*;
import java.util.*;

public class BinaryTree {
Node root;
public Node addToTree(int[] a,int min,int max){
if(max<min){
	return null;
}
int mid=(min+max)/2;
Node newnode=new Node(a[mid]);
newnode.left=addToTree(a,0,mid-1);
newnode.right=addToTree(a,mid+1,max);
return newnode;
}

public void inorder(Node root){
	Node n=root;
	if(n!=null){
		inorder(n.left);
		System.out.print(n.data+" ");
		inorder(n.right);
	}
}

public Node inorderSuccessor(Node n){
	if(n.right!=null){
		n=n.right;
		while(n.left!=null)
			n=n.left;
		return n;
	}
	
	return null;
}
public static void main(String args[])throws IOException{
	BinaryTree bt=new BinaryTree();
	int a[]={1,2,3,4,5,6,7,8,9,10};
	bt.addToTree(a,0,a.length-1);
	bt.inorder(bt.root);
}
}
