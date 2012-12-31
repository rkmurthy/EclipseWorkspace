package FacebookQuestions;

public class MinimalBST {

	
	public static Node createMinimalBST(int[] array, int start, int end){
		Node root = new Node();
		if(start <= end){
			int mid = (start+end)/2;
			root = new Node(array[mid]);
		    root.left = createMinimalBST(array,start,mid-1);
			root.right = createMinimalBST(array,mid+1,end);
			return root;
		}
		return null;
	}
	
	public static void inorder(Node root){
		if(root != null){
			inorder(root.left);
			System.out.print(root.value+"\t");
			inorder(root.right);
		}
	}
	
	public static void main(String[] args)throws Exception{
		int a[] = {10,20,30,40,50,60,70,80,90};
		Node root = new Node();
		root = createMinimalBST(a,0,a.length-1);
		inorder(root);
	}
}
