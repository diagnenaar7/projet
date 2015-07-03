package com.example.emploi;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
 

@SuppressLint("NewApi")
public class VoiroffreActivity extends Activity {
  private OffresAdapter dbHelper;
  private SimpleCursorAdapter dataAdapter;
  public static String idfav,fil,entre,desc;
  
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_voiroffre);
   dbHelper = new OffresAdapter(this);
    dbHelper.open();
   
    //Clean all data
    dbHelper.deleteAllCountries();
    //Add some data
    dbHelper.insertSomeCountries();
   
    //Generate ListView from SQLite Database
    displayListView();
   
    
  
   }
   
   private void displayListView() {
   
   
    Cursor cursor = dbHelper.fetchOffres();
   
    // The desired columns to be bound
    String[] columns = new String[] {
    		
      OffresAdapter.KEY_filieres,
      OffresAdapter.KEY_entreprise,
      OffresAdapter.KEY_description,
      
    };
   
    // the XML defined views which the data will be bound to
    int[] to = new int[] { 
      R.id.filieres,
      R.id.entreprise,
      R.id.description,
     
    };
   
    // create the adapter using the cursor pointing to the desired data 
    //as well as the layout information
    dataAdapter = new SimpleCursorAdapter(
      this, R.layout.personaliser, 
      cursor, 
      columns, 
      to,
      0);
   
    ListView listView = (ListView) findViewById(R.id.listView1);
    // Assign adapter to ListView
    listView.setAdapter(dataAdapter);
    
    
    listView.setOnItemClickListener(new OnItemClickListener() {
    	
    	   @Override
    	     public void onItemClick(AdapterView listView, View view, 
    	       int position, long id) {
    	     // Get the cursor, positioned to the corresponding row in the result set
    	     Cursor cursor = (Cursor) listView.getItemAtPosition(position);
    	   
    	     // Get the state's capital from this row in the database.
    	     idfav =cursor.getString(cursor.getColumnIndexOrThrow("_id"));
    	     
    	     fil=cursor.getString(cursor.getColumnIndexOrThrow("filieres"));
    	     
    	     entre =cursor.getString(cursor.getColumnIndexOrThrow("entreprise"));
    	

    	      desc=cursor.getString(cursor.getColumnIndexOrThrow("description")); 
    	    	      
    	      fil=Uri.encode(fil, "utf-8");
    			entre=Uri.encode(entre, "utf-8");
    			desc=Uri.encode(desc, "utf-8");

    	     Toast.makeText(getApplicationContext(),
    	       "Vous allez étre rediriger vers le menu pour Ajouter l'offre aux favoris ou postuler", Toast.LENGTH_SHORT).show();
    	    Intent intent=new Intent(VoiroffreActivity.this,MenuActivity.class
 	    			);
 	    	startActivity(intent);

 	    	
    	   
    	     }
    	    });} 
   
   
   

  }