package com.example.cursorexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * 메인 리스트 어댑터
 * 
 * @author user
 * 
 */
public class ListAdapter extends ArrayAdapter<String> {

	private String[] objects;

	public ListAdapter(Context context, int textViewResourceId,
			String[] objects) {
		super(context, textViewResourceId, objects);
		this.objects = objects;

	}

	@Override
	public View getView(final int position, View convertView,
			final ViewGroup parent) {
		View row = convertView;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) this.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.list_item, parent, false);
			TextView textView = (TextView)row.findViewById(R.id.textview);
			textView.setText(objects[position]);
		}
		return row;
	}

}
