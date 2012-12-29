package FacebookQuestions;

public class RotatedBinSearch {
	
	public static int binSearchRotated(int[] a, int start, int end, int x){
		if(start <= end){
			System.out.println("start: "+start+"\t"+"end: "+end);
			int mid = (start+end)/2;
			if(a[mid] == x) {
				System.out.println("mid: "+mid+"\t"+"a[mid]: "+a[mid]);
				return mid;
			}
			if(a[mid] > x){
				if(a[mid] >= a[start] ){
					if(a[mid] > a[end])
						if(a[end] >= x)
						return binSearchRotated(a,mid+1,end,x);
						else
						return binSearchRotated(a,start,mid-1,x);
					else
						return binSearchRotated(a,start,mid-1,x);
				}else{
					return binSearchRotated(a,start,mid-1,x);
				}
			}else
				return binSearchRotated(a,mid+1,end,x);
			//System.out.println("start: "+start+"\t"+"end: "+end);
		}
		return -1;
	}
	
	
	public static void main(String[] args)throws Exception{
		int[] a = {10,10,20,30,30,40,50,60,60,10};
		System.out.println(binSearchRotated(a,0,a.length-1,40));
		
	}
}
