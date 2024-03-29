package com.example.emploi;

import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class EditercvActivity extends ListActivity {

String[] items;


	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		Toast.makeText(EditercvActivity.this,"Veuillez patienter", Toast.LENGTH_SHORT).show();
		Downloader downloader = new Downloader();
		downloader.execute("http://10.0.2.2/android/carnetmaman.php");
		
	}

	protected class Downloader extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... args) {

			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(args[0]);
			
			try {
				String resultat = client.execute(get,
						new BasicResponseHandler());
				
				return resultat;
			} catch (Exception e) {
				
			}
			return null;
			
		}

		@Override
		protected void onPostExecute(String result) {
			
			
		Vector v = new Vector();
		StringTokenizer st = new StringTokenizer(result, "|");
		
		while (st.hasMoreTokens()) {
			v.add(st.nextToken());
			
			}
                items = new String[v.size()];
for (int i = 0; i < v.size(); i++) {
				items[i] = v.elementAt(i).toString();
				Log.v("Chaine=", v.elementAt(i).toString());
			}

setListAdapter(new ArrayAdapter<String>(EditercvActivity.this,
		android.R.layout.simple_list_item_1, items));

		

		}
	}
}
