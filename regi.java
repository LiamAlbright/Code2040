package code2040test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.*;
import org.apache.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class regi {
	
	public static void main(String args[]) throws Exception{
	   
		String myGIt="https://github.com/LiamAlbright/Code2040";
	    String tokenAPI="44777cf0fd126638828fde23d63824eb";
	    String regEndpoint="http://challenge.code2040.org/api/register";	
		
	    JSONObject keyParam = new JSONObject();
	    keyParam.put("token", tokenAPI);
	    keyParam.put("github", myGIt);

	    HttpClient httpClient = HttpClientBuilder.create().build();
	    
	    try {
	        HttpPost request = new HttpPost(regEndpoint);
	        StringEntity params =new StringEntity(keyParam.toString());

	        request.addHeader("content-type", "application/json");
	        request.setEntity(params);
	        httpClient.execute(request);
	        
	        
	        
	        
	        
	        
	        
	      }
	        catch (Exception ex) {
	    	System.out.print("register went wrong");
	    }  finally {
	        
	    }
	}
}






