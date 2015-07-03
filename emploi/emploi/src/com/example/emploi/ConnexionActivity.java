package com.example.emploi;

import java.util.StringTokenizer;

import java.util.Vector;


import org.apache.http.client.HttpClient;

import org.apache.http.client.ResponseHandler;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.BasicResponseHandler;

import org.apache.http.impl.client.DefaultHttpClient;




import android.os.Bundle;

import android.app.Activity;

import android.view.Menu;

import android.app.Activity;

import android.content.Intent;

import android.os.AsyncTask;

import android.util.Log;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;



public class ConnexionActivity extends Activity {
	
	

EditText txtlogin, txtmdp;
	
Button btconnect, btquitter;
	
public static String matricule="";
	
	

    
@Override
   protected void onCreate(Bundle savedInstanceState) {
   

     super.onCreate(savedInstanceState);
        
     setContentView(R.layout.activity_connexion);
       
     btconnect= (Button)findViewById(R.id.btnval); 
   
     btquitter= (Button)findViewById(R.id.btnquit);
        

        txtlogin= (EditText)findViewById(R.id.txtlog);
    
    txtmdp= (EditText)findViewById(R.id.txtpas);
        
btconnect.setOnClickListener(new  OnClickListener() {
	

		
			@Override
	

		public void onClick(View arg0) {
	

			// TODO Auto-generated method stub
            
             final String login = txtlogin.getText().toString();
	
			final String password = txtmdp.getText().toString();
    
            if (login.equals("") || password.equals("")) {
		
	
		Toast.makeText(ConnexionActivity.this,
		
	
	      "Veuillez renseigner tous les champs",
											
           Toast.LENGTH_LONG).show();

	
							}
	
	
						else{
		 
							
         //Intent intent= new Intent(MainActivity.this,Presen_Activity.class);

                                  //  startActivity(intent);
                     
               
       String  url = "http://10.0.2.2/android/connexion.php?login="+login+"&password="+password;
                		        	
                		        	Downloader d =new Downloader();
                		        	d.execute(url);
			                    }

			}
		});
        
         btquitter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent= new Intent(ConnexionActivity.this,PresentationActivity.class);
                startActivity(intent);	
				
			}
		});
        
        
        
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
				
				Vector v = new Vector();
				StringTokenizer st = new StringTokenizer(result, "|");
				
				while (st.hasMoreTokens()) {
					v.add(st.nextToken());
					
				}
				String tab[] = new String[v.size()];
	for (int i = 0; i < v.size(); i++) {
		tab[i] = v.elementAt(i).toString();
					Log.v("Chaine=", v.elementAt(i).toString());
					
				}
	matricule=tab[1];
				Toast.makeText(ConnexionActivity.this,"ID= "+matricule,Toast.LENGTH_LONG).show();
				
				Intent intent= new Intent(ConnexionActivity.this,JobActivity.class);
                startActivity(intent);	
				
			}else{
				
				Toast.makeText(ConnexionActivity.this, " Login ou le Mot de passe incorrect ", Toast.LENGTH_LONG).show();
				
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
