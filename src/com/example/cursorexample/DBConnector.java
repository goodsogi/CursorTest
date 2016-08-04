package com.example.cursorexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBConnector {
	private SQLiteDatabase db;
	private DBHelper dbHelper;

	String[][] datas = { { "경복궁", "200", "300" }, { "창덕궁", "250", "250" },
			{ "운현궁", "270", "270" } };

	public DBConnector(Context context) {
		dbHelper = new DBHelper(context);
		db = dbHelper.getWritableDatabase();
	}

	public void insertTestData() {

		for (int i = 0; i < datas.length; i++) {

			String name = datas[i][0];
			String x = datas[i][1];
			String y = datas[i][2];

			ContentValues cv = new ContentValues();
			cv.put("name", name);
			cv.put("x", x);
			cv.put("y", y);

			db.insert("test_table", null, cv);

		}

	}

	public Cursor getDatas() {
		// TODO Auto-generated method stub
		return db.rawQuery("SELECT * FROM test_table ", null);
	}

}
