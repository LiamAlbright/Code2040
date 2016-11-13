package code2040test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class needleStack {

public static void main(String args[]) throws Exception{
		   
	    
		String tokenAPI="44777cf0fd126638828fde23d63824eb";
	    
	    String queEndpoint="http://challenge.code2040.org/api/haystack";
	   
	    String queTwoEndpoint="http://challenge.code2040.org/api/haystack/validate";
		
	  
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
	    
	        
	        
	        JSONObject myObject = new JSONObject(resPon);
	        JSONArray haystack = myObject.getJSONArray("haystack");
	        
	        String needle = myObject.getString("needle");
	       
	       System.out.println(haystack);
	       System.out.println(needle);
	       
	       int finInt = nedLook(needle, haystack);
	       System.out.println(finInt);
	   
	    JSONObject keyParamtwo = new JSONObject();
	    keyParamtwo.put("token", tokenAPI);
	    keyParamtwo.put("needle", finInt);

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
	    
	


public static int nedLook (String ned, JSONArray hay ) throws JSONException{
		int ind = 0;
	
		for(int i = 0; i < hay.length() - 1; i ++) {
			
			if( hay.getString(i).equals(ned) ) {
				ind = i; 
				
			}
		
		
			
	}
		return ind;
	}






}
