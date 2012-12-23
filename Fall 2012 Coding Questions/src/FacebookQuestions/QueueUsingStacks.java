package FacebookQuestions;

import java.io.*;
import java.util.*;

public class QueueUsingStacks {
	
	Stack<Integer> enque=new Stack<Integer>();
	Stack<Integer> deque=new Stack<Integer>();
	
	QueueUsingStacks(){
		enque=new Stack<Integer>();
	    deque=new Stack<Integer>();	
	}
	
	public void doDeque(){
		while(!enque.isEmpty()){
			deque.push(enque.pop());
			deque.pop();
		}
	}
	
	public void doEnque(int value){
		while(!deque.isEmpty()){
			enque.push(deque.pop());
			enque.push(value);
		}
	}
	

}
