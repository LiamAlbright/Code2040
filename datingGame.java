package code2040test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.joda.time.DateTime;
import org.joda.time.format.*;
import java.time.format.DateTimeFormatter;
import org.joda.time.*;

public class datingGame {
public static void main(String args[]) throws Exception{
		   
	    
		String tokenAPI="44777cf0fd126638828fde23d63824eb";
	    
	    String queEndpoint="http://challenge.code2040.org/api/dating";
	   
	    String queTwoEndpoint="http://challenge.code2040.org/api/dating/validate";
		
	  
	    JSONObject keyParam = new JSONObject();
	    keyParam.put("token", tokenAPI);
	   

	    HttpClient httpClient = HttpClientBuilder.create().build();
	    
	    try {
	        HttpPost request = new HttpPost(queEndpoint);
	        StringEntity params =new StringEntity(keyParam.toString());

	        request.addHeader("content-type", "application/json");
	        request.setEntity(params);
	        httpClient.execute(request);
	        
	     
	        HttpResponse response = httpClient.execute(request);
	    
	       BufferedReader r = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	       
	      StringBuilder total = new StringBuilder();

	        String line = null;

	        while ((line = r.readLine()) != null) {
	           total.append(line);
	        }
	  
	        r.close();
	       
	        String resPon= total.toString();
	        System.out.println(resPon);
	        
	       
	        JSONObject myObject = new JSONObject(resPon);
	        int interval = myObject.getInt("interval");
	        
	        String datestamp = myObject.getString("datestamp");
	       
	       System.out.println(interval);
	       System.out.println(datestamp);
	       System.out.println(timeChan (datestamp, interval));
	       
	  
	    JSONObject keyParamtwo = new JSONObject();
	    keyParamtwo.put("token", tokenAPI);
	    keyParamtwo.put("datestamp", timeChan (datestamp, interval));

	    HttpClient httpClienttwo = HttpClientBuilder.create().build();
	    
	    
	    try {
	        HttpPost requesttwo = new HttpPost(queTwoEndpoint);
	        StringEntity paramstwo =new StringEntity(keyParamtwo.toString());

	        requesttwo.addHeader("content-type", "application/json");
	        requesttwo.setEntity(paramstwo);
	        httpClienttwo.execute(requesttwo);
	        
	       }
	        catch (Exception ex) {
	    	System.out.print("register went wrong");
    
    
	        }
	    
	    
	    }
	       catch (Exception ex) {
	    	System.out.println(ex);
	    }  
	    
	  
	
	    } 
	    
	


public static String timeChan (String datestamp, int interval ) throws JSONException{
		int ind = 0;
	   String  timeFin = "";
	   
	   
	 
	   
	    DateTime date = new DateTime(datestamp);
		
		DateTime newDate = date.plusSeconds(interval);
		timeFin = newDate.toString();
		
		

		   DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		
		    String nowAsISO = df.format(newDate.toDate());
		
		
		
	

	
		return nowAsISO;
	}






}
