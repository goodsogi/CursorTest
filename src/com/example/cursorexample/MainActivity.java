package com.example.cursorexample;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	String[] names = { "경복궁", "창덕궁", "운현궁" };
	private DBConnector dbConnector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 테스트용 데이터 베이스 생성
		makeDB();

		// 리스트 생성
		makeList();

	}

	private void makeList() {
		// TODO Auto-generated method stub
		ListView listView = (ListView) findViewById(R.id.listview);
		ListAdapter listAdapter = new ListAdapter(this, 0, names);
		listView.setAdapter(listAdapter);

		final Cursor cursor = dbConnector.getDatas();

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub

				cursor.moveToPosition(position);
				String name = cursor.getString(cursor.getColumnIndex("name"));
				String x = cursor.getString(cursor.getColumnIndex("x"));
				String y = cursor.getString(cursor.getColumnIndex("y"));

				Toast.makeText(MainActivity.this,
						"name: " + name + "  x: " + x + "  y" + y,
						Toast.LENGTH_SHORT).show();

			}
		});

	}

	private void makeDB() {
		// TODO Auto-generated method stub
		dbConnector = new DBConnector(this);
		dbConnector.insertTestData();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
