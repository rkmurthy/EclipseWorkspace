package twitter4j.examples.json;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import twitter4j.internal.org.json.JSONException;
//import twitter4j.internal.org.json.JSONException;
public class processJSON {
	/*
	 * Gets the JSON data from a text file and retrieves specific columns and stores in another file
	 * to make plotting values easier
	 * Here the values needed are : UserID(?),geoLocation(coordinates).tweet text,Location in text format
	 * 
	 */
	 public static void main(String[] args) throws IOException{
		    File f= new File("New_Tweets.json");
		    FileInputStream fis=new FileInputStream(f);
		    BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		    String currentJSONString  = "";
		   // JSONObject jsonObject=new JSONObject();
		    
		   String jsonObject="";
		    JSONArray jsonArray=new JSONArray();
		 // read the file, since I ask for newline separation, it's easier for BufferedReader
		 // to separate each String
		 while( (currentJSONString = br.readLine()) != null ) {
		     // create new JSONObject
		     
		     jsonArray.add(currentJSONString);
		 }
		     try{
		     jsonObject =(JSONArray.toJSONString(jsonArray));
		     }
		     catch(Exception e){
		    	 
		     }
		        	// System.out.println(jsonObject.valueOf("text"));
		        	// System.out.println(jsonObject.valueOf("created_at"));
		        	 System.out.println(jsonObject.getBytes("text"));
		        
		     
		          
		     }
		    
		   
	    }


