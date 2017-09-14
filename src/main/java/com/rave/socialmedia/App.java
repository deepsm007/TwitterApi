package com.rave.socialmedia;

import java.io.IOException;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import twitter4j.TwitterException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JsonGenerationException, JsonMappingException, IOException, TwitterException
    {
        
    	Scanner sc = new Scanner(System.in);
    	while (true) {
    	System.out.println("\n \n Select any choice from below:");
    	System.out.println("1. Read all tweets \n 2. Tweet a post \n 0. To exit");
    	String choice = sc.nextLine();
    	if(choice.equalsIgnoreCase("1")){
    		try {
				Methods.readTweets();
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(choice.equalsIgnoreCase("2")){
    		try {
    			System.out.println("Enter the username to respond");
    			String user = sc.nextLine();
    			System.out.println("Enter Your tweet message");
    			String message = sc.nextLine();
				Methods.writeTweets(user+" "+message);
			} catch (Exception e) {
				e.printStackTrace();
			}

    	}else if(choice.equalsIgnoreCase("0")){
    		break;
    	}
    	else {
    		System.out.println("Wrong input");
    	}
    	
    	}
						
        
    }
 

}
