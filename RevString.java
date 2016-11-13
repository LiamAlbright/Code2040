package code2040test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;



public class RevString {
	
	public static void main(String args[]) throws Exception{
		   
	    
		String tokenAPI="44777cf0fd126638828fde23d63824eb";
	    
	    String queEndpoint="http://challenge.code2040.org/api/reverse";
	   
	    String queTwoEndpoint="http://challenge.code2040.org/api/reverse/validate";
		
	    String word;
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
	    System.out.println(total.toString());
	    word= revString(total.toString());
	    System.out.println(word);
	    
	  
	    
	    JSONObject keyParamtwo = new JSONObject();
	    keyParamtwo.put("token", tokenAPI);
	    keyParamtwo.put("string", word);

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
	    
	
	public static String revString (String str){
		String revWord="";
		
		for (int i =0; i<str.length();i++){
			revWord= str.charAt(i)+revWord;
		}
		
		return revWord;
		
	}
	
   
}













