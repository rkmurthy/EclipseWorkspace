import java.io.*;
public class Pa4 {
	
	public static void main(String args[])throws IOException{
		InvIndex inv=new InvIndex();
		Document d[]=new Document[200];
		FileInputStream fis=new FileInputStream("Captions");
		InputStreamReader in=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(in);
		for(int i=0;i<200;i++){
			d[i]=new Document(br.readLine(),inv);
			d[i].docID=(i+1);
		}
		
		BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter query");
		String query=br2.readLine();
		int c[]=new int[200];
		for(int i=0;i<200;i++){
			if(d[i].h.containsKey(query))
				c[i]=d[i].h.get(query);
			else
				c[i]=-1;
		}
		int r=0;
		for(int i=0;i<199 ;i++){
			if(c[i]==-1) i++;
			int max=c[i];
			int pos=i;
			for(int j=i+1;j<200;j++){
				if(c[j]==-1 ) j++;
				if(max<c[j]){
					max=c[j];
					pos=j;
				}
			}
			/*int temp=c[i];
			c[i]=c[pos];
			c[pos]=temp;*/
			c[pos]=-1;
			r++;
			if(r<=5)System.out.println("Document "+pos);
			}
			
	}

}
