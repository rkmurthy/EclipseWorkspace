package SortingMethods;

class Node1{
	int value;
	Node1 next;
	
	Node1(){
		value = -1;
		next = null;
	}
	
	Node1(int value){
		this.value = value;
		next = null;
	}
}

class LinkedList1{
	Node1 head;
	
	public void insert(int v){
		if(head == null){
			head = new Node1(v);
		}else{
			Node1 x = head;
			while( x.next != null)
				x = x.next;
			x.next = new Node1(v);
		}
	}
	 
	public boolean delete(int v)throws Exception{
		if(head == null)
			throw new Exception("Deleting from Empty List");
		if (head.value == v){
			head = head.next;
			return true;
		}
		else{
			Node1 x = head;
			while(x.next != null){
				if(x.next.value == v){
					x.next = x.next.next;
					return true;
				}
				x = x.next;
			}
		}
		return false;
	}
	
	public void displayList(Node1 head){
		Node1 x = head;
		while( x != null)
			System.out.print(x.value+"\t");
	}
	
	public Node1 reverseI(Node1 head){
		if(head == null) return null;
		
		Node1 prev = null;
		Node1 current = head;
		while( current != null){
			Node1 next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	
	public Node1 reverseR(Node1 head){
		if(head.next == null) return head;
		
		Node1 temp = reverseR(head.next);
		head.next.next = head.next;
		
		return temp;
	}
}

public class Reverse {

	public static void reverse(Node1 head){
		int a[] = {10,20,30,40,50,60,70,80,90};
		LinkedList1 list = new LinkedList1();
		for(int i:a)
			list.insert(i);
		list.displayList(list.head);
		Node1 head1 = list.reverseI(list.head);
		Node1 head2 = list.reverseR(head1);
		list.displayList(head1);
		list.displayList(head2);
		
		
			
	}
}
