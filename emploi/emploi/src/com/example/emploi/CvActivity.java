package com.example.emploi;

import org.apache.http.client.HttpClient; 
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;


import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CvActivity extends Activity {
	String matri=ConnexionActivity.matricule;
	EditText txtprenom, txtnom,txtobject, txtdip, txtexp;;
	Button btnenvoyer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cv);
		
		
	txtnom=(EditText)findViewById(R.id.txtnom);	
	txtprenom=(EditText)findViewById(R.id.txtprenom);	
	txtobject=(EditText)findViewById(R.id.txtobject);
	txtdip=(EditText)findViewById(R.id.txtdip);		
	txtexp=(EditText)findViewById(R.id.txtexp);
	
	btnenvoyer=(Button)findViewById(R.id.btnenvoyer);
    
    btnenvoyer.setOnClickListener(new OnClickListener ()
	 {
     

        //Run when button is clicked
        public void onClick(View v) {

            
            
        	String nom = txtnom.getText().toString();
            String prenom = txtprenom.getText().toString();
            String diplome = txtdip.getText().toString();
            String experience = txtexp.getText().toString();
            String objectif = txtobject.getText().toString();
            
    		 // encoder pour tenir en compte les espaces
    		 diplome=Uri.encode(diplome, "utf_8");
    		 objectif=Uri.encode(objectif, "utf-8");
    		 experience=Uri.encode(experience, "utf-8");
    		 
    		 
    String	url2="http://10.0.2.2/android/creercv.php?matricule="+matri+"&prenom="+prenom+"&nom="+nom+"&objectif="+objectif+"&diplome="+diplome+"&experience="+experience;
    	

    Downloader2 d =new Downloader2();
    d.execute(url2);
              Toast.makeText(CvActivity.this, "", 
                              Toast.LENGTH_LONG).show();

        }
      });
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
//Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.cv, menu);
return true;
}

protected class Downloader2 extends AsyncTask<String,Void, String>
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
		
		String result2 =client.execute(get,tunnel);
		
		return result2;
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	return null;
}

@Override
	protected void onPostExecute(String result) {
	
	
	
	
	
		 Toast.makeText(CvActivity.this, " vous etes enregistrer ", Toast.LENGTH_LONG).show();	
		
	}

}

}