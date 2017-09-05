/**
 * 
 */
package com.rave.socialmedia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.api.TweetsResources;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author deep.mistry
 *
 */
public class Methods {

	
	 public static void readTweets() throws Exception{
		 Twitter twitter =null;
    	 UserTwitterCredentials userTwitterDetails = null;
 		userTwitterDetails = generateCredentials("Yi531zC2f46Aub9K5zD5nwrbh","noS1Tzf9WfRgQFhd9DJbAU4sVwW4vXDCGDsnLWEryFSJsI9ci0");
 		twitter =getByConfigureBuilder(userTwitterDetails);
 			    	
 			 TweetsResources tweets= twitter.tweets();
 			ResponseList<twitter4j.Status> stat;
 			stat = twitter.getUserTimeline();
 			System.out.println("Username/ScreenName : "+stat.get(0).getUser().getScreenName()+"\n Display Name : "+ stat.get(0).getUser().getName()+"\n Tweets : ");
			for(int j = 0 ; j<stat.size();j++){
				System.out.println((j+1)+" => "+stat.get(j).getText());
			}
	 }
	 
	 public static void writeTweets(String message) throws Exception{
		 Twitter twitter =null;
    	 UserTwitterCredentials userTwitterDetails = null;
 		userTwitterDetails = generateCredentials("Yi531zC2f46Aub9K5zD5nwrbh","noS1Tzf9WfRgQFhd9DJbAU4sVwW4vXDCGDsnLWEryFSJsI9ci0");
 		twitter =getByConfigureBuilder(userTwitterDetails);
 		System.out.println("Your entered message :\n"+message);	
 		twitter.updateStatus(message);
 		System.out.println("Tweet posted!!! \n");
	 }
	 
	 /**
		 * Get Request Token for given consumerKey and consumerSecret.
		 * @param consumerKey
		 * @param consumerSecret
		 * @return
		 * @throws SessionExpiredException
		 * @throws TwitterException
		 * @throws Exception
		 */
		public static UserTwitterCredentials generateCredentials(String consumerKey,String consumerSecret) throws  TwitterException,Exception {
			try{
				ConfigurationBuilder cb = new ConfigurationBuilder();
	            cb.setOAuthConsumerKey(consumerKey);
	            cb.setOAuthConsumerSecret(consumerSecret);
	            Configuration conf = cb.build();           
	            TwitterFactory tf = new TwitterFactory(conf);
	            Twitter twitter = tf.getInstance();
	            RequestToken token = twitter.getOAuthRequestToken(); 
	            
	            UserTwitterCredentials userTwitterDetails = new UserTwitterCredentials();
	    		userTwitterDetails.setConsumerKey("Yi531zC2f46Aub9K5zD5nwrbh");
	    		userTwitterDetails.setConsumerSecret("noS1Tzf9WfRgQFhd9DJbAU4sVwW4vXDCGDsnLWEryFSJsI9ci0");
	    		userTwitterDetails.setAccessToken("904573384696233989-iJwID4WzhO3lWBpxu4EuXCqhWTbh1D6");
	    		userTwitterDetails.setAccessSecret("c4uelEXAyBTpkE8T5gAMnI1vLcuuVOsHvltyFaQChAnaP");
	            
	           return userTwitterDetails;
	          
			}catch(Exception e){
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw));
				
				throw e;
			}
		}
		
			/**
			 * Set initial configuration for twitter instance which are required to do API call.
			 * Here we set below four properties.
			 * @param userTwitterDetails
			 * @return Twitter
			 */
			public static Twitter getByConfigureBuilder(
					UserTwitterCredentials userTwitterDetails) {
				Twitter twitter =null;
				try{
					ConfigurationBuilder cb = new ConfigurationBuilder();
					cb.setDebugEnabled(true)
							.setOAuthConsumerKey(userTwitterDetails.getConsumerKey())
							.setOAuthConsumerSecret(userTwitterDetails.getConsumerSecret())
							.setOAuthAccessToken(userTwitterDetails.getAccessToken())
							.setOAuthAccessTokenSecret(userTwitterDetails.getAccessSecret());
					TwitterFactory tf = new TwitterFactory(cb.build());
					twitter = tf.getInstance();
				}catch(Exception e){
					StringWriter sw = new StringWriter();
					e.printStackTrace(new PrintWriter(sw));
					
							
				}
				return twitter;
			}
			
			/**
			 * Getting the configuration for authentication by reading the twitter4j.properties file.
			 * @param key
			 * @return
			 * @throws IOException
			 */
/*			public static String readProperty(String key) throws IOException{
				
				Properties prop = new Properties();
				InputStream input = null;

//	For using with eclipse
//				input = new FileInputStream("../socialmedia/src/main/resources/twitter4j.properties");
// 	For using with jar or package
				
				input = new FileInputStream("twitter4j.properties");

					// load a properties file
					prop.load(input);
					input.close();
				return prop.getProperty(key);
			}*/
}
