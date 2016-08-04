package com.example.cursorexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 무료 행사 정보 저장용 디비
 * 
 * @author user
 * 
 */
public class DBHelper extends SQLiteOpenHelper {

	public DBHelper(Context context) {
		super(context, "test_db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		// 테스트 테이블 생성
		db.execSQL("CREATE TABLE test_table"
				+ "(_id integer primary key autoincrement ,"
				+ "name TEXT, x TEXT, y TEXT);");

		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// 기존 테이블 삭제
		db.execSQL("DROP TABLE IF EXISTS test_db");

		// 새로 DB 생성
		onCreate(db);

	}

}
