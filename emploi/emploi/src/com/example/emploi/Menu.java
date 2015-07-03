package com.example.emploi;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class Menu extends SimpleAdapter {
	
	private int color1 = 0xaaFF5F5F;
	private int color2 = 0xaa2F67FF;

	public Menu(Context context, List<HashMap<String, String>> items, int resource, String[] from, int[] to) {
		super(context, items, resource, from, to);
		// TODO Auto-generated constructor stub
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	  View view = super.getView(position, convertView, parent);

	  if(position % 2 == 0)
		  view.setBackgroundColor(color1);
	  else
		  view.setBackgroundColor(color2);

	  return view;
	}
}