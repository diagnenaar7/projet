package com.example.emploi;

import com.example.emploi.*;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;





public class PresentationActivity extends Activity {
	Button connexion;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);
		connexion= (Button) findViewById(R.id.btncon);
       
	connexion.setOnClickListener(new OnClickListener() {
		public void onClick(View arg0) {


	
		Intent intent=new Intent(PresentationActivity.this, ConnexionActivity.class
				);
		startActivity(intent);
		
		
	}
	
		
    }
   ); }}


  
    
