package FacebookQuestions;

class ListNode{
	int value;
	ListNode next;
	
	ListNode(){
		value=0;
		next=null;
	}
	
	ListNode(int value){
		this.value=value;
		next=null;
	}
	
	}

class List<T>{
	ListNode head;
	
	public void insert(int value){
		if(head==null)
			head=new ListNode(value);
		else{
			ListNode newnode=new ListNode(value);
			ListNode x=head;
			while(x.next!=null)
					x=x.next;
			x.next=newnode;
		}
	}
	
	
	public void display(ListNode head){
	  ListNode x=head;
	  int i=0;
	  while(x!=null ){
		  System.out.print(x.value+"\t");
		  x=x.next;
	  }
	  System.out.println();
	}
	
	
	public int size(){
		ListNode x=head;
		int count=1;
			while(x!=null){
				x=x.next;
				count++;
			}
		
		return count;
	}
	
	public int get(int position){
		ListNode x=head;
		int pos=1;
		while(x!=null){
			if(position==pos)
				return x.value;
			else
				x=x.next;
		}
		return -1;
	}
}

public class ReverseList {
	
	public static ListNode recursiveReverse(ListNode head){
		ListNode temp=null;
		if(head.next==null)
			return head;
		
		temp=recursiveReverse(head.next);
		head.next.next=head;
		head.next=null;
		return temp;
		
	}
	
	public static void main(String args[])throws Exception{
		List<Integer> l=new List<Integer>();
		int a[]={10,20,30,40,50,60};
		
		for(int i:a){
			l.insert(i);
		}
		int i=a.length;
		System.out.println("Original Linked List");
		l.display(l.head);
		l.head=recursiveReverse(l.head);
		System.out.println("Reversed List:");
		l.display(l.head);
	}
}
