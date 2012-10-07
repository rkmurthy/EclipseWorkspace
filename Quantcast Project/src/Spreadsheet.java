import java.io.*;
import java.util.*;

class Assignment {
private int n, m;
private String[][] spreadsheet;
HashMap<String,Integer> map;
ArrayList<String> operators;


	Assignment(){
		n=0;
		m=0;
		map=new HashMap<String,Integer>();
		operators=new ArrayList<String>();
	}
	
	public HashMap<String,Integer> getMap(){
		return map;
	}
	
	public String[][] getSpreadsheet(){
		return spreadsheet;
	}
	
	public int getNumberofColumns(){
		return m;
	}
	
	public int getNumberofRows(){
		return n;
	}
	
	public void initializeOperators(){
		/**
		 * maintains a list of all permitted operators
		 */
		
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
	}
	
	public void createHashMap(String filename)throws IOException{
		FileInputStream fis=new FileInputStream(filename);
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		ArrayList<String>natLang=new ArrayList<String>();
		String s="";
		while((s=br.readLine())!=null)
			natLang.add(s);
		
		//naturalLanguage contains all the alphabets from 'A' to 'Z'
		for(int i=0;i<natLang.size();i++){
			map.put(natLang.get(i),i+1);
		}
		
	}
	
	public void readInput()throws IOException{
		FileInputStream fis=new FileInputStream("Input");
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		String first=br.readLine();
		String[] firstLine=first.split("\t");
		//System.out.println(firstLine[0]);
		m=Integer.parseInt(firstLine[0]);//number of columns
		n=Integer.parseInt(firstLine[1]);//number of rows
		if(n>26){
			System.out.println("Number of rows cannot exceed 26!");
			System.exit(0);
		}
		spreadsheet=new String[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++){
				String s=br.readLine();
				spreadsheet[i][j]=s;
			}
		br.close();
	}
	
	public void displaySpreadsheet(){
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++)
				System.out.print(spreadsheet[i][j] + "|\t");
			System.out.println();
		}
	}
	
	public void preEvaluate(String[][] spreadsheet, int m, int n){
		//input is the expression from each cell in the spreadsheet
		String input=spreadsheet[m][n];
		String s="";
		String cell[]=input.split("\t");
		for(int i=0;i<cell.length;i++){
			if(cell[i].length()>1){
			String first=cell[i].charAt(0)+"";
			//System.out.println(first);
			String second=cell[i].charAt(1)+"";
			if(map.containsKey(first)){
				int x=map.get(first);
				int y=Integer.parseInt(second);
				cell[i]=spreadsheet[x-1][y-1];
				//float f=evaluate1(cell[i]);
				//System.out.println(cell[i]);
				}
			}
			if(i!=cell.length-1)s+=cell[i]+"\t";
			else s+=cell[i];
		}
		spreadsheet[m][n]=s;
		
	}
	
	public float evaluateExp(String[][] spreadsheet, int m, int n){
		//Now we perform the actual evaluation of a given expression
				Stack<Float> s=new Stack<Float>();
				String input=spreadsheet[m][n];
				String cell[]=input.split("\t");
				
				//for(int i=0;i<cell.length;i++){
					//String c[]=cell.split("\t");
					for(int i=0;i<cell.length;i++){
						//System.out.println(cell[i]);
					if(!operators.contains(cell[i])){
						//System.out.println("I am the problem"+cell[i]);
						s.push((Float.parseFloat(cell[i])));
						
					}else{
						//System.out.println("Character:"+cell[i]);
						if(!s.isEmpty()){
							float x=s.pop();
							//System.out.println("x:"+x);
							float y=s.pop();
							//System.out.println("y:"+y);
							float f=performOperation(x,y,cell[i]);
							s.push(f);
						}
					}
	            }
				 return s.pop();
	}
	
	public float performOperation(float x, float y, String s){
		char c=s.charAt(0);
		if(c=='+')
			return x+y;
		else if(c=='-')
			return y-x;
		else if(c=='*')
			return x*y;
		else if(c=='/'){
			 if(x>0)return y/x;
			 else return -1; 
		}
	return -1;	
	}
	
}

public class Spreadsheet{
	public static void main(String args[])throws IOException{
		HashMap<String,String> output=new HashMap<String, String>();
		
		Assignment a =new Assignment();
		a.readInput();
		String s=a.getSpreadsheet()[0].length+" "+a.getSpreadsheet().length;
		output.put(s,s);
		String localSpreadsheet[][]=new String[a.getSpreadsheet().length][a.getSpreadsheet()[0].length];
		for(int i=0;i<a.getNumberofRows();i++)
			for(int j=0;j<a.getNumberofColumns();j++)
				localSpreadsheet[i][j]=a.getSpreadsheet()[i][j];
		
		//a.displaySpreadsheet();
		a.initializeOperators();
		a.createHashMap("natLang");
		//a.preevaluate("A2");
		for(int i=0;i<a.getNumberofRows();i++){
			for(int j=0;j<a.getNumberofColumns();j++){
				a.preEvaluate(a.getSpreadsheet(),i,j);
			}
		}
		//a.displaySpreadsheet();
		
		for(int i=0;i<a.getNumberofRows();i++){
			for(int j=0;j<a.getNumberofColumns();j++){
				output.put(localSpreadsheet[i][j],String.format("%.5f",a.evaluateExp(a.getSpreadsheet(), i, j)));
			}
		}
		//Printing output in given format
		System.out.println("Input"+"\t"+"Output");
		System.out.println(s+"\t"+output.get(s));
		for(int i=0;i<a.getNumberofRows();i++)
			for(int j=0;j<a.getNumberofColumns();j++)
				System.out.println(localSpreadsheet[i][j]+"\t"+output.get(localSpreadsheet[i][j]));
	}
}
