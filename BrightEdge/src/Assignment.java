import java.io.*;
import java.util.*;

public class Assignment {
	ArrayList<String> basicItems;
	ArrayList<String> importedItems;
	ArrayList<String> item;
	ArrayList<Integer>quantity;
	ArrayList<Float>  cost;
	ArrayList<String> books;
	ArrayList<String> edibleItems;
	ArrayList<String> medicalItems;
	float salesTax;
	float tax;
	float total;
	
	Assignment(){
		basicItems=new ArrayList<String>();
		importedItems=new ArrayList<String>();
		item=new ArrayList<String>();
		quantity=new ArrayList<Integer>();
		cost=new ArrayList<Float>();
		books=new ArrayList<String>();
		edibleItems=new ArrayList<String>();
		medicalItems=new ArrayList<String>();
	}
	
	public void initializeTaxes(){
		int basic=10;
		int imported=5;
	}
	
	public void initializeBasicItems()throws IOException{
		/*BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		System.out.println("Enter basic item names");
		String input=br.readLine();
		while(!input.equals("")){
			basicItems.add(input);
			input=br.readLine();
		}*/
		
		String[] temp={"book","music CD","chocolate bar","bottle of perfume","headache pills"};
		Collections.addAll(basicItems,temp);
	}
	
	public void initializeImportedItems() throws IOException{
		String temp[]={"imported box of chocolates","imported bottle of perfume"};
		Collections.addAll(importedItems,temp);
	}
	
	public void performItemSelection()throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         System.out.println("Please select items in the following order:");
         String response="";
         do{
        	 System.out.println("Enter Item");
        	 item.add(br.readLine());
        	 System.out.println("Enter quantity");
        	 quantity.add(Integer.parseInt(br.readLine()));
        	 System.out.println("Enter cost per peice");
        	 cost.add(Float.parseFloat(br.readLine()));
        	 System.out.println("Do you want to select more items?(y/n)");
        	 response=br.readLine();
         }while(response.equalsIgnoreCase("y"));
	}
	
	public void initializeCategories(){
		books=new ArrayList<String>();
		books.add("book");
		edibleItems=new ArrayList<String>();
		edibleItems.add("chocolate bar");
		edibleItems.add("imported box of chocolates");
		medicalItems=new ArrayList<String>();
		medicalItems.add("headache pills");
	}
	
	public void calculateTax(){
		salesTax=0;
		tax=0;
		total=0;
		for(int i=0;i<item.size();i++){
			//salesTax=0;
			if(!importedItems.contains(item.get(i))){
				if(!(books.contains(item.get(i))||edibleItems.contains(item.get(i))||medicalItems.contains(item.get(i)))){
				salesTax+=0.1*cost.get(i)*quantity.get(i);
				total+=cost.get(i)*quantity.get(i)+salesTax;
			}else{
				salesTax+=0;
				total+=cost.get(i)*quantity.get(i);//+salesTax;
				}
			}else{
			
				//for(String i1:importedItems){
					//if (i1.equalsIgnoreCase(item.get(i)) ){
						if (!((books.contains(item.get(i))||edibleItems.contains(item.get(i))||medicalItems.contains(item.get(i))))){
							salesTax+=0.15*cost.get(i)*quantity.get(i);
							total+=cost.get(i)*quantity.get(i)+salesTax;
						}else{
							salesTax+=0.05*cost.get(i)*quantity.get(i);
							total+=cost.get(i)*quantity.get(i)+salesTax;
						}
					//}
				//}
					
			//total+=salesTax;
		}
		//total+=salesTax;
	}
	}
	
	public void createBill(){
		System.out.println("Thank you for shopping with us! Your bill is as follows:");
		for(int i=0;i<item.size();i++){
			System.out.println("Item:"+item.get(i));
			System.out.println("Quantity:"+quantity.get(i));
			System.out.println("Cost:"+cost.get(i)*quantity.get(i));
		}
			//System.out.println("Sales Tax: "+Math.round((double)salesTax));
		System.out.print("Sales Tax: ");
		System.out.printf("%.2f\n", salesTax);	
		//System.ou
		System.out.print("Total: ");
		System.out.printf("%.2f\n", total);
		
	}
	
	public static void main(String args[])throws IOException{
		Assignment a=new Assignment();
		a.initializeTaxes();
		a.initializeBasicItems();
		a.initializeImportedItems();
		a.initializeCategories();
		a.performItemSelection();
		a.calculateTax();
		a.createBill();
	}
}
