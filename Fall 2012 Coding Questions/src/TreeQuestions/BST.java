package TreeQuestions;

/**
 * Do not run BST to DCLL and findCommonAncestor together or change their order in the code and make 
 * DCLL execute last because this changes the structure of the BST
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class NodePair{
	Node head;
	Node tail;
	
	public NodePair(Node head, Node tail){
		this.head = head;
		this.tail = tail;
	}
}

class Node{
	int value;
	Node left;
	Node right;
	
	Node(){
		value = 0;
		left = null;
		right = null;
	}
	
	Node(int value){
		this.value = value;
		left = null;
		right = null;
	}
}
public class BST {
	Node root;
	
	public void insert(int value){
		Node newnode = new Node(value);
		if(root == null)
		  root = newnode;
		else{
			Node x = root,y = root;
			while(x!=null){
				y = x;
				if(x.value > value)
					x = x.left;
				else
					x = x.right;
			}
			if( y.value > value)
				y.left = newnode;
			else
				y.right = newnode;
		}
	}
	
	public void inorder(Node root){
	   if(root != null){
		   inorder(root.left);
		   System.out.print(root.value+"\t");
		   inorder(root.right);
	   }
	 }
	
	public void preorder(Node root){
		if(root != null){
			System.out.print(root.value+"\t");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void postorder(Node root){
		//Least useful of all
		if(root != null){
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.value+"\t");
		}
	}
	
	public void DFS(Node root){
		System.out.println("DFS Traversal of Tree");
		
		if(root != null){
			Stack<Node> stack = new Stack<Node>();
			stack.push(root);
			while(!stack.isEmpty()){
				Node x = stack.pop();
				System.out.print(x.value+"\t");
				if(x.right != null) stack.push(x.right);
				if(x.left != null) stack.push(x.left);
			}
		}
		
	}
	
	public void BFS(Node root){
		System.out.println("BFS Traversal of Tree");
		
		if(root != null){
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			while(!q.isEmpty()){
				Node x = q.remove();
				System.out.print(x.value+"\t");
				if(x.left != null) q.add(x.left);
				if(x.right != null) q.add(x.right);
			}
		}
	}
	
	public static int findCommonAncestor(Node root, int x, int y)throws Exception{
		//if(root ==  null) throw new Exception("Root is null");
		Node n = root;
		while(n != null){
			if(n.value < x && n.value < y){
				n = n.right;
			}else if(n.value > x && n.value > y){
				n = n.left;
			}else
				return n.value;
		}
		throw new Exception("No Common Ancestor Found for "+x+" "+y);
	}
	
	
	public void LevelTraversal(Node root){
		/*
		 * Prints a level by level representation of the tree
		 */
		System.out.println("Level By Level Traversal is as follows:");
		if(root != null){
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			q.add(null);
			while(!q.isEmpty()){
				Node x = q.remove();
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
	
	public static boolean checkBST(Node root, int min, int max)throws Exception{
		//Hint: Try putting the if statement inside the return statement
		//Explain why this doesnt work although it seems intuitive
		
		if(root != null){
		if(root.value > min && root.value < max)
			return(checkBST(root.left, min, root.value) 
						&& checkBST(root.right,root.value,max));
		}
	     return true;
		//	throw new Exception("Root is null");
	}
	
	public static int getMin(Node root)throws Exception{
		Node x = root;
		if(x != null){
			while(x.left != null)
				x = x.left;
			return x.value;
		}
		
		throw new Exception("root is null");
	}
	
	public static int getMax(Node root)throws Exception{
		Node x = root;
		if(x != null){
			while(x.right != null)
				x = x.right;
			return x.value;
		}
		throw new Exception("root is null");
	}
	
	public static int getMaxHeight(Node root){
		if(root == null) return 0;
		return 1 + Math.max(getMaxHeight(root.left),getMaxHeight(root.right));
	}
	
	public static boolean isBalanced(Node root){
		if(root == null) return true;
		int left = getMaxHeight(root.left);
		int right = getMaxHeight(root.right);
		System.out.println("Left and Right Height Difference: "+Math.abs(left-right));
		return (Math.abs(left-right) > 1)? false:true;
	}
	
	public static Node deepClone(Node root){
		//Create a new BST that is identical to this BST rooted at root
		HashMap <Node, Node> cloneMap = new HashMap<Node,Node>();//maps a node to its clone
		Node root_copy = new Node(root.value);
		cloneMap.put(root,root_copy);
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node copy = new Node();
			Node x = q.remove();
			if(cloneMap.get(x) ==  null){
				copy = new Node(x.value);
				cloneMap.put(x, copy);
			}else{
				copy = cloneMap.get(x);
			}
				if(x.left != null){
					q.add(x.left);
					if(cloneMap.get(x.left)!=null) copy.left = cloneMap.get(x.left);
					else{
						cloneMap.put(x.left, new Node(x.left.value));
						copy.left = cloneMap.get(x.left);
					}
				}
				if(x.right != null){
					q.add(x.right);
					if(cloneMap.get(x.right)!=null) copy.right = cloneMap.get(x.right);
					else{
						cloneMap.put(x.right, new Node(x.right.value));
						copy.right = cloneMap.get(x.right);
					}
				}
			//System.out.println(q.toString());
		}
		return root_copy;
	}
	
	public NodePair convert(Node root){
		if(root == null) return null;
		
		NodePair part1 = convert(root.left);
		NodePair part2 = convert(root.right);
		
		if(part1 != null)
			concat(part1.tail,root);
		
		if(part2 != null)
			concat(root,part2.head);
		
		return new NodePair(part1 == null ? root : part1.head, part2 == null ? root : part2.tail);
	}
	
	public static void concat(Node x, Node y){
		x.right = y;
		y.left = x;
	}
	static int index = -1;
	static int[] inorder;
	
	public static void getNodeWithRank(Node root, int rank){
		if(root != null){
			getNodeWithRank(root.left,rank);
			++index;
			if(index == rank-1) System.out.println(root.value);
			//System.out.println(Arrays.toString(inorder));
			
			getNodeWithRank(root.right,rank);
		}
		
	
		return ;
	}
	
	public static void printAllPaths(Node root,List<Node> list){
		if(root == null) return;
		list.add(root);
		printAllPaths(root.left,list);
		if(root.left == null){
			for(Node l:list)
				System.out.print(l.value+"\t");
			System.out.println();
		}
		
		printAllPaths(root.right,list);
		list.remove(list.size()-1);
	}
	
    public static Node createMinimalBST(int [] a, int start, int end){
    	if(end < start || a.length == 0 || start < 0 || end > a.length)
    		return null;
    	Arrays.sort(a);
    	int mid = (start+end)/2;
    	Node n = new Node(a[mid]);
    	n.left = createMinimalBST(a,start,mid-1);
    	n. right = createMinimalBST(a,mid+1,end);
    	return n;
    }
    
    static int value  = Integer.MIN_VALUE;
    public static boolean checkBST1(Node root){
    	if(root != null){
    		if(!checkBST1(root.left)) return false;
    		if(root.value < value) return false;
    			value = root.value;
    			//System.out.print(value+"\t");
    		if(!checkBST1(root.right)) return false;
    	}	
        return true;
    }
	
	
	
	public static void main(String[] args)throws Exception{
		
		BST bst = new BST();
		int[] a = {60,40,50,20,30,10,70,80,65,75};
		inorder=new int[a.length];
		for(Integer i: a)
			bst.insert(i);
		bst.inorder(bst.root);
		int min = getMin(bst.root);
		int max = getMax(bst.root) ;
		System.out.println();
		System.out.println("Min: "+min);
		System.out.println("Max: "+max);
		System.out.println("Check BST?: "+checkBST(bst.root,min,max));
		System.out.println("Maximum Height: "+getMaxHeight(bst.root));
		System.out.println("IS Balanced? :"+isBalanced(bst.root));
		Node root_copy = deepClone(bst.root);
		System.out.println("Deep Cloned Copy is as follows: ");
		bst.inorder(root_copy);
		System.out.println();
		bst.LevelTraversal(bst.root);
		System.out.println("----------------------------------------------------------------");
		System.out.println("Find common ancestor:\n--------------------------------------------");
		System.out.println(findCommonAncestor(bst.root,20,50));
		System.out.println("----------------------------------------------------------------");
		/*System.out.println("Converting BST to DCLL");
		NodePair result = bst.convert(bst.root);
		Node x = null;
		for (x = result.head; x!= result.tail;x = x.right)
			   System.out.print(x.value+"<=>");
		System.out.print(x.value);*/
		System.out.println();
        int rank = 5;
		   getNodeWithRank(bst.root,rank);
		 //  System.out.println("Node with rank "+rank+" is: "+x);
		   System.out.println("Printing All Paths from Root to leaves: ");
		ArrayList<Node> list = new ArrayList<Node>();
		printAllPaths(bst.root,list);
		System.out.println("-------------------------------------------------");
		System.out.println("Created Minimal BST");
		Node root2 = createMinimalBST(a,0,a.length-1);
		bst.inorder(root2);
		System.out.println("\n-------------------------------------------------");
		System.out.println(checkBST1(root2));
	}

}
