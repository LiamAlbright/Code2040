package code2040test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class prefix {
public static void main(String args[]) throws Exception{
		   
	    
		String tokenAPI="44777cf0fd126638828fde23d63824eb";
	    
	    String queEndpoint="http://challenge.code2040.org/api/prefix";
	   
	    String queTwoEndpoint="http://challenge.code2040.org/api/prefix/validate";
		
	  
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
	        JSONArray haystack = myObject.getJSONArray("array");
	        
	        String prefix = myObject.getString("prefix");
	       
	       System.out.println(prefix);
	       System.out.println(haystack);
	       
	     
	       System.out.println(Arrays.toString(trimAry(prefix, haystack)));
	       
	       
	       
	   
	    JSONObject keyParamtwo = new JSONObject();
	    keyParamtwo.put("token", tokenAPI);
	    keyParamtwo.put("array", trimAry(prefix, haystack));

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
	    
	


public static String[] trimAry(String ned, JSONArray hay ) throws JSONException{
		
	
	  
	ArrayList<String> result = new ArrayList<String>();
	
	for(int i = 0; i < hay.length(); i ++) {
				
			if(hay.getString(i).contains(ned)==false) {
				result.add(hay.getString(i));
				
			}
		}
	
	
	
	String[] resFin = new String[result.size()];

	for (int i = 0; i < result.size(); i++) {
		resFin[i] = result.get(i);
	}
		
	
	
	return resFin;
	


}






}
