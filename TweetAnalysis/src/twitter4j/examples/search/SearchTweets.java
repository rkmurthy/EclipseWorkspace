/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package twitter4j.examples.search;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.examples.json.SaveRawJSON;
import twitter4j.json.DataObjectFactory;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.7
 */
public class SearchTweets {
    /**
     * Usage: java twitter4j.examples.search.SearchTweets [query]
     *
     * @param args
     */
    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	 System.out.println("Enter query term");
         String query=br.readLine();
         //String filename="Example";
       // File f=new File(filename);
    	FileOutputStream fos = new FileOutputStream(query+"_Tweets.json",true); 
    	OutputStreamWriter out1 = new OutputStreamWriter(fos);
        if (args.length < 1) {
            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
            System.exit(-1);
        }
        Twitter twitter = new TwitterFactory().getInstance();
       
        try {
        	//SaveRawJSON srj=new SaveRawJSON();
        	while(true){
        	//t.notify();	
        	Query q=new Query(query);
        	q.setRpp(100);
        	//System.out.println("Geocode "+q.getGeocode());
            QueryResult result = twitter.search(q);
            List<Tweet> tweets = result.getTweets();
            for (Tweet tweet : tweets) {
            	System.out.println(tweet.toString());
                //System.out.println("@" + tweet.getFromUser() + " - " + tweet.getText()+"-"+tweet.getLocation()+"-"+tweet.getCreatedAt());
                //String rawJSON=DataObjectFactory.getRawJSON(tweet);
            	//System.out.println(rawJSON);
               // SaveRawJSON.storeJSON(rawJSON, filename);
              // out1.append("@" + tweet.getFromUser() + " - " + tweet.getText()+"-"+tweet.getLocation()+"-"+tweet.getCreatedAt());
              //  out1.append("\n");
              //  out1.flush();
               out1.append(tweet.toString()+"\n");
               //out1.append("\n");
              
               //t.notify();
            }    
            Thread.sleep(10000);
          
           // t.notify();
            }
           // System.exit(0);
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
        
        out1.close();
    }
}
