package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Content;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	public DBHelper(Context context, String name, CursorFactory factory,
			int version, String tableName) {
		super(context, DATABASE_NAME, factory, version);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.TABLE_NAME = tableName;
		createTable();
	}

	private final static String DATABASE_NAME = "test";
	private Context context;
	private final static String COL_ID = "id";
	private final static String COL_NAME = "name";
	private final static String COL_AUTHOR = "author";
	private final static String COL_Details = "details";
	private String TABLE_NAME;// = "poem";

	@Override
	public void onCreate(SQLiteDatabase db) {
		/*
		 * final String QUERY_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
		 * + COL_ID + " INTEGER PRIMARY KEY " + "AUTOINCREMENT, " + COL_NAME +
		 * " TEXT, " + COL_AUTHOR + " TEXT, " + COL_Details + " TEXT )";
		 * 
		 * // TODO Auto-generated method stub db.execSQL(QUERY_CREATE_TABLE);
		 * 
		 * Log.d("database", "Database Created");
		 */
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	private void createTable() {
		SQLiteDatabase db = this.getWritableDatabase();
		// if(db.f)
		final String QUERY_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
				+ COL_ID + " INTEGER PRIMARY KEY " + "AUTOINCREMENT, "
				+ COL_NAME + " TEXT, " + COL_AUTHOR + " TEXT, " + COL_Details
				+ " TEXT )";

		try {
			db.execSQL(QUERY_CREATE_TABLE);
		} catch (Exception e) {
			// TODO: handle exception

		//	db.execSQL("drop table "+TABLE_NAME);
		}

		// TODO Auto-generated method stub

	}

	public void insertData(Content content) {
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COL_NAME, content.Name);
		values.put(COL_AUTHOR, content.Author);
		values.put(COL_Details, content.Details);
		database.insert(TABLE_NAME, null, values);
	}

	
	public List<Content> getAllContent() {
		
		String queryToGetAll = "SELECT * FROM " + TABLE_NAME;
		List<Content> contents = new ArrayList<Content>();
		SQLiteDatabase database = this.getReadableDatabase();
		Cursor cursor = database.rawQuery(queryToGetAll, null);
		if (cursor.moveToFirst()) {
			do {

				Content content = new Content();
				content.id = cursor.getInt(cursor.getColumnIndex(COL_ID));
				content.Name = cursor
						.getString(cursor.getColumnIndex(COL_NAME));
				content.Author = cursor.getString(cursor
						.getColumnIndex(COL_AUTHOR));
				content.Details = cursor.getString(cursor
						.getColumnIndex(COL_Details));

				contents.add(content);

			} while (cursor.moveToNext());
		}

		return contents;
	}

	public Content getContent(int id) {
	   String queryToGetById = "SELECT * FROM " + TABLE_NAME
				+ " WHERE " + COL_ID + " = " + id;
		
		SQLiteDatabase database = this.getReadableDatabase();
		Cursor cursor = database.rawQuery(queryToGetById, null);
		Content content = new Content();

		if (cursor.moveToFirst()) {
			content.id = cursor.getInt(cursor.getColumnIndex(COL_ID));
			content.Name = cursor.getString(cursor.getColumnIndex(COL_NAME));
			content.Author = cursor
					.getString(cursor.getColumnIndex(COL_AUTHOR));
			content.Details = cursor.getString(cursor
					.getColumnIndex(COL_Details));
		}
		return content;
	}
	
	public void dropTable()
	{
		SQLiteDatabase database = this.getWritableDatabase();
		database.execSQL("DROP TABLE "+ TABLE_NAME);
	}
	
	public List<Content> getAllContent(String name) {

		String queryToGetAll = "SELECT * FROM " + TABLE_NAME+" WHERE "+COL_NAME+"='"+name+"'";
		List<Content> contents = new ArrayList<Content>();
		SQLiteDatabase database = this.getReadableDatabase();
		Cursor cursor = database.rawQuery(queryToGetAll, null);
		if (cursor.moveToFirst()) {
			do {

				Content content = new Content();
				content.id = cursor.getInt(cursor.getColumnIndex(COL_ID));
				content.Name = cursor
						.getString(cursor.getColumnIndex(COL_NAME));
				content.Author = cursor.getString(cursor
						.getColumnIndex(COL_AUTHOR));
				content.Details = cursor.getString(cursor
						.getColumnIndex(COL_Details));

				contents.add(content);

			} while (cursor.moveToNext());
		}

		return contents;
	}
	
	public Content getContent(String contentName) {
		   String queryToGetById = "SELECT * FROM " + TABLE_NAME
					+ " WHERE " + COL_NAME + " = '" + contentName+"'";
			
			SQLiteDatabase database = this.getReadableDatabase();
			Cursor cursor = database.rawQuery(queryToGetById, null);
			Content content = new Content();

			if (cursor.moveToFirst()) {
				content.id = cursor.getInt(cursor.getColumnIndex(COL_ID));
				content.Name = cursor.getString(cursor.getColumnIndex(COL_NAME));
				content.Author = cursor
						.getString(cursor.getColumnIndex(COL_AUTHOR));
				content.Details = cursor.getString(cursor
						.getColumnIndex(COL_Details));
			}
			return content;
		}

}
