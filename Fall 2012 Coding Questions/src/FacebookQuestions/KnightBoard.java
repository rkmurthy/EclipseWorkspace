package FacebookQuestions;

import java.util.HashSet;
import java.util.Iterator;

class Point{
	int x, y;
	
	Point(){
		 x = -1;
		 y = -1;
	}
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class KnightBoard {

	public static void move(int[][] a, int x, int y, HashSet<Integer> pset){
		if (x < 0 || x >= a.length || y >= a[0].length || y < 0)
			return;
		
		Point p = new Point(x,y);
		
		if(!pset.contains(p.x)){
			pset.add(p.x);
			System.out.println(p.x+"\t"+p.y);
		}
		if(x >= 0 && x <= a.length-1 && y >= 0 && y <= a[0].length-1 ){
			//move(a,x-1,y,pset);
			move(a,x+1,y,pset);
		//	move(a,x-1,y-1,pset);
		   move(a,x+1,y+1,pset);
			
			return;
		}
		return;
	}
	
	public static void main(String[] args){
		HashSet<Integer> pset = new HashSet<Integer>();
		int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	    move(a,0,0,pset);
		Iterator<Integer> p = pset.iterator();
		while(p.hasNext()){
			System.out.println(p);
			p.next();
		}
	}
}
