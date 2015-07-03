package com.example.emploi;

import org.apache.http.client.HttpClient; 
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class ChoixcvActivity extends Activity {

	Button btncreer;
	Button btnediter;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_cv);
			  
			btncreer =(Button) findViewById(R.id.btncreer);
			btnediter =(Button) findViewById(R.id.btnediter);
			
			btncreer.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					
	    	    Intent i = new Intent(ChoixcvActivity.this, CvActivity.class);		
				startActivity(i);
				AnimationSet set = new AnimationSet(true);
				Animation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,30, Animation.RELATIVE_TO_SELF, 40);
				animation.setDuration(1000);
				set.addAnimation(animation);
				btncreer.startAnimation(animation);}});
			
			btnediter.setOnClickListener(new OnClickListener() {
	            @Override
				public void onClick(View v) {
	            	
	                  Intent it = new Intent(ChoixcvActivity.this, EditercvActivity.class);
					  startActivity(it);
					  AnimationSet set = new AnimationSet(true);
						Animation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,30, Animation.RELATIVE_TO_SELF, 40);
						animation.setDuration(1000);
						set.addAnimation(animation);
						btnediter.startAnimation(animation);}});
			
						   
	    
	}}