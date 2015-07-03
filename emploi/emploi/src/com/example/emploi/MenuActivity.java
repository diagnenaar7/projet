package com.example.emploi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends Activity {

	
	String matri=ConnexionActivity.matricule;
	String identite=VoiroffreActivity.idfav;
	String entreprise=VoiroffreActivity.entre;
	String filiere=VoiroffreActivity.fil;
	String description=VoiroffreActivity.desc;
	

	private ListView list;

	private List<HashMap<String, String>> listContent = new ArrayList<HashMap<String,String>>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.list = (ListView) findViewById(R.id.listView1);         
        
        	HashMap<String,String> item1 = new HashMap<String,String>();
		item1.put("line", "Créercv");
		this.listContent.add(item1);

		HashMap<String,String> item2 = new HashMap<String,String>();
		item2.put("line", "FAVORIS");
		this.listContent.add(item2);

		HashMap<String,String> item3 = new HashMap<String,String>();
		item3.put("line", "Editer cv");
		this.listContent.add(item3);
        
		HashMap<String,String> item4 = new HashMap<String,String>();
		item4.put("line", "CONSULTATION FAVORIS");
		this.listContent.add(item4);
		
		HashMap<String,String> item5 = new HashMap<String,String>();
		item5.put("line", "REPONSE OFFRE");
		this.listContent.add(item5);
        
		HashMap<String,String> item6 = new HashMap<String,String>();
		item6.put("line", "VISUALISATION GOOGLE MAPS");
		this.listContent.add(item6);
        
		
        this.list.setAdapter(new Menu(this, listContent, R.layout.item, new String[] { "line" }, new int[] { R.id.text }));
  

list.setOnItemClickListener(new OnItemClickListener() {


		 
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int i,long arg3) {
			CallFunc(i);
			
		}
		});
}

		private void CallFunc(int i) {
			   
		
				Intent intent = null ;
				switch (i) {
				  case 0:
				    intent = new Intent(getBaseContext() , CvActivity.class);
				  break;
				  case 1 :

						 String  url = "http://10.0.2.2/android/favoris.php?identite="+identite+"&filiere="+filiere+"&entreprise="+entreprise+"&description="+description;
						     	
							Downloader d =new Downloader();
					     	d.execute(url);
				   
				  break;
				  
				  case 2 :
					   intent = new Intent(getBaseContext() ,EditercvActivity.class);
					  break;
					  
				  case 3 :
					   intent = new Intent(getBaseContext() , PresentationActivity.class);
					  break;
					  
				  case 4 :
					  String  url1 = "http://10.0.2.2/android/candidature.php?offre="+identite+"&matricule="+matri;
				     	
						Downloader a =new Downloader();
				     	a.execute(url1);
				  case 5 :
					   intent = new Intent(getBaseContext() ,PresentationActivity.class);
					  break;
					  				  
				}
				if(intent != null)
        		    startActivity(intent);
		}
		
		
		
		
		
		protected class Downloader extends AsyncTask<String,Void, String>
	    {

	   

	 	
	    	
	    	
	      @Override
	    protected void onPreExecute() {
	   
	 
	                 	// TODO Auto-generated method stub
	    	  
	    	  
	  
	  
		  
	    	                super.onPreExecute();
	    }
	    

		
	      
	      
	      
			@Override
			
	                             protected String doInBackground(String... url) {
		
	             		// TODO Auto-generated method stub
				

				try {
					

			
			HttpClient client = new DefaultHttpClient();
			
			HttpGet get =new HttpGet(url[0]);
				
	   	ResponseHandler<String> tunnel= new BasicResponseHandler();

		
				
					String result =client.execute(get,tunnel);
					
					return result;
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				return null;
			}
	    	
			
			
			
	    	
			@Override
				protected void onPostExecute(String result) {
					
				
				
				
				if (result.contains("OK"))
				{
					
				
		
					Toast.makeText(MenuActivity.this,matri ,Toast.LENGTH_LONG).show();
					
					Intent intent= new Intent(MenuActivity.this,MenuActivity.class);
	                startActivity(intent);	
					
				}else{
					
					Toast.makeText(MenuActivity.this, " Réessayez ", Toast.LENGTH_LONG).show();
					
				}
				
	    
		}
	    
		
	    } 
	    public static String[] split(String text, String sep) {

	    	

	    	if (text == null || text.trim().equals("")) {
	    		
	    	return null;
	    		}
	    		
	              text = text.trim();

	    		
	              StringTokenizer st = new StringTokenizer(text.trim(), sep);
	    	
	       	int nbtoken = st.countTokens();
	    		
	                if (nbtoken != 0) {
	    	

	    		String[] tmp = new String[nbtoken];
	    	
	    		int i = 0;
	    			
	               while (st.hasMoreTokens()) {
	    				
	                tmp[i] = st.nextToken();
	    				
	                i++;
	    			}
	    		
	          	return tmp;
	    		}

	    		
	          return null;
	    	}
	        
		
		
		
		}
	
		
	

