package com.example.emploi;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class JobActivity extends Activity {

	ListView liste = null;
	public static String offre;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_job);
	liste = (ListView) findViewById(R.id.listView);
	    final List<String> exemple = new ArrayList<String>();
	    exemple.add("Télécommunications");
	    exemple.add("Administration");
	    exemple.add("Agroalimentaire");
	        
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exemple);
	    liste.setAdapter(adapter);
	  
	
	liste.setOnItemClickListener(new OnItemClickListener() {
	    @Override
	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {               
	      
	    	  offre = exemple.get(position);
	    	
	    	Toast.makeText(JobActivity.this,
	    			"filiére choisie : " +offre, 
							Toast.LENGTH_LONG).show();
	    	
	    	
	    	
	    	Intent intent=new Intent(JobActivity.this, VoiroffreActivity.class
	    			);
	    	startActivity(intent);

	    	
	    	
	    	
	    	
	    	
	    	
	   }	
	    
	 });
	}
}
		
		
class Downloader extends AsyncTask<String, Void, String>

{
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}
	
	@Override
	protected String doInBackground(String... url) {
		 
		try {
HttpClient client=new DefaultHttpClient();
HttpGet get=new HttpGet(url[0]);
ResponseHandler<String> tunnel=new BasicResponseHandler();
String result=client.execute(get, tunnel);

return result;
			
		} catch (Exception e) {
		}
		
		return null;
	}
	
	@Override 
	protected void onPostExecute(String result) {
	
		 
		
		

		}
	}
	




	


